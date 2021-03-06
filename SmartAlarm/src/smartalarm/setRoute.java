/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class setRoute extends javax.swing.JFrame {

    private String StartLocation="", CityState="";
    private int TimetogetReady = 0;
    private boolean closewindow = true;
    
    public setRoute() {
        initComponents();
        setRouteButton.addActionListener(new setListener());
        CancelRouteButton.addActionListener(new cancelListener());
        ReadyTimeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if ((caracter < '0') || (caracter > '9')) {
                    e.consume();
                }
            }
        });
        CityField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String caracter =String.valueOf(e.getKeyChar());
                if(!caracter.matches("[A-Za-z ]+"))
                {
                    e.consume();
                }
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        ReadyTimeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        StreetField = new javax.swing.JTextField();
        setRouteButton = new javax.swing.JButton();
        CancelRouteButton = new javax.swing.JButton();
        CityLabel = new javax.swing.JLabel();
        CityField = new javax.swing.JTextField();
        StreetLabel = new javax.swing.JLabel();
        StateLabel = new javax.swing.JLabel();
        StateField = new javax.swing.JTextField();

        setTitle("Set Route");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Time to get Ready in minutes:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Set start location address");

        setRouteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setRouteButton.setText("Set");
        setRouteButton.setToolTipText("");

        CancelRouteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CancelRouteButton.setText("Cancel");
        CancelRouteButton.setToolTipText("");

        CityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CityLabel.setForeground(new java.awt.Color(255, 255, 255));
        CityLabel.setText("City:");
        CityLabel.setToolTipText("");

        StreetLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StreetLabel.setForeground(new java.awt.Color(255, 255, 255));
        StreetLabel.setText("Street:");
        StreetLabel.setToolTipText("");

        StateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StateLabel.setForeground(new java.awt.Color(255, 255, 255));
        StateLabel.setText("State Abbreviation:");
        StateLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(ReadyTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(setRouteButton)
                            .addGap(18, 18, 18)
                            .addComponent(CancelRouteButton)
                            .addGap(38, 38, 38)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StateLabel)
                    .addComponent(CityLabel)
                    .addComponent(StreetLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StreetField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CityField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StateField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ReadyTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StreetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StreetLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CityLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StateLabel))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setRouteButton)
                    .addComponent(CancelRouteButton))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(setRoute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setRoute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setRoute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setRoute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setRoute().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelRouteButton;
    private javax.swing.JTextField CityField;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JTextField ReadyTimeField;
    private javax.swing.JTextField StateField;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JTextField StreetField;
    private javax.swing.JLabel StreetLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton setRouteButton;
    // End of variables declaration//GEN-END:variables

    public void resetRoute(){
        CityField.setText("");
        StateField.setText("");
        StreetField.setText("");
        ReadyTimeField.setText("");
    }
    private class setListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String street = StreetField.getText();
            String city = CityField.getText();
            String state = StateField.getText();
           if(street.isEmpty() || street == null){
               JOptionPane.showMessageDialog(null,"Please set a street location!", "Location Error",JOptionPane.ERROR_MESSAGE);
               closewindow = false;
            }      
           else if(city.isEmpty() || city == null){
               JOptionPane.showMessageDialog(null,"Please set a city!", "Location Error",JOptionPane.ERROR_MESSAGE);
               closewindow = false;
            }
           else if(state.isEmpty() || state == null || state.length() >2){
               JOptionPane.showMessageDialog(null,"Please set a state or state abberviation invalid!", "Location Error",JOptionPane.ERROR_MESSAGE);
               closewindow = false;
            }
           else{
               closewindow = true;
           }
           String Ready = ReadyTimeField.getText();
            if(Ready.isEmpty()|| Ready == null){
                Ready = "0";
            }
            TimetogetReady = Integer.parseInt(Ready);
            StartLocation = street + " " + city + ", " + state;
            CityState = city + ", " + state;
            if(closewindow){
                setVisible(false);
            }
        }
        
    }
    
    private class cancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            resetRoute();
            TimetogetReady = 0;
            StartLocation = "";
            CityState = "";
           setVisible(false);
        }
        
    }
    
    public int getTimetogetReady(){
        return TimetogetReady;
    }
    public String getStartLocation(){
        return StartLocation;
    }
    public String getCityState(){
        return CityState;
    }
}
