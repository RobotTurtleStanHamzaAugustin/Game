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

    public static void getPlayerChoice(int choix, Player player, Grid grid, Game game) {
        switch (choix) {
            case 1:
                System.out.println("Combien de cartes voulez vous ajouter à votre programme?");
                Scanner scanner = new Scanner(System.in);
                int nombre = scanner.nextInt();
                for (int i = 0;i < nombre;i++){
                    System.out.println("Quelle carte voulez vous ajouter à votre programme?");
                    System.out.println("Votre main: ");
                    System.out.println(player.getHand());
                    int indice = scanner.nextInt();
                    player.completerProgram(indice);
                }
                break;
            case 2:
                System.out.println("Quel bloc voulez vous construire?");
                Scanner scannerss = new Scanner(System.in);
                int ind = scannerss.nextInt();
                System.out.println("Où voulez-vous le construire?");
                System.out.println("numéro de ligne?");
                int ligne = scannerss.nextInt();
                System.out.println("numéro de colonne?");
                int colonne = scannerss.nextInt();
                grid.poserBlock(player.getBlocksInHand().get(ind),ligne,colonne);
                player.defausserBlock(ind);

                break;
            case 3:
                System.out.println("Le programme s'exécute!");
                executerProgram(player, grid,game);
            default:
                break;


        }

    }

    public static void executerProgram(Player player, Grid grid,Game game) {
        for (int i = 0; i < player.getProgram().size(); i++) {
            Card card = player.getProgram().get(i);
            if (card instanceof BlueCard) {
                grid.deleteCell(player);
                ((BlueCard) card).executerCard(player,grid,game);
            } else if (card instanceof YellowCard) {
                ((YellowCard) card).executerCard(player);
            } else if (card instanceof PurpleCard) {
                ((PurpleCard) card).executerCard(player);
            } else {
                ((LaserCard) card).executerCard(player);
            }


        }
        player.initialiserProgram();


    }

    public static void tourJeu(Player player, Grid grid,Game game){
        System.out.println("Votre main: ");
        System.out.println(player.getHand());
        System.out.println("Votre programme: ");
        System.out.println(player.getProgram());
        System.out.println("Vos blocs: ");
        System.out.println(player.getBlocksInHand());
        System.out.println("Pour compléter le programme taper 1\nPour construire un mur taper 2\nPour exécuter le programme taper 3");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        getPlayerChoice(choix,player,grid,game);



    }

    public  void initialiserPartie(Grid grid) {
        Player bluePlayer = new Player("blue", new int[]{0, 0}, "Jonathan", 1);
        Player redPlayer = new Player("red", new int[]{0, 2}, "Joseph", 2);
        Player greenPlayer = new Player("green", new int[]{0, 5}, "Jotaro", 3);
        Player pinkPlayer = new Player("pink", new int[]{0, 7}, "Josuke", 4);
        this.players.add(bluePlayer);
        this.players.add(redPlayer);
        this.players.add(greenPlayer);
        this.players.add(pinkPlayer);
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
    public  void initialiserJeu(Grid grid){
        grid.initialiserCell();
        this.initialiserPartie(grid);
        grid.afficherCell();
    }

    public static boolean finduJeu(Player player,Grid grid){
        if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 1 || player.getPosition()[1] == 6 )){
            return true;
        }
        return false;
    }

    public static void defausser(Player player){
        System.out.println("Votre main: ");
        System.out.println(player.getHand());
        System.out.println("Combien de cartes voulez vous défausser?");
        Scanner scanner = new Scanner(System.in);
        int nombre = scanner.nextInt();
        System.out.println("Quelles cartes voulez-vous défausser?");
        List<Integer> cartes = new ArrayList<>();
        for (int i = 0;i < nombre;i++){
            int carte = scanner.nextInt();
            cartes.add(carte);
        }
        for (int i = 0; i < nombre;i++){
            player.defausserHand(cartes.get(i) - i);
        }
        player.piocherHand();

    }




}
