# Web Log Analyzer

## Creator

Abdulrahman Zaghloul[LinkedIn](https://www.linkedin.com/in/abdulrahman-zaghloul-876735295/)

## Description

The Web Log Analyzer is a Java project designed to parse and analyze web server logs to extract meaningful information about web traffic. It provides tools to count unique IP addresses, determine the most frequent visitors, and identify patterns of access across different days.

## Features

- Parse log files to capture web access details.
- Count unique IP addresses from log data.
- Identify days with the highest traffic.
- Determine the most frequent IP addresses on any given day.
- Filter IP addresses based on HTTP status codes.

## Components

The project consists of several Java classes:

- `LogEntry`: Represents a single log entry from a web server.
- `LogAnalyzer`: Provides methods to analyze collections of `LogEntry` objects.
- `WebLogParser`: Handles the parsing of log file lines into `LogEntry` objects.
- `Tester`: Contains methods to test the functionality of the log analysis tools.

## Usage

The core functionality of this project can be accessed through the `LogAnalyzer` class, which uses instances of `LogEntry` to perform various analyses:

1. **Reading and parsing a log file:**
   ```java
   LogAnalyzer analyzer = new LogAnalyzer();
   analyzer.readFile("path/to/logfile.log");
2. **Counting unique IP addresses:**
   ```java
   int uniqueIPs = analyzer.countUniqueIps();
   System.out.println("Unique IPs: " + uniqueIPs);
3. **Finding the day with most IP visits:**
   ```java
   String dayWithMostIPVisits = analyzer.dayWithMostIPVisits(analyzer.iPsForDays());
   System.out.println("Day with most IP visits: " + dayWithMostIPVisits);
4. **Identifying IPs with the most visits on a particular day:**
   ```java
   ArrayList<String> ipsWithMostVisits = analyzer.iPsWithMostVisitsOnDay(analyzer.iPsForDays(), "MMM dd");
   System.out.println("IPs with the most visits on given day: " + ipsWithMostVisits);




