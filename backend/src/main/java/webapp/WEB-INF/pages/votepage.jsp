<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<t:base-page>
    <html lang="en">

    <div style="text-align: center">
        <h1 align="center">Страница голосования</h1>
        <a href="/voteresult">Посмотреть результат</a>
    </div>

    <div style="float:left">
        <div class="card" style="width: 18rem;">
            <c:if test="${not empty cats.get(0).ava_link}">
                <img src="${cats.get(0).ava_link}" class="card-img-top">
            </c:if>
            <div class="card-body p-0">
                <a href="/voteaction/${user.id}/${cats.get(0).id}" class="btn btn-primary">${cats.get(0).name}</a>
            </div>
        </div>
    </div>
    <div style="float:right">
        <div class="card" style="width: 18rem;">
            <c:if test="${not empty cats.get(1).ava_link}">
                <img src="${cats.get(1).ava_link}" class="card-img-top">
            </c:if>
            <div class="card-body p-0">
                <a href="/voteaction/${user.id}/${cats.get(1).id}" class="btn btn-primary">${cats.get(1).name}</a>
            </div>
        </div>
    </div>
    </div>
    </html>
</t:base-page>