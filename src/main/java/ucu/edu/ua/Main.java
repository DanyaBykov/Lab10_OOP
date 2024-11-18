package ucu.edu.ua;

public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument();

        Document c_document = new CachedDocument(document);
        String imagePath = "/Users/daniilbykov/Documents/Java projects/OOP/lab_10/test.png";
    
        try {
            String content = c_document.parse(imagePath);
            if (content != null) {
                System.out.println("OCR Output:");
                System.out.println(content);
            } else {
                System.err.println("Failed to perform OCR on the image.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TimedDocument t_document = new TimedDocument(document);

        t_document.parse("/Users/daniilbykov/Documents/Java projects/OOP/lab_10/test.png");
    }
}