# Java Image Processing Toolkit

Welcome to the Java Image Processing Toolkit! This project was created by me as part of the HONORS online Duke University's course, Learn to program in java, on coursera.

## Features

- Convert images to grayscale: Transforms color images into beautiful grayscale.
- Invert colors of images: Creates a negative of the image by inverting its colors.

## Dependencies

This project relies on the `edu.duke` package for handling images and directory resources. Ensure you have this library set up in your project to use the `GrayScaleConverter` and `BatchInversions` classes.

### Prerequisites

- Java Development Kit (JDK)
- `edu.duke` library set up in your project's build path

### Usage

1. **GrayScaleConverter**: To convert images to grayscale, instantiate `GrayScaleConverter` and either call `makeGray()` for individual images or `selectAndConvert()` to convert multiple images selected through a file dialog.

2. **BatchInversions**: To invert the colors of images, instantiate `BatchInversions` and similarly use `makeInversion()` for single images or `selectAndConvert()` for bulk processing.

Implemented are 2 tester methods to try processing on one image, testGray() for converting an image to grayscale and testInverse() for creating a negative version of the image. 
These 2 methods are implemented for testing so they will not save or alter any of your images or files.


```java
ImageResource ir = new ImageResource();
GrayScaleConverter converter = new GrayScaleConverter();
ImageResource gray = converter.makeGray(ir);
gray.draw();
