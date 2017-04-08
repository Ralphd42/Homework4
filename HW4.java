package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

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
            //System.out.println("Working Directory = "
            //        + System.getProperty("user.dir"));
            System.out.println(args[0]);

            // Test Item 1 from Homework
            TextHeader("Item 1");
            Stack<String> TestStack1 = new Stack<>();
            Queue<String> TestQueue1 = new Queue<>();
            int numAddded = FillStackFromFile(TestStack1, args[0]);
            if (numAddded > 0) {

                FillQueueWithStack(TestStack1, TestQueue1);
            } else {
                TextHeader("Item 1 failed to load");
            }
            // Test Item 2 from Home work
            TextHeader("");
            TextHeader("Item 2");
            numAddded = FillQueueFromFile(TestQueue1, args[0]);
            if (numAddded > 0) {

                FillStackWithQueue(TestStack1, TestQueue1);
            } else {
                TextHeader("Item 2 failed to load");
            }
            TextHeader("");
            TextHeader("Item 3");
            numAddded = FillQueueFromFile(TestQueue1, args[0]);
            Stack<String> Stack2 = new  Stack<>();
            if (numAddded > 0) {

                FillStackWithStack(TestStack1, Stack2);
            } else {
                TextHeader("Item 3 failed to load");
            }

            //FillQueueFromFile(Queue,args[0]);
            //FillStackWithQueue(TestStack1,Queue);
            /*GenStack<String> gs = new GenStack();
            gs.Push("one").Push("two");
            System.out.println(gs);
            String pop1 = gs.Pop();
            System.out.println(pop1);
            System.out.println("------------------------------------------");
            System.out.println(gs);
            System.out.println("------------------------------------------");
            System.out.println("------------------------------------------");
            Stack<String> gn11 = new Stack();
            gn11.Push("a1");
            gn11.Push("b2");
            gn11.Push("c31");
            Queue<String> q = new Queue<String>();
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
    public static int FillStackFromFile(Stack<String> stack, String FullFileName) {
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

    public static void FillQueueWithStack(Stack<String> stack, Queue<String> queue) {
        TextHeader("Stack Contents(toString)");
        System.out.println(stack);
        TextHeader("Moving Stack to queue");

        do {

            String Item = stack.Pop();
            queue.Enqueue(Item);
            System.out.println("queuing " + Item);
        } while (!stack.isEmpty());
        TextHeader("Queue Contents(ToString)");
        System.out.println(queue);
        TextHeader("Queue via dequing");
        boolean hasitems = true;
        while (hasitems) {
            try {
                System.out.println(queue.Dequeue());
            } catch (NoSuchElementException nse) {
                hasitems = false;
            }
        }

    }

    public static void FillStackWithQueue(Stack<String> stack, Queue<String> queue) {
        TextHeader("Queue Contents");
        System.out.println(queue);
        TextHeader("Moving Queue to Stack");

        do {

            String Item = queue.Dequeue();
            stack.Push(Item);
            System.out.println("pushing " + Item);
        } while (!queue.isEmpty());
        TextHeader("Stack  using(ToString)");
        System.out.println(stack);
        TextHeader("Stack using pop");
        boolean hasitems = true;
        while (hasitems) {
            try {
                System.out.println(stack.Pop());
            } catch (NoSuchElementException nse) {
                hasitems = false;
            }
        }

    }

    public static int FillQueueFromFile(Queue<String> queue, String FullFileName) {
        int retval = 0;
        File InputFile = new File(FullFileName);
        try {
            FileReader inputFileReader = new FileReader(InputFile);
            BufferedReader InputReader = new BufferedReader(inputFileReader);

            String line;
            while ((line = InputReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    queue.Enqueue(line.trim());
                    retval++;
                }

            }
            inputFileReader.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return retval;

    }
    
    public static void FillStackWithStack(Stack<String> stack, Stack<String> stackto) {
        TextHeader("Stack Contents");
        System.out.println(stack);
        TextHeader("Moving Stack to new Stack");
        
        do {

            String Item = stack.Pop();
            stack.Push(Item);
            System.out.println("pushing " + Item);
        } while (!stack.isEmpty());
        TextHeader("Stack  using(ToString)");
        System.out.println(stackto);
        TextHeader("Stack using pop");
        boolean hasitems = true;
        while (hasitems) {
            try {
                System.out.println(stackto.Pop());
            } catch (NoSuchElementException nse) {
                hasitems = false;
            }
        }

    }
    
    
    
    
    

    public static void TextHeader(String header) {
        System.out.println();
        System.out.println(header);
        div();

    }

    public static void div() {
        System.out.println("----------------------------------");
    }

}
