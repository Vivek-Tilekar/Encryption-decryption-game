import java.io.*;
import java.nio.file.Files;

public class PolyalphabeticCipher {

    // Method to encrypt text using Polyalphabetic Cipher (Vigenère Cipher)
    public String encrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char charToEncrypt = text.charAt(i);
            if (Character.isLetter(charToEncrypt)) {
                char offset = Character.isUpperCase(charToEncrypt) ? 'A' : 'a';
                char encryptedChar = (char) (((charToEncrypt - offset + (key.charAt(keyIndex) - offset)) % 26) + offset);
                encryptedText.append(encryptedChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                encryptedText.append(charToEncrypt);
            }
        }
        return encryptedText.toString();
    }

    // Method to decrypt text using Polyalphabetic Cipher (Vigenère Cipher)
    public String decrypt(String text, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char charToDecrypt = text.charAt(i);
            if (Character.isLetter(charToDecrypt)) {
                char offset = Character.isUpperCase(charToDecrypt) ? 'A' : 'a';
                char decryptedChar = (char) (((charToDecrypt - offset - (key.charAt(keyIndex) - offset) + 26) % 26) + offset);
                decryptedText.append(decryptedChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                decryptedText.append(charToDecrypt);
            }
        }
        return decryptedText.toString();
    }

    // Function to encrypt the content of the File object and overwrite the file
    public void encryptFile(File file, String key) throws IOException {
        // Read the content of the file
        String content = new String(Files.readAllBytes(file.toPath()));

        // Encrypt the content
        String encryptedContent = encrypt(content, key);

        // Overwrite the same file with the encrypted content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(encryptedContent);
        }

        System.out.println("File encrypted successfully!");
    }

    // Function to decrypt the content of the File object and overwrite the file
    public void decryptFile(File file, String key) throws IOException {
        // Read the content of the file
        String content = new String(Files.readAllBytes(file.toPath()));

        // Decrypt the content
        String decryptedContent = decrypt(content, key);

        // Overwrite the same file with the decrypted content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(decryptedContent);
        }

        System.out.println("File decrypted successfully!");
    }
}



//********** old method **************
//import java.io.*;
//import java.nio.file.Files;
//
//public class PolyalphabeticCipher {
//
//    // Method to encrypt text using the Polyalphabetic Cipher (Vigenère Cipher)
//    public String encrypt(String text, String key) {
//        StringBuilder encryptedText = new StringBuilder();
//        int keyIndex = 0;
//
//        for (int i = 0; i < text.length(); i++) {
//            char charToEncrypt = text.charAt(i);
//            if (Character.isLetter(charToEncrypt)) {
//                char offset = Character.isUpperCase(charToEncrypt) ? 'A' : 'a';
//                char encryptedChar = (char) (((charToEncrypt - offset + (key.charAt(keyIndex) - offset)) % 26) + offset);
//                encryptedText.append(encryptedChar);
//                keyIndex = (keyIndex + 1) % key.length();
//            } else {
//                encryptedText.append(charToEncrypt);
//            }
//        }
//        return encryptedText.toString();
//    }
//
//    // Function to encrypt the content of the File object and overwrite the file
//    public void encryptFile(File file, String key) throws IOException {
//        // Read the content of the file
//        String content = new String(Files.readAllBytes(file.toPath()));
//
//        // Encrypt the content
//        String encryptedContent = encrypt(content, key);
//
//        // Overwrite the same file with the encrypted content
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(encryptedContent);
//        }
//
//        System.out.println("File encrypted successfully!");
//    }
//}
