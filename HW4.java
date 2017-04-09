package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Tested class for Stack and Queue
 *
 * @author ralph
 */
public class HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length <= 0) {
            TextHeader("Console Test no file provided");
            Stack<String> TestStack1 = new Stack<>();
            TestStack1.Push("TV").Push("Rocket").Push("Tree").Push("Oasis").Push("Apple");
            Queue<String> TestQueue = new Queue<>();
            TextHeader("Stack Contents");
            System.out.println(TestStack1);
            TextHeader("Moving Stack to Queue");
            do {

                String Item = TestStack1.Pop();
                TestQueue.Enqueue(Item);
                System.out.println("queuing " + Item);
            } while (!TestStack1.isEmpty());
            TextHeader("Queue Contents");
            TextHeader("Moving Queue to Stack");
            do {

                String Item = TestQueue.Dequeue();
                TestStack1.Push(Item);
                System.out.println("pushing " + Item);
            } while (!TestQueue.isEmpty());
            TextHeader("Stack  using(ToString)");
            System.out.println(TestStack1);

        } else if (args[0].equals("-f")) {
            String fname = args[1];
            System.out.print("Testing from File: ");
            //System.out.println("Working Directory = "
            //        + System.getProperty("user.dir"));
            System.out.println(fname);

            // Test Item 1 from Homework
            TextHeader("Item 1");
            Stack<String> TestStack1 = new Stack<>();
            Queue<String> TestQueue1 = new Queue<>();
            int numAddded = FillStackFromFile(TestStack1, fname);
            if (numAddded > 0) {

                FillQueueWithStack(TestStack1, TestQueue1);
            } else {
                TextHeader("Item 1 failed to load");
            }
            // Test Item 2 from Home work
            TextHeader("");
            TextHeader("Item 2");
            numAddded = FillQueueFromFile(TestQueue1, fname);
            if (numAddded > 0) {

                FillStackWithQueue(TestStack1, TestQueue1);
            } else {
                TextHeader("Item 2 failed to load");
            }

            //Test Item 3 from Home work
            TextHeader("");
            TextHeader("Item 3");
            numAddded = FillStackFromFile(TestStack1, fname);
            Stack<String> Stack2 = new Stack<>();
            if (numAddded > 0) {

                FillStackWithStack(TestStack1, Stack2);
            } else {
                TextHeader("Item 3 failed to load");
            }

        } else if (args[0].equals("-g")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TestForm().setVisible(true);
                }
            });
        } else {
            System.out.println("Invalid entry");

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

    /**
     * Fills a queue with a stack by poping from Stack to queing toQueue
     *
     * @param stack from
     * @param queue to
     */
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

    /**
     * deques from queue to stack
     *
     * @param stack to
     * @param queue from
     */
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

    /**
     * *
     * fills a queue with contents of a file
     *
     * @param queue queue to fill
     * @param FullFileName file to get data from
     * @return
     */
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

    /**
     * *
     * move contents from one stack to another
     *
     * @param stack stack from
     * @param stackto stack to
     */
    public static void FillStackWithStack(Stack<String> stack, Stack<String> stackto) {
        TextHeader("Stack Contents");
        System.out.println(stack);
        TextHeader("Moving Stack to new Stack");
        boolean hasitems = true;
        do {
            try {
                String Item = stack.Pop();
                stackto.Push(Item);
                System.out.println("pushing " + Item);
            } catch (NoSuchElementException nse) {
                hasitems = false;
            }
        } while (hasitems);
        TextHeader("Stack  using(ToString)");
        System.out.println(stackto);
        TextHeader("Stack using pop");
        hasitems = true;
        while (hasitems) {
            try {
                System.out.println(stackto.Pop());
            } catch (NoSuchElementException nse) {
                hasitems = false;
            }
        }

    }

    /**
     * *
     * tester function for easy printing of text to console
     *
     * @param header
     */
    public static void TextHeader(String header) {
        System.out.println();
        System.out.println(header);
        div();

    }

    /**
     * helper function for making div in console
     */
    public static void div() {
        System.out.println("----------------------------------");
    }

}
