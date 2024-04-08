# GladLibs Project

## Creator

Abdulrahman Zaghloul [LinkedIn](linkedin.com/in/abdulrahman-zaghloul-876735295/)

## Overview

The GladLibs project is an exciting and educational venture into the world of language, creativity, and programming. Utilizing Java, this project dynamically generates stories by randomly replacing words in a template with others of the same category, such as nouns, verbs, and adjectives. It's inspired by the classic "Mad Libs" games but takes it a step further by integrating programming skills to automate and expand the creative process.

### Features

- **Dynamic Story Generation:** Leveraging Java's robust programming capabilities, GladLibs creates engaging and humorous stories by filling in a template with random words from specified categories.
- **Customizable Word Lists:** Users can modify the source word lists for different categories, such as animals, colors, countries, names, and more, to tailor the story outcomes to their preferences.
- **Unique Word Replacement:** Ensures that each placeholder in the story template is filled with a unique word, maximizing the variety and unpredictability of each generated story.
- **Template Flexibility:** Supports multiple story templates, allowing for a wide range of story types and themes. Users can easily add new templates to the project.
- **Educational Tool:** Beyond entertainment, GladLibs serves as an excellent educational tool, demonstrating key programming concepts, data structures, and file handling in Java.

### How It Works

1. **Initialization:** Upon execution, the program initializes by loading word lists from specified files into corresponding ArrayLists for various categories like adjectives, nouns, verbs, etc.
2. **Template Processing:** The program selects a story template and identifies placeholders for random words (e.g., `<noun>`, `<verb>`).
3. **Word Replacement:** For each placeholder, it randomly selects an appropriate word from the corresponding category list, ensuring no repetition within the same story.
4. **Story Generation:** After replacing all placeholders, the program outputs the completed story, filled with random, contextually appropriate words.
5. **Unique and Count Tracking:** It keeps track of all unique words used and the total number of words replaced, displaying this information upon story completion.

### Getting Started

1. **Clone the Repository:**
    ```sh
    git clone https://github.com/yourusername/gladlibs-project.git
    ```
2. **Compile the Java Program:**
    ```sh
    javac GladLib.java
    ```
3. **Run the Application:**
    ```sh
    java GladLib
    ```

### Contributing

Contributions to the GladLibs project are welcome! Whether it's adding new word lists, creating story templates, or suggesting feature improvements, your input is valued. Please follow the standard GitHub pull request process to submit your contributions.

### Acknowledgments

- The structure and concept were inspired by Duke University's Java Programming and Software Engineering Fundamentals Specialization on Coursera.
- Special thanks to all contributors and the open-source community for support and contributions.

Enjoy crafting your unique and whimsical stories with GladLibs!
