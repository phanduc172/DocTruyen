package bo;

import java.util.ArrayList;

import bean.httruyenbean;
import dao.httruyendao;

public class httruyenbo {
	httruyendao httdao = new httruyendao();
	public ArrayList<httruyenbean> getHTTruỵen() throws Exception {
		return httdao.getHTTruỵen();
	}
}
