/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author William Barbosa
 */
public class SubdomainVisitCount {
    public static void main(String[] args){
    
        String[] arg = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> subdomainVisits = subdomainVisits(arg);
        
    
    }
    
    
    
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> db = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String s : cpdomains){
            String[] timesDomain = s.split(" ");
            int times = Integer.valueOf(timesDomain[0]);
            String[] domain = timesDomain[1].split("\\.");
            StringBuilder visit = new StringBuilder();
            for(int i = domain.length-1; i>=0 ; i-- ){
                visit.insert(0, domain[i]);
                String str = visit.toString();
                
                Integer repeat = db.get(str) == null? 0 :db.get(str);
                db.put(str, repeat+times);
                
                visit.insert(0,".");
            }
            
        }
        
        Set<String> keySet = db.keySet();
        Iterator<String> iterator = keySet.iterator();
        
        while(iterator.hasNext()){
            String next = iterator.next();
            Integer get = db.get(next);
            ans.add(get+" " + next);
        }
        return ans;
        
    }
}
