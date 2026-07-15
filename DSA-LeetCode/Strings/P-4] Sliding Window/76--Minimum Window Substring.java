class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];

        // Frequency of characters needed
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length(); // characters still needed

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);

            // Add current character
            window[ch]++;

            // Useful character found
            if (need[ch] > 0 && window[ch] <= need[ch]) {
                required--;
            }

            // Window is valid
            while (required == 0) {

                // Update minimum answer
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                window[leftChar]--;

                // Window became invalid
                if (need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]) {
                    required++;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}