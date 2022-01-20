package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class Sys_UserAuthorPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/Company/DetailCurrent']/i")
	static WebElement system;

	@FindBy(xpath = "//a[@href='/IDManager']")
	static WebElement userAuthorization;

	@FindBy(xpath = "//a[@href='/IDManager/Create/']")
	static WebElement add;

	@FindBy(xpath = "//input[@id='name']")
	static WebElement name;

	@FindBy(xpath = "//input[@id='Title']")
	static WebElement displayname;

	@FindBy(xpath = "//input[@id='all']")
	static WebElement ckball;

	@FindBy(xpath = "//input[@value='View_home']")
	public static WebElement ckbviewhome;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	static WebElement save;

	@FindBy(xpath = "//button[@class='btn']")
	static WebElement back;
	
	@FindBy(xpath = "//h4")
	public static WebElement title;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;
	
	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement authorname;
	
	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;

	public Sys_UserAuthorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSystem() {
		system.click();
	}
	
	public void clickUserAuthorization() {
		userAuthorization.click();
	}

	public void clickAddRole() {
		add.click();
	}

	public void checkbox() {

		// Kiểm tra xem nút checkbox có hiển thị trên Trang web hay không
		boolean ckballIsDisplayed = ckball.isDisplayed();

		// Kiểm tra trạng thái lựa chọn nút checkbox mặc định
		boolean ckballIsSelected = ckball.isSelected();
	}

	public void addRole(String Name, String DisplayName) {
		name.sendKeys(Name);
		displayname.sendKeys(DisplayName);
		checkbox();
		ckball.click();
		save.click();
	}
	
	public void addRoleNotPermission(String Name, String DisplayName) {
		name.sendKeys(Name);
		displayname.sendKeys(DisplayName);
		save.click();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void clickEditAuthorization(String author) {
		if (authorname.getText().equals(author)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[4]/a"));
			b.click();
		}
	}

	public void editAuthorization(String DisplayName) {
		displayname.clear();
		displayname.sendKeys(DisplayName);
		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteAuthorization(String author) {
		if (authorname.getText().equals(author)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[5]/a"));
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
