package bo;
import java.util.ArrayList;

import bean.nguoidungbean;
import dao.nguoidungdao;

public class nguoidungbo {
	nguoidungdao nddao = new nguoidungdao();

	public ArrayList<nguoidungbean> getNguoiDung() throws Exception {
		return nddao.getNguoiDung();
	}
	public nguoidungbean ktdn(String tendn, String matkhau) throws Exception{
		return nddao.ktdn(tendn, matkhau);
	}

    public boolean DangKyNguoiDung(nguoidungbean nguoidung) {
        try {
            nddao.themNguoiDung(nguoidung);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTongNguoiDung() throws Exception {
    	return nddao.getTongNguoiDung();
    }

    public int xoaNguoiDung(long manguoidung) throws Exception {
    	return nddao.xoaNguoiDung(manguoidung);
    }

	public int themNguoiDungAD(long manguoidung,String hoten, String tendangnhap, String matkhau) throws Exception {
		return nddao.themNguoiDungAD(manguoidung, hoten, tendangnhap, matkhau);
	}

	public int suaNguoiDung(long manguoidung,String hoten, String tendangnhap, String matkhau) throws Exception {
		return nddao.suaNguoiDung(manguoidung, hoten, tendangnhap, matkhau);
	}


}
