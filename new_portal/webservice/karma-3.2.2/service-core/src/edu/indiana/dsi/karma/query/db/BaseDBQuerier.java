package edu.indiana.dsi.karma.query.db;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.DetailEnumType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FormatEnumType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType;
import org.openprovenance.model.v1_1_a.OpmGraphDocument;
import org.w3.www._1999._02._22_rdf_syntax_ns.RdfType;

import edu.indiana.dsi.karma.ingest.db.DBConnectionPool;
import edu.indiana.dsi.karma.query.NodeCountUtil;
import edu.indiana.dsi.karma.query.QueryAnnotationUtil;
import edu.indiana.dsi.karma.query.QueryByWorkflowURIUtil;
import edu.indiana.dsi.karma.query.QueryClientUtil;
import edu.indiana.dsi.karma.query.QueryDataProductUtil;
import edu.indiana.dsi.karma.query.QueryDataProvenanceHistoryUtil;
import edu.indiana.dsi.karma.query.QueryException;
import edu.indiana.dsi.karma.query.QueryImplementer;
import edu.indiana.dsi.karma.query.QueryServiceUtil;

public class BaseDBQuerier implements QueryImplementer {

	public static final Log l = LogFactory.getLog(BaseDBQuerier.class);

	private QueryImplementer implementer = null;

	public BaseDBQuerier() {
		this.setImplementer(implementer);
	}

	@Override
	public GetProvenanceHistoryResponseDocument getProvenanceHistory(
			GetProvenanceHistoryRequestDocument getProvenanceHistoryRequest)
			throws QueryException {

		l.info("Entering getProvenanceHistoryGraph()");
		Connection connection = null;

		GetProvenanceHistoryRequestType getProvenanceHistoryRequestType = getProvenanceHistoryRequest
				.getGetProvenanceHistoryRequest();

		String dataObjectID = getProvenanceHistoryRequestType.getArtifactID();
		FormatEnumType.Enum format = getProvenanceHistoryRequestType
				.getFormat();
		DetailEnumType.Enum informationDetailLevel = getProvenanceHistoryRequestType
				.getInformationDetailLevel();
		long timeRange = getProvenanceHistoryRequestType.getTimeRange();

		GetProvenanceHistoryResponseDocument getProvenanceHistoryResponseDocument = GetProvenanceHistoryResponseDocument.Factory
				.newInstance();
		GetProvenanceHistoryResponseType getProvenanceHistoryResponse = getProvenanceHistoryResponseDocument
				.addNewGetProvenanceHistoryResponse();

		try {
			connection = DBConnectionPool.getInstance().getEntry();

			QueryDataProvenanceHistoryUtil queryByDataProductUtil = new QueryDataProvenanceHistoryUtil();
			OpmGraphDocument opmGraphDocumentByDataID = queryByDataProductUtil
					.getOPMGraphDocumentByDataID(connection, dataObjectID,
							timeRange, informationDetailLevel);

			l.info("Completed getProvenanceHistoryGraph()");
			getProvenanceHistoryResponse.setOpmGraph(opmGraphDocumentByDataID
					.getOpmGraph());

			l.debug("getProvenanceHistoryResponseDocument validation: "
					+ getProvenanceHistoryResponseDocument.validate());

		} catch (QueryException e) {
			l.error("Failed to query getProvenanceHistoryGraph()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getProvenanceHistoryResponseDocument;
	}

	@Override
	public GetWorkflowGraphResponseDocument getWorkflowGraph(
			GetWorkflowGraphRequestDocument getWorkflowGraphRequest)
			throws QueryException {

		l.info("Entering getWorkflowGraph()");
		GetWorkflowGraphRequestType getWorkflowGraphRequestType = getWorkflowGraphRequest
				.getGetWorkflowGraphRequest();
		String workflowID = getWorkflowGraphRequestType.getWorkflowID();
		FormatEnumType.Enum format = getWorkflowGraphRequestType.getFormat();
		DetailEnumType.Enum informationDetailLevel = getWorkflowGraphRequestType
				.getInformationDetailLevel();

		GetWorkflowGraphResponseDocument getWorkflowGraphResponseDocument = GetWorkflowGraphResponseDocument.Factory
				.newInstance();
		GetWorkflowGraphResponseType getWorkflowGraphResponseType = getWorkflowGraphResponseDocument
				.addNewGetWorkflowGraphResponse();

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();

			if (format.equals(FormatEnumType.OPM)) {
				QueryByWorkflowURIUtil queryByWorkflowURIUtil = new QueryByWorkflowURIUtil();
				OpmGraphDocument opmGraphDocument = queryByWorkflowURIUtil
						.getOPMGraphDocument(connection, workflowID,
								informationDetailLevel);
				getWorkflowGraphResponseType.setOpmGraph(opmGraphDocument
						.getOpmGraph());
			}

			if (format.equals(FormatEnumType.RDF)) {
				RdfType rdf = null;
				getWorkflowGraphResponseType.setRDF(rdf);
			}

			l.debug("getWorkflowGraphResponseDocument validation: "
					+ getWorkflowGraphResponseDocument.validate());

			l.info("Completed getWorkflowGraph()");
		} catch (Exception e) {
			l.error("Failed to query getWorkflowGraph()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getWorkflowGraphResponseDocument;
	}

	@Override
	public CompareWorkflowGraphsResponseDocument compareWorkflowGraphs(
			CompareWorkflowGraphsRequestDocument compareWorkflowGraphsRequest)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetNodeCountOfGraphResponseDocument getNodeCountOfGraph(
			GetNodeCountOfGraphRequestDocument getNodeCountOfGraphRequest)
			throws QueryException {

		l.info("Entering getNodeCountOfGraph()");
		Connection connection = null;

		GetNodeCountOfGraphRequestType getNodeCountOfGraphRequestType = getNodeCountOfGraphRequest
				.getGetNodeCountOfGraphRequest();
		String contextWorkflowURI = getNodeCountOfGraphRequestType
				.getWorkflowID();

		GetNodeCountOfGraphResponseDocument getNodeCountOfGraphResponseDocument = GetNodeCountOfGraphResponseDocument.Factory
				.newInstance();
		GetNodeCountOfGraphResponseType getNodeCountOfGraphResponseType = getNodeCountOfGraphResponseDocument
				.addNewGetNodeCountOfGraphResponse();

		try {
			connection = DBConnectionPool.getInstance().getEntry();

			NodeCountUtil nodeCountUtil = new NodeCountUtil();
			int countOfGraph = nodeCountUtil.getCountOfGraph(connection,
					contextWorkflowURI);
			getNodeCountOfGraphResponseType.setCount(countOfGraph);

			l.debug("getNodeCountOfGraphResponseDocument validation: "
					+ getNodeCountOfGraphResponseDocument.validate());

			l.info("Completed getNodeCountOfGraph()");

		} catch (Exception e) {
			l.error("Failed to query getNodeCountOfGraph()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getNodeCountOfGraphResponseDocument;
	}

	public void setImplementer(QueryImplementer implementer) {
		this.implementer = implementer;
	}

	public QueryImplementer getImplementer() {
		return implementer;
	}

	@Override
	public GetAnnotationDetailResponseDocument getAnnotationDetail(
			GetAnnotationDetailRequestDocument getAnnotationDetailRequest)
			throws QueryException {

		l.info("Entering getAnnotationDetail()");
		GetAnnotationDetailRequestType annotationDetailRequestType = getAnnotationDetailRequest
				.getGetAnnotationDetailRequest();

		GetAnnotationDetailResponseDocument annotationDetailResponseType = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryAnnotationUtil queryAnnotationUtil = new QueryAnnotationUtil();
			annotationDetailResponseType = queryAnnotationUtil
					.getAnnotationDetail(connection,
							annotationDetailRequestType
									.getAnnotationPairedIDList());

			l.debug("annotationDetailResponseType validation: "
					+ annotationDetailResponseType.validate());

			l.info("Completed getAnnotationDetail()");
		} catch (Exception e) {
			l.error("Failed to query getAnnotationDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return annotationDetailResponseType;
	}

	@Override
	public FindAbstractDataProductResponseDocument findAbstractDataProduct(
			FindAbstractDataProductRequestDocument findAbstractDataProductRequest)
			throws QueryException {
		l.info("Entering findAbstractDataProduct()");
		FindAbstractDataProductRequestType findAbstractDataProductRequestType = findAbstractDataProductRequest
				.getFindAbstractDataProductRequest();

		FindAbstractDataProductResponseDocument findAbstractDataProductResponseDocument = FindAbstractDataProductResponseDocument.Factory
				.newInstance();

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryDataProductUtil queryDataProductUtil = new QueryDataProductUtil();
			findAbstractDataProductResponseDocument = queryDataProductUtil
					.findAbstractDataProduct(connection,
							findAbstractDataProductRequestType);

			l.debug("findAbstractDataProductResponseDocument validation: "
					+ findAbstractDataProductResponseDocument.validate());

			l.info("Completed findAbstractDataProduct()");
		} catch (Exception e) {
			l.error("Failed to query findAbstractDataProduct()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return findAbstractDataProductResponseDocument;
	}

	@Override
	public FindAbstractMethodResponseDocument findAbstractMethod(
			FindAbstractMethodRequestDocument findAbstractMethodRequest)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindAbstractServiceResponseDocument findAbstractService(
			FindAbstractServiceRequestDocument findAbstractServiceRequest)
			throws QueryException {
		l.info("Entering findAbstractService()");
		FindAbstractServiceRequestType findAbstractServiceRequestType = findAbstractServiceRequest
				.getFindAbstractServiceRequest();

		FindAbstractServiceResponseDocument findAbstractServiceResponseType = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryServiceUtil queryServiceUtil = new QueryServiceUtil();
			findAbstractServiceResponseType = queryServiceUtil
					.findAbstractService(connection,
							findAbstractServiceRequestType);

			l.debug("findAbstractServiceResponseType validation: "
					+ findAbstractServiceResponseType.validate());

			l.info("Completed findAbstractService()");
		} catch (Exception e) {
			l.error("Failed to query findAbstractService()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return findAbstractServiceResponseType;
	}

	@Override
	public FindDataProductResponseDocument findDataProduct(
			FindDataProductRequestDocument findDataProductRequest)
			throws QueryException {

		l.info("Entering findDataProduct()");
		FindDataProductRequestType findDataProductRequestType = findDataProductRequest
				.getFindDataProductRequest();

		FindDataProductResponseDocument findDataProductResponseDocument = FindDataProductResponseDocument.Factory
				.newInstance();

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryDataProductUtil queryDataProductUtil = new QueryDataProductUtil();
			findDataProductResponseDocument = queryDataProductUtil
					.findDataProduct(connection, findDataProductRequestType);

			l.debug("findDataProductResponseDocument validation: "
					+ findDataProductResponseDocument.validate());

			l.info("Completed findDataProduct()");
		} catch (Exception e) {
			l.error("Failed to query findDataProduct()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return findDataProductResponseDocument;
	}

	@Override
	public FindMethodInvocationResponseDocument findMethodInvocation(
			FindMethodInvocationRequestDocument findMethodInvocationRequest)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindServiceResponseDocument findService(
			FindServiceRequestDocument findServiceRequest)
			throws QueryException {
		l.info("Entering findService()");
		FindServiceRequestType findServiceRequestType = findServiceRequest
				.getFindServiceRequest();

		FindServiceResponseDocument findServiceResponseDocument = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryServiceUtil queryServiceUtil = new QueryServiceUtil();
			findServiceResponseDocument = queryServiceUtil.findService(
					connection, findServiceRequestType);

			l.debug("findServiceResponseDocument validation: "
					+ findServiceResponseDocument.validate());

			l.info("Completed findService()");
		} catch (Exception e) {
			l.error("Failed to query findService()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return findServiceResponseDocument;
	}

	@Override
	public GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetail(
			GetAbstractDataProductDetailRequestDocument getAbstractDataProductDetailRequest)
			throws QueryException {
		l.info("Entering getAbstractDataProductDetail()");
		GetAbstractDataProductDetailRequestType getAbstractDataProductDetailRequestType = getAbstractDataProductDetailRequest
				.getGetAbstractDataProductDetailRequest();

		GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetailResponseDocument = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryDataProductUtil queryDataProductUtil = new QueryDataProductUtil();
			getAbstractDataProductDetailResponseDocument = queryDataProductUtil
					.getAbstractDataProductDetail(connection,
							getAbstractDataProductDetailRequestType
									.getDataProductIDList());

			l.debug("getAbstractDataProductDetailResponseDocument validation: "
					+ getAbstractDataProductDetailResponseDocument.validate());

			l.info("Completed getAbstractDataProductDetail()");
		} catch (Exception e) {
			l.error("Failed to query getAbstractDataProductDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getAbstractDataProductDetailResponseDocument;
	}

	@Override
	public GetAbstractMethodDetailResponseDocument getAbstractMethodDetail(
			GetAbstractMethodDetailRequestDocument getAbstractMethodDetailRequest)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetAbstractServiceDetailResponseDocument getAbstractServiceDetail(
			GetAbstractServiceDetailRequestDocument getAbstractServiceDetailRequest)
			throws QueryException {
		l.info("Entering getAbstractServiceDetail()");
		GetAbstractServiceDetailRequestType getAbstractServiceDetailRequestType = getAbstractServiceDetailRequest
				.getGetAbstractServiceDetailRequest();

		GetAbstractServiceDetailResponseDocument getAbstractServiceDetailResponseType = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryServiceUtil queryServiceUtil = new QueryServiceUtil();
			getAbstractServiceDetailResponseType = queryServiceUtil
					.getAbstractServiceDetail(connection,
							getAbstractServiceDetailRequestType);

			l.debug("getAbstractServiceDetailResponseType validation: "
					+ getAbstractServiceDetailResponseType.validate());

			l.info("Completed getAbstractServiceDetail()");
		} catch (Exception e) {
			l.error("Failed to query getAbstractServiceDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getAbstractServiceDetailResponseType;
	}

	@Override
	public GetClientDetailResponseDocument getClientDetail(
			GetClientDetailRequestDocument getClientDetailRequest)
			throws QueryException {
		l.info("Entering getClientDetail()");
		GetClientDetailRequestType getClientDetailRequestType = getClientDetailRequest
				.getGetClientDetailRequest();

		GetClientDetailResponseDocument getClientDetailResponseType = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryClientUtil queryClientUtil = new QueryClientUtil();
			getClientDetailResponseType = queryClientUtil.getClientDetail(
					connection, getClientDetailRequestType.getUniqueIDList());

			l.debug("getClientDetailResponseType validation: "
					+ getClientDetailResponseType.validate());

			l.info("Completed getClientDetail()");
		} catch (Exception e) {
			l.error("Failed to query getClientDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return getClientDetailResponseType;
	}

	@Override
	public GetDataProductDetailResponseDocument getDataProductDetail(
			GetDataProductDetailRequestDocument getDataProductDetailRequest)
			throws QueryException {
		l.info("Entering getDataProductDetail()");
		GetDataProductDetailRequestType dataProductDetailRequestType = getDataProductDetailRequest
				.getGetDataProductDetailRequest();

		GetDataProductDetailResponseDocument dataProductDetailResponseType = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryDataProductUtil queryDataProductUtil = new QueryDataProductUtil();
			dataProductDetailResponseType = queryDataProductUtil
					.getDataProductDetail(connection,
							dataProductDetailRequestType.getDataProductIDList());

			l.debug("dataProductDetailResponseType validation: "
					+ dataProductDetailResponseType.validate());

			l.info("Completed getDataProductDetail()");
		} catch (Exception e) {
			l.error("Failed to query getDataProductDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return dataProductDetailResponseType;
	}

	@Override
	public GetServiceDetailResponseDocument getServiceDetail(
			GetServiceDetailRequestDocument getServiceDetailRequest)
			throws QueryException {
		l.info("Entering getServiceDetail()");
		GetServiceDetailRequestType serviceDetailRequestType = getServiceDetailRequest
				.getGetServiceDetailRequest();

		GetServiceDetailResponseDocument serviceDetailResponseDocument = null;

		Connection connection = null;

		try {
			connection = DBConnectionPool.getInstance().getEntry();
			QueryServiceUtil queryServiceUtil = new QueryServiceUtil();
			serviceDetailResponseDocument = queryServiceUtil.getServiceDetail(
					connection, serviceDetailRequestType);

			l.debug("serviceDetailResponseDocument validation: "
					+ serviceDetailResponseDocument.validate());

			l.info("Completed getServiceDetail()");
		} catch (Exception e) {
			l.error("Failed to query getServiceDetail()", e);

		} finally {
			if (connection != null) {
				DBConnectionPool.getInstance().releaseEntry(connection);
			}
		}

		return serviceDetailResponseDocument;
	}

	@Override
	public GetMethodInvocationDetailResponseDocument getMethodInvocationDetail(
			GetMethodInvocationDetailRequestDocument getMethodInvocationDetailRequest)
			throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

}
