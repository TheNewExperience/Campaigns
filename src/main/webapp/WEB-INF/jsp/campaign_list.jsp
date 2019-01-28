<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 27/01/2019
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Campaign</title>

</head>
<body>

    <h2>Campaign List</h2>

<table>
    <tr>
    <td>Campaign Name</td>
    <td>${nameOfCampaign}</td>
    </tr>
    <tr>
        <td>Keywords</td>
        <td>${keywords}</td>
    </tr>
    <tr>
        <td>Bid Amount</td>
        <td>${bidAmount}</td>
    </tr>
    <tr>
        <td> Campaign Fund</td>
        <td>${campaignFund}</td>
    </tr>
    <tr>
        <td> Status</td>
        <td>${status}</td>
    </tr>
    <tr>
        <td> Town</td>
        <td>${town}</td>
    </tr>
    </tr>
    <tr>
        <td> Radius</td>
        <td>${radius}</td>
    </tr>
</table>

</div>
</body>
</html>
