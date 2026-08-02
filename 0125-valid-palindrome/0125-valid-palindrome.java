class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            char left = Character.toLowerCase(s.charAt(start));
            char right = Character.toLowerCase(s.charAt(end));
            if (!Character.isLetterOrDigit(left)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                end--;
                continue;
            }
            if (left != right)
                return false;

            start++;
            end--;

        }
        return true;
    }
}