package com.cydeo.tests.day09_javafaker_testBase_driverUtil;

public class Singleton {

    //1--> create private constructor
    private Singleton(){}

    //2--> private static String
    //prevent access and provide a getter method
    private static String word;

    //this method will return the word in the way we want to return
    public static String getWord(){
        if (word == null){
            System.out.println("first time call, the word is null. assigning value to it now");
            word = "something";
        } else {
            System.out.println("word already has a value");
        }
        return word;
    }


}
