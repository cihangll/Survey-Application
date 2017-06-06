<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	function onDeleteClick(event) {
		var doDelete = confirm("Bu anketi silmek istediğinizden emin misiniz?");

		if (doDelete == false) {
			event.preventDefault();
		}
	}

	function onReady() {
		$("#delete").click(onDeleteClick);
	}

	$(document).ready(onReady);
</script>

<sf:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="survey">

	<sf:input type="hidden" path="id" />

	
	
	<div class="form-group">
		<label for="usr">Anket İsmini Giriniz:</label>
		<sf:input id="usr" class="form-control" path="name" name="name"></sf:input>
		<br/>
		<sf:errors path="name" cssClass="alert alert-danger"></sf:errors>
		<br/>
	</div>
	
	<div class="form-group">
		<label for="comment">Json Değerini Giriniz:</label>
		<sf:textarea id="" class="form-control" path="json" name="json" rows="10" cols="10"></sf:textarea>
		<br/>
		<sf:errors path="json" cssClass="alert alert-danger"></sf:errors>
	</div>
	<input class="btn btn-primary" value="Anketi Kaydet" type="submit" />
	
	<c:if test="${survey.id != 0}">
		&nbsp;
		<input id="delete" name="delete" class="btn btn-danger" value="Anketi Sil" type="submit" /></td>
	</c:if>	

	<%-- <!--  -->
	<table class="table">
		<tr>
			<td>Anket İsmini Giriniz:</td>
			<td><sf:input id="usr" class="form-control" path="name" name="name"></sf:input><br />
				<sf:errors path="name" cssClass="alert alert-danger"></sf:errors></td>
		</tr>
		<tr>
			<td>Json Değerini Giriniz.:</td>
			<td><sf:textarea class="form-control" path="json" name="json"
					rows="10" cols="10"></sf:textarea><br /> <sf:errors path="json"
					cssClass="alert alert-danger"></sf:errors></td>
		</tr>
		<tr>
			<td></td>
			<td><input class="btn btn-primary" value="Anketi Kaydet"
				type="submit" /></td>
		</tr>

		Eğer bu survey mevcut iste delete kısmını göster
		<c:if test="${survey.id != 0}">
			<tr>
				<td></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="delete label"></td>
				<td><input id="delete" name="delete" class="btn btn-danger"
					value="Anketi Sil" type="submit" /></td>
			</tr>

		</c:if>
	</table> --%>

</sf:form>