package Miguel.Corporation;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Application Class</h1>
 * This Class is the starting point to implement any other class
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public class Application {
    private static final String filepath = "members.txt";
    private static String userName;
    private static String passWord;

    /**
     * This method is used to greet the user.
     * @return boolean, This method will return false
     */
    public boolean welcomePage(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException, IOException {
        boolean success = true;

        do {
            System.out.println("\nIn Order To Use The App, You Need To Login Or Create Account If You Don't Have One");
            System.out.println("\n\t1. Login");
            System.out.println("\t2. Create Account");
            System.out.println("\t3. Quit Applications");

            System.out.print("\nPlease Choose Your Options: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                boolean login = true;
                System.out.println("\nTo Login, Please Enter Your Credentials");
                do {
                    System.out.print("\n\tUsername: ");
                    userName = scanner.next();

                    System.out.print("\tPassword: ");
                    passWord = scanner.next();
                    scanner.nextLine();

                    Login loginPage = new Login(userName,passWord);
                    if (loginPage.verifyLogin(userName,passWord,filepath)) {
                        System.out.println("\nLogin Successfully! Welcome Back To Fit Loops " + loginPage.getUserName() + "!");
                        login = false;
                    } else {
                        System.err.println("Your Username and/or Password is incorrect please re-enter");
                        System.err.flush();
                    }
                } while (login);
                success = false;

            } else if (userInput == 2) {
                System.out.println("\nTo Register, Please Enter Your Credentials");

                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Date Of Birth (dd/MM/yyyy): ");
                String dateOfBirth = scanner.nextLine();

                System.out.print("Weight (KG): ");
                float weight = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Height (CM): ");
                float height = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Username: ");
                String userName = scanner.nextLine();

                System.out.print("Password: ");
                passWord = scanner.nextLine();

                Register register = new Register(firstName,lastName,dateOfBirth,weight,height,userName,passWord);
                register.createUserAccountInformation();
                register.addNewMembers(filepath,"\n" + userName + "," + passWord);
                System.out.println("\nAccount Created Successfully!");

                System.out.println("Username: " + userName);
                System.out.println("Password: YourPassword!");
            } else if (userInput == 3) {

                System.out.println("Goodbye!");
                scanner.close();
                success = false;
            }
            else {
                throw new IndexOutOfBoundsException();
            }

        } while (success);
        return false;
    }

    /**
     * This method is the main page (main menu).
     * @return boolean, This method will return boolean success
     */
    public boolean mainMenu(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException, IOException {
        boolean success = true;

        System.out.println("\nChoose Your Options");
        System.out.println("\nMenu");
        System.out.println("\t1. Maintenance Macro Calculator");
        System.out.println("\t2. Lean Cutting Macro Calculator");
        System.out.println("\t3. Lean Bulking Macro Calculator");
        System.out.println("\t4. Training Plans");
        System.out.println("\t5. Create Weekly Diet Log");
        System.out.println("\t6. Create Weekly Exercise Log");
        System.out.println("\t7. Read My Weekly Diet Log (if there is any)");
        System.out.println("\t8. Read My Weekly Exercise Log (if there is any)");
        System.out.println("\t9. Read My Current Macros Log");
        System.out.println("\t10. Diet Regime Algorithm");
        System.out.println("\t11. Print Menus");
        System.out.println("\t12. Quit Applications");

        System.out.print("\nEnter your choice (11 - To Print Menus): ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 1 ->{
                Maintenance maintenance = new Maintenance(userName,passWord);
                System.out.println("\nMaintenance Macro Calculator");
                System.out.println("\nThis Will Calculate Your Maintenance Macros\n");
                maintenance.getInput();
            }
            case 2 ->{
                Cutting cutting = new Cutting(userName,passWord);
                System.out.println("\nLean Cutting Macro Calculator");
                System.out.println("\nThis Will Calculate Your Lean Cutting Macros\n");
                cutting.getInput();
            }
            case 3 ->{
                Bulking bulking = new Bulking(userName,passWord);
                System.out.println("\nLean Bulking Macro Calculator");
                System.out.println("\nThis Will Calculate Your Lean Bulking Macros\n");
                bulking.getInput();
            }
            case 4 ->{
                Trainings trainingPlans = new Trainings();
                System.out.println("\nTraining Plans, Where You Can Get Recommendations For Your Training Plans Program");
                trainingPlans.getInput();
            }
            case 5 ->{
                System.out.println("\nCreate Weekly Diet Log");
                System.out.println("\nTo Continue, Please Enter How Many Weeks Would You Like To Logs");
                WeeklyDietLogs weeklyDietLogs = new WeeklyDietLogs(userName);
                weeklyDietLogs.getInput();
            }
            case 6 ->{
                System.out.println("\nCreate Weekly Exercise Log");
                System.out.println("\nTo Continue, Please Enter The Following Information");
                WeeklyExerciseLogs weeklyExerciseLogs = new WeeklyExerciseLogs(userName);
                weeklyExerciseLogs.getInput();
            }
            case 7 ->{
                System.out.println("\nRead My Weekly Diet Log (if there is any)");
            }
            case 8 ->{
                System.out.println("\nRead My Weekly Exercise Log (if there is any)");
            }
            case 9 ->{
                System.out.println("\nRead My Current Macros Log");
            }
            case 10 ->{
                System.out.println("\nDiet Regime Algorithm");
            }
            case 11 ->{
                mainMenu(scanner);
                success = false;
            }
            case 12 ->{
                System.out.println("\nSee ya!");
                success = false;
            }
            default ->
                    throw new IndexOutOfBoundsException();
        }
        return success;
    }
}
