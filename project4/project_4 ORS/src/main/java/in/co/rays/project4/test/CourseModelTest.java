package in.co.rays.project4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CourseModel;

/**
 * @author bhupendra
 *
 */
public class CourseModelTest {
	
	public static CourseModel model=new CourseModel();
	
	public static void main(String[] args) throws Exception {
	           // testadd(); 
		      // testdelete();
		     testUpdate();
		      //testfindByPk(); 
		//testfindByName();
		//testSearch();
		//testList();
		
		
	
	}
	public static void testUpdate(){
		try{
			CourseBean bean=model.findByPK(14L);
			bean.setCourseName("MMPSC");
			model.update(bean);
			System.out.println("Test Update success");
			CourseBean updateBean=model.findByPK(19L);
			if(!"MSC".equals(updateBean.getCourseName())){
				System.out.println("Test Update fail");
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}catch(DuplicateRecordException e){
			e.printStackTrace();
		}
	}


	public static void testdelete() {
		try {
			CourseBean bean = new CourseBean();
			long pk=9L;
			bean.setId(2);
			model.delete(bean);
			System.out.println("test Delete Success");
CourseBean deletedBean=model.findByPK(2);
			
			if(deletedBean!=null){
				System.out.println("Test Delete fail");
			}
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
		
	}

	public static void testList() {
		
		try {
			CourseBean bean = new CourseBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
			System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
			bean = (CourseBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			}

			} catch (ApplicationException e) {
			e.printStackTrace();
			}
			}

	public static void testSearch() {
		try {
			CourseBean  bean = new CourseBean();
			List list = new ArrayList();
			bean.setCourseName("MBA");
			list = model.search(bean,1,10);
			if (list.size() < 0) {
				System.out.println("Test Search fail");
				}
				Iterator it = list.iterator();
				while (it.hasNext()) {
				bean = (CourseBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
				}
				} catch (ApplicationException e) {
				e.printStackTrace();
				}
				}


	public static void testfindByName() {
		// TODO Auto-generated method stub
		try {
			CourseBean bean = model.findByName("BE");
			if(bean==null) {
				System.out.println("test Find By Name Fail");
				
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getDuration());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}

	public static void testfindByPk() {
		CourseBean bean= new CourseBean();
		long pk=0L;
		try {
			bean=model.findByPK(1);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bean==null){
			System.out.println("test find By Pk fail");
			
		}
		System.out.println(bean.getId());
		System.out.println(bean.getCourseName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getDuration());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getModifiedDatetime());
	}
	
			
			
	

	public static void testadd() throws Exception {
		// TODO Auto-generated method stub
		try {
			CourseBean bean = new CourseBean();
			bean.setId(5);
			bean.setCourseName("BE");
			bean.setDescription("bachelor");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			

			long pk=model.add(bean);
			System.out.println("add tested successfully");
			CourseBean addedBean=model.findByPK(pk);

			if(addedBean==null){
				System.out.println("fail to add");
			}
		}catch(ApplicationException e){
				e.printStackTrace();
			}
	}
	
		
	
	}

	
