package tests;

import org.testng.annotations.Test;

import pages.DK_DangKySuDungPage;

public class DK_DangKySuDungTest extends BaseTest{

	@Test
	public void clickCatDangKySuDung() {
		DK_DangKySuDungPage dangkysudungPg;
		dangkysudungPg = new DK_DangKySuDungPage(getDriver());
		dangkysudungPg.clickCatDKSD();
	}
}
