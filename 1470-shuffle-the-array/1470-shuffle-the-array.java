class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(nums == null || nums.length == 0) return new int []{};
        int [] res = new int [2 * n];
        int low = 0; int mid = n; int i = 0;
        while(i < res.length) {
            res[i] = nums[low];
            i++;
            low++;
            res[i] = nums[mid];
            i++;
            mid++;
        }
        return res;
    }
}