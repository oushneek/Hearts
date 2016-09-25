/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import cse.pkg434.ai.*;
import java.util.ArrayList;


public class SpadesPlay {
    
    SpadesStart game=new SpadesStart();
    Compare cardsOfBoard=new Compare();
    MinHearts minHeart=new MinHearts();
    MinDiamonds diamond=new MinDiamonds();
    MinClubs club=new MinClubs();
    MinSpades spade=new MinSpades();
    MaxHearts maxHeart=new MaxHearts();
    
    public void play(ArrayList<String> player, int playerNo){
        if(!player.isEmpty()){
            int size=player.size();
            String firstCardType=""+ Start.board.get(0).charAt(0);
                int i=0;
                String addSpade="";
                for(i=0;i<size;i++){
                    if(player.get(i).startsWith(firstCardType)){
                        addSpade=spade.minOfSpades(player);
                        break;
                    }
                }
                if(i<size){
                    giveCard(player, playerNo, addSpade);
                }
                if(i==size && Cse434AI.level==2){
                       String addHeart="";
                       int z=0;
                       for(z=0;z<size;z++){
                            if(player.get(z).startsWith("H")){
                                addHeart=maxHeart.maxOfHearts(player);
                                break;
                            }
                        }
                       if(z<size){
                            giveCard(player, playerNo, addHeart);
                        }
                        else if(z==size){        
                            String addDiamond="";
                            int p=0;
                            for(p=0;p<size;p++){
                                if(player.get(p).startsWith("D")){
                                    addDiamond=diamond.minOfDiamonds(player);
                                    break;
                                }
                            }
                            if(p<size){
                                giveCard(player, playerNo, addDiamond);
                            }
                            else if(p==size){
                                String addClub="";
                                int q=0;
                                for(q=0;q<size;q++){
                                    if(player.get(q).startsWith("C")){
                                        addClub=club.minOfClubs(player);
                                        break;
                                    }
                                }
                                if(q<size){
                                    giveCard(player, playerNo, addClub);
                                }
                            }
                        }

                }
                else if(i==size && Cse434AI.level==1 && !player.isEmpty()){
                    String addClub="";
                    int q=0;
                    for(q=0;q<size;q++){
                        if(player.get(q).startsWith("C")){
                            addClub=club.minOfClubs(player);
                            break;
                         }
                    }
                    if(q<size){
                        giveCard(player, playerNo, addClub);
                    }
                    else if(q==size){
                        String addDiamond="";
                        int p=0;
                        for(p=0;p<size;p++){
                            if(player.get(p).startsWith("D")){
                                addDiamond=diamond.minOfDiamonds(player);
                                break;
                            }
                        }
                        if(p<size){
                            giveCard(player, playerNo, addDiamond);
                        }
                        else if(p==size){
                            String addHeart="";
                            int z=0;
                            for(z=0;z<size;z++){
                                 if(player.get(z).startsWith("H")){
                                     addHeart=minHeart.minOfHearts(player);
                                     break;
                                 }
                            }
                            Start.heartbroken=1;
                            giveCard(player, playerNo, addHeart);
                        }
                    }
                    
                }
        }
    }
    
    public void giveCard(ArrayList<String> player,int playerNo,String card){
        Start.board.add(card);
        
        System.out.println("player "+playerNo+" = "+player);
        System.out.println("board "+playerNo+" " +Start.board);
        
        if(Start.nextPlayer==3)
            Shuffle.player3.remove(card);
        else if(Start.nextPlayer==2)
            Shuffle.player2.remove(card);
        else if(Start.nextPlayer==1)
            Shuffle.player1.remove(card);
        System.out.println("player "+playerNo+" = "+player);
        Start.nextPlayer=playerNo+1;
        if(Start.nextPlayer>4)
            Start.nextPlayer-=4;
        System.out.println("board "+playerNo+" " +Start.board);
        if(Start.board.size()<4)
            game.continueSpade();
        else if(Start.board.size()==4)
            cardsOfBoard.compareCards();
    }

}
