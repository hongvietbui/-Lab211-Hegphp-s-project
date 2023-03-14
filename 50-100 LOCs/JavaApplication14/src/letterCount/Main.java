/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterCount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
    Map<Character,Integer> characterMap = new LinkedHashMap<>();
    char[] targetChars = {'w', 'd', 'e', 'r', 'o', 'l', 'h'};
    char[] characters = content.toCharArray();
    //Access every character in the string
    for(int i=0;i<characters.length;i++){
        char c = characters[i];
        //Check if the character is alphabetic or not
        if(!Character.isLetter(c))
            continue;
        //Check if the character is contained in the target characters array
        boolean isInTargetChars = false;
        for(char targetChar : targetChars){
            if(c == targetChar){
                isInTargetChars = true;
                break;
            }
        }
        if(isInTargetChars){
            //Check if the character is contained in the map or not
            if(characterMap.containsKey(c)){
                characterMap.put(c, characterMap.get(c)+1);
            } else {
                characterMap.put(c, 1);
            }
        }
    }
    System.out.print("{");
    //Display all characters and number of them in the specified order
    for(char c : targetChars){
        if(characterMap.containsKey(c)){
            int count = characterMap.get(c);
            System.out.print(c + "=" + count + ", ");
        }
    }
    System.out.println("}");
}
}
