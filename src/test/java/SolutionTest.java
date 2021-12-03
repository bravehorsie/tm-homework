import net.grigoriadi.Solution;
import net.grigoriadi.SortContext;
import net.grigoriadi.pojo.LogEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testSolution() {
        String filePath = System.getenv("filePath");
        if (filePath == null) {
            throw new IllegalStateException("Please specify a file path");
        }
        Solution solution = new Solution(filePath);
        SortContext sort = solution.sort();
        List<LogEntry> entriesWithOrder = sort.getEntriesWithOrder();
        entriesWithOrder.forEach(logEntry ->
                System.out.printf("Log entry %s %d %s", logEntry.getCustomer(), logEntry.getOrder(), logEntry.getItem()));
    }
}
