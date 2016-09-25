/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import cse.pkg434.ai.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    
    public static ArrayList<String> board = new ArrayList<>();
    public static int nextPlayer=0;
    public static int startPlayer=0;
    public static ArrayList<Integer> score=new ArrayList<>();
    
    public static int heartbroken=0;
    
    public static ArrayList<String> player1get = new ArrayList<>();
    public static ArrayList<String> player2get = new ArrayList<>();
    public static ArrayList<String> player3get = new ArrayList<>();
    public static ArrayList<String> player4get = new ArrayList<>();
    
    public void startGame(int playerNo){
        
        for(int i=0;i<4;i++)
        {
            Start.score.add(0);
        }
        
        
        System.out.println("1 :"+Shuffle.player1);
        System.out.println("2 :"+Shuffle.player2);
        System.out.println("3 :"+Shuffle.player3);
        System.out.println("4 :"+Shuffle.player4);
        
        
        if(playerNo==4){
            System.out.println("Player with 2 of Clubs (C2) starts the game");
            System.out.println("player 4= "+Shuffle.player4);
            String input="";
            
            while(!input.equals("C2")){
                
                System.out.println("give C2");
                Scanner in = new Scanner(System.in);
                input= in.nextLine();
                
            }
            board.add("C2");
            Shuffle.player4.remove("C2");
            startPlayer=4;
            nextPlayer=1;
            System.out.println("board   4" +board );
        }
        else if(playerNo==1){
            System.out.println("Player 1= "+Shuffle.player1);
             board.add("C2");
             Shuffle.player1.remove("C2");
             startPlayer=1;
             nextPlayer=2;
             System.out.println("board 1" +board );
        }
        else if(playerNo==2){
            System.out.println("Player 2= "+Shuffle.player2);
             board.add("C2");
             Shuffle.player2.remove("C2");
             startPlayer=2;
             nextPlayer=3;
             System.out.println("board 2" +board );
        }
        else if(playerNo==3){
            System.out.println("Player 3= "+Shuffle.player3);
             board.add("C2");
             Shuffle.player3.remove("C2");
             startPlayer=3;
             nextPlayer=4;
             System.out.println("board 3" +board );
        }
        
        ClubsStart game=new ClubsStart();
        game.continueClub();
        
    }
}
