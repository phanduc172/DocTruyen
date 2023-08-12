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
