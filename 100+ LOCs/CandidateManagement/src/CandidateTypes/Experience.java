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
public class Experience extends Candidate{
    private int ExpInYear;
    private String ProSkill;
        
    public Experience(String id, String firstName, String lastName, int birthDate,
            String address, String phone, String email) {
        super(id, firstName, lastName, birthDate, address, phone, email, 0);
    }

    public Experience(int ExpInYear, String ProSkill, String id, String firstName,
            String lastName, int birthDate, String address, String phone, String email) {
        super(id, firstName, lastName, birthDate, address, phone, email, 0);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }
}
