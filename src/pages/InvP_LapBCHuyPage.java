package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class InvP_LapBCHuyPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/InvoiceCancel/index']")
	static WebElement lapbaocaohuy;

	@FindBy(xpath = "//input[@name='creater']")
	static WebElement nguoilapbieu;

	@FindBy(xpath = "//input[@name='dateFrom']")
	static WebElement fromdate;

	@FindBy(xpath = "//input[@name='dateTo']")
	static WebElement todate;

	@FindBy(xpath = "//button[text()='Tìm kiếm']")
	static WebElement btntimkiem;

	@FindBy(xpath = "//a[@href='/InvoiceCancel/Create/']")
	static WebElement taomoi;

	@FindBy(xpath = "//textarea[@id='Method']")
	static WebElement phuongphaphuy;

	@FindBy(xpath = "//input[@id='ComPrepared']")
	static WebElement nguoitao;

	@FindBy(xpath = "//input[@id='ComRepresent']")
	static WebElement nguoidaidienphapluat;

	@FindBy(xpath = "//button[@id='openner']")
	static WebElement taomoidshdhuy;

	@FindBy(xpath = "//select[@id='InvCateName']")
	static WebElement chonloaihoadon;

	@FindBy(xpath = "//select[@id='InvPattern']")
	static WebElement mauso;

	@FindBy(xpath = "//button[text()='Lưu dữ liệu']")
	static WebElement luudulieu;

	@FindBy(xpath = "//button[text()='Lưu và tạo mới']")
	static WebElement luuvataomoi;

	@FindBy(xpath = "//button[text()='Lưu']")
	static WebElement luu;
	
	@FindBy(xpath = "//h4")
	public static WebElement title;
	
	@FindBy(xpath = "//td[10]/i")
	public static WebElement delete;

	public InvP_LapBCHuyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLapBCHuy() {
		lapbaocaohuy.click();
	}

	public void selectBaoCaoHuy(String NguoiLapBieu, String TuNgay, String DenNgay) {

		nguoilapbieu.sendKeys(NguoiLapBieu);

		fromdate.click();
		fromdate.sendKeys(TuNgay);
		fromdate.sendKeys(Keys.ENTER);

		todate.click();
		todate.sendKeys(DenNgay);
		todate.sendKeys(Keys.ENTER);

		btntimkiem.click();
	}

	public void clickTaoMoi() {
		taomoi.click();
	}

	public void addHoaDonHuy(String LoaiHoaDon, String MauSo) {

		taomoidshdhuy.click();

		Select lhd = new Select(chonloaihoadon);
		lhd.selectByVisibleText(LoaiHoaDon);

		Select ms = new Select(mauso);
		ms.selectByVisibleText(MauSo);

		luudulieu.click();
	}

	public void addHoaDonHuyVaTaoMoi(String LoaiHoaDon, String MauSo) {

		taomoidshdhuy.click();

		Select lhd = new Select(chonloaihoadon);
		lhd.selectByVisibleText(LoaiHoaDon);

		Select ms = new Select(mauso);
		ms.selectByVisibleText(MauSo);

		luuvataomoi.click();
	}

	public void addThongBaoHuyHoaDon(String PhuongPhapHuy, String NguoiTao, String NguoiDaiDienPhapLuat,
			String LoaiHoaDon, String MauSo) {
		
		driver.navigate().refresh();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		phuongphaphuy.sendKeys(PhuongPhapHuy);
		nguoitao.sendKeys(NguoiTao);
		nguoidaidienphapluat.sendKeys(NguoiDaiDienPhapLuat);
		addHoaDonHuy(LoaiHoaDon, MauSo);
		luu.click();
	}
	
	public void deleteDanhSachHDHuy() {
		
		delete.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		delete.sendKeys(Keys.ENTER);
	}
}
