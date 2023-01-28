/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsystem;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @author Lenovo
 */
public class Menu {
    //GUI
    void GUI(String... inputs){
        System.out.println("-------Login Program-------");
        int i=0;
        for(String x:inputs){   //Show all inputs as choices
            System.out.println(++i+". "+x);
        }
    }
    //login system
    void setLocate(Locale locate){
        Validate check = new Validate();
        ResourceBundle resource = ResourceBundle.getBundle(locate.getLanguage(),locate);
        //Require to input an account number :
        String accNum = check.inputAccountNumber(resource.getString("accountNumber"),locate);
        //Input a password: 
        String pass = check.inputPassword(locate);
        //Require to input one character or multiple characters in the captcha:
        String generateCaptcha = check.generateCaptcha();
        if(!check.checkCaptcha(generateCaptcha,locate))
            return;
        if(!check.checkPassword(accNum,pass))
            System.out.println(resource.getString("loginError"));
        else
            System.out.println(resource.getString("loginSuccess"));
    }
}