import datatypes.API;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, LoginException, ParseException {
        API roosevelt  = new API("token here", Activity.streaming("Ju 87", "https://www.youtube.com/watch?v=yXLl4V78-iI"), OnlineStatus.DO_NOT_DISTURB);
        Bot b = new Bot(roosevelt, "=");
    }
}
