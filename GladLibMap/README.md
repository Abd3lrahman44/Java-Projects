# GladLibMap

### Creator
Abdulrahman Zaghloul [LinkedIn](https://www.linkedin.com/in/abdulrahman-zaghloul-876735295/)

## Overview
GladLibMap is a Java project that generates random stories by replacing placeholder text (such as `<noun>`, `<adjective>`, etc.) with actual words from a specified category. This is an extension of the traditional Mad Libs game, utilizing a HashMap to organize word categories and their corresponding lists of words. The project demonstrates an understanding of Java Collections Framework, particularly the use of HashMaps and ArrayLists, along with basic file I/O operations to read from a set of predefined files or URLs.

## Features

- **Dynamic Word Replacement**: Utilizes a HashMap to map categories (like "noun", "adjective", etc.) to a list of possible words.
- **Customizable Source for Word Lists**: Allows word lists to be loaded from a specified directory or URL, making it easy to customize the vocabulary.
- **Unique Replacement**: Ensures that words are not repeated in the same story, for a wider variety of generated content.
- **Story Template Processing**: Processes templates from files or URLs, replacing placeholders with appropriate words from the corresponding categories.
- **Statistics**: After generating a story, it outputs statistics such as the total number of words replaced and the total number of words available in the used categories.

## Getting Started

To get started with the GladLibMap project, you will need to have Java installed on your system. This project is built and tested with Java SE 8 or higher.

### Usage

After running the application, it will automatically generate a story based on the template provided in the `data/madtemplate2.txt` file (or another specified template file). The console will output the generated story along with some statistics about the word replacement process.

To create custom stories, you can modify the template file or add new ones, following the placeholder format (e.g., `<noun>`, `<adjective>`). Ensure your word lists in the specified source directory are updated accordingly.

## Contributing

Contributions to the GladLibMap project are welcome. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your_feature_name`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your_feature_name`).
5. Open a pull request.

## Acknowledgments

- This project is part of the Java Programming: Arrays, Lists, and Structured Data course by Duke University on Coursera.
- Thanks to the instructors and the community for providing the inspiration and foundation for this project.


