/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;
import java.util.Scanner;
import java.util.ArrayList;
import studentmanagement.Data.*;
/**
 *
 * @author Lenovo
 */
public class Checker {
    //inputChoice
    int inputChoice(int min, int max){
        Scanner sc = new Scanner(System.in);
        int choice;
        String checkBlank;
        while(true){
            try{
                checkBlank = sc.nextLine();
                if(checkBlank.equals(""))   //If user typed nothing
                    throw new Exception("You must input an number!");
                else{
                    choice = Integer.parseInt(checkBlank);
                    if(choice<min||choice>max)  //If user not typed correct number (from min to max)
                        throw new Exception("Error: the number you typed must be in range of "+min+" to "+max+"!");
                    return choice;
                }
            }catch(NumberFormatException FormatError){  //Format Error
                System.out.println("Error: you must typed an integer number!");
            }catch(Exception ex){   //Other Exception
                System.out.println(ex.getMessage());
            }
        }
    }
    //Student input
    Students inputStudent(String id){
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        System.out.print("Type name: ");    
        String name = sc.nextLine();
        System.out.print("Type semester: ");
        int semester = check.checkSemesterInput();
        System.out.print("Type course name: ");
        String courseName = check.checkCourseName();
        return new Students(id,name, semester, courseName);
    }
    //Continue or not
    String continueCheck(){
        Scanner sc = new Scanner(System.in);
        String checker;
        while(true){    //Loop until valid
            try{
                checker = sc.nextLine().toUpperCase();
                if(!checker.matches("[YN]"))
                    throw new Exception("Error: Invalid input, please type Y/N");
                return checker;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //Duplicate Checker
    boolean duplicateCheck(ArrayList<Students> list, String id){
        for(int i=0;i<list.size();i++){
            if(id.equals(list.get(i).getId()))
                return true;
        }
        return false;
    }
    //check Semester Input
    int checkSemesterInput(){
        Scanner sc = new Scanner(System.in);
        int input;
        while(true){
            try{
                input = Integer.parseInt(sc.nextLine());
                if(input < 0)
                    throw new Exception("Error: Invalid number (must be >=0)");
                return input;
            }catch(NumberFormatException FormatError){  //Format Error
                System.out.println("Error: you must type an integer");
            }catch(Exception ex){   //other exception
                System.out.println(ex.getMessage());
            }
        }
    }
    //check courseName
    String checkCourseName(){
        Scanner sc = new Scanner(System.in);
        Database data = new Database();
        String[] inputs = data.getCourseNameList();
        String input;
        while(true){    //Loop until user typed valid course name
            input = sc.nextLine();
            //check course Name
            for(String x:inputs){
                if(x.equals(input))
                    return x;
            }
            System.out.println("Error: Valid course name!");
        }
    }
    //update Check
    String updateCheck(){
        Scanner sc = new Scanner(System.in);
        String checker;
        while(true){    //Loop until valid
            try{
                checker = sc.nextLine().toUpperCase();
                if(!checker.matches("[UD]"))
                    throw new Exception("Error: Invalid input, please type Y/N");
                return checker;
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //updateStudent
    void updateStudent(Students student){
        Scanner sc = new Scanner(System.in);
        System.out.print("Typed new Name: ");
        student.setName(sc.nextLine());
        System.out.print("Typed new Semester: ");
        student.setSemester(checkSemesterInput());
        System.out.print("Type new Course: ");
        student.setCourseName(checkCourseName());
    }
}
