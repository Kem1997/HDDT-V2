package utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

private DriverFactory(){
		
	}
	private static DriverFactory instance = new DriverFactory();
	public static DriverFactory getInstance(){
		return instance;
	}
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();// tạo driver mới cho từng luồng
	public WebDriver getDriver(){
		return driver.get();
	}
	public void setDriver(WebDriver driverParam){
		driver.set(driverParam);
	}
	public void removeDriver(){
		driver.get().quit();
		driver.remove();
	}

}
