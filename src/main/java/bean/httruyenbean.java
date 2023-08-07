package bean;

public class httruyenbean {
	private String anh;
	private String tentruyen;
	private String tentheloai;
	private String tentacgia;
	private long matheloai;
	public httruyenbean() {
		super();
	}
	public httruyenbean(String anh, String tentruyen, String tentheloai, String tentacgia) {
		super();
		this.anh = anh;
		this.tentruyen = tentruyen;
		this.tentheloai = tentheloai;
		this.tentacgia = tentacgia;
	}
	public httruyenbean(String anh, String tentruyen, String tentheloai, String tentacgia, long matheloai) {
		super();
		this.anh = anh;
		this.tentruyen = tentruyen;
		this.tentheloai = tentheloai;
		this.tentacgia = tentacgia;
		this.matheloai = matheloai;
	}
	public long getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(long matheloai) {
		this.matheloai = matheloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getTentruyen() {
		return tentruyen;
	}
	public void setTentruyen(String tentruyen) {
		this.tentruyen = tentruyen;
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


}
