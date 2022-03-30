package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.XuLyHD_ThongBaoHDSaiSotPage;

public class XuLyHD_ThongBaoHDSaiSotTest extends BaseTest {

	@Test
	public void clickThongBaoHoaDonSaiSot() {
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.clickThongBaoHDSaiSot();
		Assert.assertEquals(thongbaohdsaisotPg.title.getText(), " DANH SÁCH THÔNG BÁO HÓA ĐƠN SAI SÓT");
	}

	@Test
	public void addThongBaoHDSaiSotFail1() {
		// TH bo trong tat ca cac truong bat buoc
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.clickTaoMoi();
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "", "", "", "", "", "", "", "", "","Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "");
		Assert.assertEquals(thongbaohdsaisotPg.titlecreate.getText(), " Thông báo sai sót");
	}

	@Test
	public void addThongBaoHDSaiSotFail2() {
		// TH bo trong truong bat buoc: Ten CQT
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "", "10100", "Hà Nội", "", "tesstttttttt1213", "1", "C22TSA",
				"1", "01/03/2022", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "test");
		Assert.assertEquals(thongbaohdsaisotPg.titlecreate.getText(), " Thông báo sai sót");
	}

	@Test
	public void addThongBaoHDSaiSotFail3() {
		// TH bo trong truong bat buoc: Ma CQT
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "Cục Thuế Thành Phố Hà Nội", "", "Hà Nội", "",
				"tesstttttttt1213", "1", "C22TSA", "1", "01/03/2022", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "test");
		Assert.assertEquals(thongbaohdsaisotPg.titlecreate.getText(), " Thông báo sai sót");
	}

	@Test
	public void addThongBaoHDSaiSotFail4() {
		// TH bo trong truong bat buoc: Dia Danh
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "Cục Thuế Thành Phố Hà Nội", "10100", "", "",
				"tesstttttttt1213", "1", "C22TSA", "1", "01/03/2022", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "test");
		Assert.assertEquals(thongbaohdsaisotPg.titlecreate.getText(), " Thông báo sai sót");
	}

	@Test
	public void addThongBaoHDSaiSotFail5() {
		// TH bo trong truong bat buoc: Thong tin hoa don
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "Cục Thuế Thành Phố Hà Nội", "10100", "Hà Nội", "", "", "",
				"", "", "", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "");
		Assert.assertEquals(thongbaohdsaisotPg.titlecreate.getText(), " Thông báo sai sót");
	}

	@Test
	public void addThongBaoHDSaiSotSuccess() {
		// TH nhap tat ca cac truong du lieu bat buoc
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.createThongBaoHDSaiSot("", "", "Cục Thuế Thành Phố Hà Nội", "10100", "Hà Nội", "",
				"tesstttttttt1213", "1", "C22TGT", "1", "22/02/2022", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "test");
		Assert.assertEquals(thongbaohdsaisotPg.message.getText(), "Tạo thông báo sai sót hóa đơn thành công.");
	}
	
	@Test
	public void editThongBaoHDSaiSot() {
		// TH nay dang loi khong test duoc: Bao loi "Co loi xay ra"
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.editThongBaoHDSaiSot("", "", "Cục Thuế Thành Phố Hà Nội", "10100", "Hà Nội", "",
				"tesstttttttt1213", "1", "C22TGT", "1", "22/02/2022", "Hóa đơn theo 123/2020/NĐ-CP", "Hủy", "test");
		Assert.assertEquals(thongbaohdsaisotPg.message.getText(), "Sửa thông báo sai sót hóa đơn thành công.");
	}
	
	@Test
	public void deleteThongBaoHDSaiSot() {
		XuLyHD_ThongBaoHDSaiSotPage thongbaohdsaisotPg;
		thongbaohdsaisotPg = new XuLyHD_ThongBaoHDSaiSotPage(getDriver());
		thongbaohdsaisotPg.deleteThongBaoHDSaiSot();
		Assert.assertEquals(thongbaohdsaisotPg.message.getText(), "Xóa thông báo sai sót hóa đơn thành công!");
	}
}
