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
public class ListBase<StackItem> {
    protected Node head; 
    public boolean isEmpty(){
        return head==null;
    }
    public String toString()
    {
    
    }
    
    
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
            
    
    protected class Node{
        private StackItem itm;
        protected Node( StackItem stackitem, Node next)
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
    
    
