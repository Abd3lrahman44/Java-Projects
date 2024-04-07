
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo(int key1,int key2){
        this.key1 = key1;
        this.key2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }
    
    
    public String encryptTwoKeys(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        CaesarCipher cc = new CaesarCipher(key1);
        CaesarCipher cc2 = new CaesarCipher(key2);
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {  // Even index, use key1
                String part = cc.encryptString(Character.toString(encrypted.charAt(i)));
                encrypted.setCharAt(i, part.charAt(0));
            } else {  // Odd index, use key2
                String part = cc2.encryptString(Character.toString(encrypted.charAt(i)));
                encrypted.setCharAt(i, part.charAt(0));
            }
        }
        return encrypted.toString();
    }
    /*
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < encrypted.length(); i += 2) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                char newChar = shiftedAlphabet1.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        
        for (int i = 1; i < encrypted.length(); i += 2) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                char newChar = shiftedAlphabet2.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    */ 
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - key1,26 - key2);
        String decrypted = cc.encryptTwoKeys(input);
        return decrypted;
    }
}
