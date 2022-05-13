package pages;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Model.DelayedPressEnterThread;
import Model.HangHoa;
import Model.ThongTinHD;
import tests.BaseTest;
import utilities.ReadThongtinchungHD;
import utilities.ReadThongtinhanghoaHD;

public class InvM_InvoiceIssuePage extends BaseTest {

	@FindBy(xpath = "//a[contains(text(), 'Quản lý hóa đơn')]")
	static WebElement invoicemanagement;

	@FindBy(xpath = "//a[contains(text(), 'Danh sách HĐ phát hành')]")
	static WebElement invoiceissue;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement selectSerrial;

	@FindBy(xpath = "//button[contains(text(), 'Tìm kiếm')]")
	static WebElement timkiem;

	@FindBy(xpath = "//td[2]//p[2]")
	static WebElement thongtincapma;

	@FindBy(xpath = "//div[@class='dropdown']//button")
	static WebElement thaotac;

	@FindBy(xpath = "//td[7]")
	static WebElement dstrangthai;

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

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;

	@FindBy(xpath = "//button[text()='Chuyển đổi']")
	static WebElement chuyendoi;

	@FindBy(xpath = "//button[contains(text(), 'Thay thế')]")
	static WebElement thaythe;

	@FindBy(xpath = "//button[contains(text(), 'Điều chỉnh')]")
	static WebElement dieuchinh;

	@FindBy(xpath = "//select[@id='Status']")
	static WebElement status;

	@FindBy(xpath = "//input[@id='InvNo']")
	static WebElement invoiceno;

	@FindBy(xpath = "//input[@id='searchKey']")
	static WebElement matracuu;

	@FindBy(xpath = "//input[@id='FromDate']")
	static WebElement fromdate;

	@FindBy(xpath = "//input[@id='ToDate']")
	static WebElement todate;

	@FindBy(xpath = "//input[@id='nameCus']")
	static WebElement tenkhachhang;

	@FindBy(xpath = "//input[@id='CodeTax']")
	static WebElement masothue;

	@FindBy(xpath = "//input[@id='code']")
	static WebElement makhachhang;

	@FindBy(xpath = "//select[@id='typeInvoice']")
	static WebElement kieuhoadon;

	@FindBy(xpath = "//a[text()='>']")
	static WebElement next;

	@FindBy(xpath = "//input[@id='CusCode']")
	static WebElement cuscode;

	@FindBy(xpath = "//input[@id='Buyer']")
	static WebElement byername;

	@FindBy(xpath = "//input[@id='CusName']")
	static WebElement cusname;

	@FindBy(xpath = "//input[@id='CusTaxCode']")
	static WebElement custaxcode;

	@FindBy(xpath = "//input[@id='CusEmail']")
	static WebElement cusmail;

	@FindBy(xpath = "//input[@id='CusAddress']")
	static WebElement cusaddress;

	@FindBy(xpath = "//select[@id='PaymentMethod']")
	static WebElement paymentmethod;

	@FindBy(xpath = "//select[@id='VATRate']")
	static WebElement vatrate;

	@FindBy(xpath = "//button[@onclick='submitForm()']")
	static WebElement luuhd;

	@FindBy(xpath = "//input[@id='mTotal']")
	static WebElement tongtiendichvu;

	@FindBy(xpath = "//input[@id='mVATAmount']")
	static WebElement tienthuegtgt;

	@FindBy(xpath = "//input[@id='mAmount']")
	static WebElement tongcongtientt;

	@FindBy(xpath = "//input[@id='AmountInWords']")
	static WebElement doctien;

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement title;

	@FindBy(xpath = "//button[text()='Xóa']")
	static WebElement delete;

	@FindBy(xpath = "//li[@class='active']")
	public static WebElement titlelaphd;

	@FindBy(xpath = "//button[@id='convertPagination']")
	static WebElement printChuyendoi;

	@FindBy(xpath = "//p[contains(text(),'Người chuyển đổi')]")
	public static WebElement titlechuyendoi;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	static WebElement close;

	@FindBy(xpath = "//button[contains(text(),'Gửi')]")
	static WebElement gui;

	public InvM_InvoiceIssuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInvoiceIssueList() {
		invoiceissue.click();
	}

	public void selectInvoice(String ChonKyHieu, String TrangThai, String SoHoaDon, String MaTraCuu, String TuNgay,
			String DenNgay, String TenKhachHang, String MasoThue, String MaKhachHang, String KieuHoaDon) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Select seri = new Select(selectSerrial);
		seri.selectByVisibleText(ChonKyHieu);

		Select sta = new Select(status);
		sta.selectByVisibleText(TrangThai);

		invoiceno.sendKeys(SoHoaDon);
		matracuu.sendKeys(MaTraCuu);

		fromdate.click();
		fromdate.sendKeys(TuNgay);
		fromdate.sendKeys(Keys.ENTER);

		todate.click();
		todate.sendKeys(DenNgay);
		todate.sendKeys(Keys.ENTER);

		tenkhachhang.sendKeys(TenKhachHang);
		masothue.sendKeys(MasoThue);
		makhachhang.sendKeys(MaKhachHang);

		Select khd = new Select(kieuhoadon);
		khd.selectByVisibleText(KieuHoaDon);

		timkiem.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickThaoTac() {
		WebElement donghd1 = driver.findElement(By.xpath("//tbody//tr[1]"));
		WebElement thaotacdong1 = donghd1.findElement(By.xpath("//td[9]//button"));
		thaotacdong1.click();
	}

	public void clickchuyendoihd() {
		clickThaoTac();
		selectchuyendoi.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		chuyendoi.click();

		DelayedPressEnterThread thr = new DelayedPressEnterThread("DelayedPressEnterThread", 5000);

		printChuyendoi.click();

		clickThaoTac();
		selectchuyendoi.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		chuyendoi.click();
	}

	public void clickthaythehd() {
		clickThaoTac();
		selectthaythe.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		thaythe.click();
	}

	public void clickdieuchinhtthd() {
		clickThaoTac();
		selectdieuchinhthongtin.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		dieuchinh.click();
	}

	public void clickdieuchinhthd() {
		clickThaoTac();
		selectdieuchinhhd.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		dieuchinh.click();
	}

	public void clickCloseView() {
		close.click();
	}

	public void layMaHoaDon() {
		WebElement donghd1 = driver.findElement(By.xpath("//tbody//tr[1]"));
		WebElement chondonghd1 = donghd1.findElement(By.xpath("//td[11]/input"));
		WebElement trangthaihd1 = donghd1.findElement(By.xpath("//td[2]//p[2]"));

		if (trangthaihd1.getText().equals("Chưa lấy mã của CQT")) {
			chondonghd1.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			laymahoadon.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			gui.click();

			try {
				Thread.sleep(7000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			timkiem.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public List<ThongTinHD> getThongTinHDThayThe(String casetest) {
		List<ThongTinHD> listthongtinhdthaythe = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoathaythe = new ArrayList<HangHoa>();
		try {
			listthongtinhdthaythe = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHDThayThe_" + casetest + ".xlsx", 0);
			listhanghoathaythe = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoaThayThe_" + casetest + ".xlsx", 0);

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
		List<HangHoa> listhanghoadctt = new ArrayList<HangHoa>();
		try {
			listthongtinhddctt = ReadThongtinchungHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinHDDCThongTin_" + casetest + ".xlsx", 0);
			listhanghoadctt = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoaDcThongTin_" + casetest + ".xlsx", 0);

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
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHDDCTien_" + casetest + ".xlsx", 0);
			listhanghoadct = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoaDCTien_" + casetest + ".xlsx", 0);

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

	public void laphdthaythe(String casetest) throws Exception {

		List<ThongTinHD> listthongtinhdthaythe = new ArrayList<ThongTinHD>();
		listthongtinhdthaythe = getThongTinHDThayThe(casetest);

		for (int i = 0; i < listthongtinhdthaythe.size(); i++) {
			if (listthongtinhdthaythe.get(i) != null) {
				cuscode.clear();
				cuscode.sendKeys(listthongtinhdthaythe.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhdthaythe.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhdthaythe.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhdthaythe.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhdthaythe.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhdthaythe.get(i).getHinhthucthanhtoan());
				vatrate.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Chon thue GTGT
				List<WebElement> optionsToSelectVat = driver.findElements(By.xpath("//select[@id='VATRate']//option"));
				for (WebElement option : optionsToSelectVat) {
					if (option.getText().equals(listthongtinhdthaythe.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}
			float totalhh = 0, totalck = 0, total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhdthaythe.get(i).dshanghoa;
			int k = 0;
			for (int j = 0; j < listhh.size(); j++) {
				k++;
				if (listhh.get(j) != null) {

					// Lay dong hang hoa
					WebElement stt = driver.findElement(By.xpath("//td[text()='" + k + "']"));

					// Chon Hinh thuc
					WebElement hinhthuc = driver.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[3]"));
					hinhthuc.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<WebElement> optionsToSelectHinhthuc = driver
							.findElements(By.xpath("//td[text()='" + k + "']//parent::tr//div//select//option"));
					for (WebElement option : optionsToSelectHinhthuc) {
						if (option.getText().contains(listhh.get(j).getHinhthuc())) {
							option.click();
							break;
						}
					}

					// Tinh tong tien dich vu
					if (listhh.get(j).getHinhthuc().equals("Hàng hóa")) {
						totalhh = totalhh + Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());
					}

					if (listhh.get(j).getHinhthuc().equals("Chiết khấu")) {
						totalck = totalck - Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());
					}

					total = totalck + totalhh;
					if (total < 0) {
						throw new Exception("Tiền chiết khấu không được vượt quá tiền hóa đơn.");
					}

					// Lay ten hang hoa
					WebElement tenhanghoa = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[4]//input"));
					tenhanghoa.clear();
					tenhanghoa.sendKeys(listhh.get(j).getTenhanghoa());

					WebElement donvitinh = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[5]//input"));
					donvitinh.clear();
					donvitinh.sendKeys(listhh.get(j).getDonvitinh());

					WebElement soluong = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[6]//input"));
					soluong.clear();
					soluong.sendKeys(listhh.get(j).getSoluong());

					WebElement dongia = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[7]//input"));
					dongia.clear();
					dongia.sendKeys(listhh.get(j).getDongia());

					// Kiem tra thanh tien dong
					WebElement thanhtien = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[8]//input"));
					thanhtien.click();
					String thanhtientextcodauphay = thanhtien.getAttribute("value");
					String thanhtientext = thanhtientextcodauphay.replace(",", "");
					Float thanhtienso = Float.parseFloat(thanhtientext);
					if (Float.parseFloat(listhh.get(j).getSoluong())
							* Float.parseFloat(listhh.get(j).getDongia()) != thanhtienso) {
						throw new Exception("SAI O HANG HOA " + listhh.get(j).getTenhanghoa() + "O HOA DON" + i);
					}

					// Xoa dong hang hoa va tinh lai tong tien
					WebElement xoadonghanghoa = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[1]"));

					if (listhh.get(j).getXoa().equals(false)) {
						xoadonghanghoa.click();
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						delete.click();
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if (listhh.get(j).getHinhthuc().equals("Hàng hóa")) {
							totalhh = totalhh - Float.parseFloat(listhh.get(j).getSoluong())
									* Float.parseFloat(listhh.get(j).getDongia());
						}

						if (listhh.get(j).getHinhthuc().equals("Chiết khấu")) {
							totalck = totalck + Float.parseFloat(listhh.get(j).getSoluong())
									* Float.parseFloat(listhh.get(j).getDongia());
						}
						total = total - Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());

						k--;
					}

				}
			}

			// So sanh tong tien dich vu
			if (Float.parseFloat(tongtiendichvu.getAttribute("value").replace(",", "")) != total) {
				throw new Exception("SAI TONG TIEN DICH VU O HOA DON" + i);
			}

			// Tinh Tien thue GTGT va Tong cong tien thanh toan theo tung loai thue suat
			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("0%")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("3.5%")) {
				vatamount = (total * 7 / 2) / 100;
				amount = total + vatamount;
			}
			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("7%")) {
				vatamount = (total * 7) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("8%")) {
				vatamount = (total * 8) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("Không chịu thuế")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhdthaythe.get(i).getThueGTGT().equals("Không kê khai thuế")) {
				vatamount = 0;
				amount = total;
			}

			// So sanh Tien thue GTGT
			if (Float.parseFloat(tienthuegtgt.getAttribute("value").replace(",", "")) != vatamount) {
				throw new Exception("SAI TIEN THUE GTGT O HOA DON " + i);
			}

			// So sanh Tong cong tien thanh toan
			if (Float.parseFloat(tongcongtientt.getAttribute("value").replace(",", "")) != amount) {
				throw new Exception("SAI TONG CONG TIEN THANH TOAN O HOA DON " + i);
			}

			luuhd.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void laphddieuchinhtt(String casetest) throws Exception {

		List<ThongTinHD> listthongtinhddieuchinhtt = new ArrayList<ThongTinHD>();
		listthongtinhddieuchinhtt = getThongTinHDDCThongTin(casetest);

		for (int i = 0; i < listthongtinhddieuchinhtt.size(); i++) {
			if (listthongtinhddieuchinhtt.get(i) != null) {
				cuscode.clear();
				cuscode.sendKeys(listthongtinhddieuchinhtt.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhddieuchinhtt.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhddieuchinhtt.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhddieuchinhtt.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhddieuchinhtt.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhddieuchinhtt.get(i).getHinhthucthanhtoan());
			}

			List<HangHoa> listhh = listthongtinhddieuchinhtt.get(i).dshanghoa;
			int k = 0;
			for (int j = 0; j < listhh.size(); j++) {
				k++;
				if (listhh.get(j) != null) {

					// Lay dong hang hoa
					WebElement stt = driver.findElement(By.xpath("//td[text()='" + k + "']"));

					// Chon Hinh thuc
					WebElement hinhthuc = driver.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[3]"));
					hinhthuc.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<WebElement> optionsToSelectHinhthuc = driver
							.findElements(By.xpath("//td[text()='" + k + "']//parent::tr//div//select//option"));
					for (WebElement option : optionsToSelectHinhthuc) {
						if (option.getText().contains(listhh.get(j).getHinhthuc())) {
							option.click();
							break;
						}
					}

					// Lay ten hang hoa
					WebElement tenhanghoa = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[4]//input"));
					tenhanghoa.clear();
					tenhanghoa.sendKeys(listhh.get(j).getTenhanghoa());

					WebElement donvitinh = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[5]//input"));
					donvitinh.clear();
					donvitinh.sendKeys(listhh.get(j).getDonvitinh());

					WebElement soluong = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[6]//input"));
					soluong.clear();
					soluong.sendKeys(listhh.get(j).getSoluong());

					WebElement dongia = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[7]//input"));
					dongia.clear();
					dongia.sendKeys(listhh.get(j).getDongia());

					if (Integer.parseInt(tongtiendichvu.getAttribute("value")) != 0) {
						throw new Exception("HIEN THI SAI TONG TIEN DICH VU CUA HOA DON DIEU CHINH THONG TIN");
					}

					if (Integer.parseInt(tienthuegtgt.getAttribute("value")) != 0) {
						throw new Exception("HIEN THI SAI TIEN THUE GTGT CUA HOA DON DIEU CHINH THONG TIN");
					}

					if (Integer.parseInt(tongcongtientt.getAttribute("value")) != 0) {
						throw new Exception("HIEN THI SAI TONG CONG TIEN THANH TOAN CUA HOA DON DIEU CHINH THONG TIN");
					}

					if (!(doctien.getAttribute("value")).equals("Không đồng")) {
						throw new Exception("HIEN THI SAI SO TIEN BANG CHU CUA HOA DON DIEU CHINH THONG TIN");
					}

					luuhd.click();
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
	}

	public void laphddieuchinhtien(String casetest) throws Exception {

		List<ThongTinHD> listthongtinhddctien = new ArrayList<ThongTinHD>();
		listthongtinhddctien = getThongTinHDDCTien(casetest);

		for (int i = 0; i < listthongtinhddctien.size(); i++) {
			if (listthongtinhddctien.get(i) != null) {
				cuscode.clear();
				cuscode.sendKeys(listthongtinhddctien.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhddctien.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhddctien.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhddctien.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhddctien.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhddctien.get(i).getHinhthucthanhtoan());
				vatrate.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Chon thue GTGT
				List<WebElement> optionsToSelectVat = driver.findElements(By.xpath("//select[@id='VATRate']//option"));
				for (WebElement option : optionsToSelectVat) {
					if (option.getText().equals(listthongtinhddctien.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}
			float totalhh = 0, totalck = 0, total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhddctien.get(i).dshanghoa;
			int k = 0;
			for (int j = 0; j < listhh.size(); j++) {
				k++;
				if (listhh.get(j) != null) {

					// Lay dong hang hoa
					WebElement stt = driver.findElement(By.xpath("//td[text()='" + k + "']"));

					// Chon Hinh thuc
					WebElement hinhthuc = driver.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[3]"));
					hinhthuc.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<WebElement> optionsToSelectHinhthuc = driver
							.findElements(By.xpath("//td[text()='" + k + "']//parent::tr//div//select//option"));
					for (WebElement option : optionsToSelectHinhthuc) {
						if (option.getText().contains(listhh.get(j).getHinhthuc())) {
							option.click();
							break;
						}
					}

					// Tinh tong tien dich vu
					if (listhh.get(j).getHinhthuc().equals("Hàng hóa")) {
						totalhh = totalhh + Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());
					}

					if (listhh.get(j).getHinhthuc().equals("Chiết khấu")) {
						totalck = totalck - Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());
					}

					total = totalck + totalhh;
					if (total < 0) {
						throw new Exception("Tiền chiết khấu không được vượt quá tiền hóa đơn.");
					}

					// Lay ten hang hoa
					WebElement tenhanghoa = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[4]//input"));
					tenhanghoa.clear();
					tenhanghoa.sendKeys(listhh.get(j).getTenhanghoa());

					WebElement donvitinh = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[5]//input"));
					donvitinh.clear();
					donvitinh.sendKeys(listhh.get(j).getDonvitinh());

					WebElement soluong = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[6]//input"));
					soluong.clear();
					soluong.sendKeys(listhh.get(j).getSoluong());

					WebElement dongia = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[7]//input"));
					dongia.clear();
					dongia.sendKeys(listhh.get(j).getDongia());

					// Kiem tra thanh tien dong
					WebElement thanhtien = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[8]//input"));
					thanhtien.click();
					String thanhtientextcodauphay = thanhtien.getAttribute("value");
					String thanhtientext = thanhtientextcodauphay.replace(",", "");
					Float thanhtienso = Float.parseFloat(thanhtientext);
					if (Float.parseFloat(listhh.get(j).getSoluong())
							* Float.parseFloat(listhh.get(j).getDongia()) != thanhtienso) {
						throw new Exception("SAI O HANG HOA " + listhh.get(j).getTenhanghoa() + "O HOA DON" + i);
					}

					// Xoa dong hang hoa va tinh lai tong tien
					WebElement xoadonghanghoa = driver
							.findElement(By.xpath("//td[text()='" + k + "']//parent::tr//td[1]"));
					if (listhh.get(j).getXoa().equals(false)) {
						xoadonghanghoa.click();
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						delete.click();
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if (listhh.get(j).getHinhthuc().equals("Hàng hóa")) {
							totalhh = totalhh - Float.parseFloat(listhh.get(j).getSoluong())
									* Float.parseFloat(listhh.get(j).getDongia());
						}

						if (listhh.get(j).getHinhthuc().equals("Chiết khấu")) {
							totalck = totalck + Float.parseFloat(listhh.get(j).getSoluong())
									* Float.parseFloat(listhh.get(j).getDongia());
						}
						total = total - Float.parseFloat(listhh.get(j).getSoluong())
								* Float.parseFloat(listhh.get(j).getDongia());

						k--;
					}

				}
			}

			// So sanh tong tien dich vu
			if (Float.parseFloat(tongtiendichvu.getAttribute("value").replace(",", "")) != total) {
				throw new Exception("SAI TONG TIEN DICH VU O HOA DON" + i);
			}

			// Tinh Tien thue GTGT va Tong cong tien thanh toan theo tung loai thue suat
			if (listthongtinhddctien.get(i).getThueGTGT().equals("0%")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("3.5%")) {
				vatamount = (total * 7 / 2) / 100;
				amount = total + vatamount;
			}
			if (listthongtinhddctien.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("7%")) {
				vatamount = (total * 7) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("8%")) {
				vatamount = (total * 8) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("Không chịu thuế")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhddctien.get(i).getThueGTGT().equals("Không kê khai thuế")) {
				vatamount = 0;
				amount = total;
			}

			// So sanh Tien thue GTGT
			if (Float.parseFloat(tienthuegtgt.getAttribute("value").replace(",", "")) != vatamount) {
				throw new Exception("SAI TIEN THUE GTGT O HOA DON " + i);
			}

			// So sanh Tong cong tien thanh toan
			if (Float.parseFloat(tongcongtientt.getAttribute("value").replace(",", "")) != amount) {
				throw new Exception("SAI TONG CONG TIEN THANH TOAN O HOA DON " + i);
			}

			luuhd.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void xoabohoadon() {
		checkchon.click();
		xoabohoadon.click();
	}

	public void checkTrangThaiHoaDon() {
		// Nếu trạng thái hóa đơn là Bị thay thế hoặc xóa bỏ: thì Không hiển thị nút
		// Thao tác
		if (dstrangthai.getText().contains("Bị thay thế")) {
			thaotac.isDisplayed();
			thaotac.isEnabled();

		}
	}

	// Hàm này để check số lượng hóa đơn trên báo cáo Bảng kê chi tiết
	public Integer checkSoLuongHDTrongDanhSach() {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvManagement();
		clickInvoiceIssueList();
		selectInvoice("1C22TGT", "--Trạng thái--", "", "", "01/03/2022", "18/03/2022", "", "", "", "--Tất cả--");
		List<WebElement> nextlist = driver.findElements(By.xpath("//a[text()='>']"));
		while (!nextlist.isEmpty() && nextlist != null) {
			next.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			nextlist = driver.findElements(By.xpath("//a[text()='>']")); // Gan lai gia tri next list để kiem tra lại
																			// xem cai list co trong hay khong
		}

		List<WebElement> donghoadon = driver.findElements(By.xpath("//tbody//tr"));
		int k = donghoadon.size();
		WebElement soluonghd = driver.findElement(By.xpath("//tbody//tr[" + k + "]//td[1]"));
		int b = Integer.parseInt(soluonghd.getText());
		return b;
	}
}
