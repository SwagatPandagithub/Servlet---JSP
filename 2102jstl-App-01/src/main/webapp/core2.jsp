<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>Output</title>
	</head>
	<body>
		<c:set scope="page" var="x" value="10"/>
		<c:set scope="page" var="y" value="20"/>
		<c:set var="z" scope="request" value='${x+y}'/>
		
		<c:remove var="z"/>
		
		<h1 style="color:green;text-align:center">The result is ::
			<c:out value="${z}" default="1000"/>
		</h1>
		
		
	</body>
</html>