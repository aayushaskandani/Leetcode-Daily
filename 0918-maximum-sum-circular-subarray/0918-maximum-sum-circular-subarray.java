class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=0, total=0, min=0, globalMax=nums[0], globalMin=nums[0];
        for(int i: nums){
            total+=i;
            max=Math.max(max+i,i);
            globalMax=Math.max(globalMax,max);
            min=Math.min(min+i,i);
            globalMin=Math.min(globalMin,min);
        }
        if(globalMax<0) return globalMax;
        return Math.max(globalMax,total-globalMin);
    }
}