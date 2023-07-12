package com.Hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Introduction {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",1947);
        hm.put("USA",1776);
        hm.put("Chile",1810);
        hm.put("Korea",1945);
        System.out.println(hm);
//        Put is used to create a new key-value pair
        hm.put("Sinagapore",1965);
        System.out.println(hm);
//       Value of a key can also be changed by put method
        hm.put("Korea",1946);
//        Get prints the value associated with key if key exists
        System.out.println("India " + hm.get("India"));
//        If key doesn't exist than it prints null
        System.out.println("Japan " + hm.get("Japan"));
//        ContainsKey returns true if the key exist else return false
        System.out.println("Has India " + hm.containsKey("India"));
        System.out.println("Has Pakistan " + hm.containsKey("Pakistan"));
//        keySet is used to get all the key values
        Set<String> keys = hm.keySet();
        System.out.println(keys);
//        keySet is used to implement a loop
        for (String key : hm.keySet()) {
            Integer val = hm.get(key);
            System.out.println(key + "-" + val);
        }
        System.out.println(hm.size());
        Collection<Integer> listValues = hm.values();
        System.out.println(listValues);
    }
}
