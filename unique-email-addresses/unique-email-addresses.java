class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String str : emails) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if(c == '+' || c == '@'){
                    break;
                } 
                if(c != '.') {
                    sb.append(c);
                }
            }
            
            StringBuilder domName = new StringBuilder();
            
            for(int i = str.length() - 1; i>= 0; i--) {
                char c = str.charAt(i);
                domName.append(c);
                if(c == '@') {
                    break;
                }
            }
            
            domName = domName.reverse();
            sb.append(domName);
            set.add(sb.toString());
        }
        
        return set.size();
    }
}