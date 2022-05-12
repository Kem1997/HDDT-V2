package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class InvP_ReplacementInvoicePage extends BaseTest {

	@FindBy(xpath = "//a[@href='/TaxAdjust/AdJustInvindex']/i")
	static WebElement invoiceProcessing;

	@FindBy(xpath = "//a[@href='/TaxAdjust/ReplaceInvindex']")
	static WebElement replacementInvoice;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement selectSerial;

	@FindBy(xpath = "//input[@id='InvNo']")
	static WebElement selectInvoiceno;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement selectFromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement selectTodate;

	@FindBy(xpath = "//button[contains(text(),'Tìm kiếm')]")
	static WebElement timkiem;

	public InvP_ReplacementInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInvoiceProcessing() {
		invoiceProcessing.click();
	}

	public void clickReplacementInvoice() {
		replacementInvoice.click();
	}

	public void selectInvoice(String ChonKyHieu, String ChonSoHoaDon, String ChonTuNgay, String ChonDenNgay) {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Select seri = new Select(selectSerial);
		seri.selectByVisibleText(ChonKyHieu);

		selectInvoiceno.sendKeys(ChonSoHoaDon);

		selectFromdate.click();
		selectFromdate.sendKeys(ChonTuNgay);
		selectFromdate.sendKeys(Keys.ENTER);

		selectTodate.click();
		selectTodate.sendKeys(ChonDenNgay);
		selectTodate.sendKeys(Keys.ENTER);

		timkiem.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
