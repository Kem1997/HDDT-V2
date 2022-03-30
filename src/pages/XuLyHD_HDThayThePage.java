package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class XuLyHD_HDThayThePage extends BaseTest {

	@FindBy(xpath = "//a[text()='Xử lý hóa đơn']")
	static WebElement xulyhoadon;

	@FindBy(xpath = "//a[text()='Hóa đơn thay thế']")
	static WebElement hoadonthaythe;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement serial;

	@FindBy(xpath = "//input[@id='InvNo']")
	static WebElement invoiceno;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement fromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement todate;

	@FindBy(xpath = "//*[text()='Tìm kiếm']")
	static WebElement timkiem;

	@FindBy(xpath = "//a[@href='/TaxAdjust/CreateReplace']")
	static WebElement taomoi;

	@FindBy(xpath = "//select[@id='adjusttype']")
	static WebElement kieuhoadon;

	@FindBy(xpath = "//input[@id='pattern']")
	static WebElement mauso;

	@FindBy(xpath = "//input[@id='serial']")
	static WebElement kyhieu;

	@FindBy(xpath = "//input[@id='invNo']")
	static WebElement sohoadon;

	@FindBy(xpath = "//select[@id='adjustserial']")
	static WebElement kyhieuhdxuly;

	@FindBy(xpath = "//*[text()='Thay thế hóa đơn']")
	static WebElement btnthaytthehd;

	public XuLyHD_HDThayThePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickXuLyHoaDon() {
		xulyhoadon.click();
	}

	public void clickHoaDonThayThe() {
		hoadonthaythe.click();
	}

	public void selectSoHoaDon(String KyHieu, String SoHoaDon, String TuNgayHD, String DenNgayHD) {

		Select kh = new Select(serial);
		kh.selectByVisibleText(KyHieu);

		invoiceno.sendKeys(SoHoaDon);

		fromdate.click();
		fromdate.sendKeys(TuNgayHD);
		fromdate.sendKeys(Keys.ENTER);

		todate.click();
		todate.sendKeys(DenNgayHD);
		todate.sendKeys(Keys.ENTER);

		timkiem.click();
	}

	public Integer checkHDBiThayThe() {

		List<WebElement> listhdbithaythe = driver.findElements(By.xpath("//tr/td[4]"));
		if (!listhdbithaythe.isEmpty() && listhdbithaythe != null) {
			int a = Integer.parseInt(listhdbithaythe.get(0).getText());
		}
		return null ;
	}

	private Integer checkHDThayThe() {

		List<WebElement> listhdthaythe = driver.findElements(By.xpath("//tr/td[9]"));

		return null;
	}
}
