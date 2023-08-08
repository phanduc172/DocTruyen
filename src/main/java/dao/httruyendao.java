package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import bean.httruyenbean;

public class httruyendao {
	public ArrayList<httruyenbean> getHTTruỵen() throws Exception {
		ArrayList<httruyenbean> ds = new ArrayList<httruyenbean>();
		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from V_HTTruyen";
		//B3 Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String anh = rs.getString("anh");
			long matruyen = rs.getLong("matruyen");
			String tentruyen = rs.getString("tentruyen");
			String mota = rs.getString("mota");
			String noidung = rs.getString("noidung");
			String tentheloai = rs.getString("tentheloai");
			String tentacgia = rs.getString("tentacgia");
			long matheloai = rs.getLong("matheloai");
			ds.add(new httruyenbean(anh, matruyen, tentruyen, mota, noidung, tentheloai, tentacgia, matheloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public httruyenbean getTruyenByMaTruyen(long matruyen) throws Exception {
        httruyenbean truyen = null;
        // Kết nối vào csdl
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();

        String sql = "SELECT * FROM V_HTTruyen WHERE matruyen = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, matruyen);

        // Thực hiện câu lệnh
        ResultSet rs = cmd.executeQuery();

        while(rs.next()) {
            // Lấy thông tin truyện từ result set và tạo đối tượng httruyenbean
            String anh = rs.getString("anh");
            String tentruyen = rs.getString("tentruyen");
            String mota = rs.getString("mota");
            String noidung = rs.getString("noidung");
            String tentheloai = rs.getString("tentheloai");
            String tentacgia = rs.getString("tentacgia");
            long matheloai = rs.getLong("matheloai");
            truyen = new httruyenbean(anh, matruyen, tentruyen, mota, noidung, tentheloai, tentacgia, matheloai);
        }

        rs.close();
        kn.cn.close();
        return truyen;
    }
}
