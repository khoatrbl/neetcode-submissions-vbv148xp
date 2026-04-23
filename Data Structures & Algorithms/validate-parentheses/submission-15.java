class Solution {
    public boolean isValid(String s) {
        // A Map to store all the pairs
        // A stack to keep track of the latest open bracket
        // when we see an open bracket, add it to the stack
        // when we see a close bracket, we compare it to the top of the stack
        // if it does not match then return false;
        // at the end, if the stack is empty -> we have closed all brackets.

        Stack<Character> stack = new Stack();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');

        for (char c : s.toCharArray()) {
            if (!pairs.containsKey(c)) {
                stack.add(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == pairs.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
