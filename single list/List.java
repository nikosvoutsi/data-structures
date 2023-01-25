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
public class List {
    
    //properties
    private Node head;//το πρώτο στοιχείο της λίστας
    private Node tail;//το τελευταίο στοιχείο της λίστας
    private int size;
       
    //constructor
    public List(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }//List
    
    //getters/setters
    public Node getHead() {
        return head;
    }//getHead

    public void setHead(Node head) {
        this.head = head;
    }//setHead
    
    public Node getTail() {
        return tail;
    }//getTail

    public void setTail(Node tail) {
        this.tail = tail;
    }//setTail

    public int getSize() {
        return size;
    }//getSize

    public void setSize(int size) {
        this.size = size;
    }//setSize
        
    //other methods
    public boolean isEmpty(){
        return size==0;       
    }//isEmpty
    
    public void addNode(int data){
        Node newNode=new Node(data);
        if (this.isEmpty()){
            head=newNode;
            tail=newNode;
            this.size++;
        }//if 
        else{
            /*
            Node temp=head;           
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }//while
            temp.setNext(newNode);
            this.size++;
            this.tail=newNode;
            */
            this.tail.setNext(newNode);
            this.tail=newNode;
            this.size++;
        }//else            
    }//addNote
    
    public int findDataPosition(int x){
        int position=-1;
        Node temp=head;
        for (int i = 1; i <= size; i++) {
            if (temp.getData()==x){
               position=i;
               break;
            }//if
            temp=temp.getNext();
        }//for
        return position;
    }//findDataPosition
    
    public int removeNodeFromStart(){
        int temp=-1;
        if(this.isEmpty()){
            System.out.println("the list is empty");            
        }//if
        else if(this.size==1){
            temp=head.getData();
            head=null;
            tail=null;
            size=0;
        }//else if
        else{
            temp=head.getData();
            head=head.getNext();
            size--;
        }//else
        return temp;
    }//removeNodeFromStart
    
    public int removeNodeFromEnd(){
        int temp=-1;
        if(this.isEmpty()){
            System.out.println("the list is empty");            
        }//if
        else if(this.size==1){
            temp=head.getData();
            head=null;
            tail=null;
            size=0;
        }//else if
        else{
            temp=tail.getData();
            Node tempNode=head;
            for (int i = 1; i <size-1; i++) {
                tempNode=tempNode.getNext();
            }//for
            tempNode.setNext(null);
            this.tail=tempNode;
            size--;
        }//else
        return temp;
    }//removeNodeFromEnd
    
    public Node findPrevious(Node node){
        Node temp;
        if (node==null){
            System.out.println("Invalid node");
            return null;
        }
        if (this.isEmpty()){
            System.out.println("The List is empty");
            temp=null;
        }
        //List is not empty
        temp=this.head;
        if(temp==node) {
            System.out.println("The Node is the head,it has not any previous.");
            temp= null;
        }
        temp=this.head;
        while(temp.getNext()!=node && temp.getNext()!=null){ // !(temp.getNext()==node || temp.getNext()==null)          
            temp=temp.getNext();
        }
        if(temp.getNext()==node){
            System.out.println("Node was found and previous was return");
        }
        if(temp.getNext()==null){
            System.out.println("Node was not found");
            temp=null;
        }
        return temp;
    }//findPrevious

    public void printList(){
        Node temp=head;
        System.out.println("###Head: "+head+" ##tail: "+this.tail+" ##size: "+this.size+" ###");
        while(temp!=null){
            temp.print();
            temp=temp.getNext();
        }//while
        System.out.println("#######\n");
    }//printList
    
    public void bubbleSort() {
        if (this.size > 1) {
            Node temp;
            boolean flag;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.getNext();
                flag = false;

                while ( next != null ) {
                    if (current.getData() > next.getData()) {

                        
                        flag = true;

                        if ( previous != null ) {
                            temp = next.getNext();
                            previous.setNext(next);
                            next.setNext(current);
                            current.setNext(temp);
                        } else {
                            temp = next.getNext();
                            head = next;
                            next.setNext(current);
                            current.setNext(temp);
                        }

                        previous = next;
                        next = current.getNext();
                    } else { 
                        previous = current;
                        current = next;
                        next = next.getNext();
                    }
                } 
            } while( flag );
        }//if
        this.printList();
    }//bubbleSort
    
}//class
