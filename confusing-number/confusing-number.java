class Solution {
    public boolean confusingNumber(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        int res = 0;
        int curr = n;
        while(curr > 0){
            int lastDigit = curr % 10;
            curr = curr / 10;
            if(!map.containsKey(lastDigit)) return false;
            
            res = res * 10 + map.get(lastDigit);    
        }
        return res != n;
    }
}