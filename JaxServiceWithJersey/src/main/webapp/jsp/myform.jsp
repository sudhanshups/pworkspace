<html>
<body>
	<h1>JAX-RS @FormQuery Testing</h1>
<!-- 
    If we just write it rest/service/add url form will <base>/SpringJaxService/jsp/rest/service/add
    If we write /rest/service/add url formed will be <base>/jsp/rest/service/add
    If we write /SpringJaxService/rest/service/add url formed will be
     <base>/SpringJaxService/rest/service/add which is correct -->
	<form action="/SpringJaxService/rest/service/add" method="post">
		<p>
			Namezz : <input type="text" name="name" />
		</p>
		<p>
			Age : <input type="text" name="age" />
		</p>
		<input type="submit" value="Add User" />
	</form>

</body>
</html>