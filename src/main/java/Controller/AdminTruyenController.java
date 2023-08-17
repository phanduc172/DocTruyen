package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.truyenbean;
import bo.truyenbo;

@WebServlet("/AdminTruyenController")
public class AdminTruyenController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            truyenbo trbo = new truyenbo();
            ArrayList<truyenbean> dstruyen = trbo.gettruyen();

            String tab = request.getParameter("tab");
            String mtrStr = request.getParameter("txtmatruyen");
            String tentruyen = request.getParameter("txttentruyen");
            String anh = request.getParameter("txtanh");
            String noidung = request.getParameter("txtnoidung");
            String mota = request.getParameter("txtmota");
            String mtgStr = request.getParameter("txtmatacgia");
            String mtlStr = request.getParameter("txtmatheloai");

            long mtr = 0;
            if (mtrStr != null && !mtrStr.isEmpty()) {
                mtr = Long.parseLong(mtrStr);
            }

            long mtg = 0;
            if (mtgStr != null && !mtgStr.isEmpty()) {
                mtg = Long.parseLong(mtgStr);
            }

            long mtl = 0;
            if (mtlStr != null && !mtlStr.isEmpty()) {
                mtl = Long.parseLong(mtlStr);
            }

            if (request.getParameter("butadd") != null) {
                trbo.themTruyen(tentruyen, anh, noidung, mota, mtg, mtl);
            } else if (request.getParameter("butupdate") != null) {
                trbo.suaTruyen(mtr, tentruyen, anh, noidung, mota, mtg, mtl);
            } else if (tab != null && tab.equals("xoa")) {
            	String mtrxoa = request.getParameter("mtr");
        	    long matruyen = Long.parseLong(mtrxoa);
        	    trbo.xoaTruyen(matruyen);
            }

            dstruyen = trbo.gettruyen();

            request.setAttribute("dstruyen", dstruyen);
            request.getRequestDispatcher("AdminTruyen.jsp").forward(request, response);
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
