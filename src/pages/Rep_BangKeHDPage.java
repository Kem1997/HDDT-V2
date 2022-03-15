package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class Rep_BangKeHDPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/ReportsInv/reportsmonth']")
	static WebElement bangkehd;

	@FindBy(xpath = "//select[@id='Month']")
	static WebElement month;

	@FindBy(xpath = "//select[@id='year']")
	static WebElement year;

	@FindBy(xpath = "//button[contains(text(), ' Báo cáo')]")
	static WebElement baocao;

	@FindBy(xpath = "//center/b[2]")
	static WebElement titlebaocao;

	@FindBy(xpath = "//center[contains(text(), 'BÁO CÁO TÌNH HÌNH SỬ DỤNG HÓA ĐƠN')]//i")
	static WebElement kytinhthue;

	@FindBy(xpath = "//tr[td[contains(., '1. Hàng hoá, dịch vụ không chịu thuế giá trị gia tăng (GTGT):')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[2]")
	static WebElement dschuathue_kchiuthue;
	
	@FindBy(xpath = "//tr[td[contains(., '1. Hàng hoá, dịch vụ không chịu thuế giá trị gia tăng (GTGT):')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[3]")
	static WebElement thue_kchiuthue;
	
	@FindBy(xpath = "//tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[2]")
	static WebElement dschuathue_thue0;
	
	@FindBy(xpath = "//tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[3]")
	static WebElement thue_thue0;
	
	@FindBy(xpath = "//tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[2]")
	static WebElement dschuathue_thue5;
	
	@FindBy(xpath = "//tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[3]")
	static WebElement thue_thue5;
	
	@FindBy(xpath = "//tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[2]")
	static WebElement dschuathue_thue10;
	
	@FindBy(xpath = "//tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]/following-sibling::tr[td[contains(., 'Tổng Cộng')]][1]//td[3]")
	static WebElement thue_thue10;

	public Rep_BangKeHDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickBangkeHD() {
		bangkehd.click();
	}

	public void selectBangKeHD(String thang, String nam) {
		Select mon = new Select(month);
		mon.selectByVisibleText(thang);

		Select ye = new Select(year);
		ye.selectByVisibleText(nam);

		baocao.click();
	}

	public Boolean checkThongTinChungBaoCao(String thang, String nam) {
		String ktt = kytinhthue.getText();
		String[] tachchuoitheothang = ktt.split("tháng "); // Tach chuoi
		String[] tachchuoitheocach = tachchuoitheothang[1].split(" ");// lấy phần sau
		String textthang = tachchuoitheocach[0];
		String textnam = tachchuoitheocach[2];
		if (textthang != thang || textnam != nam) {
			return false;
		} else {
			return true;
		}
	}

	public void checkTienBaoCao() {
		// Tinh doanh so ban chua thue - TH khong chiu thue
		
	}
}
