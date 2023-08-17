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

		String sql = "select * from Truyen order by matruyen desc";

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

    public int xoaTruyen(long matruyen) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from Truyen where matruyen = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setLong(1, matruyen);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int themTruyen(String tentruyen,String anh,String noidung,String mota, long matacgia, long matheloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into Truyen(tentruyen,anh,noidung,mota,matacgia,matheloai) values (?,?,?,?,?,?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, tentruyen);
	    cmd.setString(2, anh);
	    cmd.setString(3, noidung);
	    cmd.setString(4, mota);
	    cmd.setLong(5, matacgia);
	    cmd.setLong(6, matheloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaTruyen(long matruyen, String tentruyen,String anh,String noidung,String mota, long matacgia, long matheloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update Truyen set tentruyen = ?, anh = ?, noidung = ?,mota = ?, matacgia = ?, matheloai = ? where matruyen = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tentruyen);
	    cmd.setString(2, anh);
	    cmd.setString(3, noidung);
	    cmd.setString(4, mota);
	    cmd.setLong(5, matacgia);
	    cmd.setLong(6, matheloai);
	    cmd.setLong(7, matruyen);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
