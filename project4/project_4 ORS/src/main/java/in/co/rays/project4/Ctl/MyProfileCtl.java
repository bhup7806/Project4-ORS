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
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.UserModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Myprofile functionality controller.to perform update profile operation and
 * show profile
 * @author bhupendrapatidar
 *
 */
@WebServlet(name = "MyProfileCtl", urlPatterns = { "/ctl/MyProfileCtl" })
public class MyProfileCtl extends BaseCtl {

	public static final String OP_CHANGE_MY_PASSWORD = "ChangePassword";

	private static Logger log = Logger.getLogger(MyProfileCtl.class);

	@Override
       protected boolean validate(HttpServletRequest request) {
		
		log.debug("MyProfileCtl Method validate Started");
		System.out.println("MyProfileCtl Method validate Started");
		
		boolean pass=true;
		
		String op = DataUtility.getString(request.getParameter("operation"));
		
		if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(op) || op == null) {

			return pass;
			
	}
	
		if (DataValidator.isNull(request.getParameter("firstName"))) {
			System.out.println("firstName" + request.getParameter("firstName"));
			request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "please enter correct Name");
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "please enter correct Name");
			pass = false;

		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "MobileNo"));
			pass = false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Please Enter Valid Mobile Number");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Date Of Birth"));
			pass = false;
		} else if (!DataValidator.isDate(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.date", "Date Of Birth"));
			pass = false;
		} else if (!DataValidator.isValidAge(request.getParameter("dob"))) {
			request.setAttribute("dob", "Age Must be greater then 18 year");
			pass = false;
		}

		log.debug("MyProfileCtl Method validate Ended");

		return pass;

	}
	
	/**
	 *populates bean object form reqest parameter
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		
		log.debug("MyProfileCtl Method populatebean Started");
		System.out.println("MyProfileCtl Method populatebean Started");
		
		UserBean bean = new UserBean();
		

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setLogin(DataUtility.getString(request.getParameter("login")));

		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));

		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));

		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		bean.setGender(DataUtility.getString(request.getParameter("gender")));

		bean.setDob(DataUtility.getDate(request.getParameter("dob")));

		populateDTO(bean, request);

		return bean;
	}

	/**
	 * Display Concept for viewing profile page view
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   HttpSession session = request.getSession(true);
   log.debug("MyprofileCtl Method doGet Started");

	
	UserBean userBean = (UserBean) session.getAttribute("user");
	long id = userBean.getId();
	
	String op=DataUtility.getString(request.getParameter("operation"));
	
	System.out.println("---- doget in myprofile"+userBean.getId());
	// get model
	
	UserModel model = new UserModel();
	if( id>0 || op != null)   {
		UserBean bean;
		try {
			bean = model.findByPK(id);
			ServletUtility.setBean(bean, request);
			
		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
	}
	ServletUtility.forward(getView(), request, response);

	log.debug("MyProfileCtl Method doGet Ended");
}

/**
 * Submit Concept
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		log.debug("MyprofileCtl Method doPost Started");
		
		UserBean userBean = (UserBean)session.getAttribute("user");
		long id = userBean.getId();
		String op = DataUtility.getString(request.getParameter("operation"));
		
		UserModel model = new UserModel();
		
		if (OP_SAVE.equalsIgnoreCase(op))  {
		UserBean bean = (UserBean)populateBean(request);
		try {
			
			if(id>0) {
				
				userBean.setFirstName(bean.getFirstName());
		        userBean.setLastName(bean.getLastName()); 
				userBean.setGender(bean.getGender());
				userBean.setMobileNo(bean.getMobileNo());
				userBean.setDob(bean.getDob());
				model.update(userBean);

			}
			ServletUtility.setBean(bean, request);
			ServletUtility.setSuccessMessage("Profile has been updated Successfully. ", request);
		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		} catch (DuplicateRecordException e) {
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage("Login id already exists", request);
		}
	} else if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(op)) {

		ServletUtility.redirect(ORSView.CHANGE_PASSWORD_CTL, request, response);
		return;

	}

		ServletUtility.forward(getView(), request, response);
		System.out.println("MYProfileCtl method dopost");
		log.debug("MYProfileCtl Method dopost ended ");
	}
	
	@Override
	protected String getView() {
	
		return ORSView.MY_PROFILE_VIEW;
		
	}

}
