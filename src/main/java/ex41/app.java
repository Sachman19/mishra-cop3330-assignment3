/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex41;

//Import file and scanner. Additionally, import FileNotFoundException to handle errors. This set of imports handles file reading.
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//Import arraylist to dynamically increase array, as opposed to manual resizing or needing to find the length beforehand.
import java.util.ArrayList;

//Import collections to handle sorting
import java.util.Collections;

//Set of imports to handle writing to file.
import java.io.FileWriter;
import java.io.IOException;

public class app {

   public static void main(String[] args) {
       //Import file and check if valid
       File inFile = new File("src/main/java/ex41/exercise41_input.txt");

       Scanner readFile;
       try {
           readFile = new Scanner(inFile);
       } catch (FileNotFoundException e) {
           System.out.println("exercise41_input.txt not found.");
           return;
       }

       //assign each line to arraylist
       ArrayList<String> inputData = new ArrayList<>();
       while (readFile.hasNextLine()) {
           inputData.add(readFile.nextLine());
       }

       readFile.close(); //Added this in as afterthought but closing scanner saves resources.

       //sort arraylist
       Collections.sort(inputData);

       //Output sorted arraylist to new file
       outputTable(inputData);
   }

    public static void outputTable(ArrayList<String> inputData){ //Function to write the output table.

       //Create relevant output file
       File outFile = new File("output/ex41_output.txt");
       try{
           outFile.createNewFile();
       }
       catch(IOException e){
            System.out.print("Error with output file creation.");
            return;
       }

       //Write to output file
        try{
            FileWriter writeOut = new FileWriter("output/ex41_output.txt");

            writeOut.write("Total of " + inputData.size() + " names\n");
            writeOut.write("----------------------------------------\n");

            for (String inputDatum : inputData) {
                writeOut.write(inputDatum + "\n");
            }
            writeOut.close();
        }
        catch(IOException e){
            System.out.print("Error with writing data to file.");
        }

   }
}
