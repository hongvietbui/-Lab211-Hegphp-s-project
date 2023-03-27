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
class Display {

    void displayMainScreen() {
        System.out.println("         CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("          1. Experience");
        System.out.println("          2. Fresher");
        System.out.println("          3. Internship");
        System.out.println("          4. Searching");
        System.out.println("          5. Exit\n");
        System.out.println("(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate,"
                + " 3 to Internship Candidate,\n4 to Searching and 5 to Exit program).");
    }

    void displayAllCandidate(ArrayList<Candidate> candidateList) {
        displayAllExperience(candidateList);
        displayAllFresher(candidateList);
        displayAllIntern(candidateList);
    }

    void displayCandidateSearchedList(ArrayList<Candidate> searchedList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void displayAllExperience(ArrayList<Candidate> candidateList) {
        for(int i=0;i<candidateList.size();i++){
            
        }
    }

    private void displayAllFresher(ArrayList<Candidate> candidateList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void displayAllIntern(ArrayList<Candidate> candidateList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
