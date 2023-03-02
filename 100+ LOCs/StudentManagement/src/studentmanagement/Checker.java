/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import org.omg.IOP.CodecPackage.FormatMismatch;

/**
 *
 * @author Lenovo
 */
public class Checker {
    //Check user choice
    static int inputPosIntNumberWithRange(int min, int max){
        Display display = new Display();
        Scanner sc = new Scanner(System.in);
        String input;
        int choice;
        //Loop until user choose exit
        while(true){
            try{
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
                display.menu("","Create","Find and Sort","Update/Delete","Report","Exit");
            }catch(NumberFormatException FormatError){
                System.out.println("Error: You have to type an integer!");
                display.menu("","Create","Find and Sort","Update/Delete","Report","Exit");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                display.menu("","Create","Find and Sort","Update/Delete","Report","Exit");
            }
        }
    }
    
    static int inputPosIntNumberWithRange(String msg,int min, int max){
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
    static String checkStringInput(String msg, String regex){
        Scanner sc = new Scanner(System.in);
        String input;
        //Loop until user typed valid value
        while(true){
            System.out.print(msg);
            try{
                input=sc.nextLine();
                if(input.equals(""))
                    throw new NullPointerException();
                if(!input.matches(regex))
                    throw new Exception("Error: the input is not in valid format!");
                return input;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You must type something!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //check course name
    static String checkNewCourseName(String msg, String regex){
        boolean flag = false;
        String input;
        String[] courses = {".Net","Java","C/C++"};
        //Loop until user typed valid input
        while(true){
            input = checkStringInput(msg, regex);
            try{
                //Access all value in courses list
                for(String x:courses){
                    //Check if the value of input equal the course or not
                    if(x.equals(input))
                        flag = true;
                }
                //Check if the course is in the database or not
                if(flag==false)
                    throw new Exception("Error: the course you typed is not in database!");
                return input;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //check Continue
    static String checkContinue(String msg, String regex, String errorMsg){
        String input;
        Scanner sc = new Scanner(System.in);
        //Loop until user typed valid number
        while(true){
            try{
                System.out.print(msg);
                input = sc.nextLine();
                //Check the input is null value
                if(input.equals(""))
                    throw new NullPointerException();
                //Check the input is valid format or not
                if(!input.matches(regex))
                    throw new FormatMismatch();
                return input;
            }catch(NullPointerException NullValue){
                System.out.println("Error: You have to type "+errorMsg+"!");
            }catch(FormatMismatch FormatError){
                System.out.println("Error: You must type "+errorMsg + "!");
            }
        }
    }
    //checkExist
    static boolean checkExist(ArrayList<Student> list, String id, String studentName, String semester, String courseName){
        //access every elements from begin to end
        for(Student x:list){
            //Check if all 4 infomation give is all duplicate or not
            if(x.getId().equalsIgnoreCase(id)&&
                x.getStudentName().equalsIgnoreCase(studentName)&&
                x.getCourseName().equalsIgnoreCase(courseName)&&
                x.getSemester().equalsIgnoreCase(semester))
                return true;
        }
        return false;
    }
    
    static boolean checkExist(ArrayList<Student> list, String id){
        //access every elements from begin to end
        for(Student x:list){
            //Check if all 4 infomation give is all duplicate or not
            if(x.getId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
}
