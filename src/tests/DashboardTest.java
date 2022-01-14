package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;

public class DashboardTest {
	@Test
	public void homepage(WebDriver driver) {
		DashboardPage dashboardPg;
		dashboardPg = new DashboardPage(driver);
		Assert.assertTrue(dashboardPg.isDisplayed(driver));
	}
}
