package bean;

public class tacgiabean {
	private long matacgia;
	private String tentacgia;
	private String quequan;
	public tacgiabean() {
		super();
	}
	public tacgiabean(long matacgia, String tentacgia, String quequan) {
		super();
		this.matacgia = matacgia;
		this.tentacgia = tentacgia;
		this.quequan = quequan;
	}
	public long getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(long matacgia) {
		this.matacgia = matacgia;
	}
	public String getTentacgia() {
		return tentacgia;
	}
	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

}
