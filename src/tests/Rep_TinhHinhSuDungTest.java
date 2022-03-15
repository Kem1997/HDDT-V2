package tests;

import org.testng.annotations.Test;

import pages.Rep_TinhHinhSuDungHDPage;


public class Rep_TinhHinhSuDungTest extends BaseTest{

	@Test
	public void clickReport() {
		Rep_TinhHinhSuDungHDPage tinhhinhsdPg;
		tinhhinhsdPg = new Rep_TinhHinhSuDungHDPage(getDriver());
		tinhhinhsdPg.clickBaocao();
	}
}
