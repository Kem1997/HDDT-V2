package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvM_InvoiceIssuePage;
import pages.Rep_BangKeChiTietPage;
import pages.Rep_TinhHinhSuDungHDPage;

public class Rep_BangKeChiTietTest extends BaseTest {

	@Test
	public void checkThongTinChungBCBangKeChiTiet() {
		Rep_BangKeChiTietPage bangkechitietPg;
		bangkechitietPg = new Rep_BangKeChiTietPage(getDriver());
		bangkechitietPg.clickBangkechitiet();
		bangkechitietPg.selectBangkechitiet("1C01T", "1C22TGT", "--Trạng thái--", "01/03/2022", "18/03/2022");
		Assert.assertEquals(bangkechitietPg.title.getText(), "THỐNG KÊ CHI TIẾT HÓA ĐƠN");
		bangkechitietPg.checkThongTinChungBaoCao("1C01T", "1C22TGT");
	}
	
	@Test
	public void checkTongTienBCBangKeChiTiet() throws Exception {
		Rep_BangKeChiTietPage bangkechitietPg;
		bangkechitietPg = new Rep_BangKeChiTietPage(getDriver());
		bangkechitietPg.checkTienBaoCao();
	}
	
	@Test
	public void checkSoLuongHDBaoCaoVaDanhSachHD() throws Exception {
		Rep_BangKeChiTietPage bangkechitietPg;
		bangkechitietPg = new Rep_BangKeChiTietPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		Rep_TinhHinhSuDungHDPage tinhhinhsdPg;
		tinhhinhsdPg = new Rep_TinhHinhSuDungHDPage(getDriver());
		tinhhinhsdPg.clickBaocao();
		
		bangkechitietPg.clickBangkechitiet();
		bangkechitietPg.selectBangkechitiet("1C01T", "1C22TGT", "--Trạng thái--", "01/03/2022", "18/03/2022");
		Assert.assertEquals(bangkechitietPg.checkTienBaoCao(), invissuelistPg.checkSoLuongHDTrongDanhSach() );
	}
}
