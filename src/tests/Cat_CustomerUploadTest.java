package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cat_CustomerUploadPage;
import pages.Sys_UserAuthorPage;

public class Cat_CustomerUploadTest extends BaseTest{
	@Test
	public void clickCustomerUpload() {
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		customerupload.clickCustomerUpload();
	}
	
	@Test
	public void createCustomerUploadFail1() {
		// TH không chọn file upload
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		customerupload.clickAddTemplate();
		customerupload.btnupload.click();
		Assert.assertEquals(customerupload.messageError.getText(), "Chưa chọn file dữ liệu khách hàng.");
	}
	
	@Test
	public void createCustomerUploadFail2() {
		// TH chọn file upload không đúng định dạng cho phép
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		customerupload.addTemplate();
		Assert.assertEquals(customerupload.messageError.getText(), "Chưa chọn file dữ liệu khách hàng.");
	}
	
	@Test
	public void createCustomerUploadSuccess() {
		// Upload KH thành công
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		customerupload.clickAddTemplate();
		customerupload.addTemplate();
		Assert.assertEquals(customerupload.title.getText(), "Quản lý upload khách hàng");
	}
	
	@Test
	public void deleteFileUploadSuccess() {
		// Xóa thành công trong TH trạng thái: mới tạo
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		customerupload.deleteFileUpload("MauUploadKH.xlsx");
		Assert.assertEquals(customerupload.title.getText(), "Xóa thành công.");
	}
	
	@Test
	public void notDeleteFileUpload() {
		// Trạng thái: Đang xử lý, nút Xóa bị disable
		Cat_CustomerUploadPage customerupload;
		customerupload = new Cat_CustomerUploadPage(getDriver());
		Boolean actualResult = customerupload.isEnabled(customerupload.delete, "MauUploadKH.xlsx");
		assertFalse(actualResult);
	}
	
	
}
