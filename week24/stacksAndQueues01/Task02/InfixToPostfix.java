package stacksAndQueues01;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    static final String OPERATORS = "+-*/^";

    public static void main(String[] args) {
        System.out.println("Enter an expression: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        try {
            System.out.println(infixToPostfix(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
        scanner.close();
    }

    public static String infixToPostfix(String expression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<String> helperStack = new Stack<>();
        expression = insertBlanks(expression);
        String[] tokens = expression.split(" ");
        for (String token: tokens) {
            if (token.length() == 0)
                continue;
            if (token.charAt(0) >= 48 && token.charAt(0) <= 57)
                postfixExpression.append(" ").append(token);
            else if (token.charAt(0) == '(')
                helperStack.push(token);
            else if (OPERATORS.contains(token)) {
                if (!helperStack.isEmpty() && OPERATORS.contains(helperStack.peek()) && getPriority(token.charAt(0)) >= getPriority(helperStack.peek().charAt(0)))
                    postfixExpression.append(" ").append(helperStack.pop());
                helperStack.push(token);
            }
            else if (token.charAt(0) == ')') {
                while (helperStack.peek().charAt(0) != '(')
                    postfixExpression.append(" ").append(helperStack.pop());
                helperStack.pop();
            }
        }

        while (!helperStack.isEmpty() && helperStack.peek().charAt(0) != '(')
            postfixExpression.append(" ").append(helperStack.pop());

        return postfixExpression.toString().trim();
    }

    public static int getPriority(char operator) {
        if (operator == '+' || operator == '-')
            return 3;
        else if (operator == '*' || operator == '/')
            return 2;
        else
            return 1;
    }

    public static String insertBlanks(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
                result.append(" ").append(s.charAt(i)).append(" ");
            else
                result.append(s.charAt(i));
        }
        return result.toString();
    }
}
