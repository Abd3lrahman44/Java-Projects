# Words In Files (HashMaps)

## Creator
Abdulrahman Zaghloul [LinkedIn](https://www.linkedin.com/in/abdulrahman-zaghloul-876735295/)

## Project Overview
Words In Files is a Java application designed to analyze occurrences of words across multiple files. It maps each word found in the selected files to a list of files in which that word appears. This utility is particularly useful for identifying common words in literature, cross-referencing documents, or simply organizing textual data.

## Features
- **Word Frequency Analysis**: Determine how frequently each word appears across multiple files.
- **File Mapping**: Identify which files contain a given word.
- **Max Frequency Finder**: Discover the maximum number of files any single word appears in.
- **Selective Word Listing**: Generate lists of words that appear in a specific number of files.

## How to Run
Ensure you have Java installed on your system. Compile the WordsInFiles class and run the main method. The application uses the Duke University `edu.duke` library for file selection and reading, so make sure this library is included in your project setup.

```bash
javac WordsInFiles.java
java WordsInFiles
