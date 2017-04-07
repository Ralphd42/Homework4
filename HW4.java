package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ralph
 */
public class HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length > 0) {
            System.out.print("Testing from File: ");
            System.out.println("Working Directory = "
                    + System.getProperty("user.dir"));
            System.out.println(args[0]);
            GnStack<String> TestStack1 = new GnStack<>();
            FillStack(TestStack1, args[0]);
            System.out.println(TestStack1);

            /*GenStack<String> gs = new GenStack();
            gs.Push("one").Push("two");
            System.out.println(gs);
            String pop1 = gs.Pop();
            System.out.println(pop1);
            System.out.println("------------------------------------------");
            System.out.println(gs);
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            GnStack<String> gn11 = new GnStack();
            gn11.Push("a1");
            gn11.Push("b2");
            gn11.Push("c31");
            GenQueue<String> q = new GenQueue<String>();
            q.Enqueue("ONE");
            q.Enqueue("Two").Enqueue("THREE").Enqueue("nine").Enqueue("Eleven");
            System.out.println(q);
             */
        } else {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TestForm().setVisible(true);
                }
            });
        }

    }

    /**
     *
     * @param stack a stack to add itemd from file to
     * @param FullFileName - the full file name to load
     * @return number of Items added
     */
    public static int FillStack(GnStack<String> stack, String FullFileName) {
        int retval = 0;
        File InputFile = new File(FullFileName);
        try {
            FileReader inputFileReader = new FileReader(InputFile);
            BufferedReader InputReader = new BufferedReader(inputFileReader);

            String line;
            while ((line = InputReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    stack.Push(line.trim());
                    retval++;
                }

            }
            inputFileReader.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return retval;

    }

}
