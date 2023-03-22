/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidatemanagement;

import CandidateTypes.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Lenovo
 */
class CandidateManagement {

    Candidate getCandidateInput(ArrayList<Candidate> candidateList,int candidateType) {
        //Accept String that has characters and id
        String id = GetData.getIdInput("Type id: ","[a-zA-Z0-9]{1,}",candidateList);
        String firstName = GetData.getStringInput("Type first name: ", "[a-zA-Z ]+");
        //Accept String that its characters are alphabetic and 
        String lastName = GetData.getStringInput("Type last name: ", "[a-zA-Z ]+");
        int birthDate = GetData.getInt("Type birth date: ", 1923,Calendar.getInstance().get(Calendar.YEAR));
        String address = GetData.getStringInput("Type address: ");
        //Accepet a digit sequence that has at least 10 character
        String phone = GetData.getStringInput("Type phone: ","[\\d]{10,}");
        //Accept value in format <accountName>@<domain>.<topleveldomain>
        String email = GetData.getStringInput("Type email: ","[a-zA-Z0-9]{1,}@[a-zA-Z]{1,}[.a-zA-Z]+[^.]$");
        return new Candidate(id, firstName, lastName, birthDate, address, phone, email, candidateType);
    }

    void createNewExperience(ArrayList<Candidate> candidateList) {
        Candidate newCandidate = getCandidateInput(candidateList,0);
        Experience newExperience = new Experience(newCandidate.getId(), newCandidate.getFirstName(), newCandidate.getLastName(),
                newCandidate.getBirthDate(), newCandidate.getAddress(), newCandidate.getPhone(), newCandidate.getEmail(), newCandidate.getCandidateType());
        newExperience.setExpInYear(GetData.getInt("Type ExpInYear: ", 0, 100));
        newExperience.setProSkill(GetData.getStringInput("Type ProSkill: "));
        candidateList.add(newExperience);
        System.out.println("Added successfully!");
    }

    void createNewFresher(ArrayList<Candidate> candidateList) {
        Candidate newCandidate = getCandidateInput(candidateList,1);
        Fresher newFresher = new Fresher(newCandidate.getId(), newCandidate.getFirstName(), newCandidate.getLastName(),
                newCandidate.getBirthDate(), newCandidate.getAddress(), newCandidate.getPhone(), newCandidate.getEmail(), newCandidate.getCandidateType());
        newFresher.setGraduation_date(GetData.getInt("Type Graduation Date: ", 1900, Calendar.getInstance().get(Calendar.YEAR)));
        newFresher.setGraduation_rank(GetData.getGraduationRankInput("Type Graduation Rank:"));
        candidateList.add(newFresher);
        System.out.println("Added successfully!");
    }

    void createNewInternship(ArrayList<Candidate> candidateList) {
        Candidate newCandidate = getCandidateInput(candidateList,2);
        Internship newIntern = new Internship(newCandidate.getId(), newCandidate.getFirstName(), newCandidate.getLastName(),
                newCandidate.getBirthDate(), newCandidate.getAddress(), newCandidate.getPhone(), newCandidate.getEmail(), newCandidate.getCandidateType());
        newIntern.setMajors(GetData.getStringInput("Type Major: "));
        newIntern.setSemester(GetData.getStringInput("Type Semester", "[a-zA-Z0-9 ]+"));
        newIntern.setUniversityName(GetData.getStringInput("Type University Name: "));
        candidateList.add(newIntern);
        System.out.println("Added successfully!");
    }
}
