/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;


public class MinSpades {
    public String minOfSpades(ArrayList<String> temp){
        String minOfS ="" ;
        int minSval=15;
        //ArrayList<String> temp=new ArrayList<>();
        for(int q=0;q<temp.size();q++){
            String str=temp.get(q);
          
            if(str.startsWith("S")){
                if(minSval>14 && str.endsWith("A")){
                    minSval=14;
                    minOfS=str;
                }
                else if(minSval>13 && str.endsWith("K")){
                    minSval=13;
                    minOfS=str;
                }
                else if(minSval>12 && str.endsWith("Q")){
                    minSval=12;
                    minOfS=str;
                }
                else if(minSval>11 && str.endsWith("J")){
                    minSval=11;
                    minOfS=str;
                }
                
                else if( (!str.endsWith("A"))  && (!str.endsWith("K"))  && (!str.endsWith("Q")) && (!str.endsWith("J"))){
                    String digits=str.substring(1, str.length());
//                    //System.out.println("dgit "+digits );
                    int tempcardval=Integer.parseInt(digits);
                    if(minSval>tempcardval){
                        minOfS=str;
                       minSval=tempcardval;
                     }
                }     
            }
        }
            return minOfS;
    }

}
