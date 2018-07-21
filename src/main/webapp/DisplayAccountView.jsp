<%@ page import="com.topo.inscription.entity.Account" %>
<html>
<head>
    <title>Web Demo</title>
</head>
<body>
    <%
        Account account = (Account) request.getAttribute("account");
    %>
<label>name <%=account.getName()%></label><br>
<label>surname <%=account.getSurname()%></label><br>
<label>email <%=account.getEmail()%></label><br>
<label>telephone <%=account.getTelephone()%></label><br>
<label>id <%=account.getId()%></label>
</body>
</html>