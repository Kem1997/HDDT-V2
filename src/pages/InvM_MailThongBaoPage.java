package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.BaseTest;

public class InvM_MailThongBaoPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/SendMail/Index']")
	static WebElement mailthongbao;
}
