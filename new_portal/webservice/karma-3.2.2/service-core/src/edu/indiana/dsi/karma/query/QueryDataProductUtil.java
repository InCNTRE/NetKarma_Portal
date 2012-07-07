package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dataandsearch.www.karma.query._2010._10.AbstractDataProductDetail;
import org.dataandsearch.www.karma.query._2010._10.AbstractDataProductListType;
import org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType;
import org.dataandsearch.www.karma.query._2010._10.DataObjectEnumType.Enum;
import org.dataandsearch.www.karma.query._2010._10.DataProductDetail;
import org.dataandsearch.www.karma.query._2010._10.DataProductDetailListType;
import org.dataandsearch.www.karma.query._2010._10.DataProductIDListType;
import org.dataandsearch.www.karma.query._2010._10.DataProductNameListType;
import org.dataandsearch.www.karma.query._2010._10.DataProductTypeListType;
import org.dataandsearch.www.karma.query._2010._10.FileURIDetailsType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseType;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestType;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseType;
import org.dataandsearch.www.karma.query._2010._10.MembershipDetail;
import org.dataandsearch.www.karma.query._2010._10.UniqueFileListType;
import org.dataandsearch.www.karma.query._2010._10.UniqueIDListType;

import edu.indiana.dsi.karma.query.common.Common;

public class QueryDataProductUtil {
	public static final Log l = LogFactory.getLog(QueryDataProductUtil.class);

	private static final String GET_FILE = "SELECT * FROM exe_file WHERE file_id = ?";
	private static final String GET_BLOCK = "SELECT * FROM exe_block WHERE block_id = ?";
	private static final String GET_COLLECTION = "SELECT * FROM exe_data_collection c WHERE c.collection_id = ?";
	private static final String GET_MEMBERSHIP = "SELECT * FROM exe_data_collection_membership m, exe_data_object o "
			+ "WHERE m.collection_id = ? AND m.member_id = o.object_id";

	private static final String GET_ABSTRACT_DATA_OBJECT = "SELECT * FROM reg_data_object WHERE object_id = ?";
	private static final String FIND_ALL_ABSTRACT_DATA_OBJECT = "SELECT * FROM reg_data_object";

	public FindDataProductResponseDocument findDataProduct(
			Connection connection,
			FindDataProductRequestType findDataProductRequestType)
			throws QueryException, SQLException {

		l.info("Entering QueryDataProductUtil.findDataProduct().");

		assert (connection != null);
		assert (findDataProductRequestType != null);

		PreparedStatement findDataProductStmt = null;
		ResultSet resultSet = null;

		FindDataProductResponseDocument findDataProductResponseDocument = FindDataProductResponseDocument.Factory
				.newInstance();
		FindDataProductResponseType findDataProductResponseType = findDataProductResponseDocument
				.addNewFindDataProductResponse();

		String blockName = findDataProductRequestType.getBlockName();
		String blockContent = findDataProductRequestType.getBlockContent();
		String blockIsInstanceOfDataProduct = findDataProductRequestType
				.getBlockIsInstanceOfDataProduct();
		long blockSize = findDataProductRequestType.getBlockSize();
		String blockMD5 = findDataProductRequestType.getBlockMD5Checksum();

		Calendar creationDate = findDataProductRequestType
				.getFileCreationDate();
		String fileName = findDataProductRequestType.getFileName();
		String fileURI = findDataProductRequestType.getFileURI();
		String ownerID = findDataProductRequestType.getFileOwnerID();
		String fileIsInstanceOfDataProduct = findDataProductRequestType
				.getFileIsInstanceOfDataProduct();
		long fileSize = findDataProductRequestType.getFileSize();
		String fileMD5 = findDataProductRequestType.getFileMD5Checksum();

		StringBuilder queryString = new StringBuilder(
				"SELECT * FROM exe_data_object o ");

		if (blockName != null || blockContent != null || blockMD5 != null
				|| blockSize > 0 || blockIsInstanceOfDataProduct != null) {
			queryString.append(", exe_block b ");
			queryString
					.append("WHERE o.object_id = b.block_id AND o.object_type = 'BLOCK'");

			if (blockName != null)
				queryString.append(" AND block_id = '"
						+ blockName.replace(Common.BLOCK_IDENTIFIER, "") + "'");
			if (blockContent != null)
				queryString.append(" AND block_content LIKE '%" + blockContent
						+ "%'");
			if (blockMD5 != null)
				queryString.append(" AND md5_checksum = '" + blockMD5 + "'");
			if (blockSize > 0)
				queryString.append(" AND size = '" + blockSize + "'");
			if (blockIsInstanceOfDataProduct != null)
				queryString.append(" AND instance_of = '"
						+ blockIsInstanceOfDataProduct + "'");

		} else if (fileName != null || fileURI != null || creationDate != null
				|| ownerID != null || fileMD5 != null || fileSize > 0
				|| fileIsInstanceOfDataProduct != null) {
			queryString.append(", exe_file f ");
			queryString
					.append("WHERE o.object_id = f.file_id AND o.object_type = 'FILE'");

			if (fileName != null)
				queryString.append(" AND file_name LIKE '%" + fileName + "%'");
			if (fileURI != null)
				queryString.append(" AND file_uri LIKE '%" + fileURI + "%'");
			if (ownerID != null)
				queryString.append(" AND owner_id LIKE '%" + ownerID + "%'");
			if (creationDate != null)
				queryString.append(" AND creation_date = '" + creationDate
						+ "'");
			if (fileMD5 != null)
				queryString.append(" AND md5_checksum = '" + fileMD5 + "'");
			if (fileSize > 0)
				queryString.append(" AND size = '" + fileSize + "'");
			if (fileIsInstanceOfDataProduct != null)
				queryString.append(" AND instance_of = '"
						+ fileIsInstanceOfDataProduct + "'");
		}

		try {

			findDataProductStmt = connection.prepareStatement(queryString
					.toString());
			resultSet = findDataProductStmt.executeQuery();

			if (blockName != null || blockContent != null || blockMD5 != null
					|| blockSize > 0 || blockIsInstanceOfDataProduct != null) {
				UniqueIDListType uniqueBlockIDList = findDataProductResponseType
						.addNewUniqueBlockIDList();

				while (resultSet.next()) {
					uniqueBlockIDList.addUniqueID(Common.BLOCK_IDENTIFIER
							+ resultSet.getString("block_id"));
				}

			} else if (fileName != null || fileURI != null
					|| creationDate != null || ownerID != null
					|| fileMD5 != null || fileSize > 0
					|| fileIsInstanceOfDataProduct != null) {
				UniqueFileListType uniqueFileURIList = findDataProductResponseType
						.addNewUniqueFileURIList();

				while (resultSet.next()) {

					FileURIDetailsType fileURIDetailsType = uniqueFileURIList
							.addNewFileURIDetailsType();
					fileURIDetailsType.setFileURI(resultSet
							.getString("file_uri"));
					fileURIDetailsType.setFileID(Common.FILE_IDENTIFIER
							+ resultSet.getString("file_id"));					
					
					Timestamp creation_date = resultSet
							.getTimestamp("creation_date");
					if (creation_date != null)
						fileURIDetailsType
								.setCreationDate(Common.getCalendarFromTimeStamp(creation_date));
					
				}

			} else {
				l.error("Should not enter here. Block specific or file specific attributes must be specified.");
			}

			resultSet.close();
			findDataProductStmt.close();

		} catch (SQLException e) {
			l.error("Exiting QueryDataProductUtil.findDataProduct() with SQL errors.");
			l.error(e.toString());

			return null;
		} finally {
			if (findDataProductStmt != null) {
				findDataProductStmt.close();
				findDataProductStmt = null;
			}

			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
		}

		l.info("Response: " + findDataProductResponseDocument);
		l.info("Exiting QueryDataProductUtil.findDataProduct() with success.");
		return findDataProductResponseDocument;
	}

	public FindAbstractDataProductResponseDocument findAbstractDataProduct(
			Connection connection,
			FindAbstractDataProductRequestType findAbstractDataProductRequestType)
			throws QueryException, SQLException {

		l.info("Entering QueryDataProductUtil.findAbstractDataProduct().");

		assert (connection != null);
		assert (findAbstractDataProductRequestType != null);

		FindAbstractDataProductResponseDocument findAbstractDataProductResponseDocument = FindAbstractDataProductResponseDocument.Factory
				.newInstance();
		FindAbstractDataProductResponseType findAbstractDataProductResponseType = findAbstractDataProductResponseDocument
				.addNewFindAbstractDataProductResponse();

		PreparedStatement findAbstractDataProductStmt = null;
		ResultSet res = null;

		try {
			if (findAbstractDataProductRequestType.getReturnAll()) {
				findAbstractDataProductStmt = connection
						.prepareStatement(FIND_ALL_ABSTRACT_DATA_OBJECT);
				l.debug("findAbstractDataProductStmt: "
						+ findAbstractDataProductStmt);
			} else {
				DataProductNameListType dataProductNameList = findAbstractDataProductRequestType
						.getDataProductNameList();
				DataProductTypeListType dataProductTypeList = findAbstractDataProductRequestType
						.getDataProductTypeList();

				if (!dataProductNameList.isNil()
						|| !dataProductTypeList.isNil()) {
					StringBuilder queryString = new StringBuilder(
							"SELECT * FROM reg_data_object o WHERE ");

					for (String dataProductName : dataProductNameList
							.getDataProductNameArray()) {
						queryString.append(" name like '%" + dataProductName
								+ "%' ");

					}

					for (Enum dataProductType : dataProductTypeList
							.getDataProductTypeArray()) {
						queryString.append(" type like '%"
								+ dataProductType.toString() + "%' ");
					}
				}

			}

			res = findAbstractDataProductStmt.executeQuery();
			DataProductNameListType dataProductNameList = findAbstractDataProductResponseType
					.addNewDataProductNameList();
			UniqueIDListType uniqueIDList = findAbstractDataProductResponseType
					.addNewUniqueIDList();

			while (res.next()) {
				String name = res.getString("object_name");
				String id = res.getString("object_id");
				if (name != null)
					dataProductNameList.addDataProductName(name);
				if (id != null)
					uniqueIDList.addUniqueID(Common.REG_DATA_OBJECT_IDENTIFIER
							+ id);
			}
			res.close();
			findAbstractDataProductStmt.close();

		} catch (SQLException e) {
			l.error("Exiting QueryDataProductUtil.findAbstractDataProduct() with SQL errors.");
			l.error(e.toString());

			return null;
		} finally {
			if (findAbstractDataProductStmt != null) {
				findAbstractDataProductStmt.close();
				findAbstractDataProductStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}

		l.info("Response: " + findAbstractDataProductResponseDocument);
		l.info("Exiting QueryDataProductUtil.findAbstractDataProduct() with success.");
		return findAbstractDataProductResponseDocument;
	}

	public GetDataProductDetailResponseDocument getDataProductDetail(
			Connection connection, DataProductIDListType dataProductIDType)
			throws QueryException, SQLException {

		l.info("Entering QueryDataProductUtil.getDataProductDetail().");
		assert (connection != null);
		assert (dataProductIDType != null);

		PreparedStatement dataProductDetailStmt = null;
		PreparedStatement membershipDetailStmt = null;
		ResultSet res = null;
		ResultSet membershipRes = null;

		GetDataProductDetailResponseDocument getDataProductDetailResponseDocument = GetDataProductDetailResponseDocument.Factory
				.newInstance();

		GetDataProductDetailResponseType getDataProductDetailResponseType = getDataProductDetailResponseDocument
				.addNewGetDataProductDetailResponse();
		DataProductDetailListType dataProductDetailList = getDataProductDetailResponseType
				.addNewDataProductDetailList();

		for (String dataProductID : dataProductIDType.getDataProductIDArray()) {
			l.info("Processing dataProductID: " + dataProductID);

			try {
				if (dataProductID.startsWith(Common.FILE_IDENTIFIER)) {
					dataProductDetailStmt = connection
							.prepareStatement(GET_FILE);
					dataProductDetailStmt.setString(1,
							dataProductID.replace(Common.FILE_IDENTIFIER, ""));

					l.debug("dataProductDetailStmt: " + dataProductDetailStmt);

					res = dataProductDetailStmt.executeQuery();

					if (res.next()) {

						DataProductDetail newDataProductDetail = dataProductDetailList
								.addNewDataProductDetail();
						newDataProductDetail.setId(dataProductID);

						String file_uri = res.getString("file_uri");
						String owner_id = res.getString("owner_id");
						Timestamp creation_date = res
								.getTimestamp("creation_date");
						long size = res.getLong("size");
						String md5 = res.getString("md5_checksum");
						String file_name = res.getString("file_name");

						newDataProductDetail.setFileURI(file_uri);

						if (owner_id != null)
							newDataProductDetail.setOwner(owner_id);
						if (creation_date != null)
							newDataProductDetail.setCreationDate(Common.getCalendarFromTimeStamp(creation_date));						
						if (size > 0)
							newDataProductDetail.setSize(size);
						if (md5 != null)
							newDataProductDetail.setMd5(md5);
						if (file_name != null)
							newDataProductDetail.setFileName(file_name);
					}

				} else if (dataProductID.startsWith(Common.BLOCK_IDENTIFIER)) {
					dataProductDetailStmt = connection
							.prepareStatement(GET_BLOCK);
					dataProductDetailStmt.setString(1,
							dataProductID.replace(Common.BLOCK_IDENTIFIER, ""));

					l.debug("dataProductDetailStmt: " + dataProductDetailStmt);
					res = dataProductDetailStmt.executeQuery();

					if (res.next()) {

						DataProductDetail newDataProductDetail = dataProductDetailList
								.addNewDataProductDetail();
						newDataProductDetail.setId(dataProductID);

						String block_content = res.getString("block_content");
						long size = res.getLong("size");
						String md5 = res.getString("md5_checksum");

						newDataProductDetail.setBlockContent(block_content);
						if (size > 0)
							newDataProductDetail.setSize(size);
						if (md5 != null)
							newDataProductDetail.setMd5(md5);

					}

				} else {
					dataProductDetailStmt = connection
							.prepareStatement(GET_COLLECTION);
					dataProductDetailStmt.setString(1, dataProductID.replace(
							Common.COLLECTION_IDENTIFIER, ""));

					l.debug("dataProductDetailStmt: " + dataProductDetailStmt);
					res = dataProductDetailStmt.executeQuery();

					if (res.next()) {

						DataProductDetail newDataProductDetail = dataProductDetailList
								.addNewDataProductDetail();
						newDataProductDetail.setId(dataProductID);

						String uri = res.getString("collection_uri");
						newDataProductDetail.setCollectionURI(uri);

						membershipDetailStmt = connection
								.prepareStatement(GET_MEMBERSHIP);
						membershipDetailStmt.setString(1, dataProductID
								.replace(Common.COLLECTION_IDENTIFIER, ""));

						membershipRes = membershipDetailStmt.executeQuery();

						while (membershipRes.next()) {
							MembershipDetail membership = newDataProductDetail
									.addNewMembership();
							membership.setId(membershipRes
									.getString("member_id"));

							if (membershipRes.getString("object_type").equals(
									DataObjectEnumType.BLOCK.toString())) {
								membership
										.setDataObjectType(DataObjectEnumType.BLOCK);
							} else if (membershipRes.getString("object_type")
									.equals(DataObjectEnumType.FILE.toString())) {
								membership
										.setDataObjectType(DataObjectEnumType.FILE);
							} else if (membershipRes.getString("object_type")
									.equals(DataObjectEnumType.COLLECTION
											.toString())) {
								membership
										.setDataObjectType(DataObjectEnumType.COLLECTION);
							} else {
								l.error("Unrecognized data object type.");
							}

							String instance_of = membershipRes
									.getString("instance_of");
							if (instance_of != null)
								membership.setInstanceOf(instance_of);

						}

						membershipRes.close();
						membershipDetailStmt.close();

					}
				}
			} catch (SQLException e) {
				l.error("Exiting getDataProductDetail() with SQL errors.");
				l.error(e.toString());

				return null;
			} finally {
				if (dataProductDetailStmt != null) {
					dataProductDetailStmt.close();
					dataProductDetailStmt = null;
				}

				if (membershipDetailStmt != null) {
					membershipDetailStmt.close();
					membershipDetailStmt = null;
				}

				if (res != null) {
					res.close();
					res = null;
				}

				if (membershipRes != null) {
					membershipRes.close();
					membershipRes = null;
				}
			}
		}

		l.info("Response: " + getDataProductDetailResponseDocument);
		l.info("Exiting QueryDataProductUtil.getDataProductDetail() with success.");
		return getDataProductDetailResponseDocument;

	}

	public GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetail(
			Connection connection, DataProductIDListType dataProductIDType)
			throws QueryException, SQLException {

		l.info("Entering QueryDataProductUtil.getAbstractDataProductDetail().");
		assert (connection != null);
		assert (dataProductIDType != null);

		PreparedStatement dataProductDetailStmt = null;
		ResultSet res = null;

		GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetailResponseDocument = GetAbstractDataProductDetailResponseDocument.Factory
				.newInstance();

		GetAbstractDataProductDetailResponseType getAbstractDataProductDetailResponseType = getAbstractDataProductDetailResponseDocument
				.addNewGetAbstractDataProductDetailResponse();

		AbstractDataProductListType abstractDataProductList = getAbstractDataProductDetailResponseType
				.addNewAbstractDataProductList();

		for (String dataProductID : dataProductIDType.getDataProductIDArray()) {
			l.info("Processing RegDataProductID: " + dataProductID);

			try {
				dataProductDetailStmt = connection
						.prepareStatement(GET_ABSTRACT_DATA_OBJECT);
				dataProductDetailStmt.setString(
						1,
						dataProductID
								.replace(Common.REG_DATA_OBJECT_IDENTIFIER, "")
								.replace(Common.BLOCK_IDENTIFIER, "")
								.replace(Common.FILE_IDENTIFIER, ""));

				l.debug("dataProductDetailStmt: " + dataProductDetailStmt);
				res = dataProductDetailStmt.executeQuery();

				if (res.next()) {
					AbstractDataProductDetail newAbstractDataProductDetail = abstractDataProductList
							.addNewAbstractDataProductDetail();
					newAbstractDataProductDetail.setId(dataProductID);

					String name = res.getString("object_name");
					String type = res.getString("object_type");

					if (name != null)
						newAbstractDataProductDetail.setName(name);
					if (type != null)
						newAbstractDataProductDetail.setType(type);

				}

			} catch (SQLException e) {
				l.error("Exiting QueryDataProductUtil.getAbstractDataProductDetail() with SQL errors.");
				l.error(e.toString());

				return null;
			} finally {
				if (dataProductDetailStmt != null) {
					dataProductDetailStmt.close();
					dataProductDetailStmt = null;
				}

				if (res != null) {
					res.close();
					res = null;
				}
			}
		}

		l.info("Response: " + getAbstractDataProductDetailResponseDocument);
		l.info("Exiting QueryDataProductUtil.getAbstractDataProductDetail() with success.");
		return getAbstractDataProductDetailResponseDocument;

	}
}