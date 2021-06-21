/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex46;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class app {

    public static void main(String[] args) {
        List<String> lines;
        try {
            //Reuse method used in ex45 to create arraylist of strings
            lines = Files.readAllLines(Path.of("src/main/java/ex46/exercise46_input.txt"));
            lines = makeListEvenBigger(lines);
        } catch (IOException e) {
            return;
        }
        //Use hashmap to map words with a count
        HashMap<String, Integer> newMap = assignHashMap(lines);

        //sort hashmap by values
        comparison(newMap);

        //print values
        printOutput(newMap);
    }

    public static List<String> makeListEvenBigger(List<String> lines){
        //Create new list to copy values into
        List<String> newList = new ArrayList<>();

        //Split string and copy each substring into new list
        for (String line : lines) {
            String[] temp = line.split(" ");
            newList.addAll(Arrays.asList(temp));
        }
        lines.clear();

        return newList;
    }

    public static HashMap<String, Integer> assignHashMap(List<String> lines){
        HashMap<String, Integer> mapping = new HashMap<>();
        for (String temp : lines) {
            //Assign this to a temp value to make it easier to read.
            //If string is already contained in hashmap, increment value by one.
            if (mapping.containsKey(temp)) {
                mapping.replace(temp, mapping.get(temp) + 1);
            } else {
                //Otherwise, create said entry with value of one.
                mapping.put(temp, 1);
            }
        }
        return mapping;
    }

    // function to sort hashmap by values
    public static void comparison(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
    }

    public static void printOutput(HashMap<String, Integer> hMap){
        //for (Map.Entry<String, Integer> stringIntegerEntry : hMap.entrySet()) {

        for (Map.Entry<String, Integer> stringIntegerEntry : hMap.entrySet()) {
            System.out.printf("%-9s: ", ((Map.Entry) stringIntegerEntry).getKey());
            for (int i = 0; i < (int) ((Map.Entry) stringIntegerEntry).getValue(); i++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
