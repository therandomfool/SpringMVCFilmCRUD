<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Status</title>
</head>
<body>
${result}

	<c:choose>
		<c:when test="${! empty films}">
      ${films}
    </c:when>
    </c:choose>

</body>
</html>