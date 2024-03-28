import java.io.*;
import org.apache.commons.csv.*;
import edu.duke.*;


public class Cold_Weather {
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar, String row){
        if(smallestSoFar == null){
                smallestSoFar = currentRow;
        }
        
        else{
            double current = Double.parseDouble(currentRow.get(row));
            double smallest = Double.parseDouble(smallestSoFar.get(row));
                
            if(current < smallest){ 
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for(CSVRecord currentRow : parser){
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }
        return smallestSoFar;
    }
    
    
    public CSVRecord coldestInManyDays(){
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(Double.parseDouble(currentRow.get("TemperatureF")) < -1000){
                //do nothing
            }
            else{
                smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
            }
        }
        return smallestSoFar;
    }
    
    
    public String fileWithColdestTemperature(){
        CSVRecord smallestSoFar = null;
        String fileName = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = currentRow;
            }
        
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                
                if(currentTemp < smallestTemp){ 
                    smallestSoFar = currentRow;
                    fileName = f.getName();
                }
            }
        }
        return fileName;
    }
    
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord = null;
        for(CSVRecord currentRow : parser){
            if(currentRow.get("Humidity").equals("N/A")){
                //do nothing
            }
            else{
                lowestHumidityRecord = getSmallestOfTwo(currentRow, lowestHumidityRecord, "Humidity");
            }
        }
        return lowestHumidityRecord;
    }
    
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumidityRecord = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestHumidityRecord = getSmallestOfTwo(currentRow, lowestHumidityRecord, "Humidity");
        }
        return lowestHumidityRecord;
    }
    
    
    public double averageTemperatureInFile(CSVParser parser){
        double avgTemperature = 0;
        double total = 0;
        int count = 0;
        
        for(CSVRecord currentRow : parser){
            total = total + Double.parseDouble(currentRow.get("TemperatureF"));
            count = count + 1;
        }
        avgTemperature = total/count;
        return avgTemperature;
    }
    
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double avg = 0;
        double total = 0;
        int count = 0;
        
        for(CSVRecord currentRow : parser){
            if(currentRow.get("Humidity").equals("N/A")){
                //do nothing
            }
            else if(Double.parseDouble(currentRow.get("Humidity")) >= value){
                total = total + Double.parseDouble(currentRow.get("TemperatureF"));
                count = count + 1;
            }
        }
        avg = total/count;
        return avg;
    }
    
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average Temperature in file is " + averageTemperatureInFile(parser));
    }
    
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord lowestHumidityRow = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityRow.get("Humidity") + " at " + lowestHumidityRow.get("DateUTC"));
    }
    
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("DateUTC"));
    }
    
    public void testColdestInManyDays(){
        CSVRecord smallest = coldestInManyDays();
        System.out.println("The coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    }
    
    public void testFileWithColdestTemperature(){
        System.out.println(fileWithColdestTemperature());
    }
}
