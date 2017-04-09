
package hw4;

/**
 * 
 * @author ralph
 * @param <StackItem>  generic Stack  
 */
public class Stack<StackItem> extends ListBase<StackItem> {
    /**
     * Pops the stack
     * @return returns and removes top item in Stack
     */
    public StackItem Pop(){
        StackItem retval =null;
            if(isEmpty()){
            throw new java.util.NoSuchElementException("Empty Stack");
        }
        retval = head.getItem();
        
        head = head.GetNext();
        return retval;

}/**
 * Adds Item to Stack
 * @param stackitem
 * @return 
 */
    public Stack<StackItem> Push(StackItem stackitem)
    {
        Node lasthead = head;
        head = new Node(stackitem,lasthead);
        return this;
    }
    /**
     * Peeks stack to return top item witout removing
     * @return top item in stack
     */
    public StackItem Peek()
    {
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Empty Stack");
        }
        return head.getItem();
    }
    
    
}
