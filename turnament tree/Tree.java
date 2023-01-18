/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nickv
 */
public class Tree {
    
    //properties
    private Node root=null;
    private ArrayList <Node> currentRoots=new ArrayList<>();
    private int size;//ΑΡΙΘΜΟΣ ΟΜΑΔΩΝ ΤΡΕΧΟΥΣΑΣ ΦΑΣΗΣ 
    private int currentSize;//συνολικός αριθμός κόμβων κάθε φάσης
    
    //constructor
    public Tree(int size) {
        this.size = size;
        this.currentSize=0;
    }

    //getters and setters
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public ArrayList<Node> getCurrentRoots() {
        return currentRoots;
    }

    public void setCurrentRoots(ArrayList<Node> currentRoots) {
        this.currentRoots = currentRoots;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
    
    //other methods
    
    public boolean isFull(){
        return this.root!=null;
    }//isFull

    public void printFinalWinner(){
        System.out.println("the final winner of the tournament is... \n"+this.root.getTeam()+"!!!");
    }
    
    public Node findWinner(Node left, Node right){
        Node newNode=null;
        int numberOfPenalties1;
        int numberOfPenalties2;
        Scanner keys=new Scanner(System.in);
        if (left.getGoals()>right.getGoals()){
            newNode=new Node(left.getTeam());
        }else if(left.getGoals()<right.getGoals()){
            newNode=new Node(right.getTeam());
        }else{   
            System.out.println("Give penalties of "+left.getTeam());
            numberOfPenalties1=keys.nextInt();
            System.out.println("Give penalties of "+right.getTeam());
            numberOfPenalties2=keys.nextInt();
            if (numberOfPenalties1>numberOfPenalties2) {
                newNode=new Node(left.getTeam());
                left.setGoals(left.getGoals()+1);
            }else{
                newNode=new Node(right.getTeam());
                right.setGoals(right.getGoals()+1);
            }//else   
        }//else 
        newNode.setLeft(left);
        newNode.setRight(right);
        left.setParent(newNode);
        right.setParent(newNode);
        currentRoots.add(newNode);
        return newNode;
    }//findWinner
    
    public List drawAndPutResults(ArrayList<String> Teams, int x){
        if (x==this.size){
            while (Teams.size()>0) {            
                Random r = new Random();
                int result = r.nextInt(Teams.size()) ;
                Node tempNode=new Node(Teams.get(result));
                this.currentRoots.add(tempNode);//δημιουργώ λίστα από κόμβους
                Teams.remove(result);
            }//while
        }//if
        if(this.size==x){
            System.out.println("The following pairs emerged after a draw: "); 
        }else if(this.size==2){
            System.out.println("The final is: ");
        }else if(this.size==8){
            System.out.println("Quarterfinals:");
        }else if(this.size==4){
            System.out.println("Semifinals:");
        }else    
            System.out.println("The games of the next phase are the following:");
        for (int i = this.currentSize; i < this.size+this.currentSize; i=i+2) {
                System.out.println(this.currentRoots.get(i).getTeam()+" - "+this.currentRoots.get(i+1).getTeam());             
        }//for
        
        int numberOfGoals;
        Scanner keys=new Scanner(System.in);
        for (int i = this.currentSize; i < this.size+this.currentSize; i++) {
            System.out.println("Give the team goals: "+this.currentRoots.get(i).getTeam());
            numberOfGoals=keys.nextInt();
            this.currentRoots.get(i).setGoals(numberOfGoals);            
        }//for
        System.out.println("The results were as follows:");
        for (int i = this.currentSize; i < this.size+this.currentSize; i=i+2) {
            System.out.println(this.currentRoots.get(i).getTeam()+" - "+this.currentRoots.get(i+1).getTeam()+" "+this.currentRoots.get(i).getGoals()+" - "+this.currentRoots.get(i+1).getGoals());
        }//for
        Node W=null;
        if(this.size>2)
            System.out.println("The following teams qualify to the next round:");           
        for (int i = this.currentSize; i < this.size+this.currentSize; i=i+2) {
            W=this.findWinner(this.currentRoots.get(i), this.currentRoots.get(i+1));
            if(this.size>2)
                System.out.println(W.getTeam());
            Teams.add(W.getTeam());                  
        }//for
        this.currentSize+=this.size;
        this.size=this.size/2;
        if (this.size==1)
            this.root=W;
        return Teams;
    }//draw
    
    public void printTotalRoute(int x){
        System.out.println("The panorama of the tournament was as follows:");
        for (int i = 0; i < this.currentSize; i=i+2) {
            System.out.println(this.getCurrentRoots().get(i).getTeam()+" - "+this.getCurrentRoots().get(i+1).getTeam()
                +" "+this.getCurrentRoots().get(i).getGoals()+" - "+this.getCurrentRoots().get(i+1).getGoals());
        }//for
    }//printTotalRoute
    
    public void printRouteOfTheWinner(){
        System.out.println("The winner's route was as follows:");
        Node tempNode=this.root;
        while (tempNode.getLeft()!=null) {  
            System.out.println(tempNode.getLeft().getTeam()+" - "+tempNode.getLeft().getParent().getRight().getTeam()+"  "
                    +tempNode.getLeft().getGoals()+" - "+tempNode.getLeft().getParent().getRight().getGoals());
            if (tempNode.getLeft().getTeam()==this.root.getTeam()){                
                tempNode=tempNode.getLeft();
            }else
                tempNode=tempNode.getRight();
        }//while
    }//printRouteOfTheWinner
    
}//Tree

