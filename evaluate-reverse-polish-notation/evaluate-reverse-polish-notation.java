class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String str : tokens) {
            
            if(set.contains(str)) {
                
                int first = st.pop();
                int second = st.pop();
                
                if(str.equals("+")){    
                    st.push(second + first);
                } else if(str.equals("-")){    
                    st.push(second - first);
                } else if(str.equals("*")){    
                    st.push(second * first);
                } else if(str.equals("/")){    
                    st.push(second / first);
                }
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}