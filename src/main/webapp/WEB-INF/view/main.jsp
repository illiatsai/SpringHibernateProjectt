<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="by.htp.main.entity.News" %>
<%@ page import="by.htp.main.entity.Tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="тур, путешествие, отдых">
    <meta name="description" content="Дешёвые туры в любую страну с вылетом из Минска">
    <style>
        .pagination c {
            border-radius: 5px;
        }

        .pagination a.active {
            border-radius: 5px;
        }

        a:link {
            color: green;
            background-color: transparent;
            text-decoration: none;
        }
        a:hover {
            color: blue;
            background-color: transparent;
            text-decoration: underline;
        }
        a:active {
            color: red;
            background-color: transparent;
            text-decoration: underline;
        }
    </style>
    <title>Minsk tour</title>
    <link rel="stylesheet" href="/resources/css/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <img src="https://seeklogo.com/images/M/minsk-logo-9E6258EEF8-seeklogo.com.gif" width="70" height="70">
    <h1>Minsk tour</h1>
</div>
<button class="w3-button w3-cyan w3-hover-light-blue w3-round-large" onclick="location.href='/main/formAddNews'">Add news</button>
<button class="w3-button w3-cyan w3-hover-light-blue w3-round-large" onclick="location.href='customer/list'">List all users</button>


<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-button w3-green w3-hover-light-green w3-round-xxlarge" style="width:120%" onclick="location.href='/main/tours/searchTour'">Search tour</button>
    </div>
    <div class="w3-panel w3-border-top w3-border-bottom w3-border-green">
        <table class="w3-table w3-striped">
            <c:forEach var="tempNews" items="${news}">
                <!-- construct an "update" link with customer id -->
                <c:url var="detailLink" value="/main/newsDetails">
                    <c:param name="newsId" value="${tempNews.id}" />
                </c:url>
                <ui>
                    <tr>
                        <td>
                            <a href="${detailLink}">${tempNews.headerNews}</a>
                        </td>
                        <td>${tempNews.preview}</td>
                        <td><i><fmt:formatDate value="${tempNews.date}" pattern="dd-MM-yyyy" /></i></td>
                    </tr>
                </ui>
            </c:forEach>
        </table>
    </div>
</div>
<div id="pagination" class="pagination">
    <c:url value="/main/news" var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
    </c:if>

    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span>${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="/main/news" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="/main/news" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if>
</div>

</body>
</html>
