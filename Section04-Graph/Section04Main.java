import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * FIXME
 *
 * This class reads in the input file described below and creates a
 * graph from it. Beginning
 * lines that are comments are ignored and nodes that map to themselves
 * (1 to 1 or 4 to 4)
 * are ignored. A .dot file is created and can be opened as a visual
 * representation of the graph.
 * 
 * Input - Unknown number of comment lines at the beginning, they start
 * with %
 * - first line of input file is row, column and number of entries
 * - all lines after that are mapping entries, representing a row and
 * column value
 * 
 * Example input file:
 * 
 * FIXME
 */
public class Section4Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File(args[0]));

        // Create a graph to place each entry line
        DGraph graph = new DGraph(in);

        // Write to a .dot file in order to visualize your graph 
        PrintWriter writer = new PrintWriter("graph.dot"); 
        writer.println(graph.toDotString());
        writer.close();

        // Print out your graph for debugging purposes 
        System.out.println(graph.toDotString());
    }

}
