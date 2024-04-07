import edu.duke.*;

public class CaesarBreaker {
    public int[] countLetters(String message) {
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

    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }

    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encryptString(encrypted, 26 - dkey);
    }

    public void testDecrypt() {
        String encrypted = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
    }

    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int k = start; k < message.length(); k += 2) {
            sb.append(message.charAt(k));
        }
        return sb.toString();
    }

    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    public String decryptTwoKeys(FileResource fr){
        String half0 = halfOfString(fr.asString(), 0);
        String half1 = halfOfString(fr.asString(), 1);
        int key1 = getKey(half0);
        int key2 = getKey(half1);
        System.out.println("Key 1: " + key1 + ", Key 2: " + key2);
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(fr.asString(), 26 - key1, 26 - key2);
    }
    
    public void testTwoKey(){
        FileResource fr = new FileResource();
        System.out.println(decryptTwoKeys(fr));
    }
}
