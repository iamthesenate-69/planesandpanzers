package commands;

import datatypes.Commands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map extends Commands {

    @Override
    public String name() {
        return "map";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        File f = new File(".\\temp\\temp.png");
        event.getChannel().sendFile(f, "map.png").queue();
    }
}
