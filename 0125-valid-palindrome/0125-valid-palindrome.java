class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return true;
        int left=0;
        int right=s.length()-1;
        s=s.toLowerCase();
        while(left<right){
            char Left = s.charAt(left);
            char Right=s.charAt(right);
            if(!Character.isLetterOrDigit(Left)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(Right)){
                right--;
                continue;
            }

            if(Left!=Right){
                return false;

            }
            left++;
            right--;
        }
        return true;
    }
}