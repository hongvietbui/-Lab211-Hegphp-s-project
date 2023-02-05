/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement.Data;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class Database {
    //courseName
    String[] courseNameList(){
        String[] list = new String[3];
        list[0] = "Java";
        list[1] = "C++";
        list[2] = "Python";
        return list;
    }
    //database
    private ArrayList database(){
        ArrayList<Students> data = new ArrayList();
        data.add(new Students("HE171255","Nguyen Van B",2,"Java"));
        data.add(new Students("HE171254","Nguyen Van A",1,"Java"));
        data.add(new Students("HE171256","Nguyen Van C",3,"Java"));
        return data;
    }
    //getDatabase
    public ArrayList getDatabase(){
        return database();
    }
    
    public String[] getCourseNameList(){
        return courseNameList();
    } 
}
