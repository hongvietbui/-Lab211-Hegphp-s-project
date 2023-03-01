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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        StudentManager manager = new StudentManager();
        Database data = new Database();
        ArrayList<Student> list = data.studentList();
        int choice;
        //Loop until user choose exit
        while(true){
        //Display menu
            display.menu("WELCOME TO STUDENT MANAGEMENT","Create","Find and Sort","Update/Delete","Report","Exit");
        //Input user's positive interger in range of 1 to 5 as choice
            choice = Checker.inputPosIntNumberWithRange(1,5);
        //Run function depends on user's choice
            switch(choice){
            //Create Student function
                case 1:
                    manager.createStudent(list);
                    break;
            //Find and sort by name
                case 2:
                    manager.findSortStudentByName(list);
                    break;
            //Update/Delete Student by ID
                case 3:
                    manager.updateDeleteStudentById(list);
                    break;
            //Report
                case 4:
                    manager.reportStudent(list);
                    break;
        //Exit
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
