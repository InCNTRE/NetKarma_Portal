package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlString;
import org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetail;
import org.dataandsearch.www.karma.query._2010._10.AbstractServiceDetailListType;
import org.dataandsearch.www.karma.query._2010._10.AnnotationListType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseType;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.ServiceDetail;
import org.dataandsearch.www.karma.query._2010._10.ServiceDetailListType;
import org.dataandsearch.www.karma.query._2010._10.ServiceIDListType;
import org.dataandsearch.www.karma.query._2010._10.UniqueIDListType;

import edu.indiana.dsi.karma.ingest.NotificationSummary.StatusEnum;
import edu.indiana.dsi.karma.query.common.Common;

public class QueryServiceUtil {
	public static final Log l = LogFactory.getLog(QueryServiceUtil.class);

	private static final String FIND_SERVICE = "SELECT distinct(e.entity_uri) FROM exe_entity e, exe_invocation i WHERE "
			+ "e.entity_type = 'SERVICE' " + "AND e.entity_id = i.invokee_id ";

	private static String FIND_SERVICE_ANNOTATION = "SELECT distinct(e.entity_uri) FROM exe_entity e, exe_invocation i, exe_entity_annotation a WHERE "
			+ "e.entity_type = 'SERVICE' "
			+ "AND e.entity_id = a.entity_id "
			+ "AND e.entity_id = i.invokee_id ";

	private static final String ANNOTATION_COMPARISON = "OR a.annotation_value LIKE ? ";
	private static final String GET_SERVICE_BY_URI = "SELECT * FROM exe_entity WHERE entity_uri = ? ";
	private static final String GET_SERVICE_BY_ID = "SELECT * FROM exe_entity WHERE entity_id = ? ";

	private static final String GET_SERVICE_DETAIL_BY_URI = "SELECT * FROM exe_entity e, exe_invocation i WHERE e.entity_uri = ? ";
	private static final String GET_SERVICE_DETAIL_BY_ID = "SELECT * FROM exe_entity e WHERE e.entity_id = ? ";
	private static final String GET_EXECUTION_DETAIL_BY_ID = "SELECT * FROM exe_invocation where invokee_id = ? ";

	private static final String GET_ABSTRACT_SERVICE_BY_ID = "SELECT * FROM reg_entity WHERE entity_id = ? AND entity_type = 'SERVICE'";
	private static final String FIND_ALL_ABSTRACT_SERVICE = "SELECT * FROM reg_entity WHERE entity_type = 'SERVICE'";
	private static final String FIND_ABSTRACT_SERVICE = "SELECT * FROM reg_entity re, exe_entity e WHERE "
			+ "re.entity_type = 'SERVICE' "
			+ "AND re.entity_id = e.instance_of ";

	private static String FIND_ABSTRACT_SERVICE_ANNOTATION = "SELECT * FROM reg_entity re, exe_entity e, reg_entity_annotation a WHERE "
			+ "re.entity_type = 'SERVICE' "
			+ "AND re.entity_id = e.instance_of ";

	public FindServiceResponseDocument findService(Connection connection,
			FindServiceRequestType findServiceRequestType)
			throws QueryException, SQLException {

		l.info("Entering QueryServiceUtil.findService().");

		assert (connection != null);
		assert (findServiceRequestType != null);

		PreparedStatement findServiceStmt = null;
		ResultSet res = null;

		FindServiceResponseDocument findServiceResponseDocument = FindServiceResponseDocument.Factory
				.newInstance();
		FindServiceResponseType findServiceResponseType = findServiceResponseDocument
				.addNewFindServiceResponse();
		ServiceIDListType serviceNameList = findServiceResponseType
				.addNewServiceIDList();

		try {
			AnnotationListType annotationList = findServiceRequestType
					.getAnnotationList();

			StringBuilder query = new StringBuilder();
			if (annotationList != null) {
				query.append(FIND_SERVICE_ANNOTATION);
			} else {
				query.append(FIND_SERVICE);
			}

			String nextService = findServiceRequestType.getNextServiceID();
			String nextServiceID = null;
			if (nextService != null) {
				PreparedStatement findNextServiceStmt;
				if (nextService.startsWith(Common.PROCESS_IDENTIFIER)) {

					nextService = nextService.replace(
							Common.PROCESS_IDENTIFIER, "");
					findNextServiceStmt = connection
							.prepareStatement(GET_SERVICE_BY_ID);
				} else {
					findNextServiceStmt = connection
							.prepareStatement(GET_SERVICE_BY_URI);
				}
				findNextServiceStmt.setString(1, nextService);
				ResultSet nextServiceRes = findNextServiceStmt.executeQuery();

				int nextServiceCount = 0;
				if (nextServiceRes.next()) {
					nextServiceID = nextServiceRes.getString(1);
					query.append("AND i.invokee_id LIKE " + nextServiceID + " ");
					nextServiceCount++;
				}

				nextServiceRes.close();
				findNextServiceStmt.close();

				if (nextServiceCount == 0) {
					l.info("No service with specified next service found.");
					l.info("Exiting QueryServiceUtil.findService() with success.");
					return findServiceResponseDocument;
				}
			}

			String architecture = findServiceRequestType.getArchitecture();
			String hostName = findServiceRequestType.getHostName();
			String name = findServiceRequestType.getName();
			String workflowID = findServiceRequestType.getWorkflowID();
			String subServiceID = findServiceRequestType.getSubServiceID();
			Calendar initializationTime = findServiceRequestType
					.getInitializationTime();
			Calendar terminationTime = findServiceRequestType
					.getTerminationTime();
			boolean isSuccess = findServiceRequestType.getIsSuccess();
			if (architecture != null)
				query.append("AND e.entity_uri LIKE '%" + architecture + "%' ");
			if (hostName != null)
				query.append("AND e.entity_uri LIKE '%" + hostName + "%' ");
			if (name != null)
				query.append("AND e.entity_uri LIKE '%" + name + "%' ");
			if (workflowID != null)
				query.append("AND e.context_workflow_uri LIKE '%" + workflowID
						+ "%' ");
			if (subServiceID != null)
				query.append("AND e.context_service_uri LIKE '%" + subServiceID
						+ "%' ");
			if (initializationTime != null)
				query.append("AND i.invocation_start_time LIKE '%"
						+ initializationTime + "%' ");
			if (terminationTime != null)
				query.append("AND i.execution_end_time LIKE '%"
						+ terminationTime + "%' ");
			if (isSuccess)
				query.append("AND i.execution_status = '"
						+ StatusEnum.SUCCESS.toString() + "' ");
			else
				query.append("AND i.execution_status = '"
						+ StatusEnum.FAILED.toString() + "' ");
			if (annotationList != null) {
				for (int i = 0; i < findServiceRequestType.getAnnotationList()
						.sizeOfAnnotationArray(); i++) {
					query.append(ANNOTATION_COMPARISON);
				}
			}

			findServiceStmt = connection.prepareStatement(query.toString());

			if (annotationList != null) {
				for (int i = 1; i <= findServiceRequestType.getAnnotationList()
						.sizeOfAnnotationArray(); i++) {
					findServiceStmt.setString(i, '%' + findServiceRequestType
							.getAnnotationList().getAnnotationArray(i)
							.getValue().toString() + '%');
				}
			}

			l.info("findServiceStmt: " + findServiceStmt);
			res = findServiceStmt.executeQuery();

			while (res.next()) {
				XmlString serviceName = serviceNameList.addNewServiceID();
				serviceName.setStringValue(res.getString("entity_uri"));
			}

			res.close();
			findServiceStmt.close();

		} catch (SQLException e) {
			l.error("Exiting findService() with SQL errors.");
			l.error(e.toString());

			return null;
		} finally {
			if (findServiceStmt != null) {
				findServiceStmt.close();
				findServiceStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}

		l.info("Response: " + findServiceResponseDocument);
		l.info("Exiting QueryServiceUtil.findService() with success.");
		return findServiceResponseDocument;
	}

	public GetServiceDetailResponseDocument getServiceDetail(
			Connection connection,
			GetServiceDetailRequestType serviceDetailRequestType)
			throws QueryException, SQLException {

		l.info("Entering QueryServiceUtil.getServiceDetail().");

		assert (connection != null);
		assert (serviceDetailRequestType != null);

		PreparedStatement serviceDetailStmt = null;
		PreparedStatement serviceExecutionDetailStmt = null;
		ResultSet res = null;
		ResultSet resExecutionDetail = null;

		GetServiceDetailResponseDocument getServiceDetailResponseDocument = GetServiceDetailResponseDocument.Factory
				.newInstance();
		GetServiceDetailResponseType getServiceDetailResponseType = getServiceDetailResponseDocument
				.addNewGetServiceDetailResponse();
		ServiceDetailListType serviceDetailList = getServiceDetailResponseType
				.addNewServiceDetailList();

		if (serviceDetailRequestType.getUniqueURIList() != null) {

			for (String uri : serviceDetailRequestType.getUniqueURIList()
					.getUniqueURIArray()) {

				l.info("Processing uri: " + uri);

				try {
					serviceDetailStmt = connection
							.prepareStatement(GET_SERVICE_DETAIL_BY_URI);
					serviceDetailStmt.setString(1, uri);

					res = serviceDetailStmt.executeQuery();

					if (res.next()) {

						String entity_type = res.getString("entity_type");
						String entity_subtype = res.getString("entity_subtype");
						String context_workflow_uri = res
								.getString("context_workflow_uri");
						String context_service_uri = res
								.getString("context_service_uri");
						int timestep = res.getInt("timestep");
						String context_wf_node_id_token = res
								.getString("context_wf_node_id_token");
						String instance_of = res.getString("instance_of");

						ServiceDetail serviceDetail = serviceDetailList
								.addNewServiceDetail();
						serviceDetail.setId(uri);

						if (entity_type != null)
							serviceDetail.setType(entity_type);
						if (entity_subtype != null)
							serviceDetail.setSubtype(entity_subtype);
						if (context_workflow_uri != null)
							serviceDetail.setWorkflowID(context_workflow_uri);
						if (context_service_uri != null)
							serviceDetail.setServiceID(context_service_uri);
						if (timestep != -1)
							serviceDetail.setTimestep(timestep);
						if (context_wf_node_id_token != null)
							serviceDetail
									.setWorkflowNodeID(context_wf_node_id_token);
						if (instance_of != null)
							serviceDetail.setInstanceOf(instance_of);

						serviceExecutionDetailStmt = connection
								.prepareStatement(GET_EXECUTION_DETAIL_BY_ID);
						serviceExecutionDetailStmt.setString(1,
								res.getString("entity_id"));
						resExecutionDetail = serviceExecutionDetailStmt
								.executeQuery();

						if (resExecutionDetail.next()) {
							Timestamp invocation_start_time = resExecutionDetail
									.getTimestamp("invocation_start_time");
							Timestamp execution_end_time = resExecutionDetail
									.getTimestamp("execution_end_time");
							String execution_status = resExecutionDetail
									.getString("execution_status");

							if (invocation_start_time != null)
								serviceDetail
										.setInvocationStartTime(Common
												.getCalendarFromTimeStamp(invocation_start_time));

							if (execution_end_time != null)
								serviceDetail
										.setExecutionEndTime(Common
												.getCalendarFromTimeStamp(execution_end_time));

							if (execution_status != null)
								serviceDetail
										.setExecutionStatus(execution_status);

						}
					}

				} catch (SQLException e) {
					l.error("Exiting QueryServiceUtil.getServiceDetail() with SQL errors.");
					l.error(e.toString());

					return null;
				} finally {
					if (serviceDetailStmt != null) {
						serviceDetailStmt.close();
						serviceDetailStmt = null;
					}

					if (serviceExecutionDetailStmt != null) {
						serviceExecutionDetailStmt.close();
						serviceExecutionDetailStmt = null;
					}

					if (res != null) {
						res.close();
						res = null;
					}

					if (resExecutionDetail != null) {
						resExecutionDetail.close();
						resExecutionDetail = null;
					}
				}
			}
		} else {

			for (String id : serviceDetailRequestType.getUniqueIDList()
					.getUniqueIDArray()) {

				l.info("Processing id: " + id);

				try {
					serviceDetailStmt = connection
							.prepareStatement(GET_SERVICE_DETAIL_BY_ID);
					serviceDetailStmt.setString(1,
							id.replace(Common.PROCESS_IDENTIFIER, ""));

					res = serviceDetailStmt.executeQuery();

					if (res.next()) {

						String entity_type = res.getString("entity_type");
						String entity_subtype = res.getString("entity_subtype");
						String context_workflow_uri = res
								.getString("context_workflow_uri");
						String context_service_uri = res
								.getString("context_service_uri");
						int timestep = res.getInt("timestep");
						String context_wf_node_id_token = res
								.getString("context_wf_node_id_token");
						String instance_of = res.getString("instance_of");

						ServiceDetail serviceDetail = serviceDetailList
								.addNewServiceDetail();
						serviceDetail.setId(id);

						if (entity_type != null)
							serviceDetail.setType(entity_type);
						if (entity_subtype != null)
							serviceDetail.setSubtype(entity_subtype);
						if (context_workflow_uri != null)
							serviceDetail.setWorkflowID(context_workflow_uri);
						if (context_service_uri != null)
							serviceDetail.setServiceID(context_service_uri);
						if (timestep != -1)
							serviceDetail.setTimestep(timestep);
						if (context_wf_node_id_token != null)
							serviceDetail
									.setWorkflowNodeID(context_wf_node_id_token);
						if (instance_of != null)
							serviceDetail.setInstanceOf(instance_of);

						serviceExecutionDetailStmt = connection
								.prepareStatement(GET_EXECUTION_DETAIL_BY_ID);
						serviceExecutionDetailStmt.setString(1, id);
						resExecutionDetail = serviceExecutionDetailStmt
								.executeQuery();

						if (resExecutionDetail.next()) {
							Timestamp invocation_start_time = resExecutionDetail
									.getTimestamp("invocation_start_time");
							Timestamp execution_end_time = resExecutionDetail
									.getTimestamp("execution_end_time");
							String execution_status = resExecutionDetail
									.getString("execution_status");

							if (invocation_start_time != null)								
								serviceDetail
										.setInvocationStartTime(Common.getCalendarFromTimeStamp(invocation_start_time));						

							if (execution_end_time != null)
								serviceDetail
										.setExecutionEndTime(Common.getCalendarFromTimeStamp(execution_end_time));						

							if (execution_status != null)
								serviceDetail
										.setExecutionStatus(execution_status);

						}
					}

				} catch (SQLException e) {
					l.error("Exiting QueryServiceUtil.getServiceDetail() with SQL errors.");
					l.error(e.toString());

					return null;
				} finally {
					if (serviceDetailStmt != null) {
						serviceDetailStmt.close();
						serviceDetailStmt = null;
					}

					if (serviceExecutionDetailStmt != null) {
						serviceExecutionDetailStmt.close();
						serviceExecutionDetailStmt = null;
					}

					if (res != null) {
						res.close();
						res = null;
					}

					if (resExecutionDetail != null) {
						resExecutionDetail.close();
						resExecutionDetail = null;
					}
				}
			}
		}

		l.info("Response: " + getServiceDetailResponseDocument);
		l.info("Exiting QueryServiceUtil.getServiceDetail() with success.");
		return getServiceDetailResponseDocument;
	}

	public FindAbstractServiceResponseDocument findAbstractService(
			Connection connection,
			FindAbstractServiceRequestType findAbstractServiceRequestType)
			throws QueryException, SQLException {
		l.info("Entering QueryServiceUtil.findAbstractService().");

		assert (connection != null);
		assert (findAbstractServiceRequestType != null);

		PreparedStatement findAbstractServiceStmt = null;
		ResultSet res = null;

		FindAbstractServiceResponseDocument findAbstractServiceResponseDocument = FindAbstractServiceResponseDocument.Factory
				.newInstance();
		FindAbstractServiceResponseType findAbstractServiceResponseType = findAbstractServiceResponseDocument
				.addNewFindAbstractServiceResponse();
		UniqueIDListType uniqueIDList = findAbstractServiceResponseType
				.addNewUniqueIDList();
		ServiceIDListType serviceNameList = findAbstractServiceResponseType
				.addNewServiceNameList();

		try {

			if (findAbstractServiceRequestType.getReturnAll()) {
				findAbstractServiceStmt = connection
						.prepareStatement(FIND_ALL_ABSTRACT_SERVICE);
				l.info("findAbstractServiceStmt: " + findAbstractServiceStmt);
				res = findAbstractServiceStmt.executeQuery();

				while (res.next()) {
					String name = res.getString("name");
					String id = res.getString("entity_id");
					if (name != null)
						serviceNameList.addServiceID(name);

					uniqueIDList
							.addUniqueID(Common.REG_PROCESS_IDENTIFIER + id);
				}

				res.close();
				findAbstractServiceStmt.close();

			} else {
				AnnotationListType annotationList = findAbstractServiceRequestType
						.getAnnotationList();

				StringBuilder query = new StringBuilder();

				if (annotationList != null) {
					query.append(FIND_ABSTRACT_SERVICE_ANNOTATION);
				} else {
					query.append(FIND_ABSTRACT_SERVICE);
				}

				String serviceName = findAbstractServiceRequestType
						.getServiceName();
				String workflowID = findAbstractServiceRequestType
						.getWorkflowID();
				String subServiceName = findAbstractServiceRequestType
						.getSubServiceName();
				String version = findAbstractServiceRequestType.getVersion();

				if (serviceName != null)
					query.append("AND re.name LIKE '%" + serviceName + "%' ");
				if (workflowID != null)
					query.append("AND e.context_workflow_uri LIKE '%"
							+ workflowID + "%' ");
				if (subServiceName != null)
					query.append("AND e.context_service_uri LIKE '%"
							+ workflowID + "%' ");
				if (version != null)
					query.append("AND re.version LIKE '%" + version + "%' ");
				if (annotationList != null) {
					for (int i = 0; i < annotationList.sizeOfAnnotationArray(); i++) {
						query.append(ANNOTATION_COMPARISON);
					}
				}

				findAbstractServiceStmt = connection.prepareStatement(query
						.toString());

				if (annotationList != null) {
					for (int i = 1; i <= findAbstractServiceRequestType
							.getAnnotationList().sizeOfAnnotationArray(); i++) {
						findAbstractServiceStmt.setString(i,
								'%' + findAbstractServiceRequestType
										.getAnnotationList()
										.getAnnotationArray(i).getValue()
										.toString() + '%');
					}
				}

				l.info("findAbstractServiceStmt: " + findAbstractServiceStmt);
				res = findAbstractServiceStmt.executeQuery();

				while (res.next()) {
					String name = res.getString("name");
					String id = res.getString("entity_id");
					if (name != null)
						serviceNameList.addServiceID(name);

					uniqueIDList
							.addUniqueID(Common.REG_PROCESS_IDENTIFIER + id);

				}

				res.close();
				findAbstractServiceStmt.close();
			}
		} catch (SQLException e) {
			l.error("Exiting findAbstractService() with SQL errors.");
			l.error(e.toString());

			return null;
		} finally {
			if (findAbstractServiceStmt != null) {
				findAbstractServiceStmt.close();
				findAbstractServiceStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}

		l.info("Response: " + findAbstractServiceResponseDocument);
		l.info("Exiting QueryServiceUtil.findAbstractService() with success.");
		return findAbstractServiceResponseDocument;
	}

	public GetAbstractServiceDetailResponseDocument getAbstractServiceDetail(
			Connection connection,
			GetAbstractServiceDetailRequestType abstractServiceDetailRequestType)
			throws QueryException, SQLException {

		l.info("Entering QueryServiceUtil.getAbstractServiceDetail().");

		assert (connection != null);
		assert (abstractServiceDetailRequestType != null);

		PreparedStatement abstractServiceDetailStmt = null;
		ResultSet res = null;

		GetAbstractServiceDetailResponseDocument getAbstractServiceDetailResponseDocument = GetAbstractServiceDetailResponseDocument.Factory
				.newInstance();
		GetAbstractServiceDetailResponseType getAbstractServiceDetailResponseType = getAbstractServiceDetailResponseDocument
				.addNewGetAbstractServiceDetailResponse();
		AbstractServiceDetailListType abstractServiceDetailListType = getAbstractServiceDetailResponseType
				.addNewAbstractServiceDetailListType();

		for (String id : abstractServiceDetailRequestType.getUniqueIDList()
				.getUniqueIDArray()) {

			l.info("Processing id: " + id);

			try {
				abstractServiceDetailStmt = connection
						.prepareStatement(GET_ABSTRACT_SERVICE_BY_ID);
				abstractServiceDetailStmt.setString(1,
						id.replace(Common.REG_PROCESS_IDENTIFIER, ""));

				res = abstractServiceDetailStmt.executeQuery();

				if (res.next()) {

					String entity_type = res.getString("entity_type");
					String entity_subtype = res.getString("entity_subtype");
					String name = res.getString("name");
					String version = res.getString("version");
					String creation_time = res.getString("creation_time");

					AbstractServiceDetail abstractServiceDetail = abstractServiceDetailListType
							.addNewAbstractServiceDetail();

					abstractServiceDetail.setId(id);

					if (entity_type != null)
						abstractServiceDetail.setType(entity_type);
					if (entity_subtype != null)
						abstractServiceDetail.setSubtype(entity_subtype);
					if (name != null)
						abstractServiceDetail.setName(name);
					if (version != null)
						abstractServiceDetail.setVersion(version);
					if (creation_time != null)
						abstractServiceDetail.setCreationTime(creation_time);

				}
			} catch (SQLException e) {
				l.error("Exiting QueryServiceUtil.getAbstractServiceDetail() with SQL errors.");
				l.error(e.toString());

				return null;

			} finally {
				if (abstractServiceDetailStmt != null) {
					abstractServiceDetailStmt.close();
					abstractServiceDetailStmt = null;
				}

				if (res != null) {
					res.close();
					res = null;
				}
			}
		}

		l.info("Response: " + getAbstractServiceDetailResponseDocument);
		l.info("Exiting QueryServiceUtil.getAbstractServiceDetail() with success.");
		return getAbstractServiceDetailResponseDocument;
	}
}