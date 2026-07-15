import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {

            // Add current character
            count2[s2.charAt(right) - 'a']++;

            // Keep count2 size equal to s1.length()
            if (right - left + 1 > s1.length()) {
                count2[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare both frequency arrays
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}