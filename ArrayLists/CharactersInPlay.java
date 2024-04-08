import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> Characters;
    private ArrayList<Integer> Counts;
    
    
    public CharactersInPlay(){
        Characters = new ArrayList<String>();
        Counts = new ArrayList<Integer>();
    }
    
    
    public void update(String person){
        //person = person.toLowerCase();
        // maybe size is 0 so loop doesnt happen
        int index = Characters.indexOf(person);
        if(index == -1){
            Characters.add(person);
            Counts.add(1);
        }
        else{
            int value = Counts.get(index);
            Counts.set(index, value +1);
        }
    }
    
    
    public void findAllCharacters(){
        //Characters.clear();
        //Counts.clear();
        FileResource fr = new FileResource();
        for(String line: fr.lines()){
            String character = "";
            if(line.contains(".")){
                character = line.substring(0,line.indexOf("."));
                update(character);
            }
        }
    }
    
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i = 0; i < Characters.size(); i++){
            if(Counts.get(i) >= num1 && Counts.get(i) <= num2){
                System.out.println(Characters.get(i) + "\t" + Counts.get(i));
            }
        }
    }
    
    
    public void tester(){
        findAllCharacters();
        for(int i = 0; i < Characters.size(); i++){
            if(Counts.get(i) > 5){
                System.out.println(Characters.get(i) + "\t" + Counts.get(i));
            }
        }
        System.out.println("TEST_charactersWithNumParts()__________________");
        charactersWithNumParts(10,15);
    }
    
    
}
