class Solution {
    public int compress(char[] chars) {

        int i = 0;       // Read pointer
        int idx = 0;     // Write pointer
        int n = chars.length;

        while (i < n) {

            char ch = chars[i];
            int count = 0;

            // Count consecutive same characters
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            // Write the character
            chars[idx++] = ch;

            // Write the count if greater than 1
            if (count > 1) {
                String str = String.valueOf(count);

                for (char digit : str.toCharArray()) {
                    chars[idx++] = digit;
                }
            }
        }

        return idx;
    }
}