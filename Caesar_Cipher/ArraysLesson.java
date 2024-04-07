import java.util.Random;

public class ArraysLesson {
    public void bruteForce(String encrypted){ // Brute forces Caesar cipher.
        //CaesarCipher cipher = new CaesarCipher();
        for(int i = 0; i < 26; i++){
          //  String s = cipher.encryptString(encrypted, i);
           // System.out.println(i + "\t" + s);
        }
        // Prints 26 Output strings, eyeball results to see the decrypted message.
    }
    
    
    public int[] countOccurences(String s){ // Counts how many times each letter is in string.
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != -1){
                counters[i] ++;
            }
        }       
        
        /* for(int i = 0; i < counters.length; i++){
            System.out.println(alpha.charAt(i) + "\t" + counters[i]);
        }
        */
        return counters;
    }
    
    
    public int maxIndex(int[] x){ // method that returns index of the most frequent element in array
        int max = 0; // largest number in array
        int maxIndex = 0; // index of largest number
        
        for(int i = 0; i < x.length; i++){
            if(x[i] > max){
                max = x[i];
            }
            
            if(x[i] == max){
                maxIndex = i;
            }
        
        }
        
        return maxIndex;
    }
    
    public void testMaxIndex(){
        int[] arr = {10,10,12,32,2,4,5,36,2,4,1,19};
        System.out.println("Max index = " + maxIndex(arr));
    }
    
    public void rollDice(int rolls){ // shows output and percentage of rolled dice. 
        Random rand = new Random();
        int [] counts = new int[13];
        
        for(int i = 0; i < rolls; i++){
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            System.out.println("rolls is " + d1 + "+" + d2 + "=" + (d1+d2)); // to see what was rolled.
            counts[d1 + d2] ++;
        }
        
        for(int i = 2; i < counts.length; i++){
            System.out.println(i + "'s=\t" + counts[i] + "\t" + 100.0 * counts[i]/rolls);
        }
    }
}
