package bean;

public class theloaibean {
	private String matheloai;
	private String tentheloai;

	public theloaibean() {
		super();
	}
	public theloaibean(String matheloai, String tentheloai) {
		super();
		this.matheloai = matheloai;
		this.tentheloai = tentheloai;
	}
	public String getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(String matheloai) {
		this.matheloai = matheloai;
	}
	public String getTentheloai() {
		return tentheloai;
	}
	public void setTentheloai(String tentheloai) {
		this.tentheloai = tentheloai;
	}


}
