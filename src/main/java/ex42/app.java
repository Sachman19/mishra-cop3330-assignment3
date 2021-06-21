/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex42;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class app {

    public static void main(String[] args){
        //Test for input file validity.
        File inFile = new File("src/main/java/ex42/exercise42_input.txt");

        Scanner readFile;
        try {
            readFile = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("exercise42_input.txt not found.");
            return;
        }

        //Assign each line to object in arraylist.
        ArrayList<empInfo> inputData = readData(readFile);

        readFile.close();

        //Output arraylist to console.
        outputData(inputData);
    }

    public static ArrayList<empInfo> readData(Scanner readFile){
        ArrayList<empInfo> inputData = new ArrayList<>();

        while (readFile.hasNextLine()) {
            empInfo newInfo = new empInfo();
            newInfo.parseInfo(readFile.nextLine());
            inputData.add(newInfo);
        }

        return inputData;
    }

    public static void outputData(ArrayList<empInfo> inputData){
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");
        //System.out.printf("%d", inputData.size());

        for (empInfo inputDatum : inputData) {
            System.out.printf("%-9s %-9s %-6s\n", inputDatum.returnLName(), inputDatum.returnFName(), inputDatum.returnSalary());
        }
    }
}
