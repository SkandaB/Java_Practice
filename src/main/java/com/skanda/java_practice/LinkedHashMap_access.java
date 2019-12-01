package com.skanda.java_practice;

import java.util.*;

public class LinkedHashMap_access {

    static class myLinkedHasHashMap<K, V> extends LinkedHashMap {
        private final int MAX_SIZE = 5;

        myLinkedHasHashMap(int capacity, float load_factor, boolean access_order) {
            super(capacity,load_factor,access_order);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > MAX_SIZE;
        }
    }

    public static void main(String[] args) {
//        Map<String, Integer> myMap = new myLinkedHasHashMap<String, Integer>(3, 0.75f, true);
        Map<String, Integer> myMap = new TreeMap<>();
        myMap.put("One", 1);
        myMap.put("Two", 2);
        myMap.put("Three", 3);
        myMap.put("Four", 4);
        myMap.put("Five", 5);
        System.out.println(myMap);
        System.out.println("Accessing element: "+ myMap.get("Three"));
        myMap.put("Six" , 6);
        System.out.println(myMap);
        for(Map.Entry<String, Integer> curr : myMap.entrySet()) {
            curr.setValue(14);
        }
        System.out.println(myMap);

        ((TreeMap<String, Integer>) myMap).firstEntry().setValue(11);
        System.out.println(myMap);
    }
}
