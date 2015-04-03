<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Example</title>
    </head>
    <body>
        <ul>
        <c:forEach var="item" items="${items}">
            <li>${item.name}</li>
        </c:forEach>
        </ul>
    </body>
</html>
