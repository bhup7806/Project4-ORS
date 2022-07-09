package in.co.rays.project4.bean;

/**
 *  College JavaBean encapsulates College attributes
 * @author bhupendrapatidar
 *
 */
public class CollegeBean extends BaseBean {
	
	/**
	 * Name of College
	 */
	private String name;
	/**
	 *  Address of College
	 */
	private String address;
	/**
	 *  State of College
	 */
	private String state;
	/**
	 * City of College
	 */
	private String city;
	/**
	 *  Phoneno of College
	 */
	private String phoneNo;
	/**
	 *  accessor
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

