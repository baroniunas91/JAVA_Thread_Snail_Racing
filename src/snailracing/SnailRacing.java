/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snailracing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edgaras
 */
public class SnailRacing {
    public static int trackLength = 300;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Snail s1 = new Snail("first");
        Snail s2 = new Snail("second");
        Snail s3 = new Snail("third");
        Snail s4 = new Snail("fourth");
        Snail s5 = new Snail("fifth");
        Snail s6 = new Snail("sixth");
        Snail s7 = new Snail("seventh");
        Snail s8 = new Snail("eight");
        
        List snails = new ArrayList();
        snails.add(s1);
        snails.add(s2);
        snails.add(s3);
        snails.add(s4);
        snails.add(s5);
        snails.add(s6);
        snails.add(s7);
        snails.add(s8);
        
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();
        s7.start();
        s8.start();
        
        try {
            s1.join();
            s2.join();
            s3.join();
            s4.join();
            s5.join();
            s6.join();
            s7.join();
            s8.join();
        } catch (InterruptedException ex) {
            System.out.println("Fault with waiting while all snails will finish");
        }
        
        for(int i=0; i<snails.size()-1; i++) {
            for(int j=i+1; j<snails.size(); j++) {
                Snail snail = (Snail)snails.get(i);
                Snail snail2 = (Snail)snails.get(j);
                if(snail.getDuration() > snail2.getDuration()) {
                    Snail temp = snail;
                    snail = (Snail)snails.set(i, snail2) ;
                    snail2 = (Snail)snails.set(j, temp);
                }
                else if(snail.getDuration() == snail2.getDuration()) {
                    if(snail.getDistance() < snail2.getDistance()) {
                        Snail temp2 = snail;
                        snail = (Snail)snails.set(i, snail2) ;
                        snail2 = (Snail)snails.set(j, temp2);
                    }
                }
            }
        }
        Snail winner = (Snail)snails.get(0);
        System.out.println("--------------------------------------------------");
        System.out.println("WINNER: " + winner.getSnailName() + " snail");
        System.out.println("--------------------------------------------------");
        for (int i=0; i<snails.size(); i++) {
            Snail snail = (Snail)snails.get(i);
            System.out.println(snail.getSnailName() + " snail, distance is " + snail.getDistance() + ", and duration is " + snail.getDuration() + " sec.");
        }
    }
}
