package ucu.edu.ua;

public abstract class DocumentDecorator implements Document {
    protected Document document;

    public DocumentDecorator(Document document) {
        this.document = document;
    }

    @Override
    public String parse(String path) {
        return document.parse(path);
    }
}
