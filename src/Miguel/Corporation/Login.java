package Miguel.Corporation;

import java.io.File;
import java.util.Scanner;

/**
 * <h1>Login Class</h1>
 * This class will give the ability to login in the welcomePage(); inside Application Class
 *
 * @author Miguel Emmara - 18021466
 * @version 1.0
 * @since 10/10/2020
 */
public class Login {
    private String userName;
    private String password;

    /**
     * 2-Parameters Constructor
     *
     * @param userName : Get userName From User.
     * @param password : Get PassWord From user.
     * @author Miguel Emmara - 18021466
     */
    public Login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        this.password = password;
    }

    // Getter and setter methods for Object's instance data.
    //------------------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //------------------------------------------------------------------
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //------------------------------------------------------------------

    /**
     * This method is verifyLogin user
     * It will check if the username and password entered by user is valid and exist in the members.txt
     *
     * @param filepath : members.txt.
     * @author Miguel Emmara - 18021466
     */
    public boolean verifyLogin(String filepath) {
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try {
            Scanner scanner = new Scanner(new File(filepath));
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext() && !found) {
                tempUsername = scanner.next();
                tempPassword = scanner.next();

                if (tempUsername.trim().equals(getUserName().trim()) && tempPassword.trim().equals(getPassword().trim())) {
                    found = true;
                }
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error, File not Found!");
        }
        return found;
    }
}
