package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class DK_DangKySuDungPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/TaxPublish/index']/i")
	static WebElement catDKSD;
	
	@FindBy(xpath = "//a[@href='/DKyThongTin/index']")
	static WebElement dangkysudung;
	
	@FindBy(xpath = "//a[@href='/DKyThongTin/Create/']")
	static WebElement dangky;
	
	public DK_DangKySuDungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCatDKSD() {
		catDKSD.click();
	}
}
