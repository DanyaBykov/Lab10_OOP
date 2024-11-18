package ucu.edu.ua;

public class TimedDocument extends DocumentDecorator{
    public TimedDocument(Document document) {
        super(document);
    }

    public String parse(String path){
        long startTime = System.nanoTime();
        String result = super.parse(path);
        long endTime = System.nanoTime();

        long durationInNano = endTime - startTime;
        double durationInSec = (double) durationInNano / 1_000_000_000;
        System.out.println("Time spent: " + durationInSec + " seconds");
        return result;
    }
}
