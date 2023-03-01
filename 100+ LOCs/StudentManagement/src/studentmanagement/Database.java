/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Database {
    ArrayList<Student> studentList(){
        ArrayList<Student> list = new ArrayList();
        list.add(new Student("h1", "Hong2", "Spring 2021", "Java"));
        list.add(new Student("h1", "Hong0", "Summer 2021", "Java"));
        list.add(new Student("h1", "Hong3", "Fall 2022", "Java"));
        list.add(new Student("h1", "Hong1", "Spring 2022", "Java"));
        return list;
    }
}

