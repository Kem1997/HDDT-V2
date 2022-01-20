package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Sys_UnitInforPage;
import pages.Sys_UserAdminPage;

public class Sys_UserAdminTest extends BaseTest {
	@Test
	public void clickUserAdministration() {
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.clickUserAdministration();
	}

	@Test
	public void createBlankAll() {
		// Để trống tất cả các trường
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.clickAddUser();
		useradministration.addUser("", "", "", "", "");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void create1RequiredFieldBlank1() {
		// Để trống Tên tài khoản
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.refreshPage();
		useradministration.addUser("", "Nguyễn Văn A", "test@gmail.com", "Abcd@123456", "Abcd@123456");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void create1RequiredFieldBlank2() {
		// Để trống Mail
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.refreshPage();
		useradministration.addUser("test1", "Nguyễn Văn A", "", "Abcd@123456", "Abcd@123456");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void create1RequiredFieldBlank3() {
		// Để trống Mật khẩu
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.refreshPage();
		useradministration.addUser("test1", "Nguyễn Văn A", "test@gmail.com", "", "Abcd@123456");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void create1RequiredFieldBlank4() {
		// Để trống Nhập lại mật khẩu
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.refreshPage();
		useradministration.addUser("test1", "Nguyễn Văn A", "test@gmail.com", "Abcd@123456", "");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void reEnterPasswordDifferentPassword() {
		// Nhập lại Mật khẩu khác Mật khẩu
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.refreshPage();
		useradministration.addUser("test1", "Nguyễn Văn A", "test@gmail.com", "Abcd@123456", "Abcd@12345");
		Assert.assertEquals(useradministration.title.getText(), "Tạo mới người dùng hệ thống");
	}

	@Test
	public void clickApprovedSuccess() {
		// Nhấn nút kích hoạt
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.back.click();
		useradministration.clickAddUser();
		useradministration.addUser("test1", "Nguyễn Văn A", "test@gmail.com", "Abcd@123456", "Abcd@123456");
		Assert.assertEquals(useradministration.messageSuccess.getText(), "Tạo mới người dùng thành công.");
	}

	@Test
	public void checkAccountClickApproved() {
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.checkAccount(useradministration.acc.getText(), "test1");
	}

	@Test
	public void notClickApprovedSuccess() {
		// Không nhấn nút kích hoạt
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.clickAddUser();
		useradministration.addUserNotApproved("test2", "Nguyễn Văn B", "test@gmail.com", "Abcd@123456", "Abcd@123456");
		Assert.assertEquals(useradministration.messageSuccess.getText(), "Tạo mới người dùng thành công.");
	}

	@Test
	public void checkAccountNotClickApproved() {
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.checkAccount(useradministration.acc.getText(), "test2");
	}
	
	@Test
	public void editAccountSuccess() {
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.clickEditAccount("test2");
		useradministration.editAccount();
		Assert.assertEquals(useradministration.messageSuccess.getText(), "Sửa tài khoản thành công.");
	}
	
	@Test
	public void deleteSuccess() {
		//TH tài khoản không được phân quyền quản trị mới xóa được
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.deleteAccount("test2");
		Assert.assertEquals(useradministration.messageSuccess.getText(), "Xóa tài khoản thành công.");
	}
	
	public void deleteFailed() {
		//TH tài khoản được phân quyền admin thì sẽ không xóa được
		Sys_UserAdminPage useradministration;
		useradministration = new Sys_UserAdminPage(getDriver());
		useradministration.deleteAccount("test1");
		Assert.assertEquals(useradministration.messageError.getText(), "Không được xóa tài khoản này.");
	}
}
