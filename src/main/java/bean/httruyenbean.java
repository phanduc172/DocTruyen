package bean;

public class httruyenbean {
	private String anh;
	private long matruyen;
	private String tentruyen;
	private String mota;
	private String noidung;
	private String tentheloai;
	private String tentacgia;
	private long matheloai;
	public httruyenbean() {
		super();
	}
	public httruyenbean(String anh, long matruyen, String tentruyen, String mota, String noidung, String tentheloai,
			String tentacgia, long matheloai) {
		super();
		this.anh = anh;
		this.matruyen = matruyen;
		this.tentruyen = tentruyen;
		this.mota = mota;
		this.noidung = noidung;
		this.tentheloai = tentheloai;
		this.tentacgia = tentacgia;
		this.matheloai = matheloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
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
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getTentheloai() {
		return tentheloai;
	}
	public void setTentheloai(String tentheloai) {
		this.tentheloai = tentheloai;
	}
	public String getTentacgia() {
		return tentacgia;
	}
	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
	}
	public long getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(long matheloai) {
		this.matheloai = matheloai;
	}

}
