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
	public void laphoadon1dongSuccess() throws Exception {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case4");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
	
	@Test
	public void laphoadonnhieudongSuccess() throws Exception {
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDon("case5");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
	}
}
