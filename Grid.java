

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Grid {
    private int[][] cell;
    private static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] visited;
    private List<int[]> path;

    private void setVisited(int row, int col) {
        visited[row][col] = true;
    }

    private boolean isExplored(int row, int col) {
        return visited[row][col];
    }

    private boolean isExit(int x, int y) {
        return this.cell[x][y] == 10;
    }


    private int[] getNextCoordinate(int ligne, int colonne, int i, int j) {
        return new int[]{ligne + i, colonne + j};
    }

    Grid(Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            this.cell = new int[8][7];
        } else {
            this.cell = new int[8][8];

        }

    }

    int initialiserCell(Graphique graphique) {


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

    void poserBlock(Blocks block, int ligne, int colonne) {
        if (block instanceof IceBlock) {
            this.cell[ligne][colonne] = 8;
        } else {
            this.cell[ligne][colonne] = 9;
        }
    }

    boolean presenceBlock(int ligne, int colonne) {
        return this.cell[ligne][colonne] == 8 || this.cell[ligne][colonne] == 9;
    }

    void deleteBlock(int ligne, int colonne) {
        this.cell[ligne][colonne] = 0;
    }

    boolean Blockisposable(int ligne, int colonne, Blocks block, Graphique graphique) {
        if (ligne < 0 || colonne < 0) {
            return false;
        }
        if (this.cell[ligne][colonne] != 0) {
            return false;
        }
        if (block instanceof StoneBlock) {
            this.poserBlock(new StoneBlock(), ligne, colonne);
            for (int i = 0; i < Game.getPlayers().size(); i++) {
                if (solve(Game.getPlayers().get(i).getPosition()[0], Game.getPlayers().get(i).getPosition()[1], graphique).isEmpty()) {
                    this.deleteBlock(ligne, colonne);
                    return false;
                }
            }
            this.deleteBlock(ligne, colonne);
        }

        return true;
    }

    boolean presenceJoueur(int ligne, int colonne) {
        return this.cell[ligne][colonne] == 1 || this.cell[ligne][colonne] == 2 || this.cell[ligne][colonne] == 3 || this.cell[ligne][colonne] == 4;
    }

    boolean sortieCarte(int ligne, int colonne, Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            return ligne < 0 || ligne > 7 || colonne < 0 || colonne > 6;
        } else if (graphique.getMenu() == 4) {
            return ligne < 0 || ligne > 7 || colonne < 0 || colonne > 7;
        }

        return false;
    }

    int indiceJoueur(int ligne, int colonne, Graphique graphique) {
        if (graphique.getMenu() == 2) {
            return (this.cell[ligne][colonne] + 2 - 1) % 2;
        } else if (graphique.getMenu() == 3) {
            return (this.cell[ligne][colonne] + 3 - 1) % 3;
        } else if (graphique.getMenu() == 4) {
            return (this.cell[ligne][colonne] + 4 - 1) % 4;
        }
        return 0;

    }


    void updateCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = player.getPassageOrder();


    }

    void deleteCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = 0;
    }

    void afficherCell(Graphique graphique) {
        if (graphique.getMenu() == 2 || graphique.getMenu() == 3) {
            System.out.println("_________________________________________________________________");
            for (int i = 0; i < 8; i++) {
                System.out.println();
                for (int j = 0; j < 7; j++) {
                    System.out.print("\t" + this.cell[i][j] + "\t");
                }

            }
            System.out.println("\n_________________________________________________________________");

        } else if (graphique.getMenu() == 4) {
            System.out.println("_________________________________________________________________");
            for (int i = 0; i < 8; i++) {
                System.out.println();
                for (int j = 0; j < 8; j++) {
                    System.out.print("\t" + this.cell[i][j] + "\t");
                }

            }
            System.out.println("\n_________________________________________________________________");

        }


    }

    int[][] getCell() {
        return cell;
    }


    private List<int[]> solve(int ligne, int colonne, Graphique graphique) {
        path = new ArrayList<>();
        if (graphique.getMenu() == 4){
            visited = new boolean[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    visited[i][j] = false;
                }
            }
        } else {
            visited = new boolean[8][7];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    visited[i][j] = false;
                }
            }

        }

        if (explore(ligne, colonne)) {
            return path;
        }
        return Collections.emptyList();

    }

    private boolean explore(int ligne, int colonne) {
        if (ligne > 7 || ligne < 0 || colonne > (visited[0].length - 1) || colonne < 0 || this.cell[ligne][colonne] == 9 || this.isExplored(ligne, colonne)) {
            return false;
        }

        path.add(new int[]{ligne, colonne});
        this.setVisited(ligne, colonne);
        if (this.isExit(ligne, colonne)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            int[] coordonees = getNextCoordinate(ligne, colonne, direction[0], direction[1]);
            if (explore(coordonees[0], coordonees[1])) {
                return true;
            }
        }
        path.remove(path.size() - 1);


        return false;
    }
}
