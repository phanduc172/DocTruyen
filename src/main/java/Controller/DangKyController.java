package Controller;

import bean.nguoidungbean;
import bo.nguoidungbo;
import nl.captcha.Captcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DangKyController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        response.setCharacterEncoding("utf-8");
	        request.setCharacterEncoding("utf-8");

	        String hoten = request.getParameter("dkhoten");
	        String tendangnhap = request.getParameter("dktendangnhap");
	        String matkhau = request.getParameter("dkmatkhau");
	        String captchaAnswer = request.getParameter("answer");

	        if (hoten.isEmpty() || tendangnhap.isEmpty() || matkhau.isEmpty() || captchaAnswer.isEmpty()) {
	            response.sendRedirect("TruyenController?tb=ThieuThongTin");
	            return; // Kết thúc xử lý nếu thiếu thông tin
	        }

	        // Kiểm tra mã CAPTCHA
	        HttpSession session = request.getSession();
	        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);

	        if (captchaAnswer == null || captchaAnswer.isEmpty()) {
	            response.sendRedirect("TruyenController?tb=ChuaNhapMaCaptcha");
	            return;
	        }

	        nguoidungbean nguoidung = new nguoidungbean(0, hoten, tendangnhap, matkhau);
	        nguoidungbo nguoidungbo = new nguoidungbo();

	        if (captcha.isCorrect(captchaAnswer)) {
	            boolean result = nguoidungbo.DangKyNguoiDung(nguoidung);
	            if (result) {
	                response.sendRedirect("TruyenController");
	            } else {
	                response.sendRedirect("TruyenController?tb=DangKySai");
	            }
	        } else {
	            response.sendRedirect("TruyenController?tb=MaCaptchaSai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	    }
	}

}
