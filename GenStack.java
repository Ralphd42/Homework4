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
public class GenStack<StackItem> {
    
    private Node head;
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
    public GenStack<StackItem> Push(StackItem stackitem)
    {
        Node lasthead = head;
        head = new Node(stackitem,lasthead);
        return this;
    }
    
    public boolean isEmpty()
    {
        return head==null;
    
    }
    
    public StackItem Peek()
    {
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Empty Stack");
        }
        return head.getItem();
    }
    
   
    
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        while (tmp!=null)
        {
            sb.append(tmp.getItem());
            sb.append("\n");
            tmp = tmp.GetNext();
        }
        
        
        
        return sb.toString();
        
    }
    
    
    private class Node
    {
        private StackItem itm;
        private Node( StackItem stackitem, Node next)
        {
            itm =stackitem;
            nxt = next;
        
        }
        
        StackItem getItem ()
        {
            return itm;
        }
        private Node nxt;
        public void SetNext( Node n)
        {
            nxt =n;
        }
        public Node GetNext ()
        {
            return nxt;
        }
        
        
        
        
    }
    
    
}
