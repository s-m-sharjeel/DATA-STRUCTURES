package Labs.Lab12;

public class GraphAdjMatrix {

    class Vertex {

        String name;
        int num;

        public Vertex(String lab, int vertexCount) {
            name = lab;
            num = vertexCount;
        }

    }

    Vertex vertexList[]; // array of vertices
    int adjMat[][]; // adjacency matrix
    int vertexCount;

    GraphAdjMatrix(int s) {
        vertexList = new Vertex[s];
        vertexCount = 0;
        adjMat = new int[s][s];
    }

    public void addVertex(String L) {

        if (isFull())
            return;

        int num = vertexCount;
        vertexList[num] = new Vertex(L, num);
        vertexCount++;

    }

    private boolean isFull() {

        return vertexCount == vertexList.length;

    }

    public void addEdge(String L1, String L2) {

        Vertex from = null;
        Vertex to = null;

        for (int i = 0; i < vertexCount; i++) {

            if (vertexList[i] == null)
                continue;

            if (vertexList[i].name.equals(L1))
                from = vertexList[i];
            else if (vertexList[i].name.equals(L2))
                to = vertexList[i];

        }

        if (from == null || to == null) {
            if (from == null)
                System.out.println(L1 + " not found!");
            if (to == null)
                System.out.println(L2 + " not found!");
            return;
        }

        adjMat[from.num][to.num] = 1;
        adjMat[to.num][from.num] = 1;

    }

    public void display() {

        for (int i = 0; i < vertexCount; i++) {

            if (i == 0) {

                System.out.print("  ");

                for (int j = 0; j < vertexCount; j++)
                    System.out.print(vertexList[j].name + " ");

                System.out.println();

            }

            for (int j = 0; j < vertexCount; j++) {

                if (j == 0)
                    System.out.print(vertexList[i].name + " ");

                System.out.print(adjMat[i][j] + " ");

            }

            System.out.println();

        }

    }

}
