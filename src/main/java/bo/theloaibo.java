package bo;

import java.util.ArrayList;

import bean.theloaibean;
import dao.theloaidao;

public class theloaibo {
	theloaidao tldao = new theloaidao();
	ArrayList<theloaibean> ds;
	public ArrayList<theloaibean> gettheloai() throws Exception {
		return tldao.gettheloai();
	}

	public int getTongTheLoai() throws Exception {
		return tldao.getTongTheLoai();
	}
}
