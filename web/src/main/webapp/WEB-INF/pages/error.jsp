<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="error-template">
                <h1>Oops!</h1>
                <h2>Status: ${status}</h2>

                <div class="error-details">
                    The page you are looking cannot be represented.
                </div>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/test" htmlEscape="true"/>' class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-home"></span> Back
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
