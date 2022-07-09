package in.co.rays.project4.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.MarksheetBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.model.MarksheetModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;

/**
 * @author bhupendra
 *
 */
@WebServlet(name="MarksheetMeritListCtl",urlPatterns={"/ctl/MarksheetMeritListCtl"})
public class MarksheetMeritListCtl extends BaseCtl {

	private static Logger log=Logger.getLogger(MarksheetMeritListCtl.class);
	
	
	/**
	 *populates bean object form reqest parameter
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("Marksheet merit list populate bean start");
		MarksheetBean bean=new MarksheetBean();
		return bean;
	}

	/**
     * Contains Display logics
     */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("MarksheetMeritListCtl doGet Start");
		System.out.println("doGet");
		
		int pageNo=1;
		int pageSize=DataUtility.getInt(PropertyReader.getValue("page.size"));
		
		MarksheetBean bean=(MarksheetBean)populateBean(request);
		String op=DataUtility.getString(request.getParameter("operation"));
		
		MarksheetModel model=new MarksheetModel();
		System.out.println("before try");
		List list=null;
		List next=null;
		try {
			list=model.getMeritList(pageNo, pageSize);
			ServletUtility.setBean(bean, request);
			if(list==null || list.size()==0)  {
				
				
				ServletUtility.setErrorMessage("No record found", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			System.out.println("before view");
			ServletUtility.forward(ORSView.MARKSHEET_MERIT_LIST_VIEW, request, response);  //getView()
			System.out.println("after view");
		}catch(Exception e){
			log.error(e);
			ServletUtility.handleException(e, request, response);
			e.printStackTrace();
		}
		log.debug("MarksheeetMeritListCtl doGet End");
		}

		/**
	     * Contains Submit logics
	     */
		@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			log.debug("MarksheetMeritListCtl doGet Start");
			System.out.println("doPost");
			List list=null;
			
			int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
			int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
			
			pageNo=(pageNo==0)?1:pageNo;
			pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
				
       MarksheetBean bean=(MarksheetBean)populateBean(request);
       String op=DataUtility.getString(request.getParameter("operation"));
       MarksheetModel model=new MarksheetModel();
       try {
    	   if(OP_BACK.equalsIgnoreCase(op)){
   			ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
   			return;
   		}
   		list=model.getMeritList(pageNo, pageSize);
   		ServletUtility.setList(list, request);
   		
   		if(list==null||list.size()==0){
   			ServletUtility.setErrorMessage("No Record Found", request);
   		}
   		ServletUtility.setList(list, request);
   		ServletUtility.setPageNo(pageNo, request);
   		ServletUtility.setPageSize(pageSize, request);
   		ServletUtility.forward(ORSView.MARKSHEET_MERIT_LIST_VIEW, request, response);
   	}catch(ApplicationException e){
   		log.error(e);
   		ServletUtility.handleException(e, request, response);
   		return;
   	}
   	log.debug("MarksheetMeritListCtl doPOst End");
   	}

   	@Override
	protected String getView() {
		
		return ORSView.MARKSHEET_MERIT_LIST_VIEW;
	}

}
