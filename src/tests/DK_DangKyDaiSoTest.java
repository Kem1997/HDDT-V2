package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DK_DangKyDaiSoPage;

public class DK_DangKyDaiSoTest extends BaseTest{

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
		dangkydaisoPg.addAnnouncement("AB", "22", "1000", "");
		Assert.assertEquals(dangkydaisoPg.messagedate.getText(), "Cần nhập ngày bắt đầu");
		dangkydaisoPg.ok.click();
	}
	
	@Test
	public void chooseInvoiceTypeSuccess() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.addAnnouncement("AB", "22", "1000", "21/01/2022");
		Assert.assertEquals(dangkydaisoPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}
	
	@Test
	public void editInvoiceType() {
		DK_DangKyDaiSoPage dangkydaisoPg;
		dangkydaisoPg = new DK_DangKyDaiSoPage(getDriver());
		dangkydaisoPg.editInvoiceType("AA", "22", "2000", "21/01/2022");
		Assert.assertEquals(dangkydaisoPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}
	
	
}
