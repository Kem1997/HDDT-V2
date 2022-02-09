package Model;

import java.util.List;

public class ThongTinHD {
		private String Stt;
		private String Makhachhang;
		private String Hotennguoimua;
		private String Donvimua;
		private String Masothue;
		private String Diachi;
		private String Hinhthucthanhtoan;
		private String Ghichu;
		private String ThueGTGT;

		public List<HangHoa> dshanghoa;

		public String getStt() {
			return Stt;
		}

		public void setStt(String stt) {
			Stt = stt;
		}

		public String getMakhachhang() {
			return Makhachhang;
		}

		public void setMakhachhang(String makhachhang) {
			Makhachhang = makhachhang;
		}

		public String getHotennguoimua() {
			return Hotennguoimua;
		}

		public void setHotennguoimua(String hotennguoimua) {
			Hotennguoimua = hotennguoimua;
		}

		public String getDonvimua() {
			return Donvimua;
		}

		public void setDonvimua(String donvimua) {
			Donvimua = donvimua;
		}

		public String getMasothue() {
			return Masothue;
		}

		public void setMasothue(String masothue) {
			Masothue = masothue;
		}

		public String getDiachi() {
			return Diachi;
		}

		public void setDiachi(String diachi) {
			Diachi = diachi;
		}

		public String getHinhthucthanhtoan() {
			return Hinhthucthanhtoan;
		}

		public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
			Hinhthucthanhtoan = hinhthucthanhtoan;
		}

		public String getGhichu() {
			return Ghichu;
		}

		public void setGhichu(String ghichu) {
			Ghichu = ghichu;
		}

		public List<HangHoa> getDsvattu() {
			return dshanghoa;
		}

		public void setDsvattu(List<HangHoa> dshanghoa) {
			this.dshanghoa = dshanghoa;
		}
		
		public String getThueGTGT() {
			return ThueGTGT;
		}

		public void setThueGTGT(String thueGTGT) {
			ThueGTGT = thueGTGT;
		}
		
		public ThongTinHD() {
			setStt("");
			setMakhachhang("");
			setHotennguoimua("");
			setDonvimua("");
			setMasothue("");
			setDiachi("");
			setHinhthucthanhtoan("");
			setGhichu("");
			setThueGTGT("");
		}
}
