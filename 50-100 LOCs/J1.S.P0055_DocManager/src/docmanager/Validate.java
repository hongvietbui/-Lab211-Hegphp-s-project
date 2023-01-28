/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docmanager;
import java.util.Scanner;
import java.util.HashMap;
/**
 *
 * @author Lenovo
 */
public class Validate {
    //Input choice
    int inputChoice(){
        int choice;
        Scanner sc = new Scanner(System.in);
        while(true){    //loop until valid
            try{
            choice = Integer.parseInt(sc.nextLine());
            if(choice<0||choice>5)  // 1<=choice<=5
                throw new Exception("Error: choice must be in range of 1-5");
            return choice;
            }catch(NumberFormatException FormatError){
                System.out.println("Error: You must type an integer number!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //check availability
    boolean checkAvailability(){
        DoctorHash newDocHash = new DoctorHash();
        HashMap<String,Doctor> docMap = newDocHash.database();
        return false;
    }
}
