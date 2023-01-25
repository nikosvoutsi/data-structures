/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author nickv
 */
public class Main {
    public static void main(String[] args) {
        List list1 = new List();
        /*
        list1.printList();
        int x=3;
        System.out.println(x+" was found in position: "+list1.findDataPosition(x));
        list1.addNode(5);
       //System.out.println(list1.removeNodeFromEnd()+" was removed");
        list1.printList();
        list1.printList();
        list1.addNode(7);
        list1.addNode(6);
        list1.addNode(4);
        System.out.println("I will look for previous of "+ list1.getHead().getNext().getNext().getData());
        System.out.println(list1.findPrevious(list1.getHead().getNext().getNext()));    
        System.out.println("I will look for previous of "+ list1.getHead().getData());
        System.out.println(list1.findPrevious(list1.getHead()));  
        System.out.println("I will look for previous of "+ list1.getHead().getNext().getNext().getNext().getNext());
        System.out.println(list1.findPrevious(list1.getHead().getNext().getNext().getNext().getNext()));        
        list1.printList();
        x=7;
        System.out.println(x+" was found in position: "+list1.findDataPosition(x));
        x=10;
        System.out.println(x+" was found in position: "+list1.findDataPosition(x));
        System.out.println(list1.removeNodeFromStart()+" was removed");
        list1.printList();
        System.out.println(list1.removeNodeFromEnd()+" was removed");
        list1.printList();   
        */
        list1.printList();
        list1.addNode(10);
        list1.addNode(8);
        list1.addNode(3);
        list1.addNode(7);
        list1.printList();
        list1.bubbleSort();
    }//main
    
}//Main class
