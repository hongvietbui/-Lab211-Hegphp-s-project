/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docmanager;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedHashMap;
/**
 *
 * @author Lenovo
 */
public class DoctorHash {
    //addDoctor
    boolean addDoctor(Doctor doctor) throws Exception{
        Validate check = new Validate();
        HashMap<String, Doctor> docMap = database();
        try{
            if(docMap.isEmpty())    //Database not exist
                throw new Exception("Database does not exist");
            // Data is not exist
            if(doctor.getCode().equals("")||doctor.getName().equals("")
                    ||doctor.getSpecialization().equals("")||doctor.getAvailability()==-1)
                throw new Exception("Data does not exist");
            if(docMap.containsKey(doctor.getCode()))  //Duplicate Code
               throw new Exception("Doctor code "+doctor.getCode()+" is duplicate");
            docMap.put(doctor.getCode(), doctor);
            System.out.println("Doctor added");
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //updateDoctor
    boolean updateDoctor(Doctor doctor) throws Exception{
        HashMap<String, Doctor> docMap = database();
        try{
            if(docMap.isEmpty())    //Database not exist
                throw new Exception("Database does not exist");
            // Data is not exist
            if(doctor.getCode().equals("")||doctor.getName().equals("")
                    ||doctor.getSpecialization().equals("")||doctor.getAvailability()==-1)
                throw new Exception("Data does not exist");
            if(!docMap.containsKey(doctor.getCode()))  //Doctor code not exist
                throw new Exception("Doctor code doesn't exit");
            docMap.put(doctor.getCode(), doctor);
            System.out.println("Doctor fixed");
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //deleteDoctor
    boolean deleteDoctor(Doctor doctor) throws Exception{
        HashMap<String, Doctor> docMap = database();
        try{
            //check valid data
            if(docMap.isEmpty())    //Database not exist
                throw new Exception("Database does not exist");
            if(doctor.getCode().equals("")) //Doctor code not exist
               throw new Exception("Doctor code doesn't exist");
            if(!docMap.containsKey(doctor.getCode()))   //Data doesn't exist
                throw new Exception("Data doesn't exist");
            //delete the doctor in4
            docMap.remove(doctor.getCode().toUpperCase());
            return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //searchDoctor
    HashMap<String,Doctor> searchDoctor(String input) throws Exception{
        HashMap<String, Doctor> newList = new HashMap();
        Display result = new Display();
        for(Doctor x:database().values()){   //for each elements of database() HashMap with N Doctor Elements
        //if x contains input sequence
            if(x.getCode().contains(input)||x.getName().contains(input)
                    ||x.getSpecialization().contains(input)||Integer.toString(x.getAvailability()).contains(input))
                newList.put(x.getCode(), x);
        }
        try{
            if(newList.isEmpty())   //Database not exist
                throw new Exception("Database does not exist");
            result.searchResult(newList);
            return newList;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    //database
    private HashMap<String,Doctor> docMap = new HashMap();
    HashMap<String,Doctor> database(){
        docMap.put("DOC 3", new Doctor("DOC 3", "Lien", "orthodontic", 1));
        docMap.put("DOC 2", new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        docMap.put("DOC 1", new Doctor("DOC 1", "Nghia", "Orthopedics", 3));
        return docMap;
    }
}
