package in.co.rays.project4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.MarksheetBean;
import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DataBaseException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.util.JDBCDataSource;

/**
 * JDBC Implements of marksheet model
 * 
 * @author bhupendrapatidar
 *
 */
public class MarksheetModel {

	

	Logger log = Logger.getLogger(MarksheetModel.class);

	/**
	 * add new id
	 * 
	 * @return pk
	 * @throws DatabaseException
	 */
	public Integer nextPK() throws DataBaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			System.out.println("Connection Succesfully Establish (pk method in marksheet model)");

			PreparedStatement stmt = conn.prepareStatement("select max(id) from st_marksheet");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error(e);
			throw new DataBaseException("Exception in Marksheet getting PK");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk + 1;

	}

	public MarksheetBean findByPK(long pk) throws ApplicationException {
		log.debug("Model findByPK Started");
		System.out.println("marksheet model Method findbypk Started");
		StringBuffer sql = new StringBuffer("select *from st_marksheet where id=?");

		MarksheetBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, pk);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setStudentId(rs.getLong(3));
				bean.setName(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				bean.setCreatedBy(rs.getString(8));
				bean.setModifiedBy(rs.getString(9));
				bean.setCreatedDatetime(rs.getTimestamp(10));
				bean.setModifiedDatetime(rs.getTimestamp(11));
			}
			rs.close();
		} catch (Exception e) {
			log.error(e);
			throw new ApplicationException("Exception in getting marksheet by pk");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByPK end");
		return bean;

	}

	public long add(MarksheetBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");

		Connection conn = null;

		StudentModel sModel = new StudentModel();
		StudentBean studentbean = sModel.findByPK(bean.getStudentId());
		bean.setName(studentbean.getFirstName() + "" + studentbean.getLastName());

		MarksheetBean duplicateMarksheet = findByRollNo(bean.getRollNo());
		int pk = 0;

		if (duplicateMarksheet != null) {
			throw new DuplicateRecordException("Roll Number already exist");

		}
		try {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa add method");
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");

			stmt.setInt(1, pk);
			stmt.setString(2, bean.getRollNo());
			stmt.setLong(3, bean.getStudentId());
			stmt.setString(4, bean.getName());
			stmt.setInt(5, bean.getPhysics());
			stmt.setInt(6, bean.getChemistry());
			stmt.setInt(7, bean.getMaths());
			stmt.setString(8, bean.getCreatedBy());
			stmt.setString(9, bean.getModifiedBy());
			stmt.setTimestamp(10, bean.getCreatedDatetime());
			stmt.setTimestamp(11, bean.getModifiedDatetime());

			stmt.executeUpdate();
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb add method");
			conn.commit();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			try {
				conn.rollback();
			} catch (Exception ex) {

				throw new ApplicationException("add rollback exception" + ex.getMessage());
			}
			throw new ApplicationException("Exception in add marksheet");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add end");
		return pk;
	}

	public MarksheetBean findByRollNo(String rollNo) throws ApplicationException {
		log.debug("Model findByRollNo Started");

		System.out.println("marksheet model Method findbyrollno Started");
		StringBuffer sql = new StringBuffer("select * from st_marksheet where roll_no=?");

		MarksheetBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, rollNo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setStudentId(rs.getLong(3));
				bean.setName(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				bean.setCreatedBy(rs.getString(8));
				bean.setModifiedBy(rs.getString(9));
				bean.setCreatedDatetime(rs.getTimestamp(10));
				bean.setModifiedDatetime(rs.getTimestamp(11));
			}
			rs.close();
		} catch (Exception e) {
			log.error(e);
			throw new ApplicationException("Exception in getting marksheet by rollno");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByRollNo end");
		return bean;
	}

	public void delete(MarksheetBean bean) throws ApplicationException {
		log.debug("Model delete Started");
		System.out.println("marksheet model Method delete Started");
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement("delete from st_marksheet where id=?");
			stmt.setLong(1, bean.getId());
			System.out.println("Deleted Marksheet");
			stmt.executeUpdate();
			conn.commit();
			stmt.close();
		} catch (Exception e) {
			log.error(e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				log.error(ex);
				throw new ApplicationException("Delete rollback exception" + ex.getMessage());

			}
			throw new ApplicationException("Exception in delete marksheet");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Mdel delete end");
	}

	public List search(MarksheetBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/**
	 * Searches Marksheet with pagination
	 *
	 * @return list : List of Marksheets
	 * @param bean     : Search Parameters
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 *
	 * @throws DatabaseException
	 */

	public static List search(MarksheetBean bean, int pageNo, int pageSize) throws ApplicationException {

	/*	if (bean.getResult().equalsIgnoreCase("pass")) {
			sql.append("select * from ST_MARKSHEET where physics > 33 && chemistry > 33 && maths > 33 true");

		} else if (bean.getResult().equalsIgnoreCase("fail")) {
			sql.append("select * from ST_MARKSHEET where physics < 33 && chemistry < 33 && maths < 33 true");

		} else {*/
		
		StringBuffer sql = new StringBuffer("select * from ST_MARKSHEET where true");

			if (bean != null) {
				System.out.println("service" + bean.getName());
				if (bean.getId() > 0) {
					sql.append(" AND id = " + bean.getId());
				}
				if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
					sql.append(" AND roll_no like '" + bean.getRollNo() + "%'");
				}
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" AND name like '" + bean.getName() + "%'");
				}
				if (bean.getPhysics() != null && bean.getPhysics() > 0) {
					sql.append(" AND physics = " + bean.getPhysics());
				}
				if (bean.getChemistry() != null && bean.getChemistry() > 0) {
					sql.append(" AND chemistry = " + bean.getChemistry());
				}
				if (bean.getMaths() != null && bean.getMaths() > 0) {
					sql.append(" AND maths = '" + bean.getMaths());
				}
				if (bean.getStudentId() != null && bean.getStudentId() > 0) {
					sql.append(" AND student_id = " + bean.getStudentId());
				}

			}
		/* } */
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
			// sql.append(" limit " + pageNo + "," + pageSize);
		}

		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setStudentId(rs.getLong(3));
				bean.setName(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				bean.setCreatedBy(rs.getString(8));
				bean.setModifiedBy(rs.getString(9));
				bean.setCreatedDatetime(rs.getTimestamp(10));
				bean.setModifiedDatetime(rs.getTimestamp(11));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			
			throw new ApplicationException("Update rollback exception " + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		
		return list;
	}

	public List list() throws ApplicationException {
		System.out.println("marksheet model Method List(0) Started");
		return list(0, 0);
	}

	/**
	 * get List of Marksheet with pagination
	 *
	 * @return list : List of Marksheets
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 * @throws DatabaseException
	 */

	public List list(int pageNo, int pageSize) throws ApplicationException {

		System.out.println("marksheet model Method List(1) Started");
		log.debug("Model list Started");

		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from st_marksheet");
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MarksheetBean bean = new MarksheetBean();
				bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setStudentId(rs.getLong(3));
				bean.setName(rs.getString(4));
				bean.setPhysics(rs.getInt(5));
				bean.setChemistry(rs.getInt(6));
				bean.setMaths(rs.getInt(7));
				bean.setCreatedBy(rs.getString(8));
				bean.setModifiedBy(rs.getString(9));
				bean.setCreatedDatetime(rs.getTimestamp(10));
				bean.setModifiedDatetime(rs.getTimestamp(11));

				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error(e);
			throw new ApplicationException("Exception in getting list of marksheet");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model list End");
		return list;
	}

	public void update(MarksheetBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Model Update Started");
		System.out.println("marksheet model Method update Started");

		Connection conn = null;
		MarksheetBean beanExist = findByRollNo(bean.getRollNo());

		StudentModel sModel = new StudentModel();
		StudentBean studentbean = sModel.findByPK(bean.getStudentId());
		bean.setName(studentbean.getFirstName() + "" + studentbean.getLastName());

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(
					"update st_marksheet set roll_no=?,student_id=?,name=?,physics=?,chemistry=?,maths=?,created_by=?,modified_by=?,created_date_time=?,modified_date_time=? where id=?");

			stmt.setString(1, bean.getRollNo());
			stmt.setLong(2, bean.getStudentId());
			stmt.setString(3, bean.getName());

			stmt.setInt(4, bean.getPhysics());
			stmt.setInt(5, bean.getChemistry());
			stmt.setInt(6, bean.getMaths());
			stmt.setString(7, bean.getCreatedBy());
			stmt.setString(8, bean.getModifiedBy());
			stmt.setTimestamp(9, bean.getCreatedDatetime());
			stmt.setTimestamp(10, bean.getModifiedDatetime());
			stmt.setLong(11, bean.getId());

			stmt.executeUpdate();
			conn.commit();
			stmt.close();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("update rollback exception" + ex.getMessage());
			}

			throw new ApplicationException("Exception in updating marksheet");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add end");

	}

	public List getMeritList(int pageNo, int pageSize) throws ApplicationException {

		System.out.println("marksheet model Method  getMeritList Started");
		log.debug("Model Meritlist Started");

		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer(
				"select id,roll_no,name,physics,chemistry,maths,(physics+chemistry+maths)as total from st_marksheet where(physics>33 AND chemistry>33 AND maths>33) order by total desc");
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MarksheetBean bean = new MarksheetBean();
				bean.setId(rs.getLong(1));
				bean.setRollNo(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));

				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			throw new ApplicationException("Exception in getting Meritlist of marksheet");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model Meritlist End");
		return list;

	}

}