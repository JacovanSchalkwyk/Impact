import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import numberrangesummarizer.GroupIntoRange;
import java.util.Collection;

public class GroupIntoRangeTest {
    
    @Test
    void checkIfEmptyWorks() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Object expected = "[]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collect_check1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1,2,3,4");
        Object expected = "[1, 2, 3, 4]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collect_check2() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1");
        Object expected = "[1]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collect_ordered_check1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1,2,5,3,-9");
        Object expected = "[-9, 1, 2, 3, 5]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizer_check_1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,5,3,-9");
        Object expected = "-9, 1-3, 5";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizer_check_2() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1");
        Object expected = "1";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizer_check_3() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,3,5,7,9");
        Object expected = "1, 3, 5, 7, 9";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizer_check_4() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("2,3,4,5,6");
        Object expected = "2-6";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void summarizer_check_5() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,4,7,8,9,11");
        Object expected = "1-2, 4, 7-9, 11";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizer_check_with_given_example() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = 
        summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Object expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }
}