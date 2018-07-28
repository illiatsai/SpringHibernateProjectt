<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="${meta}">
    <title>Minsk tour</title>
    <link rel="stylesheet" href="/resources/css/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <img src="https://seeklogo.com/images/M/minsk-logo-9E6258EEF8-seeklogo.com.gif" width="70" height="70">
    <h1>Minsk tour</h1>
</div>
<button class="w3-button w3-cyan w3-hover-light-blue w3-round-large" onclick="location.href='..'">Back to List</button>

<div id="wrapper">
    <div id="header">
        <h2>News details</h2>
    </div>
</div>

<div id="container" class="w3-panel w3-border-top w3-border-bottom w3-border-green">
    <form:form action="saveNews" modelAttribute="news" method="POST">

        <form:hidden path="id" />

        <c:url var="deleteLink" value="/main/deleteNews">
            <c:param name="newsId" value="${news.id}" />
        </c:url>
        <ui>

                <td><h2>${news.headerNews}</h2></td><br>
                <td>${news.bodyNews}</td><br>
                <td>Rubric: ${news.rubric}</td><br><br>
                <td>${news.date}</td>
            <p>
                <a href="${deleteLink}"
               onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
            </p>
        </ui>
    </form:form>

    <div style="clear; both;"></div>

    <%--<p>
        <a class="w3-button w3-green w3-hover-light-green w3-round-xxlarge" href="..">Back to List</a>
    </p>--%>

</div>

</body>

</html>










