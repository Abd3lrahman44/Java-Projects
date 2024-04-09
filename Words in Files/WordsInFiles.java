import java.util.*;
import java.io.*;
import edu.duke.*;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    
    public WordsInFiles(){
        map = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String filename = f.getName();
        for(String word : fr.words()){
            if(!map.containsKey(word)){
                ArrayList<String> files = new ArrayList<String>();
                files.add(filename);
                map.put(word, files);
            }
            else{
                ArrayList<String> files = map.get(word);
                if(!files.contains(filename)) files.add(filename);
            }
        }
    }
    
    private void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    
    private int maxNumber(){
        int max = 0;
        for(String word : map.keySet()){
            if(map.get(word).size() > max){
                max = map.get(word).size();
            }
        }
        return max;
    }
    
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList <String> words = new ArrayList<String>();
        for(String word : map.keySet()){
            if(map.get(word).size() == number){
                words.add(word);
            }
        }
        return words;
    }
    
    
    private void printFilesIn(String word){
        if(map.containsKey(word)){
            ArrayList<String> files = map.get(word);
            for(String fileName : files){
                System.out.println(fileName);
            }
        }
    }
    
    
    public void tester(){
        buildWordFileMap(); // Build Map
        // print out key value pairs
        System.out.println("printing map.. ");
        for(String word : map.keySet()){
            System.out.println(word + "\t" + map.get(word));
        }
        System.out.println(); // line break
        System.out.println("printing the greatest number of files a word appears in... " + maxNumber());
        System.out.println(); // line break
        System.out.println("printing words that has been found 2 times.. " + wordsInNumFiles(2));
        System.out.println(); // line break
        System.out.println("printing the file names where 'cats' was found... ");
        printFilesIn("cats");
    }
    
    
}
