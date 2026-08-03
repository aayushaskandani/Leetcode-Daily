class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxwt=0;
        while(left<right){
            int wt=right-left;
            int ht= Math.min(height[left],height[right]);
            int currwt=wt*ht;
            maxwt=Math.max(maxwt,currwt);
           if( height[left] < height[right] ) {
           left++;

           }else{
            right--;
           }

        }
        return maxwt;
    }
}