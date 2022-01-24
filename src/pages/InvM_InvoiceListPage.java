package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.BaseTest;

public class InvM_InvoiceListPage extends BaseTest{

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
	
	public void clickInvManagement() {
		invoicemanagement.click();
	}
}
