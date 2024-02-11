package Labs.Lab10;

public class HashT <T>{

    LinkedList<T>[] table;

    HashT(int s){

        table = new LinkedList[s+(s/3)];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }

    }

    public int Hash(T obj){

        int key = obj.hashCode();
        return key % table.length;

    }

    public void insert(T obj){

        int index = Hash(obj);
        table[index].insert(obj);

    }

    public Boolean find(T obj) {

        int index = Hash(obj);
        return table[index].find(obj) != null;  // obj not found if null is returned

    }
    public void delete(T obj){

        int index = Hash(obj);
        table[index].delete(obj);

    }
    public void displayTable() {

        String s = "\tindex\t|\telement\n";

        int i = 0;
        for (LinkedList<T> list : table) {

            s += "\t" + i + "\t\t|\t" + list.toString() + "\n";
            i++;

        }

        System.out.println(s);

    }

}

