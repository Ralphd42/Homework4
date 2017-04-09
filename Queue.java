package hw4;

/**
 *
 * @author ralph
 */
public class Queue<StackItem> extends ListBase<StackItem> {
    
    private final String ErrorMessage ="Queue is empty.";
    private Node tail;  // the tail of the list
    
    /**
     *  Queues an item onto the end of the list
     * This returns the this pointer so that calls to Enqueue can be chained
     * @param item
     * @return  this
     */
    public Queue<StackItem> Enqueue(StackItem item) {
        Node lasttail = tail;
        tail = new Node(item,null);
        if (isEmpty()){ 
            head = tail;
        }
        else {
            lasttail.SetNext(tail);
        }
        return this;
    }
    
    /**
     * Deque retuerns item from head of linked list and removes it
     * @return returns the current head
     */
    public StackItem Dequeue()
    {
        if( isEmpty()){
            throw new java.util.NoSuchElementException(ErrorMessage);
        }
        StackItem retval = head.getItem();
        head = head.GetNext();
        if( head==null){
            tail=null;
        }
        return retval;
    }
    /**
     * Returns but does not remove top item in Queue
     * @return current head item;
     */
    public StackItem Peek()
    {
        if( isEmpty()){
            throw new java.util.NoSuchElementException(ErrorMessage);
        }
        return head.getItem();
    }
    
    
    
    }

