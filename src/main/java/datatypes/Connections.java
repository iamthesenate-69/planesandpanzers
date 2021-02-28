package datatypes;

import java.util.ArrayList;

public class Connections {
    ArrayList<String> c_sea;
    ArrayList<String> c_land;
    int x;
    int y;

    public Connections(ArrayList<String> _c_sea, ArrayList<String> _c_land, int _x, int _y) {
        c_sea = _c_sea;
        c_land = _c_land;
        x = _x;
        y = _y;
    }

    public ArrayList<String> getSeaConnections() {
        return c_sea;
    }

    public ArrayList<String> getLandConnections() {
        return c_land;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
