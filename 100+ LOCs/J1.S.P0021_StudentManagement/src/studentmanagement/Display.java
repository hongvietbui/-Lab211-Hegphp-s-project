/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;
import java.util.ArrayList;
import studentmanagement.Data.*;
/**
 *
 * @author Lenovo
 */
public class Display {
    //main Screen
    void mainScreen(String msg, String... inputs){
        System.out.println(msg);
        int i = 0;
        for(String x:inputs){   //Show all inputs
            System.out.println("\t"+(++i)+".  "+x);
        }
        System.out.print("(Please choose");
        i=0;
        for(String x:inputs){   //Show all inputs
            System.out.print(" "+(++i)+" to "+x);
        }
        System.out.println(").");
    }
    //display Founded
    void displayFounded(ArrayList<Students> list, int size){
        System.out.printf("%-"+size+"s%-8s"+"%-"+size+"s","Student name|","Semester|","Course");
        for(int i=0;i<list.size();i++){
            System.out.printf("\n%-"+size+"s|%-8s"+"|%-"+size+"s",list.get(i).getName(),
                list.get(i).getSemester(),list.get(i).getCourseName());
        }
        System.out.println("");
    }
    //display reported
    void displayReport(ArrayList<Reports> report){
        //Find longest name
        int longestNameLength = 0;
        for(int i=0;i<report.size();i++){
            if(longestNameLength<report.get(i).getName().length())
                longestNameLength = report.get(i).getName().length();
        }
        //Display table
        for(int i=0;i<report.size();i++){
            System.out.printf("%-"+longestNameLength+"s|%-7s|%-1s\n",
                    report.get(i).getName(),report.get(i).getCourse(),report.get(i).getTotalOfCourse());
        }
    }
}
