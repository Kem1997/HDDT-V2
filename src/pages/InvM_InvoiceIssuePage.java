package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Model.HangHoa;
import Model.ThongTinHD;
import tests.BaseTest;
import utilities.ReadThongtinchungHD;
import utilities.ReadThongtinhanghoaHD;

public class InvM_InvoiceIssuePage extends BaseTest{
	
	@FindBy(xpath = "//a[contains(text(), 'Quản lý hóa đơn')]")
	static WebElement invoicemanagement;
	
	@FindBy(xpath = "//a[contains(text(), 'Danh sách HĐ phát hành')]")
	static WebElement invoiceissue;
	
	@FindBy(xpath = "//button[text()='Xóa']")
	static WebElement selectSerrial;
	
	@FindBy(xpath = "//button[contains(text(), 'Tìm kiếm')]")
	static WebElement timkiem;
	
	@FindBy(xpath = "//td[2]//p[2]")
	static WebElement thongtincapma;
	
	@FindBy(xpath = "//div[@class='dropdown']//button")
	static WebElement thaotac;
	
	@FindBy(xpath = "//a[contains(text(), 'Chuyển đổi')]")
	static WebElement selectchuyendoi;
	
	@FindBy(xpath = "//a[contains(text(), 'Thay thế')]")
	static WebElement selectthaythe;
	
	@FindBy(xpath = "//a[contains(text(), 'Điều chỉnh hóa đơn')]")
	static WebElement selectdieuchinhhd;
	
	@FindBy(xpath = "//a[contains(text(), 'Điều chỉnh thông tin')]")
	static WebElement selectdieuchinhthongtin;
	
	@FindBy(xpath = "//input[@title='Chọn để xóa bỏ']")
	static WebElement checkchon;
	
	@FindBy(xpath = "//input[@id='ckbAll']")
	static WebElement checkall;
	
	@FindBy(xpath = "//button[contains(text(), 'Tải hóa đơn')]")
	static WebElement taihoadon;
	
	@FindBy(xpath = "//button[contains(text(), 'Xóa bỏ hóa đơn')]")
	static WebElement xoabohoadon;
	
	@FindBy(xpath = "//button[contains(text(), 'Lấy mã hóa đơn')]")
	static WebElement laymahoadon;
	
	@FindBy(xpath = "//div[@class='errorbox']")
	public static WebElement messageError;
	
	@FindBy(xpath = "//button[contains(text(), 'Thay thế')]")
	static WebElement thaythe;
	
	@FindBy(xpath = "//button[contains(text(), 'Điều chỉnh')]")
	static WebElement dieuchinh;
	
	public InvM_InvoiceIssuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInvoiceIssueList() {
		invoiceissue.click();
	}
	
	public void selectInvoice() {
		Select seri = new Select(selectSerrial);
		seri.selectByVisibleText("1C22TKA");
		timkiem.click();
	}
	
	public void chuyendoihoadon() {
		
	}
	
	public List<ThongTinHD> getThongTinHDThayThe(String casetest) {
		List<ThongTinHD> listthongtinhdthaythe = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoathaythe = new ArrayList<HangHoa>();
		try {
			listthongtinhdthaythe = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHD_" + casetest + ".xlsx", 0);
			listhanghoathaythe = ReadThongtinhanghoaHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinhanghoa_" + casetest + ".xlsx", 0);

			for (ThongTinHD thongtinhd : listthongtinhdthaythe) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoathaythe) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhdthaythe;
	}
	
	
	public List<ThongTinHD> getThongTinHDDCThongTin(String casetest) {
		List<ThongTinHD> listthongtinhddctt = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoadctt= new ArrayList<HangHoa>();
		try {
			listthongtinhddctt = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHD_" + casetest + ".xlsx", 0);
			listhanghoadctt = ReadThongtinhanghoaHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinhanghoa_" + casetest + ".xlsx", 0);

			for (ThongTinHD thongtinhd : listthongtinhddctt) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoadctt) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhddctt;
	}
	
	public List<ThongTinHD> getThongTinHDDCTien(String casetest) {
		List<ThongTinHD> listthongtinhddct = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoadct = new ArrayList<HangHoa>();
		try {
			listthongtinhddct = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHD_" + casetest + ".xlsx", 0);
			listhanghoadct = ReadThongtinhanghoaHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinhanghoa_" + casetest + ".xlsx", 0);

			for (ThongTinHD thongtinhd : listthongtinhddct) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoadct) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhddct;
	}
	
	public void chuyendoihdchualayma() {
		
	}
	
	public void thaythehdchualayma() {
		selectInvoice();
		thaotac.click();
		selectthaythe.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		thaythe.click();
	}
	
	public void dieuchinhtthdchualayma() {
		selectInvoice();
		thaotac.click();
		selectdieuchinhthongtin.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		dieuchinh.click();
	}
	
	public void dieuchinhthdchualayma() {
		selectInvoice();
		thaotac.click();
		selectdieuchinhhd.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		dieuchinh.click();
	}
}
