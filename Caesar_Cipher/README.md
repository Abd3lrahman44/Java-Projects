# Text Manipulation Utilities (Caesar Cipher)

This Java-based project encompasses a collection of utilities designed for specific text manipulations, including vowel substitution, strategic character emphasis, and the application of Caesar cipher encryption techniques for text encoding. The suite is bifurcated into two principal classes: `WordPlay`, which focuses on vowel manipulation and character emphasis, and `CaesarCipher`, dedicated to encoding text using Caesar cipher encryption with support for both single and dual encryption keys. 

## Getting Started

This section guides you through getting a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Before you can run this project, you need to have the Java Development Kit (JDK) installed on your system. This project is compatible with JDK 8 or newer versions. You can check your Java version by running `java -version` in your command line.

## Usage
The functionality provided by this project is divided into two main classes: WordPlay and CaesarCipher, each offering unique text manipulation capabilities.

### WordPlay
WordPlay provides methods for:

Checking if a character is a vowel. Replacing all vowels in a given string with another specified character. Emphasizing characters in a string conditionally based on their position and match with a specified character.

### Examples
Vowel Check:
```java
WordPlay wp = new WordPlay();
System.out.println(wp.isVowel('A')); // Expected output: true
```
Replace Vowels:
```java
System.out.println(wp.replaceVowels("Hello World", '*')); // Expected output: "H*ll* W*rld"
```
Emphasize Characters:
```java
System.out.println(wp.emphasize("Mary Bella Abracadabra", 'a')); // Expected output: "M+ry Bell+ +br*c*d+br+"
```
## CaesarCipher
CaesarCipher class is designed for text encryption using the Caesar cipher technique. It supports:

Encrypting a string with a single key.
Encrypting a string with two keys, applying a different key to every other character.
Examples
Single Key Encryption:
```java
CaesarCipher cc = new CaesarCipher();
System.out.println(cc.encryptString("HELLO", 3)); // Expected output: "KHOOR"
```
Dual Key Encryption:
```java
System.out.println(cc.encryptTwoKeys("HELLO WORLD", 3, 4)); // Output depends on the encryption logic
```
### Testing
Included within both classes are methods designed to demonstrate their functionalities. You can run these methods to test the capabilities of WordPlay and CaesarCipher.
