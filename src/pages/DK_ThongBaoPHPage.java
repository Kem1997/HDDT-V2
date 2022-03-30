package pages;

import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class DK_ThongBaoPHPage extends BaseTest {

	@FindBy(xpath = "//a[contains(text(), 'Thông báo phát hành')]")
	static WebElement thongbaophathanh;

	@FindBy(xpath = "//a[@href='/TaxPublish/Create/']")
	static WebElement addannouncement;

	@FindBy(xpath = "//button[@id='Create']")
	public static WebElement create;

	@FindBy(xpath = "//select[@id='RegisterName']")
	static WebElement pattern;

	@FindBy(xpath = "//input[@id='InvSerialPrefix']")
	static WebElement serial;

	@FindBy(xpath = "//input[@id='InvSerialSuffix']")
	static WebElement year;

	@FindBy(xpath = "//input[@id='Quantity']")
	static WebElement quantity;

	@FindBy(xpath = "//input[@id='ToNo']")
	static WebElement tono;

	@FindBy(xpath = "//input[@id='StartDate']")
	static WebElement startdate;

	@FindBy(xpath = "//button[@id='Save']")
	static WebElement save;

	@FindBy(xpath = "//button[@onclick='btCancel_click()']")
	static WebElement back;

	@FindBy(xpath = "//article//p")
	public static WebElement messagedate;

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;

	@FindBy(xpath = "//div[@class='errorbox']")
	public static WebElement messageError;

	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;

	@FindBy(xpath = "//h4")
	public static WebElement title;

	@FindBy(xpath = "//tr//td[7]//span")
	static WebElement editinvoicetype;

	@FindBy(xpath = "//tr//td[8]//span")
	static WebElement deleteinvoicetype;

	@FindBy(xpath = "//button[@onclick='Save_Click()']")
	static WebElement savenotifications;

	@FindBy(xpath = "//tr[1]//td[6]//a/i")
	static WebElement view;

	@FindBy(xpath = "//button[text()='Gửi thông báo']")
	static WebElement sendnotifications;

	@FindBy(xpath = "//button[text()='Chấp nhận thông báo']")
	static WebElement acceptnotifications;

	@FindBy(xpath = "//tr[1]//td[7]//a/i")
	static WebElement editannouncement;

	@FindBy(xpath = "//tr[1]//td[8]//a/i")
	static WebElement deleteannouncement;

	@FindBy(xpath = "//tr[1]//td[5]")
	static WebElement status;

	public DK_ThongBaoPHPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickThongBaoPH() {
		thongbaophathanh.click();
	}

	public void clickAddAnnouncement() {
		addannouncement.click();
	}

	public void selectPattern(WebElement ele, String obj) {
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(obj);
	}

	public void addInvoiceType(String Serial, String Year, String Quantity, String StartDate) {
		
		selectPattern(pattern, "78VATTEMP");

		serial.clear();
		serial.sendKeys(Serial);

		year.clear();
		year.sendKeys(Year);

		quantity.clear();
		quantity.sendKeys(Quantity);

		startdate.clear();
		startdate.sendKeys(StartDate);

		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void editInvoiceType(String Serial, String Year, String Quantity, String StartDate) {
		editinvoicetype.click();

		selectPattern(pattern, "78VATTEMP");

		serial.clear();
		serial.sendKeys(Serial);

		year.clear();
		year.sendKeys(Year);

		quantity.clear();
		quantity.sendKeys(Quantity);

		startdate.clear();
		startdate.sendKeys(StartDate);

		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteInvoiceType() {
		deleteinvoicetype.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		deleteinvoicetype.sendKeys(Keys.ENTER);
	}

	public void addAnnounncement() {
		addInvoiceType("BB", "22", "1000", "24/03/2022");

		savenotifications.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void editAnnouncement() {
		editannouncement.click();
		addInvoiceType("BB", "22", "2000", "24/02/2022");

		savenotifications.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteAnnouncemnet() {
		deleteannouncement.click();
	}

	public void acceptAnnouncement() {
		if (status.getText().equals("Mới lập")) {
			view.click();
			sendnotifications.click();
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			ok.click();
			
			acceptnotifications.click();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			ok.click();
		}
	}
}
