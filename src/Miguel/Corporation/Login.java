package Miguel.Corporation;

import java.io.File;
import java.util.Scanner;

public class Login {
    private String userName;
    private String password;

    public Login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyLogin(String userName, String password, String filepath) {
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
