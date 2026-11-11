class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char leftChar = Character.toLowerCase(s.charAt(l));
            char rightChar = Character.toLowerCase(s.charAt(r));

            if (!Character.isLetterOrDigit(leftChar)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                r--;
                continue;
            }

            if (leftChar != rightChar)
                return false;
            
            l++;
            r--;
        }
        return true;
    }
}
