package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dataandsearch.www.karma.query._2010._10.ClientDetail;
import org.dataandsearch.www.karma.query._2010._10.ClientDetailListType;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.UniqueIDListType;

public class QueryClientUtil {
	public static final Log l = LogFactory.getLog(QueryClientUtil.class);
	private static final String GET_USER_CONTROLLER_ID = "SELECT * from reg_personnel WHERE dn = ?";

	public GetClientDetailResponseDocument getClientDetail(
			Connection connection, UniqueIDListType clientIDListType)
			throws QueryException, SQLException {

		l.info("Entering QueryClientUtil.getClientDetail().");
		assert (connection != null);
		assert (clientIDListType != null);

		PreparedStatement clientDetailStmt = null;
		ResultSet res = null;

		GetClientDetailResponseDocument getClientDetailResponseDocument = GetClientDetailResponseDocument.Factory
				.newInstance();

		GetClientDetailResponseType getClientDetailResponseType = getClientDetailResponseDocument
				.addNewGetClientDetailResponse();
		ClientDetailListType clientDetailList = getClientDetailResponseType
				.addNewClientDetailList();

		for (String clientID : clientIDListType.getUniqueIDArray()) {
			try {
				clientDetailStmt = connection
						.prepareStatement(GET_USER_CONTROLLER_ID);
				clientDetailStmt.setString(1, clientID);

				l.debug("clientDetailStmt: " + clientDetailStmt);
				res = clientDetailStmt.executeQuery();

				ClientDetail clientDetail = clientDetailList
						.addNewClientDetail();

				if (res.next()) {
					String name = res.getString("name");
					String affiliation = res.getString("affiliation");
					String email = res.getString("email");

					clientDetail.setDn(clientID);

					if (name != null)
						clientDetail.setName(name);
					if (affiliation != null)
						clientDetail.setAffiliation(affiliation);
					if (email != null)
						clientDetail.setEmail(email);
				} else {
					res.close();
					clientDetailStmt.close();
				}

			} catch (SQLException e) {
				l.error("Exiting getClientDetail() with SQL errors.");
				l.error(e.toString());

				return null;
			} finally {
				if (clientDetailStmt != null) {
					clientDetailStmt.close();
					clientDetailStmt = null;
				}

				if (res != null) {
					res.close();
					res = null;
				}

			}
		}

		l.info("Response: " + getClientDetailResponseDocument);
		l.info("Exiting QueryServiceUtil.getClientDetail() with success.");
		return getClientDetailResponseDocument;
	}
}