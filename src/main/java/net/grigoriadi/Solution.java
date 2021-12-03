package net.grigoriadi;

import java.io.*;

public class Solution {

    private final String absoluteFileName;

    public Solution(String absoluteFileName) {
        this.absoluteFileName = absoluteFileName;
    }

    public SortContext sort() {
        SortContext sortContext = new SortContext();
        try (FileReader fileReader = new FileReader(absoluteFileName); BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sortContext.addLine(line);
            }
            return sortContext;
        } catch (IOException e) {
            throw new IllegalStateException("File could not be loaded", e);
        }
    }
}
