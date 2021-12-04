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

    //Order based on the timestamp of entries split by customer name
    private final Map<String, PriorityQueue<LogEntry>> logEntryPriorityQueue;

    private static final String CUST_PHONE_SPLIT_CHAR = "/";

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SortContext() {
        this.entries = new LinkedList<>();
        //Priority queue with a time based comparator
        this.logEntryPriorityQueue = new HashMap<>();
    }

    /**
     * Handle method for each line of the log.
     * Parses {@link LogEntry} from a line.
     * Adds a record in both a log ordered list and in a datetime ordered queue.
     *
     * @param line line to parse
     */
    public void addLine(String[] line) {
        String[] customerAndPhone = line[1].split(CUST_PHONE_SPLIT_CHAR);

        //create pojo from line values
        LogEntry logEntry = new LogEntry();
        logEntry.setItem(line[0].trim());
        logEntry.setCustomer(customerAndPhone[0].trim());
        logEntry.setPhoneNumber(customerAndPhone[1]);
        //normalize whitespaces in date and parse
        logEntry.setDateTime(
                LocalDateTime.parse(
                        line[2]
                                .trim()
                                .replaceAll("\\s+", " "), DATE_FORMAT));

        //add to original order list
        entries.add(logEntry);

        //add to timestamp ordered queue per each customer
        PriorityQueue<LogEntry> customerLogEntries = logEntryPriorityQueue.computeIfAbsent(logEntry.getCustomer(), s -> new PriorityQueue<>((o1, o2) -> {
            if (o1.getDateTime() == null || o2.getDateTime() == null) {
                throw new IllegalStateException();
            }
            return o1.getDateTime().compareTo(o2.getDateTime());
        }));
        customerLogEntries.add(logEntry);
    }

    /**
     * Traverses a queue ordered by the timestamp and assigns order into the pojo for each customer.
     * Returns a list in an original order as appeared in the log with order assigned.
     *
     * @return A list of pojo
     */
    public List<LogEntry> getEntriesWithOrder() {
        //Iterate each of the customer queue ordered by date
        logEntryPriorityQueue.values().forEach(logEntries -> {
            int idx = 0;
            LogEntry logEntry;
            while ((logEntry = logEntries.poll()) != null) {
                logEntry.setOrder(++idx);
            }
        });
        return this.entries;
    }
}
