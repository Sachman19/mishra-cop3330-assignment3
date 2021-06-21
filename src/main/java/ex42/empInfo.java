/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sachin Mishra
 */

package ex42;

public class empInfo {
    private String fName, lName, salary;

    //Set of methods to return information.
    public String returnFName(){
        return fName;
    }
    public String returnLName(){
        return lName;
    }
    public String returnSalary(){
        return salary;
    }

    public void parseInfo(String inData){
        //Given string in format "fName,lName,salary", split into 3 strings
        String[] splitData = inData.split(",");

        //Assign each substring to attribute.
        lName = splitData[0];
        fName = splitData[1];
        salary = splitData[2];
    }
}
