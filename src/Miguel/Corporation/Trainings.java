package Miguel.Corporation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trainings extends ReadingUser implements TrainingPlans {
    //private final Scanner scanner = new Scanner(System.in);

    @Override
    public void getInput(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException {
        boolean quit = true;
        while (quit) {
            try {
                quit = choices(scanner);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid menu input. Please try again.\n");

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.err.println("Invalid menu input. Please try again.");
                System.err.flush();
                scanner.nextLine();
            }
        }
    }

    @Override
    public boolean choices(Scanner scanner) throws IndexOutOfBoundsException, InputMismatchException {
        boolean success;

        System.out.println("\nTraining Plans Day Plan");
        System.out.println("\t1. 3 Days");
        System.out.println("\t2. 5 Days");
        System.out.println("\t3. 6 Days");
        System.out.println("\t4. Quit");

        System.out.print("\nHow many days would you like to consider training?: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                threeDays();
                success = false;
            }
            case 2 -> {
                fiveDays();
                success = false;
            }
            case 3 -> {
                sixDays();
                success = false;
            }
            case 4 -> success = false;
            default -> throw new IndexOutOfBoundsException();
        }
        return success;
    }

    @Override
    public void threeDays() {
        System.out.println("3 Day Training Plan\n");
        System.out.println("\t\t\tMonday Upper body");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.printf("%-22s %31s\n","Seated DB Shoulder Press", "3 Sets | 4-6, 6-8, 8-10");
        System.out.printf("%-22s %27s\n","Lat Pull Down", "2 Sets | 4-6, 6-8");
        System.out.printf("%-22s %28s\n","Weighted Dips", "2 sets | 6-8, 8-10");
        System.out.printf("%-22s %28s\n","Incline Dumbbell Curls", "2 Sets | 6-8, 8-10");
        System.out.printf("%-22s %31s\n","Lateral Raises", "4 Sets | 12 - 15 Reps");

        System.out.println("\n\t\t\tWednesday Lower body");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.printf("%-22s %19s\n","Dumbbell Bulgarian Split Squats", "2 Sets | 6-8, 8-10");
        System.out.printf("%-22s %28s\n","Romanian Dead lifts", "2 Sets | 6-8, 8-10");
        System.out.printf("%-22s %28s\n","Leg Extensions", "2 Sets | 6-8, 8-10");
        System.out.printf("%-22s %28s\n","Calf Raises", "2 sets | 6-8, 8-10");

        System.out.println("\n\t\t\tFriday Upper body");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.printf("%-22s %33s\n","Incline Bench Press", "3 Sets | 4-6, 6-8, 8-10");
        System.out.printf("%-22s %27s\n","Flat Bench Press", "2 Sets | 4-6, 6-8");
        System.out.printf("%-22s %28s\n","Cable Rope Push Downs", "2 sets | 6-8, 8-10");
        System.out.printf("%-22s %28s\n","Hammer Curls", "2 Sets | 6-8, 8-10");
        System.out.printf("%-22s %31s\n","Bent Over Flies", "4 Sets | 12 - 15 Reps");
        System.out.println();

        abProgram();
    }

    @Override
    public void fiveDays() {
        System.out.println("5 Days Training Plan\n");
        System.out.println("\t\t\tMonday Upper Power");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %15s\n","Barbell bench press", "5 X 5");
        System.out.printf("%-22s %15s\n","Bent over rows", "5 X 5");
        System.out.printf("%-22s %15s\n","Overhead press", "5 X 5");
        System.out.printf("%-22s %17s\n","Pull ups", "3 x 6-8");
        System.out.printf("%-22s %17s\n","Dips", "3 x 6-8");

        System.out.println("\n\t\t\tTuesday lower Power");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %15s\n","Squats", "5 X 5");
        System.out.printf("%-22s %15s\n","Dead lifts", "5 X 5");
        System.out.printf("%-22s %18s\n","Hip thrusts", "3 x 8-10");
        System.out.printf("%-22s %18s\n","Leg press", "3 x 8-10");
        System.out.printf("%-22s %18s\n","Hamstring curls", "3 x 8-10");
        System.out.printf("%-22s %17s\n","Standing calves machine", "4 x 8-10");

        System.out.printf("\n%29s","# Wednesday Rest #\n");

        System.out.println("\n\t\t\tThursday Push");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %12s\n","Incline dumbbell bench press", "4 x 8-10");
        System.out.printf("%-22s %10s\n","Seated dumbbell shoulder press", "4 x 8-10");
        System.out.printf("%-22s %17s\n","Machine flat bench press", "3 x 10-12");
        System.out.printf("%-22s %10s\n","Rope triceps overhead extensions", "3 x 10-12 each");
        System.out.printf("%-22s %23s\n","Rope triceps push downs", "3 x 10-12 each");
        System.out.printf("%-22s %18s\n","Dumbbell lateral raises", "3 x 12-15");
        System.out.printf("%-22s %19s\n","Face pulls", "3 x 12-15");

        System.out.println("\n\t\t\tFriday Pull");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %18s\n","Bent over rows", "4 x 8-10");
        System.out.printf("%-22s %18s\n","Pull ups", "3 x 8-10");
        System.out.printf("%-22s %13s\n","Standing dumbbell 1 arm rows", "3 x 12-15");
        System.out.printf("%-22s %16s\n","Close grip lat pull downs", "3 x 12-15");
        System.out.printf("%-22s %19s\n","Dumbbell hammer curls", "4 x 10-12");
        System.out.printf("%-22s %19s\n","Preacher curls", "3 x 12-15");
        System.out.printf("%-22s %16s\n","Dumbbell shrugs", "4 x 10");

        System.out.println("\n\t\t\tSaturday Legs");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %18s\n","Squats", "4 x 8-10");
        System.out.printf("%-22s %18s\n","dead lifts", "2 x 8-10");
        System.out.printf("%-22s %16s\n","Leg press", "3 x 10");
        System.out.printf("%-22s %24s\n","Walking dumbbell lunges", "3 x 10 each leg");
        System.out.printf("%-22s %16s\n","Leg extensions", "3 x 10");
        System.out.printf("%-22s %16s\n","Hamstring curls", "3 x 10");
        System.out.printf("%-22s %19s\n","Seated calves machine", "4 x 12-15");

        System.out.printf("\n%29s","# Sunday Rest #\n");
        System.out.println();

        abProgram();
    }

    @Override
    public void sixDays() {
        System.out.println("6 Days Training Plan\n");
        System.out.println("\t\t\tMonday Upper Power");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %15s\n","Barbell bench press", "5 X 5");
        System.out.printf("%-22s %15s\n","Bent over rows", "5 X 5");
        System.out.printf("%-22s %15s\n","Overhead press", "5 X 5");
        System.out.printf("%-22s %17s\n","Pull ups", "3 x 6-8");
        System.out.printf("%-22s %17s\n","Dips", "3 x 6-8");

        System.out.println("\n\t\t\tTuesday lower Power");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %15s\n","Squats", "5 X 5");
        System.out.printf("%-22s %15s\n","Dead lifts", "5 X 5");
        System.out.printf("%-22s %18s\n","Hip thrusts", "3 x 8-10");
        System.out.printf("%-22s %18s\n","Leg press", "3 x 8-10");
        System.out.printf("%-22s %18s\n","Hamstring curls", "3 x 8-10");
        System.out.printf("%-22s %17s\n","Standing calves machine", "4 x 8-10");

        System.out.printf("\n%29s","# Wednesday Rest #\n");

        System.out.println("\n\t\t\tThursday Push");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %12s\n","Incline dumbbell bench press", "4 x 8-10");
        System.out.printf("%-22s %10s\n","Seated dumbbell shoulder press", "4 x 8-10");
        System.out.printf("%-22s %17s\n","Machine flat bench press", "3 x 10-12");
        System.out.printf("%-22s %10s\n","Rope triceps overhead extensions", "3 x 10-12 each");
        System.out.printf("%-22s %23s\n","Rope triceps push downs", "3 x 10-12 each");
        System.out.printf("%-22s %18s\n","Dumbbell lateral raises", "3 x 12-15");
        System.out.printf("%-22s %19s\n","Face pulls", "3 x 12-15");

        System.out.println("\n\t\t\tFriday Pull");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %18s\n","Bent over rows", "4 x 8-10");
        System.out.printf("%-22s %18s\n","Pull ups", "3 x 8-10");
        System.out.printf("%-22s %13s\n","Standing dumbbell 1 arm rows", "3 x 12-15");
        System.out.printf("%-22s %16s\n","Close grip lat pull downs", "3 x 12-15");
        System.out.printf("%-22s %19s\n","Dumbbell hammer curls", "4 x 10-12");
        System.out.printf("%-22s %19s\n","Preacher curls", "3 x 12-15");
        System.out.printf("%-22s %16s\n","Dumbbell shrugs", "4 x 10");

        System.out.println("\n\t\t\tSaturday Legs");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %18s\n","Squats", "4 x 8-10");
        System.out.printf("%-22s %18s\n","dead lifts", "2 x 8-10");
        System.out.printf("%-22s %16s\n","Leg press", "3 x 10");
        System.out.printf("%-22s %24s\n","Walking dumbbell lunges", "3 x 10 each leg");
        System.out.printf("%-22s %16s\n","Leg extensions", "3 x 10");
        System.out.printf("%-22s %16s\n","Hamstring curls", "3 x 10");
        System.out.printf("%-22s %19s\n","Seated calves machine", "4 x 12-15");

        System.out.println("\n\t\t\tSunday Upper Power");
        System.out.printf("%-22s %21s\n", "EXERCISE", "SETS X REPS");
        System.out.println("============================================");
        System.out.printf("%-22s %15s\n","Barbell bench press", "5 X 5");
        System.out.printf("%-22s %15s\n","Bent over rows", "5 X 5");
        System.out.printf("%-22s %15s\n","Overhead press", "5 X 5");
        System.out.printf("%-22s %17s\n","Pull ups", "3 x 6-8");
        System.out.printf("%-22s %17s\n","Dips", "3 x 6-8");
        System.out.println();

        abProgram();
    }

    @Override
    public void abProgram() {
        System.out.println("\t\t\tAB Program");
        System.out.printf("%-22s %6s\n", "EXERCISE", "SETS X REPS");
        System.out.printf("%-22s %6s\n","Hanging leg raises", "3 x as many reps as possible");
        System.out.printf("%-22s %6s\n","Ball crunches", "3 x as many reps as possible");
        System.out.printf("%-22s %6s\n","Bicycles", "3 x as many reps as possible");
        System.out.println("\n*Ab work can be done on your days off or after you complete your\n" +
                "workouts.");
    }
}