package in.co.rays.project4.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project4.util.ServletUtility;


/**
 * Error functionality controller.perform error page operation
 * @author bhupendrapatidar
 *
 */
@WebServlet(name="ErrorCtl", urlPatterns={"/ErrorCtl"})
public class ErrorCtl extends BaseCtl {
	
	private static Logger log=Logger.getLogger(ErrorCtl.class);
	
	 /**
     * Concept of Display logic
     *
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug( "error ctl do get started");
		ServletUtility.forward(getView(), request, response);
		log.debug(" error ctl do get end");
	}
	 /**
     * Concept of submit logic
     *
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 log.debug("error ctl do post started");
		  ServletUtility.forward(getView(), request, response);
		 
		   log.debug("error ctl do post end");
		 }

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ERROR_VIEW;
		
	}

}
