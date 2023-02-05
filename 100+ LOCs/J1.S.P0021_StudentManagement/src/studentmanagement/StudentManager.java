/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import studentmanagement.Data.*;
/**
 *
 * @author Lenovo
 */
public class StudentManager {
    //Create
    void create(ArrayList<Students> list){
        Scanner sc = new Scanner(System.in);
        Checker check = new Checker();
        int i = 0;
        //Condition Y/N(>=10)
        String cont;
        //Student inputs
        String id,name,courseName;
        int semester;
        while(true){    //Type 10 student
            System.out.println("Type " +(++i)+" Student:");
            System.out.print("Type id: ");
            id=sc.nextLine();
            if(check.duplicateCheck(list,id)){   //Duplicated code
                System.out.println("Duplicated code, please type again!");
                i--;
                continue;
            }
            list.add(check.inputStudent(id));
            if(i>=10){   //If number of student typed >= 10
                System.out.println("Do you want to continue (Y/N)?");
                cont = check.continueCheck();
                if(cont.toUpperCase().equals("Y"))
                    i=0;
                else
                    break;
            }
        }
    }
    //Find and Sort
    void findSort(ArrayList<Students> list){
        //Check empty
        if(list.isEmpty()){
            System.out.println("List empty!");
            return;
        }
        ArrayList<Students> founded = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Inputs name:");
        String name = sc.nextLine();
        //Find
        int longestNameLength=0;
        //Find name and longest name length
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().contains(name)){
                if(longestNameLength<list.get(i).getName().length())
                    longestNameLength = list.get(i).getName().length();
                founded.add(list.get(i));
            }
        }
        //Check
        if(founded.isEmpty()||name.equals("")){
            System.out.println("Not Found!");
            return;
        }
        //Sort
        Collections.sort(founded, new Comparator<Students>(){
            @Override
            public int compare(Students s1,Students s2){
                return s1.getName().compareTo(s2.getName());
            }
        });
        //Display
        Display display = new Display();
        display.displayFounded(founded,longestNameLength);
    }
    //Update/Delete
    void updateDelete(ArrayList<Students> list){
        //check empty
        if(list.isEmpty()){
            System.out.println("List empty!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Type id: ");
        String id = sc.nextLine();
        Students founded = null;
        //Find student
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                founded = list.get(i);
                break;
            }
        }
        //If not found
        if(founded == null){
            System.out.println("Not found!");
            return;
        }
        //Show question
        System.out.println("Do you want to update (U) or delete (D) student");
        Checker check = new Checker();
        String cont = check.updateCheck();
        //Update
        if(cont.equals("U")){
            check.updateStudent(founded);
        }
        //Delete
        else{
            list.remove(founded);
        }
    }
    //Report
    void report(ArrayList<Students> list){
        //check empty
        if(list.isEmpty()){
            System.out.println("List empty!");
            return;
        }
        ArrayList<Reports> report = new ArrayList<>();
        //sort list
        ArrayList<Students> sortedList = (ArrayList)list.stream()
                                            .sorted(Comparator.comparing(Students::getName))
                                            .collect(Collectors.toList());
        //Make a report
        int courseNumber = 1;
        //n-1 persons
        for(int i=0;i<sortedList.size()-1;i++){
            //Add person by names
            if(sortedList.get(i).getName().equals(sortedList.get(i+1).getName()))
                ++courseNumber;
            else{
                report.add(new Reports(sortedList.get(i).getName(),sortedList.get(i).getCourseName(), courseNumber));
                courseNumber = 1;
            }
        }
        //Add the last person
        if(courseNumber!=1)
            report.add(new Reports(sortedList.get(sortedList.size()-1).getName()
                    ,sortedList.get(sortedList.size()-1).getCourseName(),courseNumber));
        else
            report.add(new Reports(sortedList.get(sortedList.size()-1).getName()
                    ,sortedList.get(sortedList.size()-1).getCourseName(),1));
        //Display report
        Display display = new Display();
        display.displayReport(report);
    }
}
