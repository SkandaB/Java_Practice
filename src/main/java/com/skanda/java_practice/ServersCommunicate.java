package com.skanda.java_practice;
import java.util.*;
class ServersCommunicate {
    public int countServers(int[][] grid) {
        // Step 1:      Put each server in a hashset
        // Step 2:      For each server, check if there is at-least one more server in the same row/column
        // Step 2.1:    If this is the only server in it's row and column, remove this server from hashset
        // Step 3:      Return size of the hashset

        // Set that holds all servers, irrespective of they being able to communicate with others or not
        Set<AbstractMap.SimpleEntry<Integer,Integer>> commServers = new HashSet<>();

        // Step 1:
        // Go thru the entire grid once, and add all the servers
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1)
                    commServers.add(new AbstractMap.SimpleEntry<Integer, Integer>( i, j));
            }
        }

        // Step 2:
        // Go thru each server from the set
        Iterator<AbstractMap.SimpleEntry<Integer, Integer>> itr = commServers.iterator();
        while(itr.hasNext()) {
            AbstractMap.SimpleEntry<Integer, Integer> server = itr.next();

            boolean moreThanOne = false;
            int rowNum = server.getKey();

            // Check each row
            for(int j = 0; j < grid[rowNum].length ; j ++) {
                if(j != server.getValue() && grid[rowNum][j] == 1) {
                    moreThanOne = true;
                    break;
                }
            }

            // Check each column
            int colNum = server.getValue();
            for(int i = 0; i< grid.length ; i++) {
                if(i != server.getKey() && grid[i][colNum] == 1) {
                    moreThanOne = true;
                    break;
                }
            }

            // Step 2.1
            if(!moreThanOne)
                itr.remove();
        }

        // Step 3
        return commServers.size();
    }

}