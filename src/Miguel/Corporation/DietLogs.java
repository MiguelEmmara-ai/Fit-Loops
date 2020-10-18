package Miguel.Corporation;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * <h1>DieLogs Class</h1>
 * This Class integrates for 2 functionality, to read and create a daily logs
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public class DietLogs {
    private final String userName;
    private List<List<String>> rows;
    private List<String> list;
    private LocalDate now;

    /**
     * Default Constructor
     * @param userName : Get userName From User.
     * @author  Miguel Emmara - 1802146
     */
    public DietLogs(String userName) {
        this.userName = userName;
        this.list = new ArrayList<>();
        this.now = LocalDate.now();
    }

    // Getter method for Object's instance data.
    //------------------------------------------------------------------
    public String getUserName() {
        return userName;
    }
    //------------------------------------------------------------------

    /**
     * This will get user information and will save it a csv file
     * @param scanner : Scanner to grab user input.
     * @return none
     * @author  Miguel Emmara - 1802146
     */
    public void getInput(Scanner scanner) throws IOException {
        System.out.print("\nCalories: ");
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

        System.out.println("\nYour Daily Diet Log Has Been Saved as \"" + fileName + "\"");
    }

    /**
     * This will display File Names Available (csv) for user to read it in the console
     * @param scanner : Scanner to grab user input.
     * @return none
     * @author  Miguel Emmara - 1802146
     */
    public void readDietLog(Scanner scanner) throws IOException {
        File directoryPath = new File(System.getProperty("user.dir"));

        // List text files only
        System.out.println("\n----------- File Names Available -----------");
        File[] files = directoryPath.listFiles(new FilenameFilter() {
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
            int i;
            boolean success = false;
            while (!success) {
                try {
                    System.out.print("\nPlease Enter Your Options: ");
                    i = scanner.nextInt();
                    if (i <= arrayLists.size()) {
                        System.out.println();
                        try {
                            System.out.println("Calories          Carbs (Grams)   Fats (Grams)   Protein (Grams)     Average Body Weight");
                            String pathToCsv = arrayLists.get(i - 1);
                            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
                            String row;
                            while ((row = csvReader.readLine()) != null) {
                                String[] data = row.split(",");
                                String joined = String.join("", data);
                                System.out.println(Arrays
                                        .toString(data)
                                        .replace("[", "")
                                        .replace("]", "")
                                        .replace(",", "             ")
                                        .replace("Calories", "")
                                        .replace("Carbs (Grams)", "")
                                        .replace("Fats (Grams)", "")
                                        .replace("Protein (Grams)", "")
                                        .replace("Average Body Weight", ""));
                            }
                            csvReader.close();
                            success = true;
                        } catch (FileNotFoundException e) {
                            System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                                    "You Can Create one Within The Main Menu Options 5");
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Error, The System Only Read " + arrayLists.size() + " Files");
                        scanner.nextLine();
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("Invalid menu input. Please try again.\n");

                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.err.println("Invalid menu input. Please try again.");
                    System.err.flush();
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                    "You Can Create one Within The Main Menu Options 5");
        }
    }
}