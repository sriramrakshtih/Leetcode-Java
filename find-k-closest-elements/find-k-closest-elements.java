class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low = 0; int high = arr.length - 1;
        int k_idx = bs(arr, low, high, x);
        System.out.print(k_idx);
        int j = k_idx + 1;
        
        while(k_idx >= 0 && j < arr.length && res.size() != k){
            if(Math.abs(arr[k_idx] - x) <= Math.abs(arr[j] - x)){
                res.add(0, arr[k_idx]);
                k_idx--;
            } else {
                res.add(arr[j]);
                j++;
            }
        }
        
        while(res.size() < k){
            if(k_idx >= 0){
                res.add(0, arr[k_idx]);
                k_idx--;
            } else if(j < arr.length){
                res.add(arr[j]);
                j++;
            }
        }
        return res;
    }
    
    private int bs(int [] arr, int low, int high, int k) {
        while(low < high){
            int mid = low + (high - low) / 2; 
            if(arr[mid] == k || (arr[mid] < k && arr[mid + 1] > k)) {
                return mid;
            } else if(arr[mid] > k){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}