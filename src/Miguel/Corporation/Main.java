package Miguel.Corporation;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("Welcome to Fit Loops!");
        System.out.println("=====================");

        boolean success = true;
        while (success) {
            try {
                success = application.welcomePage();
                success = false;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.");

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                System.err.flush();
                scanner.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       boolean quit2 = true;
        while (quit2) {
            try {
                quit2 = application.menu();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.");

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                scanner.next();
            }
        }
    }
}