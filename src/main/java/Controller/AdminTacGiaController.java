package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.tacgiabean;
import bo.tacgiabo;

@WebServlet("/AdminTacGiaController")
public class AdminTacGiaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            tacgiabo tgbo = new tacgiabo();
            ArrayList<tacgiabean> dstacgia = tgbo.getTacGia();

            String tab = request.getParameter("tab");
            String mtgStr = request.getParameter("txtmatacgia");
            String tentacgia = request.getParameter("txttentacgia");
            String quequan = request.getParameter("txtquequan");

            long mtg = 0;
            if (mtgStr != null && !mtgStr.isEmpty()) {
                mtg = Long.parseLong(mtgStr);
            }

            if (request.getParameter("butadd") != null) {
                tgbo.themTacGia(tentacgia, quequan);
            } else if (request.getParameter("butupdate") != null) {
                tgbo.suaTacGia(mtg, tentacgia, quequan);
            } else if (tab != null && tab.equals("xoa")) {
            	String mtgxoa = request.getParameter("mtg");
        	    long matacgia = Long.parseLong(mtgxoa);
        	    tgbo.xoaTacGia(matacgia);
            }

            dstacgia = tgbo.getTacGia(); // Cập nhật danh sách sau khi thêm, sửa, xóa

            request.setAttribute("dstacgia", dstacgia);
            request.getRequestDispatcher("AdminTacGia.jsp").forward(request, response);
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
