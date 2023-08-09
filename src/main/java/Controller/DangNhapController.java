package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.nguoidungbean;
import bo.nguoidungbo;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
     	   	response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
 	   		String user = request.getParameter("username");
 	   		String pass = request.getParameter("password");
    			nguoidungbo ndbo = new nguoidungbo();
 	   		if(user==null && pass==null) {
 	   			RequestDispatcher rd = request.getRequestDispatcher("TruyenController");
 	   			rd.forward(request, response);
 	   		} else {
 	   			nguoidungbean nd = ndbo.ktdn(user, pass);
 	   			if(nd !=null) {
 	   				HttpSession session = request.getSession();
	   				session.setAttribute("dn",user);
 	   				session.setAttribute("ktdn", nd);
 	   				response.sendRedirect("TruyenController");
 	   			} else {
 	   				response.sendRedirect("TruyenController?tb=DangNhapSai");
 	   			}
 	   		}
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
