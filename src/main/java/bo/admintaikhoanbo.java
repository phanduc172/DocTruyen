package bo;

import bean.admintaikhoanbean;
import dao.admintaikhoandao;

public class admintaikhoanbo {
	admintaikhoandao tkadmin = new admintaikhoandao();
	public admintaikhoanbean ktdnadmin(String taikhoanadmin, String matkhauadmin) throws Exception{
		return tkadmin.ktdnadmin(taikhoanadmin, matkhauadmin);
	}
}
