import edu.duke.*;

public class TestCaesarCipher {
    
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
    
    public String breakCaesarCipher(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        String decrypted = cc.decryptString(encrypted);
        return decrypted;
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String file = fr.asString();
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encryptString(file);
        System.out.println("Encrypted String: " + encrypted);
        System.out.println("Decrypted String: " + cc.decryptString(encrypted));
        System.out.println("Automatically Decrypted String: " + breakCaesarCipher(encrypted));
    }
}
