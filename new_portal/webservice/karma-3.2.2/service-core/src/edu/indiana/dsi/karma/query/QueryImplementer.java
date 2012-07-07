package edu.indiana.dsi.karma.query;

import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument;

public interface QueryImplementer {

	public FindAbstractDataProductResponseDocument findAbstractDataProduct(
			FindAbstractDataProductRequestDocument findAbstractDataProductRequest)
			throws QueryException;

	public FindAbstractMethodResponseDocument findAbstractMethod(
			FindAbstractMethodRequestDocument findAbstractMethodRequest)
			throws QueryException;

	public FindAbstractServiceResponseDocument findAbstractService(
			FindAbstractServiceRequestDocument findAbstractServiceRequest)
			throws QueryException;

	public FindDataProductResponseDocument findDataProduct(
			FindDataProductRequestDocument findDataProductRequest)
			throws QueryException;

	public FindMethodInvocationResponseDocument findMethodInvocation(
			FindMethodInvocationRequestDocument findMethodInvocationRequest)
			throws QueryException;

	public FindServiceResponseDocument findService(
			FindServiceRequestDocument findServiceRequest)
			throws QueryException;

	public GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetail(
			GetAbstractDataProductDetailRequestDocument getAbstractDataProductDetailRequest)
			throws QueryException;

	public GetAbstractMethodDetailResponseDocument getAbstractMethodDetail(
			GetAbstractMethodDetailRequestDocument getAbstractMethodDetailRequest)
			throws QueryException;

	public GetAbstractServiceDetailResponseDocument getAbstractServiceDetail(
			GetAbstractServiceDetailRequestDocument getAbstractServiceDetailRequest)
			throws QueryException;

	public GetClientDetailResponseDocument getClientDetail(
			GetClientDetailRequestDocument getClientDetailRequest)
			throws QueryException;

	public GetDataProductDetailResponseDocument getDataProductDetail(
			GetDataProductDetailRequestDocument getDataProductDetailRequest)
			throws QueryException;

	public GetAnnotationDetailResponseDocument getAnnotationDetail(
			GetAnnotationDetailRequestDocument getAnnotationDetailRequest)
			throws QueryException;

	public GetServiceDetailResponseDocument getServiceDetail(
			GetServiceDetailRequestDocument getServiceDetailRequest)
			throws QueryException;

	public GetMethodInvocationDetailResponseDocument getMethodInvocationDetail(
			GetMethodInvocationDetailRequestDocument getMethodInvocationDetailRequest)
			throws QueryException;

	public GetWorkflowGraphResponseDocument getWorkflowGraph(
			GetWorkflowGraphRequestDocument getWorkflowGraphRequest)
			throws QueryException;

	public CompareWorkflowGraphsResponseDocument compareWorkflowGraphs(
			CompareWorkflowGraphsRequestDocument compareWorkflowGraphsRequest)
			throws QueryException;

	public GetNodeCountOfGraphResponseDocument getNodeCountOfGraph(
			GetNodeCountOfGraphRequestDocument getNodeCountOfGraphRequest)
			throws QueryException;

	public GetProvenanceHistoryResponseDocument getProvenanceHistory(
			GetProvenanceHistoryRequestDocument getProvenanceHistoryRequest)
			throws QueryException;

}
