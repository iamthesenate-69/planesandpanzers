package commands;

import datatypes.Commands;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;

public class Move extends Commands {
    @Override
    public String name() {
        return "move";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) throws IOException {

    }
}
