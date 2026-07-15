class Solution {
    public int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            int curr = getValue(s.charAt(i));
            int next = getValue(s.charAt(i + 1));
            if (curr < next) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }
        // Add the last character
        sum += getValue(s.charAt(s.length() - 1));
        return sum;
    }
}