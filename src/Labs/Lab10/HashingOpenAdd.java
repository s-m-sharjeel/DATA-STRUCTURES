package Labs.Lab10;

public class HashingOpenAdd {

    String[] table;
    boolean linear;
    int totalCollisions;

    HashingOpenAdd(int s, boolean linear){
        // table size should be a prime number and 1/3 extra.
        table = new String [s+(s/3)];
        this.linear = linear;
        totalCollisions = 0;
    }
    public int strToInt(String key){

        int intVal = 0;
        for (int i = 0; i < key.length(); i++)
            intVal += key.charAt(i);
        return intVal;

    }

    public int Hash(int sum){
        return sum % table.length;
    }
    public int Rehash(int sum, int i){
        // first test linear probing on whole dictionary words, then Quadratic probing and
        // understand the changes in number of collision in each method
        return ((sum % table.length) + i) % table.length;
    }

    public void insert(String v){

        int sum = strToInt(v);
        sum = Hash(sum);
        int collisions = 0;

        if (table[sum] == null) {
            table[sum] = v;
        } else {

            // linear probing:

            if (linear) {
                int i = 1;
                int newSum;
                do {
                    newSum = Rehash(sum, i);
                    collisions++;
                    i++;
                } while (table[newSum] != null);
                table[newSum] = v;

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

        }

        System.out.println("number of collisions for " + v + " : " + collisions);
        totalCollisions += collisions;
    }
    public int search (String v) {

        int sum = strToInt(v);
        sum = Hash(sum);

        // linear probing:

        if (table[sum].equals(v))
            return sum;
        else {

            if (linear) {

                int i = 1;
                int newSum;
                do {
                    newSum = Rehash(sum, i);
                    if (table[newSum].equals(v))
                        return newSum;
                    i++;
                } while (table[newSum] != null && i < table.length);

            } else {

                int i = 1;
                int newSum;
                do {
                    newSum = Rehash(sum, i * i);
                    if (table[newSum].equals(v))
                        return newSum;
                    i++;
                } while (table[newSum] != null && i < table.length);

            }
        }

        System.out.println("word not found!");
        return -1;
    }
    public boolean delete (String v) {

        int index = search(v);

        if (index == -1)
            return false;

        table[index] = "$";
        return true;

    }
    public String displayTable() {

        String s = "\tindex\t|\telement\n";

        int i = 0;
        for (String v : table) {

            s += "\t" + i + "\t\t|\t" + v + "\n";
            i++;

        }

        return s;

    }

    public int getTotalCollisions() {
        return totalCollisions;
    }
}