import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
    public void paintComponent(Graphics g) {
        Image img = null;
        try {
            img = ImageIO.read(new File("images/Background.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        Font font = new Font("Arial", Font.BOLD, 100);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("1",this.getWidth()/4,this.getHeight()/2);
    }
}
