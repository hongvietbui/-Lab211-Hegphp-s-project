/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lenovo
 */
public class StudentManager {
    void createStudent(ArrayList<Student> list){
        String newId;
        String newStudentName;
        String newSemester;
        String newCourseName;
        
        String choice;
        //Loop until user want to return to main menu
        while(true){
        //Loop until user type 10 student
            for(int i=0;i<10;i++){
                System.out.println("Enter student "+(i+1)+":");
                //Enter student id that must be alphanumeric and can have white space in the middle
                newId = GetInput.getStringInput("Enter student id: ","^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
                //Enter student name that must be alphabetic and can have white space in the middle
                newStudentName = GetInput.getStudentNameInput(list,newId,"Enter new student name: ","^[a-zA-Z\\s]{1,}[a-zA-Z]$");
                //Enter semester that must be alphanumeric and can have white space in the middle
                newSemester = GetInput.getStringInput("Enter semester: ","^[a-zA-Z0-9\\s]*[a-zA-Z0-9]$");
                //Enter course name that must be alphanumeric and can have white space in the middle
                newCourseName = GetInput.getCourseNameInput("Enter course name: ","^[./+a-zA-Z0-9\\s]{1,}[.a-zA-Z0-9/+]$");
                if(!GetInput.checkDuplicateInfo(list, newId, newSemester, newCourseName)){
                    list.add(new Student(newId, newStudentName, newSemester, newCourseName));
                    System.out.println("Information added successfully!");
                }
                else{
                    System.out.println("Error: Duplicate information!");
                    i--;
                    System.out.println("Please enter again");
                }
            }
        //Check if user want to continue or not
            choice = GetInput.getContinueSelection("Do you want to continue (Y/N)?\n","[Y|N]","Y/N");
            //Check if the user want to exit
            if(choice.equals("N"))
                break;
        }
    }
    //find and Sort Student by Name
    void findSortStudentByName(ArrayList<Student> list){
        ArrayList<Student> foundedList = new ArrayList<>();
        //Check the database is empty or not
        if(list.isEmpty()){
            System.out.println("List Empty!");
            return;
        }
        //User enter keyword
        String keyword = GetInput.getStringInput("Enter student name: ", "[a-zA-Z ]*");
        //Access elements of ArrayList list from begin to end
        for(Student x:list){
            if(x.getStudentName().contains(keyword))
                foundedList.add(x);
        }
        //Sort list by name
        Collections.sort(foundedList, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return s1.getStudentName().compareTo(s2.getStudentName());
            }
        });
        //display student list
        Display display = new Display();
        display.displayStudentList(foundedList);
    }
    
    void updateDeleteStudentById(ArrayList<Student> list) {
        String newStudentName;
        String newSemester;
        String newCourseName;
        
        String checkContinue;
        
        Student student = new Student();
        //User input Student id
        String input = GetInput.getStringInput("Type Student Id: ", "^[a-zA-Z0-9\\s]{1,}[a-zA-Z0-9]$");
        student = findStudentByID(list, input);
        //Check if the id is not found
        if(student == null){
            System.out.println("Student id not found!");
            return;
        }
        //Check if user want to continue or not
        checkContinue = GetInput.getContinueSelection("Do you want to update (U) or delete (D) student: ", "[U|D]{1}", "U/D");
        //Check if user want to delete
        if(checkContinue.equals("D")){
        //Find student by ID
            //Access Student in ArrayList list from 1st to last
            list.remove(student);
            System.out.println("Delete Successfully!");
        }
        //Check if user want to update
        else{
            //Enter student name that must be alphabetic and can have white space in the middle
            newStudentName = GetInput.getStringInput("Enter new student name: ","^[a-zA-Z\\s]{1,}[a-zA-Z]$");
            //Enter semester that must be alphanumeric and can have white space in the middle
            newSemester = GetInput.getStringInput("Enter new semester: ","^[a-zA-Z0-9\\s]*[a-zA-Z0-9]$");
            //Enter course name that must be alphanumeric and can have white space in the middle
            newCourseName = GetInput.getCourseNameInput("Enter new course name: ","^[.a-zA-Z0-9\\s]{1,}[.a-zA-Z0-9]$");
            //Check if user making change or not
            if(!GetInput.checkDuplicateInfo(list, input, newSemester, newCourseName)){
                list.get(list.indexOf(student)).setStudentName(newStudentName);
                list.get(list.indexOf(student)).setSemester(newSemester);
                list.get(list.indexOf(student)).setCourseName(newCourseName);
                System.out.println("Update success");
            }
            else{
                System.out.println("Nothing changed!");
            }
        }
    }

    private Student findStudentByID(ArrayList<Student> list, String input) {
        ArrayList<Student> newList = new ArrayList<Student>();
        System.out.printf("%-15s | %-15s | %-15s |%-7s\n", "Number", "Student name","Semester","Course name");
        //Access every element from 1st to last
        for(Student x:list){
            //Check if student ID contains input or not
            if(x.getId().contains(input)){
                newList.add(x);
                System.out.printf("%-15d | %-15s | %-15s |%-7s\n", newList.indexOf(x)+1, newList.get(newList.size()-1).getStudentName(),
                        newList.get(newList.size()-1).getSemester(),newList.get(newList.size()-1).getCourseName());
            }
        }
        //If the list is empty
        if(newList.isEmpty())
            return null;
        //User choice the int number in range of 1st to the last value
        int choice = GetInput.getInt("Enter number:",1, newList.size());
        return newList.get(choice-1);
    }
    
    public void report(ArrayList<Student> list){
        //Check if the list is empty or not
        if(list.isEmpty()){
            System.out.println("List empty!");
            return;
        }
        ArrayList<Report> newList = new ArrayList<>();
        ArrayList<Student> sortedList = list;
        Collections.sort(sortedList, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                int result = s1.getId().compareTo(s2.getId());
                //Check if the result is 0 or not
                if(result!=0)
                    return result;
                else
                    return s1.getCourseName().compareTo(s2.getCourseName());
            }
        });
        int total = 1;
        //Access every elements from 1st to the second last
        for(int i=0;i<sortedList.size()-1;i++){
            //Check if the next elements has the same id or not
            if(sortedList.get(i).getId().equalsIgnoreCase(sortedList.get(i+1).getId())){
                //Check if the next elements has the same Course or not
                if(sortedList.get(i).getCourseName().equalsIgnoreCase(sortedList.get(i+1).getCourseName()))
                    total++;
                else{
                    newList.add(new Report(sortedList.get(i).getStudentName(),sortedList.get(i).getCourseName(),total));
                    total = 1;
                }
            }
            else{
                newList.add(new Report(sortedList.get(i).getStudentName(),sortedList.get(i).getCourseName(),total));
                total = 1;
            }
        }
        //Add the last person
        if(total!=1)
            newList.add(new Report(sortedList.get(sortedList.size()-1).getStudentName()
                    ,sortedList.get(sortedList.size()-1).getCourseName(),total));
        else
            newList.add(new Report(sortedList.get(sortedList.size()-1).getStudentName()
                    ,sortedList.get(sortedList.size()-1).getCourseName(),1));
        //Display report
        Display display = new Display();
        display.displayReport(newList);
    }
}
