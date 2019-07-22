/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomalphabet;

import javax.

     
/**
 *
 * @author Noah
 */
public class RandomAlphabet extends javax.swing.JFrame {

    RandomTranslator translator;
    /**
     * Creates new form RandomAlphabet
     */
    public RandomAlphabet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plainTextLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        plainTextBox = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        encodedTextBox = new javax.swing.JTextArea();
        encodedTextLabel = new javax.swing.JLabel();
        keyLabel = new javax.swing.JLabel();
        keyBox = new javax.swing.JTextField();
        generateAlphabetButton = new javax.swing.JButton();
        encodeButton = new javax.swing.JButton();
        decodeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Alphabet");
        setResizable(false);

        plainTextLabel.setText("Plain Text:");
        plainTextLabel.setName("plainTextLabel"); // NOI18N

        plainTextBox.setColumns(20);
        plainTextBox.setLineWrap(true);
        plainTextBox.setRows(5);
        plainTextBox.setName("plainTextBox"); // NOI18N
        jScrollPane1.setViewportView(plainTextBox);
        plainTextBox.getAccessibleContext().setAccessibleName("plainTextBox");

        encodedTextBox.setColumns(20);
        encodedTextBox.setLineWrap(true);
        encodedTextBox.setRows(5);
        jScrollPane2.setViewportView(encodedTextBox);
        encodedTextBox.getAccessibleContext().setAccessibleName("encodedTextBox");

        encodedTextLabel.setText("Encoded Text");
        encodedTextLabel.setName("encodedTextLabel"); // NOI18N

        keyLabel.setText("Key: ");
        keyLabel.setName("keyLabel"); // NOI18N

        keyBox.setToolTipText("");
        keyBox.setName("keyBox"); // NOI18N

        generateAlphabetButton.setText("Generate Alphabet");
        generateAlphabetButton.setActionCommand("");
        generateAlphabetButton.setName("generateAlphabetButton"); // NOI18N
        generateAlphabetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateAlphabetButtonMouseClicked(evt);
            }
        });

        encodeButton.setText("Encode");
        encodeButton.setName("encodeButton"); // NOI18N
        encodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encodeButtonMouseClicked(evt);
            }
        });

        decodeButton.setText("Decode");
        decodeButton.setActionCommand("");
        decodeButton.setName("decodeButton"); // NOI18N
        decodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decodeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encodedTextLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(plainTextLabel)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(keyLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(keyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(generateAlphabetButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(encodeButton)
                        .addGap(18, 18, 18)
                        .addComponent(decodeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyLabel)
                    .addComponent(keyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateAlphabetButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encodeButton)
                    .addComponent(decodeButton))
                .addGap(18, 18, 18)
                .addComponent(plainTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(encodedTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        plainTextLabel.getAccessibleContext().setAccessibleName("plainTextLabel");
        encodedTextLabel.getAccessibleContext().setAccessibleName("encodedTextLabel");
        keyLabel.getAccessibleContext().setAccessibleName("keyLabel");
        keyBox.getAccessibleContext().setAccessibleName("keyBox");
        generateAlphabetButton.getAccessibleContext().setAccessibleName("generateAlphabetButton");
        encodeButton.getAccessibleContext().setAccessibleName("encodeButton");
        decodeButton.getAccessibleContext().setAccessibleName("decodeButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encodeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encodeButtonMouseClicked
        // TODO add your handling code here:
        if(translator != null)
        {
            encodedTextBox.setText(translator.encodeText(plainTextBox.getText()));
        }
    }//GEN-LAST:event_encodeButtonMouseClicked

    private void decodeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decodeButtonMouseClicked
        // TODO add your handling code here:
        if(translator != null)
        {
            plainTextBox.setText(translator.decodeText(encodedTextBox.getText()));
        }
    }//GEN-LAST:event_decodeButtonMouseClicked

    private void generateAlphabetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateAlphabetButtonMouseClicked
        // TODO add your handling code here:
        translator = new RandomTranslator(keyBox.getText());
    }//GEN-LAST:event_generateAlphabetButtonMouseClicked

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
             UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RandomAlphabet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RandomAlphabet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RandomAlphabet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RandomAlphabet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandomAlphabet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decodeButton;
    private javax.swing.JButton encodeButton;
    private javax.swing.JTextArea encodedTextBox;
    private javax.swing.JLabel encodedTextLabel;
    private javax.swing.JButton generateAlphabetButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyBox;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JTextArea plainTextBox;
    private javax.swing.JLabel plainTextLabel;
    // End of variables declaration//GEN-END:variables
}
