<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		document.f.username.focus();
	});
</script>

<div class="container">
	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Giriş Yap</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px"></div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12"></div>

				<form id="loginform" class="form-horizontal" role="form" name="f"
					action='${pageContext.request.contextPath}/login' method='POST'>

					<c:if test="${param.error ne null}">
						<p class="alert alert-danger">Giriş yapılamadı.Lütfen kullanıcı
							adınızı ve şifrenizi düzgün bir şekilde giriniz.</p>
					</c:if>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input id="login-username"
							type="text" class="form-control" name="username" value=""
							placeholder="Kullanıcı adınız...">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
							type="password" class="form-control" name="password"
							placeholder="Şifreniz...">
					</div>

					<div class="input-group">
						<div class="checkbox">
							<label> <input id="login-remember" type="checkbox"
								name="remember_me" checked="checked"> Beni Hatırla
							</label>
						</div>
					</div>


					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<input id="btn-login" class="btn btn-success" name="submit"
								type="submit" value="Giriş Yap" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12 control">
							<div
								style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								Hesabınız Yokmu? <a href='<c:url value="/newaccount"/>'>Yeni
									hesap oluşturun.</a>
							</div>
						</div>
					</div>

					<%--Cross Site Request Forgery (CSRF)--%>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</div>