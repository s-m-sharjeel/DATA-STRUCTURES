package Labs.Lab11;

public class MyGraph {

    class Vertex implements Comparable<Vertex> {

        String name;
        int age;
        MyLinkedList<Vertex> friendsList = new MyLinkedList<Vertex>();

        public Vertex(String d, int a){
            name=d;
            age=a;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.age, o.age);
        }

    }

    Vertex[] adjList;
    int count;

    MyGraph(int s) {

        adjList = new Vertex[s];
        count = 0;

    }

    public void addVertex(String s, int a) {



    }

    public void addEdge(String s1, String s2) {



    }

    public void findVertex(String s) {



    }

    public void findVertexFriendList(String s) {



    }



}
