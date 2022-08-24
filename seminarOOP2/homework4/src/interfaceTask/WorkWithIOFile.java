package interfaceTask;

import data.DataStorage;

public interface WorkWithIOFile {
    void save(DataStorage ds);
    DataStorage read();
}
