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

    public int xoaTruyen(long matruyen) throws Exception {
    	return tdao.xoaTruyen(matruyen);
    }

    public int themTruyen(String tentruyen,String anh,String noidung,String mota, long matacgia, long matheloai) throws Exception {
    	return tdao.themTruyen(tentruyen, anh, noidung, mota, matacgia, matheloai);
    }

    public int suaTruyen(long matruyen, String tentruyen,String anh,String noidung,String mota, long matacgia, long matheloai) throws Exception {
    	return tdao.suaTruyen(matruyen, tentruyen, anh, noidung, mota, matacgia, matheloai);
    }


}
