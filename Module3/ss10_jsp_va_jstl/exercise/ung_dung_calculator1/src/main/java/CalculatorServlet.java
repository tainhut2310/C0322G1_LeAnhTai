import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperator = Double.parseDouble(request.getParameter("firstOperand"));
        double lastOperator = Double.parseDouble(request.getParameter("lastOperand"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:");
        try {
            double result = Calculator.calculator(firstOperator, lastOperator, operator);
            writer.println(firstOperator + " " + operator + " " + lastOperator + " = " + result);
        } catch (RuntimeException ex) {
            writer.println("Error: " + ex.getMessage());
        }
        writer.println("</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
