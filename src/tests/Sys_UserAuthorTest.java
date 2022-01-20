package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Sys_UserAuthorPage;

public class Sys_UserAuthorTest extends BaseTest {
	@Test
	public void clickAuthorization() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.clickSystem();
		authorization.clickUserAuthorization();
	}
	
	@Test
	public void createBlankAll() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.clickAddRole();
		authorization.addRole("","");
		Assert.assertEquals(authorization.title.getText(), " QUYỀN TRUY CẬP HỆ THỐNG");
	}
	
	@Test
	public void create1RequiredFieldBlank1() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.refreshPage();
		authorization.addRole("", "Quyền tester");
		Assert.assertEquals(authorization.title.getText(), " QUYỀN TRUY CẬP HỆ THỐNG");
	}
	
	@Test
	public void create1RequiredFieldBlank2() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.refreshPage();
		authorization.addRoleNotPermission("test", "Quyền tester");
		Assert.assertEquals(authorization.title.getText(), " QUYỀN TRUY CẬP HỆ THỐNG");
	}
	
	@Test 
	public void createAuthorizationAll() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.refreshPage();
		authorization.addRole("test", "Quyền tester");
		Assert.assertEquals(authorization.messageSuccess.getText(), "Tạo quyền thành công.");
	}
	
	@Test
	public void createAuthorizationViewHome() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.clickAddRole();
		authorization.ckbviewhome.click();
		authorization.addRoleNotPermission("viewhome", "Quyền trang chủ");
		Assert.assertEquals(authorization.messageSuccess.getText(), "Tạo quyền thành công.");
	}
	
	@Test
	public void editAuthorization() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.clickEditAuthorization("viewhome");
		authorization.editAuthorization("viewhome1");
		Assert.assertEquals(authorization.messageSuccess.getText(), "Sửa role thành công.");
	}
	
	@Test
	public void deleteAuthorization() {
		Sys_UserAuthorPage authorization;
		authorization = new Sys_UserAuthorPage(getDriver());
		authorization.deleteAuthorization("viewhome");
		Assert.assertEquals(authorization.messageSuccess.getText(), "Xóa role thành công.");
	}
}
