/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitshop;

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
        while(true){
        //Display main screen
        display.displayMainScreen();
        //User select an option
        int option = GetInput.getInt();
        //Run function depends on user's choice
        switch(option){
            //Option 1: create product
            case 1:
                //Create 
            //Option 2: View order
            //Option 3: Shopping
            //Option 4: exit program
            }
        }
    }
    
}
