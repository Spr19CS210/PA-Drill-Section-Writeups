import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Section4Main.java
 * 
 * This class reads in the input file described below and creates a
 * graph from it. Beginning lines that are comments are ignored
 * as well as nodes that map to themselves (1 to 1 or 4 to 4)
 * A .dot file is created and can be opened as a visual representation
 * of the graph.
 * 
 * Input - Unknown number of comment lines at the beginning,
 * starting with %
 * - first line of input file is row, column and number of entries
 * - all lines after that are mapping entries, representing a row and
 * column value
 * 
 * usage: java Section4Main infile.mtx
 *  
 * Example input file:
 * %%MatrixMarket matrix coordinate real general
 * 3 3 6
 * 1 2 1.0
 * 2 1 2.0
 * 1 3 3.0
 * 3 1 4.0
 * 2 3 5.0
 * 3 2 6.0
 * 
 * Example Output
 * digraph {
 * 1 -> 2 [label="1.0"];
 * 1 -> 3 [label="3.0"];
 * 2 -> 1 [label="2.0"];
 * 2 -> 3 [label="5.0"];
 * 3 -> 1 [label="4.0"];
 * 3 -> 2 [label="6.0"];
 * }
 * 
 */
public class Section4Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File(args[0]));

        //TODO: Skip over comment lines that can be at the beginning of mtx

        //TODO: Read the number of rows, columns and non-zeros        
        
        //TODO: Initialize the graph using the number of nodes 
        DGraph graph = null;    	
        
        //TODO: Assuming the number of non-zeros reported is correct,
        //  loop over the entry lines and add the directed edge,
        //  do not include self edges.
        
        // Write to a .dot file in order to visualize your graph 
        PrintWriter writer = new PrintWriter("graph.dot"); 
        writer.println(graph.toDotString());
        writer.close();

        // Print out your graph
        System.out.println(graph.toDotString());
    }

}
