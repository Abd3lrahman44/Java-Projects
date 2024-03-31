import java.io.*;
import edu.duke.*;


public class BatchInversions {
    
    // Method to invert one image to negative value  
    public ImageResource makeInversion(ImageResource inImage){
        // create new ImageResource with same size as input image
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // Algorithm to invert images (to negative or opposite) => (255 - RGB) = opposite
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int inverseRed = 255 - inPixel.getRed();
            int inverseGreen = 255 - inPixel.getGreen();
            int inverseBlue = 255 - inPixel.getBlue();
            pixel.setRed(inverseRed);
            pixel.setGreen(inverseGreen);
            pixel.setBlue(inverseBlue);
        }
        // returns one inverted image
        return outImage;
    }
    
    // Tester method for makeInversion, pick a photo and inverted version will show on screen
    public void testInverse(){
        ImageResource ir = new ImageResource();
        ImageResource outImage = makeInversion(ir);
        outImage.draw();
    }
    
    
    /* selectAndConvert selects many photos on pc jpg,png,.. and creates
    inverse version, and saves new version to pc as "inverted-photo.jpg".
       */
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inputImage = new ImageResource(f);
            String imageName = f.getName();
            ImageResource inverseImage = makeInversion(inputImage);
            String inverseImageName = "inverted-" + imageName;
            inverseImage.setFileName(inverseImageName);
            inverseImage.draw();
            inverseImage.save();
        }
    }
}
