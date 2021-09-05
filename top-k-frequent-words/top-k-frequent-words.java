class Solution {

    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue(
            new Comparator<Map.Entry<String,Integer>>(){
                public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                    return o1.getValue()==o2.getValue()?o2.getKey().compareTo(o1.getKey()):o1.getValue()-o2.getValue();
                }
            }
        );
        
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        
        
        List<String> list = new ArrayList<>(pq.size());
        System.out.print(pq.size());
        while(!pq.isEmpty()){
            String res = pq.poll().getKey();
            //System.out.print(pq.peek().getKey());
            list.add(0,res);
        }
        System.out.print(map);
        return list;
    }
}