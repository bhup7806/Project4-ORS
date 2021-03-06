package in.co.rays.project4.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.model.RoleModel;
import in.co.rays.project4.model.UserModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * Servlet implementation class LoginCtl
 */
@WebServlet(name="LoginCtl",urlPatterns = {"/LoginCtl"} )
public class LoginCtl extends BaseCtl {
	
	public static final String OP_REGISTER = "Register";
	public static final String OP_SIGN_IN = "SignIn";
	public static final String OP_SIGN_UP = "SignUp";
	public static final String OP_LOG_OUT = "logout";

	
	private static Logger log = Logger.getLogger(LoginCtl.class);

	/**
	 * Validates input data entered by User.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {
		
		System.out.println("in validate method do start");

		log.debug("LoginCtl Method validate Started");
		boolean pass = true;

		String op = request.getParameter("operation");
		if (OP_SIGN_UP.equals(op) || OP_LOG_OUT.equals(op)) {
			return pass;
		}

		String login = request.getParameter("login");
		if (DataValidator.isNull(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.require", "Login Id"));
			pass = false;
		} 
			  else if (!DataValidator.isEmail(login)){
				  request.setAttribute("login", PropertyReader.getValue("error.email", "Login "));
		pass = false;
			  }
			 
		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
			pass = false;

		} 

		log.debug("LoginCtl Method validate Ended");
		return pass;

	}

	/**
	 * Populates bean object from request parameters.
	 *
	 * @param request the request
	 * @return the base bean
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("LoginCtl Method populatebean Started");
		
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));

		log.debug("LoginCtl Method populatebean Ended");
		return bean;
	}

	/**
	 * Display Logics inside this method.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		log.debug(" Method doGet Started");
		
		HttpSession session = request.getSession(true);

		String op = DataUtility.getString(request.getParameter("operation"));
	
		if (OP_LOG_OUT.equals(op)) {
		
			session = request.getSession();

			session.invalidate();
			
				ServletUtility.setSuccessMessage("Logout Successfully", request);
			}
			ServletUtility.forward(ORSView.LOGIN_VIEW, request, response);

			return;

		}


	/**
	 * Submit logic inside it.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.debug(" LoginCtl Method doPost Started");
		
		HttpSession session = request.getSession(true);

		String op = DataUtility.getString(request.getParameter("operation"));
		
		long id = DataUtility.getLong(request.getParameter("id"));
		
		UserModel model = new UserModel();
		RoleModel role = new RoleModel();

		UserBean bean = null;
		if (OP_SIGN_IN.equalsIgnoreCase(op)) {

			bean = (UserBean) populateBean(request);

			try {
				bean = model.authenticate(bean.getLogin(), bean.getPassword());

				String uri = (String) request.getParameter("uri");
				if (bean != null) {

					session.setAttribute("user", bean);

					long rollId = bean.getRoleId();
					
					RoleBean rolebean = role.findByPK(rollId);
	
					if (rolebean != null) {
						session.setAttribute("role", rolebean.getName());
					}

					if ("null".equalsIgnoreCase(uri)) {
						ServletUtility.forward(ORSView.WELCOME_VIEW, request, response);
						return;
					} else {
						
							ServletUtility.redirect(uri, request, response);
							return;
						} 

					}
				
				else {
					bean = (UserBean) populateBean(request);
					ServletUtility.setBean(bean, request);
					ServletUtility.setErrorMessage("Invalid LoginId And Password", request);
				}

				}

			 catch (Exception e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_SIGN_UP.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
			return;

		}

		ServletUtility.forward(getView(), request, response);

		log.debug("UserCtl Method doPost Ended");
		

	}


    /**
	 * Returns the VIEW page of this Controller.
	 *
	 * @return the view
	 */
	@Override
	protected String getView() {

		System.out.println(" LoginCtl getView");
		return ORSView.LOGIN_VIEW;
	}

}