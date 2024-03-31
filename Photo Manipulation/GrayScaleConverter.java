import java.io.*;
import edu.duke.*;

public class GrayScaleConverter {
    
    // Algorithm to convert image to grayscale
    public ImageResource makeGray(ImageResource inImage){
        // create new empty image of same size as input
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        // for each pixel set RGB to average to make gray 
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        // returns the output gray image of type ImageResource
        return outImage;
    }
    
    
    public void testGray(){
        // Tester method to makeGray() converts one image to grayscale and draws on screen
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    
    public void selectAndConvert(){
        // Algorithm to convert many images to grayscale and save them on the pc
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f); 
            ImageResource gray = makeGray(inImage); 
            String fileName = f.getName(); // Gets image name
            String grayCopy = "gray-" + fileName; // create new image name by appending "gray-" before name 
            gray.setFileName(grayCopy);
            gray.draw(); // draws on screen
            gray.save(); // saves to pc
        }
    }
    
    
}
