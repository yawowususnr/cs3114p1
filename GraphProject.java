// -------------------------------------------------------------------------
/**
 * Main for Graph project (CS3114/CS5040 Fall 2023 Project 4).
 * Usage: java GraphProject <init-hash-size> <command-file>
 *
 * @author {Yaw Owusu Snr}
 * @version {1.0.0}
 *
 */


public class GraphProject {
    /**
     * @param args
     *            Command line parameters
     */
    public static void main(String[] args) {
        if (args.length == 2)
        {
            int hashtableSize = Integer.parseInt(args[1]);
            String filename = args[0];
            
            CommandProcessor processor = new CommandProcessor(filename, hashtableSize);
            processor.beginParsingByLine();
        }
    }
}
