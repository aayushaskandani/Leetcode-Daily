class Solution {
    public int maxFrequencyElements(int[] nums) {
    HashMap<Integer,Integer> freq= new HashMap<>();
    int val=0;
    for(int num:nums){
        freq.put(num,freq.getOrDefault(num,0)+1);
    }
    int maxFreq=0;
    for(int count:freq.values()){
        if(maxFreq<=count){
            maxFreq=count;
        }

    }    
    int total=0;
    for(int ans:freq.values()){
        if(ans==maxFreq){
            total+=ans;
        }
    }
    return total;
    }
}