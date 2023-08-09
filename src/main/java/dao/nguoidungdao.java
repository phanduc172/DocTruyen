package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.nguoidungbean;


public class nguoidungdao {
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
}
