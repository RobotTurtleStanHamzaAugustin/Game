import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Le nom du thread principal est " + Thread.currentThread().getName());

        Graphique graphique = new Graphique();
        Game game = new Game();
        Grid grid = new Grid(new int[8][8]);
        int currentPlayer = 3;
        game.initialiserJeu(grid, graphique);
        do {
            currentPlayer = (currentPlayer + 1) % 4;
            Game.tourJeu(Game.getPlayers().get(currentPlayer), grid, game,graphique);
            grid.updateCell(Game.getPlayers().get(currentPlayer));
            grid.afficherCell();
            Game.defausser(Game.getPlayers().get(currentPlayer),graphique);
        } while (Game.finduJeu(Game.getPlayers().get(currentPlayer), grid) == false);
        System.out.println("Le joueur gagnant est le joueur" + (currentPlayer + 1));


    }
}
