package Assignments.Assignment4;

public class HashTable {

    private final Dictionary[] table;
    private int totalCollisions;

    HashTable(int s){
        // table size should be a prime number and 1/3 extra.
        table = new Dictionary [s+(s/3)];
        totalCollisions = 0;
    }

    /**
     * O(1)
     * @param key is the string-value
     * @return a key for a specific string-value
     */
    public int strToInt(String key){

        int intVal = 0;
        for (int i = 0; i < key.length(); i++)
            intVal += key.charAt(i);
        return intVal;

    }

    /**
     * return an index for a specific key-value | O(1)
     * @param sum is the key-value
     * @return the index
     */
    public int Hash(int sum){
        return sum % table.length;
    }

    /**
     * hashing again in case of collision | O(1)
     * @param sum is the index of collision
     * @param i is the factor of probing
     * @return a new index
     */
    public int Rehash(int sum, int i){
        return ((sum % table.length) + i) % table.length;
    }

    /**
     * inserts a Dictionary in the table | O(1)
     * @param v is the Dictionary to be inserted
     */
    public void insert(Dictionary v){

        int sum = strToInt(v.getWord());
        sum = Hash(sum);
        int collisions = 0;

        if (table[sum] == null) {
            table[sum] = v;
        } else {

            // quadratic probing:

            int i = 1;
            int newSum = sum;
            do {
                newSum = Rehash(sum, i * i);
                collisions++;
                i++;
            } while (table[newSum] != null);
            table[newSum] = v;

        }

        System.out.println("number of collisions for " + v + " : " + collisions);
        totalCollisions += collisions;

    }

    /**
     * return the index value of the Dictionary with the word v | O(1)
     * @param v is the word of the dictionary
     * @return the index value
     */
    public int find(String v) {

        int sum = strToInt(v);
        sum = Hash(sum);

        // linear probing:

        if (table[sum].getWord().equals(v))
            return sum;
        else {

            int i = 1;
            int newSum;
            do {
                newSum = Rehash(sum, i * i);
                if (table[newSum].getWord().equals(v))
                    return newSum;
                i++;
            } while (table[newSum] != null && i < table.length);


        }

        System.out.println("word not found!");
        return -1;

    }

    /**
     * places an indicator (a dictionary with word "$") in place of the Dictionary that has to be deleted | O(1)
     * @param v is the word of the Dictionary that has to be deleted
     * @return true if successfully deleted, false otherwise
     */
    public boolean delete (String v) {

        int index = find(v);

        if (index == -1)
            return false;

        table[index] = new Dictionary("$", "$");
        return true;

    }

    /**
     * O(n)
     * @return the table as a string
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("\tindex\t|\telement\n");

        int i = 0;
        for (Dictionary v : table) {

            s.append("\t").append(i).append("\t\t|\t").append(v).append("\n");
            i++;

        }

        return s.toString();

    }

    /**
     * display the table | O(n)
     */
    public void display() {
        System.out.println(this);
    }

    /**
     * @return the total number of collisions
     */
    public int getTotalCollisions() {
        return totalCollisions;
    }

    /**
     * O(1)
     * @return the table array
     */
    public Dictionary[] getTable() {
        return table;
    }
}