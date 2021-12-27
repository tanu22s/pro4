package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.bean.FacultyBean;
import in.co.rays.ors.bean.SubjectBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.util.JDBCDataSource;

/**
 
 * @author Tanvi
 * @Version:(4.14.0)
 *
 * 
 */

public class FacultyModel {
	public static Logger log = Logger.getLogger(FacultyModel.class);


	public Integer nextPk() throws ApplicationException {
		log.debug("Faculty Model nextPK method Started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM ST_FACULTY");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error("DataBase Exception ..", e);
			throw new ApplicationException("Exception in Getting the PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model nextPK method End");
		return pk + 1;
	}

	

	public long add(FacultyBean bean) throws ApplicationException, DuplicateRecordException {
		
//		System.out.println("faculty add in");
		
		log.debug("Faculty Model ADD method Started");
		Connection conn = null;
//		System.out.println("faculty add connection");
		int pk=0;
//		System.out.println("faculty add fbn");
		FacultyBean duplicateFacultyName = findByEmail(bean.getLoginId());
//		System.out.println("faculty add duplicate");
		if (duplicateFacultyName != null) {
//			System.out.println("faculty add if condition ");
			throw new DuplicateRecordException("Faculty name already Exist");
		}
//		System.out.println("faculty add try block started");
		try {
	//		System.out.println("faculty add try block");
			pk = nextPk();
			
			
			  CollegeModel cmodel = new CollegeModel();
			  System.out.println(bean.getCollegeid());
			  CollegeBean cbean = cmodel.findByPK(bean.getCollegeid());
			  bean.setCollegeName(cbean.getName());
			 
		       
		  
			
			  SubjectModel smodel = new SubjectModel(); 
			  SubjectBean sbean = smodel.findByPk(bean.getSubjectId()); 
			  bean.setSubjectName(sbean.getSubjectName());
			  
			  CourseModel coumodel = new CourseModel(); 
			  CourseBean coubean = coumodel.findByPk(bean.getCourseId()); 
			  bean.setCourseName(coubean.getName());
			 
			
				System.out.println("faculty add open connection ");
			    
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO ST_FACULTY VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("prepared started");
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getLoginId());
			pstmt.setDate(6, new java.sql.Date(bean.getDateofjoining().getTime()));
			pstmt.setString(7, bean.getQualification());			
			pstmt.setString(8, bean.getMobileno());
			pstmt.setString(9, bean.getAddress());
			pstmt.setLong(10, bean.getCollegeid());
			pstmt.setString(11,bean.getCollegeName());
			pstmt.setLong(12, bean.getCourseId());
			pstmt.setString(13, bean.getCourseName());
			pstmt.setLong(14, bean.getSubjectId());
			pstmt.setString(15, bean.getSubjectName());
			pstmt.setString(16, bean.getCreatedBy());
			pstmt.setString(17, bean.getModifiedBy());
			pstmt.setTimestamp(18, bean.getCreatedDatetime());
			pstmt.setTimestamp(19, bean.getModifiedDatetime());
			pstmt.executeUpdate();
	//		System.out.println("faculty add execute update");
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("DATABASeEXCEPTION :...", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception in getting Rollback.." + ex.getMessage());
			}
			throw new ApplicationException("Exception in Faculty Model Add method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model ADD method End");
		return pk;
	}
	

	public void delete(FacultyBean bean) throws ApplicationException {
		log.debug("Faculty Model Delete method End");
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_FACULTY WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			log.error("DATABASE EXCEPTION ", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception in Faculty Model rollback" + ex.getMessage());
			}
			throw new ApplicationException("Exception in Faculty Model Delete Method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model delete method End");
	}	


	public void update(FacultyBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Faculty Model UPDATE method STARTED");
		Connection conn = null;

		CollegeModel cmodel = new CollegeModel();
		CollegeBean cbean = cmodel.findByPK(bean.getCollegeid());
		String collegeName = cbean.getName();
		

	   SubjectModel smodel = new SubjectModel();
	   SubjectBean sbean = smodel.findByPk(bean.getSubjectId());
	   String subjectname = sbean.getSubjectName();
		  
		
		
		FacultyBean beanExist = findByEmail(bean.getLoginId());
		if (beanExist != null && bean.getId()!= bean.getId()) {
			throw new DuplicateRecordException("faculty already Exist");
		}
		
		
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_FACULTY SET FIRST_NAME=?, LAST_NAME=?, GENDER=?, LOGIN_ID=?, JOINING_DATE=?, QUALIFICATION=?, MOBILE_NO=? , ADDRESS =?, COLLEGE_ID=? , COLLEGE_NAME=?,COURSE_ID=?,COURSE_NAME=?, SUBJECT_ID=?, SUBJECT_NAME=?, CREATED_BY=? , MODIFIED_BY=? , CREATED_DATETIME=? , MODIFIED_DATETIME=? WHERE ID=? ");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getGender());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setDate(5, new java.sql.Date(bean.getDateofjoining().getTime()));
			pstmt.setString(6, bean.getQualification());
			
			pstmt.setString(7, bean.getMobileno());
			pstmt.setString(8, bean.getAddress());
			pstmt.setLong(9, bean.getCollegeid());
			pstmt.setString(10, collegeName);
			pstmt.setLong(11, bean.getCourseId());
			pstmt.setString(12, bean.getCourseName());
			pstmt.setLong(13, bean.getSubjectId());
			pstmt.setString(14, subjectname);
			pstmt.setString(15, bean.getCreatedBy());
			pstmt.setString(16, bean.getModifiedBy());
			pstmt.setTimestamp(17, bean.getCreatedDatetime());
			pstmt.setTimestamp(18, bean.getModifiedDatetime());
			pstmt.setLong(19, bean.getId());

			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("DATABASE EXCEPTION ...", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception in rollback faculty model .." + ex.getMessage());
			}
			throw new ApplicationException("Exception in faculty model Update Method..");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model update method End");
	}
	/**
	 * Find User by Faculty name
	 * 
	 * @param EmailId
	 *            : get parameter
	 * @return bean
	 * 
	 */
	
	public FacultyBean findByEmail(String loginId) throws ApplicationException {
		
		System.out.println("faculty add find by name");
		log.debug("Faculty Model findByName method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE LOGIN_ID=?");
		Connection conn = null;
		FacultyBean bean = null;
		
		System.out.println(" faculty  find by name 1");
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			System.out.println("prepared");
			pstmt.setString(1, loginId);
			System.out.println("resultset"+loginId);
			
			ResultSet rs = pstmt.executeQuery();
		  System.out.println("tttttttttttttttttttttttttttt");
			
			while (rs.next()) {
				bean = new FacultyBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setLoginId(rs.getString(5));
				bean.setDateofjoining(rs.getDate(6));
				bean.setQualification(rs.getString(7));
				bean.setMobileno(rs.getString(8));
				bean.setAddress(rs.getString(9));
				bean.setCollegeid(rs.getLong(10));
				bean.setCollegeName(rs.getString(11));
				bean.setCourseId(rs.getLong(12));
				bean.setCourseName(rs.getString(13));
				bean.setSubjectId(rs.getLong(14));
				bean.setSubjectName(rs.getString(15));
				bean.setCreatedBy(rs.getString(16));
				bean.setModifiedBy(rs.getString(17));
				bean.setCreatedDatetime(rs.getTimestamp(18));
				bean.setModifiedDatetime(rs.getTimestamp(19));
				System.out.println(" faculty  find by name 3");
			}
			rs.close();
		} catch (Exception e) {
			log.error("database exception ..." , e);
			throw new ApplicationException("Exception : Exception in faculty model in findbyName method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		System.out.println(" faculty  find by name 4");
		log.debug("Faculty Model findbyName method End");
		return bean;
	}
	

	public FacultyBean findByPk(long pk) throws ApplicationException {
		log.debug("Faculty Model findByPK method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE ID=?");
		Connection conn = null;
		FacultyBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new FacultyBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setLoginId(rs.getString(5));
				bean.setDateofjoining(rs.getDate(6));
				bean.setQualification(rs.getString(7));
				bean.setMobileno(rs.getString(8));
				bean.setAddress(rs.getString(9));
				bean.setCollegeid(rs.getLong(10));
				bean.setCollegeName(rs.getString(11));
				bean.setCourseId(rs.getLong(12));
				bean.setCourseName(rs.getString(13));
				bean.setSubjectId(rs.getLong(14));
				bean.setSubjectName(rs.getString(15));
				bean.setCreatedBy(rs.getString(16));
				bean.setModifiedBy(rs.getString(17));
				bean.setCreatedDatetime(rs.getTimestamp(18));
				bean.setModifiedDatetime(rs.getTimestamp(19));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("database exception ..." , e);
			throw new ApplicationException("Exception : Exception in findByPK in faculty model");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model FindByPK method end");
		return bean;
	}
	
	/**
	 * Search Faculty
	 * 
	 * @param bean
	 *            : Search Parameters
	 * 
	 */

	public List search(FacultyBean bean) throws ApplicationException{
		return search(bean,0,0);
	}
	/**
	 * Search Faculty with pagination
	 * 
	 * @return list : List of Users
	 * @param bean
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 * 
	 */

	public List search(FacultyBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Faculty Model search  method Started");
		System.out.println("faculty model");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE 1=1");
		if (bean!=null) {
			 if (bean.getId() > 0) {
	                sql.append(" AND id = " + bean.getId());
	            }
	            if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
	                sql.append(" AND FIRST_NAME like '" + bean.getFirstName()
	                        + "%'");
	            }
	            if (bean.getLastName() != null && bean.getLastName().length() > 0) {
	                sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
	            }
		
			System.out.println("good here ");
			
			if (bean.getGender()!=null && bean.getGender().length()>0) {
				sql.append(" AND Gender like '" + bean.getGender() + "%'");
			}
			if (bean.getLoginId()!=null && bean.getLoginId().length()>0) {
				sql.append(" AND EmailId like '" + bean.getLoginId() + "%'");
			}
			// date of birth
			
				if (bean.getDateofjoining()!=null && bean.getDateofjoining().getDate()>0) {
				sql.append(" AND DateofJoining = " + bean.getDateofjoining() + " % ");
			}
				System.out.println("good here2 ");
			if (bean.getQualification()!=null && bean.getQualification().length()>0) {
				sql.append(" AND Qualification like '" + bean.getQualification() + "%'");
			}
			
			if (bean.getMobileno()!=null && bean.getMobileno().length()>0) {
				sql.append(" AND MobileNo like '" + bean.getMobileno() + "%'");
			}
			if (bean.getAddress()!=null && bean.getAddress().length()>0) {
				sql.append(" AND Address like '" + bean.getAddress() + "%'");
			}
			if (bean.getCollegeid() > 0) {
				sql.append(" AND collegeid = '" + bean.getCollegeid());
			}
			if (bean.getCollegeName()!=null && bean.getCollegeName().length()>0) {
				sql.append(" AND collegename like '" + bean.getCollegeName() + "%'");
			}
			if (bean.getCourseId() > 0) {
				sql.append(" AND courseid = '" + bean.getCourseId());
			}
			if (bean.getCourseName()!=null && bean.getCourseName().length()>0) {
				sql.append(" AND coursename like '" + bean.getCourseName() + "%'");
			}
			if (bean.getSubjectId() > 0) {
				sql.append(" AND Subjectid = '" + bean.getSubjectId());
			}
			if (bean.getSubjectName()!=null && bean.getSubjectName().length()>0) {
				sql.append(" AND subjectname like '" + bean.getSubjectName() + "%'");
			}
			System.out.println("good here3 ");
		}
		
		// if page no is greater then zero then apply pagination 
		System.out.println("model page ........"+pageNo +" "+pageSize);
		if(pageSize>0){
			pageNo = (pageNo-1)*pageSize;
			sql.append(" limit "+pageNo+ " , " + pageSize);
		}
	     System.out.println("final sql  "+sql);
		
		ArrayList list = new ArrayList();
		Connection conn = null;
		try{
			
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery(); 
			while (rs.next()) {
//				System.out.println("while...............>>>>");
				bean = new FacultyBean();
				bean.setId(rs.getLong(1));
				
				System.out.println("green");
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setLoginId(rs.getString(5));
				bean.setDateofjoining(rs.getDate(6));
				bean.setQualification(rs.getString(7));
				bean.setMobileno(rs.getString(8));
				bean.setAddress(rs.getString(9));
				bean.setCollegeid(rs.getLong(10));
				bean.setCollegeName(rs.getString(11));
				bean.setCourseId(rs.getLong(12));
				bean.setCourseName(rs.getString(13));
				bean.setSubjectId(rs.getLong(14));
				bean.setSubjectName(rs.getString(15));
				bean.setCreatedBy(rs.getString(16));
				bean.setModifiedBy(rs.getString(17));
				bean.setCreatedDatetime(rs.getTimestamp(18));
				bean.setModifiedDatetime(rs.getTimestamp(19));
			System.out.println("out while");
				list.add(bean);
				System.out.println("list size ----------->");
			}
			rs.close();
			
		}catch(Exception e){
			log.error("database Exception .. " , e);
		throw new ApplicationException("Exception : Exception in Search method of Faculty Model");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Faculty Model search  method End");
	//	System.out.println("retuen >>>>>>>>>>>>>>>"+list.size());
		return list;
		
	}

	/**
	 * Get List of Faculty
	 * 
	 * @return list : List of Faculty
	 * 
	 */

	public List list() throws ApplicationException{
		return list(0,0);
	}

	/**
	 * Get List of Faculty with pagination
	 * 
	 * @return list : List of Faculty
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 *
	 */

	public List list(int pageNo, int pageSize) throws ApplicationException {
		log.debug("Faculty Model List method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY");
		Connection conn = null;
		ArrayList list = new ArrayList();
		
		// if page is greater than zero then apply pagination 
		if (pageSize>0) {
			pageNo = (pageNo-1)*pageSize;
			sql.append(" limit "+ pageNo+ " , " + pageSize);
		}
		try{
				conn = JDBCDataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					FacultyBean bean = new FacultyBean();
					bean.setId(rs.getLong(1));
					bean.setFirstName(rs.getString(2));
					bean.setLastName(rs.getString(3));
					bean.setGender(rs.getString(4));
					bean.setLoginId(rs.getString(5));
					bean.setDateofjoining(rs.getDate(6));
					bean.setQualification(rs.getString(7));
					bean.setMobileno(rs.getString(8));
					bean.setAddress(rs.getString(9));
					bean.setCollegeid(rs.getLong(10));
					bean.setCollegeName(rs.getString(11));
					bean.setCourseId(rs.getLong(12));
					bean.setCourseName(rs.getString(13));
					bean.setSubjectId(rs.getLong(14));
					bean.setSubjectName(rs.getString(15));
					bean.setCreatedBy(rs.getString(16));
					bean.setModifiedBy(rs.getString(17));
					bean.setCreatedDatetime(rs.getTimestamp(18));
					bean.setModifiedDatetime(rs.getTimestamp(19));
					list.add(bean);
				}rs.close();
		}catch(Exception e){
			log.error("Database Exception ......" , e);
			throw new ApplicationException("Exception in list method of FacultyModel");
		}finally {
		JDBCDataSource.closeConnection(conn);	
		}
		log.debug("Faculty Model List method End");
		return list;
	}

		
}
