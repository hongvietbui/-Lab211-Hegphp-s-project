/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docmanager;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validate check = new Validate();
        DoctorHash manage = new DoctorHash();
        int choice;
        while(true){//loop until valid
            //Display the menu
            Display menu = new Display();
            menu.GUI("Add Doctor","Update Doctor","Delete Doctor","Search Doctor","Exit");
            choice = check.inputChoice();
            switch(choice){
            //Add doctor
            case 1:
                try{
                    manage.addDoctor(menu.addDoctorGUI());
                }catch(Exception ex){
                    ex.getMessage();
                }
                break;
            //Update doctor
            case 2:
                try{
                    manage.updateDoctor(menu.updateDoctorGUI());
                }catch(Exception ex){
                    ex.getMessage();
                }
                break;
            //Delete doctor
            case 3:
                try{
                    manage.deleteDoctor(menu.deleteDoctorGUI());
                }catch(Exception ex){
                    ex.getMessage();
                }
                break;
            //Search doctor
            case 4:
                try{
                    manage.searchDoctor(menu.searchDoctorGUI());
                }catch(Exception ex){
                    ex.getMessage();
                }
                break;
            //Exit
            case 5:
                System.exit(0);
                break;
            }
        }
    }
    
}
