public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    
    public String encryptString(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String decryptString(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encryptString(input);
        return decrypted;
    }
    
    /*
    public String encryptTwoKeys(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        CaesarCipher cc = new CaesarCipher();
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {  // Even index, use key1
                String part = encryptString(Character.toString(encrypted.charAt(i)), key1);
                encrypted.setCharAt(i, part.charAt(0));
            } else {  // Odd index, use key2
                String part = encryptString(Character.toString(encrypted.charAt(i)), key2);
                encrypted.setCharAt(i, part.charAt(0));
            }
        }
        return encrypted.toString();
    }
    */
    
    
}
