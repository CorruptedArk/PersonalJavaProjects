/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package looptest;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author Noah
 */

class ClockListener implements ActionListener {
    JLabel timeField;
    
    public ClockListener(JLabel timeField){
        this.timeField = timeField;
    }
    
    public void actionPerformed(ActionEvent e) {
    		//... Whenever this is called, get the current time and
    		//    display it in the textfield.
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
            timeField.setText("" + h + ":" + m + ":" + s);
            //... The following is an easier way to format the time,
            //    but requires knowing how to use the format method.
            //_timeField.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    	}
    }