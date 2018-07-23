<html>
    <head>
        <title>Web Demo</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    </head>
    <body>
    <nav class="navbar navbar-light bg-danger">
        <a class="navbar-brand" href="#">Inscription</a>
    </nav>
        <div class="card" style="width: 200px;position: absolute; left: 40%;top:10%;">
            <div class="card-body">
                <form method="post" action="/registration">
                    <div class="form-group">
                        <label for="name">name
                            <input type="text" name="name" id="name" value="${account.name}" class="form-control">
                        </label>
                        <span class="text-danger font-italic">${errors.name}</span>
                    </div>

                    <div class="form-group">
                        <label for="surname">surname
                            <input type="text" name="surname" id="surname" value="${account.surname}" class="form-control"><br>
                        </label>
                        <span class="text-danger font-italic">${errors.surname}</span>
                    </div>

                    <div class="form-group">
                        <label for="email">email
                            <input type="email" id="email" name="email" value="${account.email}" class="form-control"><br>
                        </label>
                        <span class="text-danger font-italic">${errors.email}</span>
                    </div>

                    <div class="form-group">
                        <label for="telephone">telephone
                            <input type="tel" id="telephone" name="telephone" value="${account.telephone}" class="form-control"><br>
                        </label>
                        <span class="text-danger font-italic">${errors.telephone}</span>
                    </div>

                    <div class="form-group">
                        <label for="password">password
                        <input type="password" name="password" id="password" value="${account.passwordHash}" class="form-control"><br>
                        </label>
                        <span class="text-danger font-italic">${errors.password}</span>
                    </div>

                    <div class="form-group">
                        <label for="passwordMatch">confirmer votre password
                        <input type="password" id="passwordMatch" name="passwordMatch" value="${account.passwordHash}" class="form-control"><br>
                        </label>
                        <span class="text-danger font-italic">${errors.passwordMatch}</span>
                    </div>

                    <input type="submit" name="save" value="save" id="save" class="btn btn-success">
                </form>
            </div>
        </div>
    </body>
</html>