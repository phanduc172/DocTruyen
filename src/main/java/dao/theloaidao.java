package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.theloaibean;

public class theloaidao {
	public ArrayList<theloaibean> gettheloai() throws Exception {
		ArrayList<theloaibean> ds = new ArrayList<theloaibean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();

		String sql = "select * from TheLoai";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			String matheloai = rs.getString("matheloai");
			String tentheloai = rs.getString("tentheloai");
			ds.add(new theloaibean(matheloai,tentheloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
