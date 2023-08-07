package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.httruyenbean;
import bean.theloaibean;

public class httruyendao {
	public ArrayList<httruyenbean> getHTTruỵen() throws Exception {
		ArrayList<httruyenbean> ds = new ArrayList<httruyenbean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();

		String sql = "select * from V_HTTruyen";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			String anh = rs.getString("anh");
			String tentruyen = rs.getString("tentruyen");
			String tentheloai = rs.getString("tentheloai");
			String tentacgia = rs.getString("tentacgia");
			long matheloai = rs.getLong("matheloai");
			ds.add(new httruyenbean(anh, tentruyen, tentheloai, tentacgia,matheloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
