package bean;

public class httruyenbean {
	private String anh;
	private String tentruyen;
	private String tentheloai;
	private String tentacgia;
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
