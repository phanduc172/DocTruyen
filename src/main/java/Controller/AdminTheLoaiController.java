package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.theloaibean;
import bo.theloaibo;

@WebServlet("/AdminTheLoaiController")
public class AdminTheLoaiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            theloaibo tlbo = new theloaibo();
            ArrayList<theloaibean> dstheloai = tlbo.gettheloai();

            request.setAttribute("dstheloai", dstheloai);

            request.getRequestDispatcher("AdminTheLoai.jsp").forward(request, response);
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
