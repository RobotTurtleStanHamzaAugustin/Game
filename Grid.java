public class Grid {
    private int[][] cell;

    public Grid(Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            this.cell = new int[8][7];
        } else {
            this.cell = new int[8][8];
        }

    }

    public int initialiserCell(Graphique graphique) {

        if (graphique.getMenu() == 2) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    cell[i][j] = 0;
                }
            }
            this.cell[7][3] = 10;
            return 1;

        } else if (graphique.getMenu() == 3) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    cell[i][j] = 0;
                }
            }
            this.cell[7][0] = 10;
            this.cell[7][3] = 10;
            this.cell[7][6] = 10;
            return 2;

        } else if (graphique.getMenu() == 4) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    cell[i][j] = 0;
                }
            }
            this.cell[7][1] = 10;
            this.cell[7][6] = 10;
            return 3;
        }
        return 0;

    }

    public void poserBlock(Blocks block, int ligne, int colonne) {
        if (block instanceof IceBlock) {
            this.cell[ligne][colonne] = 8;
        } else {
            this.cell[ligne][colonne] = 9;
        }
    }

    public boolean presenceBlock(int ligne, int colonne) {
        if (this.cell[ligne][colonne] == 8 || this.cell[ligne][colonne] == 9) {
            return true;
        }
        return false;
    }

    public void deleteBlock(int ligne, int colonne) {
        this.cell[ligne][colonne] = 0;
    }

    public boolean Blockisposable(int ligne, int colonne) {
        if (ligne < 0 || colonne < 0){
            return false;
        }
        if (this.cell[ligne][colonne] != 0) {
            System.out.println("Vous ne pouvez pas poser de mur à cet endroit!");
            return false;
        }
        return true;
    }

    public boolean presenceJoueur(int ligne, int colonne) {
        if (this.cell[ligne][colonne] == 1 || this.cell[ligne][colonne] == 2 || this.cell[ligne][colonne] == 3 || this.cell[ligne][colonne] == 4) {
            return true;
        }
        return false;
    }

    public boolean sortieCarte(int ligne, int colonne, Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            if (ligne < 0 || ligne > 7 || colonne < 0 || colonne > 6) {
                return true;
            }
        } else if (graphique.getMenu() == 4) {
            if (ligne < 0 || ligne > 7 || colonne < 0 || colonne > 7) {
                return true;
            }
        }

        return false;
    }

    public int indiceJoueur(int ligne, int colonne, Graphique graphique) {
        if (graphique.getMenu() == 2) {
            return (this.cell[ligne][colonne] + 2 - 1) % 2;
        } else if (graphique.getMenu() == 3) {
            return (this.cell[ligne][colonne] + 3 - 1) % 3;
        } else if (graphique.getMenu() == 4) {
            return (this.cell[ligne][colonne] + 4 - 1) % 4;
        }
        return 0;

    }


    public void updateCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = player.getPassageOrder();


    }

    public void deleteCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = 0;
    }

    public void afficherCell(Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            System.out.println("_________________________________________________________________");
            for (int i = 0; i < 8; i++) {
                System.out.println("");
                for (int j = 0; j < 7; j++) {
                    System.out.print("\t" + this.cell[i][j] + "\t");
                }

            }
            System.out.println("\n_________________________________________________________________");

        } else if (graphique.getMenu() == 4) {
            System.out.println("_________________________________________________________________");
            for (int i = 0; i < 8; i++) {
                System.out.println("");
                for (int j = 0; j < 8; j++) {
                    System.out.print("\t" + this.cell[i][j] + "\t");
                }

            }
            System.out.println("\n_________________________________________________________________");

        }


    }

    public int[][] getCell() {
        return cell;
    }
}
