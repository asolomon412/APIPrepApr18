<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API Testing</title>
</head>
<body>
<h1>Consuming a Rest Service</h1>
<a href="/"><button>New Quote</button></a><br>
${test.type}<br>
${test.value.quote}
</body>
</html>