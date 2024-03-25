# Apache Commons CSV Parser Program.

## This project was created by me as part of the online Duke University's course, Learn to program in java, on coursera.

The CSV file exportdata.csv has information on the export products of countries; you can find it in the "exports" file.
In particular it has three column headers labeled Country, Exports, and Value (dollars). The Country column represents a country from the world, the Exports column is a list of export items for a country, and the Value (dollars) column is the dollar amount in millions of their exports in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a value might be “$400,000,000”.

The CSV file exports_small.csv is a smaller version of the file above with the same columns that you may find helpful in testing your program.

### 1. Write a method named tester 
That will create your CSVParser and call each of the methods below in parts 2, 3, 4, and 5. You would start your code with:

### 2. Write a method named countryInfo
That has two parameters, parser is a CSVParser and country is a String. This method returns a string of information about the country or returns “NOT FOUND” if there is no information about the country. The format of the string returned is the country, followed by “: “, followed by a list of the countries’ exports, followed by “: “, followed by the countries export value. For example, using the file exports_small.csv and the country Germany, the program returns the string: Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000

### 3. Write a void method named listExportersTwoProducts
That has three parameters, parser is a CSVParser, exportItem1 is a String and exportItem2 is a String. This method prints the names of all the countries that have both exportItem1 and exportItem2 as export items. For example, using the file exports_small.csv, this method called with the items “gold” and “diamonds” would print the countries

- Namibia
- South Africa

### 4. Write a method named numberOfExporters 
Which has two parameters, parser is a CSVParser, and exportItem is a String. This method returns the number of countries that export exportItem. For example, using the file exports_small.csv, this method called with the item “gold” would return 3.


### 5. Write a void method named bigExporters
That has two parameters, parser is a CSVParser, and amount is a String in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a string might be “$400,000,000”. This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string. You do not need to parse either string value as an integer, just compare the lengths of the strings.
