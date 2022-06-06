package tests;

import org.testng.annotations.Test;

import pages.TD_BTHHoaDonPage;

public class TD_BTHHoaDonTest extends BaseTest {

	@Test
	public void timKiemBTHHoaDon() {
		TD_BTHHoaDonPage bthhoadon;
		bthhoadon = new TD_BTHHoaDonPage(getDriver());
		bthhoadon.clickBTHHoaDon();
		bthhoadon.timKiemBTHHoaDon("", "");
	}
}
