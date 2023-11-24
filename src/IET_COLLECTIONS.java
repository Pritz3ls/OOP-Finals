import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IET_COLLECTIONS{
    static Boolean isAdmin = false;
    static String GLOBAL_USERNAME = "admin", GLOBAL_PASSWORD = "admin";
    static ArrayList<IET_Entry> _entryAM = new ArrayList<IET_Entry>();
    static ArrayList<IET_Entry> _entryPM = new ArrayList<IET_Entry>();
    public static ArrayList<IET_Entry> _entryTEMP = new ArrayList<IET_Entry>();
    
    // Testing Purposes
    static ArrayList<IET_Person> students = new ArrayList<IET_Person>();

    public static void Add(int indx, String srcode){
        LocalDateTime curDATE = LocalDateTime.now();
        DateTimeFormatter formatDATE = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String DATE = curDATE.format(formatDATE);
        if(VerifySRCODE(srcode)){
            if(indx == 1){
                _entryAM.add(new IET_Entry(srcode, DATE));
            }else if(indx == 2){
                _entryPM.add(new IET_Entry(srcode, DATE));
            }
        }else{
            System.out.println("Tracked Unsuccessful");
        }
    }
    
    public static boolean VerifySRCODE(String srcode){
        boolean verification = false;
        for(int i = 0; i < students.size(); i++){
            if(srcode.equals(students.get(i).RetrieveSRCODE())){
                verification = true;
            }
        }
        return verification;
    }
    // Testing Purposes
    public static void InitStudents(){
        students.add(new IET_Person("Prince Guerrero", "2104", "22-32507"));
        students.add(new IET_Person("Marlou Espenada", "2104", "24-13120"));
        students.add(new IET_Person("Cherysmond Montana", "2105", "34-50321"));

        for(int i = 0; i < 3; i++){
            Add(1, students.get(i).RetrieveSRCODE());
        }
        for(int i = 0; i < 30; i++){
            Add(2, students.get(0).RetrieveSRCODE());
        }
    }

    public static void CollectListEntry(int indx){
        _entryTEMP.clear();
        if(indx == 1){
            _entryTEMP = _entryAM;
        }else if(indx == 2){
            _entryTEMP = _entryPM;
        }
        System.out.println(_entryTEMP.size());
    }
}