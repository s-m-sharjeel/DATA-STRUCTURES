package Assignments.Assignment3.question2;

public class DictionaryNode implements Comparable<DictionaryNode> {

    String word;
    String meaning;
    DictionaryNode right;
    DictionaryNode left;

    public DictionaryNode(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    @Override
    public int compareTo(DictionaryNode o) {

        if (this.word.compareTo(o.word) > 0)
            return 1;
        else if (this.word.compareTo(o.word) < 0)
            return -1;

        return 0;

    }

    @Override
    public String toString() {
        return "DictionaryNode{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
