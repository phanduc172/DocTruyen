package bo;

import java.util.ArrayList;

import bean.tacgiabean;
import dao.tacgiadao;

public class tacgiabo {
	tacgiadao tgdao = new tacgiadao();
    public ArrayList<tacgiabean> getTacGia() throws Exception {
    	return tgdao.getTacGia();
    }

    public int getTongTacGia() throws Exception {
    	return tgdao.getTongTacGia();
    }

    public int xoaTacGia(long matacgia) throws Exception {
    	return tgdao.xoaTacGia(matacgia);
    }

	public int themTacGia(String tentacgia, String quequan) throws Exception {
		return tgdao.themTacGia(tentacgia, quequan);
	}

	public int suaTacGia(long matacgia,String tentacgia, String quequan) throws Exception {
		return tgdao.suaTacGia(matacgia, tentacgia, quequan);
	}
}
