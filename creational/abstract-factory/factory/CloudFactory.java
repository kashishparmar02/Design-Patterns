package factory;
import product.*;

/**
 * Abstract factory for creating cloud infrastructure families.
 * Each concrete factory creates compatible cloud components.
 */
public interface CloudFactory {
    ComputeInstance createComputeInstance();
    Database createDatabase();
    Storage createStorage();
}