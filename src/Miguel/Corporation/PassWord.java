package Miguel.Corporation;

/**
 * <h1>PassWord Class</h1>
 * This class works as a encryptor for user password to store in the database
 *
 * @author Miguel Emmara - 18021466
 * @version 1.0
 * @since 10/10/2020
 */
public class PassWord implements Encryptable {
    public String message;
    public boolean isEncrypted;

    /**
     * 2-Parameters Constructor
     *
     * @param passWord  : Get passWord From User.
     * @param encrypted : Get false.
     * @author Miguel Emmara - 18021466
     */
    public PassWord(String passWord, boolean encrypted) {
        this.message = passWord;
        isEncrypted = encrypted;
    }

    /**
     * Encrypt The Password
     *
     * @param key : SecretKey.
     * @author Miguel Emmara - 18021466
     */
    @Override
    public void encrypt(char[] key) {
        if (!isEncrypted) { // String builder used to hold Encrypted String
            StringBuilder encrypted = new StringBuilder();
            isEncrypted = true;
            // loop through each char
            for (int i = 0; i < message.length(); i++) {
                char current = message.charAt(i);
                // check if the current char between printable ascii values
                if (current >= 33 && current <= 126) {
                    current -= 33; // keep first character the value 0
                    // add on current key at position i mod length of key
                    current += key[i % key.length];
                    // mod to keep char in range 33-126 (keyboard characters)
                    current = (char) ((int) current % 94 + 33);
                    encrypted.append(current);
                } else
                    encrypted.append(current);
            }
            message = encrypted.toString();
        }
    }

    /**
     * Decrypt The Password
     *
     * @param key : SecretKey.
     * @author Miguel Emmara - 18021466
     */
    @Override
    public void decrypt(char[] key) {
        if (isEncrypted) {
            isEncrypted = false;
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char current = message.charAt(i);
                if (current >= 33 && current <= 126) {
                    current -= 33;
                    current += 282; // done to keep value positive (3*94)
                    current -= key[i % key.length];
                    current = (char) ((int) current % 94 + 33);
                    decrypted.append(current);
                } else
                    decrypted.append(current);
            }
            message = decrypted.toString();
        }
    }

    @Override
    public boolean isEncrypted() {
        return isEncrypted;
    }

    public String toString() {
        return message;
    }
}
