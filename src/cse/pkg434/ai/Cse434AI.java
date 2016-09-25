/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg434.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;


public class Cse434AI {

    /**
     * @param args the command line arguments
     */
    public static int level;
    public static void main(String[] args) {
        // TODO code application logic here
//        ArrayList<String> cards=new ArrayList<String>(Arrays.asList("H2","H3"));
//        cards.add("H4");
//        System.out.println("Which Level ???");
//        System.out.println("1) Beginner ,  2)Intermediate, 3)Hard ??   (only give the number)");
//        Scanner in=new Scanner(System.in);
//        level=in.nextInt();
        String rawinputOption = JOptionPane.showInputDialog(null, "1. Beginner ,  2.Intermediate, 3.Hard ??   (only give the number)", "Which Level ???", QUESTION_MESSAGE);
        level = Integer.parseInt(rawinputOption);
        
        ArrayList<String> cards=new ArrayList<String>();
        for(int i=2;i<11;i++){
            cards.add("H"+i);
        }
        cards.add("HJ");
        cards.add("HQ");
        cards.add("HK");
        cards.add("HA");
        
        for(int i=2;i<11;i++){
            cards.add("D"+i);
        }
        cards.add("DJ");
        cards.add("DQ");
        cards.add("DK");
        cards.add("DA");
        
        for(int i=2;i<11;i++){
            cards.add("C"+i);
        }
        cards.add("CJ");
        cards.add("CQ");
        cards.add("CK");
        cards.add("CA");
        
        for(int i=2;i<11;i++){
            cards.add("S"+i);
        }
        cards.add("SJ");
        cards.add("SQ");
        cards.add("SK");
        cards.add("SA");
        
        
        Shuffle sh=new Shuffle();
        sh.shufflecards(cards);
        
        CheckToStart check =new CheckToStart();
        int playerToStart = check.checkClubs();
        
        Start game=new Start();
        game.startGame(playerToStart);
        
        
    }
    
}
