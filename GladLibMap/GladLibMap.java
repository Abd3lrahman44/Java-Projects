import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String>> map;
    
    private int totalWordsReplaced;
    private ArrayList<String> uniqueList;
    private ArrayList<String> usedList;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        map = new HashMap <String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        map = new HashMap <String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] labels = {"adjective", "noun", "color", "country",
             "name", "animal", "timeframe", "verb", "fruit", };
        for(String label : labels){
            ArrayList<String> list = readIt(source+"/"+label+".txt");
            map.put(label, list);
        }
        uniqueList = new ArrayList<String>();
        usedList = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        
        if(!usedList.contains(label)){
            usedList.add(label);
        }
        return randomFrom(map.get(label));
        //String s = "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub;
        do {
            sub = getSubstitute(w.substring(first+1,last));
        } while(uniqueList.contains(sub));
        uniqueList.add(sub);
        totalWordsReplaced++;
        return prefix+sub+suffix;
    }
    
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        uniqueList.clear();
        totalWordsReplaced = 0;
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n\nTotal words replaced " + totalWordsReplaced);
        System.out.println("Total number of words that were possible to pick from " + totalWordsInMap());
        System.out.println("Total number of words in used categories " + totalWordsConsidered());
    }
    

    private int totalWordsInMap(){
        int total = 0;
        for(String word : map.keySet()){
            total += map.get(word).size();
        }
        return total;
    }
    
    private int totalWordsConsidered(){
        int total= 0;
        for(String label : usedList){
            ArrayList<String> words = map.get(label);
            if(words != null){
                total += words.size();
            }
        }
        return total;
    }
}
