/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import cse.pkg434.ai.*;
import java.util.ArrayList;


public class ClubsPlay {
    ClubsStart game=new ClubsStart();
    Compare cardsOfBoard=new Compare();
    MaxHearts maxHeart=new MaxHearts();
    MinDiamonds diamond=new MinDiamonds();
    MinClubs club=new MinClubs();
    MinSpades spade=new MinSpades();
    MinHearts  minHeart=new MinHearts();
    
    public void play(ArrayList<String> player, int playerNo){
        if(!player.isEmpty()){
            int size=player.size();
            String firstCardType=""+ Start.board.get(0).charAt(0);
            int i=0;
            String addClub="";
            for(i=0;i<size;i++){
                if(player.get(i).startsWith(firstCardType)){
                    addClub=club.minOfClubs(player);
                    //System.out.println("addClub of player "+playerNo+ " ="+addClub);     
                    break;
                }
            }
            if(i<size){
                giveCard(player, playerNo, addClub);
            }          
            else if(i==size){
                if(player.contains("SQ") && Cse434AI.level==2){
                    giveCard(player, playerNo,"SQ");
                }
                else if(player.contains("SK") && Cse434AI.level==2){
                    giveCard(player, playerNo,"SK");
                }
                else if(player.contains("SA") && Cse434AI.level==2){
                    giveCard(player, playerNo,"SA");
                }
                else if(Cse434AI.level==2){   // for intermediate level
                    String addHeart="";
                    int p=0;
                    for(p=0;p<size;p++){
                        if(player.get(p).startsWith("H")){
                            addHeart=maxHeart.maxOfHearts(player);
                            break;
                        }
                    }
                   
                    if(p<size){
                        Start.heartbroken=1;
                        giveCard(player, playerNo, addHeart);
                    }
                    else if(p==size){
                        String addDiamond="";
                        int q=0;
                        for(q=0;q<size;q++){
                            if(player.get(q).startsWith("D")){
                                addDiamond=diamond.minOfDiamonds(player);
                                break;
                            }
                        }
                        if(q<size){
                            giveCard(player, playerNo, addDiamond);
                        }
                        else if(q==size){
                            String addSpade="";
                            int z=0;
                            for(z=0;z<size;z++){
                                if(player.get(z).startsWith("S")){
                                    addSpade=spade.minOfSpades(player);
                                    break;
                                }
                            }
                            giveCard(player, playerNo, addSpade);
                            
                        }
                    }
                }
                else if(i==size && Cse434AI.level==1 && !player.isEmpty()){    // for beginner level
                    String addDiamond="";
                        int q=0;
                        for(q=0;q<size;q++){
                            if(player.get(q).startsWith("D")){
                                addDiamond=diamond.minOfDiamonds(player);
                                break;
                            }
                        }
                        if(q<size){
                            giveCard(player, playerNo, addDiamond);
                        }
                        else if(q==size){
                        String addSpade="";
                        int z=0;
                        for(z=0;z<size;z++){
                            if(player.get(z).startsWith("S")){
                                addSpade=spade.minOfSpades(player);
                                break;
                            }
                        }
                        if(z<size){
                            giveCard(player, playerNo, addSpade);
                        }
                        else if(z==size){
                            String addHeart="";
                            int p=0;
                            for(p=0;p<size;p++){
                                if(player.get(p).startsWith("H")){
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
            game.continueClub();
        else if(Start.board.size()==4)
            cardsOfBoard.compareCards();
    }
}
