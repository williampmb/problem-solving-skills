package leetcode.com.algorithms;

public class TopKFrequentElements{
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> db = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i : nums){
            db.put(i,db.getOrDefault(i,0)+1);
        }
        
        for(int k1: db.keySet()){
            int freq = db.get(k1);
            if(bucket[freq]==null){
                bucket[freq]= new ArrayList<>();
            }
            bucket[freq].add(k1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int pos = bucket.length-1 ; pos >=0 && ans.size()<k;pos--){
            if(bucket[pos]!=null) ans.addAll(bucket[pos]);
        }
        return ans;
    }
}