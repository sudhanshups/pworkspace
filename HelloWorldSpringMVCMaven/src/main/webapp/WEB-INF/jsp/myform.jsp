<html>
    <head>
        <title>Upload a file please</title>
    </head>
    <body>
        <h1>Please upload a file</h1>
        <!-- <form action="form"> -->
        <%
        //This will loose the value in the next page as Request object is only available until the page finishes loading
        //request.setAttribute("surname","hassan");
        request.getSession().setAttribute("surname", "hassan");
        %>
        <form action="handle">
            Name : <input type="text" name="name"/><br>
            Roll : <input type="text" name="roll"/><br>
            <input type="submit"/>
        </form>
    </body>
</html>