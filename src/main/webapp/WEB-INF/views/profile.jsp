<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Twitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${twitter.username}" /><br/>
    <c:out value="${twitter.firstName}" /> <c:out value="${twitter.lastName}" /><br/>
    <c:out value="${twitter.email}" />
  </body>
</html>
