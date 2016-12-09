
package smartalarm;

import Mp3Player.MP3Player;
import Mp3Player.MusicGui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;


public class Clock extends javax.swing.JFrame {

    //Default for the snoozetime
    private int snoozetime = 5;
    private int TimetogetReady = 0;
    private static String StartLocation = "", EndLocation = "Troy University, AL",CityState ="";
    private ArrayList<Alarm> Alarms = new ArrayList();
    private ArrayList<StudentClass> ClassList;
    private ArrayList<Thread> Threads= new ArrayList();
    MP3Player play = new MP3Player();
    boolean snoozeactive =false;
    Alarm SnoozeAlarm;
    int currentAlarm =-1;
    
    Schedule classSchedule = new Schedule();
    MusicGui  Music = new MusicGui();
    setRoute RouteSetup = new setRoute();
    Alarm a = new Alarm();
    setTimer timer = new setTimer();
    Snooze snoozeinstance = new Snooze();
    AlarmListView AList = new AlarmListView(Alarms);
    
    public Clock() {
        //Initialize the components in the desgin
        initComponents();
        
        //Create action listener for menu items when clicked/selected
        AlarmToneMenuItem.addActionListener(new AddAlarmToneListener());
        newAlarmMenuItem.addActionListener(new newAlarmListener());
        setRouteMenuItem.addActionListener(new setRouteListener());
        importScheduleMenuItem.addActionListener(new importScheduleListener());
        viewAlarmMenuItem.addActionListener(new viewAlarmListener());
        viewScheduleMenuItem.addActionListener(new viewScheduleListener());
        TimerMenuItem.addActionListener(new TimerListener());
        SnoozeMenuItem.addActionListener(new setSnoozeListener());
        SnoozeButton.addActionListener(new SnoozeListener());

        //Thread to always update the time and the day for the clock
        new Thread(){
            public void run(){
                while (true){
                    Calendar cal = new GregorianCalendar();
                    
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    int day = cal.get(Calendar.DAY_OF_WEEK);
                    if(hour == 0){
                        hour = 12;
                    }
                    String night_day;
                    
                    if(AM_PM == 0){
                        night_day = "AM";
                    }
                    else{
                        night_day = "PM";
                    }
                    String time = String.format("%02d",hour) + ":" + String.format("%02d",minute) + " " + night_day;
                    ClockLabel.setText(time);
                    String dayofweek ="";
                    switch(day){
                        case 1:
                            SundayLabel.setForeground(Color.green);
                            dayofweek = "Sunday";
                            break;
                        case 2:
                            MondayLabel.setForeground(Color.green);
                            dayofweek = "Monday";
                            break;
                        case 3:
                            TuesdayLabel.setForeground(Color.green);
                            dayofweek = "Tuesday";
                            break;
                        case 4:
                            WednesdayLabel.setForeground(Color.green);
                            dayofweek = "Wednesday";
                            break;
                        case 5:
                            ThursdayLabel.setForeground(Color.green);
                            dayofweek = "Thursday";
                            break;
                        case 6:
                            FridayLabel.setForeground(Color.green);
                            dayofweek = "Friday";
                            break;
                        case 7:
                            SaturdayLabel.setForeground(Color.green);
                            dayofweek = "Saturday";
                            break;
                    }
                    
                    for(int t=0; t< Alarms.size(); t++){
                        if(time.compareTo(Alarms.get(t).getTime())== 0){
                            if(Alarms.get(t).getEnabled()){
                                if(Alarms.get(t).getDays().size() > 1){
                                    for(int d=0; d< Alarms.get(t).getDays().size(); d++){
                                        if(dayofweek.compareTo(Alarms.get(t).getDays().get(d)) == 0){
                                            //sound alarm
                                        }
                                    }
                                }
                                else{
                                   if(dayofweek.compareTo(Alarms.get(t).getDays().get(0))==0){
                                       if(currentAlarm != t){
                                            play.Stop();
                                            play.Play("nothingatall.mp3");
                                            SnoozeAlarm = Alarms.get(t).getAlarm();
                                       }
                                       if(!Alarms.get(t).getRepeat()){
                                         Alarms.get(t).setenabled(false);
                                       }
                                       else{
                                           currentAlarm = t;
                                       }
                                   }
                                }
                            }
                            
                        }
                    }
                }
            }
        }.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ClockLabel = new javax.swing.JLabel();
        NextEventContentLabel = new javax.swing.JLabel();
        NextEventLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        MondayLabel = new javax.swing.JLabel();
        SundayLabel = new javax.swing.JLabel();
        TuesdayLabel = new javax.swing.JLabel();
        WednesdayLabel = new javax.swing.JLabel();
        ThursdayLabel = new javax.swing.JLabel();
        FridayLabel = new javax.swing.JLabel();
        SaturdayLabel = new javax.swing.JLabel();
        SnoozeButton = new javax.swing.JButton();
        DismissButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        AlarmToneMenuItem = new javax.swing.JMenuItem();
        TimerMenuItem = new javax.swing.JMenuItem();
        SnoozeMenuItem = new javax.swing.JMenuItem();
        ScheduleMenu = new javax.swing.JMenu();
        importScheduleMenuItem = new javax.swing.JMenuItem();
        viewScheduleMenuItem = new javax.swing.JMenuItem();
        RouteMenu = new javax.swing.JMenu();
        setRouteMenuItem = new javax.swing.JMenuItem();
        AlarmMenu = new javax.swing.JMenu();
        newAlarmMenuItem = new javax.swing.JMenuItem();
        viewAlarmMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Alarm");
        setBackground(new java.awt.Color(0, 0, 204));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ClockLabel.setFont(new java.awt.Font("DS-Digital", 0, 80)); // NOI18N
        ClockLabel.setForeground(new java.awt.Color(0, 0, 204));
        ClockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        NextEventLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NextEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        NextEventLabel.setText("Next Event:");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        MondayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MondayLabel.setForeground(new java.awt.Color(153, 153, 153));
        MondayLabel.setText("Monday");

        SundayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SundayLabel.setForeground(new java.awt.Color(153, 153, 153));
        SundayLabel.setText("Sunday");

        TuesdayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TuesdayLabel.setForeground(new java.awt.Color(153, 153, 153));
        TuesdayLabel.setText("Tuesday");

        WednesdayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WednesdayLabel.setForeground(new java.awt.Color(153, 153, 153));
        WednesdayLabel.setText("Wednesday");
        WednesdayLabel.setToolTipText("");

        ThursdayLabel.setBackground(new java.awt.Color(204, 204, 204));
        ThursdayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ThursdayLabel.setForeground(new java.awt.Color(153, 153, 153));
        ThursdayLabel.setText("Thursday");
        ThursdayLabel.setToolTipText("");

        FridayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FridayLabel.setForeground(new java.awt.Color(153, 153, 153));
        FridayLabel.setText("Friday");
        FridayLabel.setToolTipText("");

        SaturdayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaturdayLabel.setForeground(new java.awt.Color(153, 153, 153));
        SaturdayLabel.setText("Saturday");
        SaturdayLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SundayLabel)
                .addGap(18, 18, 18)
                .addComponent(MondayLabel)
                .addGap(18, 18, 18)
                .addComponent(TuesdayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(WednesdayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThursdayLabel)
                .addGap(18, 18, 18)
                .addComponent(FridayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaturdayLabel)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MondayLabel)
                    .addComponent(SundayLabel)
                    .addComponent(TuesdayLabel)
                    .addComponent(WednesdayLabel)
                    .addComponent(ThursdayLabel)
                    .addComponent(FridayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaturdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        SnoozeButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        SnoozeButton.setText("Snooze");
        SnoozeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SnoozeButton.setBorderPainted(false);

        DismissButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DismissButton.setText("Dismiss");
        DismissButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DismissButton.setBorderPainted(false);
        DismissButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DismissButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NextEventContentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(NextEventLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(ClockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(DismissButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(SnoozeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SnoozeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DismissButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ClockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NextEventLabel)
                        .addGap(18, 18, 18)
                        .addComponent(NextEventContentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jMenuBar.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FileMenu.setBackground(new java.awt.Color(0, 0, 0));
        FileMenu.setText("File");

        AlarmToneMenuItem.setText("Add Alarm Tone");
        FileMenu.add(AlarmToneMenuItem);

        TimerMenuItem.setText("Timer");
        FileMenu.add(TimerMenuItem);

        SnoozeMenuItem.setText("Set Snooze");
        FileMenu.add(SnoozeMenuItem);

        jMenuBar.add(FileMenu);

        ScheduleMenu.setText("Schedule");

        importScheduleMenuItem.setText("Import Schedule");
        ScheduleMenu.add(importScheduleMenuItem);

        viewScheduleMenuItem.setText("View Schedule");
        ScheduleMenu.add(viewScheduleMenuItem);

        jMenuBar.add(ScheduleMenu);

        RouteMenu.setText("Route");

        setRouteMenuItem.setText("Set Route");
        RouteMenu.add(setRouteMenuItem);

        jMenuBar.add(RouteMenu);

        AlarmMenu.setText("Alarm");

        newAlarmMenuItem.setText("New Alarm");
        AlarmMenu.add(newAlarmMenuItem);

        viewAlarmMenuItem.setText("View Alarm");
        AlarmMenu.add(viewAlarmMenuItem);

        jMenuBar.add(AlarmMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DismissButtonActionPerformed
        play.Stop();
    }//GEN-LAST:event_DismissButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clock().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AlarmMenu;
    private javax.swing.JMenuItem AlarmToneMenuItem;
    private javax.swing.JLabel ClockLabel;
    private javax.swing.JButton DismissButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel FridayLabel;
    private javax.swing.JLabel MondayLabel;
    private javax.swing.JLabel NextEventContentLabel;
    private javax.swing.JLabel NextEventLabel;
    private javax.swing.JMenu RouteMenu;
    private javax.swing.JLabel SaturdayLabel;
    private javax.swing.JMenu ScheduleMenu;
    private javax.swing.JButton SnoozeButton;
    private javax.swing.JMenuItem SnoozeMenuItem;
    private javax.swing.JLabel SundayLabel;
    private javax.swing.JLabel ThursdayLabel;
    private javax.swing.JMenuItem TimerMenuItem;
    private javax.swing.JLabel TuesdayLabel;
    private javax.swing.JLabel WednesdayLabel;
    private javax.swing.JMenuItem importScheduleMenuItem;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem newAlarmMenuItem;
    private javax.swing.JMenuItem setRouteMenuItem;
    private javax.swing.JMenuItem viewAlarmMenuItem;
    private javax.swing.JMenuItem viewScheduleMenuItem;
    // End of variables declaration//GEN-END:variables
private class AddAlarmToneListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!Music.isVisible()){
                Music.setVisible(true);
            }
            else{
                Music.toFront();
            }
            Music.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    Music.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                }); 
        }
    }
    
    private class importScheduleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(classSchedule.isVisible()){
                classSchedule.dispose();
                classSchedule.ScheduleDigest();
                classSchedule.setVisible(true);
            }
            else{
                classSchedule.ScheduleDigest();
                classSchedule.setVisible(true);
            }
            classSchedule.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    ClassList = (ArrayList<StudentClass>) classSchedule.getClassList().clone();
                    
                    classSchedule.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                }); 
        }
    }
    
    private class viewScheduleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(ClassList == null || ClassList.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please import schedule first!","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(classSchedule.isVisible()){
                    classSchedule.dispose();
                    classSchedule.ScheduleView(ClassList);
                    classSchedule.setVisible(true);
                }
                else{
                    classSchedule.ScheduleView(ClassList);
                    classSchedule.setVisible(true);
                }
            }
        }
    }
    
    private class setRouteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           //Create a setTimer object and set is to be visible
            if(!RouteSetup.isVisible()){
                RouteSetup.resetRoute();
                RouteSetup.setVisible(true);
            }
            else{
                RouteSetup.toFront();
            }
            //when the user closes the window it will hide
            //need to dispose the window when it is hidden
            //doing this not to close the whole application when close is clicked
            RouteSetup.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    StartLocation = RouteSetup.getStartLocation();
                    if(StartLocation != null && !StartLocation.isEmpty()){
                        String City = RouteSetup.getCityState();
                        if(City.compareToIgnoreCase(CityState)!=0){
                            if(!Threads.isEmpty()){
                                for(int tt=0; tt<Threads.size(); tt++){
                                    Threads.get(tt).interrupt();
                                }
                            }
                            Runnable weathermonitor = new Weather(City);
                            Thread threadW = new Thread(weathermonitor);
                            Threads.add(threadW);
                            threadW.start();
                            CityState = City;
                          
                            
                        }
                        ScheduledThreadPoolExecutor TravelPool = new ScheduledThreadPoolExecutor(2);
     
                        TravelPool.scheduleAtFixedRate(new TravelDuration(StartLocation), 0, 5, TimeUnit.SECONDS);

                    }
                    
                    TimetogetReady = RouteSetup.getTimetogetReady();
                    RouteSetup.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                }); 
            
        }
    }
    
    private class newAlarmListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                a.dispose();
                a = new Alarm();
                a.setVisible(true);
            
            a.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    Alarm newAlarm = a.getAlarm();
                    if(newAlarm.getAlarmName() != null){
                        Alarms.add(newAlarm);
                        System.out.println(newAlarm.getDays().toString());
                    }
                    a.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                });
        }
    }
    
    private class viewAlarmListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                AList.dispose();
                AList = new AlarmListView(Alarms);
                AList.setVisible(true);

            AList.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    AList.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                }); 
        }
    }
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Create a setTimer object and set is to be visible
            if(!timer.isVisible()){
                timer.Reset();
                timer.setVisible(true);
            }
            else{
                timer.toFront();
            }
            //when the user closes the window it will hide
            //need to dispose the window when it is hidden
            //doing this not to close the whole application when close is clicked
            timer.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    timer.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                }); 
               
        }
    }
       
   
    private class setSnoozeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
          if(!snoozeinstance.isVisible()){
             snoozeinstance.setVisible(true); 
          }
          else{
              snoozeinstance.toFront();
          }
          snoozeinstance.addComponentListener(new ComponentAdapter() {
                public void componentHidden(ComponentEvent e) 
                {
                    snoozetime = snoozeinstance.getsnoozetime();
                    snoozeinstance.dispose();
                }
                public void componentShown(ComponentEvent e) {
                    /* code run when component shown */
                }
                });
        }
    }
    private class SnoozeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //When the snooze is pressed we delay the alarm by snooze time.
            play.Stop();
            String time = SnoozeAlarm.getTime();
            String [] timespots = time.split(":");
            String [] strmins = timespots[1].split(" ");
            int mins = Integer.parseInt(strmins[0]);
            int newmins = mins + snoozetime;
            String newtime = "";
            if(newmins > 60 ){
                int m = newmins - 60;
                int h = Integer.parseInt(timespots[0]) + 1;
                newtime = String.format("%02d", h) + ":" + String.format("%02d",m) + " "+ strmins[1];
            }
            else{
                newtime = timespots[0] + ":" + String.format("%02d",newmins) + " "+ strmins[1];
            }
            
            Alarms.add(new Alarm(SnoozeAlarm.getAlarmName(),SnoozeAlarm.getDays(),newtime,SnoozeAlarm.getRepeat(),SnoozeAlarm.getTone()));
        }
    }
}
