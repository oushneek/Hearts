/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.Scanner;
import cse.pkg434.ai.*;

public class DiamondsStart {
     public void continueDiamond(){
        
        
        Compare cardsOfBoard=new Compare();
        MaxHearts max=new MaxHearts();
        DiamondsPlay play=new DiamondsPlay();
    
        if(Start.nextPlayer==4  && !Shuffle.player4.isEmpty()){
            int size=Shuffle.player4.size();
            System.out.println("player 4 = "+Shuffle.player4 );
            String firstCardType=""+ Start.board.get(0).charAt(0);
            String input="";
            int i=0;
            for(i=0;i<size;i++){
                if(Shuffle.player4.get(i).startsWith(firstCardType)){
                    while(!input.startsWith(firstCardType)){

                        System.out.println("give input from "+firstCardType);
                        Scanner in = new Scanner(System.in);
                        input= in.nextLine();
                        
                    }
                    break;
                }    
            }
            if(i==size){
                Scanner in = new Scanner(System.in);
                input= in.nextLine();
            }
            if(input.startsWith("H"))
                Start.heartbroken=1;
            Start.board.add(input);
            Shuffle.player4.remove(input);
            System.out.println("board 4" +Start.board);
            
            System.out.println("player 4 = "+Shuffle.player4);
             
            Start.nextPlayer=1;
            if(Start.board.size()<4)
                continueDiamond();
            else if(Start.board.size()==4)
                cardsOfBoard.compareCards();
        }
        else if (Start.nextPlayer==3  && !Shuffle.player3.isEmpty()){
            play.play(Shuffle.player3, Start.nextPlayer);
        }
        else if (Start.nextPlayer==2  && !Shuffle.player2.isEmpty()){
            play.play(Shuffle.player2, Start.nextPlayer);  
        }
        else if (Start.nextPlayer==1  && !Shuffle.player1.isEmpty()){
            play.play(Shuffle.player1, Start.nextPlayer);  
        }
        
    }
    
    
}
