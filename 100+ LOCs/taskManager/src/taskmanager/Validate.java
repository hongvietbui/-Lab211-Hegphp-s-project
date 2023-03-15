/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
class Validate {

    static int inputInt(String msg,int min, int max){
        Display display = new Display();
        Scanner sc = new Scanner(System.in);
        String input;
        int choice;
        //Loop until user choose exit
        while(true){
            try{
                System.out.print(msg);            
                //Check String empty
                input=sc.nextLine();
                if(input.equals(""))
                    throw new NullPointerException();
            //Check Format error
                choice = Integer.parseInt(input);
            //Check if the number is in the range or not
                if(choice<min||choice>max)
                    throw new Exception("The number you typed must be in range of "+min+" to "+max+"!");
                return choice;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You have to type a number!");
            }catch(NumberFormatException FormatError){
                System.out.println("Error: You have to type an integer!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //Check String input
    static String checkStringInput(String msg){
        Scanner sc = new Scanner(System.in);
        String input;
        //Loop until user typed valid value
        while(true){
            System.out.print(msg);
            try{
                input=sc.nextLine();
                if(input.equals(""))
                    throw new NullPointerException();
                return input;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You must type something!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    static String checkTaskTypeId(String msg) {
        int taskType = inputInt(msg, 1, 4);
        switch(taskType){
            //Option 1: Code
            case 1:
                return "Code";
            //Option 2: Test
            case 2:
                return "Test";
            //Option 3: Design
            case 3:
                return "Design";
            //Option 4: Review
            case 4:
                return "Review";
        }
        return null;
    }

    static String checkDate(String date_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Double checkDouble(String msg) {
        String input;
        Double output;
        Scanner sc = new Scanner(System.in);
        //Loop until user input valid number
        while(true){
            try{
                System.out.print(msg);
                input = sc.nextLine();
                //Check if input is empty
                if(input.equals(""))
                    throw new NullPointerException();
                output = Double.parseDouble(input);
                return output;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You must type a number!");
            }catch(NumberFormatException FormatError){
                System.out.println("Error: You must type a number!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    static boolean checkPlantFromTo(String from, String to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static boolean checkPlantFromTo(Double from, Double to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
