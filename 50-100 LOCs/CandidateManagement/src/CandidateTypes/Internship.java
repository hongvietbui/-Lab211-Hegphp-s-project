/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CandidateTypes;

/**
 *
 * @author Lenovo
 */
public class Internship extends Candidate{
    String majors;
    String semester;
    String universityName;

    public Internship() {
    }

    public Internship(String majors, String semester, String universityName, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Internship(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        super(id, firstName, lastName, birthDate, address, phone, email, candidateType);
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    
}
