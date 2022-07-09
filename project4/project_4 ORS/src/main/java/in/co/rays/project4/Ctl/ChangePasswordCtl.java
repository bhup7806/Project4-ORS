package in.co.rays.project4.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.RecordNotFoundException;
import in.co.rays.project4.model.UserModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;


/**
 *  change password operation functionality perform
 * @author bhupendrapatidar
 *
 */
@WebServlet(name="ChangePasswordCtl",urlPatterns={"/ctl/ChangePasswordCtl"})
public class ChangePasswordCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(ChangePasswordCtl.class);
	
	protected boolean validate(HttpServletRequest request) {
		
		log.debug("ChangePasswordCtl Method validate Started");
		System.out.println("validate of changepassword");
		boolean pass=true;
		String op =request.getParameter("operation");
	
		if(OP_CHANGE_MY_PROFILE.equalsIgnoreCase(op)){
			return pass;
		}
		if(DataValidator.isNull(request.getParameter("oldPassword"))){
			request.setAttribute("oldPassword",PropertyReader.getValue("error.require","Old Password"));
			pass=false;
		}else if (!DataValidator.isPassword(request.getParameter("oldPassword"))) {
			request.setAttribute("oldPassword", "Please Enter valid Password");
			pass = false;
		}
		if(DataValidator.isNull(request.getParameter("newPassword"))){
			request.setAttribute("newPassword",PropertyReader.getValue("error.require","New Password"));
			pass=false;
		}else if (!DataValidator.isPassword(request.getParameter("newPassword"))) {
			request.setAttribute("newPassword", "Please Enter vaild Password");
			pass = false;
		}
		if(DataValidator.isNull(request.getParameter("confirmPassword"))){
			request.setAttribute("confirmPassword",PropertyReader.getValue("error.require","Confirm Password"));
			pass=false;
		}
		if(!request.getParameter("newPassword").equals
				(request.getParameter("confirmPassword"))&&!"".equals(request.getParameter("confirmPassword"))){
			ServletUtility.setErrorMessage("New and confirm passwords not matched", request);
			pass=false;
		}
		log.debug("ChangePasswordCtl Method validate Ended");
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("ChangePasswordCtl Method populatebean Started");
		
		UserBean bean = new UserBean();
		bean.setPassword(DataUtility.getString(request.getParameter("oldPassword")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("oldPassword")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		populateDTO(bean,request);
		log.debug("ChangePasswordCtl Method populatebean Ended");
		return bean;
		
	}
	/**
     * Display Logics inside this method
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   ServletUtility.forward(getView(), request, response);
   
	}

	/**
     * Submit logic inside it
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession session=request.getSession(true);
log.debug("ChangePasswordCtl Method doPost Started");

String op=DataUtility.getString(request.getParameter("operation"));

UserModel model=new UserModel();
UserBean bean=(UserBean)populateBean(request);
UserBean userBean=(UserBean)session.getAttribute("user");


String newPassword=request.getParameter("newPassword");
String oldPassword=request.getParameter("oldPassword");
long id =userBean.getId();

if(OP_SAVE.equalsIgnoreCase(op)) {
	
	try {
		
		boolean flag=model.changePassword(id, oldPassword, newPassword);
				
				if(flag==true){
					model.findByLogin(userBean.getLogin());
					session.setAttribute("user",bean);
					ServletUtility.setSuccessMessage("Password has been changed Successfully", request);
					
				}		
			}catch(ApplicationException e){
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}catch(RecordNotFoundException e){
				ServletUtility.setErrorMessage("Old Password is invalide", request);
				
			}
		}else if(OP_CHANGE_MY_PROFILE.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.MY_PROFILE_CTL, request, response);
			return;
		}
		ServletUtility.forward(ORSView.CHANGE_PASSWORD_VIEW, request, response);
		log.debug("ChangePasswordCtl Method doGet Ended");
	}	

	@Override
	protected String getView() {


		return ORSView.CHANGE_PASSWORD_VIEW;
	}

}
