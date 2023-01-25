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
public class Node {
    
    //properties
    private int data;//το στοιχείο του κάθε κόμβου
    private Node next;//ο επόμενος κόμβος
    
    //constructor
    public Node(int data){
        this.data=data;
        this.next=null;
    }//Node
    
    //getters/setters
    public int getData() {
        return data;
    }//getData

    public void setData(int data) {
        this.data = data;
    }//setData

    public Node getNext() {
        return next;
    }//getNext

    public void setNext(Node next) {
        this.next = next;
    }//setNext
    
    //other methods
    public void print(){
        System.out.println(this+":data= "+this.data+" next= "+this.next);
    }//print
}//class
