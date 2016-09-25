/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;


public class MinHearts {
    public String minOfHearts(ArrayList<String> temp){
        String minOfH ="" ;
        int minHval=15;
        //ArrayList<String> temp=new ArrayList<>();
        for(int q=0;q<temp.size();q++){
            String str=temp.get(q);
          
            if(str.startsWith("H")){
                if(minHval>14 && str.endsWith("A")){
                    minHval=14;
                    minOfH=str;
                }
                else if(minHval>13 && str.endsWith("K")){
                    minHval=13;
                    minOfH=str;
                }
                else if(minHval>12 && str.endsWith("Q")){
                    minHval=12;
                    minOfH=str;
                }
                else if(minHval>11 && str.endsWith("J")){
                    minHval=11;
                    minOfH=str;
                }
                
                else if( (!str.endsWith("A"))  && (!str.endsWith("K"))  && (!str.endsWith("Q")) && (!str.endsWith("J"))){
                    String digits=str.substring(1, str.length());
//                    //System.out.println("dgit "+digits );
                    int tempcardval=Integer.parseInt(digits);
                    if(minHval>tempcardval){
                        minOfH=str;
                       minHval=tempcardval;
                     }
                }     
            }
        }
            return minOfH;
    }

}
