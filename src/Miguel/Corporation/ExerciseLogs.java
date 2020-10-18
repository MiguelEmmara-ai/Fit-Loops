package Miguel.Corporation;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExerciseLogs {
    private int weeks;
    private int days;
    private int numberExercises;
    private final String userName;
    private final ArrayList<String> exerciseList = new ArrayList<>();
    private LocalDate now = LocalDate.now();

    public ExerciseLogs(String userName) {
        this.userName = userName;
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

    public void getInput(Scanner scanner) throws IOException {

        boolean success = false;
        while (!success) {
            try {
                System.out.print("\nHow Many Exercise You Did Today?: ");
                int numberExercise = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numberExercise; i++) {
                    System.out.print("Exercise " + (i + 1) + " Name: ");
                    exerciseList.add(scanner.nextLine());
                }

                String fileName = getUserName() + " (" + now.toString() + ") - Exercise Log.csv";
                File file = new File(fileName);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Exercise Name");
                bw.newLine();
                for (int i = 0; i < exerciseList.size(); i++) {
                    bw.write(exerciseList.get(i));
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
            int i;
            boolean success = false;
            while (!success) {
                try {
                    System.out.print("\nPlease Enter Your Options: ");
                    i = scanner.nextInt();
                    if (i >= arrayLists.size() && i <= arrayLists.size()) {
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
        }
    }
}
