class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> curr= new ArrayList<>();
        helper(nums,used,curr,ans);
        return ans;

    }
    public void helper(int[] nums,boolean[] used,List<Integer> curr,List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;

        }
        for(int i =0;i< nums.length;i++){
            if(used[i]){
                continue;

            }
            curr.add(nums[i]);
            used[i]=true;
            helper(nums,used,curr,ans);
            curr.remove(curr.size()-1);
            
            used[i]=false;
        }
    }
}