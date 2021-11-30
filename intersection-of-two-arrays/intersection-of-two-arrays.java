class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        List<Integer> li = new ArrayList<>();
        
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                li.add(nums2[i]);
                set.remove(nums2[i]);
            }
            if(set.isEmpty()) break;
        }
        
        int [] arr = new int[li.size()];
        for(int i = 0; i < arr.length;i++){
            arr[i] = li.get(i);
        } 
        return arr;   
    }
}