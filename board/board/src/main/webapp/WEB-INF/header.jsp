<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">    
<!DOCTYPE html>
<html>
<style>
        div {
            background: linear-gradient(to right, rgb(7,244,104), rgb(2,19,29));
            color: #ffffff;
            padding: 20px 40px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 4px 10px rgba(0,0,0,0.2);
        }
        div h1 {
            font-size: 24px;
            margin: 0;
        }
        nav a {
            color: #ffffff;
            text-decoration: none;
            margin-left: 20px;
            font-weight: bold;
            transition: color 0.3s ease;
        }
        nav a:hover {
            color: #07f468;
        }
    </style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
	  		<a class="navbar-brand" href="#"><img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">Bootstrap</a>
	  		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
	  		</button>
	  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		      		<li class="nav-item">
		        		<a class="nav-link active" aria-current="page" href="#">Home</a>
		      		</li>
		      		<li class="nav-item">
		        		<a class="nav-link" href="#">Link</a>
		      		</li>
		      		<li class="nav-item dropdown">
		        		<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
		        	<ul class="dropdown-menu">
		          		<li><a class="dropdown-item" href="#">Action</a></li>
		          		<li><a class="dropdown-item" href="#">Another action</a></li>
		          		<li><hr class="dropdown-divider"></li>
		          		<li><a class="dropdown-item" href="#">Something else here</a></li>
		        	</ul>
		      		</li>
		      		<li class="nav-item">
				        <a class="nav-link disabled" aria-disabled="true">Disabled</a>
				    </li>
				</ul>
				    <form class="d-flex" role="search">
				      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
				      <button class="btn btn-outline-success" type="submit">Search</button>
				    </form>
			</div>
		</div>
	</nav>

</body>
</html>