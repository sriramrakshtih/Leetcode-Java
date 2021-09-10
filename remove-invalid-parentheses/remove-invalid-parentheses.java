class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(s); set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    res.add(curr);
                    flag = true;
                } 
                if(!flag){
                    for(int j = 0; j < curr.length(); j++) {
                        if(Character.isLetter(curr.charAt(j))) continue;
                        String children = curr.substring(0, j) + curr.substring(j+1);
                        if(!set.contains(children)){
                            set.add(children);
                            q.add(children);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            } else if(c == ')') {
                if(count == 0){
                    return false;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }
}