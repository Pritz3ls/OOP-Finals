import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class IET_COLLECTIONS extends IET_FileWrite{
    static Boolean isAdmin = false;
    static String GLOBAL_USERNAME = "admin", GLOBAL_PASSWORD = "admin";
    static ArrayList<IET_Entry> _entryAM = new ArrayList<IET_Entry>();
    static ArrayList<IET_Entry> _entryPM = new ArrayList<IET_Entry>();
    public static ArrayList<IET_Entry> _entryTEMP = new ArrayList<IET_Entry>();
    static int entry_INDEX = 1;
    
    // Testing Purposes
    static ArrayList<IET_Person> students = new ArrayList<IET_Person>();

    public static void RecordEntry(int indx, String srcode){
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
    public static void DeleteRecord(){
        _entryTEMP.removeAll(_entryTEMP);
        if(entry_INDEX == 1){
            _entryAM.removeAll(_entryAM);
        }else{
            _entryPM.removeAll(_entryPM);
        }
    }
    public static void SaveFile(){
        LocalDate localdate = LocalDate.now();
        String FILENAME = "data//";
        FILENAME += entry_INDEX == 1 ? "IET_AM_(" : "IET_PM_(";
        FILENAME += localdate.toString() + ")" + ".txt";

        ArrayList<String> _datas = new ArrayList<String>();
        for(int i = 0; i < _entryTEMP.size(); i++){
            _datas.add("SRCODE: " + _entryTEMP.get(i).GetSRCODE() + " - - - DATE & TIME: " + _entryTEMP.get(i).GETDATE());
        }
        FILE_OVERWRITE(FILENAME, _datas);
    }
    public static void CollectListEntry(int indx){
        entry_INDEX = indx;
        _entryTEMP.removeAll(_entryTEMP);
        if(entry_INDEX == 1){
            _entryTEMP.addAll(_entryAM);
        }else if(entry_INDEX == 2){
            _entryTEMP.addAll(_entryPM);
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

        // for(int i = 0; i < 3; i++){
        //     Add(1, students.get(i).RetrieveSRCODE());
        // }
    }
}