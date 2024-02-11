package Labs.Lab12;

public class Driver {

    public static void main(String[] args) {

        GraphAdjMatrix matrix = new GraphAdjMatrix(10);

        matrix.addVertex("A");
        matrix.addVertex("B");
        matrix.addVertex("C");
        matrix.addVertex("D");

        matrix.addEdge("A", "B");
        matrix.addEdge("A", "C");
        matrix.addEdge("B", "D");
        matrix.addEdge("C", "B");

        matrix.display();

        GraphAdjacencyList list = new GraphAdjacencyList(10);

        list.addVertex("A");
        list.addVertex("B");
        list.addVertex("C");
        list.addVertex("D");

        list.addEdge("A", "B");
        list.addEdge("A", "C");
        list.addEdge("B", "D");
        list.addEdge("C", "B");
        list.addEdge("D", "C");

        System.out.print(list);

        list.deleteVertex("A");
        list.deleteVertex("A");

        list.deleteEdge("B","D");
        list.deleteEdge("B","D");

        System.out.println(list);

    }

}
