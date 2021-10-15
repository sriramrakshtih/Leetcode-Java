class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int lonhgestSteak = 0;
        for(int num : set) {
            if(!set.contains(num-1)){
                int currNum = num;
                int curr = 1;

                while(set.contains(currNum+1)){
                    currNum = currNum + 1;
                    curr++;
                }

                lonhgestSteak = Math.max(lonhgestSteak, curr);
            }
            
            
        }
        return lonhgestSteak;
    }
}