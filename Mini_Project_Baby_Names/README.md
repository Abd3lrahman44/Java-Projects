# Baby Names Data Analysis (United States data)
## This project was created by me as part of the online Duke University's course, Learn to program in java, on coursera.
### Assignment
For this assignment, we are providing data on baby names from the United States and you will
answer questions about this data. The datafiles give information on the first names of people born in
a particular year. We have data from 1880 through 2014 on both boys and girls names.
### Details
You will write a program with several methods and tester methods to test each method you write.
You should start with understanding the methods shown in the video. Specifically you should write
the following methods.
### 1- Modify the method totalBirths
to also print the number of unique girls names , the number of unique boys names and the total names in the file.
### 2- Write the method named getRank
This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. If the name is not in the file, then ­1 is returned. For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’, the number returned is 2, as Mason is the boys name with the second highest number of births. Given the name Mason, the year 2012 and the gender ‘F’, the number returned is ­1 as Mason does not appear with an F in that file.
### 3- Write the method named getName
This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.
### 4-  Write the void method named whatIsNameInYear
What would your name be if you were born in a different year? This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, you should determine the rank of name in the year they were born, and then print the name born in newYearthat is at the same rank and same gender. For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name. If Isabella was born in 2014 instead, she would have been named Sophia, the third most popular girl's name that year.
### 5-  Write the method yearOfHighestRank
This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. If the name and gender are not in any of the selected files, it should return ­1. For example, calling yearOfHighestRankwith name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012. That is because Mason was ranked the 2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.
### 6- Write the method getAverageRank
This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. It should return ­1.0 if the name is not ranked in any of the selected files. For example calling getAverageRank with name Mason and gender ‘M’ and selecting the three test files above results in returning 3.0, as he is rank 2 in the year 2012, rank 4 in 2013 and rank 3 in 2014. As another example, calling getAverageRank with name Jacob and gender ‘M’ and selecting the three test files above results in returning 2.66.
### 7- Write the method getTotalBirthsRankedHigher
This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name. For example, if getTotalBirthsRankedHigheraccesses the "yob2012short.csv" file with name set to “Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.
____________________________________________________________________________________________________________
## What I learned from this project
Working on this project offered me a unique chance to dive deep into the intricacies of data manipulation and analysis through programming. Handling a dataset filled with names and the frequency of their occurrence over years provided me with a real glimpse into scenarios where data is not just vast but rich with insights waiting to be uncovered. This experience proved invaluable in developing my proficiency in file operations, string manipulation, and understanding the nuances of dataset handling in a programming context.

Through implementing various methods to analyze baby name popularity trends, like `getRank`, `getName`, `whatIsNameInYear`, `yearOfHighestRank`, `getAverageRank`, and `getTotalBirthsRankedHigher`, I gained practical skills in algorithm development and honed my problem-solving capabilities. These tasks allowed me to explore data sorting, searching, and averaging operations common in data science and analytics fields. By executing tasks like determining a name's rank based on birth records, finding equivalent names across different years based on their popularity, and calculating average ranks, I learned to apply programming logic to tangible data, turning abstract concepts into concrete solutions. Moreover, dealing with edge cases, such as names not present in the dataset, taught me to write robust, fault-tolerant code.

Furthermore, this project emphasized the importance of writing clean, maintainable code. Structuring my program to include both functional logic and testing routines reinforced best practices in software development. This dual focus didn’t just enhance my coding skills but also instilled a disciplined approach to testing and validation, critical components of successful software development. The iterative process of writing a method and then crafting a test to verify its correctness under various scenarios fostered an appreciation for the meticulous nature of programming. It also highlighted the significance of understanding user requirements, ensuring that the software I developed met those needs effectively.

Overall, the baby name analysis project was a comprehensive exercise that strengthened my programming foundation, boosted my problem-solving skills, and honed my ability to manipulate and analyze data, preparing me for more complex challenges in the fields of data science, software development, and beyond.
