package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.theloaibean;
import bo.theloaibo;

/**
 * Servlet implementation class TheLoaiController
 */
@WebServlet("/TheLoaiController")
public class TheLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String mtl = request.getParameter("mtl");
			// Sai loaibo lấy về dsloai
			theloaibo tlbo = new theloaibo();
			ArrayList<theloaibean> dstheloai = tlbo.gettheloai();

			request.setAttribute("dstheloai", dstheloai);
			RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
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
