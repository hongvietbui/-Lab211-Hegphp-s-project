package studentmanagement;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Display {
//Display menu
    public void menu(String msg, String... inputs){
        System.out.println(msg);
        int i=0;
        //Access all inputs value to display them
        for(String x:inputs){
            System.out.println("   "+(++i)+". "+x);
        }
        int num = i;
        i=0;
        System.out.print("(Please choose");
        //Access all inputs value to display them
        for(String x:inputs){
            System.out.print(" "+(++i)+" to "+x);
            //Check if the choice displayed is not the last
            if(i>=1&&i<=num-2)
                System.out.print(",");
            //Check if the last choice or not
            if(i==num-1)
                System.out.print(" and");
        }
        System.out.println(" program).");
    }
//Display student list
    public void displayStudentList(ArrayList<Student> list){
    //Check if the list is empty or not
        if(list.isEmpty()){
            System.out.println("Not found!");
            return;
        }
        int largestName = 12;
    //Find the largest name
        //Access every element from 1st to last
        for(Student x: list){
            //Check if the largestName value is larger than one variable or not
            if(largestName<x.getStudentName().length())
                largestName = x.getStudentName().length();
            }
    //Display list
        System.out.printf("%-"+largestName+"s | %-11s | %-15s\n","Student name","semester","Course name");
        //Access every element from 1st to last
        for(Student x: list){
            //Check if the largestName value is larger than one variable or not
            System.out.printf("%-"+largestName+"s | %-11s | %-15s\n",x.getStudentName(),x.getSemester(),x.getCourseName());
        }
    }

    void displayReport(ArrayList<Report> newList) {
        //If the list is empty
        if(newList.isEmpty()){
            System.out.println("Error: Empty database!");
            return;
        }
        //Access every element from 1st to last
        for(Report x:newList){
            System.out.printf("%s | %s | %d\n",x.studentName,x.course,x.totalOfCourse);
        }
    }
}