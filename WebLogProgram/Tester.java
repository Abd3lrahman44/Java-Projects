
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la1 = new LogAnalyzer();
        la1.readFile("short-test_log");
        la1.printAll();
    }
    
    public void testUniqueIps(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIps() + "UniqueIps");
    }
    
    public void testPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        String day = "Mar 17";
        System.out.println(la.uniqueIPVisitsOnDay(day).size());
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println(la.countUniqueIPsInRange(200,299));
    }

    
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, Integer> map = la.countVisitsForIp();
        System.out.println(la.iPsForDays());
        System.out.println("MAP" + map);
        System.out.println("max of visits by ip: " + la.mostNumberVisitsByIP(map));
        System.out.println("List of ips with max: " + la.iPsMostVisits(map));
    }
    
    public void testIpsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsForDays());
        
    }
    
    public void testDayWithMostIp(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(map));
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        String someday = "Sep 30";
        System.out.println(la.iPsWithMostVisitsOnDay(map, someday));
    }
    
    public void quizTest(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println(la.iPsWithMostVisitsOnDay(map, "Sep 30"));
        //ArrayList<String> list = la.uniqueIPVisitsOnDay("Sep 24");
        //System.out.println(la.countUniqueIPsInRange(400,499));
        //System.out.println(la.countUniqueIps());
        
        //HashMap<String, ArrayList<String>> map = la.iPsForDays();
        //System.out.println(la.iPsWithMostVisitsOnDay(map, "Mar 17"));
    }
}
