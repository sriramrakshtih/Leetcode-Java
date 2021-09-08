class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = 9999;
        String shortest = "";
        String ref = "";
        for(String str : strs){
            if(str.length() < minLen){
                shortest = str;
                minLen = str.length();
                
            }
             
        }
        ref = shortest;
        //System.out.print(ref);
        for(int i = 0; i < minLen; i++){
            boolean flag = true;
            for(String word : strs){
                if(word.charAt(i) != ref.charAt(i)){
                    flag = false;
                    break;
                } 
            }
            if(flag == true){
                sb.append(ref.charAt(i));
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}
