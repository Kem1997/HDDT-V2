package tests;

import org.testng.annotations.Test;

import pages.Rep_BangKeHDPage;


public class Rep_BangKeHDTest extends BaseTest{

	@Test
	public void checkBaocaoBangKeHD() throws Exception {
		Rep_BangKeHDPage bangkehdPg;
		bangkehdPg = new Rep_BangKeHDPage(getDriver());
		bangkehdPg.clickBangkeHD();
		bangkehdPg.selectBangKeHD("01", "2022");
		bangkehdPg.checkThongTinChungBaoCao("01", "2022");
		bangkehdPg.checkTienBaoCao();
	}
}
