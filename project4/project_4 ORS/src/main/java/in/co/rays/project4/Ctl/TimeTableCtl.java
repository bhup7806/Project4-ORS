package in.co.rays.project4.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.w3c.dom.stylesheets.LinkStyle;

import in.co.rays.project4.bean.BaseBean;
import in.co.rays.project4.bean.TimeTableBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CourseModel;
import in.co.rays.project4.model.SubjectModel;
import in.co.rays.project4.model.TimeTableModel;
import in.co.rays.project4.util.DataUtility;
import in.co.rays.project4.util.DataValidator;
import in.co.rays.project4.util.PropertyReader;
import in.co.rays.project4.util.ServletUtility;


/**
 * @author bhupendra
 *
 */
@WebServlet(name = "TimeTableCtl", urlPatterns = { "/ctl/TimeTableCtl" })
public class TimeTableCtl extends BaseCtl {
	
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(TimeTableCtl.class);
	
	protected void preload(HttpServletRequest request) {
	CourseModel cmodel= new CourseModel();
	SubjectModel smodel= new SubjectModel();
	try {
		
		List clist=cmodel.list();
		List slist=smodel.list();
		
		request.setAttribute("courselist", clist);
		request.setAttribute("subjectlist", slist);
	} catch (Exception e) {
		log.error(e);
		e.printStackTrace();
	}

}
	protected boolean validate(HttpServletRequest request) {

		log.debug("TimeTableCtl Method validate Started");
		System.out.println("TimeTableCtl Method validate Started");
		boolean pass = true;

		String examDate = request.getParameter("examDate");

		if (DataValidator.isNull(request.getParameter("courseId"))) {
			request.setAttribute("courseId", PropertyReader.getValue("error.require", "course Name"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("subjectId"))) {
			request.setAttribute("subjectId", PropertyReader.getValue("error.require", "subject Name"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("semesterId"))) {
			request.setAttribute("semesterId", PropertyReader.getValue("error.require", "semester"));
			pass = false;

		}
		if (DataValidator.isNull(examDate)) {
			request.setAttribute("examDate", PropertyReader.getValue("error.require", "Exam Date"));
			pass = false;
		} else if (!DataValidator.isDate(examDate)) {
			request.setAttribute("examDate", PropertyReader.getValue("error.date", "Exam Date"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("examId"))) {
			request.setAttribute("examId", PropertyReader.getValue("error.require", "exam Time"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		log.debug("TimeTableCtl Method validate Ended");
		return pass;
	}
	
	/**
	 *populates bean object form reqest parameter
	 */
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("TimeTableCtl Method populatebean Started");
		System.out.println("TimeTableCtl Method populatebean Started");
		TimeTableBean bean = new TimeTableBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setSubName(DataUtility.getString(request.getParameter("subName")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		bean.setSemester(DataUtility.getString(request.getParameter("semesterId")));
		bean.setCourseId(DataUtility.getLong(request.getParameter("courseId")));
		bean.setSubId(DataUtility.getLong(request.getParameter("subjectId")));
		bean.setExamDate(DataUtility.getDate(request.getParameter("examDate")));
		bean.setExamTime(DataUtility.getString(request.getParameter("examId")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		populateDTO(bean, request);
		log.debug("TimeTableCtl Method populatebean Ended");
		return bean;

	}

	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("TimeTablectl do get started");
		String op = DataUtility.getString(request.getParameter("operation"));

		TimeTableModel model = new TimeTableModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {
			TimeTableBean bean;
			try {
				bean = model.findByPK(id);
				ServletUtility.setBean(bean, request);

			} catch (ApplicationException e) {
				log.error(e);
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;

			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("TimeTablectl do get end");
	}

	/**
	 * Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		log.debug("TimeTablectl Method doPost Started");
		System.out.println("TimeTablectl Method doPost Started");
		String op = DataUtility.getString(request.getParameter("operation"));

		TimeTableModel model = new TimeTableModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println(id + "-----------------------------------");
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			TimeTableBean bean = (TimeTableBean) populateBean(request);
			try {

				if (id > 0) {
					model.update(bean);
					System.out.println("update ----------------");

					ServletUtility.setBean(bean, request);

					ServletUtility.setSuccessMessage("Data is successfully update", request);

				} else {
					long pk;
							pk = model.add(bean);
							bean.setId(pk);
							ServletUtility.setSuccessMessage("Data is successfully saved", request);

				}
	    	}catch (Exception e) {
	    	  e.printStackTrace();	
			}
	    }else if(OP_DELETE.equalsIgnoreCase(op)) {
	    	 TimeTableBean deletebean=(TimeTableBean)populateBean(request);
	    	try {
	    		
	    		model.delete(deletebean);
	    		ServletUtility.setSuccessMessage("Data successfully deleted", request);
	    		ServletUtility.redirect(ORSView.TIMETABLE_CTL, request, response);
	    		return;
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    }else if(OP_CANCEL.equalsIgnoreCase(op)) {
	    	ServletUtility.redirect(ORSView.TIMETABLE_CTL, request, response);
	    	return;
	    }else if(OP_RESET.equalsIgnoreCase(op)) {
	    	ServletUtility.redirect(ORSView.TIMETABLE_LIST_CTL, request, response);
	    	return;
	    }
	       ServletUtility.forward(getView(), request, response);
	       log.debug("TimeTableCtl Method doPost Ended");
	}
	
	
	@Override
	protected String getView() {
		
		return ORSView.TIMETABLE_VIEW;
	}	
		
	
		
	}


	