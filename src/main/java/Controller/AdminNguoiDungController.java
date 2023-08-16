package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.nguoidungbean;
import bo.nguoidungbo;

@WebServlet("/AdminNguoiDungController")
public class AdminNguoiDungController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            nguoidungbo ndbo = new nguoidungbo();
            ArrayList<nguoidungbean> dsnguoidung = ndbo.getNguoiDung();

            String tab = request.getParameter("tab");
            String mndStr = request.getParameter("txtmanguoidung");
            String tennguoidung = request.getParameter("txttennguoidung");
            String tendangnhap = request.getParameter("txttendangnhap");
            String matkhau = request.getParameter("txtmatkhau");

            long mnd = 0;
            if (mndStr != null && !mndStr.isEmpty()) {
                mnd = Long.parseLong(mndStr);
            }

            if (request.getParameter("butadd") != null) {
                ndbo.themNguoiDungAD(mnd, tennguoidung, tendangnhap, matkhau);
            } else if (request.getParameter("butupdate") != null) {
                ndbo.suaNguoiDung(mnd, tennguoidung, tendangnhap, matkhau);
            } else if (tab != null && tab.equals("xoa")) {
            	String mndxoa = request.getParameter("mnd");
        	    long manguoidung = Long.parseLong(mndxoa);
        	    ndbo.xoaNguoiDung(manguoidung);
            }

            dsnguoidung = ndbo.getNguoiDung();

            request.setAttribute("dsnguoidung", dsnguoidung);
            request.getRequestDispatcher("AdminNguoiDung.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
