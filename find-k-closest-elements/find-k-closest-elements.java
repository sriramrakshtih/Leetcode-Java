class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            //System.out.println(arr[i]);
            q.add(arr[i]);
        }
        
        for(int i = k; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if(x - q.peek() > arr[i] - x){
                q.poll();
                q.add(arr[i]);
            } 
            else {
                break;
            }
        }
        
        
        
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.poll());
        }
        
        return res;
    }
}