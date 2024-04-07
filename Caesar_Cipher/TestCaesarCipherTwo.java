import edu.duke.*;

public class TestCaesarCipherTwo {
    
    private String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int k = start; k < message.length(); k += 2) {
            sb.append(message.charAt(k));
        }
        return sb.toString();
    }
    
    
    private int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex]++;
            }
        }
        return counts;
    }

    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    private int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    
    public String breakCaesarCipher(String input){
        String half0 = halfOfString(input, 0);
        String half1 = halfOfString(input, 1);
        int key1 = getKey(half0);
        int key2 = getKey(half1);
        System.out.println("Key 1: " + key1 + ", Key 2: " + key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1 , key2);
        return cc.decrypt(input);
    }
    
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String fileAsString = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
        String encrypted = cc.encryptTwoKeys(fileAsString);
        System.out.println("Encrypted with 2 keys: " + encrypted);
        System.out.println("Decrypted with 2 keys: " + cc.decrypt(encrypted));
        System.out.println("Automatically Decrypted with 2 keys: " + breakCaesarCipher(fileAsString));
    }
}
