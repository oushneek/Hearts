/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;


public class MaxHearts {
    public String maxOfHearts(ArrayList<String> temp){
        String maxOfH ="" ;
        int maxHval=0;
        //ArrayList<String> temp=new ArrayList<>();
        for(int q=0;q<temp.size();q++){
            String str=temp.get(q);
            
            
            if(maxHval<14 && str.startsWith("H")){
                if(str.endsWith("A")){
                    maxHval=14;
                    maxOfH=str;
                }
                else if(maxHval<13 && str.endsWith("K")){
                    maxHval=13;
                    maxOfH=str;
                }
                else if(maxHval<12 && str.endsWith("Q")){
                    maxHval=12;
                    maxOfH=str;
                }
                else if(maxHval<11 && str.endsWith("J")){
                    maxHval=11;
                    maxOfH=str;
                }
                
                else if( (!str.endsWith("A"))  && (!str.endsWith("K"))  && (!str.endsWith("Q")) && (!str.endsWith("J"))){
                    String digits=str.substring(1, str.length());
//                    //System.out.println("dgit "+digits );
                    int tempcardval=Integer.parseInt(digits);
                    if(maxHval<tempcardval){
                        maxOfH=str;
                       maxHval=tempcardval;
                     }
                }     
            }
        }
            return maxOfH;
    }
}
