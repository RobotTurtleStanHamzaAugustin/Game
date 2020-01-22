
class LaserCard extends Card {
    LaserCard() {
        this.description = "Utiliser un laser pour attaquer ce qui est devant la tortue";
        this.name = "Laser Card";
    }

    void executerCard(Player player, Grid grid, Graphique graphique) {
        if (player.getDirection() == 0) {
            for (int i = player.getPosition()[0] - 1; i > -1; i--) {
                if (detection(player, grid, graphique, i)) break;
            }
        } else if (player.getDirection() == 1) {
            for (int i = player.getPosition()[1] + 1; i < 8; i++) {
                if (detectionBis(player, grid, graphique, i)) break;
            }
        } else if (player.getDirection() == 2) {
            for (int i = player.getPosition()[0] + 1; i < 8; i++) {
                if (detection(player, grid, graphique, i)) break;
            }

        } else if (player.getDirection() == 3) {
            for (int i = player.getPosition()[1] - 1; i > -1; i--) {
                if (detectionBis(player, grid, graphique, i)) break;
            }
        }
    }

    private boolean detection(Player player, Grid grid, Graphique graphique, int i) {
        if (detectionMur(player, grid, graphique, i)) return true;
        if (grid.getCell()[i][player.getPosition()[1]] == 10) {
            if (graphique.getMenu() == 2) {
                player.inverserPosition();
                graphique.BougerTortue(player);
            } else {
                grid.deleteCell(player);
                player.retourDepart(graphique);
                graphique.BougerTortue(player);
            }
        }
        if (grid.getCell()[i][player.getPosition()[1]] == 4 || grid.getCell()[i][player.getPosition()[1]] == 1 || grid.getCell()[i][player.getPosition()[1]] == 2 || grid.getCell()[i][player.getPosition()[1]] == 3) {
            if (graphique.getMenu() == 2) {
                int joueurTouche = grid.indiceJoueur(i, player.getPosition()[1], graphique);
                Game.getPlayers().get(joueurTouche).inverserPosition();
                graphique.BougerTortue(Game.getPlayers().get(joueurTouche));
                grid.updateCell(Game.getPlayers().get(joueurTouche));

            } else {
                int joueurTouche = grid.indiceJoueur(i, player.getPosition()[1], graphique);
                grid.deleteCell(Game.getPlayers().get(joueurTouche));
                Game.getPlayers().get(joueurTouche).retourDepart(graphique);
                graphique.BougerTortue(Game.getPlayers().get(joueurTouche));
                grid.updateCell(Game.getPlayers().get(joueurTouche));
            }

            return true;
        }
        return false;
    }

    private boolean detectionBis(Player player, Grid grid, Graphique graphique, int i) {
        if (detectionMurBis(player, grid, graphique, i)) return true;
        if (grid.getCell()[player.getPosition()[0]][i] == 10) {
            if (graphique.getMenu() == 2) {
                player.inverserPosition();
                graphique.BougerTortue(player);
            } else {
                grid.deleteCell(player);
                player.retourDepart(graphique);
                graphique.BougerTortue(player);
            }
        }
        if (grid.getCell()[player.getPosition()[0]][i] == 4 || grid.getCell()[player.getPosition()[0]][i] == 1 || grid.getCell()[player.getPosition()[0]][i] == 2 || grid.getCell()[player.getPosition()[0]][i] == 3) {
            if (graphique.getMenu() == 2) {
                int joueurTouche = grid.indiceJoueur(player.getPosition()[0], i, graphique);
                Game.getPlayers().get(joueurTouche).inverserPosition();
                graphique.BougerTortue(Game.getPlayers().get(joueurTouche));
                grid.updateCell(Game.getPlayers().get(joueurTouche));

            } else {
                int joueurTouche = grid.indiceJoueur(player.getPosition()[0], i, graphique);
                grid.deleteCell(Game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], i, graphique)));
                Game.getPlayers().get(joueurTouche).retourDepart(graphique);
                graphique.BougerTortue(Game.getPlayers().get(joueurTouche));
                grid.updateCell(Game.getPlayers().get(joueurTouche));
            }
            return true;
        }
        return false;
    }

    private boolean detectionMurBis(Player player, Grid grid, Graphique graphique, int i) {
        if (grid.getCell()[player.getPosition()[0]][i] == 8) {
            grid.deleteBlock(player.getPosition()[0], i);
            graphique.supprimerBloc(new Integer[]{player.getPosition()[0], i});
            return true;
        }
        return grid.getCell()[player.getPosition()[0]][i] == 9;
    }

    private boolean detectionMur(Player player, Grid grid, Graphique graphique, int i) {
        if (grid.getCell()[i][player.getPosition()[1]] == 8) {
            grid.deleteBlock(i, player.getPosition()[1]);
            graphique.supprimerBloc(new Integer[]{i, player.getPosition()[1]});
            return true;
        }
        return grid.getCell()[i][player.getPosition()[1]] == 9;
    }
}
