package net.grigoriadi;

import net.grigoriadi.pojo.LogEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Sorts the log and calculate indexes.
 * Since an index cannot be known until end of the log, we are building whole log into the memory first.
 * For a long log that would be inefficient and require external storage solution.
 */
public class SortContext {

    //Original order as appeared in the log
    private final List<LogEntry> entries;

    //Order based on the timestamp of entries
    private final PriorityQueue<LogEntry> logEntryPriorityQueue;

    private static final String SPLIT_CHAR = ",";
    private static final String CUST_PHONE_SPLIT_CHAR = "/";

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SortContext() {
        this.entries = new LinkedList<>();
        //Priority queue with a time based comparator
        this.logEntryPriorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDateTime() == null || o2.getDateTime() == null) {
                throw new IllegalStateException();
            }
            return o1.getDateTime().compareTo(o2.getDateTime());
        });
    }

    /**
     * Handle method for each line of the log.
     * Parses {@link LogEntry} from a line.
     * Adds a record in both a log ordered list and in a datetime ordered queue.
     *
     * @param line line to parse
     */
    public void addLine(String line) {
        //not considering escape characters
        String[] lineEntries = line.split(SPLIT_CHAR);
        String[] customerAndPhone = lineEntries[1].split(CUST_PHONE_SPLIT_CHAR);

        LogEntry logEntry = new LogEntry();
        logEntry.setItem(lineEntries[0]);
        logEntry.setCustomer(customerAndPhone[0]);
        logEntry.setPhoneNumber(customerAndPhone[1]);
        //normalize whitespaces
        logEntry.setDateTime(
                LocalDateTime.parse(
                        lineEntries[2]
                                .trim()
                                .replaceAll("\\s+", " "), DATE_FORMAT));

        entries.add(logEntry);
        logEntryPriorityQueue.add(logEntry);
    }

    /**
     * Traverses a queue ordered by the timestamp and assigns order into the pojo.
     * Returns a list in a original order as appeared in the log.
     *
     * @return A list of pojo
     */
    public List<LogEntry> getEntriesWithOrder() {
        int[] idx = {0};
        logEntryPriorityQueue.forEach(logEntry -> logEntry.setOrder(idx[0]++));
        return this.entries;
    }
}
