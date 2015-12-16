/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package time.tracker;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Noah
 */
public class RemainingCounter implements Runnable { 

    boolean running;
    
    @Override
    public void run() {
        running = true;
        while(running){
            TimeTracker.calculateRemaining();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RemainingCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stop(){
        running = false;
    }
}
