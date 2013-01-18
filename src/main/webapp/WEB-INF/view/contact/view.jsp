<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>

<div id="${param.id}" 
     class="modal hide fade" 
     role="dialog"
     aria-labelledby="contact-info-title">

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="contact-info-title">Contact Information</h3>
    </div>

    <div class="overlayable">
        <div class="modal-body">
            <form:form id="contact-form"
                       method="POST" cssClass="form"
                       modelAttribute="contact"
                       action="${ctxPath}/contact/ajax"
                       onsubmit="submitForm(); return false;">

                <div class="alert alert-error" style="display:none;"></div>

                <form:label path="name">Name <span class="required">*</span></form:label>
                <form:input path="name"/>

                <form:label path="address">Address</form:label>
                <form:input path="address"/>

                <form:label path="contactNo">Contact No. <span class="required">*</span></form:label>
                <form:input path="contactNo"/>

                <form:input path="id" cssStyle="display:none;"/>
            </form:form>
        </div>
        <div class="modal-footer">
            <button type="submit" 
                    class="btn btn-primary" 
                    onclick="submitForm()">
                Save
            </button>
            <button type="button" class="btn" data-dismiss="modal">
                Cancel
            </button>
        </div>
        <div class="overlay loading-overlay modal-backdrop">
            <div class="progress progress-striped active">
                <div class="bar" style="width: 100%;">Prcessing...</div>
            </div>
        </div>
    </div>
</div>