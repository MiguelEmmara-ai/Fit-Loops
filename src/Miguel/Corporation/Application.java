package Miguel.Corporation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     *
     * @return boolean, This method will return false
     */
    public boolean welcomePage(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException, IOException {
        boolean success = true;

        do {
            System.out.println("\nIn Order To Use The App, You Need To Login Or Create An Account If You Don't Have One");
            System.out.println("\n\t1. Login");
            System.out.println("\t2. Create Account");
            System.out.println("\t3. Quit Applications");

            System.out.print("\nPlease Choose Your Options: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            if (userInput == 1) {
                boolean login = true;

                // Using file pointer creating the file.
                File file = new File(filepath);
                if (!file.exists()) {

                    // Create a new file if not exists.
                    file.createNewFile();
                }
                System.out.println("\nTo Login, Please Enter Your Credentials");
                do {
                    System.out.print("\n\tUsername: ");
                    userName = scanner.nextLine();

                    System.out.print("\tPassword: ");
                    passWord = scanner.nextLine();
                    PassWords secretPassword = new PassWords(passWord,false);
                    String theKey = userName + "SpecialKey123";
                    secretPassword.encrypt(theKey.toCharArray());

                    Login loginPage = new Login(userName, secretPassword.toString());
                    if (loginPage.verifyLogin(userName, secretPassword.toString(), filepath)) {
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
                while (!isValidDate(dateOfBirth)) {
                    System.out.print("\nPlease use dd/MM/yyyy format: ");
                    dateOfBirth = scanner.nextLine();
                }
                    System.out.print("Weight (KG): ");
                    float weight = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Height (CM): ");
                    float height = scanner.nextFloat();
                    scanner.nextLine();

                    int goalType;
                    boolean success2 = false;
                    while (!success2) {
                        try {
                            System.out.println("Goal type: ");
                            System.out.println("\n\t1. Maintenance");
                            System.out.println("\t2. Cutting");
                            System.out.println("\t3. Bulking");
                            System.out.print("\nAnswer: ");
                            goalType = scanner.nextInt();
                            scanner.nextLine();
                            success2 = true;

                            System.out.print("Username: ");
                            String userName = scanner.nextLine();

                            System.out.print("Password: ");
                            passWord = scanner.nextLine();
                            PassWords secretPassword = new PassWords(passWord,false);
                            String theKey = userName + "SpecialKey123";
                            secretPassword.encrypt(theKey.toCharArray());

                            switch (goalType) {
                                case 1 -> {
                                    Register register = new Register(firstName, lastName, dateOfBirth, weight, height, GoalType.MAINTENANCE, userName, secretPassword.toString());
                                    register.createUserAccountInformation();
                                    register.addNewMembers(filepath, "\n" + userName + "," + secretPassword.toString());
                                    System.out.println("\nAccount Created Successfully!");

                                    System.out.println("Username: " + userName);
                                    System.out.println("Password: YourPassword!");
                                }
                                case 2 -> {
                                    Register register = new Register(firstName, lastName, dateOfBirth, weight, height, GoalType.CUTTING, userName, secretPassword.toString());
                                    register.createUserAccountInformation();
                                    register.addNewMembers(filepath, "\n" + userName + "," + secretPassword.toString());
                                    System.out.println("\nAccount Created Successfully!");

                                    System.out.println("Username: " + userName);
                                    System.out.println("Password: YourPassword!");
                                }
                                case 3 -> {
                                    Register register = new Register(firstName, lastName, dateOfBirth, weight, height, GoalType.BULKING, userName, secretPassword.toString());
                                    register.createUserAccountInformation();
                                    register.addNewMembers(filepath, "\n" + userName + "," + secretPassword.toString());
                                    System.out.println("\nAccount Created Successfully!");

                                    System.out.println("Username: " + userName);
                                    System.out.println("Password: " + secretPassword.toString() + " (Encrypted!)");
                                }
                                default -> throw new IndexOutOfBoundsException();
                            }

                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid menu input. Please try again.\n");
                            System.out.flush();
                        } catch (InputMismatchException | IllegalArgumentException e) {
                            System.out.println("Invalid menu input. Please try again.\n");
                            System.out.flush();
                            scanner.nextLine();
                        }
                    }

                } else if (userInput == 3) {
                    System.out.println("Goodbye!");
                    scanner.close();
                    success = true;
                    System.exit(0);
                } else {
                    throw new IndexOutOfBoundsException();
                }

            } while (success) ;
            return false;
        }

        /**
         * This method is the main page (main menu).
         * @return boolean, This method will return boolean success
         */
        public boolean mainMenu (Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException, IOException
        {
            boolean success = true;

            System.out.println("\nChoose Your Options");
            System.out.println("\nMenu");
            System.out.println("\t1. Maintenance Macro Calculator");
            System.out.println("\t2. Lean Cutting Macro Calculator");
            System.out.println("\t3. Lean Bulking Macro Calculator");
            System.out.println("\t4. Training Plans");
            System.out.println("\t5. Create Diet Log");
            System.out.println("\t6. Create Exercise Log");
            System.out.println("\t7. Read Diet Log (if there is any)");
            System.out.println("\t8. Read Exercise Log (if there is any)");
            System.out.println("\t9. Read My Current Macros Log");
            System.out.println("\t10. Diet Regime Algorithm");
            System.out.println("\t11. Print Menus");
            System.out.println("\t12. Quit Applications");

            System.out.print("\nEnter your choice (11 - To Print Menus): ");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1 -> {
                    Maintenance maintenance = new Maintenance(userName, passWord);
                    System.out.println("\nMaintenance Macro Calculator");
                    System.out.println("\nThis Will Calculate Your Maintenance Macros\n");
                    maintenance.getInput(scanner);
                }
                case 2 -> {
                    Cutting cutting = new Cutting(userName, passWord);
                    System.out.println("\nLean Cutting Macro Calculator");
                    System.out.println("\nThis Will Calculate Your Lean Cutting Macros\n");
                    cutting.getInput(scanner);
                }
                case 3 -> {
                    Bulking bulking = new Bulking(userName, passWord);
                    System.out.println("\nLean Bulking Macro Calculator");
                    System.out.println("\nThis Will Calculate Your Lean Bulking Macros\n");
                    bulking.getInput(scanner);
                }
                case 4 -> {
                    Trainings trainingPlans = new Trainings();
                    System.out.println("\nTraining Plans, Where You Can Get Recommendations For Your Training Plans Program");
                    trainingPlans.getInput(scanner);
                }
                case 5 -> {
                    System.out.println("\nCreate Daily Diet Log");
                    System.out.println("\nTo Continue, Please Enter The Following Information");
                    DietLogs weeklyDietLogs = new DietLogs(userName);
                    weeklyDietLogs.getInput(scanner);
                }
                case 6 -> {
                    System.out.println("\nCreate Daily Exercise Log");
                    System.out.println("\nTo Continue, Please Enter The Following Information");
                    ExerciseLogs weeklyExerciseLogs = new ExerciseLogs(userName);
                    weeklyExerciseLogs.getInput(scanner);
                }
                case 7 -> {
                    System.out.println("\nRead My Diet Log");
                    DietLogs weeklyDietLogs = new DietLogs(userName);
                    weeklyDietLogs.readDietLog(scanner);
                }
                case 8 -> {
                    System.out.println("\nRead My Exercise Log");
                    ExerciseLogs weeklyExerciseLogs = new ExerciseLogs(userName);
                    weeklyExerciseLogs.readExerciseLog(scanner);
                }
                case 9 -> {
                    System.out.println("\nRead My Current Macros Log");
                    System.out.println("\nTo Continue, Please Choose Your File You Want To Read");
                    readMacrosLog(scanner);
                }
                case 10 -> {
                    System.out.println("\nDiet Regime Algorithm");
                    System.out.println("This Is The Regime Algorithm For You Depending On Your Result Week By Week");
                    dietRegimeAlgorithm(scanner);
                }
                case 11 -> {
                    mainMenu(scanner);
                }
                case 12 -> {
                    System.out.println("\nSee ya!");
                    success = false;
                }
                default -> throw new IndexOutOfBoundsException();
            }
            return success;
        }

        public void readMacrosLog (Scanner scanner){
            File directoryPath = new File(System.getProperty("user.dir"));
            // List text files only
            System.out.println("\n----------- File Names Available -----------");
            File[] files = directoryPath.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith("Macros.txt");
                }
            });

            int counter = 1;
            if (files != null && files.length > 0) {
                ArrayList<String> arrayLists = new ArrayList<>(counter);
                for (File file : files) {
                    System.out.println(counter + ". " + file.getName());
                    counter++;
                    arrayLists.add(file.getName());
                }
                //System.out.println("\nArray List");
                int i;
            /*for (i = 0; i < arrayLists.size(); i++)
                System.out.print((i+1) + ". " + arrayLists.get(i) + "\n");*/

                System.out.print("\nPlease Enter Your Options: ");
                i = scanner.nextInt();
                if (i <= arrayLists.size()) {
                    //System.out.println(i);
                    //System.out.print(arrayLists.get(i-1) + "\n");
                    System.out.println();
                    try {
                        File myObj = new File(arrayLists.get(i - 1));
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }

            } else {
                System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                        "You Can Create one Within The Main Menu Options 1,2,3");
            }
        }

        public void dietRegimeAlgorithm (Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException {
            int i = 0;
            int weeks = 0;
            int counter = 1;
            boolean success1 = false;
            while (!success1) {
                try {
                    System.out.println("\nInitiating The Shred");
                    System.out.print("\nHow Many Weeks You Have Been Dieting (eg. 10): ");
                    weeks = scanner.nextInt();
                    success1 = true;
                    while (i < weeks) {
                        System.out.println("\nWeek " + (i + 1));

                        boolean success2 = false;
                        while (!success2) {
                            try {
                                System.out.println("Did You Stay Within 5 Gram Of Your Macros Every Day, Throughout The Week?");
                                System.out.println("\t1. Yes");
                                System.out.println("\t2. No");
                                System.out.print("\nAnswer: ");
                                int answer = scanner.nextInt();
                                scanner.nextLine();

                                switch (answer) {
                                    case 1 -> {
                                        boolean success3 = false;
                                        while (!success3) {
                                            try {
                                                System.out.println("\nWhat Happened To Your Weight Compared To Your Starting Weigh in?");
                                                System.out.println("\t1. Maintained / Increased");
                                                System.out.println("\t2. Decreased");
                                                System.out.print("\nAnswer: ");
                                                int answerForWeight = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (answerForWeight) {
                                                    case 1 -> {
                                                        System.out.println("Maintained / Increased\n");
                                                        System.out.println("Drop Carbs by 25 Grams (100 Calories) and Increase Cardio by One 300 Calories Session.\n");
                                                        //counter++;

                                                        success3 = true;
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Decreased\n");
                                                        boolean success4 = false;
                                                        while (!success4) {
                                                            try {
                                                                System.out.println("More Than 1% Of Your Total Body Weight?");
                                                                System.out.println("\t1. More");
                                                                System.out.println("\t2. Less / About");
                                                                System.out.print("\nAnswer: ");
                                                                int bw = scanner.nextInt();
                                                                scanner.nextLine();

                                                                switch (bw) {
                                                                    case 1 -> {
                                                                        System.out.println("Increase Carbs By 25 Grams (100 Calories)\n");
                                                                        success4 = true;
                                                                    }
                                                                    case 2 -> {
                                                                        System.out.println("Good Job! Keep Macros and Cardio The Same and Re-evaluate The Following Week!.");
                                                                        success4 = true;
                                                                    }
                                                                    default -> throw new IndexOutOfBoundsException();
                                                                }

                                                            } catch (IndexOutOfBoundsException e) {
                                                                System.out.println("Invalid menu input. Please try again.\n");
                                                                System.out.flush();
                                                            } catch (InputMismatchException | IllegalArgumentException e) {
                                                                System.out.println("Invalid menu input. Please try again.\n");
                                                                System.out.flush();
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        success3 = true;
                                                    }
                                                    default -> throw new IndexOutOfBoundsException();
                                                }

                                            } catch (IndexOutOfBoundsException e) {
                                                System.out.println("Invalid menu input. Please try again.\n");
                                                System.out.flush();
                                            } catch (InputMismatchException | IllegalArgumentException e) {
                                                System.out.println("Invalid menu input. Please try again.\n");
                                                System.out.flush();
                                                scanner.nextLine();
                                            }
                                        }
                                        success2 = true;
                                    }
                                    case 2 -> {
                                        System.out.println("Keep Your Macros The Same! Stay Motivated, Plan Ahead, and Hit Your Macros The Next Week!\n");
                                        success2 = true;
                                    }
                                    default -> throw new IndexOutOfBoundsException();
                                }
                                success1 = true;

                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Invalid menu input. Please try again.\n");
                                System.out.flush();
                            } catch (InputMismatchException | IllegalArgumentException e) {
                                System.out.println("Invalid menu input. Please try again.\n");
                                System.out.flush();
                                scanner.nextLine();
                            }
                        }
                        i++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid menu input. Please try again.\n");
                    System.out.flush();

                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.out.println("Invalid menu input. Please try again.\n");
                    System.out.flush();
                    scanner.nextLine();
                }
            }
        }

        public boolean isValidDate (String d){
            String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((CharSequence) d);
            return matcher.matches();
        }
    }
