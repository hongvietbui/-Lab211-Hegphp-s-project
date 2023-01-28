/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsystem;
import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Lenovo
 */
public class Validate {
    //check input
    int inputChoice(String msg,int min,int max){
        System.out.print(msg+" ");
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){    //Run until valid
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice<min||choice>max)
                    throw new Exception("Error: the number must be in range of "+min+" to "+max+"!");
                return choice;
            }catch(NumberFormatException FormatError){
                System.out.println("Error: You must type an integer number");
            }catch(Exception ex){   //other excpetion
                System.out.println(ex.getMessage());
            }
        }
    }
    //input account number
    String inputAccountNumber(String msg,Locale locate){
        ResourceBundle resource = ResourceBundle.getBundle(locate.getLanguage(),locate);
        System.out.print(resource.getString("accountNumber"));
        Scanner sc = new Scanner(System.in);
        String accountNum;
        while(true){    //Loop until valid
            try{
                accountNum = sc.nextLine();
                if(!accountNum.matches("[0-9]{10}"))    //10 character each character 0-9
                    throw new Exception(resource.getString("accountNumberError"));
                return accountNum;
            }catch(Exception ex){   //Exception
                System.out.println(ex.getMessage());
            }
        }
    }
    //Check account number
    boolean checkAccountNumber(String accountNumber){
        AccountList accountList = new AccountList();
        ArrayList<Account> arrayList = accountList.database();
        for(int i=0;i<arrayList.size();i++){    //find accountNumber
            if(accountNumber.equals(arrayList.get(i).getAccountNumber()))   //if accountNumber exist
                return true;
        }
        return false;
    }
    //input password
    String inputPassword(Locale locate){
        ResourceBundle resource = ResourceBundle.getBundle(locate.getLanguage(),locate);
        System.out.print(resource.getString("password"));
        Scanner sc = new Scanner(System.in);
        String accountNum;
        while(true){    //Loop until valid
            try{
                accountNum = sc.nextLine();
                if(!accountNum.matches("[a-zA-Z0-9]{8,31}"))    //8-31 character, alphanumeric
                    throw new Exception(resource.getString("passwordError"));
                return accountNum;
            }catch(Exception ex){   //Exception
                System.out.println(ex.getMessage());
            }
        }
    }
    //check password
    boolean checkPassword(String accountNumber,String password){
        AccountList accountList = new AccountList();
        ArrayList<Account> arrayList = accountList.database();
        if(checkAccountNumber(accountNumber)){
            for(int i=0;i<arrayList.size();i++){
                if(accountNumber.equals(arrayList.get(i).getAccountNumber())&&password.equals(arrayList.get(i).getPassword()))   //if accountNumber exist
                    return true;
            }
        }
        return false;
    }
    //generate Captcha
    String generateCaptcha(){
        Random rd = new Random();
        String captcha = "";
        String character="ABCDEFGHIKLMNOPQRSTUVWXYZ0123456789";
        for(int i=0;i<5;i++){   //Create a captcha of 5 random character
            captcha += character.charAt(rd.nextInt(character.length()));
        }
        return captcha;
    }
    //check captcha
    boolean checkCaptcha(String captchaGenerate,Locale locate){
        ResourceBundle resource = ResourceBundle.getBundle(locate.getLanguage(),locate);
        Scanner sc = new Scanner(System.in);
        System.out.println(resource.getString("generateCaptcha")+captchaGenerate);
        System.out.print(resource.getString("checkCaptcha"));
        String captcha = sc.nextLine();
        if(captcha.equals(captchaGenerate)){ //neu captcha dung
            return true;
        }
        else{
            System.out.println(resource.getString("captchaError"));
            return false;
        }
    }
}
