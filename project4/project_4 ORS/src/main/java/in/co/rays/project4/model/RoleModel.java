package in.co.rays.project4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DataBaseException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.util.JDBCDataSource;

/**
 * JDBC Implement of role model
 * 
 * @author bhupendrapatidar
 *
 */
public class RoleModel {

	 private static Logger log=Logger.getLogger(RoleModel.class);

	/**
	 * create id
	 * 
	 * @return pk
	 * @throws DatabaseException
	 */

	public Integer nextPk() throws DataBaseException {

		Connection conn = null;
		int pk = 0;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_ROLE");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);

			}
			rs.close();

		} catch (Exception e) {
			 log.error("DataBase Exception",e);
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		 log.debug("Model nextPK end");
		return pk + 1;

	}

	/**
	 * add new role
	 * 
	 * @param bean
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */

	public long add(RoleBean bean) throws ApplicationException, DuplicateRecordException {
     log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_ROLE VALUES(?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			 log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
log.debug("Model add End");
		return pk;
	}

	/**
	 * delete role
	 * 
	 * @param bean
	 * @throws ApplicationException
	 */
	public void delete(RoleBean bean) throws ApplicationException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement("delete from st_role where id=?");
			stmt.setLong(1, bean.getId());
			stmt.executeUpdate();
			conn.commit();
			stmt.close();
			System.out.println("delete success");

		} catch (Exception e) {
			 log.error("Database Exception..",e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception: Delete rollback exception" + ex.getMessage());

			}
			throw new ApplicationException("Exception:Exception in delete Role");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model delete Started ");
	}

	/**
	 * find by role with the help of role
	 * 
	 * @param pk
	 * @return bean
	 * @throws ApplicationException
	 */
	public RoleBean findByPK(long pk) throws ApplicationException {
		 log.debug("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE WHERE ID=?");
		RoleBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
			}
			rs.close();
		} catch (Exception e) {
			 log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		 log.debug("Model findByPK End");
		return bean;
	}

	/**
	 * find role with the help of name
	 * 
	 * @param name
	 * @return bean
	 * @throws ApplicationException
	 */
	public RoleBean findByName(String name) throws ApplicationException {
		 log.debug("Model findBy EmailId Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_ROLE WHERE NAME=?");
		RoleBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));

			}
			rs.close();
		} catch (Exception e) {
			 log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by emailId");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		 log.debug("Model findBy EmailId End");
		return bean;
	}

	/**
	 * list of role
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return list
	 * @throws ApplicationException
	 */
	public List List () throws ApplicationException{
		return list(0,0);
	}
	public List list(int pageNo, int pageSize) throws ApplicationException {
		 log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_ROLE");
		// if page size is greater than zero then apply pagination
		Connection conn = null;
		if(pageSize>0){
			pageNo=(pageNo-1)*pageSize;
			sql.append(" limit "+pageNo+","+pageSize);
		}
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RoleBean bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			 log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		 log.debug("Model list End");
		return list;

	}
	
	

	/**
	 * update role
	 * 
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */

	public void update(RoleBean bean) throws DuplicateRecordException, ApplicationException {
		 log.debug("Model Update Started");
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(
					"update st_role set name=?,description=?,created_by=?,modified_by=?,created_date_time=?,modified_date_time=? where id=?");

			stmt.setString(1, bean.getName());
			stmt.setString(2, bean.getDescription());
			stmt.setString(3, bean.getCreatedBy());
			stmt.setString(4, bean.getModifiedBy());
			stmt.setTimestamp(5, bean.getCreatedDatetime());
			stmt.setTimestamp(6, bean.getModifiedDatetime());
			stmt.setLong(7, bean.getId());

			stmt.executeUpdate();
			conn.commit();
			stmt.close();

		} catch (Exception e) {
			 log.error("Database exception..",e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception:delete rollback exception" + ex.getMessage());

			}
			throw new ApplicationException("Exception in updating Role");

		} finally {
			JDBCDataSource.closeConnection(conn);

			 }log.debug("Model update End");

		}


	/**
	 * search role
	 * 
	 * @param bean
	 * @param pageNo
	 * @param pageSize
	 * @return list
	 * @throws ApplicationException
	 */

	public List search(RoleBean bean) throws ApplicationException{
		return search(bean,0,0);
	}
	public List search(RoleBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model search Started");
		StringBuffer sql = new StringBuffer("select * from st_role where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id= " + bean.getId());

			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND NAME like '" + bean.getName() + "%'");
			}
			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" AND DESCRIPTION like '" + bean.getDescription() + "%'");

			}

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println(sql);
		ArrayList list = new ArrayList();
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			 log.error("Database Exception.. ",e);
			throw new ApplicationException("Exception : Exception in search Role");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		 log.debug("Model search End");
		return list;

	}

}
