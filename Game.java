import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;

    public static void getPlayerChoice(int choix,Player player) {
        switch (choix){
            case 1:
                System.out.println("Quelle carte voulez vous ajouter à votre programme?");
                Scanner scanner = new Scanner(System.in);
                int indice = scanner.nextInt();
                player.completerProgram(indice);
                break;
            case 2:
                System.out.println("Le programme s'exécute!");
                executerProgram(player);
            default:
                break;



        }

    }

    public static void executerProgram(Player player){
        for (int i=0;i < player.getProgram().size(); i++){
            Card card = player.getProgram().get(i);
            if (card instanceof  BlueCard){
                ((BlueCard)card).executerCard(player);
            } else if (card instanceof  YellowCard){
                ((YellowCard)card).executerCard(player);
            } else if (card instanceof PurpleCard){
                ((PurpleCard)card).executerCard(player);
            } else {
                ((LaserCard)card).executerCard(player);
            }


        }



    }
}
