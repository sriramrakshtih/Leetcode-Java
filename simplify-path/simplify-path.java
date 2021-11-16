class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String [] str = path.split("/");
        
        for(String s : str){
            if(s.equals(".") || s.isEmpty()){
                continue;
            } else if(s.equals("..")) {
                if(!st.isEmpty()){
                    st.pop();
                }
            } else {
                st.add(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String res : st){
            sb.append("/");
            sb.append(res);
        }
        
        return sb.length() > 0 ? sb.toString() : "/";
    }
}