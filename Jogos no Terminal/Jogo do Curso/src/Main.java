import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean end_application = false;
        String[] texts = {"Do you want to start a new game?", "\nY: Yes, start the game.", "\nN: No, end the application."};
        String[] answers = {"Y", "N"};
        Scanner scanner = new Scanner(System.in);
        clearTerminal();
        String begin_game = getUserInput(texts, answers, scanner);

        if (begin_game.equals("Y")) {

            while (end_application == false) {

                clearTerminal();
                Functionality functionality = determineGameSettings(scanner);
                end_application = startGame(scanner, functionality);

            }

        }

        clearTerminal();
        System.out.println("Thanks for playing!");
        scanner.close();

    }

    public static Functionality determineGameSettings(Scanner scanner) {

        int rows = 0, columns = 0;
        boolean cheat = false;
        String[] texts = {"Which difficulty do you wish to play in?", "\nH: Hard difficulty.", "\nE: Easy difficulty."};
        String[] answers = {"H", "E", "S"};
        String game_difficulty = getUserInput(texts, answers, scanner);
      
        if (game_difficulty.equals("E") || game_difficulty.equals("S")) {

            rows = 5;
            columns = 5;
            cheat = game_difficulty.equals("S") ? true : false;

        }

        else if (game_difficulty.equals("H")) {

            rows = 10;
            columns = 10;

        }

        Functionality functionality = new Functionality(rows, columns, cheat);

        for (int index = 0; index < 5; index++) {

            int x = (int) Math.floor(Math.random() * functionality.rows);
            int y = (int) Math.floor(Math.random() * functionality.columns);
            functionality.determineEnemyPositions(x, y, functionality.rows, functionality.columns);

        }

        return functionality;

    }

    public static boolean startGame(Scanner scanner, Functionality functionality) {

        String[] texts = {"Do you want to start a new game?", "\nY: Yes, start the game.", "\nN: No, end the application."};
        String[] answers = {"Y", "N"};
        clearTerminal();
        System.out.println("Number of tries left: " + functionality.number_of_tries);
        System.out.println("Number of enemies left: " + functionality.number_of_enemies);
        functionality.showScenery();
        System.out.print("Input the x and y coordinates in the format x,y to attack: ");
        String user_input = scanner.nextLine();
        String[] coordinates = user_input.split(",");

        while (true) {

            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            int auxiliary_x = x;
            int auxiliary_y = y;
            functionality.playerAction(x - 1, y - 1);
            clearTerminal();

            if (functionality.number_of_enemies == 0 || functionality.number_of_tries == 0) {

                break;

            }

            System.out.println("Number of tries left: " + functionality.number_of_tries);
            System.out.println("Number of enemies left: " + functionality.number_of_enemies);
            System.out.println("The nearest target is witihin "+ functionality.nearestTarget(x - 1, y - 1) +
                               " space(s) of position [" + (auxiliary_x) + "][" + (auxiliary_y) + "]");

            if (functionality.cheat == true) {

                System.out.print("\nThe positions of the remaining enemies are: ");

                for (int i = 0; i < functionality.rows; i++) {

                    for (int j = 0; j < functionality.columns; j++) {

                        if (functionality.enemies[i][j] == 1) {

                            System.out.print("[" + (i + 1) + "][" + (j + 1) + "] ");

                        }

                    }
                }

            }

            System.out.println();
            functionality.showScenery();
            System.out.print("Input the x and y coordinates in the format x,y to attack: ");
            user_input = scanner.nextLine();
            coordinates = user_input.split(",");

        }

        clearTerminal();

        if (functionality.number_of_enemies == 0) {

            System.out.println("Congratulations! You won!\n");

        }

        else if (functionality.number_of_tries == 0) {

            System.out.println("You lost! Better luck next time!\n");

        }

        String auxiliary_end_application = getUserInput(texts, answers, scanner);
        return auxiliary_end_application.equals("Y") ? false : true;

    }

    public static String getUserInput(String[] texts, String[] answers, Scanner scanner) {

        String answer;

        if (answers.length == 2) {

            do {

                System.out.print(texts[0] + texts[1] + texts[2] + "\nInput: ");
                answer = scanner.nextLine();

                if (!(answer.equals(answers[0]) || answer.equals(answers[1]))) {

                    clearTerminal();
                    System.out.println("Invalid input. Please try again.\n");

                }

            } while (!(answer.equals(answers[0]) || answer.equals(answers[1])));

            return answer;

        }

        else {

            do {

                System.out.print(texts[0] + texts[1] + texts[2] + "\nInput: ");
                answer = scanner.nextLine();

                if (!(answer.equals(answers[0]) || answer.equals(answers[1]))) {

                    clearTerminal();
                    System.out.println("Invalid input. Please try again.\n");

                }

            } while (!(answer.equals(answers[0]) || answer.equals(answers[1]) || answer.equals(answers[2])));

            return answer;

        }

    }

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}