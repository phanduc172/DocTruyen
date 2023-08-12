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
}
