class BlueCard extends Card {
    public BlueCard() {
        this.description = "Avancer la tortue d'une case";
        this.name = "Blue Card";
    }

    public void executerCard(Player player, Grid grid, Game game) {

        if (player.getDirection() == 0) {
            if (grid.sortieCarte(player.getPosition()[0] - 1, player.getPosition()[1])) {
                player.retourDepart();

            } else if (grid.presenceBlock(player.getPosition()[0] - 1, player.getPosition()[1])) {
                player.setDirection(2);
            } else if (grid.presenceJoueur(player.getPosition()[0] - 1, player.getPosition()[1])) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1]);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] - 1, player.getPosition()[1])));
                game.getPlayers().get(joueurCogné).retourDepart();
                grid.updateCell(game.getPlayers().get(joueurCogné));
                player.retourDepart();
            } else {

                player.setPosition(true, false, false, false);
            }


        } else if (player.getDirection() == 1) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] + 1)) {
                player.retourDepart();

            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] + 1)) {
                player.setDirection(3);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] + 1)) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] + 1)));
                game.getPlayers().get(joueurCogné).retourDepart();
                grid.updateCell(game.getPlayers().get(joueurCogné));
                player.retourDepart();
            } else {
                player.setPosition(false, true, false, false);
            }
        } else if (player.getDirection() == 2) {
            if (grid.sortieCarte(player.getPosition()[0] + 1, player.getPosition()[1])) {
                player.retourDepart();
            } else if (grid.presenceBlock(player.getPosition()[0] + 1, player.getPosition()[1])) {
                player.setDirection(0);
            } else if (grid.presenceJoueur(player.getPosition()[0] + 1, player.getPosition()[1])) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1]);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0] + 1, player.getPosition()[1])));
                game.getPlayers().get(joueurCogné).retourDepart();
                grid.updateCell(game.getPlayers().get(joueurCogné));
                player.retourDepart();
            } else {
                player.setPosition(false, false, true, false);
            }
        } else if (player.getDirection() == 3) {
            if (grid.sortieCarte(player.getPosition()[0], player.getPosition()[1] - 1)) {
                player.retourDepart();
            } else if (grid.presenceBlock(player.getPosition()[0], player.getPosition()[1] - 1)) {
                player.setDirection(1);
            } else if (grid.presenceJoueur(player.getPosition()[0], player.getPosition()[1] - 1)) {
                int joueurCogné = grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] - 1);
                grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], player.getPosition()[1] - 1)));
                game.getPlayers().get(joueurCogné).retourDepart();
                grid.updateCell(game.getPlayers().get(joueurCogné));
                player.retourDepart();


            } else {
                player.setPosition(false, false, false, true);
            }
        }

    }

}
