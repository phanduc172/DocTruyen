package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.httruyenbean;
import bean.theloaibean;
import bean.truyenbean;
import bo.httruyenbo;
import bo.theloaibo;
import bo.truyenbo;

/**
 * Servlet implementation class TheLoaiController
 */
@WebServlet("/TruyenController")
public class TruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruyenController() {
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

			String key = request.getParameter("txttim");
			String mtlSt = request.getParameter("mtl");
			long mtl = 0;
			if (mtlSt != null && !mtlSt.isEmpty()) {
			    mtl = Long.parseLong(mtlSt);
			}
			theloaibo tlbo = new theloaibo();
			ArrayList<theloaibean> dstheloai = tlbo.gettheloai();

			httruyenbo httbo = new httruyenbo();
			ArrayList<httruyenbean> dshttruyen = httbo.getHTTruyen();

			if(mtl!=0) //Chọn tên loại
				dshttruyen =httbo.timTheLoai(mtl);
			else
			if(key!=null)
				dshttruyen =httbo.timKiem(key);
			System.out.println();
			request.setAttribute("dstheloai", dstheloai);
			request.setAttribute("dshttruyen", dshttruyen);
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
