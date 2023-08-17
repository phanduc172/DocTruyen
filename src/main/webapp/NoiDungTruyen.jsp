<%@page import="bean.nguoidungbean"%>
<%@page import="bo.theloaibo"%>
<%@page import="bo.httruyenbo"%>
<%@page import="bean.httruyenbean"%>
<%@page import="bean.tacgiabean"%>
<%@page import="bean.truyenbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.theloaibean"%>
<%@page import="bean.nguoidungbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đọc truyện Online</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		<%
		    String tb = request.getParameter("tb");
		    if (tb != null) {
		        if (tb.equals("DangNhapSai")) {
		            // Sử dụng JavaScript để hiển thị alert
		            out.println("<script>alert('Đăng nhập không thành công!');</script>");
		        } else if (tb.equals("MaCaptchaSai")) {
		            // Sử dụng JavaScript để hiển thị alert khi mã CAPTCHA sai
		            out.println("<script>alert('Mã CAPTCHA không đúng!');</script>");
		        } else if (tb.equals("ChuaNhapMaCaptcha")) {
		            // Sử dụng JavaScript để hiển thị alert khi chưa nhập mã CAPTCHA
		            out.println("<script>alert('Vui lòng nhập mã CAPTCHA!');</script>");
		        } else if (tb.equals("ThieuThongTin")) {
		            // Sử dụng JavaScript để hiển thị alert khi thiếu thông tin
		            out.println("<script>alert('Vui lòng điền đầy đủ thông tin!');</script>");
		        }
		    }
		%>
		<%
        nguoidungbean nguoidung = (nguoidungbean) session.getAttribute("ktdn");
		if(nguoidung==null) {
			nguoidung = new nguoidungbean();
			session.setAttribute("ktdn", nguoidung);
		}
   		%>
    <nav class="navbar navbar-expand-md navbar-light bg-light fw-bold mb-3 position-fixed start-0 end-0" style="z-index:1080">
        <div class="container-fluid">
        	<a href="TruyenController"><img class="logo-pd" alt="" src="img-truyen/logo-pd.png"></a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav">
                    <a href="TruyenController" class="nav-item nav-link active">Trang chủ</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Thể loại</a>
                        <div class="dropdown-menu" style="width: 200px;">
                        	<ul class="px-3 theloai-items" style="list-style: none;">
								<%
									theloaibo tlbo = new theloaibo();
									ArrayList<theloaibean> dstheloai = tlbo.gettheloai();
									request.setAttribute("dstheloai", dstheloai);
								%>
								<%for(theloaibean theloai: dstheloai) {%>
									<li class="py-2">
										<i class="bi bi-tags-fill"></i>
										<a class="text-decoration-none" href="TruyenController?mtl=<%=theloai.getMatheloai()%>">
											<%=theloai.getTentheloai()%>
										</a>
									</li>
								<%}%>
                       		</ul>
                        </div>
                    </div>
                  <a href="#" class="nav-item nav-link">Đăng truyện</a>
                </div>
                <form action="TruyenController" class="d-flex" method="get">
                    <div class="input-group">
                        <input name="txttim" type="text" class="form-control" placeholder="Tìm truyện,tác giả">
                        <button name="but1" type="submit" class="btn btn-secondary"><i class="bi-search"></i></button>
                    </div>
                </form>
               		<div class="navbar-nav">
						<% if (session.getAttribute("dn") == null) { %>
						    <button type="button" class="btn btn btn-light" data-bs-toggle="modal" data-bs-target="#myModal">
						        <i class="bi bi-person-circle"></i> Thành viên
						    </button>
						<% } else { %>
					        <li class="text-secondary me-2"><i class="bi bi-person-circle me-2"></i><%= nguoidung.getHoten() %></li>
					        <a class="text-decoration-none text-danger" href="DangXuatController">Đăng xuất</a>
						<% } %>
						</div>
					<!-- The Modal -->
					<div class="modal" id="myModal">
					    <div class="modal-dialog">
					        <div class="modal-content" style="margin-top: 100px;">

					            <!-- Modal Header -->
					            <div class="modal-header">
					                <h4 class="modal-title">Đăng nhập</h4>
					                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					            </div>

					            <!-- Modal body -->
					            <div class="modal-body">
					                <ul class="nav nav-tabs ">
					                    <li class="nav-item">
					                        <a class="nav-link active" data-bs-toggle="tab" href="#loginForm">Đăng nhập</a>
					                    </li>
					                    <li class="nav-item">
					                        <a class="nav-link" data-bs-toggle="tab" href="#registerForm">Đăng ký</a>
					                    </li>
					                </ul>

					                <div class="tab-content mt-3">
					                    <div id="loginForm" class="tab-pane fade show active">
					                        <form method="post" action="DangNhapController">
									            <fieldset>
									                <div class="form-group mb-3">
									                	<input class="form-control" placeholder="Nhập tên người dùng" name="username" type="text">
									                </div>
									                <div class="form-group mb-3">
									              	  <input class="form-control" placeholder="Nhập mật khẩu" name="password" type="password" value="">
									                </div>
									                <div class="form-group mb-3">
									              	  	<img src="simpleCaptcha.jpg" />
									              	 	<input type="text" name="answer" placeholder="Nhập mã CAPTCHA"/><br>
									                </div>
									                <input class="btn btn-md btn btn-secondary btn-block" type="submit" value="Đăng nhập">
									            </fieldset>
								            </form>
					                    </div>
					                    <div id="registerForm" class="tab-pane fade">
					                        <form method="post" action="DangKyController">
									            <fieldset>
									           		<div class="form-group mb-3">
									                	<input class="form-control" placeholder="Nhập họ tên" name="dkhoten" type="text">
									                </div>
									                <div class="form-group mb-3">
									                	<input class="form-control" placeholder="Nhập tên đăng nhập" name="dktendangnhap" type="text">
									                </div>
									                <div class="form-group mb-3">
									              	  <input class="form-control" placeholder="Nhập mật khẩu" type="password" name="dkmatkhau" value="">
									                </div>
					            				   	<div class="form-group mb-3">
									              	  	<img src="simpleCaptcha.jpg" />
									              	 	<input type="text" name="answer" placeholder="Nhập mã CAPTCHA"/><br>
									                </div>
									                <input class="btn btn-md btn btn-secondary btn-block" type="submit" value="Đăng ký">
									            </fieldset>
								            </form>
					                    </div>
					                </div>
					            </div>
					        </div>
					    </div>
					</div>
                </div>
            </div>
        </div>
    </nav>

    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col col-ms-9 bg-light">
					<div class="row justify-content-evenly">
                        <div class="motatruyen col-4 text-center">
						    <img class="truyen-img mt-2" src="<%= ((httruyenbean) request.getAttribute("truyen")).getAnh() %>" alt="Ảnh truyện">
						    <div>
						        <h5 class="my-2 text-danger fw-bold"><%= ((httruyenbean) request.getAttribute("truyen")).getTentruyen() %></h5>
						        <p>Tác giả: <%= ((httruyenbean) request.getAttribute("truyen")).getTentacgia() %></p>
						        <p>Thể loại: <%= ((httruyenbean) request.getAttribute("truyen")).getTentheloai() %></p>
						        <p class="txttruyen">Mô tả: <%= ((httruyenbean) request.getAttribute("truyen")).getMota() %></p>
						    </div>
						</div>
						<div class="noidung bg-light col col-md-7">
					    <h5 class="text-center mt-2 text-danger fw-bold"><%= ((httruyenbean) request.getAttribute("truyen")).getTentruyen() %></h5>
					    <p class="txttruyen"><%= ((httruyenbean) request.getAttribute("truyen")).getNoidung() %></p>
					</div>

            		</div>
        		</div>

    			<div class="truyenmoi bg-light col col-lg-3 ms-2 text-center">
				    <h5 class="text-danger fw-bold text-center mt-2">Truyện mới nhất</h5>
				    <ul class="p-0" style="list-style: none;">
						<%	httruyenbo httruyen = new httruyenbo();
 							ArrayList<httruyenbean> ds = httruyen.getHTTruyen();
 							for(httruyenbean tbean : ds) {
						%>
							<li>
								<a class="text-start text-decoration-none" href="ChiTietTruyenController?mt=<%= tbean.getMatruyen()%>" class="text-decoration-none">
								    <h6 class="mt-1 text-primary"><i class="bi bi-tags-fill m-2 text-secondary"></i><%= tbean.getTentruyen()%></h6>
								</a>
							</li>
						<%}%>
				    </ul>
				</div>
			</div>
	    </div>
    </div>

	<footer class="mt-3 bg-secondary text-white fw-bold fs-5 text-center py-3">
	   <p class="m-0">&copy; 2023 No CopyRight</p>
	   <p class="m-0">Mã sinh viên: 20T1020019</p>
	   <p class="m-0">Tên: Phan Đức</p>
	   <p class="m-0">Email: <a class="text-decoration-none text-white" href="mailto:20t1020019@husc.edu">20t1020019@husc.edu</a></p>
	</footer>


</body>
</html>