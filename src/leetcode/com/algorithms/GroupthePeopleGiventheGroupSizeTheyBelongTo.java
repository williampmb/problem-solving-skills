package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new Hashtable<>();
        
        for(int i =0 ; i < groupSizes.length; i++){
            int group = groupSizes[i];
            if(!map.containsKey(group)){
                map.put(group,new ArrayList<>());
            }
            
            List<Integer> curGp = map.get(group);
            curGp.add(i);
            if(curGp.size() == group){
                ans.add(curGp);
                map.remove(group);
            }
            
        }
        
        return ans;
    }
}
