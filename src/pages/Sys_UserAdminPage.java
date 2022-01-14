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

public class Sys_UserAdminPage extends BaseTest{
	
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
	public static WebElement message;
	
	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement acc;
	
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
		
		//click checkbox
		ckbapproved.click();
		ckbadmin.click();
	}
	
	public void addUser( String AccountName, String FullName, String Email, String PassWord, String RetypePassword ) {
		accountname.sendKeys(AccountName);
		fullname.sendKeys(FullName);
		email.sendKeys(Email);
		password.sendKeys(PassWord);
		retypePassword.sendKeys(RetypePassword);
		checkbox();
		save.click();
	}
	
	public void addUserNotApproved( String AccountName, String FullName, String Email, String PassWord, String RetypePassword ) {
		accountname.sendKeys(AccountName);
		fullname.sendKeys(FullName);
		email.sendKeys(Email);
		password.sendKeys(PassWord);
		retypePassword.sendKeys(RetypePassword);
		save.click();
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
	
//	public void getAccountList1() {
//		int sumpage = Integer
//				.parseInt(driver.findElement(By.xpath("//div[@class='ng-isolate-scope']")).getAttribute("pages-count"));
//
//		for (int i = 1; i <= sumpage; i++) {
//			ArrayList<String> accountList = new ArrayList<>();
//			List<WebElement> accountElementList = driver.findElements(By.xpath("//tbody//tr//td[3]"));
//			// lấy ra contractlist
//
//			for (WebElement a : accountElementList) {
//				String ac = a.getText();
//				accountList.add(ac);
//			}
//
//			// kiểm tra đk trong contractlist có chứa HĐ ko,có thì dùng vòng for để click vào
//			// cái đó
//			if (accountList.contains("HD21072021")) {
//				for (int j = 0; j < accountList.size(); j++) {
//					if (accountList.get(j).equals("HD21072021")) {
//					int a = j + 1;
//					WebElement b = driver.findElement(By.xpath("//tbody//tr[" + a + "]//td[6]/a[1]"));
//					b.click();
//					}
//				}
//				break;
//			}
//
//			// nếu không thì kiểm tra đk không chứa và sumpage để click
//			if ((!accountList.contains("HD21072021")) && i < sumpage) {
//				next.click();
//				this.waitClickAble(getDriver(), Sys_UserAdminPage.add);
//			}
//		}
//	}
}
