package com.skanda.java_practice;


import java.util.*;

class GroupPeopleByGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // We need groupSizes.size() number of lists
        // Traverse each element of groupSizes,
        // Check the group_ID, and insert the position of this element into the groupNumber (value of this element)
        // Have a hashMap of Key = size, value = List of positions where this element was found
        // As soon as the size of this value is equal to the key, move this list to result List

        List<List<Integer>> resultList = new LinkedList<>();
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // Reading each element one by one
        for (int i = 0; i < groupSizes.length; i++) {
            int hKey = groupSizes[i];

            if (hashMap.containsKey(hKey)) {
                List<Integer> currentList = hashMap.get(hKey);
                currentList.add(i);
            } else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(i);
                hashMap.put(hKey, tmp);
            }
            moveListToResult(resultList, hKey, hashMap);
        }

        return resultList;
    }

    private static void moveListToResult(List<List<Integer>> result, int grpSize, Map<Integer, List<Integer>> hashMap) {

        if (hashMap.get(grpSize).size() == grpSize) {
            result.add(hashMap.get(grpSize));
            hashMap.remove(grpSize);
        }
    }
}

