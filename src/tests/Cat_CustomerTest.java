package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cat_CustomerPage;

public class Cat_CustomerTest extends BaseTest {
	@Test
	public void clickCategory() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.clickCategory();
	}

	@Test
	public void clickCustomer() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.clickCustomer();
		Assert.assertEquals(customerPg.title.getText(), "Danh sách khách hàng");
	}

	@Test
	public void createBlankAll() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.clickAddCustomer();
		customerPg.addCustomer("", "", "", "", "", "", "", "", "", "", "", "", "", "");
		Assert.assertEquals(customerPg.title.getText(), " THÔNG TIN KHÁCH HÀNG");
	}

	@Test
	public void create1RequiredFieldBlank1() {
		// Bỏ trống trường bắt buộc nhập : Mã KH
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.refreshPage();
		customerPg.addCustomer("", "", "Nguyễn Thị An",
				"Vinaconex1 số 289a Khuất Duy Tiến - Trung Hòa - Cầu Giấy - Hà Nội", "", "", "", "", "", "", "", "", "",
				"");
		Assert.assertEquals(customerPg.title.getText(), " THÔNG TIN KHÁCH HÀNG");
	}

	@Test
	public void create1RequiredFieldBlank2() {
		// Bỏ trống trường bắt buộc nhập : Tên khách hàng
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.refreshPage();
		customerPg.addCustomer("annguyenthi", "", "",
				"Vinaconex1 số 289a Khuất Duy Tiến - Trung Hòa - Cầu Giấy - Hà Nội", "", "", "", "", "", "", "", "", "",
				"");
		Assert.assertEquals(customerPg.title.getText(), " THÔNG TIN KHÁCH HÀNG");
	}

	@Test
	public void create1RequiredFieldBlank3() {
		// Bỏ trống trường bắt buộc nhập : Địa chỉ
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.refreshPage();
		customerPg.addCustomer("annguyenthi", "", "Nguyễn Thị An", "", "", "", "", "", "", "", "", "", "", "");
		Assert.assertEquals(customerPg.title.getText(), " THÔNG TIN KHÁCH HÀNG");
	}

	@Test
	public void createCustomerSuccess() {
		// Nhập tất cả các trường
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.refreshPage();
		customerPg.addCustomer("annguyenthi", "0100109106-001", "Nguyễn Thị An",
				"Vinaconex1 số 289a Khuất Duy Tiến - Trung Hòa - Cầu Giấy - Hà Nội", "0339234567", "",
				"an@gmail.com.vn", "", "Nguyễn Văn A", "Nguyễn Văn B", "02709450230", "Nguyễn Văn A",
				"Ngân hàng Thương mại Cổ phần Tiên Phong", "Khách hàng tiềm năng");
		Assert.assertEquals(customerPg.messageSuccess.getText(), "Tạo thông tin khách hàng thành công.");
	}

	@Test
	public void checkCustomer() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.checkCustomer(customerPg.cus.getText(), "annguyenthi");
	}

	@Test
	public void editCustomer() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		customerPg.clickEditCustomer("annguyenthi");
		customerPg.editCustomer("", "Nguyễn Thị Thu An",
				"Vinaconex1 số 289a Khuất Duy Tiến - Trung Hòa - Cầu Giấy - Hà Nội", "0376890234", "",
				"thuan@gmail.com.vn", "", "Nguyễn Văn B", "Nguyễn Văn A", "02709450009", "Nguyễn Văn B",
				"Ngân hàng Thương mại Cổ phần Tiên Phong", "Khách hàng tiềm năng");
		Assert.assertEquals(customerPg.messageSuccess.getText(), "Sửa thông tin khách hàng thành công.");
	}
	
	@Test
	public void deleteCustomer() {
		Cat_CustomerPage customerPg;
		customerPg = new Cat_CustomerPage(getDriver());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		customerPg.deleteCustomer("annguyenthi");
		Assert.assertEquals(customerPg.messageSuccess.getText(), "Xóa khách hàng thành công!");
	}
}
