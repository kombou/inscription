<html>
    <head>
        <title>Web Demo</title>
    </head>
    <body>

        <form method="post" action="/registration">
            <div class="form-group">
                <label for="name">name</label>
                <input type="text" name="name" id="name" value="${account.name}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.name}</span>
            </div>

            <div class="form-group">
                <label for="surname">surname</label>
                <input type="text" name="surname" id="surname" value="${account.surname}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.surname}</span>
            </div>

            <div class="form-group">
                <label for="email">email</label>
                <input type="email" id="email" name="email" value="${account.email}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.email}</span>
            </div>

            <div class="form-group">
                <label for="telephone">telephone</label>
                <input type="tel" id="telephone" name="telephone" value="${account.telephone}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.telephone}</span>
            </div>

            <div class="form-group">
                <label for="password">password</label>
                <input type="password" name="password" id="password" value="${account.passwordHash}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.password}</span>
            </div>

            <div class="form-group">
                <label for="passwordMatch">confirmer votre password</label>
                <input type="password" id="passwordMatch" name="passwordMatch" value="${account.passwordHash}" class="form-control"><br>
                <span class="text-danger font-italic">${errors.passwordMatch}</span>
            </div>

            <input type="submit" name="save" value="save" id="save">
        </form>
    </body>
</html>