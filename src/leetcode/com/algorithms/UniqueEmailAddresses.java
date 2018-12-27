/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.algorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author William Barbosa
 */
public class UniqueEmailAddresses {
   public int numUniqueEmails(String[] emails) {
        Map<String, HashSet<String>> db = new HashMap<>();
		int numb =0;
		for(String em : emails){
			String[] tok = em.split("@");
			String email = clearEmail(tok[0]);
			HashSet<String> domain = db.get(tok[1]);
			if(domain == null){
				domain = new HashSet<>();
				db.put(tok[1], domain);
			}
			if(email != null && email.length()>0){
				domain.add(email);
			}
			
		}
		
		Collection<HashSet<String>> values = db.values();
		Iterator<HashSet<String>> it = values.iterator();
		while(it.hasNext()){
			HashSet<String> next = it.next();
			numb += next.size();
		}
		return numb;
    }
    
    private String clearEmail(String string) {
		String[] tok = string.split("[+]");
		String ans = "";
		if(tok.length>0){
			ans = new String(tok[0].replace(".", ""));
		}
		
		return ans;
	} 
}
