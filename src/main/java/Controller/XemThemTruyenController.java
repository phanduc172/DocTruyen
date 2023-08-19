package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.httruyenbean;
import bo.httruyenbo;

/**
 * Servlet implementation class XemThemTruyenController
 */
@WebServlet("/XemThemTruyenController")
public class XemThemTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemThemTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try {
			String amount = request.getParameter("exits");
			int iamount = 0;
			if (amount != null && !amount.isEmpty()) {
			    iamount = Integer.parseInt(amount);
			}
            httruyenbo httbo = new httruyenbo();
            ArrayList<httruyenbean> dshttruyen = httbo.getNextTop6HTTruỵen(iamount);
            PrintWriter out = response.getWriter();

            for(httruyenbean truyen : dshttruyen) {
            	out.print("<li class=\"httruyen col col-ms-6 col-md-6 col-lg-4 truyen-item mb-1\">\r\n"
            			+ "				            <img class=\"my-1 truyen-img\" src=\""+truyen.getAnh()+"\" alt=\"Ảnh truyện\">\r\n"
            			+ "				            <div>\r\n"
            			+ "				                <a href=\"ChiTietTruyenController?mt="+truyen.getMatruyen()+"\" class=\"text-decoration-none\">\r\n"
            			+ "								    <h6 class=\"mt-1\">"+truyen.getTentruyen()+"</h6>\r\n"
            			+ "								</a>\r\n"
            			+ "				                <p>Tác giả: "+truyen.getTentacgia()+"</p>\r\n"
            			+ "			                 	<p>Thể loại: "+truyen.getTentheloai()+"</p>\r\n"
            			+ "				            </div>\r\n"
            			+ "				        </li>");
            }

        } catch (Exception e) {
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
