package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.DriverFactory;
import utilities.Links;
import utilities.VariableCollections;

public class BaseTest {
	public WebDriver driver;
	//Hàm chạy trước kh test, dùng để khởi tạo driver
	@BeforeTest
	@Parameters( {"testname"} )// dùng để lấy ra giá trị testname trong file xml 
	public void setUp(String testname) { // khai báo 1 tham số truyền vào có giá trị bằng giá trị của testname dòng trên
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		// Chạy ngầm
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--disable-gpu","--ignore-certificate-errors","--disable-extensions",
//				"--no-sandbox","--disable-dev-shm-usage","--disable-renderer-backgrounding",
//				"--disable-background-timer-throttling","--disable-backgrounding-occluded-windows","--window-size=1920,1080","--start-maximized");
//		driver = new ChromeDriver(options);
		// Không chạy ngầm
		driver = new ChromeDriver();
		DriverFactory.getInstance().setDriver(driver);// Tạo ra 1 driver riêng biệt cho từng luồng chạy
		driver=DriverFactory.getInstance().getDriver();// gán giá trị cho driver trống
		VariableCollections.map.put(testname,driver); // cho giá trị của driver vào danh sách tương ứng với testname
		driver.get(Links.URL_LOGIN);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterTest
	public void tearDown() {
		DriverFactory.getInstance().removeDriver();
	}
	
	public WebDriver getDriver (){
        return DriverFactory.getInstance().getDriver();
    }
}
