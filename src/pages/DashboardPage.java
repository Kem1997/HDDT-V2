package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.Links;

public class DashboardPage {
	public DashboardPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public boolean isDisplayed(WebDriver driver) {
		if (Links.URL_DASHBOARD.equals(driver.getCurrentUrl())) {
			return true;
		} else {
			return false;
		}
	}
}
