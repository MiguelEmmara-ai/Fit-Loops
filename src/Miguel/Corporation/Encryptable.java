package Miguel.Corporation;

public interface Encryptable {
    public void encrypt(char[] key);
    public void decrypt(char[] key);
    public boolean isEncrypted();
}
