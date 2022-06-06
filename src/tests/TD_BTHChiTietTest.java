package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TD_BTHChiTietPage;

public class TD_BTHChiTietTest extends BaseTest {

	@Test
	public void createBTHChiTiet() {
		TD_BTHChiTietPage bthchitiet;
		bthchitiet = new TD_BTHChiTietPage(getDriver());
		bthchitiet.clickBTHChiTiet();
		bthchitiet.createBTHchitiet("", "");
	}
	
	@Test
	public void createBTHLanDau() {
		TD_BTHChiTietPage bthchitiet;
		bthchitiet = new TD_BTHChiTietPage(getDriver());
		bthchitiet.createBTHLanDau("", "");
		Assert.assertEquals(bthchitiet.message.getText(), "Hệ thống đang tạo bảng tổng hợp hóa đơn, vui lòng đợi.");
	}
	
	@Test
	public void createBTHBoSung() {
		TD_BTHChiTietPage bthchitiet;
		bthchitiet = new TD_BTHChiTietPage(getDriver());
		bthchitiet.createBTHBoSung("", "");
		Assert.assertEquals(bthchitiet.message.getText(), "Hệ thống đang tạo bảng tổng hợp hóa đơn, vui lòng đợi.");
	}
}
