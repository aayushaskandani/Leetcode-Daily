class Solution {
    public int maximumSum(int[] arr) {
        int noDelete= arr[0];
        int OneDelete=-100000000;
        int ans = arr[0];
        for(int i =1;i<arr.length;i++){
            int newOneDelete=Math.max(
                OneDelete + arr[i],
                noDelete
            );
            int newNoDelete = Math.max(
                arr[i],
                noDelete+arr[i]
            );
            OneDelete=newOneDelete;
            noDelete=newNoDelete;

            ans=Math.max(ans,Math.max(OneDelete,noDelete));

        }
        return ans;
    }
}