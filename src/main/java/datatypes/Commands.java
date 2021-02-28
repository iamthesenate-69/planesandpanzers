package datatypes;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;

public abstract class Commands {
    public abstract String name();
    public abstract void execute(MessageReceivedEvent event, String[] args) throws IOException;
}
