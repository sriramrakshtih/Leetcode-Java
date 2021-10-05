class Solution {
    public String getHint(String secret, String guess) {
        int [] arr = new int [10];
        int bulls= 0; int cows = 0;
        
        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s == g) {
                bulls++;
            } else{
                if(arr[s - '0'] < 0){
                    cows++;
                } 
                if(arr[g - '0'] > 0){
                    cows++;
                } 
                arr[s-'0']++;
                arr[g-'0']--;
            }
        }
        
        return (bulls + "A" + cows + "B");
    }
}