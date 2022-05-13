package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.BaseTest;

public class TD_ThongDiepNhanHDPage extends BaseTest {

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
}
