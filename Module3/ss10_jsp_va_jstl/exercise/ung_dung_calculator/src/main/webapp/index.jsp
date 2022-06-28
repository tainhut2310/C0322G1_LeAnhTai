<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/28/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Calculator</h3>
  <form action="/calculator" method="post">
  <table border="1">
    <tr>
      <td>
        <label>First Operand: </label>
      </td>
      <td><input type="text" name="firstOperand"><br></td>
    </tr>
    <tr>
      <td>
        <label>Operator: </label>
      </td>
      <td>
        <select name="operator">
          <option value="+">Addition</option>
          <option value="-">Subtraction</option>
          <option value="*">Multiplication</option>
          <option value="/">Division</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>
        <label>Second operand: </label>
      </td>
      <td>
        <input type="text" name="secondOperand"><br>
      </td>
    </tr>
    <tr>
      <td colspan="1"></td>
      <td><input type="submit" id="submit" value="Calculate"></td>
    </tr>
  </table>
  </form>
  </body>
</html>
