
package smartalarm;

import Mp3Player.MP3Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class setTimer extends javax.swing.JFrame {

    //Global variables used for the timer class
    private int hour;
    private int min;
    private int sec;
    private int totalmiliseconds;
    private Timer time;
    private MP3Player player = new MP3Player();
    
    public setTimer() {
        
        initComponents();
        //set this panel to false at beginning will be visible after timer is set
        jPanel1.setVisible(false);
        //action listener for all the buttons. what happens when buttons clicked
        SetButton.addActionListener(new SetTimerListener());
        StartTimerButton.addActionListener(new StartTimerListener());
        StopTimerButton.addActionListener(new StopTimerListener());
        //setting the timer interval to update every second
          time = new Timer(1000,new timeListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        HourBox = new javax.swing.JComboBox();
        MinBox = new javax.swing.JComboBox();
        SecBox = new javax.swing.JComboBox();
        TimerHourLabel = new javax.swing.JLabel();
        TimerMinuteLabel = new javax.swing.JLabel();
        TimerSecondLabel = new javax.swing.JLabel();
        SetButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        StartTimerButton = new javax.swing.JButton();
        StopTimerButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();

        setTitle("Set Timer");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(448, 300));
        setPreferredSize(new java.awt.Dimension(448, 300));

        JPanel.setBackground(new java.awt.Color(0, 0, 0));
        JPanel.setPreferredSize(new java.awt.Dimension(448, 249));

        HourBox.setBackground(new java.awt.Color(204, 204, 204));
        HourBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HourBox.setForeground(new java.awt.Color(0, 0, 204));
        HourBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        MinBox.setBackground(new java.awt.Color(204, 204, 204));
        MinBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MinBox.setForeground(new java.awt.Color(0, 0, 204));
        MinBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        SecBox.setBackground(new java.awt.Color(204, 204, 204));
        SecBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SecBox.setForeground(new java.awt.Color(51, 0, 204));
        SecBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        TimerHourLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimerHourLabel.setForeground(new java.awt.Color(0, 0, 204));
        TimerHourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerHourLabel.setText("Hour");

        TimerMinuteLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimerMinuteLabel.setForeground(new java.awt.Color(0, 0, 204));
        TimerMinuteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerMinuteLabel.setText("Minute");

        TimerSecondLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimerSecondLabel.setForeground(new java.awt.Color(0, 0, 204));
        TimerSecondLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerSecondLabel.setText("Second");

        SetButton.setBackground(new java.awt.Color(255, 255, 255));
        SetButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SetButton.setForeground(new java.awt.Color(0, 0, 204));
        SetButton.setText("Set");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(MinBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JPanelLayout.createSequentialGroup()
                            .addComponent(TimerHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(TimerMinuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(HourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TimerSecondLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(SecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SetButton)
                .addGap(47, 47, 47))
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimerHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimerMinuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimerSecondLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MinBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SecBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(SetButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 249));

        jLabel1.setFont(new java.awt.Font("DS-Digital", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        StartTimerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartalarm/images/1476496988_Go.png"))); // NOI18N
        StartTimerButton.setToolTipText("");

        StopTimerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartalarm/images/1476497110_player_stop.png"))); // NOI18N

        ResetButton.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(153, 153, 153));
        ResetButton.setText("Reset");
        ResetButton.setEnabled(false);
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(StartTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(StopTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResetButton)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StartTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StopTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetButton)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 433, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        Reset();
    }//GEN-LAST:event_ResetButtonActionPerformed
    
    public void Reset(){
       HourBox.setSelectedIndex(0);
        MinBox.setSelectedIndex(0);
        SecBox.setSelectedIndex(0);
        jPanel1.setVisible(false);
        JPanel.setVisible(true); 
    }
    
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
            java.util.logging.Logger.getLogger(setTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setTimer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox HourBox;
    private javax.swing.JPanel JPanel;
    private javax.swing.JComboBox MinBox;
    private javax.swing.JButton ResetButton;
    private javax.swing.JComboBox SecBox;
    private javax.swing.JButton SetButton;
    private javax.swing.JButton StartTimerButton;
    private javax.swing.JButton StopTimerButton;
    private javax.swing.JLabel TimerHourLabel;
    private javax.swing.JLabel TimerMinuteLabel;
    private javax.swing.JLabel TimerSecondLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private class timeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Calculate the time remaining for hour, minute, and second and update the label
            int hoursL = (int) (( totalmiliseconds/ 3600000) % 60);
            int minutesL = (int) ((totalmiliseconds / 60000) % 60);
            int secondsL = (int) (((totalmiliseconds) / 1000) % 60);
            
             jLabel1.setText(String.format("%02d", hoursL) + ":" + String.format("%02d",minutesL) + ":" + String.format("%02d",secondsL));
            
             //when the totalmilisecond reach 0 then stop the timer
            if(totalmiliseconds <= 0){
                player.Play("small-bell-ringing-01.mp3");
                time.stop();
                StartTimerButton.setEnabled(false);
                ResetButton.setForeground(Color.BLUE);
                ResetButton.setEnabled(true);
            }
            totalmiliseconds = totalmiliseconds - 1000;
        }
    }
     private class SetTimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //set the selected times for hour, minute, and second to set the timer
            hour = Integer.parseInt(HourBox.getSelectedItem().toString());
            min = Integer.parseInt(MinBox.getSelectedItem().toString());
            sec = Integer.parseInt(SecBox.getSelectedItem().toString());
            totalmiliseconds = (sec + (min * 60) + (hour *3600))*1000;
            jLabel1.setText(String.format("%02d", hour) + ":" + String.format("%02d",min) + ":" + String.format("%02d",sec));
            //hide the set timer panel and set the countdown panel to visible
            JPanel.setVisible(false);
            StartTimerButton.setEnabled(true);
            ResetButton.setForeground(Color.GRAY);
            ResetButton.setEnabled(false);
            jPanel1.setVisible(true);
            
            
        }
    }
    //start the timer when the play button is clicked
    private class StartTimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            time.start();
           
        }
    }
    //stop the timer when the stop button is clicked
    private class StopTimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            time.stop();
            player.Stop();
        }
    }
    
}
