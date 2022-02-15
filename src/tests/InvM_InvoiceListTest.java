package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvM_InvoiceListPage;

public class InvM_InvoiceListTest extends BaseTest{
	
	@Test
	public void clickInvoiceManagement() {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvManagement();
	}
	
	@Test
	public void laphoadonFail1() throws Exception {
		// TH khong nhap day du truong bat buoc nhap : Ma khach hang
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case1");
		Assert.assertTrue(getDriver().getCurrentUrl().contains("http://uat-admin78.laphoadon.vn/TaxInvoice/create"));
	}
	
	@Test
	public void laphoadonFail2() throws Exception {
		// TH khong nhap day du truong bat buoc nhap : Hinh thuc thanh toan
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.lapHoaDon("case2");
		Assert.assertTrue(getDriver().getCurrentUrl().contains("http://uat-admin78.laphoadon.vn/TaxInvoice/create"));
	}
	
	@Test
	public void laphoadonFail3() throws Exception {
		// TH khong nhap day du truong bat buoc nhap : Ten hang hoa
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.lapHoaDon("case3");
		Assert.assertTrue(getDriver().getCurrentUrl().contains("http://uat-admin78.laphoadon.vn/TaxInvoice/create"));
	}
	
	@Test
	public void laphoadonFail4() throws Exception {
		// TH dong dau tien nhap la chiet khau
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.lapHoaDon("case4");
		Assert.assertEquals(invlistPg.messageError.getText(), "Tiền chiết khấu không được vượt quá tiền hóa đơn.");
	}
	
	@Test
	public void laphoadonFail5() throws Exception {
		// TH dong tien chiet khau nhieu hon tien hang hoa
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.lapHoaDon("case5");
		Assert.assertEquals(invlistPg.messageError.getText(), "Tiền chiết khấu không được vượt quá tiền hóa đơn.");
	}
	
	@Test
	public void laphoadon1dongSuccess() throws Exception {
		// TH HD 1 dòng
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case6");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonnhieudongSuccess() throws Exception {
		// TH HD nhieu dong
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case7");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonkhongchiuthue() throws Exception {
		// TH thue suat: Khong chiu thue
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case8");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue0() throws Exception {
		// TH thue suat: 0%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case9");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue5() throws Exception {
		// TH thue suat: 5%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case10");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue10() throws Exception {
		// TH thue suat: 10%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case11");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncokhuyenmai() throws Exception {
		// TH dong hoa don co khuyen mai
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case12");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncochietkhau() throws Exception {
		// TH dong hoa don co chiet khau
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case13");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncoghichu() throws Exception {
		// TH dong hoa don co ghi chu
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case14");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphdcotatcahinhthuc() throws Exception {
		// TH dong hoa don tat ca cac hinh thuc hang hoa 
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case15");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void suahoadon() throws Exception {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickSuaHoaDon();
		invlistPg.suaHoaDon("case1");
	}
}
