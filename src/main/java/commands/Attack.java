package commands;

import datatypes.Army;
import datatypes.Commands;
import datatypes.Connections;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Attack extends Commands {

    @Override
    public String name() {
        return "buy";
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) throws IOException {
        File f = new File(".\\temp\\temp.png");
        BufferedImage img = ImageIO.read(f);
        File f2 = new File(".\\temp\\soldier.png");
        BufferedImage img2 = ImageIO.read(f2);

        Connections c = PaP.connections.get(args[1]);
        PaP.getTroopsInCountry(args[0]).UK.addInfantry(1);

        Graphics g = img.getGraphics();
        g.drawImage(img2, c.getX(), c.getY(), null);

        ImageIO.write(img, "png", new File(".\\temp\\temp.png"));
    }

}
