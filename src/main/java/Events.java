import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Events extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User u = event.getAuthor();
        if (u.isBot()) return;

        Message msg = event.getMessage();
        String[] split = msg.getContentRaw().split("( +)");
        String key = split[0];

        if (key.startsWith(Bot.getPrefix()) && Bot.commands.containsKey(key)) {
            try { Bot.commands.get(key).execute(event, split);
            } catch (Exception e) {
                event.getChannel().sendMessage("An error occurred: "+e.toString()).queue();
            }
        }
    }

}
