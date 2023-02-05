/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;
import studentmanagement.Data.*;
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
        Database data = new Database();
        ArrayList<Students> list = data.getDatabase(); 
        StudentManager manager = new StudentManager();
        //Step 1: Show main screen
        Display display = new Display();
        while(true){
            display.mainScreen("WELCOME TO STUDENT MANAGEMENT","Create",
                "Find and Sort","Update/Delete","Report","Exit");
            //Step 2: input choice
            Checker check = new Checker();
            int choice = check.inputChoice(1,5);
            //Step 3: Run selected function
            switch(choice){
            //Create
                case 1:
                    manager.create(list);
                    break;
            //Find/Sort
                case 2:
                    manager.findSort(list);
                    break;
            //Update/Delete
                case 3:
                    manager.updateDelete(list);
                    break;
            //Report
                case 4:
                    manager.report(list);
                    break;
            //Step 4: Exit
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
