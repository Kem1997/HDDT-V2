package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Rep_BangKeChiTietPage extends BasePage {

	@FindBy(xpath = "//a[@href='/ReportDetails/index']")
	static WebElement bangkechitiet;

	@FindBy(xpath = "//select[@id='Pattern']")
	static WebElement pattern;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement serial;

	@FindBy(xpath = "//select[@id='Status']")
	static WebElement status;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement fromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement todate;

	@FindBy(xpath = "//button[text()=' Báo cáo nhanh']")
	static WebElement btnbaocaonhanh;

	@FindBy(xpath = "//div[contains(text(),'THỐNG KÊ CHI TIẾT HÓA ĐƠN')]")
	public static WebElement title;

	@FindBy(xpath = "//div[@id='info']")
	static WebElement info;

	@FindBy(xpath = "//*[text()='Tổng cộng: ']/parent::*")
	static WebElement tongtienpage;

	@FindBy(xpath = "//a[text()='>']")
	static WebElement next;

	public Rep_BangKeChiTietPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickBangkechitiet() {
		bangkechitiet.click();
	}

	public void selectBangkechitiet(String MauSo, String KyHieu, String TrangThai, String TuNgay, String DenNgay) {

		Select pat = new Select(pattern);
		pat.selectByVisibleText(MauSo);

		Select ser = new Select(serial);
		ser.selectByVisibleText(KyHieu);

		Select sta = new Select(status);
		sta.selectByVisibleText(TrangThai);

		fromdate.click();
		fromdate.sendKeys(TuNgay);
		fromdate.sendKeys(Keys.ENTER);
		
		todate.click();
		todate.sendKeys(DenNgay);
		todate.sendKeys(Keys.ENTER);

		btnbaocaonhanh.click();
	}

	public Boolean checkThongTinChungBaoCao(String MauSo, String KyHieu) {
		String thongtinchung = info.getText();
		String[] tachmauso = thongtinchung.split("Mẫu số: "); // Tach chuoi
		String[] tachmausovakyhieu = tachmauso[1].split(" ");// lấy phần sau
		String textmauso = tachmausovakyhieu[0];
		String textkyhieu = tachmausovakyhieu[2];
		if (textmauso != MauSo || textkyhieu != KyHieu) {
			return false;
		} else {
			return true;
		}
	}

	public void checkTienBaoCao() throws Exception {
		List<WebElement> nextlist = driver.findElements(By.xpath("//a[text()='>']"));
		int i=0;
		while (!nextlist.isEmpty()) {
			i++;
			float tongtien = 0;
			List<WebElement> tongtiendong = driver.findElements(By.xpath("//tbody//tr//td[12]"));
			for (int j = 0; j < tongtiendong.size(); j++) {
				if (tongtiendong.get(j).getText() != null && tongtiendong.get(j).getText() != "") {
					tongtien = tongtien + Float.parseFloat(tongtiendong.get(j).getText().replace(",", ""));
				}
			}
			
			String a=tongtienpage.getText();
			float t= Float.parseFloat(tongtienpage.getText().replace(",", ""));
			if (Float.parseFloat(tongtienpage.getText().replace(",", "")) != tongtien) {
				throw new Exception("SAI TONG TIEN O PAGE " + i);
			}
			next.click();
		}
	}
}
