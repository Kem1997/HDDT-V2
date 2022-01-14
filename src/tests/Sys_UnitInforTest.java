package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Sys_UnitInforPage;

public class Sys_UnitInforTest extends BaseTest{
	@Test 
	public void clickSystem() {
		Sys_UnitInforPage unitInforPg;
		unitInforPg = new Sys_UnitInforPage(getDriver());
		unitInforPg.clickSystem();
	}
	
	@Test
	public void editUnitInformationSuccess() {
		Sys_UnitInforPage unitInforPg;
		unitInforPg = new Sys_UnitInforPage(getDriver());
		unitInforPg.clickUnitInformation();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		unitInforPg.editUnitInformation();
//		String actualResult= unitInforPg.message.getText();
//		String expectedResult = "Sửa thông tin công ty phát hành hóa đơn thành công.";
		Assert.assertEquals(unitInforPg.message.getText(), "Sửa thông tin công ty phát hành hóa đơn thành công.");
	}
	
	@Test
	public void backunitInformation() {
		Sys_UnitInforPage unitInforPg;
		unitInforPg = new Sys_UnitInforPage(getDriver());
		unitInforPg.backUnitInformation();
	}
}
