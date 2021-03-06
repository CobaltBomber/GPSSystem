// Imports all of the needed princeton code
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

public class MyGPS {

    public static void main(String[] args) {
        // Creates a new graph called graph
        MyGraph graph = new MyGraph(0);

        In myIn = new In(args[0]);
        // makes a In called my In and reads all of the file to a string array
        String myArray[] = myIn.readAllLines();
        //source, destination, weight
        //Sorts out the given data into the three different catagories
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].charAt(0) == 'c') {
                continue;
                //If c then it is an unnsecasary letter and does not need to be used
            }

            if (myArray[i].charAt(0) == 'p') {
                String[] tempArray = myArray[i].split(" ");
                graph = new MyGraph(Integer.parseInt(tempArray[2]) + 1);
                // If P then that deteermines the legnth of hte graph and connections
            }

            if (myArray[i].charAt(0) == 'a') {
                String[] tempArray = myArray[i].split(" ");
                graph.AddEdge(Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]),
                              Integer.parseInt(tempArray[3]));
                // a is the actual values theat need to be used, the vertecies, value, and connections
            }

        }
        // gives the user choices a default value incase they sont pick a correct value
        int userChoice = -1;
        int sourceVertex = -1;
        int destination = -1;

        do {
            // Asks the user what they would like to do and then carries out that response.
            StdOut.println("The current graph has vertices from 1 to 2500. ");
            StdOut.println("Would you like to:");
            StdOut.println("1. Find a new Route");
            StdOut.println("2. Exit");

            //Scanner myScanner = new Scanner(System.in);
            userChoice = Integer.parseInt(StdIn.readLine());
            // Gets the users input and checks to see if they chose outside of hte given choices
            if (userChoice != 1 && userChoice != 2) {
                StdOut.println("ERROR - please choose either selection 1 or 2");
                continue;
            }
            // checks to see if users choice is 1, and then ask for the 'route' and destination they would like to take
            if (userChoice == 1) {
                StdOut.println("Please enter your source vertex: ");
                sourceVertex = Integer.parseInt(StdIn.readLine());
                StdOut.println("Please enter your destination: ");
                destination = Integer.parseInt(StdIn.readLine());
                // Gets teh time of the journey and graphs the directions
                long startTime = System.nanoTime();
                MyGraph.Dijkstras calculation = new MyGraph.Dijkstras(graph, sourceVertex, destination);
                LinkedList<Integer> path = calculation.path(sourceVertex, destination);
                double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;

                //Prints out the results of the trip and the shortest travel time

                StdOut.println("Shortest Path from " + sourceVertex + " to " + destination + ":");
                StdOut.print(path.get(0));
                // prints the visual aid for the path to take
                for (int i = 1; i < path.size(); i++) {
                    StdOut.print(" -> ");
                    StdOut.print(path.get(i));
                }
                // Gets and prints the total diatance and the time to find the total time elapsed
                StdOut.println();
                StdOut.println("Total Distance: " + calculation.getDistanceTo(destination));
                StdOut.println("Time to find: " + elapsedTime + " seconds");

            }
            // ends the code if the users chioce is 2
        } while (userChoice != 2);

    }
}

// end
