/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;
import cse.pkg434.ai.*;
import java.util.Collections;


public class Compare {
    public void compareCards(){

        Score countscore=new Score();
        Decision nextGame=new Decision();
        if(!Start.board.isEmpty()){
            String firstCardType=""+Start.board.get(0).charAt(0);
            String maxCard="";
            int maxcardvalue=0;
            int i=0;
            for(i=0;i<4;i++){
                String temp=Start.board.get(i);
                if(temp.startsWith(firstCardType)){
                    if(maxcardvalue<14 && temp.endsWith("A")){
                        maxCard=temp;
                        maxcardvalue=14;
                    }
                    else if(maxcardvalue<13 && temp.endsWith("K")){
                        maxCard=temp;
                        maxcardvalue=13;
                    }
                    else if(maxcardvalue<12 && temp.endsWith("Q")){
                        maxCard=temp;
                        maxcardvalue=12;
                    }
                    else if(maxcardvalue<11 && temp.endsWith("J")){
                        maxCard=temp;
                        maxcardvalue=11;
                    }
                   else if( (!temp.endsWith("A"))  && (!temp.endsWith("K"))  && (!temp.endsWith("Q")) && (!temp.endsWith("J"))){
                        String digits=temp.substring(1, temp.length());
                        //System.out.println("dgit "+digits );
                        int tempcardval=Integer.parseInt(digits);
                        if(maxcardvalue<tempcardval){
                            maxCard=temp;
                            maxcardvalue=tempcardval;
                        }
                    }


                }
            }
            //System.out.println("maxcard = "+maxCard);
            int index=Start.board.indexOf(maxCard);
           // System.out.println("index =" +index);
           // System.out.println("start player ="+Start.startPlayer);
            int cardwinner=index+Start.startPlayer;
            if(cardwinner>4)
                cardwinner-=4;
            //System.out.println(" player to get the cards =" +cardwinner);
            Start.startPlayer= cardwinner;
            Start.nextPlayer=cardwinner;

            if(cardwinner==4){
                for(int x=0;x<4;x++)
                    Start.player4get.add(Start.board.get(x));
                System.out.println("player4 gets "+Start.player4get);
                countscore.count(cardwinner);
            }
            else if(cardwinner==3){
                for(int x=0;x<4;x++)
                    Start.player3get.add(Start.board.get(x));
                System.out.println("player3 gets "+Start.player3get);
                countscore.count(cardwinner);
            }

            else if(cardwinner==2){
                for(int x=0;x<4;x++)
                    Start.player2get.add(Start.board.get(x));
                System.out.println("player2 gets "+Start.player2get);
                countscore.count(cardwinner);
            }

            else if(cardwinner==1){
                for(int x=0;x<4;x++)
                    Start.player1get.add(Start.board.get(x));
                System.out.println("player1 gets "+Start.player1get);
                countscore.count(cardwinner);
            }

            Start.board.clear();
    
            if(Shuffle.player1.isEmpty() && Shuffle.player2.isEmpty() && Shuffle.player3.isEmpty() && Shuffle.player4.isEmpty())
            {
                System.out.println("Game Complete");
                System.out.println("score "+Start.score);
                Start.nextPlayer=0;
                Start.startPlayer=0;
            }

            else {
                nextGame.decide(cardwinner);

            }
        }
    }
}
