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

	public int getTongTheLoai() throws Exception {
        int tongTheLoai = 0;
        // Kết nối vào CSDL và thực hiện truy vấn
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "SELECT COUNT(*) as N'Tổng thể loại' FROM TheLoai";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        if (rs.next()) {
            tongTheLoai = rs.getInt("Tổng thể loại");
        }
        rs.close();
        kn.cn.close();

        return tongTheLoai;
    }

	public int xoaTheLoai(long matheloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from TheLoai where matheloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setLong(1, matheloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int themTheLoai(long matheloai, String tentheloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into TheLoai(matheloai,tentheloai) values (?,?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setLong(1, matheloai);
	    cmd.setString(2, tentheloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaTheLoai(long matheloai, String tentheloaimoi) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update TheLoai set tentheloai= ? where matheloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1,tentheloaimoi);
	    cmd.setLong(2,matheloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
