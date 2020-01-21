class BlueCard extends Card {
    public BlueCard() {
        this.description = "Avancer la tortue d'une case";
        this.name = "Blue Card";
    }

    public void executerCard(Player player, Grid grid, Game game,Graphique graphique) {

        if (player.getDirection() == 0) {
            if (grid.sortieCarte(player.getPosition()[0] - 1, player.getPosition()[1],graphique)) {
                player.retourDepart(graphique);

            } else if (grid.presenceBlock(player.getPosition()[0] - 1, player.getPosition()[1])) {
                player.setDirection(2);
                player.setAngle(270);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0] - 1, player.getPosition()[1])) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1],graphique);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1],graphique)));
                game.getPlayers().get(joueurCogné).retourDepart(graphique);
                grid.updateCell(game.getPlayers().get(joueurCogné));
                graphique.BougerTortue(game.getPlayers().get(joueurCogné));
                player.retourDepart(graphique);
            } else {

                player.setPosition(true, false, false, false);
            }


        } else if (player.getDirection() == 1) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] + 1,graphique)) {
                player.retourDepart(graphique);

            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] + 1)) {
                player.setDirection(3);
                player.setAngle(0);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] + 1)) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1,graphique);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1,graphique)));
                game.getPlayers().get(joueurCogné).retourDepart(graphique);
                grid.updateCell(game.getPlayers().get(joueurCogné));
                graphique.BougerTortue(game.getPlayers().get(joueurCogné));
                player.retourDepart(graphique);
            } else {
                player.setPosition(false, true, false, false);
            }
        } else if (player.getDirection() == 2) {
            if (grid.sortieCarte(player.getPosition()[0] + 1, player.getPosition()[1],graphique)) {
                player.retourDepart(graphique);
            } else if (grid.presenceBlock(player.getPosition()[0] + 1, player.getPosition()[1])) {
                player.setDirection(0);
                player.setAngle(90);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0] + 1, player.getPosition()[1])) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1],graphique);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1],graphique)));
                game.getPlayers().get(joueurCogné).retourDepart(graphique);
                grid.updateCell(game.getPlayers().get(joueurCogné));
                graphique.BougerTortue(game.getPlayers().get(joueurCogné));
                player.retourDepart(graphique);
            } else {
                player.setPosition(false, false, true, false);
            }
        } else if (player.getDirection() == 3) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] - 1,graphique)) {
                player.retourDepart(graphique);
            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] - 1)) {
                player.setDirection(1);
                player.setAngle(180);
                graphique.BougerTortue(player);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] - 1)) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] - 1,graphique);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] - 1,graphique)));
                game.getPlayers().get(joueurCogné).retourDepart(graphique);
                grid.updateCell(game.getPlayers().get(joueurCogné));
                graphique.BougerTortue(game.getPlayers().get(joueurCogné));
                player.retourDepart(graphique);


            } else {
                player.setPosition(false, false, false, true);
            }
        }

    }

}
