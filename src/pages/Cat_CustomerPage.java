package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class Cat_CustomerPage extends BaseTest {

	@FindBy(xpath = "//a[@href='/Customer/index']")
	static WebElement category;

	@FindBy(xpath = "//a[@href='/Customer/Index']")
	static WebElement customer;

	@FindBy(xpath = "//h4")
	public static WebElement title;

	@FindBy(xpath = "//a[@href='/Customer/Create/']")
	static WebElement addCustomer;

	@FindBy(xpath = "//input[@id='Code']")
	static WebElement code;

	@FindBy(xpath = "//input[@id='TaxCode']")
	static WebElement taxcode;

	@FindBy(xpath = "//input[@id='Name']")
	static WebElement name;

	@FindBy(xpath = "//input[@id='Address']")
	static WebElement address;

	@FindBy(xpath = "//input[@id='Phone']")
	static WebElement phone;

	@FindBy(xpath = "//input[@id='Fax']")
	static WebElement fax;

	@FindBy(xpath = "//input[@id='Email']")
	static WebElement email;

	@FindBy(xpath = "//input[@id='CCEmail']")
	static WebElement cclist;

	@FindBy(xpath = "//input[@id='RepresentPerson']")
	static WebElement contact;

	@FindBy(xpath = "//input[@id='ContactPerson']")
	static WebElement contactperson;

	@FindBy(xpath = "//input[@id='BankNumber']")
	static WebElement banknumber;

	@FindBy(xpath = "//input[@id='BankAccountName']")
	static WebElement bankaccountname;

	@FindBy(xpath = "//input[@id='BankName']")
	static WebElement bankname;

	@FindBy(xpath = "//textarea[@id='Descriptions']")
	static WebElement descriptions;

	@FindBy(xpath = "//select[@id='CusType']")
	static WebElement customertype;

	@FindBy(xpath = "//button[contains(text(), 'Lưu dữ liệu')]")
	static WebElement save;

	@FindBy(xpath = "//button[contains(string(), 'Quay lại')]")
	public static WebElement back;

	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;

	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement cus;

	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;

	public Cat_CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCategory() {
		category.click();
	}

	public void clickCustomer() {
		customer.click();
	}

	public void clickAddCustomer() {
		addCustomer.click();
	}

	public void selectCustomerType(String cust) {
		Select dropdown = new Select(customertype);
		dropdown.selectByVisibleText(cust);
	}

	public void addCustomer(String Code, String TaxCode, String Name, String Address, String Phone, String Fax,
			String Email, String CCLisst, String Contact, String ContactPerson, String BankNumber,
			String BankAccountName, String BankName, String Descriptions) {
		code.sendKeys(Code);
		taxcode.sendKeys(TaxCode);
		name.sendKeys(Name);
		address.sendKeys(Address);
		phone.sendKeys(Phone);
		fax.sendKeys(Fax);
		email.sendKeys(Email);
		cclist.sendKeys(CCLisst);
		contact.sendKeys(Contact);
		contactperson.sendKeys(ContactPerson);
		banknumber.sendKeys(BankNumber);
		bankaccountname.sendKeys(BankAccountName);
		bankname.sendKeys(BankName);
		descriptions.sendKeys(Descriptions);
		selectCustomerType("Khách hàng lẻ");
		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public static Boolean checkCustomer(String customer, String customer1) {
		Boolean result;
		result = customer.contains(customer1);
		return result;
	}

	public void clickEditCustomer(String customer) {
		if (cus.getText().equals(customer)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[9]//a"));
			b.click();
		}
	}

	public void editCustomer(String TaxCode, String Name, String Address, String Phone, String Fax, String Email,
			String CCLisst, String Contact, String ContactPerson, String BankNumber, String BankAccountName,
			String BankName, String Descriptions) {
		taxcode.clear();
		taxcode.sendKeys(TaxCode);

		name.clear();
		name.sendKeys(Name);

		address.clear();
		address.sendKeys(Address);

		phone.clear();
		phone.sendKeys(Phone);

		fax.clear();
		fax.sendKeys(Fax);

		email.clear();
		email.sendKeys(Email);

		cclist.clear();
		cclist.sendKeys(CCLisst);

		contact.clear();
		contact.sendKeys(Contact);

		contactperson.clear();
		contactperson.sendKeys(ContactPerson);

		banknumber.clear();
		banknumber.sendKeys(BankNumber);

		bankaccountname.clear();
		bankaccountname.sendKeys(BankAccountName);

		bankname.clear();
		bankname.sendKeys(BankName);

		descriptions.clear();
		descriptions.sendKeys(Descriptions);

		selectCustomerType("Khách hàng lẻ");
		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteCustomer(String customer) {
		if (cus.getText().equals(customer)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[10]//a"));
			b.click();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ok.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
