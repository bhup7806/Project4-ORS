package in.co.rays.project4.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * @author bhupendrapatidar
 *
 */
public class DuplicateRecordException extends Exception {
	

	/**
	 * @param msg
	 * error msg
	 */
	public DuplicateRecordException(String msg){
		super(msg);
	}

}


