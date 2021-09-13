class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            //check if mid element is greater than mid + 1
            // if yes, then you are decreasing part
            //else you are in increasing part
            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}