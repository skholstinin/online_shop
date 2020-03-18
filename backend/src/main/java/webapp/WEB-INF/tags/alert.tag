<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="User Page template" pageEncoding="UTF-8" %>
<%@attribute name="style" required="false" %>
<%@attribute name="message" required="true" %>
<c:if test="${not empty message}">
    <div class="alert alert-dismissible mb-3 fade show alert-${style}" role="alert">
            ${message}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
