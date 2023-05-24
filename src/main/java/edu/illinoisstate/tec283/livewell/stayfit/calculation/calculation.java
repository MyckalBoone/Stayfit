/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.illinoisstate.tec283.livewell.stayfit.calculation;
import edu.illinoisstate.tec283.livewell.stayfit.dao.dao;
import edu.illinoisstate.tec283.livewell.stayfit.user.user;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author mycka
 */
public class calculation {

    double IDW;
    double fatIntake;
    double BMI;
    double BMR;
    double BFP;
    double BAI;
    double waistRatio;
    
    public double getIDW(double height, String gender)
    {
        if (gender.equals("female"))
        {
            if (height > 60)
            {
                IDW = 100 + (height - 60) * 5;
            }
            if (height < 60)
            {
                IDW = 100 - (60 - height) * 5;
            }
        }
        if (gender.equals("male"))
        {
            if (height > 60)
            {
                IDW = 106 + (height - 60) * 6;
            }
            if (height < 60)
            {
                IDW = 106 - (60 - height) * 2;
            }
        }
        IDW = (double) Math.round(IDW * 100) / 100;
        System.out.print("Your ideal body weight is: ");
        return IDW;
    }

    public double getFatIntake(double activity)
    {
        if (activity == 0)
        {
            fatIntake = IDW * 11;
        }
        if (activity < 4 && activity > 0)
        {
            fatIntake = IDW * 13;
        }
        if (activity < 6 && activity > 3)
        {
            fatIntake = IDW * 15;
        }
        if (activity < 8 && activity > 5)
        {
            fatIntake = IDW * 18;
        }
        fatIntake = (double) Math.round(fatIntake * 100) / 100;
        System.out.print("your daily fat intake is: ");
        return fatIntake;

    }

    public double getBMI(double weight, double height)
    {
        double heightFt;

        heightFt = height / 12;

        //int heightSQ = heightFt*heightFt;
        BMI = (weight * 4.88) / (heightFt * heightFt);
        BMI = (double) Math.round(BMI * 100) / 100;

        if (BMI < 18.5)
        {
            System.out.println("You are underweight");
        }
        if (BMI < 26 && BMI > 18.5)
        {
            System.out.println("You are normalweight");
        }
        if (BMI < 30 && BMI > 25)
        {
            System.out.println("You are overweight");
        }
        if (BMI > 30)
        {
            System.out.println("You are obese");
        }
        System.out.print("Your Body mass index is: ");
        return BMI;
    }

    public double getBMR(String gender, double weight, double height, double age)
    {
        if (gender.equals("male"))
        {
            BMR = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
        }
        if (gender.equals("female"))
        {
            BMR = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
        }
        System.out.print("Your basal metabolic rate is: ");
        BMR = (double) Math.round(BMR * 100) / 100;
        return BMR;
    }

    public double getBFP(double BMI, double age, String gender)
    {
        if (gender.equals("male"))
        {
            BFP = (1.2 * BMI) + (.23 * age) - (10.8) - 5.4;
            BFP = (double) Math.round(BFP * 100) / 100;

            if (BFP >= 30)
            {
                System.out.print("High risk body fat");
            }
            if (BFP < 30 && BFP > 20)
            {
                System.out.print("You have excess fat");
            }
            if (BFP < 21 && BFP > 12)
            {
                System.out.print("You are moderately lean");
            }
            if (BFP < 13 && BFP > 8)
            {
                System.out.print("You are lean");
            }
            if (BFP < 9 && BFP > 5)
            {
                System.out.print("You are ultra lean");
            }
            if (BFP < 6)
            {
                System.out.print("Low body fat risk");
            }

        }

        if (gender.equals("female"))
        {
            BFP = (1.2 * BMI) + (.23 * age) - 5.4;
            BFP = Math.round(BFP);

            if (BFP > 40)
            {
                System.out.print("High risk body fat");
            }
            if (BFP < 40 && BFP > 30)
            {
                System.out.print("You have excess fat");
            }
            if (BFP < 31 && BFP > 23)
            {
                System.out.print("You are moderately lean");
            }
            if (BFP < 24 && BFP > 19)
            {
                System.out.print("You are lean");
            }
            if (BFP < 20 && BFP > 15)
            {
                System.out.print("You are ultra lean");
            }
            if (BFP < 16)
            {
                System.out.print("Low body fat risk");
            }
        }
        System.out.print(" with a body fat percentage of: ");
        return BFP;
    }

    public double getBAI(double hip, double height)
    {
        double hipSizeCM = hip * 2.54;

        double heightMeters = height / 39.37;

        double num1 = Math.pow(heightMeters, 1.5);

        BAI = ((hipSizeCM) / (num1)) - 18;
        BAI = (double) Math.round(BAI * 100) / 100;
        System.out.print("Your body adiposity index is: ");
        return BAI;
    }

    public double getWaistRatio(double waist, double hip)
    {

        System.out.print("Your waist ratio is: ");
        waistRatio = waist / hip;
        waistRatio = (double) Math.round(waistRatio * 100) / 100;
        return waistRatio;

    }
    
    public void calculateAvg(ArrayList<user> listOfUsers, String userName)
    {
        double totalWeight = 0;
        int numberOfEntries = 0;
        
        for(int i = 0; i < listOfUsers.size(); i++)
       {
           if(listOfUsers.get(i).getUserName().equals(userName))
           {
               totalWeight = totalWeight + listOfUsers.get(i).getWeight();
               numberOfEntries ++;
           }
       }
        
        double avg = totalWeight/numberOfEntries;
        System.out.println("The average weight is: "+avg);
    }
    
    public void max(ArrayList<user> listOfUsers, String userName) {
        
     ArrayList<user> list = new  ArrayList<>();  
        
      for(int i = 0; i < listOfUsers.size(); i++) {
           
          if(listOfUsers.get(i).getUserName().equals(userName)){
              list.add(listOfUsers.get(i));
          } 
      }
        
        
      double max = 0;
        
              user element = Collections.max(list, Comparator.comparingDouble(user::getWeight));
              max = element.getWeight();  
      
       System.out.println("The maximum weight recorded is: "+max);
    }
    
    public void min(ArrayList<user> listOfUsers, String userName) {
        
        ArrayList<user> list = new  ArrayList<>();  
        
      for(int i = 0; i < listOfUsers.size(); i++) {
           
          if(listOfUsers.get(i).getUserName().equals(userName)){
              list.add(listOfUsers.get(i));
          } 
      }
        
       double min = 0;
       //for(int i = 0; i < list.size(); i++) {
           
         
              user element = Collections.min(list, Comparator.comparingDouble(user::getWeight));
              min = element.getWeight();

             
       // }
       System.out.println("The minimum weight recorded is: "+min);
    }
}
