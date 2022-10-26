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

    public boolean checkPlay(String play, String turn) {

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

                this.indexes[row - 1][column - 1] = 'X';
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

            this.indexes[row][column] = '0';
            return true;

        }

    }

    public String checkWinner() {
        
        if (this.indexes[0][0] == 'X' && this.indexes[0][1] == 'X' && this.indexes[0][2] == 'X'
            ||
            this.indexes[1][0] == 'X' && this.indexes[1][1] == 'X' && this.indexes[1][2] == 'X'
            ||
            this.indexes[2][0] == 'X' && this.indexes[2][1] == 'X' && this.indexes[2][2] == 'X'
            ||
            this.indexes[0][0] == 'X' && this.indexes[1][0] == 'X' && this.indexes[2][0] == 'X'
            ||
            this.indexes[0][1] == 'X' && this.indexes[1][1] == 'X' && this.indexes[2][1] == 'X'
            ||
            this.indexes[0][2] == 'X' && this.indexes[1][2] == 'X' && this.indexes[2][2] == 'X'
            ||
            this.indexes[0][0] == 'X' && this.indexes[1][1] == 'X' && this.indexes[2][2] == 'X'
            ||
            this.indexes[2][0] == 'X' && this.indexes[1][1] == 'X' && this.indexes[0][2] == 'X')
            
            {
            
            return "Player"; 

        }

        if (this.indexes[0][0] == '0' && this.indexes[0][1] == '0' && this.indexes[0][2] == '0'
            ||
            this.indexes[1][0] == '0' && this.indexes[1][1] == '0' && this.indexes[1][2] == '0'
            ||
            this.indexes[2][0] == '0' && this.indexes[2][1] == '0' && this.indexes[2][2] == '0'
            ||
            this.indexes[0][0] == '0' && this.indexes[1][0] == '0' && this.indexes[2][0] == '0'
            ||
            this.indexes[0][1] == '0' && this.indexes[1][1] == '0' && this.indexes[2][1] == '0'
            ||
            this.indexes[0][2] == '0' && this.indexes[1][2] == '0' && this.indexes[2][2] == '0'
            ||
            this.indexes[0][0] == '0' && this.indexes[1][1] == '0' && this.indexes[2][2] == '0'
            ||
            this.indexes[2][0] == '0' && this.indexes[1][1] == '0' && this.indexes[0][2] == '0')

            {

            return "Enemy";

        }

        return "Tie";

    }

}