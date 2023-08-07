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
    <nav class="navbar navbar-expand-md navbar-light bg-light fw-bold">
        <div class="container-fluid">
            <a href="#" class="navbar-brand">PHD</a>
            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav gap-4">
                    <a href="#" class="nav-item nav-link active">Trang chủ</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Thể loại</a>
                        <div class="dropdown-menu">
                            <a href="#" class="dropdown-item">Truyện cười</a>
                            <a href="#" class="dropdown-item">Truyện hài</a>
                            <a href="#" class="dropdown-item">Truyện ma</a>
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
                    <a href="#" class="nav-item nav-link"> <i class="bi bi-person-circle"></i> Thành viên</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-9 text-center border border-dark">
                    <h5>Chi tiết nội dung</h5>
                    <div class="row justify-content-evenly">
                        <div class="col-4 text-center border border-dark">
                            <img class="book-image" src="" alt="Ảnh truyện 2">
                            <div>
                                <h5>Tên truyện 2</h5>
                                <p>Tác giả: Tác giả truyện 2</p>
                                <p>Thể loại: Tên thể loại</p>
                            </div>
                        </div>
                        <div class="col-7 text-center border border-dark">
                            <h4>TÊN TRUYỆN</h4>
                            <p>Mô tả: ... </p>
                            <p>Nội dung truyện</p>
                        </div>
                    </div>
                </div>
                <div class="col ms-2 text-center border border-dark">
                    <h5>Truyện mới nhất</h5>
                        <ul class="p-0" style="list-style: none;">
                           <li>1</li>
                           <li>1</li>
                           <li>1</li>
                           <li>1</li>
                           <li>1</li>
                        </ul>
                </div>
            </div>
        </div>
    </div>


</body>
</html>