import java.util.*;

/**
 * A word class that is comparable.
 * 
 * @author Ryan Malloy
 *
 */
public class Word implements Comparable<Word> {

    private String word;
    private int count;
    public int totalCount;

    /**
     * Word Object
     * 
     * @param word  the word.
     * @param count the count of times word appears.
     */
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    /**
     * Creates empty word.
     */
    public Word() {

    }

    /**
     * A setter method that sets the word.
     * 
     * @param word the word to be added to word object.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * A setter method that sets the count to the word.
     * 
     * @param count the number of times word exists.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * A method that returns the word.
     * 
     * @return the word.
     */
    public String getWord() {
        return word;
    }

    /**
     * A method that returns the count of the word.
     * 
     * @return the count of the word.
     */
    public int getCount() {
        return count;
    }

    /**
     * A method that compares two word objects counts.
     * 
     * @Override
     */
    public int compareTo(Word word) {
        int compareCount = ((Word) word).getCount();
        return compareCount - this.count;
    }
}
