package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DK_DangKySuDungPage;
import pages.DK_ThongBaoPHPage;
import pages.InvP_LapBCHuyPage;
import pages.InvP_ReplacementInvoicePage;

public class InvP_LapBCHuyTest extends BaseTest {

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
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		
		InvP_ReplacementInvoicePage hdthaythePg;
		hdthaythePg = new InvP_ReplacementInvoicePage(getDriver());
		hdthaythePg.clickInvoiceProcessing();;
		lapbaocaohuyPg.clickLapBCHuy();
	}

	@Test
	public void addThongBaoHuyHoaDonFail1() {
		// TH bo trong cac truong bat buoc: Bo truong tat ca cac truong du lieu
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.clickTaoMoi();
		lapbaocaohuyPg.addThongBaoHuyHoaDon("", "", "", "", "");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail2() {
		// TH bo trong cac truong bat buoc: Bo truong Phuong phap huy
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail3() {
		// TH bo trong cac truong bat buoc: Bo truong Nguoi tao
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail4() {
		// TH bo trong cac truong bat buoc: Bo truong Nguoi dai dien phap luat
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHuyHoaDonFail5() {
		// TH bo trong cac truong bat buoc: Bo truong Danh sach hoa don huy
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}
	
	@Test
	public void deleteDanhSachHDHuy() {
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		lapbaocaohuyPg.deleteDanhSachHDHuy();
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}

	@Test
	public void addThongBaoHoaDonSuccess() {
		// TH dien tat ca cac truong du lieu
		InvP_LapBCHuyPage lapbaocaohuyPg;
		lapbaocaohuyPg = new InvP_LapBCHuyPage(getDriver());
		lapbaocaohuyPg.addThongBaoHuyHoaDon("Hủy thông báo", "Phạm Thị Ly", "Phạm Thị Ly", "Hóa đơn giá trị gia tăng",
				"1C01T, 1C22TBB (1-1000)");
		Assert.assertEquals(lapbaocaohuyPg.title.getText(), "Thông báo hủy hóa đơn");
	}
}
