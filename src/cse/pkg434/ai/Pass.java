/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import cse.pkg434.ai.Shuffle.*;
import java.util.ArrayList;
import java.util.Collections;



public class Pass {
    public void passCards(){
        
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<3;i++){
            // save the cards player 1 selected in a temp arraylist
            temp.add(Shuffle.player1.get(Shuffle.selected1.get(i)));
            
           // save the cards  player 4 selected in the cards of player 1 
            Shuffle.player1.set(Shuffle.selected1.get(i),Shuffle.player4.get(Shuffle.selected4.get(i)));
            
           //  save the cards  player 3 selected in the cards of player 4 
            Shuffle.player4.set(Shuffle.selected4.get(i),Shuffle.player3.get(Shuffle.selected3.get(i)));
            
            //  save the cards  player 2 selected in the cards of player 3 
            Shuffle.player3.set(Shuffle.selected3.get(i),Shuffle.player2.get(Shuffle.selected2.get(i)));
            
            //  save the cards  player1(temp) selected in the cards of player 2
            Shuffle.player2.set(Shuffle.selected2.get(i),temp.get(i));
           
        }
        
        System.out.println("cards after passing");
        //System.out.println("selected1" +Shuffle.selected1);
       // System.out.println("temp :" +temp);
//        System.out.println("player 1" +Shuffle.player1);
//        System.out.println("player 2" +Shuffle.player2);
//        System.out.println("player 3" +Shuffle.player3);
        //System.out.println("player 4" +Shuffle.player4);
        
        
    }
}
