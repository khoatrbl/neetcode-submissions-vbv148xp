class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        // stack (store index) [0]
        // for 38, 38 > top of stack, we pop, add 38 (index 1)
        // gap = r - l = 1

        // stack [1]
        // see a colder temp = 30, add to stack
        // stack [1,2]

        // stack [1,2]
        // see 36, while 36 > top of stack, pop(), gap = r - l = 1
        // 

        // []
        // stack empty, add i to stack
        // [0]

        // [0]
        // current = arr[1] = 38, peek = arr[0] = 30
        // current > peek == true, pop stack
        // [], index = 0
        // res[index] = [1]
        // add i to stack 
        // [1]

        // [1]
        // current = arr[2] = 30, peek = arr[1] = 38
        // current > peek == false, add i to stack
        // [1, 2]

        // [1, 2]
        // current = arr[3] = 36, peek = arr[2] = 30
        // current > peek == true, pop stack
        // [1], index = 2
        // res[index] = [1, x, 1]
        // stack add i
        // [1, 3]

        // [1, 3]
        // current = arr[4] = 35, peek = arr[3] = 36
        // current > peek == false, add i to stack
        // [1, 3, 4]

        // [1, 3, 4]
        // current = arr[5] = 40, peek = arr[4] = 35
        // while current > peek() == true, pop stack
        // [1, 3]
        // index = 4
        // res[4] = [1, x, 1, x, 1]
        // [1, 3]

        // current > peek == true, pop stack
        // [1]
        // index = 3
        // res[3] = [1, x, 1, 2]

        // current > peek == true, pop stack
        // []
        // index = 1
        // res[1] = [1, 4, 1, 2]

        // stack empty, add i to stack
        // [5]

        // current = arr[6] = 28, peek = arr[5] = 40
        // 

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }

            stack.add(i);
        }

        return res;
    }
}
