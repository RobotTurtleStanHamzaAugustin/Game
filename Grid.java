public class Grid {
    private int[][] cell;

    public Grid(int[][] cell) {
        this.cell = cell;
    }

    public void initialiserCell() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cell[i][j] = 0;
            }
        }
        this.cell[7][1] = 10;
        this.cell[7][6] = 10;
    }

    public void poserBlock(Blocks block, int ligne,int colonne){
        if (block instanceof IceBlock ){
            this.cell[ligne][colonne] = 8;
        } else {
            this.cell[ligne][colonne] = 9;
        }
    }

    public boolean presenceBlock(int ligne, int colonne){
        if (this.cell[ligne][colonne] == 8 || this.cell[ligne][colonne] == 9){
            return true;
        }
        return false;
    }
     public boolean presenceJoueur(int ligne,int colonne){
         if (this.cell[ligne][colonne] == 1 || this.cell[ligne][colonne] == 2 || this.cell[ligne][colonne] == 3 || this.cell[ligne][colonne] == 4){
             return true;
         }
         return false;
     }

     public int indiceJoueur(int ligne, int colonne){
        return (this.cell[ligne][colonne] + 4 - 1) % 4;
     }



    public void updateCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = player.getPassageOrder();
    }

    public void deleteCell(Player player) {
        this.cell[player.getPosition()[0]][player.getPosition()[1]] = 0;
    }

    public void afficherCell() {
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
