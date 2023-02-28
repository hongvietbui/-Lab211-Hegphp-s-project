package studentmanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Display {
    //Display menu
    public void menu(String msg, String... inputs){
        System.out.println(msg);
        int i=0;
        //Access all inputs value to display them
        for(String x:inputs){
            System.out.println("   "+(++i)+". "+x);
        }
        int num = i;
        i=0;
        System.out.print("(Please choose");
        //Access all inputs value to display them
        for(String x:inputs){
            System.out.print(" "+(++i)+" to "+x);
            //Check if the choice displayed is not the last
            if(i>=1&&i<=num-2)
                System.out.print(",");
            //Check if the last choice or not
            if(i==num-1)
                System.out.print(" and");
        }
        System.out.println(" program).");
    }
}
