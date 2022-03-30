package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.XuLyHD_HDThayThePage;


public class XuLyHD_HDThayTheTest extends BaseTest {

	@Test
	public void clickXuLyHoaDon() {
		XuLyHD_HDThayThePage hdthaythePg;
		hdthaythePg = new XuLyHD_HDThayThePage(getDriver());
		hdthaythePg.clickXuLyHoaDon();
	}
}
