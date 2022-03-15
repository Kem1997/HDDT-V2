package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class Rep_TinhHinhSuDungHDPage extends BaseTest {
	
	@FindBy(xpath = "//a[@href='/ReportsInv/reports']")
	static WebElement report;
	
	@FindBy(xpath = "//a[@href='/UsedInvoice/reports']")
	static WebElement tinhhinhsudunghd;
	
	@FindBy(xpath = "//select[@id='quater']")
	static WebElement quater;
	
	@FindBy(xpath = "//select[@id='year']")
	static WebElement year;
	
	@FindBy(xpath = "//button[contains(text(), 'Báo cáo nhanh')]")
	static WebElement baocaonhanh;
	
	@FindBy(xpath = "//center[contains(text(), 'BÁO CÁO TÌNH HÌNH SỬ DỤNG HÓA ĐƠN')]")
	static WebElement titlebaocao;
	
	@FindBy(xpath = "//center[contains(text(), 'BÁO CÁO TÌNH HÌNH SỬ DỤNG HÓA ĐƠN')]//i")
	static WebElement kytinhthue;
	
	public Rep_TinhHinhSuDungHDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBaocao() {
		report.click();
	}
	
	public void clickTinhHinhSuSungHD() {
		tinhhinhsudunghd.click();
	}
	
	public void selectTinhHinhSuDungHD(String quy, String nam) {
		Select qua = new Select(quater);
		qua.selectByVisibleText(quy);
		
		Select ye = new Select(year);
		ye.selectByVisibleText(nam);
		
		baocaonhanh.click();
	}
	
	public Boolean checkBaoCao(String quy, String nam) {
		String ktt = kytinhthue.getText();
		String[] tachchuoitheoquy=ktt.split("Quý "); // Tach chuoi
		String[]  tachchuoitheocach =tachchuoitheoquy[1].split(" ");// lấy phần sau
		String textquy=tachchuoitheocach[0];
		String textnam=tachchuoitheocach[2];
		if (textquy!=quy || textnam!=nam) {
			return false;
		} else {
			return true;
		}
		
	}
}
