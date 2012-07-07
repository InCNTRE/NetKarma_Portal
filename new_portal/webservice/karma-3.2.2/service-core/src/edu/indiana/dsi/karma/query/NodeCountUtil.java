package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NodeCountUtil {
	public final int ERROR_COUNT = -1;
	public static final Log l = LogFactory.getLog(NodeCountUtil.class);

	private int getArtifactCountOfGraph(Connection connection,
			String contextWorkflowURI) throws QueryException, SQLException {
		l.info("Entering getArtifactCountOfGraph()");

		assert (connection != null);
		assert (contextWorkflowURI != null);

		int artifactCount = 0;
		PreparedStatement getCountFromGraph = null;
		ResultSet res = null;

		try {
			getCountFromGraph = connection
					.prepareStatement(OPMSqlQuery.GET_COUNT_ARTIFACTS_USED);

			getCountFromGraph.setString(1, contextWorkflowURI);
			res = getCountFromGraph.executeQuery();

			if (res.next()) {
				artifactCount = res.getInt(1);
				res.close();
				getCountFromGraph.close();
				l.info("Obtained artifact count in getArtifactCountOfGraph() with success");
				return artifactCount;
			} else {
				res.close();
				getCountFromGraph.close();
				l.error("Nothing was returned.");
				l.error("Exiting getArtifactCountOfGraph() with error count.");

				return ERROR_COUNT;
			}
		} catch (SQLException e) {
			l.error("Exiting getArtifactCountOfGraph() with errors.");
			l.error(e.toString());
			return ERROR_COUNT;
		} finally {
			if (getCountFromGraph != null) {
				getCountFromGraph.close();
				getCountFromGraph = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	private int getProcessCountOfGraph(Connection connection,
			String contextWorkflowURI) throws QueryException, SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getProcessCountOfGraph()");

		int processCount = 0;
		PreparedStatement getCountFromGraph = null;
		ResultSet res = null;

		try {
			getCountFromGraph = connection
					.prepareStatement(OPMSqlQuery.GET_COUNT_ENTITIES_BY_CONTEXT_WORKFLOW_URI);

			getCountFromGraph.setString(1, contextWorkflowURI);
			res = getCountFromGraph.executeQuery();

			if (res.next()) {
				processCount = res.getInt(1);
				res.close();
				getCountFromGraph.close();
				l.info("Obtained process count in getProcessCountOfGraph() with success");
				return processCount;
			} else {
				res.close();
				getCountFromGraph.close();
				l.error("Nothing was returned.");
				l.error("Exiting getProcessCountOfGraph() with error count.");

				return ERROR_COUNT;
			}
		} catch (SQLException e) {
			l.error("Exiting getProcessCountOfGraph() with errors.");
			l.error(e.toString());
			return ERROR_COUNT;
		} finally {
			if (getCountFromGraph != null) {
				getCountFromGraph.close();
				getCountFromGraph = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	public int getCountOfGraph(Connection connection, String contextWorkflowURI)
			throws QueryException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getCountOfGraph()");

		try {
			int artifactCount = getArtifactCountOfGraph(connection,
					contextWorkflowURI);
			int processCount = getProcessCountOfGraph(connection,
					contextWorkflowURI);

			return processCount + artifactCount;
		} catch (QueryException e) {
			l.error("Exiting getCountOfGraph() with query errors.");
			l.error(e.toString());
			return ERROR_COUNT;
		} catch (SQLException e) {
			l.error("Exiting getCountOfGraph() with SQL errors.");
			l.error(e.toString());
			return ERROR_COUNT;
		}
	}

}
