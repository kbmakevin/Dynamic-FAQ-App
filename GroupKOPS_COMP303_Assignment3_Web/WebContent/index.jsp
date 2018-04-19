<%@ include file="./partials/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="margin-top: 65px;">
	<div class="row">
		<h2>Dynamic FAQ with JSPs and JavaBeans</h2>
	</div>

	<div class="row">
		Topic name:&nbsp;
		<form action="Faqs" method="post">
			<input type="text" id="topicName" name="topicName" /> <input
				type="submit" class="btn btn-primary pull-right" value="OK" />
		</form>
	</div>

	<div class="row" id="result">
		<h1>${requestScope.output}</h1>
		<h1>${requestScope.output2}</h1>

		<c:set var="salary" scope="session" value="${500*2}" />
		<c:if test="${salary > 2000}">
			<p>
				My salary is:
				<c:out value="${salary}" />
			<p>
		</c:if>
	</div>

</div>

<%--   <%@ include file="./partials/footer.jsp" %> --%>