package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class TD_ThongDiepNhanPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/TDiepNhan/Index']")
	static WebElement tdnhan;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement selectFromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement selectTodate;

	@FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]")
	static WebElement timkiem;

	public TD_ThongDiepNhanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickThongDiepNhan() {
		tdnhan.click();
	}

	public void selectaThongDiepGui(String ChonTuNgay, String ChonDenNgay) {

		selectFromdate.click();
		selectFromdate.sendKeys(ChonTuNgay);
		selectFromdate.sendKeys(Keys.ENTER);

		selectTodate.click();
		selectTodate.sendKeys(ChonDenNgay);
		selectTodate.sendKeys(Keys.ENTER);

		timkiem.click();
	}
}
