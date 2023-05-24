/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.illinoisstate.tec283.livewell.stayfit.dao;

import java.util.*;
import edu.illinoisstate.tec283.livewell.stayfit.user.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import edu.illinoisstate.tec283.livewell.stayfit.user.user;


/**
 *
 * @author mycka
 */
public class dao {
    
    //ArrayList 
    
    public ArrayList<user> listOfUsers;
    
    public dao()
    {
       listOfUsers = new ArrayList<>();
    }
    
    public void storeUser(user e) {
           listOfUsers.add(e);
    }
    
    
    public ArrayList<user> getListOfUsers()
    {
        return listOfUsers;
    }
    
    public void saveData (user test) {
        
        double weight = 0;
        double height = 0;
        double waist = 0;
        double hip = 0;
        double activityLevel = 0;
        
        try {
            
            Connection dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/stayfitdb","username", "password");
            Statement stmt = dbConnection.createStatement();
            //ResultSet rs = stmt.executeQuery("select * from stayfit.userdata");
            
            int userTable = stmt.executeUpdate("INSERT INTO stayfit.users (username, firstname, lastname, dateofbirth, gender)VALUES ('"+test.getUserName()+"', '"+test.getFirstName()+"', '"+test.getLastName()+"', '1995-06-14', '"+test.getGender()+"')");
            
            int rowsUpdated = stmt.executeUpdate("INSERT INTO stayfit.userdata (username, currentdate, weight, height, waist, hip, activitylevel) VALUES ('"+test.userName+"', '2020-09-09',"+test.getWeight()+","+test.getHeight()+", "+test.getWaist()+", "+test.getHip()+", "+test.getActivity()+")");
                
                System.out.println("Rows Updated" + userTable);
                
                dbConnection.close();
            } 
        
        catch (Exception e){
            System.out.println("error "+e.toString());
        }   
    }
    
    
    public ArrayList<user> retrieveData (String userName){
        
        double weight = 0;
        double height = 0;
        double waist = 0;
        double hip = 0;
        double activityLevel = 0;
        
        try {
            
            Connection dbConnection = DriverManager.getConnection("jdbc:derby:/stayfitdb","username", "password");
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stayfit.userdata");
            
            rs = stmt.executeQuery("select weight, height, waist, hip, activityLevel from stayfit.userdata where '"+userName+"' = userName");
            
            while (rs.next())   {
                
                weight = rs.getDouble("weight");
                height = rs.getDouble("height");
                waist = rs.getDouble("waist");
                hip = rs.getDouble("hip");
                activityLevel = rs.getDouble("activityLevel");
                
                user userInfo = new user();
                userInfo.setWeight(weight);
                userInfo.setHeight(height);
                userInfo.setWaist(waist);
                userInfo.setHip(hip);
                userInfo.setActivity(activityLevel);
                
                listOfUsers.add(userInfo);
                
                dbConnection.close();    
            } 
        }
        catch (Exception e){
            System.out.println("error)");
        }
     return listOfUsers;   
    }
    
}