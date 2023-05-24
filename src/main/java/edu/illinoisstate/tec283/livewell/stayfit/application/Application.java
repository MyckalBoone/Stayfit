/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.illinoisstate.tec283.livewell.stayfit.application;
import edu.illinoisstate.tec283.livewell.stayfit.user.user;
import edu.illinoisstate.tec283.livewell.stayfit.calculation.calculation;
import edu.illinoisstate.tec283.livewell.stayfit.dao.dao;
//import edu.illinoisstate.tec283.livewell.stayfit.dao.Arraylist;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;

/**
 *
 * @author mycka
 */
public class Application {
     public static void main(String[] args) {
         int choice;
        System.out.println("Welcome to StayFit!");
        
        user test = new user();
        
        calculation test2 = new calculation();
        
        dao test3 = new dao();
        
        ArrayList<user> listOfUsers = test3.listOfUsers;
        String userName;
        
        
        do{
         
         System.out.println("1: Collect new user data");
         
         System.out.println("2: Collect existing user data");
        
         System.out.println("3: Print complete health report");
         
         System.out.println("4: Print ideal body Weight");
         
         System.out.println("5: Print daily caloric & Fat intake");
         
         System.out.println("6: Print Body Mass Index");
         
         System.out.println("7: Print basal metabolic Rate");
         
         System.out.println("8: Print body fat percentage");
         
         System.out.println("9: Print body adiposity Index");
         
         System.out.println("10: Print waist to hip ratio");
         
         System.out.println("11: Exit StayFit");
                          
         System.out.println("Please choose a number from the menu above:");
        Scanner input = new Scanner(System.in);
        
        choice = input.nextInt();
       
        switch(choice){
            case 1:
                
               test = new user();
               System.out.println("Please enter your information below.");
         
                System.out.println("First Name:");
                String firstName = input.next();
                test.setFirstName(firstName);
                
                System.out.println("Last Name:");
                String lastName = input.next();
                test.setLastName(lastName);
         
                char letter = lastName.charAt(0);
                System.out.println("Hi, " + test.getFirstName() + " " + letter +".");
         
                LocalDate currentDate = LocalDate.now();
                System.out.println("Today's date is " + currentDate); 
                
                 System.out.println("please create a username");
                 userName = input.next();
                 test.setUserName(userName);
                
                System.out.println("Please enter your gender:");
                String gender = input.next();
                test.setGender(gender);
                
                
                System.out.println("please enter your weight in POUNDS:");
                double weight = input.nextInt();
                test.setWeight(weight);
                //test3.storeUserWeight(weight);
                
                
                System.out.println("please enter your height in INCHES:");
                double height = input.nextInt();
                test.setHeight(height);
                
                
                System.out.println("please enter you waist size:");        
                double waist = input.nextInt();
                test.setWaist(waist);
                
                
                System.out.println("please enter you hip size:");        
                double hip = input.nextInt();
                test.setHip(hip);
         
                
                System.out.println("How many days a week are you active?");
                double activity = input.nextByte();
                test.setActivity(activity);
                
                
                System.out.println("Enter your birthdate(yyyy-mm-dd):");
        
                String birthDate = input.next();

                LocalDate birthDateString = LocalDate.parse(birthDate); 

                LocalDate theCurrentDate = LocalDate.now(); 

                Period date = Period.between(birthDateString, theCurrentDate);

                double age = date.getYears();
                test.setAge(age);
                
                //test3.getListOfUsers();
                
                test3.saveData(test);
                
                break;
            case 2:
                System.out.println("please enter username:");
                 userName = input.next();
                 
                 test3.retrieveData(userName);
                 
                  System.out.println("please enter your weight in POUNDS:");
                weight = input.nextInt();
                test.setWeight(weight);
                //test3.storeUserWeight(weight);
                
                
                System.out.println("please enter your height in INCHES:");
                height = input.nextInt();
                test.setHeight(height);
                
                
                System.out.println("please enter you waist size:");        
                waist = input.nextInt();
                test.setWaist(waist);
                
                
                System.out.println("please enter you hip size:");        
                hip = input.nextInt();
                test.setHip(hip);
         
                
                System.out.println("How many days a week are you active?");
                activity = input.nextByte();
                test.setActivity(activity);
                
                 test3.saveData(test);
                 break;
            case 3:
                double IDW = test2.getIDW(test.getHeight(),test.getGender());
                System.out.println(IDW);
                
                double fat = test2.getFatIntake(test.getActivity());
                System.out.println(fat);
                
                double BMI = test2.getBMI(test.getWeight(),test.getHeight());
                System.out.println(BMI);

                double BMR = test2.getBMR(test.getGender(),test.getWeight(),test.getHeight(),test.getAge());
                System.out.println(BMR);
                
                double BFP = test2.getBFP(BMI,test.getAge(),test.getGender());
                System.out.println(BFP);
                
                double BAI = test2.getBAI(test.getHip(),test.getHeight());
                System.out.println(BAI);
                
                double waistRatio = test2.getWaistRatio(test.getWaist(),test.getHip());
                System.out.println(waistRatio);
                break;
            case 4:
                IDW = test2.getIDW(test.getHeight(),test.getGender());
                System.out.println(IDW);
                break;
            case 5:
                fat = test2.getFatIntake(test.getActivity());
                System.out.println(fat);
                break;
            case 6:
                BMI = test2.getBMI(test.getWeight(),test.getHeight());
                System.out.println(BMI);
            case 7:
                BMR = test2.getBMR(test.getGender(),test.getWeight(),test.getHeight(),test.getAge());
                System.out.println(BMR);
                break;
            case 8:
                BFP = test2.getBFP(test2.getBMI(test.getWeight(),test.getHeight()),test.getAge(),test.getGender());
                System.out.println(BFP);
                break;
            case 9:
                BAI = test2.getBAI(test.getHip(),test.getHeight());
                System.out.println(BAI);
                break;
            case 10:
                waistRatio = test2.getWaistRatio(test.getWaist(),test.getHip());
                System.out.println(waistRatio);
                break;
            case 11:
                
                //test2.max(listOfUsers,test.getUserName());
                //test2.min(listOfUsers, test.getUserName());
                //test2.calculateAvg(listOfUsers, test.getUserName());
                System.out.println("Thanks Bye!");
                break;
               
        }
          
        }
        while (choice != 11);
        
        
        
        
         
         
        
        
    }
}
