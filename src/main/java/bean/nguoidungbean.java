package bean;

public class nguoidungbean {
	private long manguoidung;
	private String hoten;
	private String tendangnhap;
	private String matkhau;
	public nguoidungbean() {
		super();
	}
	public nguoidungbean(long manguoidung, String hoten, String tendangnhap, String matkhau) {
		super();
		this.manguoidung = manguoidung;
		this.hoten = hoten;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}
	public long getManguoidung() {
		return manguoidung;
	}
	public void setManguoidung(long manguoidung) {
		this.manguoidung = manguoidung;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}




}
