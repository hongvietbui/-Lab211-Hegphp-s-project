/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidatemanagement;

import CandidateTypes.Candidate;
import CandidateTypes.Experience;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
class CandidateManagement {

    Candidate getCandidateInput(ArrayList<Candidate> candidateList){
        System.out.println("Type new id: ");
        String id = GetData.getStringInput("Type id: ");
        String firstName = GetData.getStringInput("Type first name: ","[a-zA-Z]{1,}");
        String lastName = GetData.getStringInput("Type last name: ","[a-zA-Z]{1,}");
        int birthDate = GetData.getInt("Type birth date: ",1923,2008);
        String address = GetData.getStringInput("Type address: ");
        String phone = GetData.getStringInput("Type phone: ");
        String email = GetData.getStringInput("Type email: ");
        int candidateType = GetData.getInt("Type candidate type (0-2): ", 0, 2);
        return new Candidate(id, firstName, lastName, birthDate, address, phone, email, candidateType);
    }
    
    void createExperience(ArrayList<Candidate> candidateList) {
        Candidate newCandidate = getCandidateInput(candidateList);
        Experience newExperience = new Experience()
    }

    void createFresher(ArrayList<Candidate> candidateList) {
    }

    void createInternship(ArrayList<Candidate> candidateList) {
    }
    
}
