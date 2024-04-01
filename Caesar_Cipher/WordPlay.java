public class WordPlay {
    
    
    public boolean isVowel(char c){
        String vowels = "aeiouAEIOU";
        boolean isVowel = false;
        if(vowels.indexOf(c) != -1){
            isVowel = true;
        }
        return isVowel;
    }
    
    
    public void testVowel(){
        char c = 'A';
        System.out.println(isVowel(c));
    }

    
    public String replaceVowels(String phrase, char ch){
        StringBuilder newString = new StringBuilder(phrase);
        
        for(int i = 0; i < phrase.length(); i++){
            char check = phrase.charAt(i);
            if(isVowel(check)){
                newString.setCharAt(i,ch);
            }
        }
        return newString.toString();
    }
    
    
    public String emphasize(String phrase, char ch){
        StringBuilder newString = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++){
            char check = phrase.charAt(i); 
            if(check == ch){
                int idx = phrase.indexOf(ch, i);
                if(idx%2==0){ // reveresed since ie: the first character has an odd number location but an even index, it is at index 0)
                    newString.setCharAt(idx,'*');    
                }
                else{
                    newString.setCharAt(idx,'+');
                }
            }
        }
        return newString.toString();
    }
    
    
    public void testReplace(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }
}
