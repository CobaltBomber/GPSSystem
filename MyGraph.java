import java.util.ArrayList;

public class MyGraph {

    public int numVertices;
    public ArrayList<ArrayList<WeightedEdge>> adjacent;


    public MyGraph(int numVertices) { //constructor
        this.numVertices = numVertices;
        this.adjacent = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            ArrayList<WeightedEdge> tempList = new ArrayList<>();

            adjacent.add(tempList);
        }

    }

    public static class WeightedEdge { //creates weighted edge and allows weighted functionality
        public int weight;
        public int destination;

        public WeightedEdge(int weight, int destination) {
            this.weight = weight;
            this.destination = destination;
        }

    }

    public void AddEdge(int edgeSource, int edgeDestination, int weight) { //passing in a list
        WeightedEdge myWeightedEdge = new WeightedEdge(weight, edgeDestination);
        adjacent.get(edgeSource).add(myWeightedEdge);
    }



    public static void main(String[] args) {

    }
}

