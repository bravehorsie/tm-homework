import net.grigoriadi.Solution;
import net.grigoriadi.pojo.LogEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution(Solution.DEFAULT);
        List<LogEntry> entriesWithOrder = solution.getLogEntries();

        LogEntry current = entriesWithOrder.get(0);
        Assertions.assertEquals(2, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("payment weekly", current.getItem());

        current = entriesWithOrder.get(1);
        Assertions.assertEquals(1, current.getOrder());
        Assertions.assertEquals("Apple", current.getCustomer());
        Assertions.assertEquals("game Of Thrones", current.getItem());

        current = entriesWithOrder.get(2);
        Assertions.assertEquals(1, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("payment yearly", current.getItem());

        current = entriesWithOrder.get(3);
        Assertions.assertEquals(2, current.getOrder());
        Assertions.assertEquals("Microsoft", current.getCustomer());
        Assertions.assertEquals("Office 365", current.getItem());

        current = entriesWithOrder.get(4);
        Assertions.assertEquals(1, current.getOrder());
        Assertions.assertEquals("Microsoft", current.getCustomer());
        Assertions.assertEquals("Office 365", current.getItem());

        current = entriesWithOrder.get(5);
        Assertions.assertEquals(2, current.getOrder());
        Assertions.assertEquals("Apple", current.getCustomer());
        Assertions.assertEquals("payment weekly", current.getItem());

        current = entriesWithOrder.get(6);
        Assertions.assertEquals(3, current.getOrder());
        Assertions.assertEquals("Microsoft", current.getCustomer());
        Assertions.assertEquals("application Any.DO", current.getItem());

        current = entriesWithOrder.get(7);
        Assertions.assertEquals(3, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("new subscription", current.getItem());

        current = entriesWithOrder.get(8);
        Assertions.assertEquals(9, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("installation of Modem", current.getItem());

        current = entriesWithOrder.get(9);
        Assertions.assertEquals(7, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("Sport 02", current.getItem());

        current = entriesWithOrder.get(10);
        Assertions.assertEquals(6, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("monthly subscription", current.getItem());

        current = entriesWithOrder.get(11);
        Assertions.assertEquals(8, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("O2TV, SportTV", current.getItem());

        current = entriesWithOrder.get(12);
        Assertions.assertEquals(4, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("game Of thrones", current.getItem());

        current = entriesWithOrder.get(13);
        Assertions.assertEquals(5, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("yearly subscription", current.getItem());

        current = entriesWithOrder.get(14);
        Assertions.assertEquals(10, current.getOrder());
        Assertions.assertEquals("Netflix", current.getCustomer());
        Assertions.assertEquals("recharging of 987654321", current.getItem());

        entriesWithOrder.forEach(logEntry ->
                System.out.printf("%s %d %s %s \n", logEntry.getDateTime(), logEntry.getOrder(), logEntry.getCustomer(), logEntry.getItem()));
    }
}
