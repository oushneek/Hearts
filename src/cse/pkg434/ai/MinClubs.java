/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;


public class MinClubs {
     public String minOfClubs(ArrayList<String> temp){
        String minOfC ="" ;
        int minCval=15;
        //ArrayList<String> temp=new ArrayList<>();
        for(int q=0;q<temp.size();q++){
            String str=temp.get(q);
          
            if(str.startsWith("C")){
                if(minCval>14 && str.endsWith("A")){
                    minCval=14;
                    minOfC=str;
                }
                else if(minCval>13 && str.endsWith("K")){
                    minCval=13;
                    minOfC=str;
                }
                else if(minCval>12 && str.endsWith("Q")){
                    minCval=12;
                    minOfC=str;
                }
                else if(minCval>11 && str.endsWith("J")){
                    minCval=11;
                    minOfC=str;
                }
                
                else if( (!str.endsWith("A"))  && (!str.endsWith("K"))  && (!str.endsWith("Q")) && (!str.endsWith("J"))){
                    String digits=str.substring(1, str.length());
                    //System.out.println("dgit "+digits );
                    int tempcardval=Integer.parseInt(digits);
                    if(minCval>tempcardval){
                        minOfC=str;
                       minCval=tempcardval;
                     }
                }     
            }
        }
            return minOfC;
    }

}
