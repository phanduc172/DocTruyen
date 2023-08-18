<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Đọc truyện Online - Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/adminstyles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
		<script src="ckeditor/ckeditor.js"></script>
    </head>
    <body class="sb-nav-fixed adtruyen-rsp">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="AdminTrangChuController"> <img width="50px" alt="" src="img-truyen/logo-pd.png"> </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Tìm kiếm..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Cài đặt</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="AdminDangXuatController">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="AdminTrangChuController">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Tổng quát
                            </a>
                            <div class="sb-sidenav-menu-heading">Giao diện</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Quản lý truyện
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <div>
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="AdminNguoiDungController">Người dùng</a>
                                            <a class="nav-link" href="AdminTruyenController">Truyện</a>
                                            <a class="nav-link" href="AdminTacGiaController">Tác giả</a>
                                            <a class="nav-link" href="AdminTheLoaiController">Thể loại</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                        </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h2 class="mt-4">Quản lý truyện</h2>
                        <p class="text-danger mt-1 fw-bold">* Thêm truyện không cần nhập mã truyện</p>
                        <form action="AdminTruyenController" method="get" class="form-inline d-flex justify-content-start align-items-start flex-wrap">
					        <div class="form-group me-2">
					            <label for="txtmatruyen">Mã truyện:</label>
					            <input name="txtmatruyen" type="text" class="form-control mt-1" placeholder="Nhập mã truyện">
					        </div>
					        <div class="form-group me-2">
					            <label for="txttentruyen">Tên truyện:</label>
					            <input name="txttentruyen" type="text" class="form-control mt-1" placeholder="Nhập tên truyện">
					        </div>
					        <div class="form-group me-2">
					            <label for="txtanh">Ảnh:</label>
					            <input name="txtanh" type="text" class="form-control mt-1" placeholder="Nhập đường dẫn ảnh">
					        </div>
<!-- 					        <div class="form-group me-2"> -->
<!-- 					            <label for="txtnoidung">Nội dung:</label> -->
<!-- 					            <input name="txtnoidung" type="text" class="form-control mt-1" placeholder="Nhập nội dung"> -->
<!-- 					        </div> -->
							<div class="form-group me-2">
					            <label for="txtmota">Mô tả:</label>
					            <input name="txtmota" type="text" class="form-control mt-1" placeholder="Nhập mô tả">
					        </div>
					        <div class="form-group me-2">
					            <label for="txtmatacgia">Mã tác giả:</label>
					            <input name="txtmatacgia" type="text" class="form-control mt-1" placeholder="Nhập mã tác giả">
					        </div>
					        <div class="form-group me-2">
					            <label for="txtmatheloai">Mã thể loại:</label>
					            <input name="txtmatheloai" type="text" class="form-control mt-1" placeholder="Nhập mã thể loại">
					        </div>
					        <div class="w-100"></div>
					        <div class="form-group me-2">
							    <label for="txtnoidung">Nội dung</label>
							    <textarea id="txtnoidung" name="txtnoidung" rows="4" cols="50"></textarea>
							</div>

					        <div class="w-100"></div>
					        <div class="form-group me-2">
					            <input class="btn btn-secondary mt-2" name="butadd" type="submit" value="Thêm">
					            <input class="btn btn-secondary mt-2" name="butupdate" type="submit" value="Cập nhật">
					        </div>
					        <div class="form-group me-2">
					        </div>
					    </form>
                        <div class="card my-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Danh sách truyện
                            </div>
                            <div class="card-body">
								<table class="table">
								    <thead class="text-center align-middle">
								        <tr>
								            <th>Mã truyện</th>
								            <th>Tên truyện</th>
								            <th>Ảnh</th>
								            <th>Nội dung</th>
								            <th>Mô tả</th>
								            <th>Mã tác giả</th>
								            <th>Mã thể loại</th>
								            <th></th>
								        </tr>
								    </thead>
								    <tbody>
									    <c:forEach items="${dstruyen}" var="truyen">
									        <tr>
									            <td class="text-center">${truyen.getMatruyen()}</td>
									            <td>${truyen.getTentruyen()}</td>
									            <td><img width="100" src="${truyen.getAnh()}" alt="Ảnh truyện"></td>
									            <td>${truyen.getNoidung()}</td>
									            <td>${truyen.getMota()}</td>
									            <td>${truyen.getMatacgia()}</td>
									            <td>${truyen.getMatheloai()}</td>
									            <td><a href="AdminTruyenController?mtr=${truyen.getMatruyen()}&tab=xoa">Xóa</a> </td>
									        </tr>
									    </c:forEach>
									</tbody>
								</table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="mt-3 bg-dark text-white fw-bold fs-5 text-center py-3">
				   <p class="m-0">&copy; 2023 No CopyRight</p>
				   <p class="m-0">Mã sinh viên: 20T1020019</p>
				   <p class="m-0">Tên: Phan Đức</p>
				   <p class="m-0">Email: <a class="text-decoration-none text-white" href="mailto:20t1020019@husc.edu">20t1020019@husc.edu</a></p>
				</footer>
			</div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        <script src="js/thongke.js"></script>
        <script>
    		// Khởi tạo CKEditor cho textarea có id là "txtnoidung"
		    CKEDITOR.replace('txtnoidung');
		</script>
</html>
