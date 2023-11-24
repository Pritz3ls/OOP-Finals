public class IET_Entry{
    String _srcode;
    String _datetime;

    public IET_Entry(String ISRCode, String IDateTime){
        this._srcode = ISRCode;
        this._datetime = IDateTime;
    }
    public String GetSRCODE(){
        return _srcode;
    }
    public String GETDATE(){
        return _datetime;
    }
}