package Miguel.Corporation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Maintenance extends MacrosDatabases {
    private float calories;
    private boolean saveMacros;
    DataBaseUser[] dataBaseUsers = new DataBaseUser[0];

    public Maintenance(String userName, String password) {
        super(userName, password);
    }

    public void saveMacrosMethod(Scanner scanner) throws IOException {
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
            String passWords = scanner.nextLine();

            // Accept a string
            String str = "\t\t\t### Maintenance Macros ###" + "\nName: " + getUserName() + "\n"  + height + "\n"
                    + dateOfBirth + "\nWeight: " + getWeight() + " KG" + "\n\nCalories: " + String.format("%.2f", getCalories())
                    + "\nProtein: " + String.format("%.2f", getProteins()) + " Grams of Protein" + "\nFats: "
                    + String.format("%.2f", getFats()) + " Grams of Fats" + "\nCarbs: " + String.format("%.2f", getCarbs())
                    + " Grams of Carbs";

            // attach a file to FileWriter
            FileWriter fw = new FileWriter(getUserName() + " - Maintenance Macros.txt");

            // read character wise from string and write
            // into FileWriter
            for (int i = 0; i < str.length(); i++)
                fw.write(str.charAt(i));
            //close the file
            fw.close();

            DataBaseUser newUser = new DataBaseUser(firstName, lastName, dateOfBirth, weight, height, goalType, userName, passWords);
            dataBaseUsers = addUserData(dataBaseUsers, newUser);
        }
    }

    private static DataBaseUser[] addUserData(DataBaseUser[] products, DataBaseUser productToAdd) {
        DataBaseUser[] newUserData = new DataBaseUser[products.length + 1];
        System.arraycopy(products, 0, newUserData, 0, products.length);
        newUserData[newUserData.length - 1] = productToAdd;

        return newUserData;
    }

    @Override
    public float getCalories() {
        return calories;
    }

    @Override
    public void setCalories(float calories) {
        this.calories = calories;
    }

    @Override
    public boolean isSaveMacros() {
        return saveMacros;
    }

    @Override
    public void setSaveMacros(boolean saveMacros) {
        this.saveMacros = saveMacros;
    }

    @Override
    public float getActivityMultiplier() {
        return super.getActivityMultiplier();
    }

    @Override
    public void setActivityMultiplier(float activityMultiplier) {
        super.setActivityMultiplier(activityMultiplier);
    }

    @Override
    public void activityMultiplier(Scanner scanner) {
        super.activityMultiplier(scanner);
    }

    @Override
    public void getInput(Scanner scanner) {
        super.getInput(scanner);
        System.out.println("\n*Note that this will be your Maintenance Macros");

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
                            System.out.println("Macros Saves as " + getUserName() + " - Maintenance Macros.txt");
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

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                System.err.flush();
                scanner.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void calculateCalories() {
        if (isKg()) {
            this.setCalories(getWeight() * 22 * getActivityMultiplier());
            String strDouble = String.format("%.0f", getCalories());
            System.out.println("Calories: " + strDouble);

        } else if (isPound()) {
            this.setCalories(getWeight() * 10 * getActivityMultiplier());
            String strDouble = String.format("%.0f", getCalories());
            System.out.println("Calories: " + strDouble);
        }
    }

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

    @Override
    public void calculateFat() {
        if (isKg()) {
            float tempCalories = (float) (this.getCalories() * 0.25);
            this.setFats(tempCalories / 9);
            String strDouble = String.format("%.2f", getFats());
            System.out.println("Fats: " + strDouble + " Grams of Fat.");

        } else if (isPound()) {
            float tempCalories = (float) (this.getCalories() * 0.25);
            this.setFats(tempCalories / 9);
            String strDouble = String.format("%.2f", getFats());
            System.out.println("Fats: " + strDouble + " Grams of Fat.");
        }
    }

    @Override
    public void calculateCarbs() {
        if (isKg()) {
            float tempProteinInCal = this.getProteins() * 4;
            float tempFatInCal = this.getFats() * 9;
            float tempTotalProAndFat = tempProteinInCal + tempFatInCal;
            this.setCarbs((this.getCalories() - tempTotalProAndFat) / 4);
            String strDouble = String.format("%.0f", getCarbs());
            System.out.println("Carbs: " + strDouble + " Grams of Carbs");

        } else if (isPound()){
            float tempProteinInCal = this.getProteins() * 4;
            float tempFatInCal = this.getFats() * 9;
            float tempTotalProAndFat = tempProteinInCal + tempFatInCal;
            this.setCarbs((this.getCalories() - tempTotalProAndFat) / 4);
            String strDouble = String.format("%.0f", getCarbs());
            System.out.println("Carbs: " + strDouble  + " Grams of Carbs");
        }
    }
}
