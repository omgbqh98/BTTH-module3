<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>

    <h2>
        <a href="/product?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit product
                </h2>
            </caption>
<%--            <c:if test="${product != null}">--%>
<%--                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>--%>
<%--            </c:if>--%>
            <tr>
                <th> price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>amount </th>
                <td>
                    <input type="text" name="amount" size="45"
                           value="<c:out value='${product.amount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>color:</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
                <tr>
                <td>
                    <th>des</th>
                    <input type="text" name="des" size="15"
                           value="<c:out value='${product.des}' />"
                    />
                </td>
        </tr>
            <tr>
                <td>
                    <input type="text" name="idCategory" size="15"
                           value="<c:out value='${product.idCategory}' />"
                    />
                </td>
            </tr>
                <td>
                    <input type="text" name="nameProduct" size="15"
                           value="<c:out value='${product.nameProduct}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>