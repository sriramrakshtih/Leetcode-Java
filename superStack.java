import java.util.*;

public class superStack {

    Stack<Integer> st = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int currSum = 0;

    public void push (int v) {
        currSum += v;
        st.push(v);
        list.add(v);
        //System.out.println(v);
    }
     
    public int pop(){
        if(list.size() == 0) return -1;
        if(list.size() > 1){
            int lstButSecond = list.get(list.size()-2);
            lstButSecond += list.get(list.size()-1); 
        }
        int val = st.pop() + list.get(list.size() - 1);
        currSum -= val;
        System.out.print("--->>" +currSum);
        return val;

        
    }

    public void inc(int i, int v) {
        if(list.size() > 0) {
            int idx = Math.min(i, list.size() - 1);
            int idxVal = list.get(idx);
            idxVal += v;
        }
        currSum += i*v;
    }

    public static void main(String [] args) {
        superStack ss = new superStack();
        ss.push(4);
        ss.push(5); 
        ss.inc(2, 1);
        ss.pop();
        System.out.print(ss.currSum);
    }
}


