package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class Cat_CustomerUploadPage extends BaseTest {
	
	@FindBy(xpath = "//a[@href='/Transaction/index?TypeTran=1']")
	static WebElement customerupload;

	@FindBy(xpath = "//a[@href='/Transaction/Upload?TypeTran=1']")
	static WebElement addtemplate;

	@FindBy(xpath = "//input[@id='_txtFile']")
	static WebElement selectfile;

	@FindBy(xpath = "//button[@id='uploadButton']")
	public static WebElement btnupload;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-default']")
	static WebElement back;
	
	@FindBy(xpath = "//h3")
	public static WebElement title;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;
	
	@FindBy(xpath = "//div[@class='errorbox']")
	public static WebElement messageError;
	
	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement filename;
	
	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;
	
	@FindBy(xpath = "//tr[1]//td[11]//a")
	public static WebElement delete;

	public Cat_CustomerUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCustomerUpload() {
		customerupload.click();
	}

	public void clickAddTemplate() {
		addtemplate.click();
	}

	public void addTemplate() {
		selectfile.click();
//		driver.findElement(By.id("inputFile"));
		driver.switchTo()
        .activeElement()
        .sendKeys("E:\\Auto Test\\HDDT-V2\\data\\MauUploadKH.xlsx");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		String filePath = System.getProperty(("user.dir")+ filename);
//		selectfile.click();
//		selectfile.sendKeys(filePath);
		btnupload.click();
	}
	
	public void deleteFileUpload(String FileName) {
		if (filename.getText().equals(FileName)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[11]//a"));
			b.click();
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ok.click();
	}
	
	public boolean isEnabled(WebElement ele, String FileName) {
		if (ele.isEnabled() && filename.getText().equals(FileName)) {
			return true;
		} else {
			return false;
		}
	}
}
