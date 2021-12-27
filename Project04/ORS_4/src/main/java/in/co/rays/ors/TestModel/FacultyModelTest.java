package in.co.rays.ors.TestModel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.bean.FacultyBean;
import in.co.rays.ors.bean.StudentBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.model.FacultyModel;

/**

 * @author Tanvi
 * @Version:(4.14.0)

 */
public class FacultyModelTest {

	
	public static FacultyModel model = new FacultyModel();

	
	public static void main(String[] args) throws DuplicateRecordException, ParseException {
	//testAdd();
		// testDelete();
	// testUpdate();
	     // testFindByName();
		 //testFindByPK();
		// testSearch();
		//testList();

	}


	public static void testAdd() throws DuplicateRecordException, ParseException {

		try {
			FacultyBean bean = new FacultyBean();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			bean.setFirstName("Ankur");;
			bean.setLastName("Pal");;
			bean.setGender("Male");
			
			bean.setEmailId("anku2@gmail.com");
			bean.setDob(sdf.parse("1/1/1992"));
			bean.setMobileno("8584545786");
			
			bean.setCollegeid(2);
			bean.setCollegeName("mits");
			bean.setCourseId(2);
			bean.setCourseName("Core Java");
			bean.setSubjectId(1);
			bean.setSubjectName("Development");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			System.out.println("Test add succ");
			 FacultyBean addedbean = model.findByPK(pk);
	            if (addedbean == null) {
	                System.out.println("Test add fail");
	
	            }} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	

	public static void testDelete() {

		try {
			FacultyBean bean = new FacultyBean();
			long pk = 1L;
			bean.setId(pk);
			model.delete(bean);
			System.out.println("Test Delete succ");
		FacultyBean deletedBean = model.findByPK(pk);
			if (deletedBean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * //public static void testUpdate() {
	 * 
	 * // try { // CollegeBean bean = model.findByPK(3L); //
	 * bean.setName("Vikram University"); // bean.setAddress("Ujjain"); //
	 * model.update(bean); System.out.println("Test Update succ"); CollegeBean
	 * updateBean = model.findByPK(3L); if
	 * (!"Vikram University".equals(updateBean.getName())) {
	 * System.out.println("Test Update fail"); } } catch (ApplicationException e) {
	 * e.printStackTrace(); } catch (DuplicateRecordException e) {
	 * e.printStackTrace(); } }
	 */

	public static void testFindByName() {

		try {
			FacultyBean bean = model.findByEmailId("gun34@gmail.com");
			if (bean == null) {
				System.out.println("Test Find By Name fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getGender());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	
	public static void testFindByPK() {
		try {
			FacultyBean bean = new FacultyBean();
			long pk = 2L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getGender());
			System.out.println(bean.getEmailId());
			System.out.println(bean.getDob());
						
			System.out.println(bean.getMobileno());
			System.out.println(bean.getCollegeid());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests search a College by Name
	 */

	public static void testSearch() {
		try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
		//	bean.setName("LNCT");
			 bean.setFirstName("RAM");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getGender());

				System.out.println(bean.getEmailId());
				System.out.println(bean.getDob());
							
				System.out.println(bean.getMobileno());
				System.out.println(bean.getCollegeid());
				System.out.println(bean.getCollegeName());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getSubjectId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	
	public static void testList() {

		try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (FacultyBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				
				System.out.println(bean.getGender());
				System.out.println(bean.getEmailId());
			
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
