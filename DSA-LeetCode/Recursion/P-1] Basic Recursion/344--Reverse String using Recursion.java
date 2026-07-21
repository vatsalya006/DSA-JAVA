class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
    public void helper(char[] s, int si, int ei){
        if(si >= ei){
            return;
        }
        char temp = s[si];
        s[si] = s[ei];
        s[ei] = temp;

        helper(s, si + 1, ei - 1);
    }
}