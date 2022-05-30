package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class TD_ThongDiepGuiPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/TDiepGui/Index']")
	static WebElement tdgui;
	
	@FindBy(xpath = "//input[@id='keyword']")
	static WebElement matdiep;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement selectFromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement selectTodate;
	
	@FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]")
	static WebElement timkiem;
	
	public TD_ThongDiepGuiPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickThongDiepGui() {
		tdgui.click();
	}
	
	public void selectaThongDiepGui(String MaThongDiep, String ChonTuNgay, String ChonDenNgay) {
		
		matdiep.sendKeys(MaThongDiep);
		
		selectFromdate.click();
		selectFromdate.sendKeys(ChonTuNgay);
		selectFromdate.sendKeys(Keys.ENTER);

		selectTodate.click();
		selectTodate.sendKeys(ChonDenNgay);
		selectTodate.sendKeys(Keys.ENTER);
		
		timkiem.click();
	}
}
