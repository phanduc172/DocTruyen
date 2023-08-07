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

    <nav class="navbar navbar-expand-md navbar-light bg-light fw-bold mb-3">
        <div class="container-fluid">
            <img class="logo-pd" alt="" src="img-truyen/logo-pd.png">
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav gap-4">
                    <a href="#" class="nav-item nav-link active">Trang chủ</a>
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
										<i class="bi bi-tags-fill"></i>
										<a class="text-decoration-none" href="TheLoaiController?mtl=<%=theloai.getMatheloai()%>">
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
                        <input type="text" class="form-control" placeholder="Tìm truyện,tác giả">
                        <button type="button" class="btn btn-secondary"><i class="bi-search"></i></button>
                    </div>
                </form>
                <div class="navbar-nav">
                        <button type="button" class="btn btn btn-light" data-bs-toggle="modal" data-bs-target="#myModal">
				          <i class="bi bi-person-circle"></i> Thành viên
				        </button>
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
					                <input class="btn btn-md btn btn-secondary btn-block" type="submit" value="Đăng nhập">
					            </fieldset>
					            </form>
					        </div>
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
                    <h5 class="text-center mt-2">Thể loại truyện</h5>
                        <ul class="px-3 theloai-items" style="list-style: none;">
							<%for(theloaibean theloai: dstheloai) {%>
								<li class="mb-2">
									<i class="bi bi-tags-fill"></i>
									<a class="text-decoration-none" href="TheLoaiController?mtl=<%=theloai.getMatheloai()%>">
										<%=theloai.getTentheloai()%>
									</a>
								</li>
							<%}%>
                        </ul>
                </div>
                <div class="noidung bg-light col-8 text-center">
                    <h5 class="text-center mt-2">Danh sách truyện</h5>
                    <ul class="row truyen-items" style="list-style: none;">
                    	<%
			            ArrayList<httruyenbean> dshttruyen = (ArrayList<httruyenbean>) request.getAttribute("dshttruyen");
			            if (dshttruyen != null) {
			                for (httruyenbean truyen : dshttruyen) {
			       		%>
				        <li class="col-4 truyen-item mb-1">
				            <img class="mt-1 truyen-img" src="<%= truyen.getAnh() %>" alt="Ảnh truyện">
				            <div>
				                <a href="#">
				                    <h6><%= truyen.getTentruyen() %></h6>
				                </a>
				                <p>Tác giả: <%= truyen.getTentacgia() %></p>
			                 	<p>Thể loại: <%= truyen.getTentheloai() %></p>
				            </div>
				        </li>
				        <%}
				        }%>


                    </ul>
                </div>
            </div>
        </div>
    </div>


</body>
</html>