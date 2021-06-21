/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex44;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class app {

    public static void main(String[] args){
        //Read json file
        Gson gson = new Gson();
        inventory t1 = gson.fromJson("src/main/java/ex44/exercise44_input.json", inventory.class);
        System.out.printf("%s", t1.name);

        //Copy json file into objects

        //Ask for user input
        //compare user input to json object
        //output data if found, display error if not.

    }
}
