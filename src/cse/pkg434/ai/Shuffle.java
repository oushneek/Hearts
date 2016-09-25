/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Shuffle {
    public static ArrayList<String> player1=new ArrayList<String>();
    public static ArrayList<String> player2=new ArrayList<String>();
    public static ArrayList<String> player3=new ArrayList<String>();
    public static ArrayList<String> player4=new ArrayList<String>();
    
    
    public static ArrayList<Integer> selected1=new ArrayList<Integer>();
    public static ArrayList<Integer> selected2=new ArrayList<Integer>();
    public static ArrayList<Integer> selected3=new ArrayList<Integer>();
    public static ArrayList<Integer> selected4=new ArrayList<Integer>();
    
    public void shufflecards(ArrayList<String> cards){
        
        Random r= new Random();
        ArrayList<Integer> cardnum=new ArrayList<>();
        
        
        
        // shuffle cards between four players
        
        for(int i=0;i<52;i++){
            int temp=r.nextInt(52-0)+0;
            if(cardnum.contains(temp)){
                i--;
            }
            else{
                cardnum.add(temp);
            }
        }
        
        for(int i=0;i<52;){
            player1.add(cards.get(cardnum.get(i++)));
            player2.add(cards.get(cardnum.get(i++)));
            player3.add(cards.get(cardnum.get(i++)));
            player4.add(cards.get(cardnum.get(i++)));
        }
        
        // if any player has no card of hearts dn reshuffle
        
        int x;
        for(x=0;x<13;x++){
            if(player1.get(x).startsWith("H")){
                //System.out.println("hearts found");
                break;
            }
        }
        if(x==13){
            shufflecards(cards);
        }
        for(x=0;x<13;x++){
            if(player2.get(x).startsWith("H")){
              //  System.out.println("hearts found");
                break;
            }
        }
        if(x==13){
            shufflecards(cards);
        }
        for(x=0;x<13;x++){
            if(player3.get(x).startsWith("H")){
                //System.out.println("hearts found");
                break;
            }
        }
        if(x==13){
            shufflecards(cards);
        }
        for(x=0;x<13;x++){
            if(player4.get(x).startsWith("H")){
               // System.out.println("hearts found");
                break;
            }
        }
        if(x==13){
            shufflecards(cards);
        }
        
        Select selectcards=new Select();  
        //System.out.println("player 1:" +player1);
        selected1.addAll(selectcards.selectToPassCards(player1));
        //System.out.println("select: " +selected1);
       // System.out.println("selected cards : a) " +player1.get(selected1.get(0)) +"  (b) "+player1.get(selected1.get(1)) +"  (c) "+player1.get(selected1.get(2)));
        // System.out.println("select: " +selected1);
        
         
       // System.out.println("player 2:" +player2);
        selected2.addAll(selectcards.selectToPassCards(player2));
        //System.out.println("select: " +selected1);
        //System.out.println("select: " +selected2);
        //System.out.println("selected cards : a) " +player2.get(selected2.get(0)) +"  (b) "+player2.get(selected2.get(1)) +"  (c) "+player2.get(selected2.get(2)));
        
        
       // System.out.println("player 3:" +player3);
        selected3.addAll(selectcards.selectToPassCards(player3));
        //System.out.println("select: " +selected1);
        //System.out.println("selected cards : a) " +player3.get(selected3.get(0)) +"  (b) "+player3.get(selected3.get(1)) +"  (c) "+player3.get(selected3.get(2)));
        
        System.out.println("player 4:" +player4);
        System.out.println("Select 3 cards to pass to left user");
        ArrayList<String> p4str=new ArrayList<>();
        for(int q=0;q<3;q++){
            Scanner in = new Scanner(System.in);
            p4str.add(in.nextLine());
        }
        
        System.out.println(p4str);
        for(int q=0;q<3;q++){
            selected4.add(player4.indexOf(p4str.get(q)));
        }
        
//        selected4= passcards.selectToPassCards(player4);
        //System.out.println("selected cards : a) " +player4.get(selected4.get(0)) +"  (b) "+player4.get(selected4.get(1)) +"  (c) "+player4.get(selected4.get(2)));
//      
       // System.out.println("selected before class call"+selected1);
        Pass passcards=new Pass();
        passcards.passCards();
        
    }
}
