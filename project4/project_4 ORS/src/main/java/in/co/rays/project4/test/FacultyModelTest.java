package in.co.rays.project4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.FacultyBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.facultyModel;

/**
 * @author bhupendra
 *
 */
public class FacultyModelTest {
	
	public static facultyModel model = new facultyModel();
	
	public static void main(String[] args) throws Exception {
                 // testAdd();   
                //testDelete();
                   // testUpdate();
		         // testlist();
		           // testSearch();
		            //testFindByPK();
		            //  testFindName();
		                       
}
       
		
	public static void testUpdate(){
		try{
			FacultyBean bean=model.findByPK(1L);
			bean.setFirstName("Ajay");
		    bean.setLastName("singh");
			model.update(bean);
			System.out.println("Test Update success");
			FacultyBean updateBean=model.findByPK(1L);
			if(!"Ajay".equals(updateBean.getFirstName())){
				System.out.println("Test Update fail");
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}catch(DuplicateRecordException e){
			e.printStackTrace();
		}
	}
	

		public static void testFindName() {
		try {
			FacultyBean bean=model.findByName("Ankit");
			if(bean==null){
				System.out.println("Test Find By Name Fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getGender());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getQualification());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}

	
		public static void testFindByPK() {
		try {
			FacultyBean bean=new FacultyBean();
			long pk=0L;
			bean=model.findByPK(2);
			if(bean==null){
				System.out.println("Test Find By Pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getGender());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getQualification());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		
		}catch(ApplicationException e){
			e.printStackTrace();
		}
		}

		public static void testSearch() {
			try {
			FacultyBean bean = new FacultyBean();
			List list = new ArrayList();
			bean.setFirstName("Ankit");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
			System.out.println("Test Search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
			
				bean = (FacultyBean) it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
				}
			} catch (ApplicationException e) {
			e.printStackTrace();
				}
			}


	public static void testlist() {
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
			System.out.println(bean.getLastName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			}

			} catch (ApplicationException e) {
			e.printStackTrace();
			}
			
		
	}

	public static void testDelete() {
		try {
			FacultyBean bean = new FacultyBean();
			 long pk = 1;
			bean.setId(3);
			model.delete(bean);
			System.out.println("Test delets success");
			FacultyBean deletedBean = model.findByPK(1);
			if (deletedBean != null) {
			System.out.println("Test Delete fail");
			}

			}catch (ApplicationException e){
			e.printStackTrace();
			}
			}
	
	public static void testAdd() throws DuplicateRecordException {
		try{
		FacultyBean bean = new FacultyBean();
		bean.setId(3);
		bean.setFirstName("Vipin");
		bean.setLastName("Sharma");
		bean.setCollegeId(7);
		bean.setCollegeName("Advance");
		bean.setCourseName("angular");
		bean.setSubjectName("angular");
		long pk=model.add(bean);
		System.out.println("add tested ");
		FacultyBean addedBean=model.findByPK(pk);
		if(addedBean==null){
		System.out.println("fail to add");
		}
		}catch(ApplicationException e){
		e.printStackTrace();
		}
		
	}
	
	
}

	
		

