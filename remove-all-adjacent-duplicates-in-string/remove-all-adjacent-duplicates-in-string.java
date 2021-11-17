class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLen = 0;
        for(char c : s.toCharArray()){
            if(sbLen != 0 && c == sb.charAt(sbLen - 1)){
                sb.deleteCharAt(sbLen-- - 1);
            } else {
                sb.append(c);
                sbLen++;
            }
        }
        
        return sb.toString();
    }
}