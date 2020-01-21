import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static List<Player> players;
    private int nombreJoueurs;

    public Game() {
        this.setPlayers();
    }


    public void setPlayers() {
        this.players = new ArrayList<Player>();
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void getPlayerChoice(int choix, Player player, Grid grid, Game game, Graphique graphique) throws IOException, InterruptedException {
        switch (choix) {
            case 1:
                graphique.setExecuterProgramme(false);
                graphique.setPoserMur(false);
                /*System.out.println("Combien de cartes voulez vous ajouter à votre programme?");
                Scanner scanner = new Scanner(System.in);
                int nombre = scanner.nextInt();*/
                graphique.afficherInstructions("Ajoutez des cartes à votre programme!");
                while (!graphique.isFinChoix()) {
                    System.out.println(graphique.getChoixCarte());
                    System.out.println("Quelle carte voulez vous ajouter à votre programme?");
                    System.out.println("Votre main: ");
                    System.out.println(player.getHand());
                    System.out.println("Votre programme: ");
                    System.out.println(player.getProgram());
                    graphique.cliquerCartes();
                    if (graphique.getChoixCarte() != 5) {
                        int indice = graphique.getChoixCarte();
                        player.completerProgram(indice);
                        graphique.setChoixCarte(5);
                        graphique.afficherCartes(player);


                    }
                    Thread.sleep(200);


                }
                graphique.setFinChoix(false);
                graphique.setCompleterProgramme(false);
                break;
            case 2:
                graphique.setCompleterProgramme(false);
                graphique.setExecuterProgramme(false);
                graphique.afficherInstructions("Quel bloc voulez vous construire?");
                int ind = -1;
                int ligne;
                int colonne;
                graphique.setChoixMur(5);
                while (graphique.getChoixMur() == 5) {
                    graphique.cliquerMurs();
                    ind = graphique.getChoixMur();
                }

                graphique.setPositionMur(player.getPosition());


                do {
                    graphique.afficherInstructions("Où voulez-vous le construire?");
                    System.out.println(graphique.getPositionMur()[0]);
                    System.out.println(graphique.getPositionMur()[1]);
                    graphique.positionnerMur();
                    ligne = graphique.getPositionMur()[1];
                    colonne = graphique.getPositionMur()[0];
                    Thread.sleep(200);

                } while (!grid.Blockisposable(colonne, ligne));
                System.out.println(graphique.getPositionMur()[0]);
                System.out.println(graphique.getPositionMur()[1]);
                grid.poserBlock(player.getBlocksInHand().get(ind), ligne, colonne);
                player.defausserBlock(ind);
                graphique.addCoordoneesMurs(ligne);
                graphique.addCoordoneesMurs(colonne);
                graphique.addBlocksSurPlateau(player.getBlocksInHand().get(ind));
//                graphique.repaint();
                graphique.setPoserMur(false);
                break;
            case 3:
                graphique.setCompleterProgramme(false);
                graphique.setPoserMur(false);
                System.out.println("Le programme s'exécute!");
                executerProgram(player, grid, game, graphique);
                graphique.setExecuterProgramme(false);
                break;
            default:
                break;


        }

    }

    public static void executerProgram(Player player, Grid grid, Game game, Graphique graphique) {
        for (int i = 0; i < player.getProgram().size(); i++) {
            Card card = player.getProgram().get(i);
            if (card instanceof BlueCard) {
                grid.deleteCell(player);
                ((BlueCard) card).executerCard(player, grid, game, graphique);
                graphique.BougerTortue(player);
            } else if (card instanceof YellowCard) {
                ((YellowCard) card).executerCard(player);
                graphique.BougerTortue(player);
            } else if (card instanceof PurpleCard) {
                ((PurpleCard) card).executerCard(player);
                graphique.BougerTortue(player);
            } else if (card instanceof LaserCard) {
                ((LaserCard) card).executerCard(player, grid, game, graphique);
            }


        }
        player.initialiserProgram();


    }


    public static void tourJeu(Player player, Grid grid, Game game, Graphique graphique) throws IOException, InterruptedException {
        graphique.afficherCartes(player);
        graphique.afficherMurs(player);
        graphique.afficherCurrentPlayer(player);
        System.out.println("Votre main: ");
        System.out.println(player.getHand());
        System.out.println("Votre programme: ");
        System.out.println(player.getProgram());
        System.out.println("Vos blocs: ");
        System.out.println(player.getBlocksInHand());
        System.out.println("Pour compléter le programme taper 1\nPour construire un mur taper 2\nPour exécuter le programme taper 3");
        while (graphique.getChoixJeu() == 0) {

            graphique.essai();
//            System.out.println(graphique.getChoixJeu());
            Thread.sleep(200);


        }

        getPlayerChoice(graphique.getChoixJeu(), player, grid, game, graphique);
        graphique.setChoixJeu(0);


    }

    public void initialiserPartie(Grid grid, Graphique graphique) throws InterruptedException {
        if (graphique.getMenu() == 2) {
            Player bluePlayer = new Player("blue", new int[]{0, 1}, new int[]{107, 24}, "Jonathan", 1);
            Player redPlayer = new Player("red", new int[]{0, 5}, new int[]{431, 24}, "Joseph", 2);
            this.players.add(bluePlayer);
            this.players.add(redPlayer);
            graphique.BougerTortue(bluePlayer);
            graphique.BougerTortue(redPlayer);
            grid.updateCell(bluePlayer);
            grid.updateCell(redPlayer);
            bluePlayer.initialiserHand();
            bluePlayer.initialiserProgram();
            redPlayer.initialiserHand();
            redPlayer.initialiserProgram();
        } else if (graphique.getMenu() == 3) {
            Player bluePlayer = new Player("blue", new int[]{0, 0}, new int[]{26, 24}, "Jonathan", 1);
            Player redPlayer = new Player("red", new int[]{0, 3}, new int[]{269, 24}, "Joseph", 2);
            Player greenPlayer = new Player("green", new int[]{0, 6}, new int[]{512, 24}, "Jotaro", 3);
            this.players.add(bluePlayer);
            this.players.add(redPlayer);
            this.players.add(greenPlayer);
            graphique.BougerTortue(bluePlayer);
            graphique.BougerTortue(redPlayer);
            graphique.BougerTortue(greenPlayer);
            grid.updateCell(bluePlayer);
            grid.updateCell(redPlayer);
            grid.updateCell(greenPlayer);
            bluePlayer.initialiserHand();
            bluePlayer.initialiserProgram();
            redPlayer.initialiserHand();
            redPlayer.initialiserProgram();
            greenPlayer.initialiserHand();
            greenPlayer.initialiserProgram();
        } else if (graphique.getMenu() == 4) {
            Player bluePlayer = new Player("blue", new int[]{0, 0}, new int[]{26, 24}, "Jonathan", 1);
            Player redPlayer = new Player("red", new int[]{0, 2}, new int[]{188, 24}, "Joseph", 2);
            Player greenPlayer = new Player("green", new int[]{0, 5}, new int[]{431, 24}, "Jotaro", 3);
            Player pinkPlayer = new Player("pink", new int[]{0, 7}, new int[]{593, 24}, "Josuke", 4);
            this.players.add(bluePlayer);
            this.players.add(redPlayer);
            this.players.add(greenPlayer);
            this.players.add(pinkPlayer);
            graphique.BougerTortue(bluePlayer);
            graphique.BougerTortue(redPlayer);
            graphique.BougerTortue(greenPlayer);
            graphique.BougerTortue(pinkPlayer);
            grid.updateCell(bluePlayer);
            grid.updateCell(redPlayer);
            grid.updateCell(greenPlayer);
            grid.updateCell(pinkPlayer);
            bluePlayer.initialiserHand();
            bluePlayer.initialiserProgram();
            redPlayer.initialiserHand();
            redPlayer.initialiserProgram();
            greenPlayer.initialiserHand();
            greenPlayer.initialiserProgram();
            pinkPlayer.initialiserHand();
            pinkPlayer.initialiserProgram();
        }


    }

    public int initialiserJeu(Grid grid, Graphique graphique) throws InterruptedException {
        int i = grid.initialiserCell(graphique);
        this.initialiserPartie(grid, graphique);
        grid.afficherCell(graphique);
        return i;
    }

    public static boolean finduJeu(Player player, Graphique graphique) {
        if (graphique.getMenu() == 2) {
            if (player.getPosition()[0] == 7 && player.getPosition()[1] == 3) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        } else if (graphique.getMenu() == 3) {
            if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 0 || player.getPosition()[1] == 3 || player.getPosition()[1] == 6)) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        } else if (graphique.getMenu() == 4) {
            if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 1 || player.getPosition()[1] == 6)) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        }

        return false;
    }

    public static void defausser(Player player, Graphique graphique) throws IOException, InterruptedException {

        graphique.afficherCartes(player);
        graphique.afficherCurrentPlayer(player);
        graphique.afficherInstructions("Défausser des cartes");
        System.out.println("Votre main: ");
        System.out.println(player.getHand());
        System.out.println("Combien de cartes voulez vous défausser?");
        graphique.setChoixJeu(1);
        while (!graphique.isFinChoix()) {
            System.out.println("Votre main: ");
            System.out.println(player.getHand());
            System.out.println("Quelle carte voulez-vous défausser?");
            graphique.cliquerCartes();
            if (graphique.getChoixCarte() != 5) {
                int ind = graphique.getChoixCarte();
                player.defausserHand(ind);
                graphique.setChoixCarte(5);
                graphique.afficherCartes(player);
            }
            Thread.sleep(200);

        }
        player.piocherHand();
        graphique.afficherInstructions("");
        graphique.setChoixJeu(0);
        graphique.setFinChoix(false);
        graphique.setExecuterProgramme(true);
        graphique.setCompleterProgramme(true);
        graphique.setPoserMur(true);
    }


}
