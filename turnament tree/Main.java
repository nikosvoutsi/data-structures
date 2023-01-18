/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import com.sun.source.tree.BreakTree;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nickv
 */
public class Main {
    public static void main(String[] args)  {
        System.out.println("Give the number of teams");
        Scanner keys=new Scanner(System.in);
        int x=keys.nextInt();
        double y=log2(x);
        y=log2(x);
        while (Math.round(y)!=y||x==1) {
            System.out.println("The number of teams must be an integer force of 2!!!");
            System.out.println("Give the number of teams");
            x=keys.nextInt();
            y=log2(x);
        }//while7
                
        ArrayList<String> Teams= new ArrayList<>();
        System.out.println("Give the participating teams");
        for (int i = 0; i <x ; i++) {
            Teams.add(keys.next());
        }//for 

        Tree CL=new Tree(x);
        while (!CL.isFull()) {  
            CL.drawAndPutResults(Teams,x); 
        }//while 
        
        CL.printFinalWinner();     
        CL.printRouteOfTheWinner();       
        //CL.printTotalRoute(x);
        
    }//main
    
    public static double log2(int N){
        double result = (Math.log(N) / Math.log(2));  
        return result;
    }
}
