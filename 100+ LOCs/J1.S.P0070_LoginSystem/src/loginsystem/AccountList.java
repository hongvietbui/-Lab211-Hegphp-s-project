/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsystem;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class AccountList {
   public ArrayList database(){
       ArrayList<Account> list = new ArrayList();
       list.add(new Account("0123456789", "12345678"));
       list.add(new Account("1712541234", "HE171254"));
       return list;
   }
}
