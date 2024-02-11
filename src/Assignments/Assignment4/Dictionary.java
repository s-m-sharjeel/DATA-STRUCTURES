package Assignments.Assignment4;

public class Dictionary {

    private final String word;
    private final String meaning;

    public Dictionary(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    /**
     * O(1)
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * O(1)
     * @return a string containing the word and its meaning
     */
    @Override
    public String toString() {
        return "Dictionary{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
