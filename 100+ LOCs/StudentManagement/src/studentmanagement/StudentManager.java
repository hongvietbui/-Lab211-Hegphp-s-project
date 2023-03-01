/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                newId = Checker.checkStringInput("Enter student id: ","^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
                //Enter student name that must be alphabetic and can have white space in the middle
                newStudentName = Checker.checkStringInput("Enter new student name: ","^[a-zA-Z\\s]{1,}[a-zA-Z]$");
                //Enter semester that must be alphanumeric and can have white space in the middle
                newSemester = Checker.checkStringInput("Enter semester: ","^[a-zA-Z0-9\\s]*[a-zA-Z0-9]$");
                //Enter course name that must be alphanumeric and can have white space in the middle
                newCourseName = Checker.checkNewCourseName("Enter course name: ","^[.a-zA-Z0-9\\s]{1,}[.a-zA-Z0-9]$");
                if(!Checker.checkExist(list, newId, newStudentName, newSemester, newCourseName)){
                    list.add(new Student(newId, newStudentName, newSemester, newCourseName));
                    System.out.println("Information added successfully!");
                }
                else{
                    System.out.println("Error: Duplicate information!");
                    i--;
                    System.out.println("Please enter again");
                }
            }
        //Check if user want to continue or not
            choice = Checker.checkContinue("Do you want to continue (Y/N)?\n","[Y|N]","Y/N");
            //Check if the user want to exit
            if(choice.equals("N"))
                break;
        }
    }
    //find and Sort Student by Name
    void findSortStudentByName(ArrayList<Student> list){
        ArrayList<Student> foundedList = new ArrayList<>();
        //Check the database is empty or not
        if(list.isEmpty()){
            System.out.println("List Empty!");
            return;
        }
        //User enter keyword
        String keyword = Checker.checkStringInput("Enter student name: ", "[a-zA-Z ]*");
        //Access elements of ArrayList list from begin to end
        for(Student x:list){
            if(x.getStudentName().contains(keyword))
                foundedList.add(x);
        }
        //Sort list by name
        Collections.sort(foundedList, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return s1.getStudentName().compareTo(s2.getStudentName());
            }
        });
        //display student list
        Display display = new Display();
        display.displayStudentList(foundedList);
    }

    void updateDeleteStudentById(ArrayList<Student> list) {
        String newStudentName;
        String newSemester;
        String newCourseName;
        
        String checkContinue;
        //User input Student id
        String input = Checker.checkStringInput("Type Student Id: ", "^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
        //Check if the id is in database or not
        if(!Checker.checkExist(list, input)){
            System.out.println("Not found!");
            return;
        }
        //Check if user want to continue or not
        checkContinue = Checker.checkContinue("Do you want to update (U) or delete (D) student: ", "[U|D]{1}", "U/D");
        //Check if user want to delete
        if(checkContinue.equals("D")){
        //Find student by ID
            //Access Student in ArrayList list from 1st to last
            for(Student x:list){
                if(x.getId().equals(input))
                    list.remove(x);
            }
            System.out.println("Delete Successfully!");
        }
        //Check if user want to update
        else{
            //Enter student name that must be alphabetic and can have white space in the middle
            newStudentName = Checker.checkStringInput("Enter new student name: ","^[a-zA-Z\\s]{1,}[a-zA-Z]$");
            //Enter semester that must be alphanumeric and can have white space in the middle
            newSemester = Checker.checkStringInput("Enter new semester: ","^[a-zA-Z0-9\\s]*[a-zA-Z0-9]$");
            //Enter course name that must be alphanumeric and can have white space in the middle
            newCourseName = Checker.checkNewCourseName("Enter new course name: ","^[.a-zA-Z0-9\\s]{1,}[.a-zA-Z0-9]$");
            //Check if user making change or not
            if(Checker.checkExist(list, input, newStudentName, newSemester, newCourseName))
                System.out.println("Nothing changed!");
            
        }
    }
}
