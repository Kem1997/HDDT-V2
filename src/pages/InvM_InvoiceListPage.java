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
import org.testng.Assert;

import Model.HangHoa;
import Model.ThongTinHD;
import tests.BaseTest;
import utilities.ReadThongtinchungHD;
import utilities.ReadThongtinhanghoaHD;

public class InvM_InvoiceListPage extends BaseTest {

	@FindBy(xpath = "//a[contains(text(), 'Quản lý hóa đơn')]")
	static WebElement invoicemanagement;

	@FindBy(xpath = "//a[contains(text(), 'Danh sách HĐ mới')]")
	static WebElement invoicelist;

	@FindBy(xpath = "//a[@id='crtInvoice']")
	static WebElement create;

	@FindBy(xpath = "//select[@id='Serial']")
	static WebElement serial;

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

	@FindBy(xpath = "//textarea[@id='Note']")
	static WebElement note;

	@FindBy(xpath = "//select[@id='VATRate']")
	static WebElement vatrate;

	@FindBy(xpath = "//button[@id='submitInv']")
	static WebElement save;

	@FindBy(xpath = "//input[@id='mTotal']")
	static WebElement tongtiendichvu;

	@FindBy(xpath = "//input[@id='mVATAmount']")
	static WebElement tienthuegtgt;

	@FindBy(xpath = "//input[@id='mAmount']")
	static WebElement tongcongtientt;

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement title;

	@FindBy(xpath = "//p[text()='Tiền chiết khấu không được vượt quá tiền hóa đơn.']")
	public static WebElement messageError;

	@FindBy(xpath = "//button[text()='Xóa']")
	static WebElement delete;

	@FindBy(xpath = "//button[text()='Xóa']")
	static WebElement selectSerrial;

	@FindBy(xpath = "//button[contains(text(), 'Tìm kiếm')]")
	static WebElement timkiem;

	@FindBy(xpath = "//button[@id='alertify-ok']")
	static WebElement ok;

	@FindBy(xpath = "//button[contains(text(),'Phát hành hóa đơn')]")
	public static WebElement phathanhhd;

	@FindBy(xpath = "//p[contains(text(), 'Cần chọn hóa đơn để phát hành.')]")
	public static WebElement messagephathanh;

	@FindBy(xpath = "//button[contains(text(), 'OK')]")
	public static WebElement okphathanhloi;

	@FindBy(xpath = "//button[contains(text(), 'OK')]")
	public static WebElement phathanhthanhcong;

	public InvM_InvoiceListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInvManagement() {
		invoicemanagement.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickInvoiceList() {
		invoicelist.click();
	}

	public void clickCreateInvoice() {
		create.click();
	}

	public List<ThongTinHD> getThongTinHD(String casetest) {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoa = new ArrayList<HangHoa>();
		try {
			listthongtinhd = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHD_" + casetest + ".xlsx", 0);
			listhanghoa = ReadThongtinhanghoaHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinhanghoa_" + casetest + ".xlsx", 0);

			for (ThongTinHD thongtinhd : listthongtinhd) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoa) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhd;
	}

	public void lapHoaDon(String casetest) throws Exception {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		listthongtinhd = getThongTinHD(casetest);
		for (int i = 0; i < listthongtinhd.size(); i++) {
			if (listthongtinhd.get(i) != null) {
				Select seri = new Select(serial);
				seri.selectByVisibleText(listthongtinhd.get(i).getSerial());
				
				cuscode.clear();
				cuscode.sendKeys(listthongtinhd.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhd.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhd.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhd.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhd.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhd.get(i).getHinhthucthanhtoan());
				note.clear();
				note.sendKeys(listthongtinhd.get(i).getGhichu());
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
					if (option.getText().equals(listthongtinhd.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}

			float totalhh = 0, totalck = 0, total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhd.get(i).dshanghoa;
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
			if (listthongtinhd.get(i).getThueGTGT().equals("0%")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("3.5%")) {
				vatamount = (total * 7 / 2) / 100;
				amount = total + vatamount;
			}
			if (listthongtinhd.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("7%")) {
				vatamount = (total * 7) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("8%")) {
				vatamount = (total * 8) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không chịu thuế")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không kê khai thuế")) {
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

			save.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void selectInvoice() {
		Select seri = new Select(serial);
		seri.selectByVisibleText("1C22TBB");
		timkiem.click();
	}

	public void clickSuaHoaDon() {
		WebElement sua_ds = driver.findElement(By.xpath("//td[contains(text(),'3')]//parent::tr//td[8]//a"));
		sua_ds.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<ThongTinHD> getThongTinHDSua(String casetest) {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoa = new ArrayList<HangHoa>();
		try {
			listthongtinhd = ReadThongtinchungHD
					.readExcel(System.getProperty("user.dir") + "/data/dataThongtinHDSua_" + casetest + ".xlsx", 0);
			listhanghoa = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoaSua_" + casetest + ".xlsx", 0);

			for (ThongTinHD thongtinhd : listthongtinhd) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoa) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhd;
	}

	public void suaHoaDon(String casetest) throws Exception {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		listthongtinhd = getThongTinHDSua(casetest);

		// Clear tat ca cac dong hang hoa
		List<WebElement> inputs = driver.findElements(By.xpath("//tbody//tr//input"));
		for (WebElement input : inputs) {
			input.clear();
		}

		for (int i = 0; i < listthongtinhd.size(); i++) {
			if (listthongtinhd.get(i) != null) {
				Select seri = new Select(serial);
				seri.selectByVisibleText(listthongtinhd.get(i).getSerial());

				cuscode.clear();
				cuscode.sendKeys(listthongtinhd.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhd.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhd.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhd.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhd.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhd.get(i).getHinhthucthanhtoan());
				note.clear();
				note.sendKeys(listthongtinhd.get(i).getGhichu());
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
					if (option.getText().equals(listthongtinhd.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}

			float totalhh = 0, totalck = 0, total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhd.get(i).dshanghoa;
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
					tenhanghoa.click();
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
				throw new Exception("SAI TONG TIEN DICH VU O HOA DON " + i);
			}

			// Tinh Tien thue GTGT va Tong cong tien thanh toan theo tung loai thue suat
			if (listthongtinhd.get(i).getThueGTGT().equals("0%")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("3.5%")) {
				vatamount = (total * 7 / 2) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("7%")) {
				vatamount = (total * 7) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("8%")) {
				vatamount = (total * 8) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không chịu thuế")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không kê khai thuế")) {
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

			save.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void deleteInvoice() {
		WebElement xoa_ds = driver.findElement(By.xpath("//td[contains(text(),'2')]//parent::tr//td[9]//a"));
		xoa_ds.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ok.click();
	}

	public void phathanh1hd() {
		// Chi chon 1 hoa don. Vd hoa don dau tien
		WebElement chon1hd = driver.findElement(By.xpath("//td[contains(text(),'1')]//parent::tr//td[10]//input"));
		chon1hd.click();
		phathanhhd.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void phathanhnhieuhd() {
		// Phat hanh khoang 3-5 hoa don
		WebElement chonhd1 = driver.findElement(By.xpath("//td[contains(text(),'1')]//parent::tr//td[10]//input"));
		chonhd1.click();
		WebElement chonhd2 = driver.findElement(By.xpath("//td[contains(text(),'2')]//parent::tr//td[10]//input"));
		chonhd2.click();
		WebElement chonhd3 = driver.findElement(By.xpath("//td[contains(text(),'3')]//parent::tr//td[10]//input"));
		chonhd3.click();
		phathanhhd.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int phathanhtatcahd() {
		// Phat hanh tat ca hoa don cua 1 trang
		List<WebElement> soluonghd = driver.findElements(By.xpath("//tbody//tr"));
		int i = soluonghd.size();
		WebElement chontatca = driver.findElement(By.xpath("//input[@id='ckbAll']"));
		chontatca.click();
		phathanhhd.click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	// Hàm này để lấy thông tin hóa đơn- phục vụ những hóa đơn lập xong rồi điều
	// chỉnh thay thế luôn
	public List<ThongTinHD> getThongTinHDTruocDCThayThe(String casetest) {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		List<HangHoa> listhanghoa = new ArrayList<HangHoa>();
		try {
			listthongtinhd = ReadThongtinchungHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinHDTruocDCThayThe_" + casetest + ".xlsx", 0);
			listhanghoa = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoaTruocDCThayThe_" + casetest + ".xlsx",
					0);

			for (ThongTinHD thongtinhd : listthongtinhd) {
				List<HangHoa> listhh = new ArrayList<HangHoa>();
				for (HangHoa hanghoa : listhanghoa) {
					if (thongtinhd.getStt().equals(hanghoa.getStt())) {
						listhh.add(hanghoa);
					}
				}
				thongtinhd.dshanghoa = listhh;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listthongtinhd;
	}

	// Hàm này để lập hóa đơn- phục vụ những hóa đơn lập xong rồi điều chỉnh thay
	// thế luôn
	public void lapHoaDonTruocDCThayThe(String casetest) throws Exception {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		listthongtinhd = getThongTinHDTruocDCThayThe(casetest);
		for (int i = 0; i < listthongtinhd.size(); i++) {
			if (listthongtinhd.get(i) != null) {
				Select seri = new Select(serial);
				seri.selectByVisibleText(listthongtinhd.get(i).getSerial());

				cuscode.clear();
				cuscode.sendKeys(listthongtinhd.get(i).getMakhachhang());
				byername.clear();
				byername.sendKeys(listthongtinhd.get(i).getHotennguoimua());
				cusname.clear();
				cusname.sendKeys(listthongtinhd.get(i).getDonvimua());
				custaxcode.clear();
				custaxcode.sendKeys(listthongtinhd.get(i).getMasothue());
				cusaddress.clear();
				cusaddress.sendKeys(listthongtinhd.get(i).getDiachi());
				paymentmethod.sendKeys(listthongtinhd.get(i).getHinhthucthanhtoan());
				note.clear();
				note.sendKeys(listthongtinhd.get(i).getGhichu());
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
					if (option.getText().equals(listthongtinhd.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}

			float totalhh = 0, totalck = 0, total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhd.get(i).dshanghoa;
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
			if (listthongtinhd.get(i).getThueGTGT().equals("0%")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("3.5%")) {
				vatamount = (total * 7 / 2) / 100;
				amount = total + vatamount;
			}
			if (listthongtinhd.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("7%")) {
				vatamount = (total * 7) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("8%")) {
				vatamount = (total * 8) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không chịu thuế")) {
				vatamount = 0;
				amount = total;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("Không kê khai thuế")) {
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

			save.click();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
