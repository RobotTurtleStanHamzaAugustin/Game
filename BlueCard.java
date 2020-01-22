

class BlueCard extends Card {
    BlueCard() {
        this.description = "Avancer la tortue d'une case";
        this.name = "Blue Card";
    }

    void executerCard(Player player, Grid grid, Graphique graphique) {

        if (player.getDirection() == 0) {
            if (grid.sortieCarte(player.getPosition()[0] - 1, player.getPosition()[1], graphique)) {
                player.retourDepart(graphique);

            } else if (grid.presenceBlock(player.getPosition()[0] - 1, player.getPosition()[1])) {
                player.setDirection(2);
                player.setAngle(270);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0] - 1, player.getPosition()[1])) {
                int joueurCogne = grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1], graphique);
                grid.deleteCell(Game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1], graphique)));
                Game.getPlayers().get(joueurCogne).retourDepart(graphique);
                grid.updateCell(Game.getPlayers().get(joueurCogne));
                graphique.BougerTortue(Game.getPlayers().get(joueurCogne));
                player.retourDepart(graphique);
            } else {

                player.setPosition(true, false, false, false);
            }


        } else if (player.getDirection() == 1) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] + 1, graphique)) {
                player.retourDepart(graphique);

            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] + 1)) {
                player.setDirection(3);
                player.setAngle(0);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] + 1)) {
                int playerHit = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1, graphique);
                grid.deleteCell(Game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1, graphique)));
                Game.getPlayers().get(playerHit).retourDepart(graphique);
                grid.updateCell(Game.getPlayers().get(playerHit));
                graphique.BougerTortue(Game.getPlayers().get(playerHit));
                player.retourDepart(graphique);
            } else {
                player.setPosition(false, true, false, false);
            }
        } else if (player.getDirection() == 2) {
            if (grid.sortieCarte(player.getPosition()[0] + 1, player.getPosition()[1], graphique)) {
                player.retourDepart(graphique);
            } else if (grid.presenceBlock(player.getPosition()[0] + 1, player.getPosition()[1])) {
                player.setDirection(0);
                player.setAngle(90);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0] + 1, player.getPosition()[1])) {
                int joueurCogne = grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1], graphique);
                grid.deleteCell(Game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1], graphique)));
                Game.getPlayers().get(joueurCogne).retourDepart(graphique);
                grid.updateCell(Game.getPlayers().get(joueurCogne));
                graphique.BougerTortue(Game.getPlayers().get(joueurCogne));
                player.retourDepart(graphique);
            } else {
                player.setPosition(false, false, true, false);
            }
        } else if (player.getDirection() == 3) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] - 1, graphique)) {
                player.retourDepart(graphique);
            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] - 1)) {
                player.setDirection(1);
                player.setAngle(180);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] - 1)) {
                int joueurCogne = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] - 1, graphique);
                grid.deleteCell(Game.getPlayers().get(joueurCogne));
                Game.getPlayers().get(joueurCogne).retourDepart(graphique);
                grid.updateCell(Game.getPlayers().get(joueurCogne));
                graphique.BougerTortue(Game.getPlayers().get(joueurCogne));
                player.retourDepart(graphique);
            } else {
                player.setPosition(false, false, false, true);
            }
        }

    }

}
