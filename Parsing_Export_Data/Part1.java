
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        System.out.print(countryInfo(parser, "Nauru"));
        listExportersTwoProducts(parser, "fish", "nuts");
        System.out.println(numberOfExporters(parser, "sugar"));
        bigExporters(parser, "$999,999,999,999");
        
    }
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String Country = record.get("Country");
            String Exports = record.get("Exports");
            String Value = record.get("Value (dollars)");
            if(Country.contains(country)){
                return country + ": " + Exports + ": " + Value;
            }
        }
        
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String Country = record.get("Country");
            String Exports = record.get("Exports");
            if(Exports.contains(exportItem1) && Exports.contains(exportItem2)){
                System.out.println(Country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record : parser){
            String Exports = record.get("Exports");
            if(Exports.contains(exportItem)){
                count++;                
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            String Value = record.get("Value (dollars)");
            String Country = record.get("Country");
            if(Value.length() > amount.length()){
                System.out.println(Country + " " + Value);    
            }
        }
    }
}
