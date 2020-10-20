import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyGPS {

    public static void main(String[] args) {

        MyGraph graph = new MyGraph(0);

        In myIn = new In(args[0]);

        String myArray[] = myIn.readAllLines();
        //source, destination, weight
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].charAt(0) == 'c') {
                continue;
            }

            if (myArray[i].charAt(0) == 'p') {
                String[] tempArray = myArray[i].split(" ");
                graph = new MyGraph(Integer.parseInt(tempArray[2]));
            }

            if (myArray[i].charAt(0) == 'a') {
                String[] tempArray = myArray[i].split(" ");
                graph.AddEdge(Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]),
                              Integer.parseInt(tempArray[3]));
            }


        }

        int userChoice = -1;

        do {

            StdOut.println("The current graph has vertices from 1 to 2500. ");
            StdOut.println("Would you like to:");
            StdOut.println("1. Find a new Route");
            StdOut.println("2. Exit");

            //Scanner myScanner = new Scanner(System.in);
            userChoice = Integer.parseInt(StdIn.readLine());

            if (userChoice != 1 && userChoice != 2) {
                StdOut.println("ERROR - please choose either selection 1 or 2");
                continue;
            }

        } while (userChoice != 2);

    }
}
