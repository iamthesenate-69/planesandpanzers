package commands;

import datatypes.Army;
import datatypes.Connections;
import datatypes.Troops;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PaP {
    public static HashMap<String, Connections> connections = new HashMap<String, Connections>();
    public static HashMap<String, Army> troops = new HashMap<String, Army>();

    public PaP() throws IOException, ParseException {
        JSONArray a = (JSONArray) new JSONParser().parse(new FileReader(".\\assets\\planes&panzers.json"));
        for (Object o : a)
            importNode((JSONObject) o);

        File f = new File(".\\assets\\map.png");
        BufferedImage img = ImageIO.read(f);
        ImageIO.write(img, "png", new File(".\\temp\\temp.png"));
    }

    void importNode(JSONObject node) {
        String name = node.get("name").toString();
        int x = Integer.parseInt(node.get("x").toString());
        int y = Integer.parseInt(node.get("y").toString());
        ArrayList<String> c_sea = toArrayList(node.get("c_sea"));
        ArrayList<String> c_land  = toArrayList(node.get("c_land"));
        connections.put(name, new Connections(c_sea, c_land, x, y));
    }
    ArrayList<String> toArrayList(Object o) {
        JSONArray jArray = (JSONArray) o;
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < jArray.size(); i++)
            list.add(jArray.get(i).toString());
        return list;
    }

    public static Army getTroopsInCountry(String s) {
        if (!troops.containsKey(s)) {
            troops.put(s, blankArmy());
        }
        return troops.get(s);
    }

    static Army blankArmy() {
        return new Army(blankTroops(),blankTroops(),blankTroops(),blankTroops(),blankTroops());
    }

    static Troops blankTroops() {
        return new Troops(0,0,0,0,0,0);
    }
}
