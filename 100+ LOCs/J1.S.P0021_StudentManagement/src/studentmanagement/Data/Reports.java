/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.Data;

/**
 *
 * @author Lenovo
 */
public class Reports {
    String name,course;
    int totalOfCourse;

    public Reports() {
    }

    public Reports(String name, String course, int totalOfCourse) {
        this.name = name;
        this.course = course;
        this.totalOfCourse = totalOfCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }
    
}
