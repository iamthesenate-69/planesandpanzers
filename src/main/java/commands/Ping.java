package commands;

import datatypes.Commands;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.time.temporal.ChronoUnit;

public class Ping extends Commands {

    @Override
    public String name() {
        return "ping";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getMessage().reply("Ping...").queue(m ->
                m.editMessage(String.format("Pong! %sms | Gateway: %sms", getPing(event.getMessage(), m), event.getJDA().getGatewayPing())).queue());
    }

    String getPing(Message m1, Message m2) {
        return m1.getTimeCreated().until(m2.getTimeCreated(), ChronoUnit.MILLIS)+"";
    }
}
