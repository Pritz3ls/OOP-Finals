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
        }else{
            System.out.println("Tracked Unsuccessful");
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
    public static String RetrieveInfo(String srcode){
        String detail = "";
        for(int i = 0; i < students.size(); i++){
            if(srcode.equals(students.get(i).GetSRCode())){
                detail += "FullName: " + students.get(i).GetName() + "\nSR-Code: " + students.get(i).GetSRCode() + "\nSection: "  + students.get(i).GetSection();
            }
        }
        return detail;
    }
    public static boolean VerifySRCODE(String srcode){
        boolean verification = false;
        for(int i = 0; i < students.size(); i++){
            if(srcode.equals(students.get(i).GetSRCode())){
                verification = true;
            }
        }
        return verification;
    }

    // Testing Purposes
    public static void InitStudents(){
        students.add(new IET_Person("Bayanin, Janna Kristine", "2104" ,"22-39975"));
        students.add(new IET_Person("Dimaculangan, Emmanuel", "2104", "22-34069"));
        students.add(new IET_Person("Guevarra, Keith Lawrenz", "2104", "22-39508"));
        students.add(new IET_Person("Zara, Andrea", "2104", "22-39365"));
        students.add(new IET_Person("Dela Pena, Barron Lester", "2104", "22-37117"));
        students.add(new IET_Person("Serrano, Rafael Miguel", "2104", "22-36209"));
        students.add(new IET_Person("Corteza, Shiela Marie", "2104", "22-36105"));
        students.add(new IET_Person("Manumbali, May Trixie", "2104", "22-38132"));
        students.add(new IET_Person("Patricio, Ryan Jeremy", "2104", "22-37726"));
        students.add(new IET_Person("Canaria, Kimberly", "2104", "22-31215"));
        students.add(new IET_Person("Latorre, Christine Joy", "2104", "21-06701"));
        students.add(new IET_Person("Zurbano, Jannie", "2104", "22-33672"));
        students.add(new IET_Person("Malco, Lealyn", "2104", "22-36631"));
        students.add(new IET_Person("Mendoza, Christince Grace", "2104", "22-38049"));
        students.add(new IET_Person("Bondoc, Klarence Jhay", "2104", "22-37638"));
        students.add(new IET_Person("Mulleda, Sophia Blanca", "2104", "22-39791"));
        students.add(new IET_Person("Chavez, Joshua Daniel", "2104", "22-36920"));
        students.add(new IET_Person("Villaneva, Allister", "2104", "23-34588"));
        students.add(new IET_Person("Laylo, Alliah Mae", "2104", "22-30460"));
        students.add(new IET_Person("Carandang, John Howard", "2104", "22-33441"));
        students.add(new IET_Person("Perez, Gyles", "2104", "22-30527"));
        students.add(new IET_Person("Zara, Ian Carlo", "2104", "22-34780"));
        students.add(new IET_Person("Villaneva, Ric Vincent", "2104", "22-35042"));
        students.add(new IET_Person("De Jesus, Maria Nina", "2104", "22-39582"));
        students.add(new IET_Person("Bansil, Albert", "2104", "22-37780"));
        students.add(new IET_Person("Caldito, Nikka Mae", "2104", "22-37907"));
        students.add(new IET_Person("Manalo, Princess Jhaymie", "2104", "22-35426"));
        students.add(new IET_Person("Ubalde, Jonathan Christian", "2104", "22-32252"));
        students.add(new IET_Person("Virtucio, Gerard Michael", "2104", "22-35606"));
        students.add(new IET_Person("Lipana, Genelle Nescy", "2104", "23-30249"));
        students.add(new IET_Person("Segundo, Sydney Johann", "2104", "22-39812"));
        students.add(new IET_Person("Sandig, Danielle Jean", "2104", "22-38946"));
        students.add(new IET_Person("Carandang, Honmebell", "2104", "22-30155"));
        students.add(new IET_Person("De Lara, Carlos Miguel", "2104", "22-34593"));
        students.add(new IET_Person("Guerrero, Prince Marco", "2104", "22-32507"));
        students.add(new IET_Person("Saludaga, Gilbert", "2104", "22-37092"));
        students.add(new IET_Person("Rosales, Matthew", "2104", "22-35004"));
        students.add(new IET_Person("Rigodon, Kim Shairine", "2104", "22-30213"));
        students.add(new IET_Person("Bisa, Eiman Raphael", "2104", "22-32662"));
        students.add(new IET_Person("Vicedo, Ruzel Andrei", "2104", "22-36755"));
        students.add(new IET_Person("Navarro, Francis Rafael", "2104", "22-38061"));
        students.add(new IET_Person("Contreras, Melvin", "2104", "22-31298"));
        students.add(new IET_Person("Galang, ABCD Cyril", "2104", "22-38739"));
        students.add(new IET_Person("Cuevas, Diannah Mae", "2104", "22-39209"));
        students.add(new IET_Person("Samontañez, Rence", "2104", "23-37043"));
    }
}