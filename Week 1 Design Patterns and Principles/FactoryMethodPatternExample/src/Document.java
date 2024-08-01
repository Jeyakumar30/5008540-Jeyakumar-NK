public interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }

    @Override
    public void close() {
        System.out.println("Word Document Closed.");
    }
}


class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }

    @Override
    public void close() {
        System.out.println("PDF Document Closed.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document.");
    }

    @Override
    public void close() {
        System.out.println("Excel Document Closed.");
    }
}