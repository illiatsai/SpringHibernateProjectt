<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Add news</title>
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

<div id="wrapper">
    <div id="header">
        <h2>Add News</h2>
    </div>
</div>

<div id="container">
    <h3>Save News</h3>

    <form:form action="saveNews" modelAttribute="news" method="POST">

        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Header:</label></td>
                <td><form:input path="headerNews" /></td>
                <%--<form:errors path="headerNews" cssClass="error" />--%>
            </tr>
            <tr>
                <td><label>Body:</label></td>
                <td><form:input path="bodyNews" /></td>
            </tr>
            <tr>
                <td><label>Rubric:</label></td>
                <td><form:input path="rubric" /></td>
            </tr>
            <tr>
                <td><label>Preview:</label></td>
                <td><form:input path="preview" /></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><form:input autocomplete="off" path="date" type="text" id="datepicker" /></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="..">Back to List</a>
    </p>

</div>

</body>

</html>










