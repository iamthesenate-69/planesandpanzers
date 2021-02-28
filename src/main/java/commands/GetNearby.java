package commands;

import datatypes.Army;
import datatypes.Commands;
import datatypes.Connections;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class GetNearby extends Commands {


    @Override
    public String name() {
        return "nearby";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) throws IOException {
        String name = args[1];
        int depth = Integer.parseInt(args[2]);

        event.getChannel().sendMessage(getConnections(name, depth)).queue();
    }

    String getConnections(String name, int depth) {
        ArrayList<String> s = new ArrayList<>();
        for (String sc : PaP.connections.get(name).getSeaConnections()) {
            if (depth == 0)
                s.add(sc);
            else
                s.add(getConnections(sc, depth-1));

        }
        for (String lc : PaP.connections.get(name).getLandConnections()) {
            if (depth == 0)
                s.add(lc);
            else
                s.add(getConnections(lc, depth-1));
        }

        return s.toString();
    }
}
