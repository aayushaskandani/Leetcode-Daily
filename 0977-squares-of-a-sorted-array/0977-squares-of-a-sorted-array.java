class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int index=result.length-1;
        while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];
           if( nums[left]*nums[left] > nums[right]*nums[right]){
            result[index]=leftSquare;
            left++;
            index--;
           }else{
            result[index]=rightSquare;
            right--;
            index--;

           }
        }
        return result;
    }
}