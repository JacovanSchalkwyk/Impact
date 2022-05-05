package numberrangesummarizer;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GroupIntoRange implements NumberRangeSummarizer {
    private LinkedList<Integer> numbers;

    public GroupIntoRange() {
        numbers = new LinkedList<Integer>();
    }

    public Collection<Integer> collect(String input) { 
        String[] split_string = input.split(",");

        if (input.isEmpty()) return numbers;

        for (int i = 0; i < split_string.length; i++) {
            try{
                orderedAdd(Integer.parseInt(split_string[i]));
            } catch (NumberFormatException e) {
                System.out.printf("'%s' is not a number\n", split_string[i]);
            }
        }

        return numbers;
    }

    public String summarizeCollection(Collection<Integer> input) {
        String grouped;


        if (input.isEmpty()) return "";

        Iterator itr = input.iterator();

        int start = (int) itr.next();
        grouped = "";
        
        int x = start;
        int previous = x;
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


