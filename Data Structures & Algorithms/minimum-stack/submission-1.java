class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minimum;
    
    
    public MinStack() {
        this.values = new Stack<>();    
        this.minimum = new Stack<>();
    }
    
    public void push(int val) {
        this.values.push(val);
        
        if (minimum.isEmpty()) {
            minimum.push(val);
        } else {
            minimum.push(Math.min(minimum.peek(), val));

            
        }

        
    }
    
    public void pop() {
        this.values.pop();
        this.minimum.pop();
    }
    
    public int top() {
        return this.values.peek();
        
    }
    
    public int getMin() {
        return this.minimum.peek();
    }
}
