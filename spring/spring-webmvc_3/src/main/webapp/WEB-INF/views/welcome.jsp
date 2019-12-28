<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>


<html>
    <head>
        <title>My first example using Spring 3 MVC</title>
    </head>
    <body>
        <h1>Welcome message : <c:out value="${message}"></c:out></h1>
    </body>
</html>