/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.Scanner;
import cse.pkg434.ai.*;

public class Decision {
    
    public void decide(int cardwinner){
        
        
        
        ClubsStart club=new ClubsStart();
        DiamondsStart diamond=new DiamondsStart();
        HeartsStart heart =new HeartsStart();
        SpadesStart spade=new SpadesStart();
        
        MinClubs minC=new MinClubs();
        MinDiamonds minD=new MinDiamonds();
        MinHearts minH=new MinHearts();
        MinSpades minS=new MinSpades();
        
        if(cardwinner==4){
            //System.out.println("board 3: " +Start.board);
            Start.board.clear();
            System.out.println("player 4 :"+Shuffle.player4);
            System.out.println("give input");
            Scanner in = new Scanner(System.in);
            String input= in.nextLine();
            int i=0;
            for(i=0;i<Shuffle.player4.size();i++){
                if(!Shuffle.player4.get(i).startsWith("H")){
                    break;
                }
            }
            if(i==Shuffle.player4.size())
                Start.heartbroken=1;
            if(input.startsWith("H") && Start.heartbroken!=1){
                while(Start.heartbroken==0 && input.startsWith("H")){
                    System.out.println("Heart is not broken. You have to enter another card");
                    input=in.nextLine();
                }
            }
            
                Start.board.add(input);
                Shuffle.player4.remove(input);
                System.out.println("board 4: "+Start.board);
                Start.nextPlayer=1;
           
            
            
            if(input.startsWith("C"))
                club.continueClub();
            else if(input.startsWith("D"))
                diamond.continueDiamond();
            else if(input.startsWith("H"))
                heart.continueHeart();
            else if(input.startsWith("S"))
                spade.continueSpade();
        }
        else if(cardwinner==3){
            Start.board.clear();
            String input="";
            input=minC.minOfClubs(Shuffle.player3);
            if(input.equals(""))
                input=minD.minOfDiamonds(Shuffle.player3);
            if(input.equals(""))
                input=minS.minOfSpades(Shuffle.player3);
            int i=0;
            for(i=0;i<Shuffle.player3.size();i++){
                if(!Shuffle.player3.get(i).startsWith("H")){
                    break;
                }
            }
            if(i==Shuffle.player3.size())
                Start.heartbroken=1;
            if(input.equals("")  && Start.heartbroken==1)
                input=minH.minOfHearts(Shuffle.player3);
            
            Start.board.add(input);
            Shuffle.player3.remove(input);
            System.out.println("board 3: "+Start.board);
            
            Start.nextPlayer=4;
            if(input.startsWith("C"))
                club.continueClub();
            else if(input.startsWith("D"))
                diamond.continueDiamond();
            else if(input.startsWith("H"))
                heart.continueHeart();
            else if(input.startsWith("S"))
                spade.continueSpade();
            
        }
        else if(cardwinner==2){
            Start.board.clear();
            String input="";
            input=minC.minOfClubs(Shuffle.player2);
            if(input.equals(""))
                input=minD.minOfDiamonds(Shuffle.player2);
            if(input.equals(""))
                input=minS.minOfSpades(Shuffle.player2);
            int i=0;
            for(i=0;i<Shuffle.player2.size();i++){
                if(!Shuffle.player2.get(i).startsWith("H")){
                    break;
                }
            }
            if(i==Shuffle.player2.size())
                Start.heartbroken=1;
            if(input.equals("")  && Start.heartbroken==1)
                input=minH.minOfHearts(Shuffle.player2);
            
            Start.board.add(input);
            Shuffle.player2.remove(input);
            System.out.println("board 2: "+Start.board);
            Start.nextPlayer=3;
            if(input.startsWith("C"))
                club.continueClub();
            else if(input.startsWith("D"))
                diamond.continueDiamond();
            else if(input.startsWith("H"))
                heart.continueHeart();
            else if(input.startsWith("S"))
                spade.continueSpade();
            
        }
        else if(cardwinner==1){
            Start.board.clear();
            String input="";
            input=minC.minOfClubs(Shuffle.player1);
            if(input.equals(""))
                input=minD.minOfDiamonds(Shuffle.player1);
            if(input.equals(""))
                input=minS.minOfSpades(Shuffle.player1);
            int i=0;
            for(i=0;i<Shuffle.player4.size();i++){
                if(!Shuffle.player4.get(i).startsWith("H")){
                    break;
                }
            }
            if(i==Shuffle.player4.size())
                Start.heartbroken=1;
            if(input.equals("")  && Start.heartbroken==1)
                input=minH.minOfHearts(Shuffle.player1);
            
            Start.board.add(input);
            Shuffle.player1.remove(input);
            System.out.println("board 1: "+Start.board);
            Start.nextPlayer=2;
            if(input.startsWith("C"))
                club.continueClub();
            else if(input.startsWith("D"))
                diamond.continueDiamond();
            else if(input.startsWith("H"))
                heart.continueHeart();
            else if(input.startsWith("S"))
                spade.continueSpade();
            
        }
        
        
    }
}
