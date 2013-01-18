<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                <a href="#" data-action="editContact(${item.id})">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

