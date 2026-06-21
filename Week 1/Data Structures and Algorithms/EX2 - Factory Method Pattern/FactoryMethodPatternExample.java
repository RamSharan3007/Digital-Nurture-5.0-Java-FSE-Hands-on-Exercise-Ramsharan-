public class FactoryMethodPatternExample 
{
    interface Document
    {
        void open();
    }
    static class WordDocument implements Document
    {
        @Override
        public void open() 
        {
            System.out.println("Opening a Word document.");
        }
    }
    static class PdfDocument implements Document
    {
        @Override
        public void open() 
        {
            System.out.println("Opening a PDF document.");
        }
    }
    static class ExcelDocument implements Document
    {
        @Override
        public void open() 
        {
            System.out.println("Opening an Excel document.");
        }
    }
    static abstract class DocumentFactory
    {
        public abstract Document createDocument();
    }
    static class WordDocumentFactory extends DocumentFactory
    {
        @Override
        public Document createDocument() 
        {
            return new WordDocument();
        }
    }
    static class PdfDocumentFactory extends DocumentFactory
    {
        @Override
        public Document createDocument() 
        {
            return new PdfDocument();
        }
    }
    static class ExcelDocumentFactory extends DocumentFactory
    {
        @Override
        public Document createDocument() 
        {
            return new ExcelDocument();
        }
    }
    public static void main(String[] args) 
    {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
    }
}
