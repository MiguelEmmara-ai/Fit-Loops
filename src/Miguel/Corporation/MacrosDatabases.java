package Miguel.Corporation;

import java.io.File;
import java.io.FilenameFilter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MacrosDatabases extends Login implements Calculators {
    private float weight;
    private float proteins;
    private float fats;
    private float carbs;
    private float calories;
    private boolean kg;
    private boolean pound;
    private boolean saveMacros = false;

    public MacrosDatabases(String userName, String password) {
        super(userName, password);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public boolean isKg() {
        return kg;
    }

    public void setKg(boolean kg) {
        this.kg = kg;
    }

    public boolean isPound() {
        return pound;
    }

    public void setPound(boolean pound) {
        this.pound = pound;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public static float getActivityMultiplier(float activityMultiplier) {
        return activityMultiplier;
    }

    public void setActivityMultiplier(float activityMultiplier) {
    }

    public void activityMultiplier(Scanner scanner) {
        System.out.println("\nChoose your Activity Multiplier that suit you");
        System.out.println("\nFor sedentary plus 3-6 days of weight lifting: 1.3 - 1.6\n" +
                "For lightly active plus 3-6 days of weight lifting: 1.5 - 1.8\n" +
                "For active plus 3-6 days of weight lifting: 1.7 - 2.0\n" +
                "For very active plus 3-6 days of weight lifting: 1.9 - 2.2");
        System.out.print("\nActivity Multiplier (e.g 1.5): ");

        this.setActivityMultiplier(scanner.nextFloat());
        scanner.nextLine();
    }

    public boolean isSaveMacros() {
        return saveMacros;
    }

    public void setSaveMacros(boolean saveMacros) {
        this.saveMacros = saveMacros;
    }

    public void getInput(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException {
        boolean success = false;
        int choice;

        while (!success) {
            try {
                System.out.println("Choose between KG or Pound");
                System.out.println("\t 1. KG");
                System.out.println("\t 2. Pound");
                System.out.print("\nEnter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        setPound(false);
                        setKg(true);
                        System.out.print("Enter you Body Weight in KG: ");
                        this.setWeight(scanner.nextFloat());
                        scanner.nextLine();

                        activityMultiplier(scanner);
                        success = true;
                    }
                    case 2 -> {
                        setKg(false);
                        setPound(true);
                        System.out.print("Enter you Body Weight in Pound: ");
                        this.setWeight(scanner.nextFloat());
                        scanner.nextLine();

                        activityMultiplier(scanner);
                        success = true;
                    }
                    default -> throw new IndexOutOfBoundsException();
                }

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.\n");

            } catch (InputMismatchException e) {
                System.err.println("Invalid menu input. Please try again.\n");
                scanner.next();
            }
        }

        System.out.println();
        calculateCalories();
        calculateProtein();
        calculateFat();
        calculateCarbs();

        /*while (isSaveMacros()) {
            try {
                System.out.println("Would You Like To Save The Macros");
                System.out.println("\t 1. Yes");
                System.out.println("\t 2. No");
                System.out.print("\nAnswer: ");
                int answer = scanner.nextInt();
                scanner.nextLine();

                switch (answer) {
                    case 1 -> {
                        System.out.println("Macros Saves as \"Maintenance Macros - Maintenance Macros - Miguel.txt\"");
                        setSaveMacros(true);
                    }
                    case 2 -> {
                        setSaveMacros(false);
                    }
                    default -> throw new IndexOutOfBoundsException();
                }

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.\n");

            } catch (InputMismatchException e) {
                System.err.println("Invalid menu input. Please try again.\n");
                scanner.next();
            }
        }*/
    }

    @Override
    public void calculateCalories() {

    }

    @Override
    public void calculateProtein() {

    }

    @Override
    public void calculateFat() {

    }

    @Override
    public void calculateCarbs() {

    }
}
