import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
        
}
    
    public void pop() {
        int popped = st.pop();
        if(popped == min){
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}