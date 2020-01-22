

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Graphique extends JFrame {
    private JButton CompleterProgramme = new JButton();
    private JButton ExecuterProgramme = new JButton();
    private JButton PoserMur = new JButton();
    private int compteurCartesCliquees = 0;
    private List<JButton> boutonCartes = new ArrayList<>();
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
    private int choixJeu = 0;
    private int choixCarte = 5;
    private int choixMur = 5;
    private boolean finChoix = false;
    private int menu = 0;
    private List<JButton> listeBoutons = new ArrayList<>();
    private int[] positionMur = new int[2];
    private List<Integer[]> coordoneesMurs = new ArrayList<>();
    private int nombreColonnes;


    void BougerTortue(Player player) {
        switch (player.getColor()) {
            case "blue":
                Panneau.setPositionTortue1(player.getPositionFrame());
                Panneau.setAngleTortue1(player.getAngle());
                break;
            case "red":
                Panneau.setPositionTortue2(player.getPositionFrame());
                Panneau.setAngleTortue2(player.getAngle());
                break;
            case "green":
                Panneau.setPositionTortue3(player.getPositionFrame());
                Panneau.setAngleTortue3(player.getAngle());
                break;
            case "pink":
                Panneau.setPositionTortue4(player.getPositionFrame());
                Panneau.setAngleTortue4(player.getAngle());
                break;
        }
    }

    private void initialiserBoutonsCartes() {
        for (int i = 0; i < 5; i++) {
            this.boutonCartes.add(new JButton());
        }
    }


    void afficherCartes(Player player) throws IOException {
        Panneau.afficherCartes(player);
    }

    void afficherMurs(Player player) throws IOException {
        Panneau.afficherMurs(player);
    }


    void afficherCurrentPlayer(Player player) {
        Panneau.setJoueurQuiJoue(player.getPassageOrder());
    }

    void afficherInstructions(String instruction) {
        Panneau.setInstruction(instruction);

    }

    void incrementeCompteurCartesCliquees() {
        this.compteurCartesCliquees++;
    }

    int getCompteurCartesCliquees() {
        return compteurCartesCliquees;
    }

    void positionnerMur() {
        for (int i = 0; i < (nombreColonnes * 8); i++) {
            int finalI = i;
            listeBoutons.get(i).addActionListener(event -> {
                positionMur[1] = finalI / 8;
                positionMur[0] = finalI % 8;


            });
        }

    }

    void essai() {

        CompleterProgramme.addActionListener(event -> choixJeu = 1);

        PoserMur.addActionListener(event -> choixJeu = 2);

        ExecuterProgramme.addActionListener(event -> choixJeu = 3);
    }


    void cliquerCartes() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            boutonCartes.get(i).addActionListener(event -> {
                if (choixJeu == 1) {
                    choixCarte = finalI;
                }
            });
        }
        boutonValider.addActionListener(event -> {
            if (choixJeu == 1) {
                finChoix = true;
            }
        });


    }

    void cliquerMurs() {
        boutonMur1.addActionListener(event -> {
            if (choixJeu == 2) {
                choixMur = 0;
            }
        });

        boutonMur2.addActionListener(event -> {
            if (choixJeu == 2) {
                choixMur = 1;
            }
        });
        boutonMur3.addActionListener(event -> {
            if (choixJeu == 2) {
                choixMur = 2;
            }
        });
        boutonMur4.addActionListener(event -> {
            if (choixJeu == 2) {
                choixMur = 3;
            }
        });
        boutonMur5.addActionListener(event -> {
            if (choixJeu == 2) {
                choixMur = 4;
            }
        });

    }

    void choixMenu() {
        bouton2.addActionListener(event -> changerMenu(2));
        bouton3.addActionListener(event -> changerMenu(3));
        bouton4.addActionListener(event -> changerMenu(4));


    }

    void finJeu(int joueurGagnant) {
        Panneau.setFinJeu(joueurGagnant);
    }

    private void changerMenu(int nombreJoueur) {
        if (nombreJoueur == 2) {
            this.menu = 2;
            Panneau.setMenu(2);
            nombreColonnes = 7;

        } else if (nombreJoueur == 3) {
            this.menu = 3;
            Panneau.setMenu(3);
            nombreColonnes = 7;

        } else if (nombreJoueur == 4) {

            this.menu = 4;
            Panneau.setMenu(4);
            nombreColonnes = 8;
        }

        this.remove(bouton2);
        this.remove(bouton3);
        this.remove(bouton4);
        this.repaint();
        for (int i = 0; i < 5; i++) {
            this.add(boutonCartes.get(i));
        }
        this.add(boutonMur1);
        this.add(boutonMur2);
        this.add(boutonMur3);
        this.add(boutonMur4);
        this.add(boutonMur5);
        this.add(CompleterProgramme);
        this.add(boutonValider);
        this.add(ExecuterProgramme);
        this.add(PoserMur);
        for (JButton listeBouton : listeBoutons) {
            this.add(listeBouton);
        }
        this.add(nothing);
    }


    Graphique() {

        this.setTitle("Robot Turtles");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initialiserBoutonsCartes();
        String instruction = "";
        Panneau.setInstruction(instruction);
        if (menu == 0) {
            this.add(bouton2);
            this.add(bouton3);
            this.add(bouton4);
        }
        for (int i = 0; i < 5; i++) {
            boutonCartes.get(i).setBounds(150 * i, this.getHeight() - 230, 150, 200);
            boutonCartes.get(i).setOpaque(false);
            boutonCartes.get(i).setContentAreaFilled(false);
            boutonCartes.get(i).setBorderPainted(false);
        }


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

        bouton2.setBounds(this.getWidth() / 4, this.getHeight() / 2 - 100, 50, 100);
        bouton2.setOpaque(false);
        bouton2.setContentAreaFilled(false);
        bouton2.setBorderPainted(false);


        nothing.setOpaque(false);
        nothing.setContentAreaFilled(false);
        nothing.setBorderPainted(false);

        bouton3.setBounds(this.getWidth() / 2, this.getHeight() / 2 - 100, 50, 100);
        bouton3.setOpaque(false);
        bouton3.setContentAreaFilled(false);
        bouton3.setBorderPainted(false);

        bouton4.setBounds(3 * this.getWidth() / 4, this.getHeight() / 2 - 100, 50, 100);
        bouton4.setOpaque(false);
        bouton4.setContentAreaFilled(false);
        bouton4.setBorderPainted(false);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton boutonTableau = new JButton();
                boutonTableau.setBounds(26 + i * 81, 24 + j * 79, 77, 77);
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


    int getChoixJeu() {
        return choixJeu;
    }

    void setChoixJeu(int choixJeu) {
        this.choixJeu = choixJeu;
    }

    int getChoixCarte() {
        return choixCarte;
    }

    void setChoixCarte() {
        this.choixCarte = 5;
    }

    void setFinChoix() {
        this.finChoix = false;
    }

    void desactiveBoutonCarte(int i) {
        this.boutonCartes.get(i).setVisible(false);
    }

    void setCompteurCartesCliquees() {
        this.compteurCartesCliquees = 0;
    }

    boolean isFinChoix() {
        return !finChoix;
    }

    void reactiverBouton() {
        ExecuterProgramme.setVisible(true);
        CompleterProgramme.setVisible(true);
        PoserMur.setVisible(true);
        for (int i = 0; i < 5; i++) {
            this.boutonCartes.get(i).setVisible(true);
        }
    }

    void setCompleterProgramme() {
        CompleterProgramme.setVisible(false);
    }

    void setExecuterProgramme() {
        ExecuterProgramme.setVisible(false);
    }


    void setPoserMur() {
        PoserMur.setVisible(false);
    }

    int getMenu() {
        return menu;
    }

    int getChoixMur() {
        return choixMur;
    }

    int[] getPositionMur() {
        return positionMur;
    }

    void setPositionMur(int[] positionMur) {
        this.positionMur = positionMur;
    }

    void addCoordoneesMurs(Integer[] coordoneesMurs) {
        this.coordoneesMurs.add(coordoneesMurs);
        Panneau.addCoordoneesMurs(coordoneesMurs);

    }

    void addBlocksSurPlateau(Blocks blocksSurPlateau) {
        Panneau.addBlocksSurPlateau(blocksSurPlateau);
    }

    List<Integer[]> getCoordoneesMurs() {
        return coordoneesMurs;
    }


    void setChoixMur() {
        this.choixMur = 5;
    }

    void supprimerBloc(Integer[] coor) {
        int i = -1;
        Iterator<Integer[]> iterator = coordoneesMurs.iterator();
        while (iterator.hasNext()) {
            i++;
            Integer[] I = iterator.next();
            if (I[0].equals(coor[0]) && I[1].equals(coor[1])) {
                iterator.remove();
                break;
            }
        }
        Panneau.removeBlocksSurPlateau(i);
        Panneau.supprimerBlock(coor);
    }

}

