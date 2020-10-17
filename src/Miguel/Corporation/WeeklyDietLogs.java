package Miguel.Corporation;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class WeeklyDietLogs {
    private int weeks;
    private final String userName;
    private final ArrayList<String> macrosDatabasesArrayList;
    private List<List<String>> rows = new ArrayList<List<String>>();
    private List<String> list = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public WeeklyDietLogs(String userName) {
        this.userName = userName;
        this.macrosDatabasesArrayList = new ArrayList<>(weeks);
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public String getUserName() {
        return userName;
    }

    public void getInput() throws IOException {
        int counter = 1;

        System.out.print("\nWeeks: ");
        setWeeks(scanner.nextInt());
        scanner.nextLine();
        String weeks = convertFloatToString(getWeeks());

        for (int j = 0; j < getWeeks(); j++) {
            List<String> list = new ArrayList<>();

            System.out.println("Weeks " + counter);

            System.out.print("Calories: ");
            String calories;
            list.add(calories = scanner.nextLine());

            System.out.print("Protein (Grams): ");
            String protein;
            list.add(protein = scanner.nextLine());

            System.out.print("Fats (Grams): ");
            String fats;
            list.add(fats = scanner.nextLine());

            System.out.print("Carbs (Grams): ");
            String carbs;
            list.add(carbs = scanner.nextLine());

            System.out.print("Your Weekly Average (KG): ");
            String averageBodyWeight;
            list.add(averageBodyWeight = scanner.nextLine());

            rows.add(list);
            System.out.println("List " + (j + 1) + " is created");
            System.out.println(rows.get(j).toString().replace("[", "").replace("]", ""));
            System.out.println("");
            counter++;
        }
        //rows = Arrays.asList(Arrays.asList("1",calories,protein,fats,carbs,averageBodyWeight));
        for (int i = 0; i < getWeeks(); i++) {
            rows = Collections.singletonList(new LinkedList<String>(Arrays.asList(weeks,rows.get(i).toString().replace("[", "").replace("]", ""))));

            FileWriter csvWriter = new FileWriter("new.csv");
            csvWriter.append("Weeks");
            csvWriter.append(",");
            csvWriter.append("Calories");
            csvWriter.append(",");
            csvWriter.append("Carbs");
            csvWriter.append(",");
            csvWriter.append("Fats");
            csvWriter.append(",");
            csvWriter.append("Protein");
            csvWriter.append(",");
            csvWriter.append("Average Body Weight");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData).replace("Weeks", ""));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        }

        /*for (int j = 0; j < getWeeks(); j++) {
            System.out.println("\nWeek " + (j+1));

            System.out.print("Calories: ");
            float calories = scanner.nextFloat();
            scanner.nextLine();
            String caloriesString = convertFloatToString(calories);
            rows.add(Collections.singletonList(caloriesString));

            System.out.print("Protein (Grams): ");
            float proteins = scanner.nextFloat();
            scanner.nextLine();
            String proteinString = convertFloatToString(proteins);
            rows.add(Collections.singletonList(proteinString));

            System.out.print("Fats (Grams): ");
            float fats = scanner.nextFloat();
            scanner.nextLine();
            String fatsString = convertFloatToString(fats);
            rows.add(Collections.singletonList(fatsString));

            System.out.print("Carbs (Grams): ");
            float carbs = scanner.nextFloat();
            scanner.nextLine();
            String carbsString = convertFloatToString(carbs);
            rows.add(Collections.singletonList(caloriesString));

            System.out.print("Your Weekly Average (KG): ");
            float weeklyAverage = scanner.nextFloat();
            scanner.nextLine();
            String weeklyAverageString = convertFloatToString(weeklyAverage);
            rows.add(Collections.singletonList(weeklyAverageString));*/

            /*for (int k = 0; k < getWeeks(); k++) {
                rows = Arrays.asList(Arrays.asList(weeksString, caloriesString, carbsString, fatsString, proteinString, weeklyAverageString));

                FileWriter csvWriter = new FileWriter("new.csv");
                csvWriter.append("Weeks");
                csvWriter.append(",");
                csvWriter.append("Calories");
                csvWriter.append(",");
                csvWriter.append("Carbs");
                csvWriter.append(",");
                csvWriter.append("Fats");
                csvWriter.append(",");
                csvWriter.append("Protein");
                csvWriter.append(",");
                csvWriter.append("Average Body Weight");
                csvWriter.append("\n");

                for (List<String> rowData : rows) {
                    csvWriter.append(String.join(",", rowData).replace("Weeks",""));
                    csvWriter.append("\n");
                }
                csvWriter.flush();
                csvWriter.close();
            }*/

        /*System.out.println("Weeks     Calories    Carbs       Fats       Protein     Average Body Weight");
        String pathToCsv = "new.csv";
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            String joined = String.join("", data);
            System.out.println(Arrays.toString(data).replace("[","").replace("]","")
                    .replace(",","      ").replace("Weeks","")
                    .replace("Calories","").replace("Carbs", "")
                    .replace("Fats", "").replace("Protein", "")
                    .replace("Average Body Weight",""));
        }
        csvReader.close();*/

        /*for (int i = 0; i < getWeeks(); i++) {
            System.out.println("\nWeek " + (i+1));
            System.out.print("Calories: ");
            float calories = scanner.nextFloat();
            scanner.nextLine();
            macrosDatabasesArrayList.add("Calories: " + calories);
            System.out.print("Protein (Grams): ");
            float proteins = scanner.nextFloat();
            scanner.nextLine();
            macrosDatabasesArrayList.add("Protein: " + proteins);
            System.out.print("Fats (Grams): ");
            float fats = scanner.nextFloat();
            scanner.nextLine();
            macrosDatabasesArrayList.add("Fats: " + fats);
            System.out.print("Carbs (Grams): ");
            float carbs = scanner.nextFloat();
            scanner.nextLine();
            macrosDatabasesArrayList.add("Carbs: " + carbs);
            System.out.print("Your Weekly Average (KG): ");
            float weeklyAverage = scanner.nextFloat();
            scanner.nextLine();
            macrosDatabasesArrayList.add("Weekly Average Weight: " + weeklyAverage);
        }

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("Weekly Diet Log - " + getUserName() + ".txt"));
        for (int i = 0; i < getWeeks(); i++) {
            outputWriter.write("Weeks " + (i+1) + "\n");
            for (int j = 0; j < macrosDatabasesArrayList.size(); j++) {
                outputWriter.write(macrosDatabasesArrayList.get(j));
                outputWriter.newLine();
            }
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();*/

        System.out.println("\nYour " + getWeeks() + " Weeks Diet Log Has Been Saved as \"Weekly Diet Log - " + getUserName() + ".txt\"");
    }

    public String convertFloatToString(float floatValue) {
        return ("" + floatValue);
    }
}
