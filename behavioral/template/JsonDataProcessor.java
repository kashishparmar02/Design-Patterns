package behavioral.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete subclass for processing JSON data in ETL pipeline.
 */
public class JsonDataProcessor extends DataProcessor {

    @Override
    protected void extractData() {
        // Simulate extracting data from JSON (e.g., name fields)
        data.add("{\"name\":\"alice\"}");
        data.add("{\"name\":\"bob\"}");
    }

    @Override
    protected void transformData() {
        // Transform: Extract name from JSON-like string and reverse it
        List<String> transformed = new ArrayList<>();
        for (String json : data) {
            String name = json.substring(json.indexOf(":") + 2, json.length() - 2);
            transformed.add(new StringBuilder(name).reverse().toString());
        }
        data = transformed;
    }

    @Override
    protected void loadData() {
        // Simulate loading: Append with "_loaded"
        data = data.stream()
                   .map(name -> name + "_loaded")
                   .toList();
    }
}
