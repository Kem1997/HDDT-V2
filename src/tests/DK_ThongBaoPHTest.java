package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DK_ThongBaoPHPage;

public class DK_ThongBaoPHTest extends BaseTest {

	@Test
	public void clickThongBaoPH() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.clickThongBaoPH();
	}

	@Test
	public void chooseInvoiceTypeFail() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.clickAddAnnouncement();
		thongbaophPg.create.click();
		thongbaophPg.addInvoiceType("AB", "22", "1000", "");
		Assert.assertEquals(thongbaophPg.messagedate.getText(), "Cần nhập ngày bắt đầu");
		thongbaophPg.ok.click();
	}

	@Test
	public void chooseInvoiceTypeSuccess() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.addInvoiceType("AB", "22", "1000", "24/02/2022");
		Assert.assertEquals(thongbaophPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void editInvoiceType() {
		// Chỗ edit này đang lỗi nên chưa test được
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.editInvoiceType("AA", "22", "2000", "24/02/2022");
		Assert.assertEquals(thongbaophPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void deleteInvoiceType() {
		// Message này đang không lấy được xpath nên không test được
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.deleteInvoiceType();
		Assert.assertEquals(thongbaophPg.title.getText(), " THÔNG BÁO PHÁT HÀNH HOÁ ĐƠN ĐIỆN TỬ");
	}

	@Test
	public void createAnnouncementSuccess() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.addAnnounncement();
		Assert.assertEquals(thongbaophPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}

	@Test
	public void editAnnouncement() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.editAnnouncement();
		Assert.assertEquals(thongbaophPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}

	@Test
	public void deleteAnnouncement() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.deleteAnnouncemnet();
		Assert.assertEquals(thongbaophPg.messageSuccess.getText(), "Xóa thành công!");
	}

	@Test
	public void acceptAnnouncementSuccess() {
		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		thongbaophPg.addAnnounncement();
		Assert.assertEquals(thongbaophPg.messageSuccess.getText(), "Tạo phát hành thành công!");
		thongbaophPg.acceptAnnouncement();
		Assert.assertEquals(thongbaophPg.messageSuccess.getText(), "Tạo phát hành thành công!");
	}
}
