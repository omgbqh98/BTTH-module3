

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/9/2020
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" >
    <table border="1" cellpadding="5">
        <caption>
            <h2>Add New product</h2>
        </caption>

        <tr>
            <th> price:</th>
            <td>
                <input type="text" name="price" id="cusName" size="45"/>
            </td>
        </tr>
        <tr>
            <th> amount:</th>
            <td>
                <input type="text" name="amount" id="cusImg" size="45"/>
            </td>
        </tr>
        <tr>
            <th>color:</th>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <th>des:</th>
            <td><input type="text" name="des"></td>
        </tr>


<%--        <tr>--%>
<%--            <td>--%>
<%--                <select name="idCategory">--%>
<%--                    <c:forEach items="${provinces}" var="province">--%>
<%--                        <option value="${province.getName()}"><c:out value="${province.getName()}"></c:out></option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <th>category</th>
            <td><input type="text" name="idCategory"></td>
        </tr>


        <tr>
            <th>nameProduct:</th>
            <td><input type="text" name="nameProduct"></td>
        </tr>





        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
