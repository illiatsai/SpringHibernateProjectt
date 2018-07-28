<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="тур, путешествие, отдых">
    <meta name="description" content="Дешёвые туры в любую страну с вылетом из Минска">
    <style>
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <img src="https://seeklogo.com/images/M/minsk-logo-9E6258EEF8-seeklogo.com.gif" width="70" height="70">
    <h1>Minsk tour</h1>
</div>
<button class="w3-button w3-cyan w3-hover-light-blue w3-round-large" onclick="location.href='/main/news'">Back to List</button>
<br>
<div id="wrapper">
    <div id="header">
        <h2>Search Tour</h2>
    </div>
</div>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
    </div>
    <div class="w3-panel w3-border-top w3-border-bottom w3-border-green">

        <form method = "post" action="searchTourByCriteria" >
            price min: <input type="text" name="priceMin" value="${priceMin}" required="required"><br>
            price max: <input type="text" name="priceMax" value="${priceMax}" required="required"><br>
            start date: <input autocomplete="off" type="text" name="startDate" value="${startDate}" required="required" id="datepicker" /><br>
            <div class="w3-bar w3-padding-large w3-padding-24">
                <button class="w3-button w3-green w3-hover-light-green w3-round-xxlarge" style="width:120%"  type="submit" onclick="location.href='/main/tours/searchTour'">Search tour</button>
            </div>
        </form>

            <%--<form:form action="searchTourByCriteria" modelAttribute="tours" method="POST">

                <!-- need to associate this data with customer id -->
                <form:hidden path="id" />

                <table>
                    <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="startDate" /></td>
                    </tr>

                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Submit" class="submit" /></td>
                    </tr>


                    </tbody>
                </table>


            </form:form>--%>

            <c:forEach var="tempTours" items="${tours}">
                <ui><li>
                        <td><h4>${tempTours.name}</h4></td><br>
                        <td>${tempTours.description}</td><br>
                        <td>Price: <b>${tempTours.price}</b></td><br>
                        <td><i><fmt:formatDate value="${tempTours.startDate}" pattern="dd-MM-yyyy" /></i></td><br><br>
                </ui></li>

            </c:forEach>
        <div style="clear; both;"></div>

        <%--<p>
            <a class="w3-button w3-green w3-hover-light-green w3-round-xxlarge" href="/main/news">Back to List</a>
        </p>--%>

    </div>
</div>
</body>
</html>
