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
<h2>
    <a href="/product?action=create">Add New Product</a>
</h2>
<h1>Customer List</h1>
<table width="100%" border="1">
    <tr>
        <th>idProduct</th>
        <th>price</th>
        <th>amount</th>
        <th>des</th>
        <th>category</th>
        <th>nameProduct</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.getIdProduct()}"></c:out> </td>
            <td><c:out value="${product.getPrice()}"></c:out> </td>
            <td><c:out value="${product.getAmount()}"></c:out> </td>
            <td><c:out value="${product.getDes()}"></c:out> </td>
            <td><c:out value="${product.getIdCategory()}"></c:out> </td>
            <td><c:out value="${product.getNameProduct()}"></c:out> </td>
            <td>
                <a href="/product?action=edit&id=${product.idProduct}">Edit</a>
                <a href="/product?action=delete&id=${product.idProduct}">Delete</a>
            </td>
        </tr>


    </c:forEach>
</table>
</body>
</html>