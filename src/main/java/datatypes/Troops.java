package datatypes;

public class Troops {
    int infantry;
    int artillery;
    int tank;
    int antiaircraft;
    int fighter;
    int bomber;
    public Troops(int _infantry, int _artillery, int _tank, int _antiaircraft, int _fighter, int _bomber) {
        infantry = _infantry;
        artillery = _artillery;
        tank = _tank;
        antiaircraft = _antiaircraft;
        fighter = _fighter;
        bomber = _bomber;
    }

    public void addInfantry(int n) {
        infantry+=n;
    }
}
