package controlador;

import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class AES {

    private static final String algorithm = "AES";
    private static final byte[] keyValue = new byte[]{'A', 'S', 'e', 'c', 'u', 'r', 'e', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    // Performs Encryption
    private static String _encrypt(String plainText) throws Exception {
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(algorithm);
        chiper.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = chiper.doFinal(plainText.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    // Performs decryption
    private static String _decrypt(String encryptedText) throws Exception {
        // generate key 
        Key key = generateKey();
        Cipher chiper = Cipher.getInstance(algorithm);
        chiper.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
        byte[] decValue = chiper.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

//generateKey() is used to generate a secret key for AES algorithm
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, algorithm);
        return key;
    }

    public static String decrypt(String _texto) {
        String texto = "";
        try {
            texto = _decrypt(_texto);
        } catch (Exception ex) {
            System.out.println("Error al Desencriptar");
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
    
    public static String encrypt(String _texto) {
        String texto = "";
        try {
            texto = _encrypt(_texto);
        } catch (Exception ex) {
            System.out.println("Error al Encriptar");
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }

    // performs encryption & decryption 
    public static void main(String[] args) throws Exception {

        String plainText = "{\"hola\":\"que tal\",[aldo]}";
        String encryptedText = AES._encrypt(plainText);
        String decryptedText = AES._decrypt(encryptedText);

        System.out.println("Plain Text : " + plainText);
        System.out.println("Encrypted Text : " + encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);
    }
}
