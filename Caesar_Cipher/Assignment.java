import edu.duke.*;
import java.io.*;

public class Assignment {
    
    public int getWordLength(String word) {
        int length = word.length();
        
        // Check for and exclude leading non-letter characters.
        if (length > 0 && !Character.isLetter(word.charAt(0))) {
            length--;
        }
        
        // Check for and exclude trailing non-letter characters.
        if (length > 1 && !Character.isLetter(word.charAt(word.length() - 1))) {
            length--;
        }
        
        return length;
    }
    
    
    public void countWordLengths(FileResource resource, int[] counts){
        ArraysLesson a1 = new ArraysLesson();
        for(String word : resource.words()){
                int wordLength = getWordLength(word);
                if (wordLength >= counts.length) {
                wordLength = counts.length - 1;
            }
            counts[wordLength]++;
        }
        
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0){
                System.out.println(counts[i] + " words of length " + i);
            }
        }
        System.out.println("most common word length is " + a1.maxIndex(counts));
    }

    
    public void tester(){
        FileResource fr = new FileResource();
        int[] arr = new int[31];
        countWordLengths(fr, arr);
    }
    
    
    public String halfOfString(String message, int start){
        StringBuilder s = new StringBuilder();
        for(int i = start; i < message.length(); i+=2){
            char ch = message.charAt(i);
            s.append(ch);
        }
        return s.toString();
    }
    
    
    public void testHalfString(){
        System.out.println(halfOfString("Qbkm Zgis",0));
        System.out.println(halfOfString("Qbkm Zgis",1));
    }
}
