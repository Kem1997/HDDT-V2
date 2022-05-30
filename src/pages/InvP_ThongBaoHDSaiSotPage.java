package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class InvP_ThongBaoHDSaiSotPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/ThongBaoHDSS/Index']")
	static WebElement thongbaohdsaisot;

	@FindBy(xpath = "//input[@id='keyword']")
	static WebElement keyword;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement fromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement todate;

	@FindBy(xpath = "//button[text()='Tìm kiếm']")
	static WebElement timkiem;

	@FindBy(xpath = "//a[text()='Tạo mới']")
	static WebElement taomoi;

	@FindBy(xpath = "//input[@id='TNNT']")
	static WebElement tennguoinopthue;

	@FindBy(xpath = "//input[@id='MST']")
	static WebElement masothue;

	@FindBy(xpath = "//input[@id='STBCQT']")
	static WebElement sothongbaocuacqt;

	@FindBy(xpath = "//input[@id='NTBCCQT']")
	static WebElement ngaythongbaocuacqt;

	@FindBy(xpath = "//input[@id='TCQT']")
	static WebElement tencqt;

	@FindBy(xpath = "//input[@id='MCQT']")
	static WebElement macqt;

	@FindBy(xpath = "//input[@id='DDanh']")
	static WebElement diadanh;

	@FindBy(xpath = "//input[@id='MDVQHNSach']")
	static WebElement madonviquanhengansach;

	@FindBy(xpath = "//button[text()='Thêm']")
	static WebElement them;

	@FindBy(xpath = "//tr//td[3]//input")
	static WebElement macqtcap;

	@FindBy(xpath = "//tr//td[4]//input")
	static WebElement mauso;

	@FindBy(xpath = "//tr//td[5]//input")
	static WebElement kyhieu;

	@FindBy(xpath = "//tr//td[6]//input")
	static WebElement sohoadon;

	@FindBy(xpath = "//tr//td[7]//input")
	static WebElement ngayhoadon;

	@FindBy(xpath = "//tr//td[8]//select")
	static WebElement loaiapdung;

	@FindBy(xpath = "//tr//td[9]//select")
	static WebElement tinhchat;

	@FindBy(xpath = "//tr//td[10]//input")
	static WebElement lydo;

	@FindBy(xpath = "//button[text()='Lưu']")
	static WebElement luu;

	@FindBy(xpath = "//tr[1]//td[11]//a[@title='Edit']")
	static WebElement editdong1;

	@FindBy(xpath = "//tr[1]//td[11]//a[@title='Delete']")
	static WebElement deletedong1;

	@FindBy(xpath = "//tr[1]//td[12]//input")
	static WebElement chon;

	@FindBy(xpath = "//button[text()=' Gửi thông báo']")
	static WebElement guithongbao;

	@FindBy(xpath = "//button[@id='alertify-ok']")
	static WebElement ok;

	@FindBy(xpath = "//h3")
	public static WebElement title;

	@FindBy(xpath = "//h4")
	public static WebElement titlecreate;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement message;

	public InvP_ThongBaoHDSaiSotPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickThongBaoHDSaiSot() {
		thongbaohdsaisot.click();
	}

	public void selectThongTin(String KeyWord, String TuNgay, String DenNgay) {
		keyword.sendKeys(KeyWord);

		fromdate.click();
		fromdate.sendKeys(TuNgay);
		fromdate.sendKeys(Keys.ENTER);

		todate.click();
		todate.sendKeys(DenNgay);
		todate.sendKeys(Keys.ENTER);

		timkiem.click();
	}

	public void clickTaoMoi() {
		taomoi.click();
	}

	public void createThongBaoHDSaiSot(String SoThongBaoCuaCQT, String NgayThongBaoCuaCQT, String TenCQT, String MaCQT,
			String DiaDanh, String MaDVQHNganSach, String MaCQTCap, String MauSo, String KyHieu, String SoHoaDon,
			String NgayHoaDon, String LoaiApDung, String TinhChat, String LyDo) {

		driver.navigate().refresh();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		sothongbaocuacqt.sendKeys(SoThongBaoCuaCQT);

		ngaythongbaocuacqt.click();
		ngaythongbaocuacqt.sendKeys(NgayThongBaoCuaCQT);
		ngaythongbaocuacqt.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		tencqt.sendKeys(TenCQT);
		macqt.sendKeys(MaCQT);
		diadanh.sendKeys(DiaDanh);
		madonviquanhengansach.sendKeys(MaDVQHNganSach);

		macqtcap.sendKeys(MaCQTCap);
		mauso.sendKeys(MauSo);
		kyhieu.sendKeys(KyHieu);
		sohoadon.sendKeys(SoHoaDon);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ngayhoadon.click();
		ngayhoadon.sendKeys(NgayHoaDon);
		ngayhoadon.sendKeys(Keys.ENTER);

		Select lad = new Select(loaiapdung);
		lad.selectByVisibleText(LoaiApDung);

		Select tc = new Select(tinhchat);
		tc.selectByVisibleText(TinhChat);

		lydo.sendKeys(LyDo);

		luu.click();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void editThongBaoHDSaiSot(String SoThongBaoCuaCQT, String NgayThongBaoCuaCQT, String TenCQT, String MaCQT,
			String DiaDanh, String MaDVQHNganSach, String MaCQTCap, String MauSo, String KyHieu, String SoHoaDon,
			String NgayHoaDon, String LoaiApDung, String TinhChat, String LyDo) {

		editdong1.click();
		driver.navigate().refresh();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sothongbaocuacqt.sendKeys(SoThongBaoCuaCQT);

		ngaythongbaocuacqt.click();
		ngaythongbaocuacqt.sendKeys(NgayThongBaoCuaCQT);
		ngaythongbaocuacqt.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		tencqt.sendKeys(TenCQT);
		macqt.sendKeys(MaCQT);
		diadanh.sendKeys(DiaDanh);
		madonviquanhengansach.sendKeys(MaDVQHNganSach);

		macqtcap.sendKeys(MaCQTCap);
		mauso.sendKeys(MauSo);
		kyhieu.sendKeys(KyHieu);
		sohoadon.sendKeys(SoHoaDon);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		ngayhoadon.click();
		ngayhoadon.sendKeys(NgayHoaDon);
		ngayhoadon.sendKeys(Keys.ENTER);

		loaiapdung.sendKeys(LoaiApDung);
		tinhchat.sendKeys(TinhChat);
		lydo.sendKeys(LyDo);

		luu.click();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteThongBaoHDSaiSot() {
		deletedong1.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		ok.click();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void guiThongBaoHDSaiSot() {
		chon.click();
		guithongbao.click();
	}
}
