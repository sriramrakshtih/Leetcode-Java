class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                if(Character.isLetter(c)){
                    sb.append(Character.toLowerCase(c));
                }else {
                    sb.append(c);
                }
            }
        }
        String temp = sb.toString();
        System.out.print(temp);
        int low = -1; int high = temp.length();
        while(++low < --high) {
            if(temp.charAt(low) != temp.charAt(high)){
                return false;
            }
        }
        
        return true;
    }
}