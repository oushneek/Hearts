/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;


public class MinDiamonds {
    public String minOfDiamonds(ArrayList<String> temp){
        String minOfD ="" ;
        int minDval=15;
        //ArrayList<String> temp=new ArrayList<>();
        for(int q=0;q<temp.size();q++){
            String str=temp.get(q);
          
            if(str.startsWith("D")){
                if(minDval>14 && str.endsWith("A")){
                    minDval=14;
                    minOfD=str;
                }
                else if(minDval>13 && str.endsWith("K")){
                    minDval=13;
                    minOfD=str;
                }
                else if(minDval>12 && str.endsWith("Q")){
                    minDval=12;
                    minOfD=str;
                }
                else if(minDval>11 && str.endsWith("J")){
                    minDval=11;
                    minOfD=str;
                }
                
                else if( (!str.endsWith("A"))  && (!str.endsWith("K"))  && (!str.endsWith("Q")) && (!str.endsWith("J"))){
                    String digits=str.substring(1, str.length());
                    //System.out.println("dgit "+digits );
                    int tempcardval=Integer.parseInt(digits);
                    if(minDval>tempcardval){
                        minOfD=str;
                       minDval=tempcardval;
                     }
                }     
            }
        }
            return minOfD;
    }

}
