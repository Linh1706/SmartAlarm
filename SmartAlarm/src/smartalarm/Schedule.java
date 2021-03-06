/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartalarm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Property;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author Melissa
 */
public class Schedule extends javax.swing.JFrame {

    /**
     * Creates new form Schedule
     */
    private String schedulePath;
    private ArrayList<StudentClass> Classes;
    
    //tags used to parse the calendar information
    enum Prop{
        DTEND,
        DTSTART,
        LOCATION,
        SUMMARY
    }
    
    public Schedule() {
        initComponents();
        Classes = new ArrayList();
       // ViewPanel.setVisible(false);
    }
    
    /*public Schedule(ArrayList<StudentClass> List){
        initComponents();
        Classes = new ArrayList();
        ImportPanel.setVisible(false);
        ClassList.setListData(ConvertclassForView(List));
    }*/
    public void ScheduleDigest(){
        ViewPanel.setVisible(false);
        ImportPanel.setVisible(true);
    }
    public void ScheduleView(ArrayList<StudentClass> List){
        ImportPanel.setVisible(false);
        ViewPanel.setVisible(true);
        ClassList.setListData(ConvertclassForView(List));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportPanel = new javax.swing.JPanel();
        ImportLabel = new javax.swing.JLabel();
        SchedulePathTextField = new javax.swing.JTextField();
        BrowseButton = new javax.swing.JButton();
        ImportButton = new javax.swing.JButton();
        ViewPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassList = new javax.swing.JList();
        DoneButton = new javax.swing.JButton();

        setTitle("Schedule");
        setPreferredSize(new java.awt.Dimension(700, 300));

        ImportPanel.setBackground(new java.awt.Color(0, 0, 0));

        ImportLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImportLabel.setForeground(new java.awt.Color(255, 255, 255));
        ImportLabel.setText("Import schedule: ");

        SchedulePathTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BrowseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BrowseButton.setText("Browse");
        BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseButtonActionPerformed(evt);
            }
        });

        ImportButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImportButton.setText("Import");
        ImportButton.setEnabled(false);
        ImportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImportPanelLayout = new javax.swing.GroupLayout(ImportPanel);
        ImportPanel.setLayout(ImportPanelLayout);
        ImportPanelLayout.setHorizontalGroup(
            ImportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ImportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SchedulePathTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrowseButton)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImportPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImportButton)
                .addGap(63, 63, 63))
        );
        ImportPanelLayout.setVerticalGroup(
            ImportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(ImportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImportLabel)
                    .addComponent(SchedulePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrowseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(ImportButton)
                .addGap(77, 77, 77))
        );

        ViewPanel.setBackground(new java.awt.Color(0, 0, 0));
        ViewPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        ClassList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(ClassList);

        DoneButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DoneButton)
                .addGap(129, 129, 129))
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(DoneButton)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseButtonActionPerformed
        JFileChooser chooser= new JFileChooser();
        //only ics files will make the import button visible
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ical file","ics");
        chooser.setFileFilter(filter);
        int choice = chooser.showOpenDialog(null);
        
        if (choice != JFileChooser.APPROVE_OPTION) return;

        File chosenFile = chooser.getSelectedFile();
        //get the file schedule path
        SchedulePathTextField.setText(chosenFile.getAbsolutePath());
        schedulePath = chosenFile.getAbsolutePath();
         String filename = chosenFile.getName();
        String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
        if(!extension.equals("ics")){
            JOptionPane.showMessageDialog(ImportPanel,"Wrong File Format!","Error",JOptionPane.ERROR_MESSAGE);
            ImportButton.setEnabled(false);
        }
        else{
            ImportButton.setEnabled(true);
        }
    }//GEN-LAST:event_BrowseButtonActionPerformed

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        setVisible(false);
        ImportButton.setEnabled(false);
        SchedulePathTextField.setText("");
        FileInputStream fin = null;
        String classname = null, start = null, end = null, location = null;
        int day = -1;
        try {
            fin = new FileInputStream(schedulePath);
            CalendarBuilder builder = new CalendarBuilder();
            Calendar calendar = builder.build(fin);
            //parsing the calendar information
            for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
                Component component = (Component) i.next();
                //System.out.println("Component [" + component.getName() + "]");

                for (Iterator j = component.getProperties().iterator(); j.hasNext();) {
                    Property property = (Property) j.next();
                    //System.out.println("Property [" + property.getName() + ", " + property.getValue() + "]");
                    try{
                        Prop props = Prop.valueOf(property.getName());
                        switch(props){
                            case DTEND:
                                try {
                                    DateFormat utcFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
                                    utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                    Date date = utcFormat.parse(property.getValue());
                                    end = date.getHours() + ":" + date.getMinutes();
                                    day = date.getDay();
                                } catch (ParseException ex) {
                                    Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                             case DTSTART:
                                try {
                                    DateFormat utcFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
                                    utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                    Date date = utcFormat.parse(property.getValue());
                                    start = date.getHours() + ":" + date.getMinutes();
                                } catch (ParseException ex) {
                                    Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                             case SUMMARY:
                                 classname = property.getValue();
                                 break;
                             case LOCATION:
                                 location = property.getValue();
                                 break;
                        }
                    }catch(IllegalArgumentException e){
                        //info not needed
                    }
                }
                //add the class to the class list 
                StudentClass student = new StudentClass(classname, location, day, start, end);
                if(Classes.isEmpty()){
                    Classes.add(student);
                }
                else{
                    if(!ClassAdded(student)){
                            Classes.add(student);
                    }
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_DoneButtonActionPerformed
    private String[] ConvertclassForView(ArrayList<StudentClass> classes){
        //if(classes.isEmpty())System.out.println("classes empty");
         String [] classtrings = new String[classes.size()];
        for(int i=0; i< classes.size(); i++){
            StudentClass sc = classes.get(i);
            String dayofweek = getDayString(sc.getday());
            String strclass = sc.getname() + " Start:" + sc.getstarttime() + " End:" + sc.getendtime() + " " 
                    + sc.getlocation() + " " + dayofweek;
            classtrings[i]=strclass;
        }
        return classtrings;
    }
    
    public String getDayString(int day){
        String daystr = null;
        switch(day){
                        case 0:
                            daystr = "Sunday";
                            break;
                        case 1:
                            daystr = "Monday";
                            break;
                        case 2:
                            daystr = "Tuesday";
                            break;
                        case 3:
                            daystr = "Wednesday";
                            break;
                        case 4:
                            daystr = "Thursday";
                            break;
                        case 5:
                            daystr = "Friday";
                            break;
                        case 6:
                            daystr = "Saturday";
                            break;
        }
        return daystr;
    } 
    //method to see if two classes are the same class
    private boolean classmatch(StudentClass A, StudentClass B){
        if(A.getname().compareToIgnoreCase(B.getname())==0 &&
                A.getday() == B.getday()){
            return true;
        }
        else{
            return false;
        }
    }
    //method to see if the class is already added to the class list
    private boolean ClassAdded(StudentClass A){
        for(int t =0; t< Classes.size(); t++){
            if(classmatch(A, Classes.get(t))){
                return true;
            }
            else{
                
            }
        }
        return false;
    }
    public ArrayList<StudentClass> getClassList(){
        return Classes;
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
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseButton;
    private javax.swing.JList ClassList;
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton ImportButton;
    private javax.swing.JLabel ImportLabel;
    private javax.swing.JPanel ImportPanel;
    private javax.swing.JTextField SchedulePathTextField;
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
