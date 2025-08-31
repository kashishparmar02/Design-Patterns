package behavioral.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for ETL pipeline using Template Method pattern.
 * Defines the skeleton of the ETL process with customizable steps.
 */
public abstract class DataProcessor {
    protected List<String> data;

    // Template method: Defines ETL pipeline and returns processed data.
    public final List<String> processData() {
        data = new ArrayList<>();
        extractData();
        transformData();
        loadData();
        return data;
    }

    // Abstract methods for ETL steps to be implemented by subclasses.
    protected abstract void extractData();
    protected abstract void transformData();
    protected abstract void loadData();
}
