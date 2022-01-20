package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;
import utilities.Links;

public class Sys_UserAdminPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/Account/index']")
	static WebElement userAdministration;

	@FindBy(xpath = "//a[@href='/Account/Create/']")
	static WebElement add;

	@FindBy(xpath = "//input[@id='username']")
	static WebElement accountname;

	@FindBy(xpath = "//input[@id='FullName']")
	static WebElement fullname;

	@FindBy(xpath = "//input[@id='email']")
	static WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement password;

	@FindBy(xpath = "//input[@id='RetypePassword']")
	static WebElement retypePassword;

	@FindBy(xpath = "//input[@id='approved']")
	static WebElement ckbapproved;

	@FindBy(xpath = "//input[@value='Admin']")
	static WebElement ckbadmin;

	@FindBy(xpath = "//input[@value='QuanTri']")
	static WebElement ckbquantri;

	@FindBy(xpath = "//input[@value='khachhang']")
	static WebElement ckbkhachhang;

	@FindBy(xpath = "//button[contains(text(), 'Lưu')]")
	static WebElement save;

	@FindBy(xpath = "//button[contains(string(), 'Quay lại')]")
	public static WebElement back;

	@FindBy(xpath = "//strong")
	public static WebElement title;

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;
	
	@FindBy(xpath = "//div[@class='errorbox']")
	public static WebElement messageError;

	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement acc;
	
	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;

	public Sys_UserAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickUserAdministration() {
		userAdministration.click();
	}

	public void clickAddUser() {
		add.click();
	}

	public boolean isDisplayed() {
		if (driver.getCurrentUrl().contains(Links.URL_QTNGUOIDUNG)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEnabled(WebElement ele) {
		if (ele.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public void waitClickAble(WebDriver dr, WebElement we) {
		Awaitility aw = new Awaitility();
		aw.await().atMost(10, TimeUnit.SECONDS).ignoreExceptions().until(() -> we.isEnabled() && we.isDisplayed());
	}

	public void checkbox() {

		// Kiểm tra xem nút checkbox có hiển thị trên Trang web hay không
		boolean ckbapprovedIsDisplayed = ckbapproved.isDisplayed();
		boolean ckbadminIsDisplayed = ckbadmin.isDisplayed();
		boolean ckbquantriIsDisplayed = ckbquantri.isDisplayed();
		boolean approvedIsDisplayed = ckbkhachhang.isDisplayed();

		// Kiểm tra trạng thái lựa chọn nút checkbox mặc định
		boolean ckbapprovedIsSelected = ckbapproved.isSelected();
		boolean ckbadminIsSelected = ckbadmin.isSelected();
		boolean ckbquantriIsSelected = ckbquantri.isSelected();
		boolean ckbkhachhangIsSelected = ckbkhachhang.isSelected();
	}

	public void addUser(String AccountName, String FullName, String Email, String PassWord, String RetypePassword) {
		accountname.sendKeys(AccountName);
		fullname.sendKeys(FullName);
		email.sendKeys(Email);
		password.sendKeys(PassWord);
		retypePassword.sendKeys(RetypePassword);
		checkbox();
		// Click checkbox
		ckbapproved.click();
		ckbadmin.click();

		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addUserNotApproved(String AccountName, String FullName, String Email, String PassWord,
			String RetypePassword) {
		accountname.sendKeys(AccountName);
		fullname.sendKeys(FullName);
		email.sendKeys(Email);
		password.sendKeys(PassWord);
		retypePassword.sendKeys(RetypePassword);
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

	public static Boolean checkAccount(String account, String account1) {
		Boolean result;
		result = account.contains(account1);
		return result;
	}

	public void clickEditAccount(String account) {
		if (acc.getText().equals(account)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[8]//a"));
			b.click();
		}
	}

	public void editAccount() {
		checkbox();
		ckbapproved.click();
		ckbkhachhang.click();
		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteAccount(String account) {
		if (acc.getText().equals(account)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[9]//a"));
			b.click();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ok.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
