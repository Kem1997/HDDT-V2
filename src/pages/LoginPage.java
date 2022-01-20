package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Links;

public class LoginPage {
	@FindBy(xpath = "//select[@id='taxCode']")
	WebElement user_taxcode;
	
	@FindBy(name = "username")
	WebElement user_login;

	@FindBy(name = "password")
	WebElement user_pass;

	@FindBy(xpath = "//button[contains(text(), 'Đăng nhập')]")
	WebElement submitBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String userName, String password) {
		Select dropdown = new Select(user_taxcode);
		dropdown.selectByVisibleText("CÔNG TY TNHH TOTO VIỆT NAM");
		
		user_login.sendKeys(userName);
		user_pass.sendKeys(password);
		submitBtn.click();
	}

	public boolean isDisplayed(WebDriver driver) {
		if (driver.getCurrentUrl().contains(Links.URL_LOGIN)) {
			return true;
		} else {
			return false;
		}
	}

	public DashboardPage loginsccess(WebDriver driver) {
		Select dropdown = new Select(user_taxcode);
		dropdown.selectByVisibleText("CÔNG TY TNHH TOTO VIỆT NAM");
		
		user_login.sendKeys("admin");
		user_pass.sendKeys("Abcd@123456a");
		submitBtn.click();
		return new DashboardPage(driver);
	}
}
