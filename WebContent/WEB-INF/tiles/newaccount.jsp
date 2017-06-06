<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div id="signupbox"
		margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Üye Ol</div>
				<div
					style="float: right; font-size: 85%; position: relative; top: -10px">
					<a href='<c:url value="/login"/>'>Giriş Yap</a>
				</div>
			</div>
			<div class="panel-body">

				<sf:form id="details" class="form-horizontal" method="post"
					action="${pageContext.request.contextPath}/createaccount"
					commandName="user">
					<!-- <form id="signupform" class="form-horizontal" role="form"> -->

					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email:</label>
						<div class="col-md-9">
							<sf:input class="form-control" path="email" name="email"
								type="text" placeholder="Email adresinizi giriniz." />
							<sf:errors path="email" cssClass="text-danger"></sf:errors>
						</div>
					</div>

					<div class="form-group">
						<label for="username" class="col-md-3 control-label">Kullanıcı
							Adınız:</label>
						<div class="col-md-9">
							<sf:input class="form-control" path="username" type="text"
								name="username" placeholder="Kullanıcı adınızı giriniz." />
							<sf:errors path="username" cssClass="text-danger"></sf:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-md-3 control-label">Adınız,
							Soyadınız:</label>
						<div class="col-md-9">
							<sf:input class="form-control" path="name" type="text"
								name="name" placeholder="Adınızı ve soyadınızı giriniz." />
							<sf:errors path="name" cssClass="text-danger"></sf:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Şifre:</label>
						<div class="col-md-9">
							<sf:input id="password" class="form-control" path="password"
								type="password" name="password" placeholder="Şifrenizi giriniz." />
							<sf:errors path="password" cssClass="text-danger"></sf:errors>
						</div>
					</div>

					<div class="form-group">
						<label for="confirmpass" class="col-md-3 control-label">Şifre
							Tekrar:</label>
						<div class="col-md-9">
							<input id="confirmpass" class="form-control" name="confirmpass"
								type="password" placeholder="Şifrenizi tekrar giriniz." />
							<div id="matchpass"></div>
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<input class="btn btn-info" value="Hesap Oluştur" type="submit" />
						</div>
					</div>

				</sf:form>
			</div>
		</div>

	</div>
</div>