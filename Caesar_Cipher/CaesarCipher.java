import edu.duke.*;
import java.lang.*;

public class CaesarCipher {
    
    
    public String encryptString(String original, int key){
        StringBuilder encrypted = new StringBuilder(original);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = Character.toUpperCase(encrypted.charAt(i));
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    
    public String encryptTwoKeys(String original, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(original);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
        for(int i = 0; i < encrypted.length(); i+=2){
            char currChar = Character.toUpperCase(encrypted.charAt(i));
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        
        for(int i = 1; i < encrypted.length(); i+=2){
            char currChar = Character.toUpperCase(encrypted.charAt(i));
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    
    public void test2Keys(){
        String str = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encryptTwoKeys(str, 8,21);
        System.out.println(encrypted);
    }
    
    
    public void testCaesar(){
        int key = 15;
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encryptString(message, key);
        System.out.println(encrypted);
    }   
}
