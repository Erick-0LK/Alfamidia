import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean end_game;
        Scanner scanner = new Scanner(System.in);
        String player_symbol = determinePlayerSymbol(scanner);
        Grid grid = new Grid(new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});

        while (true) {

            String enemy_symbol = player_symbol.equals("X") ? "0" : "X";
            int turns = 0;

            while (true) {

                clearTerminal();
                System.out.println("Tic-Tac-Toe Game - Java Application\n");

                if (player_symbol.equals("X")) {

                    grid.showGrid();
                    playerTurn(scanner, grid, "X", "0");

                }

                else {

                    enemyTurn(grid, "0", "X");
                    grid.showGrid();

                }

                if (!grid.checkWinner(player_symbol, enemy_symbol).equals("Tie")) {

                    break;

                }

                turns++;

                if (turns == 5) {

                    break;

                }

                if (player_symbol.equals("X")) {
                    
                    enemyTurn(grid, "X", "0");
                    grid.showGrid();

                }

                else {

                    playerTurn(scanner, grid, "0", "X");

                }

                if (!grid.checkWinner(player_symbol, enemy_symbol).equals("Tie")) {

                    break;

                }

            }

            clearTerminal();
            System.out.println("Tic-Tac-Toe Game - Java Application\n");
            grid.showGrid();

            if (grid.checkWinner(player_symbol, enemy_symbol).equals("Player")) {

                System.out.println("\nCongratulations! You won!");

            }

            else if (grid.checkWinner(player_symbol, enemy_symbol).equals("Enemy")) {

                System.out.println("\nYou lost! Better luck next time!");

            }

            else {

                System.out.println("\nIt is a tie!");

            }

            end_game = yesOrNoQuestion(scanner, grid);
            grid = new Grid(new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});

            if (end_game == false) {

                player_symbol = determinePlayerSymbol(scanner);

            }

            else if (end_game == true) {
                
                break;

            }

        }

        clearTerminal();
        System.out.println("The application has ended.");
        scanner.close();

    }

    public static void playerTurn(Scanner scanner, Grid grid, String player_symbol, String enemy_symbol) {

        boolean acceptance;
        String play;
        System.out.print("\nInput row,column: ");
        play = scanner.nextLine();

        do {
            
            acceptance = grid.checkPlay(play, "Player", player_symbol, enemy_symbol);

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

    public static void enemyTurn(Grid grid, String player_symbol, String enemy_symbol) {

        boolean acceptance;

        do{
            
            acceptance = grid.checkPlay("", "Enemy", player_symbol, enemy_symbol);

        } while (acceptance == false);

    }

    public static boolean yesOrNoQuestion(Scanner scanner, Grid grid) {

        String answer;

        do{

            System.out.print("\nDo you want to play again? Yes or no? (Y/N): ");
            answer = scanner.nextLine();

            if (!(answer.equals("Y") || answer.equals("N"))) {
                
                clearTerminal();
                System.out.println("Tic-Tac-Toe Game - Java Application\n");
                grid.showGrid();
                System.out.println("\nInvalid answer. Please try again.");

            }

        } while (!(answer.equals("Y") || answer.equals("N")));

        return answer.equals("Y") ? false : true;

    }

    public static String determinePlayerSymbol(Scanner scanner) {

        String user_input;
        clearTerminal();
        System.out.print("Tic-Tac-Toe Game - Java Application\n\n1. Play as X\n2. Play as 0");
        
        do {

            System.out.print("\n\nInput: ");
            user_input = scanner.nextLine();
            clearTerminal();

            switch (user_input) {

                case "1":

                    return "X";

                case "2":

                    return "0";

                default:

                    System.out.print("Tic-Tac-Toe Game - Java Application\n\n1. Play as X\n2. Play as 0\n\nInput: " + user_input);
                    System.out.print("\n\nInvalid input. Please try again.");
                    break;
                    
            }

        } while (!user_input.equals("1") || !user_input.equals("2"));

        return "";

    }

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}