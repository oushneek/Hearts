/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;
import java.util.Random;

public class Select {
    ArrayList<Integer> selectedIndex=new ArrayList<>();
    int maxSelect=0;
    int countH=0;
    public ArrayList<Integer> selectToPassCards(ArrayList<String> player){
        
        maxSelect=0;
        countH=0;
        int countS=0;
        int SQis=0, SKis=0,SAis=0;
        
        selectedIndex.clear();
        
        
        // select Q,K,A of Spade first
        for(int i=0;i<13;i++){
            if(player.get(i).equals("SA")){
                countS++;
                SAis=1;
                selectedIndex.add(i);
                maxSelect++;
            }
            else if(player.get(i).equals("SK")){
                countS++;
                SKis=1;
                selectedIndex.add(i);
                maxSelect++;
            }
            else if(player.get(i).equals("SQ")){
                countS++;
                SQis=1;
                selectedIndex.add(i);
                maxSelect++;
            }
            else if(player.get(i).startsWith("H"))
                countH++;
        }
        
        // if 3 cards are not selected then select from hearts leaving at least one card from hearts
        Random r= new Random();
        while(maxSelect<3){
            if(countH>1){
                selectFromHearts(player);
            }
            else{
                //selectFromHearts(player, maxSelect);
                //System.out.println("hearts is less dn 1");
                int temp=r.nextInt(13-0)+0;
                if((!selectedIndex.contains(temp)) && (!player.get(temp).startsWith("H"))){
                    selectedIndex.add(temp);
                    maxSelect++;
                }
            }
                
        }
        
        
        
        
        //System.out.println(selectedIndex);
        //System.out.println("Hearts=" +countH);
        //System.out.println("Spade " +countS +" Q ="+SQis+" K ="+SKis+" A= "+SAis);
        
        return selectedIndex;
        
    }
    
    public void selectFromHearts(ArrayList<String> cards){

        if(cards.contains("HA") && !selectedIndex.contains(cards.indexOf("HA"))){
            selectedIndex.add(cards.indexOf("HA"));
            maxSelect++;
            countH--;
        }
        else  if(cards.contains("HK") && !selectedIndex.contains(cards.indexOf("HK"))){
            selectedIndex.add(cards.indexOf("HK"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("HQ")  && !selectedIndex.contains(cards.indexOf("HQ"))){
            selectedIndex.add(cards.indexOf("HQ"));
            maxSelect++;
            countH--;
        }
         
        else if(cards.contains("HJ")  && !selectedIndex.contains(cards.indexOf("HJ"))){
            selectedIndex.add(cards.indexOf("HJ"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H10") && !selectedIndex.contains(cards.indexOf("H10"))){
            selectedIndex.add(cards.indexOf("H10"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H9")  && !selectedIndex.contains(cards.indexOf("H9"))){
            selectedIndex.add(cards.indexOf("H9"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H8") && !selectedIndex.contains(cards.indexOf("H8"))){
            selectedIndex.add(cards.indexOf("H8"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H7") && !selectedIndex.contains(cards.indexOf("H7"))){
            selectedIndex.add(cards.indexOf("H7"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H6") && !selectedIndex.contains(cards.indexOf("H6"))){
            selectedIndex.add(cards.indexOf("H6"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H5") && !selectedIndex.contains(cards.indexOf("H5"))){
            selectedIndex.add(cards.indexOf("H5"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H4") && !selectedIndex.contains(cards.indexOf("H4"))){
            selectedIndex.add(cards.indexOf("H4"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H3") && !selectedIndex.contains(cards.indexOf("H3"))){
            selectedIndex.add(cards.indexOf("H3"));
            maxSelect++;
            countH--;
        }
        else if(cards.contains("H2") && !selectedIndex.contains(cards.indexOf("H2"))){
            selectedIndex.add(cards.indexOf("H2"));
            maxSelect++;
            countH--;
        }
            
    }
}
