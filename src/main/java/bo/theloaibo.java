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

	public int xoaTheLoai(long matheloai) throws Exception {
		return tldao.xoaTheLoai(matheloai);
	}

	public int themTheLoai(long matheloai, String tentheloai) throws Exception {
		return tldao.themTheLoai(matheloai,tentheloai);
	}

	public int suaTheLoai(long matheloai, String tentheloaimoi) throws Exception {
		return tldao.suaTheLoai(matheloai, tentheloaimoi);
	}


}
