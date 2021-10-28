class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int l = 0; int r = n-1;
        int lw = height[0]; int rw = height[n-1];
        int res = 0;
        
        while(l <= r) {
            if(lw <= rw){
                if (height[l] < lw){
                    res += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if (height[r] < rw){
                    res += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return res;
    }
}