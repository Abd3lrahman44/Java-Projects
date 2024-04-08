import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;     
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String word : fr.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if(index == -1){
                myWords.add(word);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        //System.out.println("ArrayList: " + myFreqs);
        System.out.println("Number of Unique words: " + myFreqs.size());
        for(int i = 0; i < myFreqs.size(); i++){
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        System.out.println("The most frequent word is '" + myWords.get(findIndexOfMax()) + "' occurres " + myFreqs.get(findIndexOfMax()) + " times.");
    }
    
    public int findIndexOfMax(){
        int max = 0;
        
        for(int i = 0; i < myFreqs.size(); i++){
            if(myFreqs.get(i) > max){
                max = myFreqs.get(i);
            }
        }
        
        return myFreqs.indexOf(max);
    }
}
