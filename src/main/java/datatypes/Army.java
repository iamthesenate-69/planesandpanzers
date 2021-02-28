package datatypes;

public class Army {
    public Troops UK;
    Troops US;
    Troops USSR;
    Troops Germany;
    Troops Japan;
    public Army(Troops _UK, Troops _US, Troops _USSR, Troops _Germany, Troops _Japan) {
        UK = _UK;
        US = _US;
        USSR = _USSR;
        Germany = _Germany;
        Japan = _Japan;
    }
}
