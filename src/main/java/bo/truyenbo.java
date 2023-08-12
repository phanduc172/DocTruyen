package bo;

import java.util.ArrayList;

import bean.truyenbean;
import dao.truyendao;

public class truyenbo {
	truyendao tdao = new truyendao();
	public ArrayList<truyenbean> gettruyen() throws Exception {
		return tdao.gettruyen();
	}

    public int getTongTruyen() throws Exception {
    	return tdao.getTongTruyen();
    }
}
