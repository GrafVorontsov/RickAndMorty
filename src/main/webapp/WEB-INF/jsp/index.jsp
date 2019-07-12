<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Welcome to Rick and Morty info site!</title>
  </head>
  <body>
  <jsp:include page="_header.jsp"/>
  <jsp:include page="menu.jsp"/>
  <jsp:include page="search.jsp"/>
  <p>${message}</p>
  <p>Please enter the character name or part of his name.</p>
  <jsp:include page="_footer.jsp"/>
  </body>
</html>
