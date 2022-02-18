package Model;

public class HangHoa {
	private String Stt;
	private String Hinhthuc;
	private String Tenhanghoa;
	private String Donvitinh;
	private String Soluong;
	private String Dongia;
	private Boolean Xoa;

	public String getStt() {
		return Stt;
	}

	public void setStt(String stt) {
		Stt = stt;
	}

	public String getHinhthuc() {
		return Hinhthuc;
	}

	public void setHinhthuc(String hinhthuc) {
		Hinhthuc = hinhthuc;
	}

	public String getTenhanghoa() {
		return Tenhanghoa;
	}

	public void setTenhanghoa(String tenhanghoa) {
		Tenhanghoa = tenhanghoa;
	}

	public String getDonvitinh() {
		return Donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		Donvitinh = donvitinh;
	}

	public String getSoluong() {
		return Soluong;
	}

	public void setSoluong(String soluong) {
		Soluong = soluong;
	}

	public String getDongia() {
		return Dongia;
	}

	public void setDongia(String dongia) {
		Dongia = dongia;
	}

	public Boolean getXoa() {
		return Xoa;
	}

	public void setXoa(Boolean xoa) {
		Xoa = xoa;
	}
	
	public HangHoa() {
		setStt("");
		setHinhthuc("");
		setTenhanghoa("");
		setDongia("");
		setSoluong("");
		setXoa(true);
	}
}
