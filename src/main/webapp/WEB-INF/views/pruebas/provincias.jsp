<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<h1>Listado Provincias</h1>

	<table style="text-align: center;" border="1" cellpadding="0"	cellspacing="0">
		<thead>
			<tr>
				<th width="25px">id_provincia</th>
				<th width="150px">cod_provincia</th>
				<th width="25px">Nombre</th>
				<th width="50px">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="provincia" items="${listProvincia}">
				<tr>
					<td>${provincia.getIdProvincia()}</td>
					<td>${provincia.getCodProvincia()}</td>
					<td>${provincia.getNombreProvincia()}</td>
					<td><a href="${pageContext.request.contextPath}/pruebas/provincias/edit/${provincia.getIdProvincia()}.html">Edit</a><br />
						<a href="${pageContext.request.contextPath}/pruebas/provincias/delete/${provincia.getIdProvincia()}.html">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>