import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static List<Player> players;

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
                /*System.out.println("Combien de cartes voulez vous ajouter à votre programme?");
                Scanner scanner = new Scanner(System.in);
                int nombre = scanner.nextInt();*/
                while (!graphique.isFinChoix()) {
                    System.out.println(graphique.getChoixCarte());
                    System.out.println("Quelle carte voulez vous ajouter à votre programme?");
                    System.out.println("Votre main: ");
                    System.out.println(player.getHand());
                    System.out.println("Votre programme: ");
                    System.out.println(player.getProgram());
                    graphique.cliquerCartes();
                    if (graphique.getChoixCarte() != 5){
                        int indice = graphique.getChoixCarte();
                        player.completerProgram(indice);
                        graphique.setChoixCarte(5);
                        graphique.afficherCartes(player);


                    }
                    Thread.sleep(2000);


                }
                graphique.setFinChoix(false);
                break;
            case 2:
                System.out.println("Quel bloc voulez vous construire?");
                Scanner scannerss = new Scanner(System.in);
                int ind = scannerss.nextInt();
                int ligne = 1;
                int colonne = 1;
                do {
                    System.out.println("Où voulez-vous le construire?");
                    System.out.println("numéro de ligne?");
                    ligne = scannerss.nextInt();
                    System.out.println("numéro de colonne?");
                    colonne = scannerss.nextInt();
                } while (!grid.Blockisposable(ligne, colonne));

                grid.poserBlock(player.getBlocksInHand().get(ind), ligne, colonne);
                player.defausserBlock(ind);

                break;
            case 3:
                System.out.println("Le programme s'exécute!");
                executerProgram(player, grid, game);
            default:
                break;


        }

    }

    public static void executerProgram(Player player, Grid grid, Game game) {
        for (int i = 0; i < player.getProgram().size(); i++) {
            Card card = player.getProgram().get(i);
            if (card instanceof BlueCard) {
                grid.deleteCell(player);
                ((BlueCard) card).executerCard(player, grid, game);
            } else if (card instanceof YellowCard) {
                ((YellowCard) card).executerCard(player);
            } else if (card instanceof PurpleCard) {
                ((PurpleCard) card).executerCard(player);
            } else if (card instanceof LaserCard) {
                ((LaserCard) card).executerCard(player, grid, game);
            }


        }
        player.initialiserProgram();


    }


    public static void tourJeu(Player player, Grid grid, Game game, Graphique graphique) throws IOException, InterruptedException {
        graphique.afficherCartes(player);
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
            System.out.println(graphique.getChoixJeu());
        }

        getPlayerChoice(graphique.getChoixJeu(), player, grid, game, graphique);
        graphique.setChoixJeu(0);


    }

    public void initialiserPartie(Grid grid, Graphique graphique) {
        Player bluePlayer = new Player("blue", new int[]{0, 0}, new int[]{20, 30}, "Jonathan", 1);
        Player redPlayer = new Player("red", new int[]{0, 2}, new int[]{184, 30}, "Joseph", 2);
        Player greenPlayer = new Player("green", new int[]{0, 5}, new int[]{430, 30}, "Jotaro", 3);
        Player pinkPlayer = new Player("pink", new int[]{0, 7}, new int[]{594, 30}, "Josuke", 4);
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

    public void initialiserJeu(Grid grid, Graphique graphique) {
        grid.initialiserCell();
        this.initialiserPartie(grid, graphique);
        grid.afficherCell();
    }

    public static boolean finduJeu(Player player, Grid grid) {
        if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 1 || player.getPosition()[1] == 6)) {
            return true;
        }
        return false;
    }

    public static void defausser(Player player, Graphique graphique) throws IOException, InterruptedException {
        graphique.afficherCartes(player);
        graphique.afficherCurrentPlayer(player);
        System.out.println("Votre main: ");
        System.out.println(player.getHand());
        System.out.println("Combien de cartes voulez vous défausser?");
        graphique.setChoixJeu(1);
        while (!graphique.isFinChoix()) {
            System.out.println("Votre main: ");
            System.out.println(player.getHand());
            System.out.println("Quelle carte voulez-vous défausser?");
            graphique.cliquerCartes();
            if (graphique.getChoixCarte() != 5){
                int ind = graphique.getChoixCarte();
                player.defausserHand(ind);
                graphique.setChoixCarte(5);
                graphique.afficherCartes(player);
            }
            Thread.sleep(2000);

        }
        player.piocherHand();
        graphique.setChoixJeu(0);
        graphique.setFinChoix(false);
    }


}
