/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

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
        TaskManager manager = new TaskManager();
        ArrayList<Task> list = new ArrayList();
        int choice;
        while(true){
            //Step 1: Display main screen
            display.mainScreen();
            //Step 2: User input choice
            choice = Validate.inputInt("",1,4);
            switch(choice){
            //Option 1: Add task
                case 1:
                    manager.addTask(list);
                    break;
            //Option 2: Delete task
                case 2:
                    manager.deleteTask(list);
                    break;
            //Option 3: Display task
                case 3:
                    manager.displayTask(list);
                    break;
            //Option 4: exit
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
