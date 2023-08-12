package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.admintaikhoanbean;

public class admintaikhoandao {
	public admintaikhoanbean ktdnadmin(String taikhoanadmin, String matkhauadmin) throws Exception{
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql="select * from TaiKhoanAD  where taikhoanadmin = ? and matkhauadmin = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, taikhoanadmin);
		cmd.setString(2, matkhauadmin);
		ResultSet rs = cmd.executeQuery();
		admintaikhoanbean tkadmin = null;
		if(rs.next()) {
			long maadim = rs.getLong("maadmin");
			tkadmin = new admintaikhoanbean(maadim, taikhoanadmin, matkhauadmin);
		}
		return tkadmin;
	}
}
