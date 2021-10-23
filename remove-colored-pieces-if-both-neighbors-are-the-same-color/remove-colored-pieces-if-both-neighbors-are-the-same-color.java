class Solution {
    public boolean winnerOfGame(String colors) {
        int count = 0;
        for(int i = 1; i < colors.length() - 1; i++) {
            char c = colors.charAt(i);
            if(colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A' && colors.charAt(i) == 'A'){
                count++;
            }
        }
        for(int i = 1; i < colors.length() - 1; i++) {
            char c = colors.charAt(i);
            if(colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B' && colors.charAt(i) == 'B'){
                count--;
            }
        }
        
        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}