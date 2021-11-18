class Solution {
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i= 0 ;i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            } else if(c == ')'){
                if(st.isEmpty()){
                    set.add(i);
                } else {
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}