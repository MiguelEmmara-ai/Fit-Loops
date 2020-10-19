package Miguel.Corporation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Bulking Class</h1>
 * This Class is for Bulking criteria, it will calculate and give result only for bulking using Bulking Algorithm
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public class Bulking extends MacrosDatabases {
    private float calories;
    private float surplusCalories;
    private boolean saveMacros;
    DataBaseUser[] dataBaseUsers = new DataBaseUser[0];

    /**
     * 2-Parameters Constructor
     * @param userName : Get userName From User.
     * @param passWord : Get PassWord From user.
     * @author  Miguel Emmara - 1802146
     */
    public Bulking(String userName, String passWord) {
        super(userName, passWord);
    }

    /**
     * This method is to Save Macros to a txt file
     * @param scanner : Scanner to grab user input.
     * @author  Miguel Emmara - 1802146
     */
    public void saveMacrosMethod(Scanner scanner) throws IOException{
        scanner = new Scanner(new File(getUserName() + " - Account Information.txt"));
        scanner.useDelimiter("[-\n]");

        while (scanner.hasNext()) {
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            String dateOfBirth = scanner.nextLine();
            String weight = scanner.nextLine();
            String height = scanner.nextLine();
            String goalType = scanner.nextLine();
            String userName = scanner.nextLine();
            String passWord = scanner.nextLine();

            // Accept a string
            String str = "\t\t\t### Lean Bulking Macros ###" + "\nName: " + getUserName() + "\n"  + height + "\n"
                    + dateOfBirth + "\nWeight: " + getWeight() + " KG" + "\n\nCalories: "
                    + String.format("%.2f", getSurplusCalories()) + "\nProtein: "
                    + String.format("%.2f", getProteins()) + " Grams of Protein"
                    + "\nFats: " + String.format("%.2f", getFats()) + " Grams of Fats" + "\nCarbs: "
                    + String.format("%.2f", getCarbs()) + " Grams of Carbs";

            // attach a file to FileWriter
            FileWriter fw = new FileWriter(getUserName() + " - Lean Bulking Macros.txt");

            // read character wise from string and write
            // into FileWriter
            for (int i = 0; i < str.length(); i++)
                fw.write(str.charAt(i));
            //close the file
            fw.close();

            DataBaseUser newUser = new DataBaseUser(firstName, lastName, dateOfBirth, weight, height, goalType, userName, passWord);
            dataBaseUsers = addUserData(dataBaseUsers, newUser);
        }
    }

    /**
     * This method is to addUserData to DataBaseUser[]
     * @param DataBaseUser[] : Array of DataBaseUser.
     * @return newUserData
     * @author  Miguel Emmara - 1802146
     */
    private static DataBaseUser[] addUserData(DataBaseUser[] data, DataBaseUser dataToAdd) {
        DataBaseUser[] newUserData = new DataBaseUser[data.length + 1];
        System.arraycopy(data, 0, newUserData, 0, data.length);
        newUserData[newUserData.length - 1] = dataToAdd;

        return newUserData;
    }

    // Getter and setter methods for Object's instance data.
    //------------------------------------------------------------------
    public float getSurplusCalories() {
        return surplusCalories;
    }

    public void setSurplusCalories(float surplusCalories) {
        this.surplusCalories = surplusCalories;
    }
    //------------------------------------------------------------------
    @Override
    public boolean isSaveMacros() {
        return saveMacros;
    }

    @Override
    public void setSaveMacros(boolean saveMacros) {
        this.saveMacros = saveMacros;
    }
    //------------------------------------------------------------------
    @Override
    public float getCalories() {
        return calories;
    }

    @Override
    public void setCalories(float calories) {
        this.calories = calories;
    }
    //------------------------------------------------------------------
    @Override
    public float getActivityMultiplier() {
        return super.getActivityMultiplier();
    }

    @Override
    public void setActivityMultiplier(float activityMultiplier) {
        super.setActivityMultiplier(activityMultiplier);
    }
    //------------------------------------------------------------------
    @Override
    public void activityMultiplier(Scanner scanner) {
        super.activityMultiplier(scanner);
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It will get user information and have an options to save it a txt file
     * @param scanner : Scanner to grab user input.
     * @return none
     * @author  Miguel Emmara - 1802146
     */
    @Override
    public void getInput(Scanner scanner) {
        super.getInput(scanner);
        System.out.println("\n*Note that this will be your Lean Bulking Macros");

        boolean success = false;
        while (!success) {
            try {
                System.out.println("\nWould You Like To Save The Macros");
                System.out.println("\t 1. Yes");
                System.out.println("\t 2. No");
                System.out.print("\nAnswer: ");
                int answer = scanner.nextInt();
                scanner.nextLine();

                switch (answer) {
                    case 1 -> {
                        setSaveMacros(true);
                        if (isSaveMacros()) {
                            saveMacrosMethod(scanner);
                            System.out.println("Macros Saves as " + getUserName() + " - Lean Bulking Macros.txt");
                        }
                        success = true;
                    }
                    case 2 -> {
                        setSaveMacros(false);
                        success = true;
                    }
                    default -> throw new IndexOutOfBoundsException();
                }

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.\n");

            } catch (InputMismatchException e) {
                System.err.println("Invalid menu input. Please try again.\n");
                scanner.next();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It use the Algorithm To Calculate Calories Intake For Bulking
     * Weight * (22(For KG)) or (10(For Pound)) * ActivityMultiplier + 500
     * @return none.
     * @author  Miguel Emmara - 1802146
     */
    @Override
    public void calculateCalories() {
        if (isKg()) {
            this.setCalories(getWeight() * 22 * getActivityMultiplier());
            this.setSurplusCalories(getCalories() + 500);
            String strDouble = String.format("%.0f", getSurplusCalories());
            System.out.println("Calories: " + strDouble);

        } else if (isPound()) {
            this.setCalories(getWeight() * 10 * getActivityMultiplier());
            this.setSurplusCalories(getCalories() + 500);
            String strDouble = String.format("%.0f", getSurplusCalories());
            System.out.println("Calories: " + strDouble);
        }
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It use the Algorithm To Calculate Proteins Intake For Bulking
     * Weight * (2.2(For KG)) or (1(For Pound))
     * @return none.
     * @author  Miguel Emmara - 1802146
     */
    @Override
    public void calculateProtein() {
        if (isKg()) {
            this.setProteins((float) (getWeight() * 2.2));
            String strDouble = String.format("%.2f", getProteins());
            System.out.println("Protein: " + strDouble + " Grams of Protein");

        } else if (isPound()) {
            this.setProteins((getWeight() * 1));
            String strDouble = String.format("%.2f", getProteins());
            System.out.println("Protein: " + strDouble + " Grams of Protein");
        }
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It use the Algorithm To Calculate Fats Intake For Bulking
     * Total calories *  0.25
     * @return none.
     * @author  Miguel Emmara - 1802146
     */
    @Override
    public void calculateFat() {
        if (isKg() || isPound()) {
            float tempCalories = (float) (this.getSurplusCalories() * 0.25);
            this.setFats(tempCalories / 9);
            String strDouble = String.format("%.2f", getFats());
            System.out.println("Fats: " + strDouble + " Grams of Fat.");
        }
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It use the Algorithm To Calculate Carbs Intake For Bulking
     * We have to convert our fats and protein into
     * calories, add them together, then subtract them from our
     * maintenance to find how much carbohydrates we are getting
     * @return none.
     * @author  Miguel Emmara - 1802146
     */
    @Override
    public void calculateCarbs() {
        if (isKg() || isPound()) {
            float tempProteinInCal = this.getProteins() * 4;
            float tempFatInCal = this.getFats() * 9;
            float tempTotalProAndFat = tempProteinInCal + tempFatInCal;
            this.setCarbs((this.getSurplusCalories() - tempTotalProAndFat) / 4);
            String strDouble = String.format("%.0f", getCarbs());
            System.out.println("Carbs: " + strDouble + " Grams of Carbs");
        }
    }
}
