<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="/SpringMVC2/">
<meta charset="utf-8">
<title>Manage Customer</title>
</head>
<body>
	<h1>Manage Customer</h1>
	<form action="index.php" method="post">
		<div>
			<label>ID</label> <input name="id" value="${user.id }">
		</div>
		<div>
			<label>Fullname</label> <input name="fullname"
				value="${user.fullname }">
		</div>
		<div>
			<label>Password</label> <input name="password"
				value="${user.password }">
		</div>
		<div>
			<label>Email</label><input name="email" value="${user.email }">
		</div>
		<div>
			<label>Photo</label> <input name="photo" value="${user.photo }">
		</div>
		<div>
			<label>Active</label> 
			<input name="activated" value="true"type="radio" ${user.activated?'checked':'' }> Male
			<input name="activated" value="false" type="radio" ${user.activated?'':'checked' }> Female
		</div>

		<div>
			<button formaction="customer/insert.php">Insert</button>
			<button formaction="customer/update.php">update</button>
			<button formaction="customer/delete.php">delete</button>
			<button formaction="customer/index.php">Reset</button>
		</div>
	</form>
	${mess }
	<ul>
		<c:forEach var="c" items="${list }">
			<li>${c.fullname } <a href="customer/edit/${c.id }.php">Edit</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>