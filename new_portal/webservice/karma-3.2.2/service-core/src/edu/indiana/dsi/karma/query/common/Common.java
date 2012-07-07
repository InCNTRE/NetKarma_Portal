package edu.indiana.dsi.karma.query.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.indiana.dsi.karma.query.OPMSqlQuery;

public class Common {

	public static final Log l = LogFactory.getLog(Common.class);

	public static final String FILE_IDENTIFIER = "File_";
	public static final String BLOCK_IDENTIFIER = "Block_";
	public static final String PROCESS_IDENTIFIER = "Process_";
	public static final String AGENT_IDENTIFIER = "Agent_";
	public static final String COLLECTION_IDENTIFIER = "Collection_";
	public static final String REG_PROCESS_IDENTIFIER = "Registry_process_";
	public static final String REG_DATA_OBJECT_IDENTIFIER = "Registry_data_object_";
	public static final String PROCESS_ANNOTATION_IDENTIFIER = "Process-Annotation_";
	public static final String ARTIFACT_ANNOTATION_IDENTIFIER = "Artifact-Annotation_";
	public static final String INVOCATION_ANNOTATION_IDENTIFIER = "Invocation-Annotation_";
	public static final String DATA_LIFECYCLE_ANNOTATION_IDENTIFIER = "Data-Lifecycle-Annotation_";
	public static final String NULL_TIME = "0000-00-00 00:00:00";
	public static final String NULL = "NULL";

	/*
	 * This function returns the type and id of a data object in a string of the
	 * form <TYPE>_<ID>
	 * 
	 * @param - connection : mysql db connection object - dataObjectId
	 * 
	 * @return - file_id, collection_id or block_id (ArtifactId)
	 */
	public static String getArtifactId(Connection connection, int dataObjectId)
			throws SQLException {
		assert (connection != null);
		assert (dataObjectId > 0);
		l.info("Entering getArtifactId()");

		PreparedStatement getDataObjectStmt = null;
		ResultSet res = null;
		try {
			String artifactId = null;

			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OBJECT_TYPE_BY_ID);
			getDataObjectStmt.setInt(1, dataObjectId);

			res = getDataObjectStmt.executeQuery();
			if (res.next()) {
				String type = res.getString(1).toLowerCase();
				StringBuilder newType = new StringBuilder(type.length());
				newType.append(Character.toUpperCase(type.charAt(0)));
				for (int i = 1; i < type.length(); i++) {
					newType.append(type.charAt(i));
				}

				artifactId = newType + "_" + dataObjectId;
			}

			res.close();
			getDataObjectStmt.close();

			if (artifactId == null) {
				l.error("Artifact was not found , some problem with the id");
				l.info("Exiting getArtifactId() with success");
			} else {
				l.info("Found ID.");
				l.info("Exiting getArtifactId() with success");
			}

			return artifactId;
		} catch (SQLException e) {
			l.error("Exiting getArtifactId() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (getDataObjectStmt != null) {
				getDataObjectStmt.close();
				getDataObjectStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function gives the Timestamp (Calendar) at which the artifact was
	 * used (consumed)
	 * 
	 * @param - connection : mysql database connection - artifactId : artifactId
	 * (data_object_id or file_id) whose Timestamp we want to find
	 * 
	 * @return - Calendar : calendar object which represents the timestamp at
	 * which the artifact was used
	 */
	public static Calendar getArtifactUsedTime(Connection connection,
			int artifactId) throws SQLException {
		assert (connection != null);
		assert (artifactId > 0);
		l.info("Entering getArtifactUsedTime() " + artifactId);

		PreparedStatement artifacatUsedStmt = null;
		ResultSet res = null;

		try {
			artifacatUsedStmt = connection
					.prepareStatement(OPMSqlQuery.GET_ARTIFACT_USED_TIME);
			artifacatUsedStmt.setInt(1, artifactId);
			res = artifacatUsedStmt.executeQuery();

			/*
			 * There should be only one result but since we are using the
			 * aggregate querry we have to do a explicit null check
			 */
			if (res.first()) {
				java.sql.Timestamp time = res.getTimestamp(1);
				if (time == null) {
					res.close();
					artifacatUsedStmt.close();
					return null;
				}
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(time.getTime());
				res.close();
				artifacatUsedStmt.close();
				return c;
			} else {
				res.close();
				artifacatUsedStmt.close();
				l.error("Nothing was returned");
				l.error("Exiting getArtifactUsedTime() with error");
				return null;
			}

		} catch (SQLException e) {
			l.error("Exiting getArtifactUsedTime() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (artifacatUsedStmt != null) {
				artifacatUsedStmt.close();
				artifacatUsedStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function gives the Timestamp (Calendar) at which the artifact was
	 * produced (generated)
	 * 
	 * @param - connection : mysql database connection - artifactId : artifactId
	 * (data_object_id or file_id) whose Timestamp we want to find
	 * 
	 * @return - Calendar : calendar object which represents the timestamp at
	 * which the artifact was generated
	 */
	public static Calendar getArtifactGeneratedTime(Connection connection,
			int artifactId) throws SQLException {
		assert (connection != null);
		assert (artifactId > 0);
		l.info("Entering getArtifactGeneratedTime()");

		PreparedStatement artifactProducedStmt = null;
		ResultSet res = null;
		try {
			artifactProducedStmt = connection
					.prepareStatement(OPMSqlQuery.GET_ARTIFACT_PRODUCED_TIME);
			artifactProducedStmt.setInt(1, artifactId);
			res = artifactProducedStmt.executeQuery();

			/*
			 * There should be only one result but since we are using the
			 * aggregate query we have to do a explicit null check
			 */
			if (res.first()) {
				java.sql.Timestamp time = res.getTimestamp(1);
				if (time == null) {
					res.close();
					artifactProducedStmt.close();
					return null;
				}
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(time.getTime());
				res.close();
				artifactProducedStmt.close();
				l.info("Exiting getArtifactGeneratedTime() with success");
				return c;
			} else {
				res.close();
				artifactProducedStmt.close();
				l.error("Nothing was returned");
				l.error("Exiting getArtifactGeneratedTime() with error");
				return null;
			}
		} catch (SQLException e) {
			l.error("Exiting getArtifactGeneratedTime() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (artifactProducedStmt != null) {
				artifactProducedStmt.close();
				artifactProducedStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function converts a Timestamp object to a Calendar object.
	 * 
	 * @param - Timestamp t
	 * 
	 * @return - Calendar : calendar object which represents the input
	 * timestamp.
	 */
	public static Calendar getCalendarFromTimeStamp(Timestamp t) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(t.getTime());
		return c;
	}
}
