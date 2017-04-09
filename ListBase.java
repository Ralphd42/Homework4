
package hw4;

/**
 *Base class for stacks and queues in this homework. Contains common code
 * @author ralph
 */
public class ListBase<StackItem> {
    protected Node head;  //head node
    /**
     * Tests if ADT is empty
     * @return  true if empty
     */
    public boolean isEmpty(){
        return head==null;
    }
    /**
     * Override of toString 
     * @return String representation of ADT
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        while( tmp!=null )
        {
            sb.append(tmp.itm.toString());
            sb.append("\n");
            tmp=tmp.GetNext();
        }
        return sb.toString();
    }
    
    /**
     * The size of the ADT
     * @return the size as an integer
     */
    public int size()
    {
        int sz =0;
        Node tmp = head;
        while(tmp!=null      )
        {
            sz++;
            tmp=tmp.GetNext();
        }
        return sz;
    }        
            
    /**
     * The node class. 
     */
    protected class Node{
        private StackItem itm;  //The data item
        /**
         * Constructor
         * @param stackitem  -- the data item
         * @param next   next node
         */
        protected Node( StackItem stackitem, Node next)
        {
            itm =stackitem;
            nxt = next;
        
        }
        /**
         * Gets item of NOde
         * @return 
         */
        protected StackItem getItem ()
        {
            return itm;
        }
        /**
         * The Next Node
         */
        private Node nxt;
        /**
         * Sets the next node in linked list
         * @param n the next node
         */
        protected void SetNext( Node n)
        {
            nxt =n;
        }
        /**
         * Returns the next node in the list
         * @return  Next Node
         */
        protected Node GetNext ()
        {
            return nxt;
        }
}
}
    
    

