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

public class Panneau extends JPanel {


    private int[] positionTortue1;
    private int[] positionTortue2;
    private int[] positionTortue3;
    private int[] positionTortue4;
    private int angle = 270;
    private List<Image> cartes;
    private int joueurQuiJoue;




    public void setPositionTortue1(int[] positionTortue1) {
        this.positionTortue1 = positionTortue1;
    }

    public void setPositionTortue2(int[] positionTortue2) {
        this.positionTortue2 = positionTortue2;
    }

    public void setPositionTortue3(int[] positionTortue3) {
        this.positionTortue3 = positionTortue3;
    }

    public void setPositionTortue4(int[] positionTortue4) {
        this.positionTortue4 = positionTortue4;
    }

    public int getAngle() {
        return angle;
    }

    public void SetAngle(int i) {
        this.angle = i;
    }

    public void afficherCartes(Player player) throws IOException {
        this.cartes = new ArrayList<Image>();
        for (int i = 0; i < player.getHand().size();i++){
            String name = player.getHand().get(i).getName();
            if (name.equals("Blue Card")){

                this.cartes.add(ImageIO.read(new File("images/cards/BlueCard.png")));
            } else if (name.equals("Purple Card")){
                this.cartes.add(ImageIO.read(new File("images/cards/PurpleCard.png")));
            } else if (name.equals("Yellow Card")){
                this.cartes.add(ImageIO.read(new File("images/cards/YellowCard.png")));
            } else if (name.equals("Laser Card")){
                this.cartes.add(ImageIO.read(new File("images/cards/LaserCard.png")));
            }
        }
        repaint();
    }

    public void setJoueurQuiJoue(int joueurQuiJoue) {
        this.joueurQuiJoue = joueurQuiJoue;
    }

    public void paintComponent(Graphics g) {
        try {
            this.removeAll();
            Font font = new Font("Arial", Font.BOLD, 20);
            g.setFont(font);
            g.setColor(Color.white);
            Image img = ImageIO.read(new File("images/Background.jpeg"));
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
            Image completerProgramme = ImageIO.read(new File("images/bouton_score.png"));
            g.drawImage(completerProgramme,this.getWidth() - 214,50,128,128,this);
            g.drawString("Compléter le programme",this.getWidth() - 270,218);
            Image executerProgramme = ImageIO.read(new File("images/bouton_play.png"));
            g.drawImage(executerProgramme,this.getWidth() - 214,350,128,128,this);
            g.drawString("Exécuter le programme",this.getWidth() - 270,518);
            Font font1 = new Font("Arial", Font.BOLD, 50);
            g.setFont(font1);
            g.drawString("Valider",785,this.getHeight() - 115);
            g.setFont(font);



            Image plateau = ImageIO.read(new File("images/plateau.jpg"));
            g.drawImage(plateau, 0, 0, this.getWidth() - 300, this.getHeight() - 300, this);
            for (int i =0; i < this.cartes.size();i++){
                g.drawImage(this.cartes.get(i), 0 + 150*i, this.getHeight() - 230, 150, 200, this);
            }

       /*     g.drawImage(this.cartes.get(0), 0, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(1), 150, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(2), 300, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(3), 450, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(4), 600, this.getHeight() - 230, 150, 200, this);*/

            g.drawString("C'est le tour du joueur " + joueurQuiJoue,10,this.getHeight() - 240);

            BufferedImage tortue1 = ImageIO.read(new File("images/turtle1.jpg"));
            BufferedImage tortue2 = ImageIO.read(new File("images/turtle1.jpg"));
            BufferedImage tortue3 = ImageIO.read(new File("images/turtle1.jpg"));
            BufferedImage tortue4 = ImageIO.read(new File("images/turtle1.jpg"));

            double rotationRequired = Math.toRadians (angle);
            double locationX = tortue1.getWidth() / 2;
            double locationY = tortue1.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            // Drawing the rotated image at the required drawing locations
            g.drawImage(op.filter(tortue1, null), positionTortue1[0], positionTortue1[1], 70, 70, this);
            g.drawImage(op.filter(tortue1, null), positionTortue2[0], positionTortue2[1], 70, 70, this);
            g.drawImage(op.filter(tortue1, null), positionTortue3[0], positionTortue3[1], 70, 70, this);
            g.drawImage(op.filter(tortue1, null), positionTortue4[0], positionTortue4[1], 70, 70, this);

            this.updateUI();
            this.setVisible(true);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}