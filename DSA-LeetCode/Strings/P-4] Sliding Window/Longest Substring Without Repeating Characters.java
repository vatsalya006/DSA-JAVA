class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] count = new int[128]; 
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar]++;
            
            while (count[rightChar] > 1) {
                char leftChar = s.charAt(left);
                count[leftChar]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}