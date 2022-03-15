package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void handleUpload(String pathFile, String fileName)  {
//	selectfile.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",selectfile);
	
		Robot robot;
		try {
			robot = new Robot();
			new Actions(driver).click(selectfile).perform();
			
			// coppy
			StringSelection ss = new StringSelection(fileName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_V);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_V);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			StringSelection ss1 = new StringSelection(pathFile);//"E:\\Auto Test\\HDDT-V2\\data"
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			robot.keyPress(KeyEvent.VK_F4);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_CONTROL);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_A);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_CONTROL);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_V);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_V);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}robot.keyPress(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}robot.keyPress(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//		driver.findElement(By.id("inputFile"));
//		driver.switchTo()
//        .activeElement()
//        .sendKeys("E:\\Auto Test\\HDDT-V2\\data\\MauUploadKH.xlsx");
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
