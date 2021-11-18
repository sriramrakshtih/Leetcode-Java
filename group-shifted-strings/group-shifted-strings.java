class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        System.out.print(map);
        
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String s) {
        char [] arr = s.toCharArray();
        String key = "";
        for(int i = 1 ; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}