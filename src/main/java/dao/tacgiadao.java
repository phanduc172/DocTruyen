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

    public int xoaTacGia(long matacgia) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from TacGia where matacgia = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setLong(1, matacgia);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int themTacGia(String tentacgia, String quequan) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into TacGia(tentacgia,quequan) values (?,?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, tentacgia);
	    cmd.setString(2, quequan);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaTacGia(long matacgia,String tentacgia, String quequan) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update TacGia set tentacgia = ? , quequan = ? where matacgia = ?;";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1,tentacgia);
	    cmd.setString(2,quequan);
	    cmd.setLong(3,matacgia);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
