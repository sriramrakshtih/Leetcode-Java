class Solution {
    public int shortestWay(String source, String target) {
        int tp = 0; int sp = 0; int count = 0;
        while(tp < target.length()){
            count++;
            sp = 0;
            int curr = tp;
            while(sp < source.length() && tp < target.length()){
                if(source.charAt(sp) == target.charAt(tp)){
                    tp++;    
                }
                sp++;
            }
            if(curr == tp) return -1;
        }
        return count;
    }
}