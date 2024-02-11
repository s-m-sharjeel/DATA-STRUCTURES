package Labs.Lab13;

public class GraphAdjacencyList <T extends  Comparable<T>> {

    public static class Vertex <T extends Comparable<T>> {

        private final T data;

        private boolean visited;

        private LinkedList<Vertex> shortestPath;

        private final LinkedList<Vertex> adjacentVertices;

        public Vertex(T d) {
            data = d;
            adjacentVertices = new LinkedList<>();
            shortestPath = new LinkedList<>();
        }

        public void addFriend(Vertex<T> v) {
            adjacentVertices.insert(v);
        }

        public LinkedList<Vertex> getAdjacentVertices() {
            return adjacentVertices;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "data='" + data + '\'' +
                    '}';
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    Vertex<T>[] adjList;
    int vertexCount;

    public GraphAdjacencyList(int s) {
        adjList = new Vertex[s];
        vertexCount = 0;
    }

    public void addVertex(T n){

        if (isFull())
            return;

        adjList[vertexCount++] = new Vertex<T>(n);

    }

    public void addEdge(T n1,T n2) {

        Vertex<T> from = null;
        Vertex<T> to = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i] == null)
                continue;

            if (adjList[i].data.equals(n1))
                from = adjList[i];
            else if (adjList[i].data.equals(n2))
                to = adjList[i];

        }

        if (from == null || to == null) {
            if (from == null)
                System.out.println(n1 + " not found!");
            if (to == null)
                System.out.println(n2 + " not found!");
            return;
        }

        if (!from.getAdjacentVertices().contains(to))
            from.addFriend(to);

        if (!to.getAdjacentVertices().contains(from))
            to.addFriend(from);

    }

    public Vertex<T> findVertex(T n){

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i] == null)
                continue;

            if (adjList[i].data.equals(n))
                return adjList[i];

        }

        return null;

    }

    public void deleteVertex(T n){

        Vertex<T> temp = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i].data.equals(n)) {
                temp = adjList[i];
                adjList[i] = null;

                // backward movement
                for (int j = i; j < vertexCount - 1; j++)
                    adjList[j] = adjList[j + 1];

                vertexCount--;
                break;
            }

        }

        if (temp == null) {
            System.out.println("Vertex not found!");
            return;
        }

        for (int i = 0; i < vertexCount; i++) {

            for (int j = 0; j < adjList[i].adjacentVertices.size(); j++) {

                if (adjList[i].adjacentVertices.get(j).data.equals(temp.data)) {
                    adjList[i].adjacentVertices.delete(j);
                    break;
                }

            }

        }

    }

    public void deleteEdge(String n1, String n2){

        Vertex<T> from = null;
        Vertex<T> to = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i].data.equals(n1))
                from = adjList[i];
            else if (adjList[i].data.equals(n2))
                to = adjList[i];

        }

        if (from == null || to == null) {
            if (from == null)
                System.out.println(n1 + " not found!");
            if (to == null)
                System.out.println(n2 + " not found!");
            return;
        }

        if ((!from.getAdjacentVertices().contains(to) || !to.getAdjacentVertices().contains(from))) {
            System.out.println("Edge does not exist!");
            return;
        }

        from.adjacentVertices.delete(to);
        to.adjacentVertices.delete(from);

    }

    public String toString(){

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            s.append(adjList[i].data).append(" : ").append(adjList[i].adjacentVertices).append('\n');
        }

        return s.toString();

    }

    public boolean isFull() {
        return vertexCount == adjList.length;
    }

    public void DFS(Vertex<T> v) {

        reset();

        System.out.println("DFS:");

        Stack<Vertex> stack = new Stack<>();

        stack.push(v);
        v.setVisited(true);
        System.out.println(v);

        while (!stack.isEmpty()) {

            Vertex<T> v1 = stack.peek();

            Vertex<T> w = null;
            for (int i = 0; i < v1.getAdjacentVertices().size(); i++) {
                if (!v1.getAdjacentVertices().get(i).isVisited()) {
                    w = v1.getAdjacentVertices().get(i);
                }
            }

            if (w != null) {
                stack.push(w);
                w.setVisited(true);
                System.out.println("W: " + w + " ; Edge: " + v + " -> " + w);

            } else stack.pop();

        }

    }

    public void BFS(Vertex<T> source) {

        reset();

        System.out.println("BFS:");

        Queue<Vertex> queue = new Queue<>();

        queue.enqueue(source);

        source.setVisited(true);
        System.out.println(source);

        while (!queue.isEmpty()) {

            Vertex<T> v = queue.dequeue();

            for (int i = 0; i < v.getAdjacentVertices().size(); i++) {

                Vertex<T> w = v.getAdjacentVertices().get(i);

                if (!w.isVisited()) {

                    queue.enqueue(w);
                    w.setVisited(true);
                    System.out.println("W: " + w + " ; Edge: " + v + " -> " + w);

                }

            }

        }

    }

    public LinkedList<Vertex> shortestPath(T d1, T d2) {

        Vertex<T> source = findVertex(d1);
        Vertex<T> to = findVertex(d2);

        reset();

        System.out.println("Shortest Path:");

        Queue<Vertex> queue = new Queue<>();

        queue.enqueue(source);
        source.shortestPath.insert(source);

        source.setVisited(true);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + to);

        while (!queue.isEmpty()) {

            Vertex<T> v = queue.dequeue();

            for (int i = 0; i < v.getAdjacentVertices().size(); i++) {

                Vertex<T> w = v.getAdjacentVertices().get(i);

                if (!w.isVisited()) {

                    queue.enqueue(w);
                    w.setVisited(true);

                    for (int j = 0; j < v.shortestPath.size(); j++)
                        w.shortestPath.insert(v.shortestPath.get(j));

                    w.shortestPath.insert(w);

                }

            }

        }

        return to.shortestPath;

    }

    private void reset() {

        for (int i = 0; i < vertexCount; i++) {

            adjList[i].setVisited(false);
            adjList[i].shortestPath = new LinkedList<>();

        }

    }

}
