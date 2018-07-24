<%@ page import="com.topo.inscription.entity.Account" %>
<html>
<head>
    <title>Web Demo</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-light bg-danger">
        <a class="navbar-brand" href="#">Inscription ${account.name}</a>
    </nav>
    <div class="card" style="width: 200px;position: absolute; left: 40%;top:10%;">
        <label>${account.name}</label><br>
        <label>${account.surname}</label><br>
        <label>${account.email}</label><br>
        <label>${account.telephone}</label><br>
        <label>${account.id}</label>
    </div>
</body>
</html>