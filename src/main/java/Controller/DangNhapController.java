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
import nl.captcha.Captcha;

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
            HttpSession session = request.getSession();
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            // Kiểm tra mã CAPTCHA
            Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
            String captchaAnswer = request.getParameter("answer");

            if (captchaAnswer == null || captchaAnswer.isEmpty()) {
                // Mã CAPTCHA chưa được nhập, chuyển hướng với thông báo
                response.sendRedirect("TruyenController?tb=ChuaNhapMaCaptcha");
            } else if (captcha.isCorrect(captchaAnswer)) {
                // Mã CAPTCHA đúng, thực hiện xử lý đăng nhập
                String user = request.getParameter("username");
                String pass = request.getParameter("password");

                nguoidungbo ndbo = new nguoidungbo();
                nguoidungbean nd = ndbo.ktdn(user, pass);

                if (nd != null) {
                    session.setAttribute("dn", user);
                    session.setAttribute("ktdn", nd);
                    response.sendRedirect("TruyenController");
                } else {
                    response.sendRedirect("TruyenController?tb=DangNhapSai");
                }
            } else {
                response.sendRedirect("TruyenController?tb=MaCaptchaSai");
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
