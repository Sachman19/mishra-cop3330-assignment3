/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class app {

    public static void main(String[] args){
        //Initialize Scanner and set to System.in
        Scanner input = new Scanner(System.in);

        //Ask user for website name
        System.out.print("Site name: ");
        String webName = input.nextLine();

        //Ask user for author name
        System.out.print("Author name: ");
        String authName = input.nextLine();

        //Ask user for javascript folder
        System.out.print("Would you like a folder for javascript? ");
        String jsCheck = input.nextLine();

        while(!validateInput(jsCheck)){
            System.out.print("Error, Valid input is \"yes\", \"y\", \"no\", \"n\". Please try again: ");
            jsCheck = input.nextLine();
        }
        int jsCheckF = parseInput(jsCheck);

        //Ask user for css folder
        System.out.print("Would you like a folder for css? ");
        String cssCheck = input.nextLine();

        while(!validateInput(cssCheck)){
            System.out.print("Error, Valid input is \"yes\", \"y\", \"no\", \"n\". Please try again: ");
            cssCheck = input.nextLine();
        }
        int cssCheckF = parseInput(cssCheck);

        //Forward user input to method to create website
        createWebsite(webName, authName, jsCheckF, cssCheckF);
    }

    public static void createWebsite(String webName, String authName, int jsCheck, int cssCheck){
        //begin by creating website directory
        String webNameClear = webName.replaceAll("\\s", ""); //clears whitespace from website name. Makes naming folder easier.

        String filePath = "src/main/java/ex43/website/" + webNameClear;
        File dir = new File(filePath);
        if(dir.mkdirs()) {
            System.out.printf("Created %s\n", dir.getPath());
        }
        else{
            System.out.print("Error creating base directory.\n");
            return;
        }
        //create index.html file
        createIndex(webName, authName);

        //if jsCheck == 1, create js folder
        if(jsCheck == 1){
            File jsDir = new File(filePath + "/js");
            if(jsDir.mkdir()) {
                System.out.printf("Created %s\n", jsDir.getPath());
            }
            else{
                System.out.print("Error creating directory.\n");
                return;
            }
        }
        //if cssCheck == 1, create css folder
        if(cssCheck == 1){
            File cssDir = new File(filePath + "/css");
            if(cssDir.mkdir()) {
                System.out.printf("Created %s\n", cssDir.getPath());
            }
            else{
                System.out.print("Error creating directory.\n");
            }
        }
    }

    public static boolean validateInput(String input){
        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
            return true;
        }
        else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
            return true;
        }
        else return false;
    }

    public static int parseInput(String input){
        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) return 1;
        else return 0;
    }

    public static void createIndex(String webName, String authName){
        String filePath = "src/main/java/ex43/website/" + webName.replaceAll("\\s", "") + "/index.html";
        File index = new File(filePath);
        try{
            index.createNewFile();
        }
        catch(IOException e){
            System.out.print("Error with output file creation.");
            e.getStackTrace();
        }

        try{
            FileWriter writeOut = new FileWriter(filePath);

            //Writing the html document in separate lines makes it easier to read within code.
            writeOut.write("<!DOCTYPE html>\n");
            writeOut.write("<html>\n");
            writeOut.write("<head>\n");
            writeOut.write("\t<title>" + webName + "<\\title>\n" );
            writeOut.write("<meta name =\"author\" content = \"" + authName + "\">\n");
            writeOut.write("</head>\n");
            writeOut.write("<body>\n\n</body>\n</html>");

            writeOut.close();
        }
        catch(IOException e){
            System.out.print("Error with writing data to index.html\n");
        }

        System.out.printf("Created %s\n", index.getPath());
    }
}
