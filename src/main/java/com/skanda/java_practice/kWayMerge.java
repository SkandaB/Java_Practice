package com.skanda.java_practice;

import java.util.*;

// ShareThis
/*
Given a list of sorted lists, merge all these lists into 1 single sorted list

Feel free to change the values for generating lists in the function "populateLists"

Time and Space trade-off discussed at the end of the file
 */
public class kWayMerge {
    public static void main(String[] args) {
        List<List<Integer>> input = new LinkedList<>();     // List to hold other sorted lists
        populateLists(input);
        printLists(input);
        mergeAll(input);
    }

    private static void mergeAll(List<List<Integer>> input) {

        // this priority queue will hold a Map of <next_min_number, list_this_number_belongs_to)
        PriorityQueue<AbstractMap.SimpleEntry<Integer, ListIterator>> mergePQ = new PriorityQueue<>(input.size(),
                new Comparator<AbstractMap.SimpleEntry<Integer, ListIterator>>() {
                    @Override
                    public int compare(AbstractMap.SimpleEntry<Integer, ListIterator> o1, AbstractMap.SimpleEntry<Integer, ListIterator> o2) {
                        return o1.getKey().compareTo(o2.getKey());      // Calling the compare two between two Integer objects
                    }
                });

        ListIterator<Integer> listItr;

        // Initialize the priority queue with 1 (min) element from each inner list
        for (List<Integer> curr : input) {
            listItr = curr.listIterator();
            mergePQ.add(new AbstractMap.SimpleEntry<>(listItr.next(), listItr));
        }

        List<Integer> resultList = new LinkedList<>();
        AbstractMap.SimpleEntry<Integer, ListIterator> currMap; // holds next min entry
        ListIterator<Integer> currList; // holds Reference to list that the curr min entry in priority belonged to

        System.out.println("Start of merging all lists");

        // Loop until priority queue is not empty
        while (!mergePQ.isEmpty()) {
            currMap = mergePQ.poll();
            currList = currMap.getValue();

            System.out.print("\t");
            System.out.print(currMap.getKey());     // Printing the elements in sorted order
            resultList.add(currMap.getKey());       // Also adding to the result list

            if (currList.hasNext()) {               // Add next min element from the list to priority queue
                mergePQ.offer(new AbstractMap.SimpleEntry<>(currList.next(), currList));
            }
        }

        System.out.println("End of merging all lists");

        // Hacking a way out to use the method printLists
        List<List<Integer>> dummy = new LinkedList<List<Integer>>();
        dummy.add(resultList);
        dummy = Collections.unmodifiableList(dummy);        // Makes the list unmodifiable from here on
        printLists(dummy);

    }

    private static void populateLists(List<List<Integer>> inpList) {

        int listsRange = 11000;     // max K (possible), can be lesser than this
        int minNumLists = 3;        // min K
        int stepRange = 1700;       // arbitrary step size
        int seedInt = 40;           // min Integer value between 0 and 40
        int maxIntRange = 74000;    // cut off max Integer value

        Random random = new Random();
        int totalLists = random.nextInt(listsRange) + minNumLists;      // number of lists to populate

        // Populate each list and add to array
        for (int i = 0; i < totalLists; i++) {
            LinkedList<Integer> currList = new LinkedList<>();
            for (int j = random.nextInt(seedInt); j < random.nextInt(maxIntRange) + 40; j += random.nextInt(stepRange)) {
                currList.add(j);
            }
            inpList.add(currList);
        }
    }

    private static void printLists(List<List<Integer>> inpList) {
        System.out.println("Total number of lists :" + inpList.size());
        int counter = 0;
        for (List<Integer> curr : inpList) {
            System.out.println(curr.toString());
            counter += curr.size();
        }
        System.out.println("Total number of records printed: " + counter);
    }
}


/*
        The reason we have to go with Priority Queue is to not end up with a K-way comparison.
        Else, this will turn into a selection sort amongst those k-min elements.

        Time and Space complexities
        N => Total number of elements, across all lists
        K => Number of lists

        Two approaches here.
        1. About what was asked. To print all the numbers in a complete sorted order
            The Space complexity here will be O(K) additional space. As we only allocate one Priority Queue with max size of K
            We need to hold only 1 element from sorted list. When we consume this min element, we fetch another from SAME list and insert to Priority Queue.
            In the worst case scenario, if each list has only 1 element, then K + N, and hence space complexity = O(N)

            Time Complexity
            Assuming in the worst-case scenario, that all the elements (count across lists), go thru the PriorityQueue,
            we will take O(NlogK) time. Because at any given point in time, the max number of elements in the Priority Queue will be k.

        2. When creating a new list
            Space complexity will be O(N), as we are allocation additional space for N items

            Time complexity doesn't change as insert to a linkedList is O(1), i.e. constant time operation.
 */