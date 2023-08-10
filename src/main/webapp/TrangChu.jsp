<%@page import="bean.nguoidungbean"%>
<%@page import="bean.httruyenbean"%>
<%@page import="bean.tacgiabean"%>
<%@page import="bean.truyenbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.theloaibean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <nav class="navbar navbar-expand-md navbar-light bg-light fw-bold mb-3">
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
								<%ArrayList<theloaibean> dstheloai = (ArrayList<theloaibean>)request.getAttribute("dstheloai");%>
								<%if (request.getAttribute("dstheloai") != null) {
								  dstheloai = (ArrayList<theloaibean>) request.getAttribute("dstheloai");
								}%>
								<%for(theloaibean theloai: dstheloai) {%>
									<li class="py-2">
										<i class="bi bi-tags-fill text-secondary"></i>
										<a class="text-decoration-none text-primary" href="TruyenController?mtl=<%=theloai.getMatheloai()%>">
											<%=theloai.getTentheloai()%>
										</a>
									</li>
								<%}%>
                       		</ul>
                        </div>
                    </div>
                  <a href="#" class="nav-item nav-link">Đăng truyện</a>
                </div>
                <form class="d-flex">
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
				        <div class="modal-content">

				        <!-- Modal Header -->
				        <div class="modal-header">
				            <h4 class="modal-title">Đăng nhập</h4>
				            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				        </div>

				        <!-- Modal body -->
				        <div class="modal-body">
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
				        </div>
				    </div>
			    </div>

			</div>
		</div>
   	</nav>

    <div class="main">
        <div class="container">
            <div class="row">
                <div class="theloai bg-light col-3 me-2">
                    <h5 class="text-danger fw-bold text-center mt-2">Thể loại truyện</h5>
                        <ul class="px-3 theloai-items" style="list-style: none;">
							<%for(theloaibean theloai: dstheloai) {%>
								<li class="mb-2 p-1">
									<i class="bi bi-tags-fill text-secondary"></i>
									<a class="text-decoration-none text-primary" href="TruyenController?mtl=<%=theloai.getMatheloai()%>">
										<%=theloai.getTentheloai()%>
									</a>
								</li>
							<%}%>
                        </ul>
                </div>

                <div class="noidung bg-light col text-center">
	              <div id="demo" class="carousel slide d-inline-block my-2" data-bs-ride="carousel">
				  <!-- Indicators/dots -->
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
				    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
				    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				  </div>

				  <!-- The slideshow/carousel -->
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="img-truyen/ca1.jpg" alt="Los Angeles" class="d-block" style="width: 100%;">
				    </div>
				    <div class="carousel-item">
				      <img src="img-truyen/ca2.jpg" alt="Chicago" class="d-block" style="width: 100%;">
				    </div>
				    <div class="carousel-item">
				      <img src="img-truyen/ca3.jpg" alt="New York" class="d-block" style="width: 100%;">
				    </div>
				  </div>

				  <!-- Left and right controls/icons -->
				  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon"></span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
				    <span class="carousel-control-next-icon"></span>
				  </button>
				</div>
                    <h5 class="text-danger fw-bold text-center mt-2">Danh sách truyện</h5>
                    <ul class="row truyen-items" style="list-style: none;">
				    <%
				    ArrayList<httruyenbean> dshttruyen = (ArrayList)request.getAttribute("dshttruyen");
				    if (dshttruyen != null && !dshttruyen.isEmpty()) {
				        for (httruyenbean truyen : dshttruyen) {
				    %>
				   		<li class="col col-ms-6 col-md-6 col-lg-4 truyen-item mb-1">
				            <img class="my-1 truyen-img" src="<%= truyen.getAnh() %>" alt="Ảnh truyện">
				            <div>
				                <a href="ChiTietTruyenController?mt=<%=truyen.getMatruyen()%>" class="text-decoration-none">
								    <h6 class="mt-1"><%= truyen.getTentruyen() %></h6>
								</a>
				                <p>Tác giả: <%= truyen.getTentacgia() %></p>
			                 	<p>Thể loại: <%= truyen.getTentheloai() %></p>
				            </div>
				        </li>
				    <% } %>
				    <% } else {	%>
				  	  <li class="text-center">
				  	  <h5 class="text-danger mt-5">Không tìm thấy nội dung tìm kiếm</h5>
				  	  </li>
				    <% } %>
				</ul>
                </div>

            </div>
        </div>
    </div>


</body>
</html>