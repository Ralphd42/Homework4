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
public class HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenStack<String> gs = new GenStack();
        gs.Push("one").Push("two");
        System.out.println(gs);
        String pop1 =gs.Pop();
        System.out.println(pop1);
        System.out.println("------------------------------------------");
        System.out.println(gs);
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        GnStack<String> gn11 = new GnStack();
        gn11.Push("a1");
        gn11.Push("b2");
        gn11.Push("c31");
        GenQueue <String> q = new GenQueue<String>();
        q.Enqueue("ONE");
        q.Enqueue("Two").Enqueue("THREE").Enqueue("nine").Enqueue("Eleven");
        System.out.println(q);
        
        
        
        
        
        
    }
    
}
