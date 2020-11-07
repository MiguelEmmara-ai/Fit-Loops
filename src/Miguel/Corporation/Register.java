package Miguel.Corporation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <h1>Register Class</h1>
 * Store information that needs for user to register
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public class Register {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private float weight;
    private float height;
    private String userName;
    private String passWord;
    private GoalType goalType;

    /**
     * 8-Parameters Constructor
     * @author  Miguel Emmara - 1802146
     */
    public Register(String firstName, String lastName, LocalDate dateOfBirth, float weight, float height,
                    GoalType goalType, String userName, String passWord) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setWeight(weight);
        setHeight(height);
        setGoalType(goalType);
        setUserName(userName);
        setPassWord(passWord);
    }

    /**
     * 8-Parameters Constructor
     * @author  Miguel Emmara - 1802146
     */
    public Register(String firstName, String lastName, String dateOfBirth, float weight, float height,
                    GoalType goalType, String userName, String passWord) {
        setFirstName(firstName);
        setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        setWeight(weight);
        setHeight(height);
        setGoalType(goalType);
        setUserName(userName);
        setPassWord(passWord);
    }

    // Getter and setter methods for Object's instance data.
    //------------------------------------------------------------------
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName.trim().isEmpty()? "UNKNOWN":firstName);
    }
    //------------------------------------------------------------------
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //------------------------------------------------------------------
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    //------------------------------------------------------------------
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    //------------------------------------------------------------------
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    //------------------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = (userName.trim().isEmpty()? "UNKNOWN":userName);
    }
    //------------------------------------------------------------------
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = (passWord.trim().isEmpty()? "UNKNOWN": passWord);
    }
    //------------------------------------------------------------------
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyy"));
    }
    //------------------------------------------------------------------
    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }
    //------------------------------------------------------------------
    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It will get user information and have an options to save it a txt file
     * @return none
     * @author  Miguel Emmara - 1802146
     */
    public void createUserAccountInformation() throws IOException {
        // Accept a string
        String str = "First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nDate Of Birth: "
                + getDateOfBirth() + "\nWeight: " + getWeight() + "\nHeight: " + getHeight() + " CM" + "\nGoal Type: " + getGoalType() + "\nUserName: "
                + getUserName() + "\nPassword: " + getPassWord();

        // attach a file to FileWriter
        FileWriter fw = new FileWriter(getUserName() + " - Account Information.txt");

        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < str.length(); i++)
            fw.write(str.charAt(i));
        //close the file
        fw.close();
    }

    /**
     * This method is A Polymorphism Method From MacroDatabases Class
     * It will get user information and have an options to save it a txt file
     * @param filePath : get filePath from user.
     * @param string : get string Information from user.
     * @return none
     * @author  Miguel Emmara - 1802146
     */
    public void addNewMembers(String filePath, String string) {
        try {
            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
            out.write(string);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
}
