/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class StudentManager {
    void createStudent(ArrayList<Student> list){
        String newId;
        String newStudentName;
        String newSemester;
        String newCourseName;
        
        String choice;
        //Loop until user want to return to main menu
        while(true){
        //Loop until user type 10 student
            for(int i=0;i<10;i++){
                System.out.println("Enter student "+(i+1)+":");
                //Enter student id that must be alphanumeric and can have white space in the middle
                newId = Checker.checkStudentID(list,"Enter student id: ","^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
                //Enter student name that must be alphabetic and can have white space in the middle
                newStudentName = Checker.checkStringInput("Enter new student name: ","^[a-zA-Z\\s]{1,}[a-zA-Z]$");
                //Enter semester that must be alphanumeric and can have white space in the middle
                newSemester = Checker.checkStringInput("Enter semester: ","^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
                //Enter course name that must be alphanumeric and can have white space in the middle
                newCourseName = Checker.checkNewCourseName("Enter course name: ","^[.a-zA-Z0-9\\s]{1,}[.a-zA-Z0-9]$");
                list.add(new Student(newId, newStudentName, newSemester, newCourseName));
            }
        //Check if user want to continue or not
            choice = Checker.checkContinue("Do you want to continue (Y/N)?\n","[Y|N]");
            //Check if the user want to exit
            if(choice.equals("N"))
                break;
        }
    }
}
