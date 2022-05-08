package numberrangesummarizer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/** Implements NumberRangeSummarizer to collect and summarize/group
 *  together sequential numbers.
*/
public class GroupIntoRange implements NumberRangeSummarizer {
    private LinkedList<Integer> numbers;

    public GroupIntoRange() {
        numbers = new LinkedList<Integer>();
    }

    public Collection<Integer> collect(String input) { 
        // If input is null return
        if (input == null) {
            return null;
        }
        String[] split_string = input.split(",");
        // If an empty string is passed in, return previously saved numbers 
        if (input.isEmpty()) return numbers;

        // Loops over input and adds the numbers to 'numbers'
        for (int i = 0; i < split_string.length; i++) {
            try{
                orderedAdd(Integer.parseInt(split_string[i]));
            } catch (NumberFormatException e) {
                System.out.printf("'%s' is not a number\n", split_string[i]);
            }
        }
        return numbers;
    }

    /**
     * Summarizes sequential numbers
     * @param input Collection<Integer> to summarize
     * @return String of summarized numbers
     */
    public String summarizeCollection(Collection<Integer> input) {
        // The string holding the return value
        String grouped;

        // If input is null return
        if (input == null) {
            return null;
        }

        // Returns empty string if input is empty
        if (input.isEmpty()) return "";

        Iterator itr = input.iterator();

        int start = (int) itr.next();
        grouped = "";
        
        int x = start;
        int previous = x;
        // Adds numbers sequentially
        while (itr.hasNext()) {
            previous = x;
            x = (int) itr.next();
            if (x == previous) {
                continue;
            } else if (x == previous + 1) {
                previous = x;
            } else if (start == previous) {
                if (!grouped.isEmpty()) {
                    grouped += ", ";
                }
                grouped += previous;
                start = x;
            } else {
                if (!grouped.isEmpty()) {
                    grouped += ", ";
                }
                grouped += start + "-" + previous;
                start = x;
            }
        }

        // Adds the final number
        if (start == x) {
            if (!grouped.isEmpty()) {
                grouped += ", ";
            }
            grouped += x;
        } else {
            if (!grouped.isEmpty()) {
                grouped += ", ";
            }
            grouped += start + "-" + x;
        }
        
        return grouped;
    }

    /**
     * Takes in an Integer x and adds them sorted to 'numbers'
     * @param x the Integer to add
     */
    private void orderedAdd(Integer x) {
        Iterator itr = numbers.iterator();

        if (numbers.size() == 0) {
            numbers.add(x);
        } else if (numbers.get(0) > x) {
            numbers.add(0, x);
        } else if (numbers.get(numbers.size() - 1) < x) {
            numbers.add(x);
        } else {
            int i = 0;
            while (numbers.get(i) < x) {
                i++;
            }
            numbers.add(i, x);
        }
    }
    
    @Override
    public String toString() {
        return numbers.toString();
    }
}


