package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DK_DangKyDaiSoPage;

public class DK_DangKyDaiSoTest extends BaseTest {

	@Test
	public void clickDangKyDaiSo() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.clickDangKyDaiSo();
	}

	@Test
	public void chooseInvoiceTypeFail() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.clickAddAnnouncement();
		dangkydaisoPg.create.click();
		dangkydaisoPg.addInvoiceType("AB", "22", "1000", "");
		Assert.assertEquals(dangkydaisoPg.messagedate.getText(), "Cần nhập ngày bắt đầu");
		dangkydaisoPg.ok.click();
	}

	@Test
	public void chooseInvoiceTypeSuccess() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.addInvoiceType("AB", "22", "1000", "24/01/2022");
		Assert.assertEquals(dangkydaisoPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void editInvoiceType() {
		//Chỗ edit này đang lỗi nên chưa test được
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.editInvoiceType("AA", "22", "2000", "24/01/2022");
		Assert.assertEquals(dangkydaisoPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void deleteInvoiceType() {
		// Message này đang không lấy được xpath nên không test được
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.deleteInvoiceType();
		Assert.assertEquals(dangkydaisoPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void createAnnouncementSuccess() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.addAnnounncement();
		Assert.assertEquals(dangkydaisoPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}

	@Test
	public void editAnnouncement() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.editAnnouncement();
		Assert.assertEquals(dangkydaisoPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}
	
	@Test
	public void deleteAnnouncement() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.deleteAnnouncemnet();
		Assert.assertEquals(dangkydaisoPg.messageSuccess.getText(), "Xóa thành công!");
	}
	
	@Test
	public void acceptAnnouncementSuccess() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.addAnnounncement();
		Assert.assertEquals(dangkydaisoPg.messageSuccess.getText(), "Tạo phát hành thành công!");
		dangkydaisoPg.acceptAnnouncement();
		Assert.assertEquals(dangkydaisoPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}
}
