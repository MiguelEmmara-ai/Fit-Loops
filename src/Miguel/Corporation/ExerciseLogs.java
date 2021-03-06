package Miguel.Corporation;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Exercise Class</h1>
 * This Class integrates for 2 functionality, to read and create a daily exercises logs
 *
 * @author Miguel Emmara - 18021466
 * @version 1.0
 * @since 10/10/2020
 */
public class ExerciseLogs {
    private final String userName;
    private final ArrayList<String> exerciseList;
    private int numberExercises;
    private final LocalDate now;

    /**
     * Default Constructor
     *
     * @param userName : Get userName From User.
     * @author Miguel Emmara - 18021466
     */
    public ExerciseLogs(String userName) {
        this.userName = userName;
        this.exerciseList = new ArrayList<>();
        this.now = LocalDate.now();
    }

    // Getter and setter methods for Object's instance data.
    //------------------------------------------------------------------
    public int getNumberExercises() {
        return numberExercises;
    }

    public void setNumberExercises(int numberExercises) {
        this.numberExercises = numberExercises;
    }

    public String getUserName() {
        return userName;
    }
    //------------------------------------------------------------------

    /**
     * This will get user information and will save it a csv file
     *
     * @param scanner : Scanner to grab user input.
     * @return none
     * @author Miguel Emmara - 18021466
     */
    public void getInput(Scanner scanner) throws IOException {

        boolean success = false;
        while (!success) {
            try {
                System.out.print("\nHow Many Exercise You Did Today?: ");
                setNumberExercises(scanner.nextInt());
                scanner.nextLine();
                for (int i = 0; i < getNumberExercises(); i++) {
                    System.out.print("Exercise " + (i + 1) + " Name: ");
                    exerciseList.add(scanner.nextLine());
                }

                String fileName = getUserName() + " (" + now.toString() + ") - Exercise Log.csv";
                File file = new File(fileName);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Exercise Name");
                bw.newLine();
                for (String s : exerciseList) {
                    bw.write(s);
                    bw.newLine();
                }
                System.out.println("\nYour Daily Exercise Log Has Been Saved as \"" + fileName + "\"");

                bw.close();
                fw.close();
                success = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid menu input. Please try again.");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid menu input. Please try again.");
                scanner.nextLine();
            }
        }

    }

    /**
     * This will display File Names Available (csv) for user to read it in the console
     *
     * @param scanner : Scanner to grab user input.
     * @return none
     * @author Miguel Emmara - 18021466
     */
    public void readExerciseLog(Scanner scanner) throws IOException {
        File directoryPath = new File(System.getProperty("user.dir"));
        // List text files only
        System.out.println("\n----------- File Names Available -----------");
        File[] files = directoryPath.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("Exercise Log.csv");
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

            // Allow user to choose the files numbers, and get retrieve the file name from arraylists
            int i;
            boolean success = false;
            while (!success) {
                try {
                    System.out.print("\nPlease Enter Your Options: ");
                    i = scanner.nextInt();
                    if (i <= arrayLists.size()) {
                        System.out.println();
                        try {
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
                                        .replace(",", "             "));
                            }
                            csvReader.close();
                            success = true;
                        } catch (FileNotFoundException e) {
                            System.out.println("Error, The System Cannot Find Any Saved Macros Log, " +
                                    "You Can Create one Within The Main Menu Options 6");
                            e.printStackTrace();
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println("Invalid menu input. Please try again.\n");

                        } catch (InputMismatchException | IllegalArgumentException e) {
                            System.err.println("Invalid menu input. Please try again.");
                            System.err.flush();
                            scanner.nextLine();
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
                    "You Can Create one Within The Main Menu Options 6");
        }
    }
}
