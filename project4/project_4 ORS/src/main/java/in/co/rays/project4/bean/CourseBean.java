package in.co.rays.project4.bean;

/**
 * course JavaBean encapsulates course attributes
 * @author bhupendrapatidar
 *
 */
public class CourseBean extends  BaseBean {
	/**
	 * name of course
	 */
	private String courseName;
	
	/**
	 * name of description
	 */
	private String description;
	
	/**
	 * name of duration
	 */
	private String duration;
	
	
	/**
	 * accessor
	 */
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getkey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getvalue() {
		// TODO Auto-generated method stub
		return courseName;
	}
	
	
}
	


