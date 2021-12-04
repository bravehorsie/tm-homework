package net.grigoriadi;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class Solution {

    private final String absoluteFileName;

    public Solution(String absoluteFileName) {
        this.absoluteFileName = "DEFAULT".equals(absoluteFileName) ?
            getJarResourceUri() : absoluteFileName;
    }

    private String getJarResourceUri() {
        //TODO
        return null;
    }

    public SortContext sort() {
        SortContext sortContext = new SortContext();
        try (CSVReader csvReader = new CSVReader(new FileReader(absoluteFileName))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                sortContext.addLine(line);
            }
            return sortContext;
        } catch (IOException e) {
            throw new IllegalStateException("File could not be loaded", e);
        } catch (CsvValidationException e) {
            throw new IllegalStateException("Invalid CSV file", e);
        }
    }
}
