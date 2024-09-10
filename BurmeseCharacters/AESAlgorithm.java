package BurmeseCharacters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESAlgorithm {
    public static String KEY = "";
    public static String IV = "";

    public static boolean readAESKeys() {
        boolean exist = false;
        String[] keys = new String[2];

        // You can change your Local Location as you want
        String filepath = "E:\\Development\\Java_Essential_Functions\\AESAlgorithm_Encryption\\BurmeseCharacters\\aesKeys";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            keys[0] = reader.readLine();
            keys[1] = reader.readLine();
            KEY = keys[0];
            IV = keys[1];

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!KEY.isEmpty() && !IV.isEmpty()) {
            exist = true;
        }
        return exist;
    }

    public static String encryptString(String value) {
        boolean isExist = readAESKeys();

        if (isExist) {

            try {
                byte[] ivBytes = IV.getBytes("UTF-8");
                byte[] keyBytes = KEY.getBytes("UTF-8");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivBytes);
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, paramSpec);
                // return new String (cipher.doFinal(value.getBytes("UTF-8")));
                return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes("UTF-8")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Error Encrypting Value";
    }

    public static String decryptString(String value) {

        boolean isExist = readAESKeys();

        if (isExist) {

            try {
                byte[] ivBytes = IV.getBytes("UTF-8");
                byte[] keyBytes = KEY.getBytes("UTF-8");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivBytes);
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, paramSpec);
                return new String(cipher.doFinal(Base64.getDecoder().decode(value)), "UTF-8");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
