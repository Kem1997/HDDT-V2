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
	public void laphoadonkhongkekhaithue() throws Exception {
		// TH thue suat: Khong ke khai thue
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case9");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue0() throws Exception {
		// TH thue suat: 0%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case10");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue3() throws Exception {
		// TH thue suat: 3.5%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case11");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue5() throws Exception {
		// TH thue suat: 5%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case12");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue7() throws Exception {
		// TH thue suat: 7%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case13");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue8() throws Exception {
		// TH thue suat: 8%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case14");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonthue10() throws Exception {
		// TH thue suat: 10%
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case15");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncokhuyenmai() throws Exception {
		// TH dong hoa don co khuyen mai
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case16");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncochietkhau() throws Exception {
		// TH dong hoa don co chiet khau
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case17");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadoncoghichu() throws Exception {
		// TH dong hoa don co ghi chu
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case18");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphdcotatcahinhthuc() throws Exception {
		// TH dong hoa don tat ca cac hinh thuc hang hoa 
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case19");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void suahoadon() throws Exception {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.selectInvoice();
		invlistPg.clickSuaHoaDon();
		invlistPg.suaHoaDon("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Cập nhật hóa đơn thành công.");
	}
	
	@Test
	public void xoahoadon() {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.selectInvoice();
		invlistPg.deleteInvoice();
		Assert.assertEquals(invlistPg.title.getText(), "Xóa hóa đơn thành công.");
	}
	
	@Test
	public void phathanhkhongchonhoadon() {
		// TH loi do khong chon hoa don phat hanh
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.selectInvoice();
		invlistPg.phathanhhd.click();
		Assert.assertEquals(invlistPg.messagephathanh.getText(), "Cần chọn hóa đơn để phát hành.");
		invlistPg.okphathanhloi.click();
	}
	
	@Test
	public void phathanhthanhcongchon1hd() {
		// TH phat hanh thanh cong tung hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
	}
	
	@Test
	public void phathanhthanhcongnhieuhd() {
		// TH phat hanh thanh cong nhieu hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.selectInvoice();
		invlistPg.phathanhnhieuhd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 3 hóa đơn");
	}
	
	@Test
	public void phathanhthanhcongtatcahd() {
		// TH phat hanh thanh cong nhieu hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.selectInvoice();
		Assert.assertEquals("Phát hành thành công: " + invlistPg.phathanhtatcahd() + " hóa đơn", invlistPg.title.getText());
	}
}
