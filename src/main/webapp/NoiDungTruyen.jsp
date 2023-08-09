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
					    <button type="button" class="btn btn btn-light" data-bs-toggle="modal" data-bs-target="#myModal">
					        <i class="bi bi-person-circle"></i>
					        <%
					        nguoidungbean nd = (nguoidungbean) session.getAttribute("ktdn");
					        if (nguoidung == null) {
					            out.print("Thành viên");
					        } else {%>
					            <li><span class="glyphicon glyphicon-log-in"></span> Xin chào: <%=nd.getHoten()%></a></li>
					            <li><a href="DangXuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
					        <%}%>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-9 bg-light">
					<div class="row justify-content-evenly">
                        <div class="col-4 text-center">
					    <img class="truyen-img mt-2" src="<%= ((httruyenbean) request.getAttribute("truyen")).getAnh() %>" alt="Ảnh truyện">
					    <div>
					        <h5 class="my-2 text-danger fw-bold"><%= ((httruyenbean) request.getAttribute("truyen")).getTentruyen() %></h5>
					        <p>Tác giả: <%= ((httruyenbean) request.getAttribute("truyen")).getTentacgia() %></p>
					        <p>Thể loại: <%= ((httruyenbean) request.getAttribute("truyen")).getTentheloai() %></p>
					        <p class="txttruyen">Mô tả: <%= ((httruyenbean) request.getAttribute("truyen")).getMota() %></p>
					    </div>
					</div>
					<div class="bg-light col-7">
					    <h5 class="text-center mt-2 text-danger fw-bold"><%= ((httruyenbean) request.getAttribute("truyen")).getTentruyen() %></h5>
					    <p class="txttruyen"><%= ((httruyenbean) request.getAttribute("truyen")).getNoidung() %></p>
					</div>

            		</div>
        		</div>

    			<div class="bg-light col ms-2 text-center">
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


</body>
</html>