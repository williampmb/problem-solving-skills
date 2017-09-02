/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingbat.com;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author willi
 */
public class Map2 {
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String,Integer> db = new HashMap<String,Integer>();

        for(String s: strings){
            if(!db.containsKey(s)){
              db.put(s,s.length());
            }
        }

    return db;
    }
    //---------
    public Map<String, String> pairs(String[] strings) {
        Map<String,String> db = new HashMap<>();
        for(String s: strings){
            db.put(""+s.charAt(0),
              ""+s.charAt(s.length()-1)
              );
        }
        return db;
    }
    
    //-------
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String,Integer> db = new HashMap<String,Integer>();

        for(String s : strings){
          if(!db.containsKey(s)){
            db.put(s,1);
          }else{
            int times = db.get(s);
            db.put(s,++times);
          }
        }
        return db;
    }



}
