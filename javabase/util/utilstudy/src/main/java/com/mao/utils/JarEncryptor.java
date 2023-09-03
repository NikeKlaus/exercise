package com.mao.utils;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
/**
 * @author: maowenxing
 * @date: 2023/8/7
 */
public class JarEncryptor {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "coffeemao1234567";

    public static void encryptJarFile(String inputFilePath, String outputFilePath) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (InputStream in = new FileInputStream(inputFilePath);
             OutputStream out = new CipherOutputStream(new FileOutputStream(outputFilePath), cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) >= 0) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decryptJarFile(String inputFilePath, String outputFilePath) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (InputStream in = new CipherInputStream(new FileInputStream(inputFilePath), cipher);
             OutputStream out = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) >= 0) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String inputFilePath = "E:\\Code\\exercise\\javabase\\collection\\collectionstudy\\target\\collectionstudy-1.0.jar";
            String encryptedFilePath = "E:\\Code\\exercise\\javabase\\util\\utilstudy\\src\\main\\resources\\encrypted.jar";
            String decryptedFilePath = "E:\\Code\\exercise\\javabase\\util\\utilstudy\\src\\main\\resources\\decrypted.jar";

//            encryptJarFile(inputFilePath, encryptedFilePath);
            System.out.println("加密成功");


            decryptJarFile(encryptedFilePath, decryptedFilePath);
            System.out.println("成功解密");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
