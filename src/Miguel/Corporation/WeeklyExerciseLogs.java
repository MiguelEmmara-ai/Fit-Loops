package Miguel.Corporation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyExerciseLogs {
    private int weeks;
    private int days;
    private int numberExercises;
    private final String userName;
    private final ArrayList<String> exerciseList;
    private static final Scanner scanner = new Scanner(System.in);

    public WeeklyExerciseLogs(String userName) {
        this.userName = userName;
        this.exerciseList = new ArrayList<>(numberExercises);
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNumberExercises() {
        return numberExercises;
    }

    public void setNumberExercises(int numberExercises) {
        this.numberExercises = numberExercises;
    }

    public String getUserName() {
        return userName;
    }

    public void getInput() throws IOException {
        System.out.print("\nHow Many Weeks Would You Like To Create A Log (eg. 10): ");
        setWeeks(scanner.nextInt());
        scanner.nextLine();
        System.out.print("How Many Training Days in a week (eg. 5): ");
        setDays(scanner.nextInt());
        scanner.nextLine();

        for (int i = 0; i < getWeeks(); i++) {
            System.out.println("\nWeeks " + (i+1));
            for (int j = 0; j < getDays(); j++) {
                System.out.println("Days " + (j+1));
                System.out.print("How Many Exercise: ");
                setNumberExercises(scanner.nextInt());
                scanner.nextLine();
                for (int k = 0; k < getNumberExercises(); k++) {
                    System.out.println("Exercise " + (k+1) + " Name: ");
                    exerciseList.add(scanner.nextLine());
                }
            }
        }

        // Printing the array
        for (int i = 0; i < getWeeks(); i++) {
            System.out.println("\nWeeks " + (i+1));
            for (int j = 0; j < getDays(); j++) {
                System.out.println("Days " + (j+1));
                System.out.println("Workout");
                for (int k = 0; k < exerciseList.size(); k++) {
                    System.out.print(exerciseList.get(i) + "\n");
                }
                System.out.println();
            }
        }

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("Weekly Exercise Log - " + getUserName() + ".txt"));
        for (int i = 0; i < getWeeks(); i++) {
            outputWriter.write("Weeks " + (i+1));
            for (int j = 0; j < getDays(); j++) {
                outputWriter.write("\nDays " + (j+1));
                outputWriter.write("\nWorkout");
                for (int k = 0; k < exerciseList.size(); k++) {
                    outputWriter.write("\n"+ exerciseList.get(i));
                }
                outputWriter.newLine();
            }
        }
        outputWriter.flush();
        outputWriter.close();

        System.out.println("Your " + getWeeks() + " Exercise Log Has Been Saved as \"Weekly Diet Log - " + getUserName() + ".txt\"");
    }
}
