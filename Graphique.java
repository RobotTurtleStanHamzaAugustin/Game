import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Graphique extends JFrame {
    private JButton CompleterProgramme = new JButton();
    private JButton ExecuterProgramme = new JButton();
    private JButton boutonCarte1 = new JButton();
    private JButton boutonCarte2 = new JButton();
    private JButton boutonCarte3 = new JButton();
    private JButton boutonCarte4 = new JButton();
    private JButton boutonCarte5 = new JButton();
    private JButton boutonValider = new JButton();
    private Panneau Panneau = new Panneau();
    int angle = Panneau.getAngle();
    private int choixJeu = 0;
    private int choixCarte = 5;
    private Thread t;
    private boolean finChoix = false;

    public void BougerTortue(Player player) {
        if (player.getColor().equals("blue")) {
            Panneau.setPositionTortue1(player.getPositionFrame());
        } else if (player.getColor().equals("red")) {
            Panneau.setPositionTortue2(player.getPositionFrame());
        } else if (player.getColor().equals("green")) {
            Panneau.setPositionTortue3(player.getPositionFrame());
        } else if (player.getColor().equals("pink")) {
            Panneau.setPositionTortue4(player.getPositionFrame());
        }
    }

    public void afficherCartes(Player player) throws IOException {
        Panneau.afficherCartes(player);
    }

    public void afficherCurrentPlayer(Player player) {
        Panneau.setJoueurQuiJoue(player.getPassageOrder());
    }

    public void essai(){
        CompleterProgramme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                choixJeu = 1;
            }
        });

        ExecuterProgramme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                choixJeu = 3;
            }
        });
    }

    public void Valider(){
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (choixJeu == 1){
                    finChoix = true;
                }
            }
        });
    }

    public void cliquerCartes(){
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
                if (choixJeu == 1){
                    finChoix = true;
                }
            }
        });


    }




    public Graphique() {

        this.setTitle("Robot Turtles");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        JPanel boutonPane = new JPanel();








        this.add(boutonCarte1);
        this.add(boutonCarte2);
        this.add(boutonCarte3);
        this.add(boutonCarte4);
        this.add(boutonCarte5);
        this.add(CompleterProgramme);
        this.add(ExecuterProgramme);
        this.add(boutonValider);


        boutonCarte1.setBounds(0, this.getHeight() - 255, 150, 200);
        boutonCarte1.setOpaque(false);
        boutonCarte1.setContentAreaFilled(false);
        boutonCarte1.setBorderPainted(false);

        boutonCarte2.setBounds(150, this.getHeight() - 255, 150, 200);
        boutonCarte2.setOpaque(false);
        boutonCarte2.setContentAreaFilled(false);
        boutonCarte2.setBorderPainted(false);

        boutonCarte3.setBounds(300, this.getHeight() - 255, 150, 200);
        boutonCarte3.setOpaque(false);
        boutonCarte3.setContentAreaFilled(false);
        boutonCarte3.setBorderPainted(false);

        boutonCarte4.setBounds(450, this.getHeight() - 255, 150, 200);
        boutonCarte4.setOpaque(false);
        boutonCarte4.setContentAreaFilled(false);
        boutonCarte4.setBorderPainted(false);

        boutonCarte5.setBounds(600, this.getHeight() - 255, 150, 200);
        boutonCarte5.setOpaque(false);
        boutonCarte5.setContentAreaFilled(false);
        boutonCarte5.setBorderPainted(false);

        CompleterProgramme.setBounds(this.getWidth() - 214,50,128,128);
        CompleterProgramme.setOpaque(false);
        CompleterProgramme.setContentAreaFilled(false);
        CompleterProgramme.setBorderPainted(false);

        ExecuterProgramme.setBounds(this.getWidth() - 214,350,128,128);
        ExecuterProgramme.setOpaque(false);
        ExecuterProgramme.setContentAreaFilled(false);
        ExecuterProgramme.setBorderPainted(false);

        boutonValider.setBounds(785,this.getHeight() - 115,200,50);
        boutonValider.setOpaque(false);
        boutonValider.setContentAreaFilled(false);
        boutonValider.setBorderPainted(false);


        this.setResizable(false);
        this.getContentPane().add(Panneau);
        Panneau.repaint();
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

