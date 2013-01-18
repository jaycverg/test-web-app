<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<c:set var="resPath" value="${ctxPath}/resources"/>
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
            <div class="span4">
                <form:form method="POST" cssClass="form"
                           modelAttribute="contact"
                           action="${ctxPath}/contact">
                    
                    <legend>Contact Information</legend>

                    <c:if test="${param.success != null}">
                        <div id="success-info" class="alert alert-info">
                            <i class="icon-ok"></i> Record successfully saved.
                        </div>
                        <script>
                            $('#success-info').hide().fadeIn().delay(3000).fadeOut();
                        </script>
                    </c:if>
                    
                    <form:errors path="*" id="error-info" element="div" cssClass="alert alert-error"/>
                    <script>
                        $('#error-info').hide().fadeIn();
                    </script>

                    <form:label path="name">Name <span class="required">*</span></form:label>
                    <form:input path="name"/>

                    <form:label path="address">Address</form:label>
                    <form:input path="address"/>

                    <form:label path="contactNo">Contact No. <span class="required">*</span></form:label>
                    <form:input path="contactNo"/>
                    <div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        <button type="reset" class="btn">Reset</button>
                    </div>
                </form:form>
            </div>
            <div class="span7">
                <legend>Contact List</legend>

                <table class="table table-bordered">
                    <tr>
                        <th class="a-center">ID</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Contact No.</th>
                        <th></th>
                    </tr>
                    <c:if test="${empty list}">
                        <tr>
                            <td colspan="5">
                                <i>No contact record</i>
                            </td>
                        </tr>
                    </c:if>
                    <c:forEach items="${list}" var="item">
                        <tr>
                            <td class="a-center">${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.address}</td>
                            <td>${item.contactNo}</td>
                            <td class="a-center">
                                <a href="#">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
