class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
        int res = 0;

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        for (String token : tokens) {
            if (!isOperation(token)) {
                operand.push(Integer.parseInt(token));
            } else {
                int operand1 = operand.pop();
                int operand2 = operand.pop();

                res = evaluate(operand1, operand2, token);

                operand.push(res);
            }
        }

        return res;
    }

    private boolean isOperation(String token) {
        if (token.equals("+") || token.equals("-") ||
            token.equals("*") || token.equals("/")) {

            return true;
        }

        return false;
    }

    private int evaluate(int num1, int num2, String operation) {
        if (operation.equals("+")) {
            return num1 + num2;
        }

        if (operation.equals("-")) {
            return num2 - num1;
        }

        if (operation.equals("*")) {
            return num1 * num2;
        }

        if (operation.equals("/")) {
            if (num1 == 0) {
                return 0;
            }

            return num2 / num1;
        }

        return 0;
    }
}
