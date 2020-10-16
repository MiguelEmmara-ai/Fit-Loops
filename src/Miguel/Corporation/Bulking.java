package Miguel.Corporation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bulking extends MacrosDatabases {
    private float calories;
    private float surplusCalories;
    private float activityMultiplier;
    private boolean saveMacros;
    private final Scanner scanner = new Scanner(System.in);

    public Bulking(String userName, String password) {
        super(userName, password);
    }

    public void saveMacrosMethod() throws IOException{
        // Accept a string
        String str = "\t\t\t### Lean Bulking Macros ###" + "\nName: " + getUserName() + "\nHeight: " + "CM" + "\nAge: "
                + "\nWeight: " + getWeight() + " KG" + "\n\nCalories: " + String.format("%.2f", getSurplusCalories())
                + "\nProtein: " + String.format("%.2f", getProteins()) + " Grams of Protein" + "\nFats: "
                + String.format("%.2f", getFats()) + " Grams of Fats" + "\nCarbs: " + String.format("%.2f", getCarbs())
                + " Grams of Carbs";

        // attach a file to FileWriter
        FileWriter fw = new FileWriter("Lean Bulking Macros - " + getUserName() + ".txt");

        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < str.length(); i++)
            fw.write(str.charAt(i));
        //close the file
        fw.close();
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
    public float getCalories() {
        return calories;
    }

    @Override
    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getSurplusCalories() {
        return surplusCalories;
    }

    public void setSurplusCalories(float surplusCalories) {
        this.surplusCalories = surplusCalories;
    }

    public float getActivityMultiplier() {
        return activityMultiplier;
    }

    @Override
    public void setActivityMultiplier(float activityMultiplier) {
        this.activityMultiplier = activityMultiplier;
    }

    @Override
    public void getInput() {
        super.getInput();
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
                            saveMacrosMethod();
                            System.out.println("Macros Saves as \"Lean Bulking Macros - " + getUserName() + ".txt\"");
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

    @Override
    public void activityMultiplier() {
        super.activityMultiplier();
    }

    @Override
    public void calculateCalories() {
        if (isKg()) {
            this.setCalories(getWeight() * 22 * MacrosDatabases.getActivityMultiplier(getActivityMultiplier()));
            this.setSurplusCalories(getCalories() + 500);
            String strDouble = String.format("%.0f", getSurplusCalories());
            System.out.println("Calories: " + strDouble);

        } else if (isPound()) {
            this.setCalories(getWeight() * 10 * MacrosDatabases.getActivityMultiplier(getActivityMultiplier()));
            this.setSurplusCalories(getCalories() + 500);
            String strDouble = String.format("%.0f", getSurplusCalories());
            System.out.println("Calories: " + strDouble);
        }
        //super.calculateCalories();
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
            float tempCalories = (float) (this.getSurplusCalories() * 0.25);
            this.setFats(tempCalories / 9);
            String strDouble = String.format("%.2f", getFats());
            System.out.println("Fats: " + strDouble + " Grams of Fat.");

        } else if (isPound()) {
            float tempCalories = (float) (this.getSurplusCalories() * 0.25);
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
            this.setCarbs((this.getSurplusCalories() - tempTotalProAndFat) / 4);
            String strDouble = String.format("%.0f", getCarbs());
            System.out.println("Carbs: " + strDouble + " Grams of Carbs");

        } else if (isPound()){
            float tempProteinInCal = this.getProteins() * 4;
            float tempFatInCal = this.getFats() * 9;
            float tempTotalProAndFat = tempProteinInCal + tempFatInCal;
            this.setCarbs((this.getSurplusCalories() - tempTotalProAndFat) / 4);
            String strDouble = String.format("%.0f", getCarbs());
            System.out.println("Carbs: " + strDouble  + " Grams of Carbs");
        }
        //super.calculateCarbs();
    }
}
