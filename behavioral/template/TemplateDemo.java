package behavioral.template;

public class TemplateDemo {
    public static void main(String[] args) {
        // Process CSV data
        DataProcessor csvProcessor = new CsvDataProcessor();
        System.out.println("CSV ETL Result: " + csvProcessor.processData());

        // Process JSON data
        DataProcessor jsonProcessor = new JsonDataProcessor();
        System.out.println("JSON ETL Result: " + jsonProcessor.processData());
    }
}
