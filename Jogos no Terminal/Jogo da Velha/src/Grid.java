import java.util.InputMismatchException;;

public class Grid {
    
    private char[][] indexes = new char[3][3];

    Grid(char[][] indexes) {

        this.indexes = indexes;

    }

    public void showGrid() {

        System.out.println(this.indexes[0][0] + "|" + this.indexes[0][1] + "|" + this.indexes[0][2]
                           + "\n-+-+-\n" +
                           this.indexes[1][0] + "|" + this.indexes[1][1] + "|" + this.indexes[1][2]
                           + "\n-+-+-\n" +
                           this.indexes[2][0] + "|" + this.indexes[2][1] + "|" + this.indexes[2][2]);

    }

    public boolean checkPlay(String play, String turn, String player_symbol, String enemy_symbol) {

        if (turn.equals("Player")) {

            try {

                int row = Character.getNumericValue(play.charAt(0));
                int column = Character.getNumericValue(play.charAt(2));

                if (play.length() != 3 || play.charAt(1) != ',' || row < 1 || row > 3 || column < 1 || column > 3) {

                    return false;

                }

                if (this.indexes[row - 1][column - 1] != ' ') {

                    return false;

                }

                this.indexes[row - 1][column - 1] = player_symbol.charAt(0);
                return true;

            } catch (IndexOutOfBoundsException error) {

                return false;

            } catch (InputMismatchException error) {

                return false;

            }

        }

        else {

            int row = (int)(Math.random() * 3);
            int column = (int)(Math.random() * 3);

            if (this.indexes[row][column] != ' ') {

                return false;

            }

            this.indexes[row][column] = enemy_symbol.charAt(0);;
            return true;

        }

    }

    public String checkWinner(String player_symbol, String enemy_symbol) {

        String winner = "";

        for (int row = 0; row <= 2; row++) {

            for (int column = 0; column <= 2; column++) {

                winner += this.indexes[row][column];

            }

            if (!determineWinner(winner, player_symbol, enemy_symbol).equals("Tie")) {

                return determineWinner(winner, player_symbol, enemy_symbol);

            }

            winner = "";

        }

        for (int column = 0; column <= 2; column++) {

            for (int row = 0; row <= 2; row++) {

                winner += this.indexes[row][column];

            }

            if (!determineWinner(winner, player_symbol, enemy_symbol).equals("Tie")) {

                return determineWinner(winner, player_symbol, enemy_symbol);

            }

            winner = "";

        }

        for (int row = 0, column = 0; row <= 2; row++, column++) {

            winner += this.indexes[row][column];

            if (winner.length() == 3 && !determineWinner(winner, player_symbol, enemy_symbol).equals("Tie")) {

               return determineWinner(winner, player_symbol, enemy_symbol);

            }

        }

        winner = "";

        for (int row = 0, column = 2; column >= 0; row++, column--) {

            winner += this.indexes[row][column];

            if (winner.length() == 3 && !determineWinner(winner, player_symbol, enemy_symbol).equals("Tie")) {

               return determineWinner(winner, player_symbol, enemy_symbol);

            }
            
        }

        return "Tie";

    }

    public String determineWinner(String winner, String player_symbol, String enemy_symbol) {

        switch (winner) {

            case "XXX":
                
                return player_symbol.equals("X") ? "Player" : "Enemy";

            case "000":

                return enemy_symbol.equals("0") ? "Enemy" : "Player";

            default:

                return  "Tie";

        }
        
    }

}