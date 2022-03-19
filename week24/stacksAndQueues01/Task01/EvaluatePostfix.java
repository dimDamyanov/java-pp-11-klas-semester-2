package stacksAndQueues01;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {
    static final String OPERATORS = "+-*/^";

    public static void main(String[] args) {
        System.out.println("Enter an expression: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        try {
            System.out.println(evaluatePostFix(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
        sc.close();
    }

    public static int evaluatePostFix(String postfix) {
        Stack<Integer> operandStack = new Stack<>();
        postfix = insertBlanks(postfix);
        String[] tokens = postfix.split(" ");
        for(String token: tokens) {
            if (token.length() == 0)
                continue;
            if (OPERATORS.contains(token)) {
                processOperator(operandStack, token.charAt(0));
            }
            else {
                operandStack.push(Integer.valueOf(token));
            }
        }
        return operandStack.pop();
    }

    public static void processOperator(Stack<Integer> operandStack, char operator) {
        int operand1 = operandStack.pop();
        int operand2 = operandStack.pop();
        if (operator == '+')
            operandStack.push(operand2 + operand1);
        else if (operator == '-')
            operandStack.push(operand2 - operand1);
        else if (operator == '*')
            operandStack.push(operand2 * operand1);
        else if (operator == '/')
            operandStack.push(operand2 / operand1);
        else if (operator == '^')
            operandStack.push((int) Math.pow(operand2, operand1));
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
