package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DK_DangKySuDungPage;
import pages.DK_ThongBaoPHPage;
import pages.XuLyHD_HDThayThePage;
import pages.XuLyHD_LapBCHuyPage;

public class XuLyHD_LapBCHuyTest extends BaseTest {

	@Test
	public void lapThongBaoPhatHanh() {
		// Tao 1 dai moi de check lap bao cao huy (huy dai)
		DK_DangKySuDungPage dangkysudungPg;
		dangkysudungPg = new DK_DangKySuDungPage(getDriver());

		DK_ThongBaoPHPage thongbaophPg;
		thongbaophPg = new DK_ThongBaoPHPage(getDriver());
		
		dangkysudungPg.clickCatDKSD();
		
		thongbaophPg.clickThongBaoPH();
		thongbaophPg.clickAddAnnouncement();
		thongbaophPg.create.click();
		thongbaophPg.addAnnounncement();
		thongbaophPg.acceptAnnouncement();
	}
	
	@Test
	public void clickLapBaoCaoHuy() {
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		
		XuLyHD_HDThayThePage hdthaythePg;
		hdthaythePg = new XuLyHD_HDThayThePage(getDriver());
		hdthaythePg.clickXuLyHoaDon();
		
		lapbaocaohuyPg.clickLapBCHuy();
	}

	@Test
	public void addThongBaoHuyHoaDonFail1() {
		// TH bo trong cac truong bat buoc: Bo truong tat ca cac truong du lieu
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.clickTaoMoi();
		lapbaocaohuyPg.addThongBaoHuyHoaDon("", "", "", "", "");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail2() {
		// TH bo trong cac truong bat buoc: Bo truong Phuong phap huy
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail3() {
		// TH bo trong cac truong bat buoc: Bo truong Nguoi tao
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail4() {
		// TH bo trong cac truong bat buoc: Bo truong Nguoi dai dien phap luat
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail5() {
		// TH bo trong cac truong bat buoc: Bo truong Danh sach hoa don huy
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}
	
	@Test
	public void deleteDanhSachHDHuy() {
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		lapbaocaohuyPg.deleteDanhSachHDHuy();
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHoaDonSuccess() {
		// TH dien tat ca cac truong du lieu
		XuLyHD_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new XuLyHD_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}
}
