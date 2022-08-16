<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/16/2022
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculator" method="post">
    <fieldset>
        <legend>CALCULATOR</legend>
        <table style="width: 500px; border: solid 1px;" cellpadding="5" cellspacing="2" align="center">
            <tr>
                <th colspan="4" style=" text-align: center">CALCULATOR</th>
            </tr>
            <tr>
                <td>
                    <label style=" float: right;">First Operand: </label>
                </td>
                <td colspan="3"><input type="text" name="firstOperand" value="0"></td>
            </tr>
            <tr>
                <td>
                    <label style=" float: right;">Operator: </label>
                </td>
                <td>
                    <select colspan="3" name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label style=" float: right;">Last Operand: </label>
                </td>
                <td colspan="3"><input type="text" name="lastOperand" value="0"></td>
            </tr>
            <tr>
                <td>
                    <label style=" float: right;">Result:</label>
                </td>
                <td colspan="3"><input disabled type="text" placeholder="result" value="${result}"></td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">
                    <input type="submit" value="Calculator">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
