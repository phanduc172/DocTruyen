package bean;

public class admintaikhoanbean {
	private long maadmin;
	private String taikhoanadmin;
	private String matkhauadmin;
	public admintaikhoanbean() {
		super();
	}
	public admintaikhoanbean(long maadmin, String taikhoanadmin, String matkhauadmin) {
		super();
		this.maadmin = maadmin;
		this.taikhoanadmin = taikhoanadmin;
		this.matkhauadmin = matkhauadmin;
	}
	public long getMaadmin() {
		return maadmin;
	}
	public void setMaadmin(long maadmin) {
		this.maadmin = maadmin;
	}
	public String getTaikhoanadmin() {
		return taikhoanadmin;
	}
	public void setTaikhoanadmin(String taikhoanadmin) {
		this.taikhoanadmin = taikhoanadmin;
	}
	public String getMatkhauadmin() {
		return matkhauadmin;
	}
	public void setMatkhauadmin(String matkhauadmin) {
		this.matkhauadmin = matkhauadmin;
	}
}
