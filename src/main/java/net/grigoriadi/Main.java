package net.grigoriadi;

import net.grigoriadi.pojo.LogEntry;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileUrl;
        if (args.length > 0) {
            fileUrl = args[0];
        } else {
            fileUrl = System.getProperty("inputAbsolutePath");
        }
        if (fileUrl == null) {
            System.out.println("Input file not provided, falling back to bundled resource in jar. \n");
            fileUrl = Solution.DEFAULT;
        }
        Solution solution = new Solution(fileUrl);
        List<LogEntry> logEntries = solution.getLogEntries();

        logEntries.forEach(
                logEntry ->
                        System.out.printf("%s|%02d|%s \n",
                                logEntry.getCustomer(),
                                logEntry.getOrder(),
                                logEntry.getItem()));
    }
}
