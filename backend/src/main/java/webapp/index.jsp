<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ru">

<div id="app">
    {{message}}
</div>

<script src="https://cdn.jsdelivr.net/npm/vue@2.6.0"></script>
<script>

    var app = new Vue({
        el: '#app',
        data: {
            message: 'Мимимиметр'
        }
    });
</script>

<div style="text-align: center">
    <h1 align="center">Мимимиметр</h1>
    <a href="/login">Начать</a>
</div>

</html>
