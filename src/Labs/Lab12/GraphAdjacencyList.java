package Labs.Lab12;

public class GraphAdjacencyList {

    public class Vertex {

        String name;

        LinkedList<Vertex> friendsList = new LinkedList<Vertex>();

        public Vertex(String d) {
            name = d;
        }

        public void addFriend(Vertex v) {
            friendsList.insert(v);
        }

        public boolean containsFriend(Vertex v) {

            return friendsList.contains(v);

        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    Vertex[] adjList;
    int vertexCount;

    public GraphAdjacencyList(int s) {
        adjList = new Vertex[s];
        vertexCount = 0;
    }

    public void addVertex(String n){

        if (isFull())
            return;

        adjList[vertexCount++] = new Vertex(n);

    }

    public void addEdge(String n1,String n2) {

        Vertex from = null;
        Vertex to = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i] == null)
                continue;

            if (adjList[i].name.equals(n1))
                from = adjList[i];
            else if (adjList[i].name.equals(n2))
                to = adjList[i];

        }

        if (from == null || to == null) {
            if (from == null)
                System.out.println(n1 + " not found!");
            if (to == null)
                System.out.println(n2 + " not found!");
            return;
        }

        if (!from.containsFriend(to))
            from.addFriend(to);

        if (!to.containsFriend(from))
            to.addFriend(from);

    }

    public Vertex findVertex(String n){

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i] == null)
                continue;

            if (adjList[i].name.equals(n))
                return adjList[i];

        }

        return null;

    }

    public void deleteVertex(String n){

        Vertex temp = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i].name.equals(n)) {
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

            for (int j = 0; j < adjList[i].friendsList.size; j++) {

                if (adjList[i].friendsList.get(j).name.equals(temp.name)) {
                    adjList[i].friendsList.delete(j);
                    break;
                }

            }

        }

    }

    public void deleteEdge(String n1, String n2){

        Vertex from = null;
        Vertex to = null;

        for (int i = 0; i < vertexCount; i++) {

            if (adjList[i].name.equals(n1))
                from = adjList[i];
            else if (adjList[i].name.equals(n2))
                to = adjList[i];

        }

        if (from == null || to == null) {
            if (from == null)
                System.out.println(n1 + " not found!");
            if (to == null)
                System.out.println(n2 + " not found!");
            return;
        }

        if ((!from.containsFriend(to) || !to.containsFriend(from))) {
            System.out.println("Edge does not exist!");
            return;
        }

        from.friendsList.delete(to);
        to.friendsList.delete(from);

    }

    public String toString(){

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {
            s.append(adjList[i].name).append(" : ").append(adjList[i].friendsList).append('\n');
        }

        return s.toString();

    }

    public boolean isFull() {
        return vertexCount == adjList.length;
    }

}
