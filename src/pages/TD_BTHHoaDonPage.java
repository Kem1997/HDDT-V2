package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class TD_BTHHoaDonPage extends BaseTest {
	
	@FindBy(xpath = "//a[@href='/TongHopHoaDon/Index']")
	static WebElement bangtonghophoadon;
	
	@FindBy(xpath = "//select[@id='month']")
	static WebElement chonThang;
	
	@FindBy(xpath = "//select[@id='year']")
	static WebElement chonNam;
	
	@FindBy(xpath = "//button[contains(text(), 'Tìm kiếm')]")
	static WebElement timkiem;
	
	public TD_BTHHoaDonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBTHHoaDon() {
		bangtonghophoadon.click();
	}
	
	public void timKiemBTHHoaDon(String Thang, String Nam) {
		
		Select thang = new Select(chonThang);
		thang.selectByVisibleText(Thang);
		
		Select nam = new Select(chonNam);
		nam.selectByVisibleText(Nam);
		
		timkiem.click();
	}
}
