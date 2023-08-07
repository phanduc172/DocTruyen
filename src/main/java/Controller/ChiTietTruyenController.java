package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.httruyenbean;
import bo.httruyenbo;

/**
 * Servlet implementation class ChiTietTruyenController
 */
@WebServlet("/ChiTietTruyenController")
public class ChiTietTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// Lấy mã truyện từ parameter
			String maTruyenStr = request.getParameter("matruyen");
			long maTruyen = 0;

			// Kiểm tra và chuyển đổi mã truyện từ chuỗi sang số nguyên
			if (maTruyenStr != null && !maTruyenStr.isEmpty()) {
			    maTruyen = Long.parseLong(maTruyenStr);
			}

			httruyenbo httbo = new httruyenbo();
			httruyenbean truyen = httbo.getTruyenByMaTruyen(maTruyen);

			// Đặt thông tin truyện trong thuộc tính của request
			request.setAttribute("truyen", truyen);

			// Chuyển hướng đến trang NoiDungTruyen.jsp để hiển thị chi tiết truyện
			RequestDispatcher rd = request.getRequestDispatcher("NoiDungTruyen.jsp");
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
