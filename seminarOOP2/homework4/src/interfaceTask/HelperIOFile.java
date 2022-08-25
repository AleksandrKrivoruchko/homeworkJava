package interfaceTask;

import data.Level;

public interface HelperIOFile extends WorkWithIOFile{
    public default Level getLevel(String s) {
        Level l;
        if (s.equals("HIGH")) {
            l = Level.HIGH;
        } else if (s.equals("MIDDLE")) {
            l = Level.MIDDLE;
        } else {
            l = Level.LOW;
        }
        return l;
    }
}
