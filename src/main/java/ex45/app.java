/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex45;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class app {

    public static void main(String[] args){
        try {
            //Copy text file into list
            List<String> lines = Files.readAllLines(Path.of("src/main/java/ex45/exercise45_input.txt"));

            //Copy said list into array with fixed newline specifiers
            String[] arr = fixNewLine(lines);

            //Ask user for input
            Scanner in = new Scanner(System.in);
            System.out.print("Name of output file? ");

            //Use user input
            String input = in.nextLine();
            writeOutput(input, arr);

        } catch (IOException e){
            return;
        }
    }

    public static String[] fixNewLine(List<String> lines){
        //Add newline specifiers back into strings
        for(int i = 0; i < lines.size(); i++){
            lines.set(i, lines.get(i) + "\n");
        }

        //Convert list to array
        String[] arr = lines.toArray(new String[0]);

        //Replace 'utilize' with 'use'
        for(int i = 0; i < lines.size(); i++){
            arr[i] = arr[i].replaceAll("utilize", "use");
        }
        return arr;
    }

    public static void writeOutput(String input, String[] arr){
        //Affix folder and file extension to user input, since the user is not mandated to give a file extension.
        input = "output/" + input + ".txt";
        File outFile = new File(input);

        try{
            if (outFile.createNewFile()) {
                try {
                    //Copy arr into new file using custom filename.
                    FileWriter myWriter = new FileWriter(outFile);
                    for (String s : arr) myWriter.write(s);
                    myWriter.close();
                }
                catch (IOException e){
                    return;
                }
            }
        } catch(IOException e){
        }
    }
}
