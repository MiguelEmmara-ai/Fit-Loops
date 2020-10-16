package Miguel.Corporation;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Welcome To Fit Loops Source Code!</h1>
 * Fit Loops is all in one Fitness Applications to
 * help and keep tracks diet and exercise.
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public class Main extends Application {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This is the main method which makes use Application Class To Start The Program.
     * @param args Unused.
     * @return Nothing.
     */
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
