<%@tag description="Page vote" pageEncoding="UTF-8" %>
<%@attribute name="cats" required="false" type="ru.skholstinin.testtask.pojo.Cat" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrapper">
    <div class="card">
        <c:if test="${not empty cats.get(0).ava_link}">
            <img src="${cats.get(0).ava_link}" class="card-img-top" alt="Кандидат 1">
        </c:if>
        <div class="card-body p-0">
            <h5 class="card-title pt-3 px-3">${cats.get(0).name}</h5>
        </div>
    </div>
    <div class="card">
        <c:if test="${not empty cats.get(1).ava_link}">
            <img src="${cats.get(1).ava_link}" class="card-img-top" alt="Кандидат 2">
        </c:if>
        <div class="card-body p-0">
            <h5 class="card-title pt-3 px-3">${cats.get(1).name}</h5>
        </div>
    </div>
</div>


