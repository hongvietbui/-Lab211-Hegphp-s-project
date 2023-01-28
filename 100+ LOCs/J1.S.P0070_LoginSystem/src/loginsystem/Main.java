/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsystem;
import java.util.Locale;
/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Menu menu = new Menu();
        Validate check = new Validate();
        int choice;
        while(true){ //loop until exit
            //Step 1: Show GUI
            menu.GUI("Vietnamese","English","Exit");
            //Step 2: Input choice
            choice = check.inputChoice("Please choice one option:",1,3);
            switch(choice){
            //Step 3: Change language to Vietnamese
                case 1: 
                    menu.setLocate(new Locale("vi","VN"));
                    break;
            //Step 4: Change language to English
                case 2:
                    menu.setLocate(new Locale("en","US"));
                    break;
            //Step 5: Exit
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
    
}
