<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 27/01/2019
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 27/01/2019
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Campaign Service</title>
</head>
<body>
<h2>Campaign Information</h2>
<form:form method="post" action="/saveCampaign">
    <table>
        <tr>
            <td><form:label path="nameOfCampaign">Campaign Name</form:label><td>
            <td><form:input path="nameOfCampaign"/></td>
        </tr>
        <tr>
            <td><form:label path="keywords">Keywords</form:label></td>
            <td><form:input path="keywords"/></td>
        </tr>
        <tr>
            <td><form:label path="bidAmount">Bid Amount(min value 1)</form:label></td>
            <td><form:input path="bidAmount"/></td>
        </tr>
        <tr>
            <td><form:label path="campaignFund"> Campaign found </form:label></td>
            <td><form:input path="campaignFund"/></td>
        </tr>
        <tr>
            <td><form:label path="avalibleFund"> Your found </form:label></td>
            <td><form:input path="avalibleFund"/></td>
        </tr>
        <tr>
            <td><form:label path="status">Status</form:label></td>
            <td>
                <form:radiobutton path = "status" value = "T" label = "On" />
                <form:radiobutton path = "status" value = "F" label = "Off" />
            </td>
        </tr>
        <tr>
            <td><form:label path="town"> Town </form:label></td>
            <td>
                <form:select path="town">
                    <form:option value="NONE" label="Select"/>
                    <form:options items="${townList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>

    </table>
</form:form>

</body>
</html>
