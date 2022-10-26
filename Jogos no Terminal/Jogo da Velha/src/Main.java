import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean end_game;
        Grid grid = new Grid(new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});
        Scanner scanner = new Scanner(System.in);

        do{

            int turns = 0;

            while (true) {

                clearTerminal();
                System.out.println("Tic-Tac-Toe Game - Java Application\n");
                grid.showGrid();
                playerTurn(scanner, grid);

                if (!grid.checkWinner().equals("Tie")) {

                    break;

                }

                turns++;

                if (turns == 5) {

                    break;

                }

                enemyTurn(grid);

                if (!grid.checkWinner().equals("Tie")) {

                    break;

                }

            }

            clearTerminal();
            System.out.println("Tic-Tac-Toe Game - Java Application\n");
            grid.showGrid();

            if (grid.checkWinner().equals("Player")) {

                System.out.println("\nCongratulations! You won!");

            }

            else if (grid.checkWinner().equals("Enemy")) {

                System.out.println("\nYou lost! Better luck next time!");

            }

            else {

                System.out.println("\nIt is a tie!");

            }

           end_game = yesOrNoQuestion(scanner);
           grid = new Grid(new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});

        } while (end_game == false);

        clearTerminal();
        System.out.println("The application has ended.");
        scanner.close();

    }

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void playerTurn(Scanner scanner, Grid grid) {

        boolean acceptance;
        String play;
        System.out.print("\nInput row,column: ");
        play = scanner.nextLine();

        do{
            
            acceptance = grid.checkPlay(play, "Player");

            if (acceptance == false) {

                clearTerminal();
                System.out.println("Tic-Tac-Toe Game - Java Application\n");
                grid.showGrid();
                System.out.println("\nInvalid play. Please try again.");
                System.out.print("\nInput row,column: ");
                play = scanner.nextLine();

            }

        } while (acceptance == false);

    }

    public static void enemyTurn(Grid grid) {

        boolean acceptance;

        do{
            
            acceptance = grid.checkPlay("", "Enemy");

        } while (acceptance == false);

    }

    public static boolean yesOrNoQuestion(Scanner scanner) {

        String answer;

        do{

            System.out.print("\nDo you want to play again? Yes or no? (Y/N): ");
            answer = scanner.nextLine();

            if (!(answer.equals("Y") || answer.equals("N"))) {
                
                System.out.println("Invalid answer. Please try again.");

            }

        } while (!(answer.equals("Y") || answer.equals("N")));

        return answer.equals("Y") ? false : true;

    }

}