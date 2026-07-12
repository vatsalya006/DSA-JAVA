class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];

        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        int right = 0;
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {

            if (left[i] == right) {
                ans = i;
            }
            right += nums[i];
        }
        return ans;
    }
}
