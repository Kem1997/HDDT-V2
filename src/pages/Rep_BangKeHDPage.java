package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Model.ThongTinHD;
import tests.BaseTest;

public class Rep_BangKeHDPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/ReportsInv/reportsmonth']")
	static WebElement bangkehd;

	@FindBy(xpath = "//select[@id='Month']")
	static WebElement month;

	@FindBy(xpath = "//select[@id='Year']")
	static WebElement year;

	@FindBy(xpath = "//button[contains(text(), ' Báo cáo')]")
	static WebElement baocao;

	@FindBy(xpath = "//center/b[2]")
	static WebElement titlebaocao;

	@FindBy(xpath = "//center")
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

	@FindBy(xpath = "//*[text()='Tổng doanh thu hàng hoá, dịch vụ bán ra trước thuế (*):']//following-sibling::b")
	static WebElement tongdoanhthu_truocthue;

	@FindBy(xpath = "//*[text()='Tổng doanh thu hàng hoá, dịch vụ bán ra chịu thuế GTGT (*):']//following-sibling::b")
	static WebElement tongdoanhthu_chiuthue;

	@FindBy(xpath = "//*[text()=' Tổng số thuế GTGT của hàng hóa, dịch vụ bán ra(**):']//following-sibling::b")
	static WebElement tongsothue;

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

	public void checkTienBaoCao() throws Exception {

		float totalkchiuthue = 0, vatkchiuthue = 0, totalthue0 = 0, vat0 = 0, totalthue5 = 0, vat5 = 0, totalthue10 = 0,
				vat10 = 0, sumdoanhthutruocthue = 0, sumdoanhthuchiuthue = 0, sumthue = 0;

		// Tinh doanh so ban chua thue - TH khong chiu thue
		List<WebElement> dsokchiuthue = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '1. Hàng hoá, dịch vụ không chịu thuế giá trị gia tăng (GTGT):')]] and following:: tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]]]//td[8]"));
		// Tinh doanh so ban chua thue - TH thue 0%
		List<WebElement> dsothue0 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]] and following:: tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]]]//td[8]"));
		// Tinh doanh so ban chua thue - TH thue 5%
		List<WebElement> dsothue5 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]] and following:: tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]]//td[8]"));
		// Tinh doanh so ban chua thue - TH thue 10%
		List<WebElement> dsothue10 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]]//td[8]"));

		// Tinh thue - TH khong chiu thue
		List<WebElement> thuekchiuthue = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '1. Hàng hoá, dịch vụ không chịu thuế giá trị gia tăng (GTGT):')]] and following:: tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]]]//td[9]"));
		// Tinh thue - TH thue 0%
		List<WebElement> thue0 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '2. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 0%:')]] and following:: tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]]]//td[9]"));
		// Tinh thue - TH thue 5%
		List<WebElement> thue5 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '3. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 5%:')]] and following:: tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]]//td[9]"));
		// Tinh thue - TH thue 10%
		List<WebElement> thue10 = driver.findElements(By.xpath(
				"//tr[preceding::tr[td[contains(., '4. Hàng hoá, dịch vụ chịu thuế suất thuế GTGT 10%:')]]]//td[9]"));

		if (dsokchiuthue.size() != 0) {
			for (int i = 0; i < dsokchiuthue.size(); i++) {
				totalkchiuthue = totalkchiuthue + Float.parseFloat(dsokchiuthue.get(i).getText().replace(",", ""));
				vatkchiuthue = vatkchiuthue + Float.parseFloat(thuekchiuthue.get(i).getText().replace(",", ""));
			}
		}

		if (dsothue0.size() != 0) {
			for (int j = 0; j < dsothue0.size(); j++) {
				totalthue0 = totalthue0 + Float.parseFloat(dsothue0.get(j).getText().replace(",", ""));
				vat0 = vat0 + Float.parseFloat(thue0.get(j).getText().replace(",", ""));
			}
		}

		if (dsothue5.size() != 0) {
			for (int k = 0; k < dsothue5.size(); k++) {
				totalthue5 = totalthue5 + Float.parseFloat(dsothue5.get(k).getText().replace(",", ""));
				vat5 = vat5 + Float.parseFloat(thue5.get(k).getText().replace(",", ""));
			}
		}

		if (dsothue10.size() != 0) {
			for (int a = 0; a < dsothue10.size(); a++) {
				totalthue10 = totalthue10 + Float.parseFloat(dsothue10.get(a).getText().replace(",", ""));
				vat10 = vat10 + Float.parseFloat(thue10.get(a).getText().replace(",", ""));
			}
		}

		if (Float.parseFloat(dschuathue_kchiuthue.getText().replace(",", "")) != totalkchiuthue) {
			throw new Exception("SAI DOANH SO BAN CHUA THUE - TH KHONG CHIU THUE");
		}

		if (Float.parseFloat(dschuathue_thue0.getText().replace(",", "")) != totalthue0) {
			throw new Exception("SAI DOANH SO BAN CHUA THUE - TH THUE SUAT 0%");
		}

		if (Float.parseFloat(dschuathue_thue5.getText().replace(",", "")) != totalthue5) {
			throw new Exception("SAI DOANH SO BAN CHUA THUE - TH THUE SUAT 5%");
		}

		if (Float.parseFloat(dschuathue_thue10.getText().replace(",", "")) != totalthue10) {
			throw new Exception("SAI DOANH SO BAN CHUA THUE - TH THUE SUAT 10%");
		}

		String t = thue_kchiuthue.getText();
		if (t != null && t != "") {
			if (Float.parseFloat(thue_kchiuthue.getText().replace(",", "")) != vatkchiuthue) {
				throw new Exception("SAI TIEN THUE - TH KHONG CHIU THUE");
			}
		}

		if (Float.parseFloat(thue_thue0.getText().replace(",", "")) != vat0) {
			throw new Exception("SAI TIEN THUE - TH THUE SUAT 0%");
		}

		if (Float.parseFloat(thue_thue5.getText().replace(",", "")) != vat5) {
			throw new Exception("SAI TIEN THUE - TH THUE SUAT 5%");
		}

		if (Float.parseFloat(thue_thue10.getText().replace(",", "")) != vat10) {
			throw new Exception("SAI TIEN THUE - TH THUE SUAT 10%");
		}

		sumdoanhthutruocthue = totalkchiuthue + totalthue0 + totalthue5 + totalthue10;

		sumdoanhthuchiuthue = totalthue0 + totalthue5 + totalthue10;

		sumthue = vat0 + vat5 + vat10;

		if (Float.parseFloat(tongdoanhthu_truocthue.getText().replace(",", "")) != sumdoanhthutruocthue) {
			throw new Exception("Sai Tong doanh thu hang hoa, dich vu ban ra truoc thue");
		}

		if (Float.parseFloat(tongdoanhthu_chiuthue.getText().replace(",", "")) != sumdoanhthuchiuthue) {
			throw new Exception("Sai Tong doanh thu hang hoa, dich vu ban ra chiu thue GTGT");
		}

		if (Float.parseFloat(tongsothue.getText().replace(",", "")) != sumthue) {
			throw new Exception("Sai Tong so thue GTGT cua hang hoa, dich vu ban ra");
		}
	}
}
