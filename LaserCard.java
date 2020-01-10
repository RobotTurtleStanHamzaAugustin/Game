class LaserCard extends Card {
    public LaserCard() {
        this.description = "Utiliser un laser pour attaquer ce qui est devant la tortue";
        this.name = "Laser Card";
    }

    public void executerCard(Player player, Grid grid, Game game) {
        if (player.getDirection() == 0) {
            for (int i = player.getPosition()[0] - 1; i > -1; i--) {
                if (grid.getCell()[i][player.getPosition()[1]] == 8) {
                    grid.deleteBlock(i, player.getPosition()[1]);
                    break;
                }
                if (grid.getCell()[i][player.getPosition()[1]] == 9) {
                    break;
                }
                if (grid.getCell()[i][player.getPosition()[1]] == 4 || grid.getCell()[i][player.getPosition()[1]] == 1 || grid.getCell()[i][player.getPosition()[1]] == 2 || grid.getCell()[i][player.getPosition()[1]] == 3) {
                    int joueurTouché = grid.indiceJoueur(i, player.getPosition()[1]);
                    grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(i, player.getPosition()[1])));
                    game.getPlayers().get(joueurTouché).retourDepart();
                    grid.updateCell(game.getPlayers().get(joueurTouché));
                    break;
                }


            }


        } else if (player.getDirection() == 1) {
            for (int i = player.getPosition()[1] + 1; i < 8; i++) {
                System.out.println("coucou");
                if (grid.getCell()[player.getPosition()[0]][i] == 8) {
                    System.out.println("block");
                    grid.deleteBlock(player.getPosition()[0], i);
                    break;
                }
                if (grid.getCell()[player.getPosition()[0]][i] == 9) {
                    break;
                }
                if (grid.getCell()[player.getPosition()[0]][i] == 4 || grid.getCell()[player.getPosition()[0]][i] == 1 || grid.getCell()[player.getPosition()[0]][i] == 2 || grid.getCell()[player.getPosition()[0]][i] == 1) {
                    System.out.println("joueur");
                    int joueurTouche = grid.indiceJoueur(player.getPosition()[0], i);
                    grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], i)));
                    game.getPlayers().get(joueurTouche).retourDepart();
                    grid.updateCell(game.getPlayers().get(joueurTouche));
                    break;
                }


            }


        } else if (player.getDirection() == 2) {
            for (int i = player.getPosition()[0] + 1; i < 7; i++) {
                if (grid.getCell()[i][player.getPosition()[1]] == 8) {
                    grid.deleteBlock(i, player.getPosition()[1]);
                    break;
                }
                if (grid.getCell()[i][player.getPosition()[1]] == 9) {
                    break;
                }
                if (grid.getCell()[i][player.getPosition()[1]] == 4 || grid.getCell()[i][player.getPosition()[1]] == 1 || grid.getCell()[i][player.getPosition()[1]] == 2 || grid.getCell()[i][player.getPosition()[1]] == 3) {
                    int joueurTouché = grid.indiceJoueur(i, player.getPosition()[1]);
                    grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(i, player.getPosition()[1])));
                    game.getPlayers().get(joueurTouché).retourDepart();
                    grid.updateCell(game.getPlayers().get(joueurTouché));
                    break;
                }


            }

        } else if (player.getDirection() == 3) {
            for (int i = player.getPosition()[1] - 1; i > -1; i--) {
                if (grid.getCell()[player.getPosition()[0]][i] == 8) {
                    grid.deleteBlock(player.getPosition()[0], i);
                    break;
                }
                if (grid.getCell()[player.getPosition()[0]][i] == 9) {
                    break;
                }
                if (grid.getCell()[player.getPosition()[0]][i] == 4 || grid.getCell()[player.getPosition()[0]][i] == 1 || grid.getCell()[player.getPosition()[0]][i] == 2 || grid.getCell()[player.getPosition()[0]][i] == 1) {
                    int joueurTouche = grid.indiceJoueur(player.getPosition()[0], i);
                    grid.deleteCell(game.getPlayers().get(grid.indiceJoueur(player.getPosition()[0], i)));
                    game.getPlayers().get(joueurTouche).retourDepart();
                    grid.updateCell(game.getPlayers().get(joueurTouche));
                    break;
                }


            }


        }
    }
}
