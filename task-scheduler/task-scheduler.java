class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(char c : tasks){
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
            maxFreq = Math.max(maxFreq, count + 1);
        }
        int maxCount = 0;
        for(char c : map.keySet()){
            if(map.get(c) == maxFreq) maxCount++;
        }
        
        int partition = maxFreq - 1; //2
        int empty = partition * (n - maxCount + 1);
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}