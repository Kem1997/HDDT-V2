package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public InvM_InvoiceListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInvManagement() {
		invoicemanagement.click();
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
			listthongtinhd = ReadThongtinchungHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinHD_" + casetest +  ".xlsx",
					0);
			listhanghoa = ReadThongtinhanghoaHD.readExcel(
					System.getProperty("user.dir") + "/data/dataThongtinhanghoa_" + casetest + ".xlsx",
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

	public void lapHoaDon(String casetest) throws Exception  {
		List<ThongTinHD> listthongtinhd = new ArrayList<ThongTinHD>();
		listthongtinhd = getThongTinHD(casetest);
		for (int i = 0; i < listthongtinhd.size(); i++) {
			if (listthongtinhd.get(i) != null) {
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
					if (option.getText().contains(listthongtinhd.get(i).getThueGTGT())) {
						option.click();
						break;
					}
				}
			}

			float total = 0, vatamount = 0, amount = 0;

			List<HangHoa> listhh = listthongtinhd.get(i).dshanghoa;
			for (int j = 0; j < listhh.size(); j++) {
				if (listhh.get(j) != null) {

					// Lay dong hang hoa
					WebElement stt = driver.findElement(By.xpath("//td[text()='" + (2+1) + "']"));
					WebElement dongchuahanghoa = stt.findElement(By.xpath("//parent::tr"));

					// Chon Hinh thuc
					WebElement hinhthuc = dongchuahanghoa.findElement(By.xpath("//td[3]"));
					hinhthuc.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<WebElement> optionsToSelectHinhthuc = dongchuahanghoa
							.findElements(By.xpath("//div//select//option"));
					for (WebElement option : optionsToSelectHinhthuc) {
						if (option.getText().contains(listhh.get(j).getHinhthuc())) {
							option.click();
							break;
						}
					}

					// Lay ten hang hoa
					WebElement tenhanghoa = dongchuahanghoa.findElement(By.xpath("//td[4]//input"));
					tenhanghoa.clear();
					tenhanghoa.sendKeys(listhh.get(j).getTenhanghoa());

					WebElement donvitinh = dongchuahanghoa.findElement(By.xpath("//td[5]//input"));
					donvitinh.clear();
					donvitinh.sendKeys(listhh.get(j).getDonvitinh());

					WebElement soluong = dongchuahanghoa.findElement(By.xpath("//td[6]//input"));
					soluong.clear();
					soluong.sendKeys(listhh.get(j).getSoluong());

					WebElement dongia = dongchuahanghoa.findElement(By.xpath("//td[7]//input"));
					dongia.clear();
					dongia.sendKeys(listhh.get(j).getDongia());
					
					// Kiem tra thanh tien dong
					WebElement thanhtien = dongchuahanghoa.findElement(By.xpath("//td[8]//input"));
					thanhtien.click();
					String thanhtientextcodauphay = thanhtien.getAttribute("value");
					String thanhtientext=thanhtientextcodauphay.replace(",", "");
					Float thanhtienso = Float.parseFloat(thanhtientext);
					if (Float.parseFloat(listhh.get(j).getSoluong())
							* Float.parseFloat(listhh.get(j).getDongia()) != thanhtienso) {
						throw new Exception("SAI O HANG HOA " + listhh.get(j).getTenhanghoa() + "O HOA DON" + i);
					}

					// Tinh tong tien dich vu
					total = total + Float.parseFloat(listhh.get(j).getSoluong())
							* Float.parseFloat(listhh.get(j).getDongia());
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
			if (listthongtinhd.get(i).getThueGTGT().equals("5%")) {
				vatamount = (total * 5) / 100;
				amount = total + vatamount;
			}

			if (listthongtinhd.get(i).getThueGTGT().equals("10%")) {
				vatamount = (total * 10) / 100;
				amount = total + vatamount;
			}
			if (listthongtinhd.get(i).getThueGTGT().equals("Không thuế GTGT")) {
				vatamount = 0;
				amount = total;
			}

			// So sanh Tien thue GTGT
			if (Float.parseFloat(tienthuegtgt.getAttribute("value").replace(",", "")) != vatamount) {
				throw new Exception("SAI TIEN THUE GTGT O HOA DON" + i);
			}

			// So sanh Tong cong tien thanh toan
			if (Float.parseFloat(tongcongtientt.getAttribute("value").replace(",", "")) != amount) {
				throw new Exception("SAI TONG CONG TIEN THANH TOAN O HOA DON" + i);
			}

			save.click();
		}
	}
}
