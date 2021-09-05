class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        String lwr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        
       
        //System.out.println(lwr);
        String [] arr = lwr.split("\\s+");
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        
        for(int i = 0; i < arr.length; i++){
            
            if(!set.contains(arr[i])) {
                 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
           
        }
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}