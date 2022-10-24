import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.*;

/**
 * The driver class that runs the main method searching and sorting words from a
 * file.
 * 
 * @author Ryan Malloy
 *
 */
public class Driver {

    private static ArrayList<Word> list;
    private static int fileWordCount = 0;

    public static void main(String args[]) {
        // Start time
        long startTime = System.currentTimeMillis();

        // Initializing list.
        list = new ArrayList<>();

        System.out.print("Enter the directory name: ");

        Scanner in = new Scanner(System.in);
        String file = in.next();

        // Catching if file is found.
        try {
            load(file);
            // Closing scanner.
            in.close();
            // Printing end time.
            long endTime = System.currentTimeMillis();
            System.out.println("\n" + (endTime - startTime) + " milliseconds");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (NullPointerException e) {
            System.out.println("File not Found");
        }

    }

    /**
     * A method that loads files from foler.
     * 
     * @param file file in folder.
     * @throws FileNotFoundException
     */
    public static void load(String file) throws FileNotFoundException {
        File folder = new File(file);
        File[] files = folder.listFiles();
        Arrays.sort(files);
        System.out.print("The files are: \n");
        for (File f : files) {
            System.out.println(f.toString());
        }
        for (File f : files) {
            read(f);
            print(f);
        }
    }

    /**
     * A method that reads an individual file and creates a word object. with
     * the next word.
     * 
     * @param file file that is being read.
     * @throws FileNotFoundException
     */
    public static void read(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter("[^a-zA-Z]+");
        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            Word w = new Word(word, 0);
            checkList(w);
        }
        sc.close();
    }

    /**
     * A method that checks the list to see if the word is in it.
     * 
     * @param word word that is being checked agaisnt list.
     * @return true if the word is in the list, false if not.
     */
    public static boolean checkList(Word word) {
        if (list.isEmpty()) {
            list.add(word);
            word.setCount(word.getCount() + 1);
            fileWordCount++;
            return false;
            // Checking if word is one of the words to ignore.
        } else if (word.getWord().equals("the")) {
            return false;
        } else if (word.getWord().equals("a")) {
            return false;
        } else if (word.getWord().equals("an")) {
            return false;
        } else if (word.getWord().equals("and")) {
            return false;
        } else {

            for (Word w : list) {
                // If word in the list then increase its count and total word
                // count in file.
                if (word.getWord().equals(w.getWord())) {
                    w.setCount(w.getCount() + 1);
                    fileWordCount++;
                    return true;
                }
            }
        }
        list.add(word);
        word.setCount(word.getCount() + 1);
        fileWordCount++;
        return false;
    }

    /**
     * A method that prints the top ten most common words in the list.
     * 
     * @param file the file that the words are being pulled from.
     */
    public static void print(File file) {
        // Sorting the list.
        Collections.sort(list);

        System.out.println("The total number of words in " + file.toString()
                + " is: " + fileWordCount);
        System.out.println("The top ten words in " + file.toString());

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    list.get(i).getWord() + "\t\t" + list.get(i).getCount());
        }
    }
}
