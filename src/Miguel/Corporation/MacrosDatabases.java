package Miguel.Corporation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
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
    private float activityMultiplier;
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

    public float getActivityMultiplier() {
        return activityMultiplier;
    }

    public void setActivityMultiplier(float activityMultiplier) {
        this.activityMultiplier = activityMultiplier;
    }

    public void activityMultiplier(Scanner scanner) {
        System.out.println("\nChoose your Activity Multiplier that suit you");
        boolean success = false;
        while (!success) {
            try {
                System.out.println("\nFor sedentary plus 3-6 days of weight lifting: 1.3 - 1.6\n" +
                        "For lightly active plus 3-6 days of weight lifting: 1.5 - 1.8\n" +
                        "For active plus 3-6 days of weight lifting: 1.7 - 2.0\n" +
                        "For very active plus 3-6 days of weight lifting: 1.9 - 2.2");
                System.out.print("\nActivity Multiplier (e.g 1.5): ");

                this.setActivityMultiplier(scanner.nextFloat());
                scanner.nextLine();
                success = true;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.\n");

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                System.err.flush();
                scanner.nextLine();
            }
        }
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

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                System.err.flush();
                scanner.nextLine();
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

    public static void readMacrosLog(Scanner scanner){
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
