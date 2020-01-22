import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game {
    private static List<Player> players;


    Game() {
        this.setPlayers();
    }


    private void setPlayers() {
        players = new ArrayList<>();
    }

    static List<Player> getPlayers() {
        return players;
    }

    private static void getPlayerChoice(int choix, Player player, Grid grid, Graphique graphique) throws IOException, InterruptedException {
        switch (choix) {
            case 1:
                graphique.setExecuterProgramme();
                graphique.setPoserMur();
                graphique.afficherInstructions("Ajoutez des cartes à votre programme!");
                while (graphique.isFinChoix()) {
                    graphique.cliquerCartes();
                    if (graphique.getChoixCarte() != 5) {
                        int indice = graphique.getChoixCarte();
                        player.completerProgram(indice);
                        graphique.setChoixCarte();
                        graphique.afficherCartes(player);
                        graphique.incrementeCompteurCartesCliquees();
                        graphique.desactiveBoutonCarte(5 - graphique.getCompteurCartesCliquees());


                    }
                    Thread.sleep(200);
                }
                graphique.setFinChoix();
                graphique.setCompleterProgramme();
                break;
            case 2:
                graphique.setCompleterProgramme();
                graphique.setExecuterProgramme();
                graphique.afficherInstructions("Quel bloc voulez vous construire?");
                int ind = 0;
                int ligne;
                int colonne;
                graphique.setChoixMur();

                while (graphique.getChoixMur() == 5) {
                    graphique.cliquerMurs();
                    ind = graphique.getChoixMur();
                }
                graphique.setPositionMur(new int[]{-1, -1});
                do {
                    graphique.afficherInstructions("Où voulez-vous le construire?");
                    graphique.positionnerMur();
                    ligne = graphique.getPositionMur()[0];
                    colonne = graphique.getPositionMur()[1];
                    Thread.sleep(200);
                } while (!grid.Blockisposable(ligne, colonne, player.getBlocksInHand().get(ind), graphique));
                grid.poserBlock(player.getBlocksInHand().get(ind), ligne, colonne);
                graphique.addCoordoneesMurs(new Integer[]{ligne, colonne});
                graphique.addBlocksSurPlateau(player.getBlocksInHand().get(ind));
                player.defausserBlock(ind);
                graphique.repaint();
                graphique.setPoserMur();
                break;
            case 3:
                graphique.setCompleterProgramme();
                graphique.setPoserMur();
                executerProgram(player, grid, graphique);
                graphique.setExecuterProgramme();
                break;
            default:
                break;


        }

    }

    private static void executerProgram(Player player, Grid grid, Graphique graphique) {
        for (int i = 0; i < player.getProgram().size(); i++) {
            Card card = player.getProgram().get(i);
            if (card instanceof BlueCard) {
                grid.deleteCell(player);
                ((BlueCard) card).executerCard(player, grid, graphique);
                graphique.BougerTortue(player);
            } else if (card instanceof YellowCard) {
                ((YellowCard) card).executerCard(player);
                graphique.BougerTortue(player);
            } else if (card instanceof PurpleCard) {
                ((PurpleCard) card).executerCard(player);
                graphique.BougerTortue(player);
            } else if (card instanceof LaserCard) {
                ((LaserCard) card).executerCard(player, grid, graphique);
            }


        }
        player.initialiserProgram();


    }


    static void tourJeu(Player player, Grid grid, Graphique graphique) throws IOException, InterruptedException {
        graphique.afficherCartes(player);
        graphique.afficherMurs(player);
        graphique.afficherCurrentPlayer(player);
        while (graphique.getChoixJeu() == 0) {
            graphique.essai();
            Thread.sleep(200);
        }

        getPlayerChoice(graphique.getChoixJeu(), player, grid, graphique);
        graphique.setChoixJeu(0);


    }

    private void initialiserPartie(Grid grid, Graphique graphique) {
        if (graphique.getMenu() == 2) {
            Player bluePlayer = new Player("blue", new int[]{0, 1}, new int[]{107, 24}, 1);
            Player redPlayer = new Player("red", new int[]{0, 5}, new int[]{431, 24}, 2);
            players.add(bluePlayer);
            players.add(redPlayer);
        } else if (graphique.getMenu() == 3) {
            Player bluePlayer = new Player("blue", new int[]{0, 0}, new int[]{26, 24}, 1);
            Player redPlayer = new Player("red", new int[]{0, 3}, new int[]{269, 24}, 2);
            Player greenPlayer = new Player("green", new int[]{0, 6}, new int[]{512, 24}, 3);
            players.add(bluePlayer);
            players.add(redPlayer);
            players.add(greenPlayer);
        } else if (graphique.getMenu() == 4) {
            Player bluePlayer = new Player("blue", new int[]{0, 0}, new int[]{26, 24}, 1);
            Player redPlayer = new Player("red", new int[]{0, 2}, new int[]{188, 24}, 2);
            Player greenPlayer = new Player("green", new int[]{0, 5}, new int[]{431, 24}, 3);
            Player pinkPlayer = new Player("pink", new int[]{0, 7}, new int[]{593, 24}, 4);
            players.add(bluePlayer);
            players.add(redPlayer);
            players.add(greenPlayer);
            players.add(pinkPlayer);


        }
        for (Player player : players) {
            graphique.BougerTortue(player);
            grid.updateCell(player);
            player.initialiserHand();
            player.initialiserProgram();
        }


    }

    int initialiserJeu(Grid grid, Graphique graphique) {
        int i = grid.initialiserCell(graphique);
        this.initialiserPartie(grid, graphique);
        grid.afficherCell(graphique);
        return i;
    }

    static boolean finduJeu(Player player, Graphique graphique) {
        if (graphique.getMenu() == 2) {
            if (player.getPosition()[0] == 7 && player.getPosition()[1] == 3) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        } else if (graphique.getMenu() == 3) {
            if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 0 || player.getPosition()[1] == 3 || player.getPosition()[1] == 6)) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        } else if (graphique.getMenu() == 4) {
            if (player.getPosition()[0] == 7 && (player.getPosition()[1] == 1 || player.getPosition()[1] == 6)) {
                graphique.finJeu(player.getPassageOrder());
                return true;
            }
        }

        return false;
    }

    static void defausser(Player player, Graphique graphique) throws IOException, InterruptedException {
        graphique.afficherCartes(player);
        graphique.afficherCurrentPlayer(player);
        graphique.afficherInstructions("Défausser des cartes");
        graphique.setChoixJeu(1);
        while (graphique.isFinChoix()) {
            graphique.cliquerCartes();
            if (graphique.getChoixCarte() != 5) {
                int ind = graphique.getChoixCarte();
                player.defausserHand(ind);
                graphique.setChoixCarte();
                graphique.afficherCartes(player);
                graphique.incrementeCompteurCartesCliquees();
                graphique.desactiveBoutonCarte(5 - graphique.getCompteurCartesCliquees());
            }
            Thread.sleep(200);

        }
        player.piocherHand();
        graphique.afficherInstructions("");
        graphique.setChoixJeu(0);
        graphique.setFinChoix();
        graphique.reactiverBouton();
        graphique.setCompteurCartesCliquees();
    }


}
