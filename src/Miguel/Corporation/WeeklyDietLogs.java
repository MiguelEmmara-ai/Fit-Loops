package Miguel.Corporation;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class WeeklyDietLogs {
    private int weeks;
    private final String userName;
    private final ArrayList<String> macrosDatabasesArrayList;
    private List<List<String>> rows;
    private List<String> list = new ArrayList<>();
    private LocalDate now = LocalDate.now();

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

    public void getInput(Scanner scanner) throws IOException {
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

        rows = Arrays.asList(Arrays.asList(calories, protein, fats, carbs, averageBodyWeight));
        String fileName = getUserName() + " (" + now.toString() + ") - Diet Log.csv";

        FileWriter csvWriter = new FileWriter(fileName);
        csvWriter.append("Calories");
        csvWriter.append(",");
        csvWriter.append("Carbs (Grams)");
        csvWriter.append(",");
        csvWriter.append("Fats (Grams)");
        csvWriter.append(",");
        csvWriter.append("Protein (Grams)");
        csvWriter.append(",");
        csvWriter.append("Average Body Weight");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData).replace("Weeks", ""));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();

        ////////////////
        /*int counter = 1;

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
            for (int i = 0; i < getWeeks(); i++) {
                rows = Arrays.asList(Arrays.asList("1",calories,protein,fats,carbs,averageBodyWeight));

                FileWriter csvWriter = new FileWriter("Weekly Diet Log - " + getUserName() + ".csv");
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
        }*/
        ////////////////
        //rows = Arrays.asList(Arrays.asList("1",calories,protein,fats,carbs,averageBodyWeight));

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

        System.out.println("\nYour Daily Diet Log Has Been Saved as \"" + fileName + "\"");
    }

    public void readDietLog(Scanner scanner) throws IOException {
        File directoryPath = new File(System.getProperty("user.dir"));
        // List text files only
        System.out.println("\n----------- File Names Available -----------");
        File[] files=directoryPath.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("Diet Log.csv");
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
            System.out.println("\nArray List");
            int i;
            for (i = 0; i < arrayLists.size(); i++)
                System.out.print((i+1) + ". " + arrayLists.get(i) + "\n");

            System.out.print("\nPlease Enter Your Options: ");
            i = scanner.nextInt();
            if (i <= arrayLists.size()) {
                System.out.println(i);
                System.out.print(arrayLists.get(i-1) + "\n");
                try {
                    System.out.println("Calories          Carbs (Grams)   Fats (Grams)   Protein (Grams)     Average Body Weight");
                    String pathToCsv = arrayLists.get(i-1);
                    BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
                    String row;
                    while ((row = csvReader.readLine()) != null) {
                        String[] data = row.split(",");
                        String joined = String.join("", data);
                        System.out.println(Arrays
                                .toString(data)
                                .replace("[","")
                                .replace("]","")
                                .replace(",","             ")
                                .replace("Calories","")
                                .replace("Carbs (Grams)", "")
                                .replace("Fats (Grams)", "")
                                .replace("Protein (Grams)", "")
                                .replace("Average Body Weight",""));
                    }
                    csvReader.close();
                }catch (FileNotFoundException e) {
                    System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                            "You Can Create one Within The Main Menu Options 5");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                    "You Can Create one Within The Main Menu Options 5");
        }
    }
}
