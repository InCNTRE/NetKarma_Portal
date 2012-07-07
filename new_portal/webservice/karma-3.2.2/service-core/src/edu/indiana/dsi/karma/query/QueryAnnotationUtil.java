package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma.query._2010._10.AnnotationIDListType;
import org.dataandsearch.www.karma.query._2010._10.AnnotationListType;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.ObjectEnumType;
import org.dataandsearch.www.karma.query._2010._10.RelationshipEnumType;

public class QueryAnnotationUtil {
	public static final Log l = LogFactory.getLog(QueryAnnotationUtil.class);
	private static final String GET_DATA_OBJECT_ANNOTATION = "SELECT * FROM exe_data_object_annotation WHERE object_id = ?";
	private static final String GET_EXE_ENTITY_ANNOTATION = "SELECT * FROM exe_entity_annotation WHERE entity_id = ?";
	private static final String GET_REG_ENTITY_ANNOTATION = "SELECT * FROM reg_entity_annotation WHERE entity_id = ?";

	private static final String GET_USED_EVENT_ID = "SELECT event_id FROM exe_data_lifecycle WHERE actor_id = ? AND data.id = ? AND event_action='CONSUME'";
	private static final String GET_WASGENERATEDBY_EVENT_ID = "SELECT event_id FROM exe_data_lifecycle WHERE actor_id = ? AND data.id = ? AND event_action='PRODUCE'";
	private static final String GET_WASTRIGGEREDBY_WITH_ARTIFACTS_EVENT_ID = "select p.event_id, c.event_id FROM exe_data_lifecycle c, exe_data_lifecycle p "
			+ "WHERE c.data_id = p.data_id AND c.event_action='CONSUME' AND p.event_action='PRODUCE'"
			+ "AND c.actor_id = ? AND p.actor_id = ?";
	private static final String GET_WASTRIGGEREDBY_WITHOUT_ARTIFACTS_EVENT_ID = "SELECT DISTINCT e2.entity_id AS effect , e1.entity_id AS cause, invocation_id "
			+ "FROM exe_invocation i, exe_entity e1, exe_entity e2 "
			+ "WHERE i.invoker_id = e1.entity_id "
			+ "AND i.invokee_id = e2.entity_id "
			+ "AND e1.entity_id = ? "
			+ "AND e2.entity_id = ?";
	private static final String GET_WASDERIVEDFROM_EVENT_ID = "SELECT c.event_id, p.event_id "
			+ "FROM exe_data_lifecycle c, exe_data_lifecycle p, exe_entity e "
			+ "WHERE c.actor_id = p.actor_id AND c.actor_id = e.entity_id AND "
			+ "c.event_action='CONSUME' AND p.event_action='PRODUCE' "
			+ "AND p.data_id = ? " + "AND c.data_id = ?";

	private static final String GET_EXE_INVOCATION_ANNOTATION = "SELECT * FROM exe_invocation_annotation WHERE invocation_id = ?";
	private static final String GET_EXE_DATA_LIFECYCLE_ANNOTATION = "SELECT * FROM exe_data_lifecycle_annotation WHERE event_id = ?";

	public GetAnnotationDetailResponseDocument getAnnotationDetail(
			Connection connection, AnnotationIDListType annotationIDListType)
			throws QueryException, SQLException {

		l.info("Entering getAnnotationDetail()");

		assert (connection != null);
		assert (annotationIDListType != null);

		PreparedStatement annotationStmt = null;
		PreparedStatement eventIDStmt = null;

		ResultSet res = null;
		ResultSet idRes = null;

		GetAnnotationDetailResponseDocument getAnnotationDetailResponseDocument = GetAnnotationDetailResponseDocument.Factory
				.newInstance();
		GetAnnotationDetailResponseType getAnnotationDetailResponse = getAnnotationDetailResponseDocument
				.addNewGetAnnotationDetailResponse();
		AnnotationListType annotationList = getAnnotationDetailResponse
				.addNewAnnotationList();
		try {
			for (int i = 0; i < annotationIDListType.getUniqueIDArray().length; i++) {
				String uid = annotationIDListType.getUniqueIDArray(i);

				if (annotationIDListType.getObjectIDArray(i).equals(
						ObjectEnumType.BLOCK)
						|| annotationIDListType.getObjectIDArray(i).equals(
								ObjectEnumType.FILE)) {

					annotationStmt = connection
							.prepareStatement(GET_DATA_OBJECT_ANNOTATION);
					annotationStmt.setString(1, uid);

					res = annotationStmt.executeQuery();
					while (res.next()) {
						AnnotationType annotation = annotationList
								.addNewAnnotation();

						String annotation_id = res.getString("annotation_id");
						String annotation_name = res
								.getString("annotation_name");
						String annotation_value = res
								.getString("annotation_value");
						String annotation_type = res
								.getString("annotation_type");
						if (annotation_name != null) {

							annotation.setProperty("block-annotation_"
									+ annotation_id + "/" + annotation_type
									+ "/" + annotation_name);
							annotation.set(XmlObject.Factory.parse("<value>"
									+ annotation_value + "</value>"));
						}
					}
					res.close();
					annotationStmt.close();

				} else if (annotationIDListType.getObjectIDArray(i).equals(
						ObjectEnumType.PROCESS)) {

					annotationStmt = connection
							.prepareStatement(GET_EXE_ENTITY_ANNOTATION);
					annotationStmt.setString(1, uid);

					res = annotationStmt.executeQuery();
					while (res.next()) {
						AnnotationType annotation = annotationList
								.addNewAnnotation();

						String annotation_id = res.getString("annotation_id");
						String annotation_name = res
								.getString("annotation_name");
						String annotation_value = res
								.getString("annotation_value");
						String annotation_type = res
								.getString("annotation_type");
						String context_workflow_uri = res
								.getString("context_workflow_uri");
						if (annotation_name != null) {

							annotation.setProperty(context_workflow_uri
									+ "/process-annotation_" + annotation_id
									+ "/" + annotation_type + "/"
									+ annotation_name);
							annotation.set(XmlObject.Factory.parse("<value>"
									+ annotation_value + "</value>"));
						}
					}
					res.close();
					annotationStmt.close();

					annotationStmt = connection
							.prepareStatement(GET_REG_ENTITY_ANNOTATION);
					annotationStmt.setString(1, uid);

					res = annotationStmt.executeQuery();
					while (res.next()) {
						AnnotationType annotation = annotationList
								.addNewAnnotation();

						String annotation_id = res.getString("annotation_id");
						String annotation_name = res
								.getString("annotation_name");
						String annotation_value = res
								.getString("annotation_value");
						String annotation_type = res
								.getString("annotation_type");
						String context_workflow_uri = res
								.getString("context_workflow_uri");
						if (annotation_name != null) {

							annotation.setProperty(context_workflow_uri
									+ "/process-annotation_" + annotation_id
									+ "/" + annotation_type + "/"
									+ annotation_name);
							annotation.set(XmlObject.Factory.parse("<value>"
									+ annotation_value + "</value>"));
						}
					}
					res.close();
					annotationStmt.close();

				} else if (annotationIDListType.getObjectIDArray(i).equals(
						ObjectEnumType.AGENT)) {
					// to be handled
				}
			}

			String[] cause = annotationIDListType.getCauseArray();
			String[] effect = annotationIDListType.getEffectArray();

			for (int i = 0; i < annotationIDListType.getCauseArray().length; i++) {

				if (annotationIDListType.getRelationshipIDArray(i).equals(
						RelationshipEnumType.USED)) {

					eventIDStmt = connection
							.prepareStatement(GET_USED_EVENT_ID);
					eventIDStmt.setString(1, effect[i]);
					eventIDStmt.setString(2, cause[i]);

					idRes = eventIDStmt.executeQuery();
					while (idRes.next()) {

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(1));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();
					}
					idRes.close();
					eventIDStmt.close();

				} else if (annotationIDListType.getRelationshipIDArray(i)
						.equals(RelationshipEnumType.WASGENERATEDBY)) {

					eventIDStmt = connection
							.prepareStatement(GET_WASGENERATEDBY_EVENT_ID);
					eventIDStmt.setString(1, effect[i]);
					eventIDStmt.setString(2, cause[i]);

					idRes = eventIDStmt.executeQuery();
					while (idRes.next()) {

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(1));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();
					}
					idRes.close();
					eventIDStmt.close();

				} else if (annotationIDListType.getRelationshipIDArray(i)
						.equals(RelationshipEnumType.WASTRIGGEREDBY)) {

					eventIDStmt = connection
							.prepareStatement(GET_WASTRIGGEREDBY_WITH_ARTIFACTS_EVENT_ID);
					eventIDStmt.setString(1, effect[i]);
					eventIDStmt.setString(2, cause[i]);

					idRes = eventIDStmt.executeQuery();
					while (idRes.next()) {

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(1));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(2));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();
					}

					idRes.close();
					eventIDStmt.close();

					eventIDStmt = connection
							.prepareStatement(GET_WASTRIGGEREDBY_WITHOUT_ARTIFACTS_EVENT_ID);
					eventIDStmt.setString(1, cause[i]);
					eventIDStmt.setString(2, effect[i]);

					idRes = eventIDStmt.executeQuery();
					while (idRes.next()) {

						annotationStmt = connection
								.prepareStatement(GET_EXE_INVOCATION_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(1));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}
					}

					idRes.close();
					eventIDStmt.close();

				} else if (annotationIDListType.getRelationshipIDArray(i)
						.equals(RelationshipEnumType.WASDERIVEDFROM)) {

					eventIDStmt = connection
							.prepareStatement(GET_WASDERIVEDFROM_EVENT_ID);
					eventIDStmt.setString(1, effect[i]);
					eventIDStmt.setString(2, cause[i]);

					idRes = eventIDStmt.executeQuery();
					while (idRes.next()) {

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(1));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();

						annotationStmt = connection
								.prepareStatement(GET_EXE_DATA_LIFECYCLE_ANNOTATION);
						annotationStmt.setString(1, idRes.getString(2));

						res = annotationStmt.executeQuery();

						while (res.next()) {
							AnnotationType annotation = annotationList
									.addNewAnnotation();

							String annotation_id = res
									.getString("annotation_id");
							String annotation_name = res
									.getString("annotation_name");
							String annotation_value = res
									.getString("annotation_value");
							String annotation_type = res
									.getString("annotation_type");
							if (annotation_name != null) {

								annotation
										.setProperty("exe_data_lifecycle-annotation_"
												+ annotation_id
												+ "/"
												+ annotation_type
												+ "/"
												+ annotation_name);
								annotation.set(XmlObject.Factory
										.parse("<value>" + annotation_value
												+ "</value>"));
							}
						}

						res.close();
						annotationStmt.close();
					}

					idRes.close();
					eventIDStmt.close();

				} else if (annotationIDListType.getRelationshipIDArray(i)
						.equals(RelationshipEnumType.WASCONTROLLEDBY)) {

				}
			}
		} catch (SQLException e) {
			l.error("Exiting getAnnotationDetail() with SQL errors.");
			l.error(e.toString());
			getAnnotationDetailResponseDocument = GetAnnotationDetailResponseDocument.Factory
					.newInstance();
			AnnotationType annotation = getAnnotationDetailResponseDocument
					.addNewGetAnnotationDetailResponse().addNewAnnotationList()
					.addNewAnnotation();
			XmlObject value = annotation.addNewValue();
			try {
				value.set(XmlObject.Factory
						.parse("<error>SQL Exception Error</error>"));
			} catch (XmlException e1) {
				l.error("Set XML error for SQL exception.");
				l.error(e.toString());
			}
			annotation.setProperty("ERROR");
			return getAnnotationDetailResponseDocument;
		} catch (XmlException e) {
			l.error("Exiting getAnnotationDetail() with XML errors.");
			l.error(e.toString());
			getAnnotationDetailResponseDocument = GetAnnotationDetailResponseDocument.Factory
					.newInstance();
			AnnotationType annotation = getAnnotationDetailResponseDocument
					.addNewGetAnnotationDetailResponse().addNewAnnotationList()
					.addNewAnnotation();
			XmlObject value = annotation.addNewValue();
			try {
				value.set(XmlObject.Factory
						.parse("<error>XML Parse Error</error>"));
			} catch (XmlException e1) {
				l.error("Set XML error for SQL exception.");
				l.error(e.toString());
			}
			annotation.setProperty("ERROR");
			return getAnnotationDetailResponseDocument;
		} finally {
			if (annotationStmt != null) {
				annotationStmt.close();
				annotationStmt = null;
			}

			if (eventIDStmt != null) {
				eventIDStmt.close();
				eventIDStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}

			if (idRes != null) {
				idRes.close();
				idRes = null;
			}
		}

		l.info("Response: " + getAnnotationDetailResponseDocument);
		l.info("Exiting getAnnotationDetail() with success.");
		return null;

	}
}