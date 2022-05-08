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
    /**
     * Checks if previously added numbers is still there
     */
    void checkIfCollectThenCollect() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,4,5");
        collection = summarizer.collect("7,8,9");
        String actual = summarizer.summarizeCollection(collection);
        Object expected = "1-2, 4-5, 7-9";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    /**
     * Checks if previously added numbers is still there test 2
     */
    void checkIfCollectThenEmptyWorks() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,4,5");
        collection = summarizer.collect("");
        String actual = collection.toString();
        Object expected = "[1, 2, 4, 5]";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collectCheck1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1,2,3,4");
        Object expected = "[1, 2, 3, 4]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collectCheck2() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1");
        Object expected = "[1]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void collectOrderedCheck1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        summarizer.collect("1,2,5,3,-9");
        Object expected = "[-9, 1, 2, 3, 5]";
        String actual = summarizer.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheck1() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,5,3,-9");
        Object expected = "-9, 1-3, 5";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheck2() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1");
        Object expected = "1";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheck3() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,3,5,7,9");
        Object expected = "1, 3, 5, 7, 9";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheck4() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("2,3,4,5,6");
        Object expected = "2-6";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void summarizerCheck5() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,4,7,8,9,11");
        Object expected = "1-2, 4, 7-9, 11";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheckWithGivenExample() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = 
        summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Object expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String actual = summarizer.summarizeCollection(collection);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void collectCheckNull() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Object expected = null;
        Collection<Integer> actual = summarizer.collect(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void summarizerCheckNull() {
        GroupIntoRange summarizer = new GroupIntoRange();
        Collection<Integer> collection = summarizer.collect("1,2,3");
        Object expected = null;
        String actual = summarizer.summarizeCollection(null);
        Assertions.assertEquals(expected, actual);
    }
}