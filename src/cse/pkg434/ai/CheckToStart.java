/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import cse.pkg434.ai.*;

public class CheckToStart {
    public int checkClubs(){
        if(Shuffle.player1.contains("C2")){
            return 1;
            
        }
        else if(Shuffle.player2.contains("C2")){
            
            return 2;
        }
        else if(Shuffle.player3.contains("C2")){
            return 3;
        }
        else {
            return 4;
        }
    }
}
