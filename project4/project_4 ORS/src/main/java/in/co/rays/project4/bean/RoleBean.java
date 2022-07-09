package in.co.rays.project4.bean;

/**
 *  Role JavaBean encapsulates Role attributes
 * @author bhupendrapatidar
 *
 */
public class RoleBean extends BaseBean {

	/**
	 * predefined role
	 */
	public static final int ADMIN=1;
	public static final int STUDENT=2;
	public static final int COLLEGE_SCHOOL=3;
	public static final int KIOSK=4;
	
	/**
	 * role name
	 */
	public String name;
	
	/**
	 * role description
	 */
	public String description;
	
	/**
	 * accessor
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	public String getkey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getvalue() {
		// TODO Auto-generated method stub
		return name;
	}

	
}
