class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }
    public int helper(int[] nums,int si,int ei,int target){
        int mid = si + (ei-si)/2;
        if(si>ei){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }else if(target < nums[mid]){
            return helper(nums, si, mid - 1, target);
        }
        return helper(nums, mid+1, ei, target);
    }
}