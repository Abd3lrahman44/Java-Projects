# Weather Info (CSV)

## This project was created by me as part of the online Duke University's course, Learn to program in java, on coursera.

### Assignment

You will write a program to find the coldest day of the year and other interesting facts about the temperature and humidity in a day. To test your program, you will use the nc_weather data folder that has a folder for each year

You will write a program with several methods and  tester methods to test each method you write. You should start with the methods from the lesson to find the hottest temperature in a day (and thus in a file) and the hottest temperature in many files and their tester methods. You can use these to write similar methods to find the coldest temperatures.

### 1. Write a method named coldestHourInFile
This method returns the CSVRecord with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. 

You should also write a void method named testColdestHourInFile() to test this method and print out information about that coldest temperature, such as the time of its occurrence.

### 2. Write the method fileWithColdestTemperature
That has no parameters. This method should return a string that is the name of the file from selected files that has the coldest temperature. 

You should also write a void method named testFileWithColdestTemperature() to test this method. 

Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day.

### 3. Write a method named lowestHumidityInFile
This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.

Note that sometimes there is not a number in the Humidity column but instead there is the string “N/A”. This only happens very rarely. You should check to make sure the value you get is not “N/A” before converting it to a number.

Also note that the header for the time is either TimeEST or TimeEDT, depending on the time of year. You will instead use the DateUTC field at the right end of the data file to  get both the date and time of a temperature reading.

You should also write a void method named testLowestHumidityInFile() to test this method.

### 4. Write the method lowestHumidityInManyFiles
This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. 

You should also write a void method named testLowestHumidityInManyFiles() to test this method and to print the lowest humidity AND the time the lowest humidity occurred.

### 5. Write the method averageTemperatureInFile
This method returns a double that represents the average temperature in the file. 

You should also write a void method named testAverageTemperatureInFile() to test this method.

### 6. Write the method averageTemperatureWithHighHumidityInFile
This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. 

You should also write a void method named testAverageTemperatureWithHighHumidityInFile() to test this method.
