class Solution {
    public boolean isValid(String s) {
        int start = 0; int end = 0;
        int i =0;
        while(s.length() > 0){
            String sb = replaceStr(s);
            if(s == sb){
                break;
            }
            s = sb;
            
        }
        if(s.length() == 0) return true;
        return false;
    }
    
    private String replaceStr(String s){
        String sb = s.replaceAll("abc", "");
        return sb;
    }
}