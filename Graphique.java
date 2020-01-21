import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class Graphique extends JFrame {
    private JButton CompleterProgramme = new JButton();
    private JButton ExecuterProgramme = new JButton();
    private JButton PoserMur = new JButton();
    private JButton boutonCarte1 = new JButton();
    private JButton boutonCarte2 = new JButton();
    private JButton boutonCarte3 = new JButton();
    private JButton boutonCarte4 = new JButton();
    private JButton boutonCarte5 = new JButton();
    private JButton boutonMur1 = new JButton();
    private JButton boutonMur2 = new JButton();
    private JButton boutonMur3 = new JButton();
    private JButton boutonMur4 = new JButton();
    private JButton boutonMur5 = new JButton();
    private JButton boutonValider = new JButton();
    private JButton nothing = new JButton();
    private JButton bouton2 = new JButton();
    private JButton bouton3 = new JButton();
    private JButton bouton4 = new JButton();
    private Panneau Panneau = new Panneau();
    private Menu Menu = new Menu();
    private int choixJeu = 0;
    private int choixCarte = 5;
    private int choixMur = 5;
    private Thread t;
    private boolean finChoix = false;
    private String Instruction = "";
    private int menu = 0;
    private List<JButton> listeBoutons = new ArrayList<JButton>() ;
    private int[] positionMur = new int[2];
    private List<Integer[]> coordoneesMurs = new ArrayList<>() ;
    private List<Blocks> blocksSurPlateau = new ArrayList<Blocks>();


    public void BougerTortue(Player player) {
        if (player.getColor().equals("blue")) {
            Panneau.setPositionTortue1(player.getPositionFrame());
            Panneau.setAngleTortue1(player.getAngle());
        } else if (player.getColor().equals("red")) {
            Panneau.setPositionTortue2(player.getPositionFrame());
            Panneau.setAngleTortue2(player.getAngle());
        } else if (player.getColor().equals("green")) {
            Panneau.setPositionTortue3(player.getPositionFrame());
            Panneau.setAngleTortue3(player.getAngle());
        } else if (player.getColor().equals("pink")) {
            Panneau.setPositionTortue4(player.getPositionFrame());
            Panneau.setAngleTortue4(player.getAngle());
        }
    }


    public void afficherCartes(Player player) throws IOException {
        Panneau.afficherCartes(player);
    }

    public void afficherMurs(Player player) throws IOException {
        Panneau.afficherMurs(player);
    }



    public void afficherCurrentPlayer(Player player) {
        Panneau.setJoueurQuiJoue(player.getPassageOrder());
    }

    public void afficherInstructions(String instruction) {
        Panneau.setInstruction(instruction);

    }

    public void positionnerMur(){
        for (int i = 0; i < listeBoutons.size();i++){
            int finalI = i;
            listeBoutons.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    positionMur[1] = finalI / 8;
                    positionMur[0] = finalI % 8;


                }
            });
        }

    }

    public void essai() {

        CompleterProgramme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                choixJeu = 1;

            }
        });

        PoserMur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                choixJeu = 2;

            }
        });

        ExecuterProgramme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                choixJeu = 3;

            }
        });
    }

//    public void Valider() {
//        boutonValider.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                if (choixJeu == 1) {
//                    finChoix = true;
//
//                }
//            }
//        });
//    }

    public void cliquerCartes() {
        boutonCarte1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    choixCarte = 0;
                }
            }
        });

        boutonCarte2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    choixCarte = 1;
                }
            }
        });
        boutonCarte3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    choixCarte = 2;
                }
            }
        });
        boutonCarte4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    choixCarte = 3;
                }
            }
        });
        boutonCarte5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    choixCarte = 4;
                }
            }
        });
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1) {
                    finChoix = true;
                }
            }
        });


    }

    public void cliquerMurs(){
        boutonMur1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 2) {
                   choixMur = 0;
                }
            }
        });

        boutonMur2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 2) {
                    choixMur = 1;
                }
            }
        });
        boutonMur3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 2) {
                    choixMur = 2;
                }
            }
        });
        boutonMur4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 2) {
                    choixMur = 3;
                }
            }
        });
        boutonMur5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 2) {
                    choixMur = 4;
                }
            }
        });

    }

    public void choixMenu() {
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changerMenu(2);

            }
        });
        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changerMenu(3);

            }
        });
        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                changerMenu(4);

            }
        });


    }

    public  void finJeu(int joueurGagnant){
        Panneau.setFinJeu(joueurGagnant);
    }

    public void changerMenu(int nombreJoueur) {
        if (nombreJoueur == 2){
            this.menu = 2;
            Panneau.setMenu(2);
        } else if (nombreJoueur == 3){
            this.menu = 3;
            Panneau.setMenu(3);
        } else if (nombreJoueur == 4){
            this.menu = 4;
            Panneau.setMenu(4);
        }

        this.remove(bouton2);
        this.remove(bouton3);
        this.remove(bouton4);
        this.repaint();
        this.add(boutonCarte1);
        this.add(boutonCarte2);
        this.add(boutonCarte3);
        this.add(boutonCarte4);
        this.add(boutonCarte5);
        this.add(boutonMur1);
        this.add(boutonMur2);
        this.add(boutonMur3);
        this.add(boutonMur4);
        this.add(boutonMur5);
        this.add(CompleterProgramme);
        this.add(boutonValider);
        this.add(ExecuterProgramme);
        this.add(PoserMur);
        for (int i = 0; i < listeBoutons.size();i++){
            this.add(listeBoutons.get(i));
        }
        this.add(nothing);
    }


    public Graphique() {

        this.setTitle("Robot Turtles");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
        Panneau.setInstruction(Instruction);
        if (menu == 0) {
            this.add(bouton2);
            this.add(bouton3);
            this.add(bouton4);
        }





        boutonCarte1.setBounds(0, this.getHeight() - 230, 150, 200);
        boutonCarte1.setOpaque(false);
        boutonCarte1.setContentAreaFilled(false);
        boutonCarte1.setBorderPainted(false);

        boutonCarte2.setBounds(150, this.getHeight() - 230, 150, 200);
        boutonCarte2.setOpaque(false);
        boutonCarte2.setContentAreaFilled(false);
        boutonCarte2.setBorderPainted(false);

        boutonCarte3.setBounds(300, this.getHeight() - 230, 150, 200);
        boutonCarte3.setOpaque(false);
        boutonCarte3.setContentAreaFilled(false);
        boutonCarte3.setBorderPainted(false);

        boutonCarte4.setBounds(450, this.getHeight() - 230, 150, 200);
        boutonCarte4.setOpaque(false);
        boutonCarte4.setContentAreaFilled(false);
        boutonCarte4.setBorderPainted(false);

        boutonCarte5.setBounds(600, this.getHeight() - 230, 150, 200);
        boutonCarte5.setOpaque(false);
        boutonCarte5.setContentAreaFilled(false);
        boutonCarte5.setBorderPainted(false);

        boutonMur1.setBounds(300, this.getHeight() - 320, 60, 60);
        boutonMur1.setOpaque(false);
        boutonMur1.setContentAreaFilled(false);
        boutonMur1.setBorderPainted(false);

        boutonMur2.setBounds(377, this.getHeight() - 320, 60, 60);
        boutonMur2.setOpaque(false);
        boutonMur2.setContentAreaFilled(false);
        boutonMur2.setBorderPainted(false);

        boutonMur3.setBounds(454, this.getHeight() - 320, 60, 60);
        boutonMur3.setOpaque(false);
        boutonMur3.setContentAreaFilled(false);
        boutonMur3.setBorderPainted(false);

        boutonMur4.setBounds(531, this.getHeight() - 320, 60, 60);
        boutonMur4.setOpaque(false);
        boutonMur4.setContentAreaFilled(false);
        boutonMur4.setBorderPainted(false);

        boutonMur5.setBounds(608, this.getHeight() - 320, 60, 60);
        boutonMur5.setOpaque(false);
        boutonMur5.setContentAreaFilled(false);
        boutonMur5.setBorderPainted(false);



        CompleterProgramme.setBounds(this.getWidth() - 214, 50, 128, 128);
        CompleterProgramme.setOpaque(false);
        CompleterProgramme.setContentAreaFilled(false);
        CompleterProgramme.setBorderPainted(false);

        PoserMur.setBounds(this.getWidth() - 214, 280, 128, 128);
        PoserMur.setOpaque(false);
        PoserMur.setContentAreaFilled(false);
        PoserMur.setBorderPainted(false);

        ExecuterProgramme.setBounds(this.getWidth() - 214, 500, 128, 128);
        ExecuterProgramme.setOpaque(false);
        ExecuterProgramme.setContentAreaFilled(false);
        ExecuterProgramme.setBorderPainted(false);

        boutonValider.setBounds(785, this.getHeight() - 185, 200, 50);
        boutonValider.setOpaque(false);
        boutonValider.setContentAreaFilled(false);
        boutonValider.setBorderPainted(false);

        bouton2.setBounds(this.getWidth()/4, this.getHeight()/2 - 100 , 50, 100);
        bouton2.setOpaque(false);
        bouton2.setContentAreaFilled(false);
        bouton2.setBorderPainted(false);


        nothing.setOpaque(false);
        nothing.setContentAreaFilled(false);
        nothing.setBorderPainted(false);

        bouton3.setBounds(this.getWidth()/2, this.getHeight()/2 - 100 , 50, 100);
        bouton3.setOpaque(false);
        bouton3.setContentAreaFilled(false);
        bouton3.setBorderPainted(false);

        bouton4.setBounds(3*this.getWidth()/4, this.getHeight()/2 - 100 , 50, 100);
        bouton4.setOpaque(false);
        bouton4.setContentAreaFilled(false);
        bouton4.setBorderPainted(false);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                JButton boutonTableau = new JButton();
                boutonTableau.setBounds(26 + i*81,24 + j*79,77,77);
                boutonTableau.setOpaque(false);
                boutonTableau.setContentAreaFilled(false);
                boutonTableau.setBorderPainted(false);
                listeBoutons.add(boutonTableau);
            }
        }




        this.setResizable(false);
        this.getContentPane().add(Panneau);
        Panneau.repaint();
        this.repaint();
        this.setVisible(true);



    }


    public int getChoixJeu() {
        return choixJeu;
    }

    public void setChoixJeu(int choixJeu) {
        this.choixJeu = choixJeu;
    }

    public int getChoixCarte() {
        return choixCarte;
    }

    public void setChoixCarte(int choixCarte) {
        this.choixCarte = choixCarte;
    }

    public void setFinChoix(boolean finChoix) {
        this.finChoix = finChoix;
    }

    public boolean isFinChoix() {
        return finChoix;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }

    public void setCompleterProgramme(boolean bool) {
        CompleterProgramme.setVisible(bool);
    }

    public void setExecuterProgramme(boolean bool) {
        ExecuterProgramme.setVisible(bool);
    }

    public void setPoserMur(boolean bool) {
        PoserMur.setVisible(bool);
    }

    public int getMenu() {
        return menu;
    }

    public int getChoixMur() {
        return choixMur;
    }

    public int[] getPositionMur() {
        return positionMur;
    }

    public void setPositionMur(int[] positionMur) {
        this.positionMur = positionMur;
    }

    public void addCoordoneesMurs(Integer[] coordoneesMurs) {
        this.coordoneesMurs.add(coordoneesMurs);
        Panneau.addCoordoneesMurs(coordoneesMurs);

    }

    public void addBlocksSurPlateau(Blocks blocksSurPlateau) {
        this.blocksSurPlateau.add(blocksSurPlateau);
        Panneau.addBlocksSurPlateau(blocksSurPlateau);
    }

    public List<Integer[]> getCoordoneesMurs() {
        return coordoneesMurs;
    }

    public List<Blocks> getBlocksSurPlateau() {
        return blocksSurPlateau;
    }

    public void setChoixMur(int choixMur) {
        this.choixMur = choixMur;
    }

    public void supprimerBloc(Integer[] coor){
        int i = -2;
        Iterator<Integer[]> iterator = coordoneesMurs.iterator();
        System.out.println("kira");
        while (iterator.hasNext()){
            i++;
            Integer[] I = iterator.next();
            System.out.println("dio");
            if (I[0] == coor[0] && I[1] == coor[1]){
                System.out.println("jojo");
                iterator.remove();
            }
        }
        System.out.println(i);
        blocksSurPlateau.remove(i);
        Panneau.removeBlocksSurPlateau(i);
        Panneau.supprimerBlock(coor);

    }

    /*public class BoutonListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            t = new Thread(new PlayAnimation());
            t.start();

        }
    }*/

    /*class PlayAnimation implements Runnable{
        public void run() {
            essai();

        }
    }*/

}

