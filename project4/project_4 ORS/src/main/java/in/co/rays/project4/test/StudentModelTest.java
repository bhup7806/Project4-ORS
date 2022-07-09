package in.co.rays.project4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.StudentModel;

/**
 * @author bhupendra
 *
 */
public class StudentModelTest {
	 
   public static StudentModel model = new StudentModel();
   
	public static void main(String[] args) throws Exception{

           
		    //testAdd(); 
           //testfindBypk();
          //  testdelete();
              // testUpdate();
		     // TestList();
		      testsearch();
		     // testFindByEmailId(); 
		      
		      
             
}
	
public static void testAdd() throws ParseException{
		
		StudentBean bean=new StudentBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		
		try{
		bean.setId(1);
		bean.setFirstName("Ajay");
		bean.setLastName("Singh");
		bean.setDob(sdf.parse("01/01/2000"));
		bean.setMobileNo("9087654567");
		bean.setEmail("pavan@gmail.com");
		bean.setCollegeId(2L);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		long pk=model.add(bean);
		StudentBean addedbean=model.findByPK(pk);
		if(addedbean==null){
			System.out.println("Test add fail");
		}
		}catch(ApplicationException e){
			e.printStackTrace();
			
		}catch(DuplicateRecordException ex){
			ex.printStackTrace();
		}
	}


public static void testUpdate(){
	try{
		StudentBean bean=model.findByPK(1L);
		bean.setCollegeId(2L);
		bean.setFirstName("krishna");
		bean.setLastName("pal");
		model.update(bean);
		StudentBean updatebean=model.findByPK(1L);
		
		if(!"krishna".equals(updatebean.getFirstName())){
			System.out.println("Test update fail");
		}
		
	}catch(ApplicationException e){
		e.printStackTrace();
	}catch(DuplicateRecordException ex){
		ex.printStackTrace();
	}
}

	public static void testFindByEmailId() {
		// TODO Auto-generated method stub
	
			try{
				StudentBean bean=new StudentBean();
				bean=model.findByEmailId("ajay@gmail.com");
				if(bean!=null){
					System.out.println("Test findBy Email id fail");
				}
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getDob());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getEmail());
				System.out.println(bean.getCollegeId());
				
			}catch(ApplicationException e){
				e.printStackTrace();
			}
		}
	

	public static void testsearch() {
	
			try{
				StudentBean bean=new StudentBean();
				
				List list=new ArrayList();
				bean.setFirstName("ajay");
				list=model.search(bean,0,0);
				if(list.size()<0){
					System.out.println("Test search fail");
				}
				Iterator it=list.iterator();
				while(it.hasNext()){
					bean=(StudentBean)it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getDob());
					System.out.println(bean.getMobileNo());
					System.out.println(bean.getEmail());
					System.out.println(bean.getCollegeId());
					
				}
				
			}catch(ApplicationException e){
				e.printStackTrace();
			}
		
		
		
	}

	public static void TestList() {
			try{
				StudentBean bean=new StudentBean();
				List list=new ArrayList();
				list=model.list(1,10);
				if(list.size()<0){
					System.out.println("test list fail");
				}
				
				Iterator it=list.iterator();
				while(it.hasNext()){
					bean=(StudentBean)it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getDob());
					System.out.println(bean.getMobileNo());
					System.out.println(bean.getEmail());
					System.out.println(bean.getCollegeId());
					System.out.println(bean.getCreatedBy());
					System.out.println(bean.getCreatedDatetime());
					System.out.println(bean.getModifiedBy());
					System.out.println(bean.getModifiedDatetime());
				}
			}catch(ApplicationException e){
				e.printStackTrace();
			}
		}



	public static void testdelete() throws Exception {
		try {
			StudentBean bean = new StudentBean();
			long pk= 15L;
			bean.setId(pk);
			model.delete(bean);
			
			StudentBean deletedbean=model.findByPK(pk);
			if(deletedbean!=null){
				System.out.println("Test delete fail");
			}
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testfindBypk() {
	
		try {
			StudentBean bean = new StudentBean();
			long pk=2L;
			bean=model.findByPK(pk);
			if (bean==null) {
				System.out.println("test find by pk fail");
			}
			
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCollegeId());
		
		}catch(ApplicationException e){
			e.printStackTrace();
		}
		}
		
	

}
