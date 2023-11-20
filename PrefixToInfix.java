import java.util.Scanner;

public class PrefixToInfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the expression in prefix notation from the user
        System.out.print("Enter the expression in prefix notation: ");
        String prefixExpression = scanner.nextLine();

        // Check for valid prefix expression
        if (!isValidPrefixExpression(prefixExpression)) {
            System.out.println("Incorrect expression input. Make sure the expression is valid.");
            scanner.close();
            return;
        }

        // Convert the prefix expression to infix and display the result
        String infixExpression = convertToInfix(prefixExpression);
        System.out.println("Infix expression: " + infixExpression);
        scanner.close();
    }

    // Check for valid prefix expression
    private static boolean isValidPrefixExpression(String prefixExpression) {
        // Split the expression into tokens (operators and operands)
        String[] tokens = prefixExpression.split("\\s+");

        boolean findOperator = false;
        int operators = 0;
        int numbers = 0;
        boolean findNumber = false;

        // Iterate through the tokens and validate the expression
        for (String token : tokens) {
            // Each token should be a single character
            if (token.length() != 1) {
                return false;
            }

            for (char c : token.toCharArray()) {
                // Check if it is an operator
                if (isOperator(c)) {
                    findOperator = true;
                    operators++;
                }
                // Check if it is a number (digit)
                else if (Character.isDigit(c)) {
                    numbers++;
                    findNumber = true;
                    findOperator = false;
                } else {
                    // Invalid character in the expression
                    return false;
                }
            }
        }

        // Check for a balanced expression with correct number of operators and operands
        if (findNumber && findOperator) {
            return false;
        }
        return numbers == operators + 1;
    }

    // Convert prefix expression to infix expression
    private static String convertToInfix(String prefixExpression) {
        // Use the implementation of the double-ended queue from Part A
        DoubleEndedQueue<String> queue = new DoubleEndedQueueImpl<>();

        // Manage the prefix expression
        String[] tokens = prefixExpression.split("\\s+");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                // If it's an operator, dequeue two numbers and enqueue the result with the operator
                String operand1 = queue.removeFirst();
                String operand2 = queue.removeFirst();
                String result = "(" + operand1 + " " + token + " " + operand2 + ")";
                queue.addFirst(result);
            } else {
                // If it's a number, enqueue it
                queue.addFirst(token);
            }
        }

        // The final result should be the infix form of the expression
        return queue.getFirst();
    }

    // Check if the term is an operator
    private static boolean isOperator(String term) {
        return term.equals("+") || term.equals("-") || term.equals("*") || term.equals("/");
    }

    // Check if the character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
