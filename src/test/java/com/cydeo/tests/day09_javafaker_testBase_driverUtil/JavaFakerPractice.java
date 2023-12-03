package com.cydeo.tests.day09_javafaker_testBase_driverUtil;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){
        //creating Faker object to reach methods
        Faker faker = new Faker(new Locale("tr"));
        //Faker faker = new Faker();

        //using the methods
        String aircraft = faker.aviation().aircraft();
        System.out.println("aircraft = " + aircraft);

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        Address address = faker.address();
        System.out.println("address = " + address);

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        //generates random numbers
        String numerify = faker.numerify("###-###-#######");
        System.out.println("numerify = " + numerify);

        String numerify1 = faker.numerify("0-535-###-##-##");
        System.out.println("numerify1 = " + numerify1);

        /*String cardNumber = faker.finance().creditCard().replaceAll("-","");
        System.out.println("cardNumber = " + cardNumber);*/


        String fact = faker.chuckNorris().fact();
        System.out.println("fact = " + fact.replaceAll("Chuck Norris", "Muhtar"));

        System.out.println("-----------------------------------------------");

        //letterify
        String letterify = faker.letterify("???-?-???????");
        System.out.println("letterify = " + letterify);

        String letterify1 = faker.letterify("???-?-?????my");
        System.out.println("letterify1 = " + letterify1);

        System.out.println("-----------------------------------------------");

        //bothify
        String bothify = faker.bothify("##?-#??-9m#");
        System.out.println("bothify = " + bothify);

    }

}
