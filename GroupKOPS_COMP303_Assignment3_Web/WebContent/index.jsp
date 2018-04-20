<%@ include file="./partials/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="margin-top: 65px;">
	<div class="row">
		<h2>Dynamic FAQ with JSPs and JavaBeans</h2>
	</div>

	<div class="row">
		<form action="Faqs" method="post">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text bg-dark border-dark text-light">Topic
						name:</span>
				</div>
				<input type="text" class="form-control" id="topicName"
					name="topicName" class="form-control" /> <input type="submit"
					class="btn btn-dark" value="Search" />
			</div>
		</form>
	</div>

	<c:choose>
		<c:when test="${requestScope.userQueriedDb }">
			<div class="row">
				<h4>You searched for questions with the topic of
					"${requestScope.queriedTopicName}".</h4>
			</div>
			<!-- we present different displays depending on whether any matching faqs found -->
			<c:choose>
				<c:when test="${requestScope.matchingFaqs == null}">
					<h6 class="text-danger">There are no questions which match
						your queried topic...</h6>
				</c:when>
				<c:otherwise>
					<h6 class="text-success">There are
						(${requestScope.matchingFaqs.size() }) questions which match your
						queried topic.</h6>

					<div class="row" id="result">
						<h3>Table of Frequently Asked Questions</h3>
						<table class="table table-hover table-dark">
							<tbody>
								<c:forEach items="${requestScope.matchingFaqs}" var="faq"
									varStatus="counter">
									<tr>
										<td>${faq.question}</td>
										<td>${faq.answer}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<!-- show instructions -->
			<p>Please enter in the name of a topic above and press
				search to find questions related to the topic.</p>
			<p>If the topic name field is left blank, all questions will be
				displayed.</p>
		</c:otherwise>
	</c:choose>
</div>
<!-- end of main container -->

<%--   <%@ include file="./partials/footer.jsp" %> --%>