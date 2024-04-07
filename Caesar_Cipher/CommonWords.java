import edu.duke.*;

public class CommonWords
{
    public String[] getCommon(){ // reads commons english words form txt file and saves to array[].
	FileResource resource = new FileResource("data/common.txt");
	String[] common = new String[20];
	int index = 0;
	for(String s : resource.words()){
		common[index] = s;
        	index += 1;
	}
	return common;
    }
	
    
    public int indexOf(String[] list, String word) { // checks if word  is in list of words.
        for (int i=0; i<list.length; i++) {
            if (list[i].equals(word)) {
                return i;
               }
           }
        return -1;
    }  
	
    
    public void countWords(FileResource resource, String[] common, int[] counts){
	for(String word : resource.words()){
		word = word.toLowerCase();
		int index = indexOf(common,word);
		if (index != -1) {
			counts[index] += 1;
		}
	}
    }
	
    // Go through shakespear plays and count number of common words used
    void countShakespeare(){ 
	String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
		          "likeit.txt", "macbeth.txt", "romeo.txt"};
        //String[] plays = {"small.txt"};
	String[] common = getCommon();
	int[] counts = new int[common.length];
	for(int k=0; k < plays.length; k++){
		FileResource resource = new FileResource("data/" + plays[k]);
		countWords(resource,common,counts);
		System.out.println("done with " + plays[k]);
	}
		
	for(int k=0; k < common.length; k++){
		System.out.println(common[k] + "\t" + counts[k]);
	}
    }
    
    
    public String autoDecryptCaesarCipher(String encrypted){ // automatic decryption of caesar cipher based on most frequent letter being "e"
        CaesarCipher cipher = new CaesarCipher(); 
        int dkey = cipher.getKey(encrypted);
        return cipher.encryptString(encrypted ,26 - dkey);
    }
    
    
    public void testBreaking(){
        CaesarCipher cipher = new CaesarCipher();
        String s = "Hi my name abdo"; // original message 
        String encrypted = cipher.encryptString(s, 10); // encrypted with key 10
        System.out.println("encrypted with key 10: " + encrypted);
        System.out.println("Decrypted: " + autoDecryptCaesarCipher(encrypted));
    }
}