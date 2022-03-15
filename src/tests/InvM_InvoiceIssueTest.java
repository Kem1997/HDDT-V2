package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.InvM_InvoiceIssuePage;


public class InvM_InvoiceIssueTest extends BaseTest {

	@Test
	public void chuyendoihoadon() {
		
	}
	
	@Test
	public void thaythehdchualaymacqt() {
		// TH thay the hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickInvoiceIssueList();
		invissuelistPg.thaythehdchualayma();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void thaythehdthanhcong1() {
		// TH thay the hoa don: thay doi thong tin chung hoa don
	}
	
	@Test
	public void thaythehdthanhcong2() {
		// TH thay the hoa don: thay doi thue suat hoa don
	}
	
	@Test
	public void thaythehdthanhcong3() {
		// TH thay the hoa don: them dong hang hoa hoa don
	}
	
	@Test
	public void thaythehdthanhcong4() {
		// TH thay the hoa don: bot(xoa) dong hang hoa hoa don
	}
	
	@Test
	public void thaythehdthanhcong5() {
		// TH thay the hoa don: thay doi(sua don gia hoac thanh tien) dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhtthdchualaymacqt() {
		// TH dieu chinh thong tin hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickInvoiceIssueList();
		invissuelistPg.dieuchinhtthdchualayma();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void dieuchinhttthanhcong() {
		
	}
	
	@Test
	public void dieuchinhtienhdchualaymacqt() {
		// TH thay the hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickInvoiceIssueList();
		invissuelistPg.dieuchinhthdchualayma();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void dieuchinhtangtienthanhcong1() {
		// TH dieu chinh tang: tang thue hoa don
	}
	
	@Test
	public void dieuchinhtangtienthanhcong2() {
		// TH dieu chinh tang: tang so luong 1 dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhtangtienthanhcong3() {
		// TH dieu chinh tang: tang don gia 1 dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhtangtienthanhcong4() {
		// TH dieu chinh tang: them 1 dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong1() {
		// TH dieu chinh giam: giam thue hoa don
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong2() {
		// TH dieu chinh giam: giam so luong 1 dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong3() {
		// TH dieu chinh giam: giam don gia 1 dong hang hoa hoa don
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong4() {
		// TH dieu chinh giam: bot(xoa) 1 dong hang hoa hoa don
	}
}
