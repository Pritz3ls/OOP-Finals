import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IET_COLLECTIONS{
    static Boolean isAdmin = false;
    static ArrayList<String> _entryAM = new ArrayList<String>();
    static ArrayList<String> _entryPM = new ArrayList<String>();
    
    // Testing Purposes
    static ArrayList<IET_Person> students = new ArrayList<IET_Person>();
    
    public void Add(int indx, String srcode){
        LocalDateTime curDATE = LocalDateTime.now();
        DateTimeFormatter formatDATE = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String DATE = curDATE.format(formatDATE);
        if(VerifySRCODE(srcode)){
            if(indx == 1){
                _entryAM.add(DATE + " SRCODE: " +srcode);
            }else if(indx == 2){
                _entryPM.add(DATE + " SRCODE: " +srcode);
            }
            System.out.println("Tracked Successful");
        }else{
            System.out.println("Tracked Unsuccessful");
        }
    }
    
    public boolean VerifySRCODE(String srcode){
        boolean verification = false;
        for(int i = 0; i < students.size(); i++){
            if(srcode.equals(students.get(i).RetrieveSRCODE())){
                verification = true;
            }
        }
        return verification;
    }
    // Testing Purposes
    public void InitStudents(){
        students.add(new IET_Person("Prince Guerrero", "2104", "22-32507"));
        students.add(new IET_Person("Marlou Espenada", "2104", "24-13120"));
        students.add(new IET_Person("Cherysmond Montana", "2105", "34-50321"));
    }
    public void Display(int indx){
        ArrayList<String> _entryTEMP = new ArrayList<String>();
        if(indx == 1){_entryTEMP = _entryAM;}else{_entryTEMP = _entryPM;}
        for (int i = 0; i < _entryTEMP.size(); i++){
            System.out.println(_entryTEMP.get(i));
        } 
    }
}