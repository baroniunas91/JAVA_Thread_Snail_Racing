/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snailracing;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edgaras
 */
public class Snail extends Thread {

    private String name;
    private int distance = 0;
    private boolean run = true;
    private double startTime;
    private double endTime;
    private double duration;
    private int distancePoints = 30;
    
    public Snail(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Date d = new Date();
        startTime = d.getTime();
        
        for (int i = 0; this.run; i++) {
            if(distance >= SnailRacing.trackLength) {
                this.run = false;
                Date d1 = new Date();
                endTime = d1.getTime();
                duration = ((endTime - startTime)/1000);
                System.out.println(this.name + " snail - i'm done, my distance is " + this.distance + "cm and my time is: " + this.duration + " sec.");
//                System.out.println("------------------");
            }
            if(distance > distancePoints && distancePoints < 300) {
                distancePoints += 30;
                System.out.println(this.name + " snail crawled " + this.distance + "cm.");
            }
            go((int) (Math.random() * 5 + 1));
            try {
                Thread.sleep((int) (Math.random() * 8 + 2));
            } catch (InterruptedException ex) {
                System.out.println("Sleep fault");
            }
        }
    }

    public void go(int distance) {
        this.distance += distance;
    }

    public String getSnailName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }
    
}
