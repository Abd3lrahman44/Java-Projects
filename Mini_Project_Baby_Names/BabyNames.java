import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
    
    
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        int boysCount = 0;
        int girlsCount = 0;
        CSVParser parser = fr.getCSVParser(false); // no header row
        
        for(CSVRecord rec : parser){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
                boysCount ++;
            }
            else{
                totalGirls += numBorn;
                girlsCount++;
            }
        }
        System.out.println("total born: " + totalBirths);
        System.out.println("total girls born: " + totalGirls);
        System.out.println("total boys born: " + totalBoys);
        System.out.println("girls names count: " + girlsCount);
        System.out.println("boys names count: " + boysCount);
        System.out.println("total number of names: " + boysCount + girlsCount);
    }
    
    
    public int getRank(int year, String name, String gender){
        String fileName = "yob" + Integer.toString(year) + ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        int Rank = -1;
        int Counter = 0;
        
        for(CSVRecord rec : parser){
            String currentName = rec.get(0);
            String currentGender = rec.get(1);
    
            if(currentGender.equals(gender)){
                Counter ++;
                if(currentName.equals(name)){
                    Rank = Counter;
                    break;
                }
            } 
        }
        return Rank;
    }
    
    
    public String getName(int year, int Rank, String gender){
        String fileName = "yob" + Integer.toString(year) + ".csv";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        
        int Counter = 1;
        String Name = "NO NAME";
        
        for(CSVRecord rec : parser){
            if(rec.get(1).equals(gender)){
                if(Counter == Rank){
                    Name = rec.get(0);
                    break;
                }
            
                else{
                    Counter ++;
                }
            }
        }
        
        return Name;
    }
    
    
    public void whatIsNameInYear(String name, int year, String gender, int newYear){
        String FileName = "yob" + Integer.toString(newYear) + ".csv";
        FileResource fr = new FileResource(FileName);
        CSVParser parser = fr.getCSVParser(false);
        int Rank = getRank(year, name, gender);
        String newName = getName(newYear, Rank, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if born in " + newYear);
    }
    
    
    public int getYearFromFile(String fileName){
        int startOfYear = fileName.indexOf("b") + 1;
        int endOfYear = 0;
        if(fileName.contains("short")){
            endOfYear = fileName.indexOf("s");
        }
        else{
            endOfYear = fileName.indexOf(".");
        }
        String year = fileName.substring(startOfYear, endOfYear);
        return Integer.parseInt(year);
    }
    
    
    public int yearOfHighestRank(String name, String gender){
        int highestRankYear = -1;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String fileName = f.getName();
            int currentYear = getYearFromFile(fileName);
            int Rank = getRank(currentYear, name, gender);
            if(Rank < highestRankYear){
                highestRankYear = currentYear;
            }
        }
        return highestRankYear;
    }
    
    
    public double getAverageRank(String name, String gender){
        double avgRank = -1;
        double totalRank = 0;
        int fileCount = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            fileCount++;
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String fileName = f.getName();
            int currentYear = getYearFromFile(fileName);
            int Rank = getRank(currentYear, name, gender);
            totalRank += Rank;
        }
        avgRank = totalRank/fileCount;
        return avgRank;
    }
    
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalBirthsRankedHigher = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int Rank = getRank(year, name, gender);
        for(CSVRecord rec: parser){
            if(rec.get(1).equals(gender)){
                if(Rank > getRank(year, rec.get(0), gender)){
                    totalBirthsRankedHigher += Integer.parseInt(rec.get(2));
                }
            }
        }
    return totalBirthsRankedHigher;
    }

    
    public void testGetTotalBirthsRankedHigher(){
        // System.out.println("Total Births Ranked Higher Than Ethan in 2012 is: " + getTotalBirthsRankedHigher(2012, "Ethan", "M"));
        System.out.println("Total Births Ranked Higher Than Drew in 1990 is: " + getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
    
    
    public void testGetAverageRank(){
        // System.out.println("Average Rank Mason: " + getAverageRank("Mason", "M")); // 3.0
        // System.out.println("Average Rank Jacob: " + getAverageRank("Jacob", "M")); // 2.66
        System.out.println("Average Rank Susan: " + getAverageRank("Susan", "F")); // test
        System.out.println("Average Rank Robert: " + getAverageRank("Robert", "M")); // test
        
    }
    
    
    public void testYearOfHighestRank(){
        // System.out.println(yearOfHighestRank("Mason","M")); // should return 2012
        System.out.println("GENIVIVE: " + yearOfHighestRank("Genevieve","F")); // test
        System.out.println("Mich: " + yearOfHighestRank("Mich","M")); // test
    }
    
    
    public void testWhatIsNameInYear(){
        // whatIsNameInYear("Isabella", 2012, "F", 2014); // Sophia
        // whatIsNameInYear("Susan", 1972, "F", 2014); // test
        whatIsNameInYear("Owen", 1974, "M", 2014); // test
    }
    
    
    public void testGetName(){
        // System.out.println(getName(2012, 2, "M")); // Mason
        // System.out.println(getName(2012, 2, "F")); // Emma
        System.out.println(getName(1980, 350, "F")); // test
        System.out.println(getName(1982, 450, "M")); // test
    }
    
    public void testGetRank(){
        //System.out.println(getRank(2012, "Mason", "M")); // correct eval: 2
        //System.out.println(getRank(2012, "Isabella", "F")); // correct eval:  3
        //System.out.println(getRank(2012, "Mason", "F")); // correct eval: -1
        //System.out.println(getRank(2012, "Abdulrahman", "M")); // correct eval: -1
        //System.out.println(getRank(1960, "Emily", "F")); // test
        System.out.println(getRank(1971, "Frank", "M")); // test
    }
    
    
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1905.csv");
        totalBirths(fr);
    }
      
}
