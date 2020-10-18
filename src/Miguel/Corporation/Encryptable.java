package Miguel.Corporation;

/**
 * <h1>Encryptable Interface Class</h1>
 * Interface Class of 3 methods to Encrypt Passwords use in PassWords Class
 *
 * @author  Miguel Emmara - 1802146
 * @version 1.0
 * @since   10/10/2020
 */
public interface Encryptable {
    public void encrypt(char[] key);
    public void decrypt(char[] key);
    public boolean isEncrypted();
}
