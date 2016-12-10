package smartalarm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Alarm extends javax.swing.JFrame {

    //Attributes for Alarm class
    private String AlarmName;
    private boolean Repeat;
    private ArrayList<String> Days;
    private String Tone;
    private String time;
    private boolean enabled;
    private String Note;
    
    enum daysofweek{
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }
    
    public Alarm() {
        initComponents();
        SundayToggleButton.addActionListener(new ColorchangeListener(SundayToggleButton,"Sunday"));
        MondayToggleButton.addActionListener(new ColorchangeListener(MondayToggleButton,"Monday"));
        TuesdayToggleButton.addActionListener(new ColorchangeListener(TuesdayToggleButton,"Tuesday"));
        WednesdayToggleButton.addActionListener(new ColorchangeListener(WednesdayToggleButton,"Wednesday"));
        ThursdayToggleButton.addActionListener(new ColorchangeListener(ThursdayToggleButton,"Thursday"));
        FridayToggleButton.addActionListener(new ColorchangeListener(FridayToggleButton,"Friday"));
        SaturdayToggleButton.addActionListener(new ColorchangeListener(SaturdayToggleButton,"Saturday"));
        Days = new ArrayList();
    }
    
    public Alarm(String name, ArrayList<String>Day, String time, boolean R, String Tone, String note){
        this.AlarmName = name;
        Days = new ArrayList(Day);
        this.time = time;
        this.Repeat = R;
        this.Tone = Tone;
        this.enabled =true;
        this.Note = note;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HourBox = new javax.swing.JComboBox();
        MinBox = new javax.swing.JComboBox();
        ColonLabel = new javax.swing.JLabel();
        AM_PMBox = new javax.swing.JComboBox();
        RepeatCheckBox = new javax.swing.JCheckBox();
        NameLabel = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        SundayToggleButton = new javax.swing.JToggleButton();
        MondayToggleButton = new javax.swing.JToggleButton();
        WednesdayToggleButton = new javax.swing.JToggleButton();
        TuesdayToggleButton = new javax.swing.JToggleButton();
        ThursdayToggleButton = new javax.swing.JToggleButton();
        FridayToggleButton = new javax.swing.JToggleButton();
        SaturdayToggleButton = new javax.swing.JToggleButton();
        AlarmToneBox = new javax.swing.JComboBox();
        AlarmToneLabel = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();

        setTitle("Add New Alarm");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        HourBox.setBackground(new java.awt.Color(153, 153, 153));
        HourBox.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        HourBox.setForeground(new java.awt.Color(0, 0, 153));
        HourBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        MinBox.setBackground(new java.awt.Color(153, 153, 153));
        MinBox.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        MinBox.setForeground(new java.awt.Color(0, 0, 153));
        MinBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        ColonLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        ColonLabel.setForeground(new java.awt.Color(0, 0, 153));
        ColonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ColonLabel.setText(":");

        AM_PMBox.setBackground(new java.awt.Color(153, 153, 153));
        AM_PMBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AM_PMBox.setForeground(new java.awt.Color(0, 0, 153));
        AM_PMBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
        AM_PMBox.setToolTipText("");

        RepeatCheckBox.setBackground(new java.awt.Color(0, 0, 0));
        RepeatCheckBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RepeatCheckBox.setForeground(new java.awt.Color(0, 0, 153));
        RepeatCheckBox.setText("Repeat");
        RepeatCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepeatCheckBoxActionPerformed(evt);
            }
        });

        NameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(0, 0, 153));
        NameLabel.setText("Alarm Name: ");
        NameLabel.setToolTipText("");

        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SundayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        SundayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SundayToggleButton.setText("S");

        MondayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        MondayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MondayToggleButton.setText("M");

        WednesdayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        WednesdayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        WednesdayToggleButton.setText("W");

        TuesdayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        TuesdayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TuesdayToggleButton.setText("T");

        ThursdayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        ThursdayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ThursdayToggleButton.setText("T");

        FridayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        FridayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FridayToggleButton.setText("F");

        SaturdayToggleButton.setBackground(new java.awt.Color(255, 255, 255));
        SaturdayToggleButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SaturdayToggleButton.setText("S");

        AlarmToneBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AlarmToneBox.setMaximumRowCount(30);
        AlarmToneBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nothingatall.mp3" }));

        AlarmToneLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AlarmToneLabel.setForeground(new java.awt.Color(0, 0, 153));
        AlarmToneLabel.setText("Alarm Tone:");

        SaveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SaveButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(RepeatCheckBox)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(NameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(AlarmToneLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(AlarmToneBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(SundayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MondayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TuesdayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(WednesdayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ThursdayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FridayToggleButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(HourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ColonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(MinBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AM_PMBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SaturdayToggleButton)))))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ColonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(AM_PMBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(RepeatCheckBox)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SundayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MondayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TuesdayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WednesdayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ThursdayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FridayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaturdayToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlarmToneLabel)
                    .addComponent(AlarmToneBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RepeatCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepeatCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RepeatCheckBoxActionPerformed

    //method called when save button is clicked
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(Days.isEmpty()){
             JOptionPane.showMessageDialog(jPanel1,"Please select a day!","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(Days.size()>1){
                JOptionPane.showMessageDialog(jPanel1,"Repeat auto selected because more than one day selected!","Warning",JOptionPane.WARNING_MESSAGE);
                Repeat = true;
            }
            else{
               Repeat = RepeatCheckBox.isSelected(); 
            }
            AlarmName = NameTextField.getText();
            if(AlarmName.isEmpty() || AlarmName == null) AlarmName = "Alarm"; 
            enabled = true;
            if(AlarmToneBox.getSelectedItem() != null){
                Tone = AlarmToneBox.getSelectedItem().toString();
            }
            else{
                Tone = "DefaultTone";
            }
            if(Tone.isEmpty() || Tone == null) Tone = "DefaultTone";
            Note = "Original time";
            time = String.format("%02d",Integer.parseInt(HourBox.getSelectedItem().toString())) + ":" + String.format("%02d",Integer.parseInt(MinBox.getSelectedItem().toString())) + " " + AM_PMBox.getSelectedItem().toString();
            setVisible(false);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed
    
    public void defaultvalues(){
        NameTextField.setText("");
        RepeatCheckBox.setSelected(false);
        AlarmToneBox.setSelectedIndex(0);
        HourBox.setSelectedIndex(0);
        MinBox.setSelectedIndex(0);
        AM_PMBox.setSelectedIndex(0);
        SundayToggleButton.setSelected(false);
        SundayToggleButton.setForeground(Color.BLACK);
        MondayToggleButton.setSelected(false);
        MondayToggleButton.setForeground(Color.BLACK);
        SaturdayToggleButton.setSelected(false);
        SaturdayToggleButton.setForeground(Color.BLACK);
        TuesdayToggleButton.setSelected(false);
        TuesdayToggleButton.setForeground(Color.BLACK);
        WednesdayToggleButton.setSelected(false);
        WednesdayToggleButton.setForeground(Color.BLACK);
        ThursdayToggleButton.setSelected(false);
        ThursdayToggleButton.setForeground(Color.BLACK);
        FridayToggleButton.setSelected(false);
        FridayToggleButton.setForeground(Color.BLACK);
        Days.clear();
    }
    //method called when toggle button is clicked
    /*
     * if selected the text will be green and added to the days array.
     * if deselected the color will be black and deleted from the days array.
     */
    private class ColorchangeListener implements ActionListener{
           JToggleButton Button;
           String Day;
           
        ColorchangeListener(JToggleButton B, String D){
            this.Button = B; 
            this.Day = D;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           if (Button.isSelected()){
                Button.setForeground(Color.GREEN);
                Days.add(Day);
            } else {
                Button.setForeground(Color.BLACK);
                for(int i =0; i<Days.size(); i++){
                    if(Day.compareTo(Days.get(i)) == 0){
                        Days.remove(i);
                    }
                }
            }
        }
        
    }
    public String getTime(){
        return time;
    }
    public boolean getEnabled(){
        return enabled;
    }
    public void setenabled(boolean value){
        this.enabled = value;
    }
    public String getTone(){
        return Tone;
    }
    public boolean getRepeat(){
        return Repeat;
    } 
    public String getAlarmName(){
        return AlarmName;
    }
    public String getNote(){
        return Note;
    }
    public ArrayList<String> getDays(){
        return Days;
    }
    public Alarm getAlarm(){
        return this;
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
            java.util.logging.Logger.getLogger(Alarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alarm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AM_PMBox;
    private javax.swing.JComboBox AlarmToneBox;
    private javax.swing.JLabel AlarmToneLabel;
    private javax.swing.JLabel ColonLabel;
    private javax.swing.JToggleButton FridayToggleButton;
    private javax.swing.JComboBox HourBox;
    private javax.swing.JComboBox MinBox;
    private javax.swing.JToggleButton MondayToggleButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JCheckBox RepeatCheckBox;
    private javax.swing.JToggleButton SaturdayToggleButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JToggleButton SundayToggleButton;
    private javax.swing.JToggleButton ThursdayToggleButton;
    private javax.swing.JToggleButton TuesdayToggleButton;
    private javax.swing.JToggleButton WednesdayToggleButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
