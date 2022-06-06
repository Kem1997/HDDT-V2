package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class TD_BTHChiTietPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/TongHopCTHD/Index']")
	static WebElement bangtonghopchitiet;
	
	@FindBy(xpath = "//select[@id='month']")
	static WebElement chonThang;
	
	@FindBy(xpath = "//select[@id='year']")
	static WebElement chonNam;
	
	@FindBy(xpath = "//button[contains(text(), 'Tìm kiếm')]")
	static WebElement timkiem;
	
	@FindBy(xpath = "//a[@href='/TongHopCTHD/CreateBTH']")
	static WebElement guithongdiep;
	
	@FindBy(xpath = "//input[@id='bosung']")
	static WebElement bosung;
	
	@FindBy(xpath = "//button[contains(text(), 'Tạo bảng tổng hợp')]")
	static WebElement taobangtonghop;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement message;
	
	@FindBy(xpath = "//a[@href='/TongHopCTHD/Create']")
	static WebElement taomoi;
	
	@FindBy(xpath = "//select[@id='serial']")
	static WebElement kyhieu;
	
	@FindBy(xpath = "//input[@id='invoicetime']")
	static WebElement ngayhd;
	
	@FindBy(xpath = "//button[contains(text(), 'TẠO MỚI')]")
	static WebElement btnTaoMoi;
	
	public TD_BTHChiTietPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickBTHChiTiet() {
		bangtonghopchitiet.click();
	}
	
	public void createBTHchitiet(String KyHieu, String NgayHD) {
		taomoi.click();
		
		Select kh = new Select(kyhieu);
		kh.selectByVisibleText(KyHieu);
		
		ngayhd.click();
		ngayhd.sendKeys(NgayHD);
		ngayhd.sendKeys(Keys.ENTER);
		
		btnTaoMoi.click();
	}
	
	public void createBTHLanDau(String Thang, String Nam) {
		guithongdiep.click();
		
		Select thang = new Select(chonThang);
		thang.selectByVisibleText(Thang);
		
		Select nam = new Select(chonNam);
		nam.selectByVisibleText(Nam);
		
		taobangtonghop.click();
	}
	
	public void createBTHBoSung(String Thang, String Nam) {
		guithongdiep.click();
		
		Select thang = new Select(chonThang);
		thang.selectByVisibleText(Thang);
		
		Select nam = new Select(chonNam);
		nam.selectByVisibleText(Nam);
		
		bosung.click();
		taobangtonghop.click();
	}
}
