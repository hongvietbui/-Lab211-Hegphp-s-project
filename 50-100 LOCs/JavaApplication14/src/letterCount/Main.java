/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterCount;

import java.util.HashMap;
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args){
        //Step 1: User input the content
        String content = checkUserStringInput("Enter your content:\n","[a-zA-Z ]*");
        //Step 2: Count the number of letters
        displayNumberOfWord(content);
        //Step 3: Count number of character
        displayNumberOfCharacter(content);
    }

    private static String checkUserStringInput(String msg, String regex) {
        String input;
        Scanner sc = new Scanner(System.in);
        //Loop until user enter valid number
        while(true){
            try{
                System.out.print(msg);
                input = sc.nextLine();
                //Check if user type nothing
                if(input.equals(""))
                    throw new NullPointerException();
                //Check if user type valid format or not
                if(!input.matches(regex))
                    throw new Exception("Error: the String you typed is invalid!");
                return input;
            }catch(NullPointerException nullValue){
                System.out.println("Error: You must type a String!");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void displayNumberOfWord(String content) {
        HashMap<String,Integer> wordMap = new HashMap();
        StringTokenizer newStringToken = new StringTokenizer(content);
        String temp;
        //Access every word in String
        while(newStringToken.hasMoreTokens()){
            temp = newStringToken.nextToken();
            //Check if the word is contained in the map or not
            if(wordMap.containsKey(temp)){
                wordMap.put(temp, wordMap.get(temp)+1);
            }
            else
                wordMap.put(temp, 1);
        }
        Object[] characterList = wordMap.keySet().toArray();
        Object[] numberList = wordMap.values().toArray();
        System.out.print("{");
        //Display all words and number of them in descending order
        for(int i=characterList.length-1;i>=0;i--){
            //Check if the element the the first or not
            if(i==characterList.length-1)
                System.out.print((String)characterList[i]+"="+(int)numberList[i]);
            //Check if the element is the last or not
            else if(i==characterList.length-1)
                System.out.print(", "+(String)characterList[i]+"="+(int)numberList[i]);
            else
                System.out.print(", "+(String)characterList[i]+"="+(int)numberList[i]);
        }
        System.out.println("}");
    }

    private static void displayNumberOfCharacter(String content) {
        Hashtable<Character, Integer> wordMap = new Hashtable();
        char[] characters = content.toCharArray();
        String temp;
        //Access every word in String
        for(int i=0;i<characters.length;i++){
            //check if the character is alphabetic or not
            if(!Character.isLetter(characters[i]))
                continue;
            //Check if the word is contained in the map or not
            if(wordMap.containsKey(characters[i])){
                wordMap.put(characters[i], wordMap.get(characters[i])+1);
            }
            else
                wordMap.put(characters[i], 1);
        }
        Object[] characterList = wordMap.keySet().toArray();
        Object[] numberList = wordMap.values().toArray();
        System.out.print("{");
        //Access every element of characterList from begin to end
        for(int i=0;i<characterList.length;i++){
            //Check if the element the the first or not
            if(i==0)
                System.out.print((char)characterList[i]+"="+(int)numberList[i]);
            //Check if the element is the last or not
            else if(i==characterList.length-1)
                System.out.print(", "+(char)characterList[i]+"="+(int)numberList[i]);
            else
                System.out.print(", "+(char)characterList[i]+"="+(int)numberList[i]);
        }
        System.out.println("}");
    }
}
