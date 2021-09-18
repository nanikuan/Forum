<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

table {
	font: "lucida grande", "lucida sans unicode", geogrotesque, arial,
		verdana, tahoma, sans-serif;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	margin-top: 10px;
}
/*sidebar CSS*/
.sidebar td {
	border: 1px solid #dddddd;
	text-align: center;
}

.categories, .subCategories {
	text-align: left;
}

.sidebar th {
	background: #ACFFF7
}

.sidebar td li {
	list-style-type: none;
}
</style>
</head>
<body>

	<header>
		<h1>OneRp</h1>
		<nav id="login" style="width: auto;">
			<a class="pointer">Login</a> <a href="Home.jsp" title="Home">Home</a>
			<a href="TopicServlet" title="Home">Topics</a> <a href="threads.jsp"
				title="Home">Threads</a>


		</nav>
	</header>
	<table class="sidebar" cellpadding="8" width="100%" border="0"
		cellspacing="0">

		<tbody>

			<tr>
				<th scope="col" style="border-radius: 10px 0px 0px 0px">Topics&nbsp;</th>
				<th scope="col">Description&nbsp;&nbsp;</th>
				<th scope="col">Number of threads&nbsp;&nbsp;</th>
				<th scope="col">Edited date:</th>
				<th style="border-radius: 0px 10px 0px 0px">Delete?</th>
			</tr>
			<tr>
				<c:forEach var="topics" items="${listTopic}">
					<script>
						console.log("${topics.name}");
						console.log("comes here");
					</script>
					<td class="categories">
						<div class="categories">
							<a style="text-decoration: none" href="threads.php">&nbsp; <c:out
									value="${topics.name}" /> &nbsp;&nbsp;
							</a>
						</div>
					</td>
					<td style="width: 200px" class="number smallfont">
						<div class="categories">
							<a style="text-decoration: none">&nbsp; <c:out
									value="${topics.content}" /> &nbsp;&nbsp;
							</a>
						</div>
					</td>
					<td style="width: 200px" class="number smallfont">
						<div class="categories">
							<a style="text-decoration: none">&nbsp; <c:out
									value="${topics.number}" /> &nbsp;&nbsp;
							</a>
						</div>
					</td>

					<td class="date" style="width: 20%">
						<div style="white-space: nowrap">
							<span class="time"><c:out value="${topics.date}" /></span>
						</div>
					</td>
					<td style="width: 20%">
						<div class="categories">
							<a href="/Forum/TopicServlet/delete?name=<c:out value='${topics.name}' />">Delete</a></td>
						</div>
					</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


	<form method='post' action="RegisterServlet">
		<br>Topic Header: <br>
		<textarea style='width: 500px; height: 20px;' name='thread-name'
			maxlength='40'></textarea>
		<br>Topic Message:<br>
		<textarea style='width: 500px; height: 200px;' name='thread-message'></textarea>
		<br> <input type="submit" value="Submit Topic" />
	</form>


</body>
</html>