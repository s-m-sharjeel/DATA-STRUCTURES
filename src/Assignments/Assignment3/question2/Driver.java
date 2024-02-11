package Assignments.Assignment3.question2;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {

        // question 2:

        DictionaryBST dictionaryBST = new DictionaryBST("./src/Assignments/Assignment3/question2/Dictionary.csv", true);

        System.out.println("finding a word and deleting it:");
        System.out.println(dictionaryBST.find("Zoanthus"));
        dictionaryBST.delete("Zoanthus");
        System.out.println(dictionaryBST.find("Zoanthus"));

        System.out.println("testing to find and delete the root node:");
        System.out.println(dictionaryBST.getRoot().word);
        String rootWord = dictionaryBST.getRoot().word;
        System.out.println(dictionaryBST.find(rootWord));
        dictionaryBST.delete(rootWord);
        System.out.println(dictionaryBST.find(rootWord));

        System.out.println("checking if root word has been updated:");
        System.out.println(dictionaryBST.getRoot().word);

        System.out.println("testing to insert a word and finding it:");
        System.out.println(dictionaryBST.find("messi"));
        dictionaryBST.insert("messi", "goat");
        System.out.println(dictionaryBST.find("messi"));

        // only prints the words and not their meanings in the specified range
        dictionaryBST.printRange(dictionaryBST.getRoot(), "A", "C");

    }

}
