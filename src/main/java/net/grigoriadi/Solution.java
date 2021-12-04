package net.grigoriadi;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import net.grigoriadi.pojo.LogEntry;

import java.io.*;
import java.util.List;

public class Solution {

    public static String DEFAULT = "DEFAULT";

    private final String absoluteFileName;
    private SortContext sortContext = new SortContext();

    public Solution(String absoluteFileName) {
        this.absoluteFileName = absoluteFileName;
    }

    public void readEntries() {
        try (CSVReader csvReader = getCSVReader()) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                sortContext.addLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File could not be loaded", e);
        } catch (CsvValidationException e) {
            throw new IllegalStateException("Invalid CSV file", e);
        }
    }

    /**
     * Provides {@link LogEntry} list in its original order with a property of calculated timestamp order.
     *
     * @return LogEntry list.
     */
    public List<LogEntry> getLogEntries() {
        readEntries();
        return sortContext.getEntriesWithOrder();
    }

    /**
     * Get either default jar included input or read it from filesystem if not provided.
     * @return an CSVReader for input log
     * @throws FileNotFoundException if absolute file path is not found
     */
    private CSVReader getCSVReader() throws FileNotFoundException {
        if (DEFAULT.equals(absoluteFileName)) {
            InputStream defaultInputStream = Main.class.getResourceAsStream("input.txt");
            if (defaultInputStream == null) {
                throw new IllegalStateException("Default log file not found");
            }
            return new CSVReader(new InputStreamReader(defaultInputStream));
        } else {
            return new CSVReader(new FileReader(absoluteFileName));
        }
    }
}
