class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum=0;
        int minSum=0;
        int ans=0;
        for(int num:nums){
            maxSum=Math.max(0,maxSum+num);
            minSum=Math.min(0,minSum+num);
            ans=Math.max(ans,Math.max(maxSum,-minSum));

        }
        return ans;

    }
    
}