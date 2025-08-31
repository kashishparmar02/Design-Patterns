package behavioral.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete subclass for processing CSV data in ETL pipeline.
 */
public class CsvDataProcessor extends DataProcessor {

    @Override
    protected void extractData() {
        // Simulate extracting data from a CSV file (e.g., rows of names)
        data.add("john,doe,30");
        data.add("jane,smith,25");
    }

    @Override
    protected void transformData() {
        // Transform: Extract first names and convert to uppercase
        List<String> transformed = new ArrayList<>();
        for (String row : data) {
            String[] parts = row.split(",");
            transformed.add(parts[0].toUpperCase());
        }
        data = transformed;
    }

    @Override
    protected void loadData() {
        // Simulate loading: Prefix with "Processed:"
        data = data.stream()
                   .map(name -> "Processed:" + name)
                   .toList();
    }
}