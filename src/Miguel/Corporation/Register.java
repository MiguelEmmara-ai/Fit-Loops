package Miguel.Corporation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Register {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private float weight;
    private float height;
    private String userName;
    private String passWords;
    private GoalType goalType;

    public Register() {
    }

    public Register(String firstName, String lastName, LocalDate dateOfBirth, float weight, float height,
                    GoalType goalType, String userName, String passWords) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setWeight(weight);
        setHeight(height);
        setGoalType(goalType);
        setUserName(userName);
        setPassWords(passWords);
    }

    public Register(String firstName, String lastName, String dateOfBirth, float weight, float height,
                    GoalType goalType, String userName, String passWords) {
        setFirstName(firstName);
        setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        setWeight(weight);
        setHeight(height);
        setGoalType(goalType);
        setUserName(userName);
        setPassWords(passWords);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWords() {
        return passWords;
    }

    public void setPassWords(String passWords) {
        this.passWords = passWords;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyy"));
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public void createUserAccountInformation() throws IOException {
        // Accept a string
        String str = "First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nDate Of Birth: "
                + getDateOfBirth() + "\nWeight: " + getWeight() + "\nHeight: " + getHeight() + " CM" + "\nGoal Type: " + getGoalType() + "\nUserName: "
                + getUserName() + "\nPassword: " + getPassWords();

        // attach a file to FileWriter
        FileWriter fw = new FileWriter(getUserName() + " - Account Information.txt");

        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < str.length(); i++)
            fw.write(str.charAt(i));
        //close the file
        fw.close();
    }

    public void addNewMembers(String fileName, String str) {
        try {
            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }

}
