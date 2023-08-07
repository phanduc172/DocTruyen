package bean;

public class truyenbean {
	private long matruyen;
	private String tentruyen;
	private String anh;
	private String noidung;
	private String mota;
	private long matacgia;
	private long matheloai;
	public truyenbean() {
		super();
	}
	public truyenbean(long matruyen, String tentruyen, String anh, String noidung, String mota, long matacgia,
			long matheloai) {
		super();
		this.matruyen = matruyen;
		this.tentruyen = tentruyen;
		this.anh = anh;
		this.noidung = noidung;
		this.mota = mota;
		this.matacgia = matacgia;
		this.matheloai = matheloai;
	}
	public long getMatruyen() {
		return matruyen;
	}
	public void setMatruyen(long matruyen) {
		this.matruyen = matruyen;
	}
	public String getTentruyen() {
		return tentruyen;
	}
	public void setTentruyen(String tentruyen) {
		this.tentruyen = tentruyen;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public long getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(long matacgia) {
		this.matacgia = matacgia;
	}
	public long getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(long matheloai) {
		this.matheloai = matheloai;
	}

}
