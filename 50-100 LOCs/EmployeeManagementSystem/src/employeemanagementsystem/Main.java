/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

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
        int option;
        while(true){
            //Display main screen
            display.displayMainScreen();
            //User select an option
            option = GetInput.getInt();
            //Run function depends on user's choice
            switch(option){
                //Option 1: Add employees
                case 1:
                    
                //Option 2: Update employees
                case 2:
                //Option 3: Remove employees
                case 3:
                //Option 4: Search employees
                case 4:
                //Option 5: Sort employees by salary
                case 5:
                //Option 6: Exit
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
