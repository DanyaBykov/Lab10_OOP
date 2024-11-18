import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.CachedDocument;
import ucu.edu.ua.Document;
import ucu.edu.ua.SmartDocument;
import ucu.edu.ua.TimedDocument;


public class TestDecorator {

	@Test
	public void testCachedDocument() {
        Document document = new CachedDocument(new SmartDocument());
        String imagePath = "/Users/daniilbykov/Documents/Java projects/OOP/lab_10/test.png";
    
        try {
            String content = document.parse(imagePath);
            Assertions.assertNotNull(content);
            Assertions.assertNotEquals(content, "cached document");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    @Test
    public void testTimedDocument() {
        Document document = new TimedDocument(new SmartDocument());
        
        String time = document.parse("/Users/daniilbykov/Documents/Java projects/OOP/lab_10/test.png");
        
        System.out.println(time);
    }
	
}
