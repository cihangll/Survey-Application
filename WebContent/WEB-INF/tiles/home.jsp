<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Anket Sahibi</th>
			<th>Email</th>
			<th>Anket Adı</th>
			<th>Anketler</th>
		</tr>
	</thead>

	<c:forEach var="survey" items="${surveys}">
		<tr>

			<td><c:out value="${survey.user.name}"></c:out></td>

			<td><c:out value="${survey.user.email}"></c:out></td>

			<td><c:out value="${survey.name}"></c:out></td>

			<td><spring:url value="/surveys/${survey.id}" var="surveyUrl" />
				<button class="btn btn-primary"
					onclick="location.href='${surveyUrl}'">Ankete Katıl</button></td>

		</tr>

	</c:forEach>

</table>

<br />
<c:choose>
	<c:when test="${hassurvey}">
		<p>
			<a href="${pageContext.request.contextPath}/createsurvey">Anketinizi
				düzenleyin ya da silin.</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>
			<a href="${pageContext.request.contextPath}/createsurvey">Anket
				Oluştur(Json Ekleyerek)</a>
		</p>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/surveyEditorPage">Anket
	Oluştur(Survey Editor ile)</a>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p>
		<br /> <a href="<c:url value="/admin"/>">Admin Sayfası</a>
	</p>
</sec:authorize>
