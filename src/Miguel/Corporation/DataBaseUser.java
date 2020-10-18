package Miguel.Corporation;

public class DataBaseUser {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String weight;
    private String height;
    private String goalType;
    private String userName;
    private String passWords;

    public DataBaseUser(String firstName, String lastName, String dateOfBirth, String weight, String height, String goalType, String userName, String passWords) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.goalType = goalType;
        this.userName = userName;
        this.passWords = passWords;
    }

    @Override
    public String toString() {
        return firstName + "\n" + lastName + "\n" + dateOfBirth + "\n" + weight + "\n" + height + "\n" + userName + "\n" + passWords + "\n";
    }
}
