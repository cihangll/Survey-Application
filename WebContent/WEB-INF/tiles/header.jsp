<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
 
<nav class="navbar navbar-default" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href='<c:url value="/"/>'>Ana Sayfa</a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href='<c:url value="/surveyEditorPage"/>'>ANKET OLUŞTUR</a></li>
    	<li>
	    	<sec:authorize access="isAuthenticated()">
				<a href="<c:url value="/createsurvey"/>">ANKETİ DÜZENLE</a>
			</sec:authorize>
		</li>
		<li>
	    	<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<c:url value="/admin"/>">Kullanıcıları Düzenle</a>
			</sec:authorize>
		</li>
      	<%-- <li><a href='<c:url value="/"/>'>Hakkımızda</a></li>
    	<li><a href='<c:url value="/"/>'>İletişim</a></li> --%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <%-- <li><a href='<c:url value="/"/>'><span class="glyphicon glyphicon-question-sign"></span> Yardım</a></li> --%>
      
      <sec:authorize access="!isAuthenticated()">
      	<li><a href='<c:url value="/newaccount"/>'><span class="glyphicon glyphicon-user"></span> Üye Ol</a></li>
      </sec:authorize>
       
      
      <%-- <li><a href='<c:url value="/login"/>'>Giriş Yap</a></li> --%>
      <li>
	  	<sec:authorize access="isAuthenticated()">
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" method="post">
				
				<input class="btn btn-danger navbar-btn" type="submit" value="Çıkış Yap" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</sec:authorize>
	
		<sec:authorize access="!isAuthenticated()">
			<a href="<c:url value="/login"/>">Giriş Yap</a>
		</sec:authorize>
      </li>
    </ul>
  </div>
</nav>