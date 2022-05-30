package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class TD_ThongDiepNhanHDPage extends BaseTest {
	
	@FindBy(xpath = "//a[@href='/TDiepNhanHD/Index']")
	static WebElement tdnhanhd;
	
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
	
	@FindBy(xpath = "//input[@id='MaTdNhan']")
	static WebElement matdnhan;
	
	@FindBy(xpath = "//select[@id='LoaiTDiep']")
	static WebElement loaithongdiep;
	
	@FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]")
	static WebElement timkiem;
	
	public TD_ThongDiepNhanHDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickThongDiepNhanHD() {
		tdnhanhd.click();
	}
	
	public void selectThongDiepNhanHD(String ChonTuNgay, String ChonDenNgay, String ChonKyHieu, String MaTDGui,
			String SoHoaDon, String MaTDNhan, String ChonLoaiTDiep) {
		
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
		matdnhan.sendKeys(MaTDNhan);
		
		Select ltd = new Select(loaithongdiep);
		ltd.selectByVisibleText(ChonLoaiTDiep);
		
		timkiem.click();
	}
}
