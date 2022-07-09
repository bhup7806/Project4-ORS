package in.co.rays.project4.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.RoleModel;

/**
 * @author bhupendra
 *
 */
public class RoleModelTest {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) throws ApplicationException {
		// testAdd();
		// testDelete();
		// testupdate();
		// testFindByName();
		//testFindByPK();
		 testList();
		   //testsearch();

	}

	public static void testsearch() {
		// TODO Auto-generated method stub
		try {
			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			bean.setName("vijay");
			list = model.search(bean, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testupdate() {

		try {
			RoleBean bean = model.findByPK(3L);
			bean.setName("vijay");
			bean.setDescription("Ejjjjjjjjng");
			model.update(bean);

			RoleBean updatedbean = model.findByPK(3L);
			if (!"vijay".equals(updatedbean.getName())) {
				System.out.println("Test Update fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	public static void testList() {

		try {
			RoleBean bean = new RoleBean();
			List list = new ArrayList();
			list = model.List();
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (RoleBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testFindByPK() {
		try {
			RoleBean bean = new RoleBean();
			long pk = 14L;
			bean = model.findByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	public static void testFindByName() {
		try {
			RoleBean bean = new RoleBean();
			bean = model.findByName("vijay");
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testDelete() {

		try {
			RoleBean bean = new RoleBean();
			long pk = 18L;
			bean.setId(pk);
			model.delete(bean);
			RoleBean deletedbean = model.findByPK(pk);
			if (deletedbean != null) {
				System.out.println("Test Delete fail");
				System.out.println("delete Success");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	public static void testAdd() {

		try {
			RoleBean bean = new RoleBean();
			bean.setId(1);
			bean.setName("Ajay");
			bean.setDescription("sadf");
			long pk = model.add(bean);

			RoleBean addedbean = model.findByPK(pk);
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

}
