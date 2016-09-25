/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;
import cse.pkg434.ai.*;
import javax.xml.soap.SAAJMetaFactory;

public class Score {
    public void count(int playerno){
        
        
        
        
        if(playerno==1){
            int count=0;
            for(int i=0;i<Start.player1get.size();i++){
                if(Start.player1get.get(i).startsWith("H"))
                    count++;
                else if(Start.player1get.get(i).equals("SQ"))
                    count+=13;
            }
            Start.score.set(0, count);
            
        }
        if(playerno==2){
            int count=0;
            for(int i=0;i<Start.player2get.size();i++){
                if(Start.player2get.get(i).startsWith("H"))
                    count++;
                else if(Start.player2get.get(i).equals("SQ"))
                    count+=13;
            }
            Start.score.set(1, count);
            
        }
        if(playerno==3){
            int count=0;
            for(int i=0;i<Start.player3get.size();i++){
                if(Start.player3get.get(i).startsWith("H"))
                    count++;
                else if(Start.player3get.get(i).equals("SQ"))
                    count+=13;
            }
            Start.score.set(2, count);
            
        }
        if(playerno==4){
            int count=0;
            for(int i=0;i<Start.player4get.size();i++){
                if(Start.player4get.get(i).startsWith("H"))
                    count++;
                else if(Start.player4get.get(i).equals("SQ"))
                    count+=13;
            }
            Start.score.set(3, count);
            
        }
        if(Start.score.contains(26)){
            Start.score.add(Start.score.indexOf(26), 0);
            for(int i=0;i<4;i++){
                if(i!=Start.score.indexOf(26))
                    Start.score.add(i, 26);
            }
        }
        
        System.out.println("Score "+Start.score);
        
        
        
    }
}
