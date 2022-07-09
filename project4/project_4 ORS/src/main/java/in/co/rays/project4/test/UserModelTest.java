
package in.co.rays.project4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.exception.RecordNotFoundException;
import in.co.rays.project4.model.UserModel;

/**
 * @author bhupendra
 *
 */
public class UserModelTest {

	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception, DuplicateRecordException {

		 testadd();
		// testDelete();
		// testUpdate();
		// testFindByPK();
		// testfindByLogin();
		// testSearch();
		//testGetRoles();
		// testlist();
		// testAuthenticate();
		// testRegisterUser();//////
		// testchangePassword();//////
		// testforgetPassword();//////

	}

	public static void testforgetPassword() {
		try {
			boolean b = model.forgetPassword("ashish@gmail.com");

			System.out.println("Suucess : Test Forget Password Success");

		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testchangePassword() throws RecordNotFoundException, ApplicationException {

		model.changePassword(1L, "1234", "123456");
		System.out.println("password has been change successfully");

	}

	public static void testRegisterUser() throws ParseException {

		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			// bean.setId(1L);
			bean.setFirstName("vivek");
			bean.setLastName("patidar");
			bean.setLogin("vivek@gmail.com");
			bean.setPassword("vivek");
			bean.setConfirmPassword("vivek");
			bean.setDob(sdf.parse("02/01/2002"));
			bean.setGender("Male");
			bean.setMobileNo("9070305256");
			bean.setRoleId(2);

			long pk = model.registerUser(bean);

			System.out.println("Successfully register");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			UserBean registerbean = model.findByPK(pk);
			if (registerbean != null) {
				System.out.println("Test registation fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testAuthenticate() {
		// TODO Auto-generated method stub
		try {
			UserBean bean = new UserBean();
			bean.setLogin("jay@gmail.com");
			bean.setPassword("1234");
			bean = model.authenticate(bean.getLogin(), bean.getPassword());
			if (bean != null) {
				System.out.println("Successfully login");

			} else {
				System.out.println("Invalied login Id & password");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testlist() {
		// TODO Auto-generated method stub
		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfullLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testGetRoles() {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel u = new UserModel();
		List list = new ArrayList();
		bean.setRoleId(1);
		try {
			list = model.getRoles(bean);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list.size() < 0) {
			System.out.println("Test get Roles fails");
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfullLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}

	}

	public static void testSearch() {

		try {
			System.out.println("in search of test");
			UserBean bean = new UserBean();
			List list = new ArrayList();
//			bean.setFirstName("jay");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("test search fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println("Role : "+bean.getRoleId());
				System.out.println(bean.getUnSuccessfullLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testfindByLogin() {
		// TODO Auto-generated method stub
		try {
			UserBean bean = model.findByLogin("akash@gmail.com");

			if (bean == null) {
				System.out.println("Test update fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfullLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {

		try {
			UserBean bean = model.findByPK(4);
			if (bean == null) {
				System.out.println("test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfullLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testUpdate() {
		// TODO Auto-generated method stub
		try {

			UserBean bean = model.findByPK(10L);
			bean.setFirstName("fi");
			bean.setLastName("la");
			bean.setLogin("login");
			bean.setPassword("password");
			model.update(bean);
			UserBean updatebean = model.findByPK(10L);
			if ("firstname".equals(updatebean.getLogin())) {
				System.out.println("test update fail");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	public static void testDelete() {
		// TODO Auto-generated method stub
		try {
			UserBean bean = new UserBean();

			bean.setId(7L);
			model.delete(bean);
			System.out.println("Test delete success" + bean.getId());
			UserBean deletedbean = model.findByPK(7L);
			if (deletedbean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testadd() throws ParseException, DuplicateRecordException {
		// TODO Auto-generated method stub

		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			bean.setId(1L);
			bean.setFirstName("vivek");
			bean.setLastName("patidar");
			bean.setLogin("vivek@gmail.com");
			bean.setPassword("vivek1234");
			bean.setDob(sdf.parse("04-05-94"));

			long pk = model.add(bean);
			UserBean addedbean = model.findByPK(pk);
			System.out.println("Test add success");
			if (addedbean == null) {
				System.out.println("Test add fail");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}