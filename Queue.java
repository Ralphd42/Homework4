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
public class Queue<StackItem> extends ListBase<StackItem> {
    
    private Node tail;
    
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
     * 
     * @return 
     */
    public StackItem Dequeue()
    {
        if( isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        StackItem retval = head.getItem();
        head = head.GetNext();
        if( head==null){
            tail=null;
        }
        return retval;
    }
    
    public StackItem Peek()
    {
        if( isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        return head.getItem();
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    }

