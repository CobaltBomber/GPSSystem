import edu.princeton.cs.algs4.IndexMinPQ;

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

    public static class Dijkstras {
        private WeightedEdge[] edgeTo;
        private double[] distanceTo;
        private IndexMinPQ<Double> pq;

        public Dijkstras(MyGraph weightedGraph, int source, int destination) {
            edgeTo = new WeightedEdge[weightedGraph.numVertices];
            distanceTo = new double[weightedGraph.numVertices];
            pq = new IndexMinPQ<Double>(weightedGraph.numVertices);

            for (int i = 0; i < weightedGraph.numVertices; i++) {
                distanceTo[i] = Double.POSITIVE_INFINITY;
            }
            distanceTo[source] = 0.0;

            pq.insert(source,0.0);

            while (!pq.isEmpty()) {
                int v = pq.delMin();
                for (WeightedEdge e: weightedGraph.adjacent.get(v)) {
                    int w = e.destination;

                    if (distanceTo[w] > distanceTo[v] + e.weight) {
                        distanceTo[w] = distanceTo[v] + e.weight;
                        edgeTo[w] = e;
                        if (pq.contains(w)) {
                            pq.decreaseKey(w, distanceTo[w]);
                        }
                        else {
                        pq.insert(w, distanceTo[w]);
                        }
                    }

                }
            }


        }



    }

    public static void main(String[] args) {

    }
}
