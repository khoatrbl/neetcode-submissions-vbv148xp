class Solution {
    public boolean isValid(String s) {

        if (s.length() <= 1) {
            return false;
        }

        Stack<Character> open = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put(')','(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char p : s.toCharArray()) {
            if (pairs.containsKey(p)) { // if it's a closing bracket
                // if top of stack is the corresponding open bracket
                if (!open.isEmpty() && open.peek() == pairs.get(p)) { 
                    open.pop();        
                } else {
                    return false;
                }
            } else {
                open.push(p);
            }
        }

        return open.isEmpty();
    }
}
