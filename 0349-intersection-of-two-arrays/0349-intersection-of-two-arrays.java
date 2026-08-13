class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
     Map<Integer,Integer> map = new HashMap<>();
     for(int num : nums1){
        map.put(num,map.getOrDefault(num,0)+1);
     }   
     List<Integer> res = new ArrayList<>();
     for(int num : nums2){
        if(map.containsKey(num)){
            res.add(num);
            map.remove(num);
        }
     }
     int[] result= new int[res.size()];
     for(int i=0;i<res.size();i++){
        result[i]=res.get(i);
     }
     return result;

    }
}