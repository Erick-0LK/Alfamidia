public class Functionality {

    public int x, y, z, w;
    public int[][] map;
    public int[][] enemies;
    public String[] symbols = { ".", "X", "*" };
    public boolean end;

    public Functionality(int x, int y) {

        this.x = x;
        this.y = x;
        this.z = 15;
        this.w = 5;
        this.map = new int[x][y];
        this.enemies = new int[x][y];
        this.end = false;

    }

    public void showScenery() {

        int i, j;

        for (i = 0; i < this.x; i++) {

            System.out.println();

            for (j = 0; j < this.y; j++) {

                System.out.print(this.symbols[this.map[i][j]] + " ");

            }

        }

        System.out.println();
        System.out.println();

    }

    public void Enemies(int x, int y, int a, int b) {

        if (this.enemies[x][y] == 0) {

            this.enemies[x][y] = 1;

        }

        else {

            x = (int) Math.floor(Math.random() * a);
            y = (int) Math.floor(Math.random() * b);
            this.Enemies(x, y, a, b);

        }

    }

    public void Action(int x, int y) {

        this.z--;

        if (this.enemies[x][y] == 1) {

            this.map[x][y] = 1;
            this.enemies[x][y] = -1;
            this.w--;

        }

        else if (this.enemies[x][y] == 0) {

            this.map[x][y] = 2;

        }

        if (this.w == 0 || this.z == 0) {

            this.end = true;

        }

    }

    public int nearestTarget(int x, int y) {

        int nearest = 100, i, j;

        for (i = 0; i < this.x; i++) {

            for (j = 0; j < this.y; j++) {

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