package Labs.Lab13;

public class Driver {

    public static void main(String[] args) {

        GraphAdjacencyList<String> list = new GraphAdjacencyList<String>(10);

        list.addVertex("A");
        list.addVertex("B");
        list.addVertex("C");
        list.addVertex("D");

        list.addEdge("A", "B");
        list.addEdge("A", "C");
        list.addEdge("B", "D");
        list.addEdge("C", "B");
        list.addEdge("D", "C");

//        System.out.print(list);
//
//        list.deleteVertex("A");
//        list.deleteVertex("A");
//
//        list.deleteEdge("B","D");
//        list.deleteEdge("B","D");

        System.out.println(list);

        list.DFS(list.findVertex("B"));

        list.BFS(list.findVertex("B"));

        GraphAdjacencyList<Integer> graph = new GraphAdjacencyList<>(10);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.DFS(graph.findVertex(2));

        System.out.println(graph.shortestPath(1, 4));
        System.out.println(graph.shortestPath(0, 4));

    }

}
