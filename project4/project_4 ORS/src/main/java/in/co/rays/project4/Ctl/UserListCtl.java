package in.co.rays.project4.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.model.RoleModel;
import in.co.rays.project4.model.UserModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;


/**
 *  user list funcitonality controller.to perform search and show operation
 * @author bhupendrapatidar
 *
 */
@WebServlet(name="UserListCtl",urlPatterns={"/ctl/UserListCtl"})
public class UserListCtl extends BaseCtl{

	private static Logger log=Logger.getLogger(UserListCtl.class);

	protected void preload(HttpServletRequest request) {
		
		RoleModel model=new RoleModel();
		
		try {
			List list = model.List();
			request.setAttribute("roleList", list);

		} catch (Exception e) {
			log.error(e);
			
		}
		
		
	}

	
	/**
	 *populates bean object form reqest parameter
	 */
	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
        bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setRoleId(DataUtility.getLong(request.getParameter("roleId")));
		populateDTO(bean, request);
		return bean;
	}
	
	/**
	 * Contains Display logics
	 */
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("UserListCtl doGet Start");
		
		List list =null;
		List next=null;
		
		
		int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize=(DataUtility.getInt(request.getParameter("pageSize")));
		
		pageNo=(pageNo==0)?1:pageNo;
		pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
		
        UserBean bean=(UserBean)populateBean(request);
        
        String op=DataUtility.getString(request.getParameter("operation"));
        String[] ids=request.getParameterValues("ids");
        UserModel model=new UserModel();
        try {
        	
        	list=model.search(bean, pageNo, pageSize);
        	if(list==null||list.size()==0){
				ServletUtility.setErrorMessage("No record found", request);
				
			}if(list==null||list.size()==0){
				request.setAttribute("nextListSize", 0);
				
			}else{
				request.setAttribute("nextListSize", list.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
			
		}catch(ApplicationException e){
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("UserListCtl doGet End");
	}
	
	/**
	 * Contains Submit logics
	 */
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("UserListCtl doPost start");
		
		List list=null;
		List next=null;
		
		int pageNO=DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
		

		pageNO=(pageNO==0)?1:pageNO;
		pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
		
		UserBean bean =(UserBean) populateBean(request);
		String op=DataUtility.getString(request.getParameter("operation"));
		
       String[]  ids=request.getParameterValues("ids");
       
       UserModel model=new UserModel();
       try {
    	   if(OP_SEARCH.equalsIgnoreCase(op)||OP_NEXT.equalsIgnoreCase(op)||OP_PREVIOUS.equalsIgnoreCase(op)){
				
				if(OP_SEARCH.equalsIgnoreCase(op)){
					pageNO=1;
				}else if(OP_NEXT.equalsIgnoreCase(op)){
					pageNO++;
				}else if(OP_PREVIOUS.equalsIgnoreCase(op)&&pageNO>1){
					pageNO--;
				}
			}else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.USER_CTL, request, response);
				return;
			}else if(OP_NEXT.equalsIgnoreCase(op)){
				ServletUtility.redirect(ORSView.USER_CTL, request, response);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;
			}else if (OP_DELETE.equalsIgnoreCase(op)) {
						if(ids !=null && ids.length >0)   {
							
						UserBean deletebean = new UserBean();
						for(String id : ids)  {
							
							deletebean.setId(DataUtility.getInt(id));
							model.delete(deletebean);
							ServletUtility.setSuccessMessage("data deleted successfully", request);
								
						}
						
						}else {
							
					ServletUtility.setErrorMessage("select at least one record", request);
					
						}
	
			}if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;	
			}
			bean = (UserBean) populateBean(request);
			list=model.search(bean, pageNO, pageSize);
			ServletUtility.setList(list, request);
			if(list==null||list.size()==0&&!OP_DELETE.equalsIgnoreCase(op)){
				ServletUtility.setErrorMessage("No record found", request);
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", "0");
			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setBean(bean, request);
			ServletUtility.setPageNo(pageNO, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		
		}catch(ApplicationException e){
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
	log.debug("UserListCtl doGet End");
}

     
	@Override
	protected String getView() {
	
		return ORSView.USER_LIST_VIEW;
		
	}

}
