<%@ page session="false" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Pixels</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/home.js" />"></script>
</head>

<body>
	<div id="header">
		<div>
			<div id="logo">
				<a href="./"><img src="./resources/images/NameTag.png" alt="LOGO"></a>
			</div>
			<ul id="navigation">
				<li class="selected"><a href="./">Home</a></li>
				<li><a href="./about">About</a></li>
				<li><a href="./buy">buy pixel</a></li>
				<li><a href="./blog">Blog</a></li>
				<li><a href="./contact">Contact</a></li>
				<li id="signin"><a href="#">${loginstatus }</a></li>
			</ul>
		</div>
	</div>
	<div id="contents">
		<div>
			<div class="body">
				<img src="./resources/images/board.png" alt="Img" width="100%" height="100%">
			</div>
		</div>
	</div>
	<div id="footer">
		<div>
			<div id="links">
				<div class="showroom">
					<h4>Visit our Showroom</h4>
					<a href="buy"><img src="./resources/images/show-room.png" alt="Img"></a>
					<p>
						4885 Wilson Street<br> Victorville, CA 92392<br><br>
									760-962-9541<br><br> <a href="./">info@carvedcreations.com</a>
					</p>
				</div>
				<div>
					<h4>Recent Blog Posts</h4>
					<ul class="posts">
						<li><span class="time">Apr 16</span>
							<p>
								<a href="./blog">The Carving Master &amp; Owner</a> Maybe
								you’re looking for something diferent, something special.
							</p></li>
						<li><span class="time">Apr 15</span>
							<p>
								<a href="./blog">5 Star Hotels We Supply</a> And we love the
								challenge of doing something diferent and something special.
							</p></li>
						<li><span class="time">Apr 14</span>
							<p>
								<a href="./blog">How To Pick The Right Furniture For You</a>
								What’s more, they’re absolutely free! You can do a lot with
								them.
							</p></li>
					</ul>
				</div>
				<div>
					<form action="#" method="post" id="newsletter">
						<h4>Join Our Newsletter</h4>
						<input type="text" value="Enter Email Address Here For Updates"
							onBlur="javascript:if(this.value==''){this.value=this.defaultValue;}"
							onFocus="javascript:if(this.value==this.defaultValue){this.value='';}">
							<input type="submit" value="Sign up" class="btn2" />
					</form>
					<div id="connect">
						<h4>Social Media</h4>
						<a href="http://freewebsitetemplates.com/go/facebook/"
							target="_blank" class="facebook"></a> <a
							href="http://freewebsitetemplates.com/go/googleplus/"
							target="_blank" class="googleplus"></a> <a
							href="http://freewebsitetemplates.com/go/twitter/"
							target="_blank" class="twitter"></a>
					</div>
				</div>
			</div>
			<ul class="navigation">
				<li><a href="./">Home</a></li>
				<li><a href="./about">About</a></li>
				<li><a href="./buy">buy pixel</a></li>
				<li><a href="./blog">Blog</a></li>
				<li><a href="./contact">Contact</a></li>
			</ul>
			<p id="footnote">© Copyright 2023. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>