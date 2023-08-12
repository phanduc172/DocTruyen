package dao;

import java.sql.PreparedStatement
;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.truyenbean;

public class truyendao {
	public ArrayList<truyenbean> gettruyen() throws Exception {
		ArrayList<truyenbean> ds = new ArrayList<truyenbean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();

		String sql = "select * from Truyen";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			long matruyen = rs.getLong("matruyen");
			String tentruyen = rs.getString("tentruyen");
			String anh = rs.getString("anh");
			String mota = rs.getString("mota");
			String noidung = rs.getString("noidung");
			long matacgia = rs.getLong("matacgia");
			long matheloai = rs.getLong("matheloai");
			ds.add(new truyenbean(matruyen, tentruyen, anh, noidung, mota, matacgia, matheloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

    public int getTongTruyen() throws Exception {
        int tongTruyen = 0;
        // Kết nối vào CSDL và thực hiện truy vấn
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "SELECT COUNT(*) as N'Tổng truyện' FROM Truyen";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        if (rs.next()) {
            tongTruyen = rs.getInt("Tổng truyện");
        }
        rs.close();
        kn.cn.close();

        return tongTruyen;
    }
}
