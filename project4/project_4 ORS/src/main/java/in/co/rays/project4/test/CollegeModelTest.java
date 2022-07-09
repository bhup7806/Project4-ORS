package in.co.rays.project4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CollegeBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CollegeModel;

/**
 * @author bhupendra
 *
 */
public class CollegeModelTest {
	

	public static CollegeModel model=new CollegeModel();

	public static void main(String args[]) throws Exception{
		
		
	     testAdd();
		//testdelete();
		//testupdate();
		//testFindByName();
		//testFindByPk();
		 // testSearch();
		  //testlist();		
}
	
	public static void testAdd() throws Exception{
		
		try{
			CollegeBean bean=new CollegeBean();
			bean.setId(2);
			bean.setName("davv 1");
			bean.setAddress("indore");
			bean.setState("mp");
			bean.setCity("indore");
			bean.setPhoneNo("64578876");
			bean.setCreatedBy("wdszc");
			bean.setModifiedBy("asfzxc");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			
			long pk=model.add(bean);
			System.out.println("add tested ");
			CollegeBean addedBean=model.findByPK(pk);
			if(addedBean==null){
				System.out.println("fail to add");
			}
		}catch(ApplicationException e){
				e.printStackTrace();
			}
			
		
	}
	
	    



	public static void testupdate() {
		// TODO Auto-generated method stub
		CollegeBean bean;
		try {
			bean = model.findByPK(7L);
		bean.setName("ajay");
		bean.setAddress("shajapur");
		model.update(bean);
		System.out.println("Test Update success");
		CollegeBean updateBean=model.findByPK(5L);
		if(!"oit".equals(updateBean.getName())){
			System.out.println("Test Update fail");
		}
	}catch(ApplicationException e){
		e.printStackTrace();
	}catch(DuplicateRecordException e){
		e.printStackTrace();
	}
}
		


	public static void testdelete() {
		// TODO Auto-generated method stub
		try {
			
		CollegeBean bean = new CollegeBean();
		long pk=8L;
		bean.setId(3);
		model.delete(bean);
		System.out.println("test delete success");
		CollegeBean deletedBean=model.findByPK(3);
		
		if(deletedBean!=null){
			System.out.println("Test Delete fail");
		}
		
	}catch(ApplicationException e){
		e.printStackTrace();
	}
		
		
	}

	public static void testlist() {
		// TODO Auto-generated method stub
		try {
			
			CollegeBean bean = new CollegeBean();
			List list = new ArrayList();
			list = model.list(1,10);
			 if (list.size() < 0) {
	                System.out.println("Test list fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (CollegeBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getName());
	                System.out.println(bean.getAddress());
	                System.out.println("state"+bean.getState());
	                System.out.println("city"+bean.getCity());
	                System.out.println(bean.getPhoneNo());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getCreatedDatetime());
	                System.out.println(bean.getModifiedBy());
	                System.out.println(bean.getModifiedDatetime());
	            }

	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }
		

	public static void testSearch(){
		try{
			CollegeBean bean=new CollegeBean();
			List list=new ArrayList();
			bean.setName("NIT");
			bean.setAddress("vijay nagar");
			list=model.search(bean, 1, 5);
			if(list.size()<0){
				System.out.println("Test Search Fail");
			}
			Iterator it=list.iterator();
			while(it.hasNext()){
				bean=(CollegeBean)it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getAddress());
				System.out.println("State :"+bean.getState());
				System.out.println("City :"+bean.getCity());
				System.out.println(bean.getPhoneNo());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
				
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}



	public static void testFindByPk() {
		// TODO Auto-generated method stub
		try {
			CollegeBean bean = new CollegeBean();
			long pk=1;
			bean= model.findByPK(5);
			if(bean==null){
				System.out.println("Test Find By Pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
            System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
		


	public static void testFindByName() {
		try{
			CollegeBean bean=model.findByName("Holkar");
			if(bean==null){
				System.out.println("Test Find By Name Fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}



}
        

