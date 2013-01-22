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
        <link href="${resPath}/bootstrap/css/bootstrap-cerulean.min.css" rel="stylesheet"/>
        <link href="${resPath}/css/default.css" rel="stylesheet"/>
        <link href="${resPath}/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <script src="${resPath}/js/jquery-1.8.3.js"></script>
        <script src="${resPath}/bootstrap/js/bootstrap.min.js"></script>
        <script src="${resPath}/js/remoting.js"></script>
        <script src="${resPath}/js/app-contact.js"></script>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">Contact Mangement</a>
                    <ul class="nav">
                        <li>
                            <a href="#" data-action="showAddContact()">
                                <i class="icon-white icon-plus"></i> Add
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-white icon-folder-close"></i> Manage
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-white icon-wrench"></i> Settings
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <jsp:include page="view.jsp">
                <jsp:param name="id" value="contact-info"/>
            </jsp:include>

            <div>
                <legend>Contact List</legend>
                
                <form class="input-append">
                    <input type="text" name="searchText" placeholder="Search" class="width300"/>
                    <button type="submit" class="btn btn-primary">
                        <i class="icon-white icon-search"></i> Search
                    </button>
                </form>
            </div>
            <div id="contact-list">
                <jsp:include page="list.jsp"/>
            </div>
        </div>
        <div class="footer container">
            &copy; 2013
        </div>
    </body>
</html>
