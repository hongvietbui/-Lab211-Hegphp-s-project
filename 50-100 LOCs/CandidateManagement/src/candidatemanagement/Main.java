/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidatemanagement;

import CandidateTypes.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        ArrayList<Candidate> candidateList = new ArrayList();
        CandidateManagement manage = new CandidateManagement();
        int option;
        String candidateName;
        int candidateType;
        ArrayList<Candidate> searchedList = new ArrayList();
        while(true){
            //Display main screen
            display.displayMainScreen();
            //User input an option
            option = GetData.getUserOption(1,5);
            //run function depends on user's choice
            switch(option){
                //Option 1: create Experience
                case 1:
                    manage.createExperience(candidateList);
                    break;
                //Option 2: Create Fresher
                case 2:
                    manage.createFresher(candidateList);
                    break;
                //Option 3: create Internship
                case 3:
                    manage.createInternship(candidateList);
                    break;
                //Option 4: searching
                case 4:
                    //Display all candidate
                    display.displayAllCandidate(candidateList);
                    //User input Candidate Name (regex: acccept value is alphabet character and cannot be null)
                    candidateName = GetData.getStringInput("Input Candidate name (First name or Last name):","[a-zA-Z]{1,}");
                    //User input type of candidate
                    candidateType = GetData.getInt("Input type of candidate:",0,3);
                    //search candidate
                    searchedList = GetData.getCandidateSearchedList(candidateList,candidateName,candidateType);
                    //Display list candidate searched
                    display.displayCandidateSearchedList(searchedList);
                //option 5: Exit
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}