package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import bean.tacgiabean;

public class tacgiadao {
    public ArrayList<tacgiabean> getTacGia() throws Exception {
		ArrayList<tacgiabean> dstacgia = new ArrayList<tacgiabean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();

		String sql = "select * from TacGia";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			long matacgia = rs.getLong("matacgia");
			String tentacgia = rs.getString("tentacgia");
			String quequan = rs.getString("quequan");
			dstacgia.add(new tacgiabean(matacgia, tentacgia, quequan));
		}
		rs.close();
		kn.cn.close();
		return dstacgia;
	}

    public int getTongTacGia() throws Exception {
        int tongTacGia = 0;
        // Kết nối vào CSDL và thực hiện truy vấn
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "SELECT COUNT(*) as N'Tổng tác giả' FROM TacGia";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        if (rs.next()) {
            tongTacGia = rs.getInt("Tổng tác giả");
        }

        rs.close();
        kn.cn.close();

        return tongTacGia;
    }
}
