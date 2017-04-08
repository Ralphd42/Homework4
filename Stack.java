/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

/**
 *
 * @author ralph
 */
public class Stack<StackItem> extends ListBase<StackItem> {
    /**
     * Pops the stack
     * @return returns and pops top item in Stack
     */
    public StackItem Pop(){
        StackItem retval =null;
            if(isEmpty()){
            throw new java.util.NoSuchElementException("Empty Stack");
        }
        retval = head.getItem();
        
        head = head.GetNext();
        return retval;

}
    public Stack<StackItem> Push(StackItem stackitem)
    {
        Node lasthead = head;
        head = new Node(stackitem,lasthead);
        return this;
    }
    
    public StackItem Peek()
    {
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Empty Stack");
        }
        return head.getItem();
    }
    
    
}
