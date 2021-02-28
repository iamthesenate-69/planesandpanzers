import commands.*;
import datatypes.Commands;
import datatypes.API;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

public class Bot {
    static String prefix;
    public static HashMap<String, Commands> commands = new HashMap<String, Commands>();


    Bot(API bot, String _prefix) throws LoginException, IOException, ParseException {
        prefix = _prefix;
        new PaP();
        build(bot);
        AddCommands();
    }

    void AddCommands() throws IOException, ParseException {
        add(new Ping());
        add(new Map());
        add(new GetNearby());
        add(new Attack());
;    }

    void add(Commands c) {
        commands.put(prefix+c.name(), c);
    }

    void build(API api) throws LoginException {
        JDABuilder.create(api.getToken(), EnumSet.allOf(GatewayIntent.class))
                .addEventListeners(new Events())
                .setStatus(api.getOnlineStatus())
                .setActivity(api.getActivity())
                .build();
    }

    static String getPrefix() {
        return prefix;
    }

}