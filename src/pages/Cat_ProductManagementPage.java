package pages;

import org.hamcrest.core.DescribedAs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;

public class Cat_ProductManagementPage extends BaseTest{
	
	@FindBy(xpath = "//a[@href='/Product/Index']")
	static WebElement productmanagement;
	
	@FindBy(xpath = "//a[@href='/Product/Create/']")
	static WebElement addproduct;
	
	@FindBy(xpath = "//input[@id='Code']")
	static WebElement code;
	
	@FindBy(xpath = "//input[@id='NameProduct']")
	static WebElement name;
	
	@FindBy(xpath = "//input[@id='mPrice']")
	static WebElement price;
	
	@FindBy(xpath = "//select[@id='Unit']")
	static WebElement unit;
	
	@FindBy(xpath = "//select[@id='VATRate']")
	static WebElement vat;
	
	@FindBy(xpath = "//textarea[@id='Description']")
	static WebElement discription;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	static WebElement save;
	
	@FindBy(xpath = "//button[@class='btn']")
	public static WebElement back;
	
	@FindBy(xpath = "//h4")
	public static WebElement title;
	
	@FindBy(xpath = "//div[@class='messagebox']")
	public static WebElement messageSuccess;
	
	@FindBy(xpath = "//p")
	public static WebElement messagePrice;
	
	@FindBy(xpath = "//div[@class='errorbox']")
	public static WebElement messageError;
	
	@FindBy(xpath = "//tr[1]//td[2]")
	public static WebElement productcode;
	
	@FindBy(xpath = "//button[@id='alertify-ok']")
	public static WebElement ok;
	
	@FindBy(xpath = "//a[@href='/Product/Upload/']")
	static WebElement uploadproduct;
	
	public Cat_ProductManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickProductMangement() {
		productmanagement.click();
	}
	
	public void clickAddProduct() {
		addproduct.click();
	}
	
	public void selectOBJ(WebElement ele, String obj) {
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(obj);
	}
	
	public void addProduct(String Code, String Name, String Price, String Discription) {
		code.sendKeys(Code);
		name.sendKeys(Name);
		price.clear();
		price.sendKeys(Price);
		selectOBJ(unit, "Cái");
		selectOBJ(vat, "10 %");
		discription.sendKeys(Discription);
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
	
	public void clickEditProduct(String product) {
		if (productcode.getText().equals(product)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[7]/a"));
			b.click();
		}
	}

	public void editProduct(String Name, String Price, String Discription) {
		name.clear();
		name.sendKeys(Name);
		
		price.clear();
		price.sendKeys(Price);
		
		discription.clear();
		discription.sendKeys(Discription);
		
		save.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteProduct(String Product) {
		if (productcode.getText().equals(Product)) {
			WebElement b = driver.findElement(By.xpath("//tr[1]//td[8]/a"));
			b.click();
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ok.click();
	}
}
