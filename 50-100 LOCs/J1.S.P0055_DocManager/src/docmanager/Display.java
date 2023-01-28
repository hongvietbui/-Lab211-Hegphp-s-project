/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docmanager;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
/**
 *
 * @author Lenovo
 */
public class Display {
    void GUI(String... inputs){
        System.out.println("========= Doctor Management ==========");
        for(String x: inputs){
            System.out.println("   ·   "+x);
        }
    }
    //Add Doctor
    Doctor addDoctorGUI(){
        Scanner sc = new Scanner(System.in);
        Doctor newDoctor = new Doctor();
        System.out.println("--------- Add Doctor ----------");
        System.out.print("Enter Code: ");
        newDoctor.setCode(sc.nextLine().toUpperCase());
        System.out.print("Enter Name: ");
        newDoctor.setName(sc.nextLine());
        System.out.print("Enter Specialization: ");
        newDoctor.setSpecialization(sc.nextLine());
        System.out.print("Enter Availability: ");
        try{
            newDoctor.setAvailability(Integer.parseInt(sc.nextLine()));
        }catch(NumberFormatException FormatError){
            newDoctor.setAvailability(-1);
        }
        return newDoctor;
    }
    //Update Doctor
    Doctor updateDoctorGUI(){
        Doctor newDoctor = new Doctor();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------- Update Doctor -------");
        System.out.print("Enter Code: ");
        newDoctor.setCode(sc.nextLine().toUpperCase());
        System.out.print("Enter Name: ");
        newDoctor.setName(sc.nextLine());
        System.out.print("Enter Specialization: ");
        newDoctor.setSpecialization(sc.nextLine());
        System.out.print("Enter Availability: ");
        try{
            newDoctor.setAvailability(Integer.parseInt(sc.nextLine()));
        }catch(NumberFormatException FormatError){
            newDoctor.setAvailability(-1);
        }
        return newDoctor;
    }
    //Delete Doctor
    Doctor deleteDoctorGUI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------- Delete Doctor -------");
            //Enter code
        System.out.print("Enter Code: ");
        String code = sc.nextLine().toUpperCase();
        return new Doctor(code,"","",0);
    }
    //Search Doctor
    String searchDoctorGUI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Search Doctor --------");
        System.out.print("Enter text: ");
        return sc.nextLine();
    }
    //Show Result
    void searchResult(HashMap<String,Doctor> results){
        TreeMap<String, Doctor> sortedDoctors = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return results.get(o1).getCode().compareTo(results.get(o2).getCode());
        }
        });
        sortedDoctors.putAll(results);
        System.out.println("--------- Result ------------");
        System.out.format("%-6s %-7s\t %-14s\t %-12s\n","Code","Name","Specialization","Availability");
        for(Doctor x:sortedDoctors.values()){
            System.out.format("%-6s %-7s\t %-14s\t %-12s\n",x.getCode(),x.getName(),x.getSpecialization(),x.getAvailability());
        }
    }
}
