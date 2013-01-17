<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="resPath" value="${pageContext.request.contextPath}/resources"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
        <link href="${resPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${resPath}/css/default.css" rel="stylesheet"/>
        <link href="${resPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <script src="${resPath}/js/jquery-1.8.3.js"></script>
        <script src="${resPath}/bootstrap/js/bootstrap.min.js"></script>
        <script src="${resPath}/js/app.js"></script>
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">Contact Mangement</a>
                    <ul class="nav">
                        <li><a href="#">Manage</a></li>
                        <li><a href="#">Options</a></li>
                        <li><a href="#">Others</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <form:form modelAttribute="contact" cssClass="form" method="POST">
                <legend>Contact Information</legend>

                <c:if test="${param.success != null}">
                    <div class="alert alert-info">
                        <i class="icon icon-ok"></i> Record successfully saved.
                    </div>
                </c:if>

                <form:label path="name">Name</form:label>
                <form:input path="name"/>
                <form:errors path="name" element="span" cssClass="alert alert-error"/>

                <form:label path="address">Address</form:label>
                <form:input path="address"/>

                <form:label path="contactNo">Contact No.</form:label>
                <form:input path="contactNo"/>
                <form:errors path="contactNo" element="span" cssClass="alert alert-error"/>

                <div>
                    <button type="submit" class="btn btn-primary">Save</button>
                    <button type="reset" class="btn">Reset</button>
                </div>
            </form:form>
        </div>
    </body>
</html>
