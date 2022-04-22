package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.INavigatorPanel;

import pages.InvM_InvoiceIssuePage;
import pages.InvM_InvoiceListPage;


public class InvM_InvoiceIssueTest extends BaseTest {
	
	@Test
	public void thaythehdchualaymacqt() throws Exception {
		// TH thay the hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void dieuchinhtthdchualaymacqt() {
		// TH dieu chinh thong tin hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickdieuchinhtthd();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void dieuchinhtienhdchualaymacqt() {
		// TH thay the hoa don chua lay ma cua co quan thue
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.messageError.getText(), "Hóa đơn chưa được cấp mã của CQT.");
	}
	
	@Test
	public void chuyendoihdchualaymacqt() {
		// Th chuyen doi hoa don chua lay ma cua cqt
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickInvoiceIssueList();
		invissuelistPg.clickchuyendoihd();
		Assert.assertEquals(invissuelistPg.titlechuyendoi.getText(), "Người chuyển đổi");
		invissuelistPg.clickCloseView();
	}
	
	@Test
	public void chuyendoihdlaymacqt() {
		// TH chuyen doi hoa don: chuyen doi hoa don thanh cong
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		invissuelistPg.clickchuyendoihd();
		Assert.assertEquals(invissuelistPg.titlechuyendoi.getText(), "Người chuyển đổi");
	}
	
	@Test
	public void thaythehdthanhcong1() throws Exception {
		// TH thay the hoa don: thay doi thong tin chung hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn thay thế");
		invissuelistPg.laphdthaythe("case1");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void thaythehdthanhcong2() throws Exception {
		// TH thay the hoa don: thay doi thue suat hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn thay thế");
		invissuelistPg.laphdthaythe("case2");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void thaythehdthanhcong3() throws Exception {
		// TH thay the hoa don: them dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn thay thế");
		invissuelistPg.laphdthaythe("case3");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void thaythehdthanhcong4() throws Exception {
		// TH thay the hoa don: bot(xoa) dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn thay thế");
		invissuelistPg.laphdthaythe("case4");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void thaythehdthanhcong5() throws Exception {
		// TH thay the hoa don: thay doi(sua don gia hoac thanh tien) dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickthaythehd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn thay thế");
		invissuelistPg.laphdthaythe("case5");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhttthanhcong1() throws Exception {
		// TH khong sua thong tin hoa don: chi dien ghi chu hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhtthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtt("case1");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhttthanhcong2() throws Exception {
		// TH sua thong tin hoa don va dien ghi chu hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhtthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtt("case2");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhtangtienthanhcong1() throws Exception {
		// TH dieu chinh tang: tang thue hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case1");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhtangtienthanhcong2() throws Exception {
		// TH dieu chinh tang: tang so luong 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case2");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhtangtienthanhcong3() throws Exception {
		// TH dieu chinh tang: tang don gia 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case3");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhtangtienthanhcong4() throws Exception {
		// TH dieu chinh tang: them 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case4");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong1() throws Exception {
		// TH dieu chinh giam: giam thue hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case5");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong2() throws Exception {
		// TH dieu chinh giam: giam so luong 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case6");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong3() throws Exception {
		// TH dieu chinh giam: giam don gia 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case7");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong4() throws Exception {
		// TH dieu chinh giam: bot(xoa) 1 dong hang hoa hoa don
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case8");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
	
	@Test
	public void dieuchinhgiamtienthanhcong5() throws Exception {
		// TH dieu chinh giam: them 1 dong chiet khau
		InvM_InvoiceListPage invlistPg;
		invlistPg = new InvM_InvoiceListPage(getDriver());
		
		InvM_InvoiceIssuePage invissuelistPg;
		invissuelistPg = new InvM_InvoiceIssuePage(getDriver());
		
		invlistPg.clickInvManagement();
		invlistPg.clickInvoiceList();
		invlistPg.clickCreateInvoice();
		invlistPg.lapHoaDonTruocDCThayThe("case1");
		Assert.assertEquals(invlistPg.title.getText(), "Tạo mới hóa đơn thành công.");
		invlistPg.selectInvoice();
		invlistPg.phathanh1hd();
		Assert.assertEquals(invlistPg.title.getText(), "Phát hành thành công: 1 hóa đơn");
		
		invissuelistPg.clickdieuchinhthd();
		Assert.assertEquals(invissuelistPg.titlelaphd.getText(), "Lập hóa đơn điều chỉnh, thay thế");
		invissuelistPg.laphddieuchinhtien("case9");
		Assert.assertEquals(invissuelistPg.messageError.getText(), "");
	}
}
