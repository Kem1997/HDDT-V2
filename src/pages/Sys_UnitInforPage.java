package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class Sys_UnitInforPage extends BaseTest{
	
	@FindBy(xpath = "//a[@href='/Company/DetailCurrent']/i")
	static WebElement system;
	
	@FindBy(xpath = "//a[contains(text(), 'Thông tin đơn vị')]")
	static WebElement unitInformation;
	
	@FindBy(xpath = "//button[contains(text(),'Chỉnh sửa')]")
	static WebElement edit;
	
	@FindBy(xpath = "//input[@id='Name']")
	static WebElement name;
	
	@FindBy(xpath = "//input[@id='Address']")
	static WebElement address;
	
	@FindBy(xpath = "//input[@id='Phone']")
	static WebElement phone;
	
	@FindBy(xpath = "//input[@id='Fax']")
	static WebElement fax;
	
	@FindBy(xpath = "//input[@id='Email']")
	static WebElement email;
	
	@FindBy(xpath = "//input[@id='RepresentPerson']")
	static WebElement representPerson;
	
	@FindBy(xpath = "//input[@id='BankNumber']")
	static WebElement bankNumber;
	
	@FindBy(xpath = "//input[@id='BankName']")
	static WebElement bankName;
	
	@FindBy(xpath = "//button[contains(text(), 'Lưu')]")
	static WebElement save;
	
	@FindBy(xpath = "//button[contains(string(), 'Quay lại')]")
	static WebElement back;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement message;
	
	public Sys_UnitInforPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSystem() {
		system.click();
	}
	
	public void clickUnitInformation() {
		unitInformation.click();
	}
		
	public void editUnitInformation() {
		edit.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		bankNumber.clear();
		bankNumber.sendKeys("11111111111111");
		bankName.clear();
		bankName.sendKeys("Ngân hàng thương mại cổ phần Á Châu");
		save.click();
	}
	
	public void backUnitInformation() {
		edit.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		back.click();
	}
}
