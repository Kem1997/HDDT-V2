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
	public void laphoadonFail1() {
		// TH khong nhap day du truong bat buoc nhap : Ma khach hang
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		
	}
	
	@Test
	public void laphoadonFail2() {
		// TH khong nhap day du truong bat buoc nhap : Hinh thuc thanh toan
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
	}
	
	@Test
	public void laphoadonFail3() {
		// TH khong nhap day du truong bat buoc nhap : Hinh thuc thanh toan
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
	}
	
	@Test
	public void laphoadonSuccess() throws Exception {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon();
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
}
