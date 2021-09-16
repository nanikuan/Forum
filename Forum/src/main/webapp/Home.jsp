<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
header {
	/*Header*/
	background-color: #CFF2EC;
	overflow: auto;
	font-family: montserrat, sans-serif;
	font-style: normal;
	font-weight: 400;
	padding: 12px
}

header nav {
	/*login*/
	width: 67%;
	float: left;
}

header nav a {
	/* login  */
	text-decoration: none;
	letter-spacing: 0.5px;
	padding-left: 10px;
}
</style>
</head>
<body>
	<header>
		<h1>OneRp</h1>
		<nav id="login" style="width: auto;">
			<a class="pointer">Login</a>
			<a href="Home.jsp" title="Home">Home</a>
			<a href="TopicServlet" title="Home">Topics</a> <a href="threads.jsp"
				title="Home">Threads</a>


		</nav>
	</header>

	<section id="mainContent">
		<h2>Introduction</h2>
		<p>
			OneRP is a forum that focuses on bringing out everything in RP into
			One platform. <br>The website prioritizes on taking out all your
			queries, discussions, arguments, remarks and presenting itself into a
			single forum-based portal. <br> Being made for the students,
			OneRP depends on the students to build it up and to make it more
			effective and involving.
		</p>

	</section>
</body>
</html>