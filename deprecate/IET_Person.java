/* Deprecated Code, Do not use
 * Will use text files as alternative for saving
*/
// import java.util.ArrayList;

// public class IET_Person extends IET_VIOLATIONCODE{
//     private String _SECTION;
//     private String _FULLNAME;
//     private String _SRCODE;
//     private static ArrayList<Integer> _VIOLATIONS = new ArrayList<Integer>();
    
//     public IET_Person(String name, String section, String srcode){
//         _SECTION = section;
//         _FULLNAME = name;
//         _SRCODE = srcode;
//     }
    
//     public String GetSRCode(){
//         return _SRCODE;
//     }
//     public String GetName(){
//         return _FULLNAME;
//     }
//     public String GetSection(){
//         return _SECTION;
//     }

//     public void RecordViolation(int code){
//         _VIOLATIONS.add(code);
//     }
//     public void RetrieveInfo(){
//         System.out.println("NAME: " + _FULLNAME);
//         System.out.println("SECTION: " + _SECTION);
//         System.out.println("SRCODE: " + _SRCODE);
        
//         CheckHistory();
//     }
//     public void CheckHistory(){
//         if(_VIOLATIONS.size() < 0){System.out.println("-NO RECORDS-"); return;}
//         System.out.println("RECORDS: ");
//         for(int i = 0; i < _VIOLATIONS.size(); i++){
//             System.out.print(_VIOLATIONS.get(i) + " - " + CheckCode(_VIOLATIONS.get(i)));
//         }
//     }
// }