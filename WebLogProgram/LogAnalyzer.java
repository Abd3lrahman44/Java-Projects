
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import java.text.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
     
     
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
             LogEntry log = WebLogParser.parseEntry(line);
             records.add(log);
         }
     }
    
     
     public int countUniqueIps(){
         HashMap <String, Integer> uniques = countVisitsForIp();
         return uniques.size();
     }
     
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> uniqueIPVisitsOnDay = new ArrayList<String>();
         for(LogEntry log : records){
             if(log.getAccessTime().toString().contains(someday)){
                 String Ip = log.getIpAddress();
                 if(!uniqueIPVisitsOnDay.contains(Ip)){
                     uniqueIPVisitsOnDay.add(Ip);
                 }
             }
         }
         return uniqueIPVisitsOnDay;
     }
     
     
     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> uniques = new ArrayList<String>();
         for(LogEntry log : records){
             int statusCode = log.getStatusCode();
             String logIp = log.getIpAddress();
             if(statusCode >= low && statusCode <= high){    
                 if(!uniques.contains(logIp)){
                     uniques.add(logIp);
                 }
             }
         }
         return uniques.size();
     }
     
     
     public HashMap<String, Integer> countVisitsForIp(){
         HashMap<String, Integer> map = new HashMap<String, Integer>();
         
         for(LogEntry log : records){
             String Ip = log.getIpAddress();
             map.put(Ip, map.getOrDefault(Ip,0) + 1);
         }
         
         return map;
     }
     
     
     public int mostNumberVisitsByIP(HashMap<String, Integer> map){
         int max = 0;
         
         for(String ip : map.keySet()){
             if(map.get(ip) > max){
                 max = map.get(ip);
             }
         }
         
         return max;
     }
     
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map){
         ArrayList <String> list = new ArrayList<>();
         int max = mostNumberVisitsByIP(map);
         
         for(String ip : map.keySet()){
             if(map.get(ip) == max){
                 list.add(ip);
             }
         }
         
         return list;
     }
     
     
     public HashMap<String, ArrayList<String>> iPsForDays() {
         HashMap<String, ArrayList<String>> ipsForDays = new HashMap<>();
         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
         for (LogEntry le : records) {
             String day = sdf.format(le.getAccessTime());
             String ip = le.getIpAddress();
             if (!ipsForDays.containsKey(day)) {
                 ipsForDays.put(day, new ArrayList<String>());
             }
             ipsForDays.get(day).add(ip);
         }
         return ipsForDays;
     }
     
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
         int max = 0;
         String Max = null;
         for(String s : map.keySet()){
             if(map.get(s).size() > max){
                 max = map.get(s).size();
                 Max = s;
             }
         }
         return Max;
     }
     
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> daysIPs, String day) {
        ArrayList<String> ipAddressesOnDay = daysIPs.getOrDefault(day, new ArrayList<String>());
        HashMap<String, Integer> ipCounts = new HashMap<>();
    
        for (String ip : ipAddressesOnDay) {
            ipCounts.put(ip, ipCounts.getOrDefault(ip, 0) + 1);
        }
    
        return iPsMostVisits(ipCounts); // Uses the iPsMostVisits method defined earlier
    }

     
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
     public void printAllHigherThanNum(int num){
         for(LogEntry log : records){
             if(log.getStatusCode() > num){
                 System.out.println(log);
             }
         }
     }
}
