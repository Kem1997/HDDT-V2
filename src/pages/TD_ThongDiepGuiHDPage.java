package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class TD_ThongDiepGuiHDPage extends BaseTest {

	@FindBy(xpath = "//a[@href=' ']")
	static WebElement qlthongdiep;

	@FindBy(xpath = "//li[3]//a[@href='/ThongDiepGuiHD/Index']")
	static WebElement tdguihd;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement selectFromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement selectTodate;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement selectSerial;

	@FindBy(xpath = "//input[@id='MaTdGui']")
	static WebElement matdgui;

	@FindBy(xpath = "//input[@id='SoHd']")
	static WebElement invoiceno;

	@FindBy(xpath = "//select[@id='LoaiTDiep']")
	static WebElement loaithongdiep;

	@FindBy(xpath = "//select[@id='Status']")
	static WebElement trangthai;

	@FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]")
	static WebElement timkiem;

	public TD_ThongDiepGuiHDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickQLThongDiep() {
		qlthongdiep.click();
	}

	public void clickThongDiepGuiHD() {
		tdguihd.click();
	}

	public void selectThongDiepGuiHD(String ChonTuNgay, String ChonDenNgay, String ChonKyHieu, String MaTDGui,
			String SoHoaDon, String ChonLoaiTDiep, String ChonTrangThai) {

		selectFromdate.click();
		selectFromdate.sendKeys(ChonTuNgay);
		selectFromdate.sendKeys(Keys.ENTER);

		selectTodate.click();
		selectTodate.sendKeys(ChonDenNgay);
		selectTodate.sendKeys(Keys.ENTER);
		
		Select seri = new Select(selectSerial);
		seri.selectByVisibleText(ChonKyHieu);
		
		matdgui.sendKeys(MaTDGui);
		invoiceno.sendKeys(SoHoaDon);
		
		Select ltd = new Select(loaithongdiep);
		ltd.selectByVisibleText(ChonLoaiTDiep);
		
		Select tt = new Select(trangthai);
		tt.selectByVisibleText(ChonTrangThai);
		
		timkiem.click();
	}
}
