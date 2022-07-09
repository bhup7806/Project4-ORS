package in.co.rays.project4.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.model.CollegeModel;
import in.co.rays.project4.model.StudentModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Student List functionality Controller. Performs operation for list, search
 * and delete operations of Student
 * @author bhupendra
 *
 */
@WebServlet(name="StudentListCtl",urlPatterns={"/ctl/StudentListCtl"})
public class StudentListCtl extends BaseCtl {
       
	private static Logger log=Logger.getLogger(StudentListCtl.class);

	protected void preload(HttpServletRequest request) {
		CollegeModel model=new CollegeModel(); 
		try {
			List list=model.list();
			request.setAttribute("collegeList", list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
			
		/**
		 *populates bean object form reqest parameter
		 */
		@Override
		protected BaseBean populateBean(HttpServletRequest request) {
			
			StudentBean bean=new StudentBean();
			bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
			bean.setEmail(DataUtility.getString(request.getParameter("email")));
			bean.setCollegeId(DataUtility.getLong(request.getParameter("collegeId")));
			populateDTO(bean, request);
			return bean;
		}
		
		/**
	     * Contains Display logics
	     */	
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	log.debug("StudentListCtl Method doPost Started");
	
	List list = null;
	List next = null;
	
	int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
	int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
	
	pageNo=(pageNo==0)?1:pageNo;
	pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
	
	StudentBean bean=(StudentBean) populateBean(request);
	
	StudentModel model=new StudentModel();
	try {
		list = model.search(bean, pageNo, pageSize);
		ServletUtility.setList(list, request);
		next = model.search(bean, pageNo+1, pageSize);
	} catch (ApplicationException e) {
		log.error(e);
		ServletUtility.handleException(e, request, response);
		return;
		}

	if (list == null || list.size() == 0) {
	ServletUtility.setErrorMessage("No record found ", request);
	}if(next==null||next.size()==0){
	request.setAttribute("nextListSize", 0);

	}else{
		request.setAttribute("nextListSize", next.size());
		}
		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);

	log.debug("StudentListCtl doGet End");
}

 /**
 * Contains Submit logics
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("StudentListCtl Method doPost Started");
		
		List list=null;
		List next=null;
		int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
		
		pageNo=(pageNo==0)?1:pageNo;
		pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
		
		StudentBean bean=(StudentBean)populateBean(request);
		String op=DataUtility.getString(request.getParameter("operation"));
		
		String[] ids=request.getParameterValues("ids");
		
		StudentModel model=new StudentModel();
		
		try{
			if(OP_SEARCH.equalsIgnoreCase(op)||OP_NEXT.equalsIgnoreCase(op)||OP_PREVIOUS.equalsIgnoreCase(op)){
				
				if(OP_SEARCH.equalsIgnoreCase(op)){
					pageNo=1;
				}else if(OP_NEXT.equalsIgnoreCase(op)){
					 pageNo++; 	
				}else if(OP_PREVIOUS.equalsIgnoreCase(op)&&pageNo>1){
					pageNo--;
				}
			}else if (OP_NEW.equalsIgnoreCase(op)) {
                ServletUtility.redirect(ORSView.STUDENT_CTL, request,
                        response);
                return;
            } else if (OP_RESET.equalsIgnoreCase(op)) {
    			ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
    			return;
    		}else if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
				return;
			}
			else if(OP_NEXT.equalsIgnoreCase(op)){
				ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
				return;
			}else if(OP_DELETE.equalsIgnoreCase(op)){
				
			if(ids!=null&&ids.length>0){
				StudentBean deletebean=new StudentBean();
				for(String id:ids){
					deletebean.setId(DataUtility.getInt(id));
					try {
						model.delete(deletebean);
					} catch (Exception e) {
						e.printStackTrace();
					}
					ServletUtility.setSuccessMessage("Data Delete Successfully", request);
				}
			}else{
				ServletUtility.setErrorMessage("Select at leat one record", request);
			}
		}
		bean = (StudentBean) populateBean(request);	
		list=model.search(bean, pageNo, pageSize);
		ServletUtility.setList(list, request);
		next = model.search(bean, pageNo+1, pageSize);
        ServletUtility.setList(list, request);
        
		if(list==null||list.size()==0&&!OP_DELETE.equalsIgnoreCase(op)){
			ServletUtility.setErrorMessage("No record found", request);
		}if(next==null||next.size()==0){
			request.setAttribute("nextListSize", 0);
			
		}else{
			request.setAttribute("nextListSize", next.size());
		}
		ServletUtility.setList(list, request);
		ServletUtility.setBean(bean, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request,response);
	
	}catch(ApplicationException e){
		log.error(e);
	
		ServletUtility.handleException(e, request, response);
	return;
	}		log.debug("StudentListCtl doPost end");
	}
	@Override
	protected String getView() {
	
		return ORSView.STUDENT_LIST_VIEW;
		
	}

}
