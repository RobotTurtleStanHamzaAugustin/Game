import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int currentPlayer = 3;
        Game game = new Game();
        Grid grid = new Grid(new int[8][8]);
        game.initialiserJeu(grid);
        do {
            currentPlayer = (currentPlayer + 1) % 4;
            System.out.println("C'est le tour du joueur " + (currentPlayer + 1));
            Game.tourJeu(Game.getPlayers().get(currentPlayer), grid, game);
            grid.updateCell(Game.getPlayers().get(currentPlayer));
            grid.afficherCell();
            Game.defausser(Game.getPlayers().get(currentPlayer));
        } while (Game.finduJeu(Game.getPlayers().get(currentPlayer), grid) == false);
        System.out.println("Le joueur gagnant est le joueur" + (currentPlayer + 1));


    }
}
