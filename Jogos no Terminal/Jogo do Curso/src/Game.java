import java.util.Scanner;
import java.io.IOException;

public class Game {

    public static void main(String[] args) throws IOException, InterruptedException {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        int x, aux_x, y, aux_y, a = 0, b = 0, i, j, k = 0;
        String entry;
        String[] coordinates;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            k = 0;
            System.out.println("Do you want to start a new game?");
            System.out.println("Y - Yes, start the new game!");
            System.out.println("N - No, finish the application!");
            System.out.print("Answer: ");
            entry = scanner.nextLine();
            System.out.println();

            if (entry.equals("N")) {

                break;

            }

            else if (entry.equals("Y")) {

                System.out.println("Which difficulty do you wish to play in?");
                System.out.println("H - Hard difficulty!");
                System.out.println("E - Easy difficulty!");
                System.out.print("Answer: ");
                entry = scanner.nextLine();

                if (entry.equals("E") || entry.equals("S")) {

                    a = 5;
                    b = 5;

                    if (entry.equals("S")) {

                        k = 1;

                    }

                }

                else if (entry.equals("H")) {

                    a = 10;
                    b = 10;

                }

            }

            Functionality functionality = new Functionality(a, b);

            for (i = 0; i < 5; i++) {

                x = (int) Math.floor(Math.random() * a);
                y = (int) Math.floor(Math.random() * b);
                functionality.Enemies(x, y, a, b);

            }

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Number of tries left: " + functionality.z);
            System.out.println("Number of enemies left: " + functionality.w);

            while (functionality.end == false) {

                functionality.showScenery();
                System.out.print("Input the x and y coordinates in the format x,y to attack: ");
                entry = scanner.nextLine();
                coordinates = entry.split(",");
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
                aux_x = x;
                aux_y = y;
                functionality.Action(x - 1, y - 1);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Number of tries left: " + functionality.z);
                System.out.println("Number of enemies left: " + functionality.w);
                System.out.println(

                        "The nearest target is witihin " + functionality.nearestTarget(x - 1, y - 1)
                                + " space(s) of position [" + (aux_x) + "][" + (aux_y) + "]"

                );

                if (k == 1) {

                    System.out.println();
                    System.out.println("The positions of the remaining enemies are: ");
                    System.out.println();

                    for (i = 0; i < a; i++) {

                        for (j = 0; j < b; j++) {

                            if (functionality.enemies[i][j] == 1) {

                                System.out.println("[" + (i + 1) + "] [" + (j + 1) + "]");

                            }

                        }
                    }

                }

            }

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            if (functionality.w == 0) {

                System.out.println("Congratulations! You won!");
                System.out.println();

            }

            else if (functionality.z == 0) {

                System.out.println("You lost! Better luck next time!");
                System.out.println();

            }

        }

        System.out.println("Thanks for playing!");
        scanner.close();

    }
}