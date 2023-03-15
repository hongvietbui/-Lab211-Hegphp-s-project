/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
class TaskManager {

    void addTask(ArrayList<Task> list) {
        int lastTaskNumber;
        //Check if the task list is empty or not
        if(list.isEmpty())
            lastTaskNumber = 1;
        else
            lastTaskNumber = list.get(list.size()-1).getId()+1;
        System.out.println("------------Add Task---------------");
        String requirementName = Validate.checkStringInput("Requirement Name: ");
        String taskType = Validate.checkTaskTypeId("Task Type: ");
        String date = Validate.checkDate("Date: ");
        Double from, to;
        //Loop until user enter valid planFrom and planTo format
        while(true){
            from = Validate.checkDouble("From: ");
            to = Validate.checkDouble("To: ");
            //Check planFrom and plantTo is valid or not
            if(Validate.checkPlantFromTo(from,to))
                break;
        }
        String assignee = Validate.checkStringInput("Assignee: ");
        String reviewer = Validate.checkStringInput("Reviewer: ");
        list.add(new Task(lastTaskNumber, taskType, requirementName, date, from, to, assignee, reviewer));
        System.out.println("Added Successfully!");
    }

    void deleteTask() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void displayTask() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
