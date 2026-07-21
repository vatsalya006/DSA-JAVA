class Solution {
    public int kthGrammar(int n, int k) {

        // Base Case
        if (n == 1) {
            return 0;
        }

        // Find parent's value
        int parent = kthGrammar(n - 1, (k + 1) / 2);

        // Left child (odd position)
        if (k % 2 == 1) {
            return parent;
        }

        // Right child (even position)
        return 1 - parent;
    }
}