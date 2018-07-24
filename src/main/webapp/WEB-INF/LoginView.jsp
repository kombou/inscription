
<html>
<head>
    <title>Connection</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-light bg-danger">
    <a class="navbar-brand" href="#">Connection</a>
</nav>
<div class="card" style="width: 200px;position: absolute; left: 40%;top:10%;">
    <div class="card-body">
        <form action="/login" method="post" class="form">
                <div class="form-group">
                    <label for="email">User email
                        <input type="email" id="email" name="email" value="${account.email}" class="form-control">
                    </label>
                    <span class="text-danger font-italic">${errors.email}</span>
                </div>
                <div class="form-group">
                    <label for="password">User Password
                        <input type="password" id="password" name="password" value="${account.passwordHash}" class="form-control">
                    </label>
                    <span class="text-danger font-itatic">${errors.password}</span>
                </div>
            <div class="text-danger">
                <span class="text-danger">${errors.response}</span>
            </div>

            <input type="submit" name="login" value="login" id="login" class="btn btn-success">
        </form>
    </div>
</div>
</body>
</html>