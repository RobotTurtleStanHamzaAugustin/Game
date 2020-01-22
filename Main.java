

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Graphique graphique = new Graphique();
        Game game = new Game();
        Grid grid = new Grid(graphique);


        while (graphique.getMenu() == 0) {
            graphique.choixMenu();
            Thread.sleep(200);
        }
        int currentPlayer = game.initialiserJeu(grid, graphique);
        do {
            currentPlayer = changerCurrentPlayer(graphique, currentPlayer);
            Game.tourJeu(Game.getPlayers().get(currentPlayer), grid, graphique);
            grid.updateCell(Game.getPlayers().get(currentPlayer));
            grid.afficherCell(graphique);
            Game.defausser(Game.getPlayers().get(currentPlayer), graphique);
        } while (!Game.finduJeu(Game.getPlayers().get(currentPlayer), graphique));


    }

    private static int changerCurrentPlayer(Graphique graphique, int currentPlayer) {
        if (graphique.getMenu() == 2) {
            currentPlayer = (currentPlayer + 1) % 2;
        } else if (graphique.getMenu() == 3) {
            currentPlayer = (currentPlayer + 1) % 3;
        } else if (graphique.getMenu() == 4) {
            currentPlayer = (currentPlayer + 1) % 4;
        }
        return currentPlayer;

    }
}
