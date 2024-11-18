package ucu.edu.ua;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class CachedDocument extends DocumentDecorator {
    private Tesseract tesseract;

    public CachedDocument(Document document){
        super(document);
        tesseract = new Tesseract();
        tesseract.setDatapath("/opt/homebrew/share/tessdata");
        tesseract.setLanguage("eng");
    }

    @Override
    public String parse(String path){
        String parsed = "cached document";

        try {
            File imageFile = new File(path);
            if (!imageFile.exists()) {
                System.err.println("Image file not found at path: " + path);
                return null;
            }
            if (!imageFile.canRead()) {
                System.err.println("Cannot read image file at path: " + path);
                return null;
            }

            parsed = tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            System.err.println("Error during OCR processing.");
            e.printStackTrace();
        }
        return parsed;
    }
}