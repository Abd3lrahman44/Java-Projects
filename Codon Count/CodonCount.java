import java.util.*;
import edu.duke.*;

public class CodonCount {
    private HashMap<String, Integer> map;
    
    
    public CodonCount(){
        map = new HashMap<String, Integer>();
    }
    
    
    private void buildCodonMap(String dna, int start){
        map.clear();
        dna = dna.trim().toUpperCase();
        for(int i = start; i <= dna.length() - 3 ; i += 3){
            String codon = dna.substring(i, i + 3);
            map.put(codon, map.getOrDefault(codon, 0) + 1);
        }
    }
    
    
    public String getMostCommonCodon(){
        int max = 0;
        String mostCommonCodon = "";
        // buildCodonMap("CGAABAABA", 0);
        for(String s : map.keySet()){
            int value = map.get(s);
            if(value > max){
                max = value;
                mostCommonCodon = s;
            }
        }
        return mostCommonCodon;
    }
    
    
    public void printCodonCounts(int start , int end){
        int uniques = 0;
        for(String s : map.keySet()){
            uniques ++;
            if(map.get(s) >= start && map.get(s) <= end){
                System.out.println(s + "\t" + map.get(s));   
            }
        }
        System.out.println("number of unique values " + uniques);
    }
    
    
    public void tester(){
        FileResource fr = new FileResource();
        String fileString = fr.asString().trim().toUpperCase();
        int start = 1;
        int end = 5;
        
        for(int i = 0; i < 3; i++){
            System.out.println("For reading frame " + i);
            buildCodonMap(fileString, i);
            System.out.println("All map elements between " + start + " and " + end + " inclusive : _____");
            printCodonCounts(start, end);
            System.out.println("The most common codon is " + getMostCommonCodon() + "\t" + map.get(getMostCommonCodon()) + "\n");
        }
        /*
        System.out.println("All map elements : _____");
        for(String s : map.keySet()){
            System.out.println(s + "\t" + map.get(s));   
        }
        */
    }
}
