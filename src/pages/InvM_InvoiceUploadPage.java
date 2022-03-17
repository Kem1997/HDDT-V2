package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class InvM_InvoiceUploadPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/Transaction/index?TypeTran=0']")
	static WebElement invoiceUpload;

	@FindBy(xpath = "//a[@href='/Transaction/Upload?TypeTran=0']")
	static WebElement addTemplate;

	@FindBy(xpath = "//select[@id='Pattern']")
	static WebElement pattern;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement serial;

	@FindBy(xpath = "//input[@id='_txtFile']")
	static WebElement selectFile;

	@FindBy(xpath = "//input[@id='IsPublish']")
	static WebElement ckbphathanhluon;

	@FindBy(xpath = "//button[@id='uploadButton']")
	static WebElement buttonUpload;

	@FindBy(xpath = "//*[text()= ' QUAY LẠI']")
	static WebElement buttonBack;

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

	public InvM_InvoiceUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInvoiceUpload() {
		invoiceUpload.click();
	}

	public void clickAddTemplate() {
		addTemplate.click();
	}

	public void handleUploadNotReleased(String Pattern, String Serial, String pathFile, String fileName) {
		Select pat = new Select(pattern);
		pat.selectByVisibleText(Pattern);

		Select ser = new Select(serial);
		ser.selectByVisibleText(Serial);

		// selectFile.click();
		if (pathFile != "" && pathFile != null && fileName != "" && fileName != null) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", selectFile);

			Robot robot;
			try {
				robot = new Robot();
				new Actions(driver).click(selectFile).perform();

				// coppy fileName
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
				StringSelection ss1 = new StringSelection(pathFile);// "E:\\Auto Test\\HDDT-V2\\data"
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
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//			driver.findElement(By.id("inputFile"));
//			driver.switchTo()
//	        .activeElement()
//	        .sendKeys("E:\\Auto Test\\HDDT-V2\\data\\MauUploadKH.xlsx");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			String filePath = System.getProperty(("user.dir")+ filename);
//			selectfile.click();
//			selectfile.sendKeys(filePath);
		buttonUpload.click();
	}

	public void handleUploadReleased(String Pattern, String Serial, String pathFile, String fileName) {
		Select pat = new Select(pattern);
		pat.selectByVisibleText(Pattern);

		Select ser = new Select(serial);
		ser.selectByVisibleText(Serial);

		// selectFile.click();
		if (pathFile != "" && pathFile != null && fileName != "" && fileName != null) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", selectFile);

			Robot robot;
			try {
				robot = new Robot();
				new Actions(driver).click(selectFile).perform();

				// coppy fileName
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
				StringSelection ss1 = new StringSelection(pathFile);// "E:\\Auto Test\\HDDT-V2\\data"
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
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ckbphathanhluon.click();
		}
//			driver.findElement(By.id("inputFile"));
//			driver.switchTo()
//	        .activeElement()
//	        .sendKeys("E:\\Auto Test\\HDDT-V2\\data\\MauUploadKH.xlsx");
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			String filePath = System.getProperty(("user.dir")+ filename);
//			selectfile.click();
//			selectfile.sendKeys(filePath);
		buttonUpload.click();
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
}
