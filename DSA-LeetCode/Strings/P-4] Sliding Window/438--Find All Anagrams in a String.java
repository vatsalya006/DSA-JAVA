import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count1[p.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            // Add current character to count2
            count2[s.charAt(right) - 'a']++;

            // Keep count2 size equal to p.length()
            if (right - left + 1 > p.length()) {
                count2[s.charAt(left) - 'a']--;
                left++;
            }

            // Check if current window is an anagram
            if (Arrays.equals(count1, count2)) {
                ans.add(left);
            }
        }
        return ans;
    }
}