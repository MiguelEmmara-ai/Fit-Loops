package Miguel.Corporation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyDietLogs {
    private int weeks;
    private final String userName;
    private final ArrayList<String> macrosDatabasesArrayList;
    private static final Scanner scanner = new Scanner(System.in);

    public WeeklyDietLogs(String userName) {
        this.userName = userName;
        this.macrosDatabasesArrayList = new ArrayList<>(weeks);
    }

    public void getInput() throws IOException {
        System.out.print("\nWeeks: ");
        weeks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < weeks; i++) {
            System.out.println("\nWeek " + (i+1));
            System.out.print("Calories: ");
            float calories = scanner.nextFloat();
            macrosDatabasesArrayList.add("Calories: " + calories);
            System.out.print("Protein (Grams): ");
            float proteins = scanner.nextFloat();
            macrosDatabasesArrayList.add("Protein: " + proteins);
            System.out.print("Fats (Grams): ");
            float fats = scanner.nextFloat();
            macrosDatabasesArrayList.add("Fats: " + fats);
            System.out.print("Carbs (Grams): ");
            float carbs = scanner.nextFloat();
            macrosDatabasesArrayList.add("Carbs: " + carbs);
            System.out.print("Your Weekly Average (KG): ");
            float weeklyAverage = scanner.nextFloat();
            macrosDatabasesArrayList.add("Weekly Average Weight: " + weeklyAverage);
        }

        System.out.println();
        for (int i = 0; i < weeks; i++) {
            System.out.println("Week " + (i+1) + "\n");
            for (int j = 0; j < macrosDatabasesArrayList.size(); j++) {
                System.out.println(macrosDatabasesArrayList.get(j) + " ");
            }
            System.out.println();
        }

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("Weekly Diet Log - " + userName + ".txt"));
        for (int i = 0; i < weeks; i++) {
            outputWriter.write("Weeks " + (i+1) + "\n");
            for (int j = 0; j < macrosDatabasesArrayList.size(); j++) {
                outputWriter.write(macrosDatabasesArrayList.get(j));
                outputWriter.newLine();
            }
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();

        System.out.println("\nYour " + weeks + " Weeks Diet Log Has Been Saved as \"Weekly Diet Log - " + userName + ".txt\"");
    }
}
