package in.co.rays.project4.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.UserModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Servlet implementation class UserRegistrationCtl
 */
@ WebServlet(name="UserRegistrationCtl",urlPatterns={"/UserRegistrationCtl"})
public class UserRegistrationCtl extends BaseCtl {

	public static final String OP_SIGN_UP="SignUp";
	
	private static Logger log=Logger.getLogger(UserRegistrationCtl.class);
	
protected boolean validate(HttpServletRequest request) {
	
	System.out.println("in validate method");
	
	log.debug("UserRegistrationCtl Method Validate Started");
	
	boolean pass=true;
	
	String login=request.getParameter("login");
	String dob=request.getParameter("dob");
	
	if(DataValidator.isNull(request.getParameter("firstName"))){
		request.setAttribute("firstName",PropertyReader.getValue("error.require","First Name"));
		pass=false;	
	}else if (!DataValidator.isName(request.getParameter("firstName"))) {
		request.setAttribute("firstName", "please enter correct Name");
		pass = false;
	}
	if(DataValidator.isNull(request.getParameter("lastName"))){
		request.setAttribute("lastName",PropertyReader.getValue("error.require","Last Name"));
		pass=false;
		
	}else if (!DataValidator.isName(request.getParameter("lastName"))) {
		request.setAttribute("lastName", "please enter correct Name");
		pass = false;
	}
	if(DataValidator.isNull(login)){
		request.setAttribute("login",PropertyReader.getValue("error.require","Login Id"));
		pass=false;
	}else if(!DataValidator.isEmail(login)){
		request.setAttribute("login",PropertyReader.getValue("error.require","Login"));
		pass=false;
		
	}if(DataValidator.isNull(request.getParameter("password"))){
		request.setAttribute("password",PropertyReader.getValue("error.require","Password"));
		pass=false;
	}else if (!DataValidator.isPasswordLength(request.getParameter("password"))) {
		request.setAttribute("password", "Password should be 8 to 12 characters");
		pass = false;
	} else if (!DataValidator.isPassword(request.getParameter("password"))) {
		request.setAttribute("password", "Password Must contain uppercase, lowercase, digit & special character");
		pass = false;
	}
	
	if(DataValidator.isNull(request.getParameter("confirmPassword"))){
		request.setAttribute("confirmPassword",PropertyReader.getValue("error.require","Confirm Password"));
		pass=false;
		
	}
	if(DataValidator.isNull(request.getParameter("gender"))){
		request.setAttribute("gender",PropertyReader.getValue("error.require","Gender"));
		pass=false;
		
	}if (DataValidator.isNull(request.getParameter("mobile"))) {
		request.setAttribute("mobile", PropertyReader.getValue("error.require", "Mobile"));
		pass = false;
	} else if (!DataValidator.isPhoneNo(request.getParameter("mobile"))) {
		request.setAttribute("mobile", "Please Enter Valid Mobile Number");
		pass = false;
	}
	
	if(DataValidator.isNull(request.getParameter("dob"))){
		request.setAttribute("dob",PropertyReader.getValue("error.require","Date Of Birth"));
		pass=false;
		
	}
	else if(!DataValidator.isDate(dob)){
		request.setAttribute("dob",PropertyReader.getValue("error.date","Date of Birth"));
		pass=false;
	}else if (!DataValidator.isValidAge(dob)) {
		request.setAttribute("dob", "Age Must be greater then 18 year");
		pass = false;
	}
	if(!request.getParameter("password").equals(request.getParameter("confirmPassword"))&&!"".equals(request.getParameter("confirmPassword"))){
		ServletUtility.setErrorMessage("Confirm password not matched", request);
		pass=false;
	
	}
		log.debug("UserRegistratioCtl Method validate Ended");
		return pass;
	}
	
protected BaseBean populateBean(HttpServletRequest request) {
	
	log.debug("UserRegistrationCtl Method populatebean Started");
	
	UserBean bean = new UserBean();
	
	bean.setId(DataUtility.getLong(request.getParameter("id")));
	bean.setRoleId(RoleBean.STUDENT);
	bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
	bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
	bean.setLogin(DataUtility.getString(request.getParameter("login")));
	bean.setPassword(DataUtility.getString(request.getParameter("password")));
	bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
	bean.setGender(DataUtility.getString(request.getParameter("gender")));
	bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));
	bean.setDob(DataUtility.getDate(request.getParameter("dob")));
	
	populateDTO(bean,request);
	log.debug("UserRegistrationCtl Method populatebean Ended");
	return bean;
}

/**
 * Display concept of user registration
 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		log.debug("UserRegistrationCtl Method doGet Started");
		ServletUtility.forward(getView(),request,response);
		
	}
/**
* Submit concept of user registration
*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("UserRegistrationCtl Method doPost Started");
		
		String op=DataUtility.getString(request.getParameter("operation"));
		
		long id=DataUtility.getLong(request.getParameter("id"));

		UserModel model= new UserModel();

		if(OP_SIGN_UP.equalsIgnoreCase(op)){
			UserBean bean=(UserBean)populateBean(request);
			try {
				
				long pk=model.registerUser(bean);
				bean.setId(pk);
				request.getSession().setAttribute("UserBean", bean);
		ServletUtility.setSuccessMessage("Registration done SuccessFully", request);
		ServletUtility.forward(ORSView.LOGIN_VIEW, request, response);
		
			}catch(DuplicateRecordException e){
				log.error(e);
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			

			}catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
	
			
		}else if (OP_RESET.equalsIgnoreCase(op)) {
			
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("UserRegistrationCtl Method doPost Ended");
	}
	@Override
	protected String getView() {
		return ORSView.USER_REGISTRATION_VIEW;
	}	
		
	}

