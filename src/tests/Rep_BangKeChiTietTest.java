package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Rep_BangKeChiTietPage;

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
}
