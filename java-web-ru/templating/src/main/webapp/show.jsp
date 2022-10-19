<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
    <center>
        <h2>User:</h2>
        <table border>
            <tr><td>${user.get("id")}</td></tr>
            <tr><td>${user.get("firstName")}</td></tr>
            <tr><td>${user.get("lastName")}</td></tr>
            <tr><td>${user.get("email")}</td></tr>
            </tr>
        </table>
        <div>
            <a href="/users">back</a>
        </div>
        <div>
            <a href='/users/delete?id=${user.get("id")}'}>delete this user</a>
        </div>
    </center>
    </body>
</html>
<!-- END -->
