

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Panneau extends JPanel {


    private int[] positionTortue1 = new int[]{0, 0};
    private int[] positionTortue2 = new int[]{0, 0};
    private int[] positionTortue3 = new int[]{0, 0};
    private int[] positionTortue4 = new int[]{0, 0};
    private int angleTortue1;
    private int angleTortue2;
    private int angleTortue3;
    private int angleTortue4;
    private List<Image> cartes = new ArrayList<>();
    private List<Image> murs = new ArrayList<>();
    private int joueurQuiJoue;
    private String instruction = "";
    private int menu = 0;
    private int finJeu = 0;
    private List<Integer[]> coordoneesMurs = new ArrayList<>();
    private List<Blocks> blocksSurPlateau = new ArrayList<>();


    void setPositionTortue1(int[] positionTortue1) {
        this.positionTortue1 = positionTortue1;
    }

    void setPositionTortue2(int[] positionTortue2) {
        this.positionTortue2 = positionTortue2;
    }

    void setPositionTortue3(int[] positionTortue3) {
        this.positionTortue3 = positionTortue3;
    }

    void setPositionTortue4(int[] positionTortue4) {
        this.positionTortue4 = positionTortue4;
    }

    void setAngleTortue1(int angleTortue1) {
        this.angleTortue1 = angleTortue1;
    }

    void setAngleTortue2(int angleTortue2) {
        this.angleTortue2 = angleTortue2;
    }

    void setAngleTortue3(int angleTortue3) {
        this.angleTortue3 = angleTortue3;
    }

    void setAngleTortue4(int angleTortue4) {
        this.angleTortue4 = angleTortue4;
    }

    void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    void afficherCartes(Player player) throws IOException {
        this.cartes = new ArrayList<>();
        for (int i = 0; i < player.getHand().size(); i++) {
            String name = player.getHand().get(i).getName();
            switch (name) {
                case "Blue Card":

                    this.cartes.add(ImageIO.read(new File("images/cards/BlueCard.png")));
                    break;
                case "Purple Card":
                    this.cartes.add(ImageIO.read(new File("images/cards/PurpleCard.png")));
                    break;
                case "Yellow Card":
                    this.cartes.add(ImageIO.read(new File("images/cards/YellowCard.png")));
                    break;
                case "Laser Card":
                    this.cartes.add(ImageIO.read(new File("images/cards/LaserCard.png")));
                    break;
            }
        }
        repaint();
    }

    void afficherMurs(Player player) throws IOException {
        this.murs = new ArrayList<>();
        for (int i = 0; i < player.getBlocksInHand().size(); i++) {
            String name = player.getBlocksInHand().get(i).getName();
            if (name.equals("Stone Block")) {
                this.murs.add(ImageIO.read(new File("images/WALL.png")));
            } else if (name.equals("Ice Block")) {
                this.murs.add(ImageIO.read(new File("images/ICE.png")));
            }
        }
        repaint();


    }

    void setJoueurQuiJoue(int joueurQuiJoue) {
        this.joueurQuiJoue = joueurQuiJoue;
    }

    public void paintComponent(Graphics g) {
        try {
            this.removeAll();
            Font font = new Font("Arial", Font.BOLD, 20);
            g.setFont(font);
            g.setColor(Color.white);
            Image img = ImageIO.read(new File("images/Background.jpeg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            if (menu != 0) {
                Image completerProgramme = ImageIO.read(new File("images/bouton_score.png"));
                g.drawImage(completerProgramme, this.getWidth() - 214, 50, 128, 128, this);
                g.drawString("Compléter le programme", this.getWidth() - 270, 218);

                Image poserMur = ImageIO.read(new File("images/WALL.png"));
                g.drawImage(poserMur, this.getWidth() - 214, 280, 128, 128, this);
                g.drawString("Poser un mur", this.getWidth() - 220, 448);

                Image executerProgramme = ImageIO.read(new File("images/bouton_play.png"));
                g.drawImage(executerProgramme, this.getWidth() - 214, 500, 128, 128, this);
                g.drawString("Exécuter le programme", this.getWidth() - 270, 668);

                Font font1 = new Font("Arial", Font.BOLD, 50);
                g.setFont(font1);
                g.drawString("Valider", 785, this.getHeight() - 115);
                g.setFont(font);

                Image Wall = ImageIO.read(new File("images/WALL.png"));
                Image Ice = ImageIO.read(new File("images/ICE.png"));
                Image plateau = ImageIO.read(new File("images/plateau.jpg"));
                g.drawImage(plateau, 0, 0, this.getWidth() - 300, this.getHeight() - 300, this);
                for (int i = 0; i < this.cartes.size(); i++) {
                    g.drawImage(this.cartes.get(i), 150 * i, this.getHeight() - 200, 150, 200, this);
                }
                for (int i = 0; i < this.murs.size(); i++) {
                    g.drawImage(this.murs.get(i), 300 + 77 * i, this.getHeight() - 290, 60, 60, this);
                }

                for (int i = 0; i < blocksSurPlateau.size(); i++) {
                    if (blocksSurPlateau.get(i) instanceof StoneBlock) {
                        g.drawImage(Wall, 24 + coordoneesMurs.get(i)[1] * 81, 26 + coordoneesMurs.get(i)[0] * 78, 77, 77, this);
                    } else if (blocksSurPlateau.get(i) instanceof IceBlock) {
                        g.drawImage(Ice, 24 + coordoneesMurs.get(i)[1] * 81, 26 + coordoneesMurs.get(i)[0] * 78, 77, 77, this);
                    }
                }

                Image joyau = ImageIO.read(new File("images/RUBY.png"));

                BufferedImage tortue1 = ImageIO.read(new File("images/turtle1.jpg"));
                BufferedImage tortue2 = ImageIO.read(new File("images/turtle2.jpg"));
                BufferedImage tortue3 = ImageIO.read(new File("images/turtle3.jpg"));
                BufferedImage tortue4 = ImageIO.read(new File("images/turtle4.jpg"));


                double rotationRequired1 = Math.toRadians(angleTortue1);
                double locationX1 = (float) tortue1.getWidth() / 2;
                double locationY1 = (float) tortue1.getHeight() / 2;
                AffineTransform tx1 = AffineTransform.getRotateInstance(rotationRequired1, locationX1, locationY1);
                AffineTransformOp op1 = new AffineTransformOp(tx1, AffineTransformOp.TYPE_BILINEAR);

                double rotationRequired2 = Math.toRadians(angleTortue2);
                double locationX2 = (float) tortue1.getWidth() / 2;
                double locationY2 = (float) tortue1.getHeight() / 2;
                AffineTransform tx2 = AffineTransform.getRotateInstance(rotationRequired2, locationX2, locationY2);
                AffineTransformOp op2 = new AffineTransformOp(tx2, AffineTransformOp.TYPE_BILINEAR);

                double rotationRequired3 = Math.toRadians(angleTortue3);
                double locationX3 = (float) tortue1.getWidth() / 2;
                double locationY3 = (float) tortue1.getHeight() / 2;
                AffineTransform tx3 = AffineTransform.getRotateInstance(rotationRequired3, locationX3, locationY3);
                AffineTransformOp op3 = new AffineTransformOp(tx3, AffineTransformOp.TYPE_BILINEAR);

                double rotationRequired4 = Math.toRadians(angleTortue4);
                double locationX4 = (float) tortue1.getWidth() / 2;
                double locationY4 = (float) tortue1.getHeight() / 2;
                AffineTransform tx4 = AffineTransform.getRotateInstance(rotationRequired4, locationX4, locationY4);
                AffineTransformOp op4 = new AffineTransformOp(tx4, AffineTransformOp.TYPE_BILINEAR);
                // Drawing the rotated image at the required drawing locations

                if (this.menu == 2) {
                    g.drawImage(joyau, 267, 573, 78, 78, this);
                    g.drawImage(op1.filter(tortue1, null), positionTortue1[0], positionTortue1[1], 77, 77, this);
                    g.drawImage(op2.filter(tortue2, null), positionTortue2[0], positionTortue2[1], 77, 77, this);
                    for (int i = 0; i < 8; i++) {
                        g.drawImage(Wall, 593, 24 + i * 78, 77, 77, this);
                    }


                } else if (this.menu == 3) {
                    g.drawImage(joyau, 24, 573, 78, 78, this);
                    g.drawImage(joyau, 267, 573, 78, 78, this);
                    drawImage(g, joyau, tortue1, tortue2, tortue3, op1, op2, op3);
                    for (int i = 0; i < 8; i++) {
                        g.drawImage(Wall, 593, 24 + i * 78, 77, 77, this);
                    }

                } else if (this.menu == 4) {
                    g.drawImage(joyau, 105, 573, 78, 78, this);
                    drawImage(g, joyau, tortue1, tortue2, tortue3, op1, op2, op3);
                    g.drawImage(op4.filter(tortue4, null), positionTortue4[0], positionTortue4[1], 77, 77, this);

                }


       /*     g.drawImage(this.cartes.get(0), 0, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(1), 150, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(2), 300, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(3), 450, this.getHeight() - 230, 150, 200, this);
            g.drawImage(this.cartes.get(4), 600, this.getHeight() - 230, 150, 200, this);*/

                g.drawString("C'est le tour du joueur " + joueurQuiJoue, 10, this.getHeight() - 280);
                g.setColor(Color.green);
                g.drawString(instruction, 10, this.getHeight() - 210);


            } else {
                Font font1 = new Font("Arial", Font.BOLD, 100);
                Font font4 = new Font("Arial", Font.BOLD, 50);
                g.setFont(font4);
                g.setColor(Color.white);
                g.drawString("Choisissez le nombre de joueurs :", 50, this.getHeight() / 4);
                g.setFont(font1);
                g.drawString("2", this.getWidth() / 4, this.getHeight() / 2);
                g.drawString("3", this.getWidth() / 2, this.getHeight() / 2);
                g.drawString("4", 3 * this.getWidth() / 4, this.getHeight() / 2);
            }
            if (finJeu != 0) {
                Font font2 = new Font("Arial", Font.BOLD, 250);
                g.setFont(font2);
                g.setColor(Color.red);
                g.drawString("Victoire", 50, this.getHeight() / 2);
                Font font3 = new Font("Arial", Font.BOLD, 100);
                g.setFont(font3);
                g.setColor(Color.green);
                g.drawString("le joueur " + finJeu + " a gagné!", 50, 3 * this.getHeight() / 4);
            }


            this.updateUI();
            this.setVisible(true);
            this.repaint();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void drawImage(Graphics g, Image joyau, BufferedImage tortue1, BufferedImage tortue2, BufferedImage tortue3, AffineTransformOp op1, AffineTransformOp op2, AffineTransformOp op3) {
        g.drawImage(joyau, 511, 573, 78, 78, this);
        g.drawImage(op1.filter(tortue1, null), positionTortue1[0], positionTortue1[1], 77, 77, this);
        g.drawImage(op2.filter(tortue2, null), positionTortue2[0], positionTortue2[1], 77, 77, this);
        g.drawImage(op3.filter(tortue3, null), positionTortue3[0], positionTortue3[1], 77, 77, this);
    }

    void setMenu(int menu) {
        this.menu = menu;
    }

    void setFinJeu(int finJeu) {
        this.finJeu = finJeu;
    }

    void addCoordoneesMurs(Integer[] coordoneesMurs) {
        this.coordoneesMurs.add(coordoneesMurs);

    }

    void addBlocksSurPlateau(Blocks blocksSurPlateau) {
        this.blocksSurPlateau.add(blocksSurPlateau);
    }

    void removeBlocksSurPlateau(int indice) {
        this.blocksSurPlateau.remove(indice);
    }

    void supprimerBlock(Integer[] coor) {
        coordoneesMurs.removeIf(I -> I[0].equals(coor[0]) && I[1].equals(coor[1]));
    }
}
