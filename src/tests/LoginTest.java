package tests;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.Links;

public class LoginTest extends BaseTest{
	
	LoginPage loginPg;
	DashboardPage dashboardPg;
	
	@Test
	public void loginWithBlankField() {
		loginPg = new LoginPage(getDriver());
		loginPg.login("", "");
		Assert.assertEquals(getDriver().getCurrentUrl(), Links.URL_LOGIN);
	}

	@Test
	public void loginByAdmin() {
		loginPg = new LoginPage(getDriver());
		dashboardPg = loginPg.loginsccess(getDriver());
		// Do sau khi login trên web chưa kịp chuyển sang URL_DASHBOARD thì hàm so sánh
		// đã thực hiện so sánh dẫn đến test faile
		// Nên phải thêm 1 hàm đợi
	
		//WebDriverWait wait = new WebDriverWait(getDriver(), 30); // Đợi tối đa 30s
		//wait.until(ExpectedConditions.urlContains(Links.URL_DASHBOARD)); // Đợi đến khi url trên web =
																			// Links.URL_DASHBOARD
		
		Awaitility aw = new Awaitility();
		aw.await().atMost(10, TimeUnit.SECONDS).ignoreExceptions().until(()->getDriver().getCurrentUrl().contains(Links.URL_DASHBOARD));
		
		Assert.assertTrue(dashboardPg.isDisplayed(driver));
	}
	
//	 @Test(dataProvider="loginData")
//	    public void loginFail(String userName, String password) {
//			loginPg = new LoginPage(driver);
//	        loginPg.login(userName, password);
//	        Assert.assertTrue(loginPg.isDisplayed(driver));
//	    }
	     
	     
//	    @DataProvider(name = "loginData")
//	    public Object[][] dataProvider() throws Exception {
//	    	try {
//	        ReadFile.setExcelFile(Links.PATH_TO_EXCEL, "LoginTest");
//	        Object[][] testData = ReadFile.getTestData("invalid");
//	        return testData;
//	    	} catch(Exception ex) {
//	    		return null;
//	    	}
	    	
//	    }
}
