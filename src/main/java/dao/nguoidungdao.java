package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import bean.nguoidungbean;


public class nguoidungdao {
	public ArrayList<nguoidungbean> getNguoiDung() throws Exception {
        ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
        // Kết nối vào CSDL
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "SELECT * FROM NguoiDung";
        // Tạo câu lệnh
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        // Thực hiện câu lệnh
        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
            long manguoidung = rs.getLong("manguoidung");
            String hoten = rs.getString("hoten");
            String tendangnhap = rs.getString("tendangnhap");
            String matkhau = rs.getString("matkhau");
            ds.add(new nguoidungbean(manguoidung, hoten, tendangnhap, matkhau));
        }
        rs.close();
        kn.cn.close();
        return ds;
    }

	public nguoidungbean ktdn(String tendn, String matkhau) throws Exception{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql="select * from NguoiDung where tendangnhap = ? and matkhau = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, matkhau);
		ResultSet rs = cmd.executeQuery();
		nguoidungbean ndung = null;
		if(rs.next()) {
			long manguoidung = rs.getLong("manguoidung");
			String hoten = rs.getString("hoten");
			ndung = new nguoidungbean(manguoidung,hoten,tendn,matkhau);
		}
		return ndung;
	}

	 public void themNguoiDung(nguoidungbean nd) throws Exception {
	        KetNoidao kn = new KetNoidao();
	        kn.KetNoi();

	        String sql = "INSERT INTO NguoiDung(hoten, tendangnhap, matkhau) VALUES (?, ?, ?)";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, nd.getHoten());
	        cmd.setString(2, nd.getTendangnhap());
	        cmd.setString(3, nd.getMatkhau());

	        cmd.executeUpdate();

	        kn.cn.close();
    }

}
