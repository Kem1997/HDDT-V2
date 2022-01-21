package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cat_ProductManagementPage;
import pages.Sys_UserAuthorPage;


public class Cat_ProductManagementTest extends BaseTest {
	
	@Test
	public void clickProductManagement() {
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.clickProductMangement();
		Assert.assertEquals(productmanagement.title.getText(), "Danh sách sản phẩm, dịch vụ");
	}
	
	@Test
	public void addProductFail1() {
		// TH để trống trường bắt buộc nhập: Mã sản phẩm(*)
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.clickAddProduct();
		productmanagement.addProduct("", "", "", "");
		Assert.assertEquals(productmanagement.title.getText(), "THÔNG TIN SẢN PHẨM");
	}
	
	@Test
	public void addProductFail2() {
		// TH để trống trường bắt buộc nhập: Mã sản phẩm(*)
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.refreshPage();
		productmanagement.addProduct("", "Ti vi Panasonic I100nc", "10000000", "test");
		Assert.assertEquals(productmanagement.title.getText(), "THÔNG TIN SẢN PHẨM");
	}
	
	@Test
	public void addProductFail3() {
		// TH để trống trường bắt buộc nhập: Tên sản phẩm(*)
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.refreshPage();
		productmanagement.addProduct("TVPI100nc", "", "10000000", "test");
		Assert.assertEquals(productmanagement.title.getText(), "THÔNG TIN SẢN PHẨM");
	}
	
	@Test
	public void addProductFail4() {
		// TH để trống trường bắt buộc nhập: Giá sản phẩm(*)
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.refreshPage();
		productmanagement.addProduct("TVPI100nc", "Ti vi Panasonic I100nc", "", "test");
		Assert.assertEquals(productmanagement.title.getText(), "THÔNG TIN SẢN PHẨM");
	}
	
	@Test
	public void priceNotCorrect() {
		// TH để trống trường bắt buộc nhập: Giá sản phẩm(*) không đúng
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.refreshPage();
		productmanagement.addProduct("TVPI100nc", "Ti vi Panasonic I100nc", "0", "test");
		Assert.assertEquals(productmanagement.messagePrice.getText(), "Giá sản phẩm phải lớn hơn 0");
	}
	
	@Test
	public void addProductSuccess() {
		// TH để trống trường bắt buộc nhập: Giá sản phẩm(*)
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.refreshPage();
		productmanagement.addProduct("TVPI100nc", "Ti vi Panasonic I100nc", "10000000", "test");
		Assert.assertEquals(productmanagement.messageSuccess.getText(), "Tạo thông tin sản phẩm thành công.");
	}
	
	@Test
	public void productCodeError() {
		// TH Mã sản phẩm đã tồn tại trên hệ thống
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.clickAddProduct();
		productmanagement.addProduct("TVPI100nc", "Ti vi Panasonic I100nc", "10000000", "test");
		Assert.assertEquals(productmanagement.messageError.getText(), "Mã sản phẩm đã tồn tại trong hệ thống.");
		productmanagement.back.click();
	}
	
	@Test
	public void editProduct() {
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.clickEditProduct("TVPI100nc");
		productmanagement.editProduct("Ti vi Panasonic I100nc", "20000000", "test");
		Assert.assertEquals(productmanagement.messageSuccess.getText(), "Sửa thông tin sản phẩm thành công.");
	}
	
	@Test
	public void deleteProduct() {
		Cat_ProductManagementPage productmanagement;
		productmanagement = new Cat_ProductManagementPage(getDriver());
		productmanagement.deleteProduct("TVPI100nc");
		Assert.assertEquals(productmanagement.messageSuccess.getText(), "Xóa thông tin sản phẩm thành công.");
	}
}
