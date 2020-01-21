import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Graphique graphique = new Graphique();
        Game game = new Game();
        Grid grid = new Grid(graphique);



        while (graphique.getMenu() == 0){
            graphique.choixMenu();
            System.out.println(graphique.getMenu());
            Thread.sleep(200);
        }
        int currentPlayer = game.initialiserJeu(grid, graphique);
        do {
            currentPlayer = changerCurrentPlayer(graphique,currentPlayer);
            Game.tourJeu(Game.getPlayers().get(currentPlayer), grid, game,graphique);
            grid.updateCell(Game.getPlayers().get(currentPlayer));
            grid.afficherCell(graphique);
            Game.defausser(Game.getPlayers().get(currentPlayer),graphique);
        } while (Game.finduJeu(Game.getPlayers().get(currentPlayer), graphique) == false);
        System.out.println("Le joueur gagnant est le joueur" + (currentPlayer + 1));


    }

    public static int changerCurrentPlayer(Graphique graphique, int currentPlayer){
        if (graphique.getMenu() == 2){
            currentPlayer = (currentPlayer + 1) % 2;
        } else if (graphique.getMenu() == 3){
            currentPlayer = (currentPlayer + 1) % 3;
        } else if (graphique.getMenu() == 4){
            currentPlayer = (currentPlayer + 1) % 4;
        }
        return currentPlayer;

    }
}
