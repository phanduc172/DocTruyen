package bo;

import bean.nguoidungbean;
import dao.nguoidungdao;

public class nguoidungbo {
	nguoidungdao nddao = new nguoidungdao();
	public nguoidungbean ktdn(String tendn, String matkhau) throws Exception{
		return nddao.ktdn(tendn, matkhau);
	}
}
