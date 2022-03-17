package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvM_InvoiceUploadPage;


public class InvM_InvoiceUploadTest extends BaseTest {

	@Test
	public void clickInvoiceUploadSuccess() {
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.clickInvoiceUpload();
	}
	
	@Test
	public void createInvoiceUploadFail1() {
		// TH Không chọn bat ky truong nao
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.clickAddTemplate();
		invoiceUploadPg.handleUploadNotReleased("--Chọn mẫu số--", "--Chọn ký hiệu--", "", "");
		Assert.assertEquals(invoiceUploadPg.messageError.getText(), "Chưa chọn file dữ liệu khách hàng.");
	}
	
	@Test
	public void createInvoiceUploadFail2() {
		// TH Không chọn truong Mau so
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.handleUploadNotReleased("--Chọn mẫu số--", "1C22TGT", "E:\\Auto Test\\HDDT-V2\\data", "MauUploadHoaDon.xlsx");
		Assert.assertEquals(invoiceUploadPg.messageError.getText(), "Cần chọn mẫu số hóa đơn.");
	}
	
	@Test
	public void createInvoiceUploadFail3() {
		// TH Không chọn truong Ky hieu
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.handleUploadNotReleased("1C01T", "--Chọn ký hiệu--", "E:\\Auto Test\\HDDT-V2\\data", "MauUploadHoaDon.xlsx");
		Assert.assertEquals(invoiceUploadPg.messageError.getText(), "Cần chọn ký hiệu hóa đơn.");
	}
	
	@Test
	public void createInvoiceUploadFail4() {
		// TH Không chọn truong File upload
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.clickAddTemplate();
		invoiceUploadPg.handleUploadNotReleased("1C01T", "1C22TGT", "E:\\Auto Test\\HDDT-V2\\data", "");
		Assert.assertEquals(invoiceUploadPg.messageError.getText(), "Chưa chọn file dữ liệu khách hàng.");
	}
	
	@Test
	public void createInvoiceUploadNotReleasedSuccess() {
		// TH upload hoa don moi tao
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.handleUploadNotReleased("1C01T", "1C22TGT", "E:\\Auto Test\\HDDT-V2\\data", "MauUploadHoaDon.xlsx");
		Assert.assertEquals(invoiceUploadPg.title.getText(), "Quản lý upload và phát hành lô hóa đơn");
	}
	
	@Test
	public void createInvoiceUploadReleasedSuccess() {
		// TH upload hoa don phat hanh
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.clickAddTemplate();
		invoiceUploadPg.handleUploadReleased("1C01T", "1C22TGT", "E:\\Auto Test\\HDDT-V2\\data", "MauUploadHoaDon.xlsx");
		Assert.assertEquals(invoiceUploadPg.title.getText(), "Quản lý upload và phát hành lô hóa đơn");
	}
	
	@Test
	public void deleteFileUploadSuccess() {
		InvM_InvoiceUploadPage invoiceUploadPg;
		invoiceUploadPg = new InvM_InvoiceUploadPage(getDriver());
		invoiceUploadPg.deleteFileUpload("MauUploadHoaDon.xlsx");
		Assert.assertEquals(invoiceUploadPg.title.getText(), "Quản lý upload và phát hành lô hóa đơn");
	}
}
