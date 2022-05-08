import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import numberrangesummarizer.GroupIntoRange;

/* A tester where you can use the data/numbers.txt file
 * to import a list of numbers.
*/
public class tester {
    public static void main(String[] args){
        String input_numbers = null;
        GroupIntoRange summarizer;
        if (args.length != 1) {
            System.out.println("Error: Usage = java numberrangesummarizer.GroupIntoRange <filename>");
        }        
        
        String file_name = args[0];
        summarizer = new GroupIntoRange();

        try 
        {
            Path file = Path.of(file_name);
            input_numbers = Files.readString(file);
        }
        catch (IOException e)
        {
            System.out.println("ERROR: Unable to read in file");
        }
        
        Collection<Integer> collection = summarizer.collect(input_numbers);

        String summarized_numbers = summarizer.summarizeCollection(collection);

        System.out.println(summarizer.toString());
        System.out.println(summarized_numbers);





    }
}