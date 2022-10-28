public class Functionality {

    public int rows;
    public int columns;
    public int number_of_enemies;
    public int number_of_tries;
    public int[][] map;
    public int[][] enemies;
    public String[] symbols = { ".", "X", "*" };
    public boolean cheat;

    public Functionality(int rows, int columns, boolean cheat) {

        this.rows = rows;
        this.columns = rows;
        this.number_of_enemies = 5;
        this.number_of_tries = 10;
        this.map = new int[rows][columns];
        this.enemies = new int[rows][columns];
        this.cheat = cheat;

    }

    public void showScenery() {

        int i, j;

        for (i = 0; i < this.rows; i++) {

            System.out.println();

            for (j = 0; j < this.columns; j++) {

                System.out.print(this.symbols[this.map[i][j]] + " ");

            }

        }

        System.out.println();
        System.out.println();

    }

    public void determineEnemyPositions(int x, int y, int rows, int columns) {

        if (this.enemies[x][y] == 0) {

            this.enemies[x][y] = 1;

        }

        else {

            x = (int) Math.floor(Math.random() * rows);
            y = (int) Math.floor(Math.random() * columns);
            this.determineEnemyPositions(x, y, rows, columns);

        }

    }

    public void playerAction(int x, int y) {

        this.number_of_tries--;

        if (this.enemies[x][y] == 1) {

            this.map[x][y] = 1;
            this.enemies[x][y] = -1;
            this.number_of_enemies--;

        }

        else if (this.enemies[x][y] == 0) {

            this.map[x][y] = 2;

        }

    }

    public int nearestTarget(int x, int y) {

        int nearest = 100, i, j;

        for (i = 0; i < this.rows; i++) {

            for (j = 0; j < this.columns; j++) {

                if (this.enemies[i][j] == 1) {

                    if (Math.abs(x - i) + Math.abs(y - j) < nearest) {

                        nearest = (Math.abs(x - i) + Math.abs(y - j));

                    }
                }

            }

        }

        return nearest;

    }

}