package Miguel.Corporation;

/**
 * <h1>DataBaseUser Class</h1>
 * This Is used To Hold User Data
 *
 * @author Miguel Emmara - 18021466
 * @version 1.0
 * @since 10/10/2020
 */
public class DataBaseUser {
    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;
    private final String weight;
    private final String height;
    private final String goalType;
    private final String userName;
    private final String passWord;

    /**
     * Default Constructor
     *
     * @param firstName   : Get firstName From User.
     * @param lastName    : Get lastName From user.
     * @param dateOfBirth : Get dateOfBirth From user.
     * @param weight      : Get weight From user.
     * @param height      : Get height From user.
     * @param goalType    : Get goalType From user.
     * @param userName    : Get userName From user.
     * @param passWord    : Get passWord From user.
     * @author Miguel Emmara - 18021466
     */
    public DataBaseUser(String firstName, String lastName, String dateOfBirth, String weight, String height,
                        String goalType, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.goalType = goalType;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return firstName + "\n" + lastName + "\n" + dateOfBirth + "\n" + weight + "\n" + height + "\n" + goalType
                + "\n" + userName + "\n" + passWord + "\n";
    }
}
