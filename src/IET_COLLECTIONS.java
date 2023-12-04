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

    public static String RecordEntry(int indx, String srcode){
        String details = "";
        LocalDateTime curDATE = LocalDateTime.now();
        DateTimeFormatter formatDATE = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String DATE = curDATE.format(formatDATE);
        if(VerifySRCODE(srcode)){
            if(indx == 1){
                details = RetrieveInfo(srcode);
                _entryAM.add(new IET_Entry(srcode, DATE));
            }else if(indx == 2){
                details = RetrieveInfo(srcode);
                _entryPM.add(new IET_Entry(srcode, DATE));
            }
        }
        return details;
    }
    public static void DeleteRecord(){
        _entryTEMP.removeAll(_entryTEMP);
        if(entry_INDEX == 1){
            _entryAM.removeAll(_entryAM);
        }else{
            _entryPM.removeAll(_entryPM);
        }
    }
    public static void DeleteAllRecord(){
        _entryTEMP.removeAll(_entryTEMP);
        _entryAM.removeAll(_entryAM);
        _entryPM.removeAll(_entryPM);
    }
    public static void SaveFile(){
        LocalDate localdate = LocalDate.now();
        String FILENAME = "data//entry//";
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
    public static String RetrieveInfo(String srcode){
        return READ_INFO("data//info//" + srcode + ".txt");
    }
    public static boolean VerifySRCODE(String srcode){
        return CHECK_INFO_EXISTS(srcode);
    }
}