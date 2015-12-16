/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package time.tracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Noah
 */
public class TimeTracker extends javax.swing.JFrame {
    static ReadByteFile reader;
    static WriteByteFile writer;
    static ArrayList<Punch> punches;
    static long currentRemaining;
    static String formattedRemaining;
    static Thread remainingThread;
    static RemainingCounter counter;
    /**
     * Creates new form TimeTracker
     */
    public TimeTracker() {
        initComponents();
        reader = new ReadByteFile("punches.png");
        writer = new WriteByteFile("punches.png");
        counter = new RemainingCounter();
        readDataFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeRemainingLabel = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        punchInOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        timeRemainingLabel.setText("Time Remaining:");
        timeRemainingLabel.setName("timeRemainingLabel"); // NOI18N

        time.setText("3:00");
        time.setName("time"); // NOI18N

        punchInOut.setText("Punch In");
        punchInOut.setActionCommand("punchInOut");
        punchInOut.setName("punchInOut"); // NOI18N
        punchInOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punchInOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeRemainingLabel)
                        .addGap(18, 18, 18)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(punchInOut)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeRemainingLabel)
                    .addComponent(time))
                .addGap(33, 33, 33)
                .addComponent(punchInOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timeRemainingLabel.getAccessibleContext().setAccessibleName("timeRemainingLabel");
        time.getAccessibleContext().setAccessibleName("time");
        punchInOut.getAccessibleContext().setAccessibleName("punchInOut");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void punchInOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punchInOutActionPerformed
        
        
        String direction;
        if(punches.isEmpty()){
            direction = "In";
            time.setText("03:00:00");
            formattedRemaining = "03:00:00";
            currentRemaining = 10800000;
        }else{ 
            if(punches.get(punches.size()-1).direction.equalsIgnoreCase("out")){
                Calendar punchCal = Calendar.getInstance();
                punchCal.setTimeInMillis(punches.get(punches.size()-1).time);
                Calendar cal = Calendar.getInstance();
                if(cal.get(Calendar.YEAR) == punchCal.get(Calendar.YEAR) &&
                  cal.get(Calendar.DAY_OF_YEAR) == punchCal.get(Calendar.DAY_OF_YEAR)){
                    direction = "In";
                    currentRemaining = punches.get(punches.size()-1).remaining;
                    format();
                    time.setText(punches.get(punches.size()-1).formattedRemaining);
                }else{
                    direction = "In";
                    time.setText("03:00:00");
                    currentRemaining = 10800000;
                    formattedRemaining = "03:00:00";
                }
            } else {
                direction = "Out";
                calculateRemaining();
            }
            
        }
        
        Calendar cal = Calendar.getInstance();
        long time = cal.getTimeInMillis();
        
        Punch punch = new Punch(direction,time,currentRemaining,currentRemaining < 0);
        punches.add(punch);
        try{
            writer.writeToFile(punches);
        }catch(IOException e){
            e.printStackTrace();
        }
        
         if(punchInOut.getText().equalsIgnoreCase("Punch In")){
            punchInOut.setText("Punch Out");
            remainingThread = new Thread(counter);
            remainingThread.start();
        }else{
            punchInOut.setText("Punch In");
            counter.stop();
        }
    }//GEN-LAST:event_punchInOutActionPerformed

    
    private void readDataFile(){
        try{
            punches = reader.openFile();
        }catch(IOException e){
            punches = new ArrayList<>();
            
        }
        
        if(punches.isEmpty()){
            time.setText("03:00:00");
            currentRemaining = 10800000;
            formattedRemaining = "03:00:00";
        }else{
            if(punches.get(punches.size()-1).direction.equalsIgnoreCase("out")){
                Calendar punchCal = Calendar.getInstance();
                punchCal.setTimeInMillis(punches.get(punches.size()-1).time);
                Calendar cal = Calendar.getInstance();
                if(cal.get(Calendar.YEAR) == punchCal.get(Calendar.YEAR) &&
                  cal.get(Calendar.DAY_OF_YEAR) == punchCal.get(Calendar.DAY_OF_YEAR)){
                    time.setText(punches.get(punches.size()-1).formattedRemaining);
                }else{
                    time.setText("03:00:00");
                    currentRemaining = 10800000;
                    formattedRemaining = "03:00:00";
                }
            }else{
                Calendar punchCal = Calendar.getInstance();
                punchCal.setTimeInMillis(punches.get(punches.size()-1).time);
                Calendar cal = Calendar.getInstance();
            
                if(cal.get(Calendar.YEAR) == punchCal.get(Calendar.YEAR) &&
                  cal.get(Calendar.DAY_OF_YEAR) == punchCal.get(Calendar.DAY_OF_YEAR)){
                    punchInOut.setText("Punch Out");
                    calculateRemaining();
                    remainingThread = new Thread(counter);
                    remainingThread.start();
                }else{
                    
                    long time = cal.getTimeInMillis();
                    
                    long change = time -  punches.get(punches.size()-1).time;
                    long remaining = punches.get(punches.size()-1).remaining - change;
                   
                    Punch punch = new Punch("Out",time,10800000,remaining < 0);
                    punches.add(punch);
                    try{
                        writer.writeToFile(punches);
                    }catch(IOException e){
                     e.printStackTrace();
                    }
                    
                    this.time.setText("03:00:00");
                    currentRemaining = 10800000;
                    formattedRemaining = "03:00:00";
                }
            }
        }
    }
    
    
    
    public static void calculateRemaining(){
        Calendar cal = Calendar.getInstance();
        long change = cal.getTimeInMillis() -  punches.get(punches.size()-1).time;
        currentRemaining = punches.get(punches.size()-1).remaining - change;
        format();
        time.setText(formattedRemaining);
    }
    
    private static void format(){
       TimeMath timeMath = new TimeMath();
       timeMath.set(TimeMath.SECOND, (int) (currentRemaining/1000));
       formattedRemaining = String.format("%02d",timeMath.get(TimeMath.HOUR)) + ":" + String.format("%02d",timeMath.get(TimeMath.MINUTE))+ ":" + String.format("%02d",timeMath.get(TimeMath.SECOND));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimeTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton punchInOut;
    private static javax.swing.JLabel time;
    private javax.swing.JLabel timeRemainingLabel;
    // End of variables declaration//GEN-END:variables
}
