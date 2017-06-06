<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>

<link href="${pageContext.request.contextPath}/assets/css/main.css"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value="/assets/bootstrap-3.3.7/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">

<script src="<c:url value="/assets/script/jquery-3.2.0.min.js" />"></script>
<script
	src="<c:url value="/assets/bootstrap-3.3.7/js/bootstrap.min.js" />"></script>


<tiles:insertAttribute name="includes" />

</head>
<body>

	<div class="panel-heading">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="panel-body">
		<tiles:insertAttribute name="content" />
	</div>
	<hr />
	<div class="panel-footer">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>